package com.wgh.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;


import com.wgh.dao.IDeptInfoDao;
import com.wgh.dao.IUserInfoDao;
import com.wgh.modle.DeptInfo;

@Controller
public class DeptOperationController extends MultiActionController {
	@Resource
	IUserInfoDao userInfoDao;//�û�
	@Resource
	IDeptInfoDao deptInfoDao;//����
	
	/**
	 * ���»�����Ӳ���
	 */
	@RequestMapping(value="/deptOperation", params = "method=insertOrUpdateDept")
	public ModelAndView insertOrUpdateDept(HttpServletRequest request,HttpServletResponse response){
		DeptInfo deptInfo=new DeptInfo();
		deptInfo.setName(request.getParameter("name"));//��ȡ��������
		deptInfo.setCreateDate(request.getParameter("createDate"));//��ȡ���Ŵ���ʱ��
		deptInfo.setNumber(Integer.valueOf(request .getParameter("number")));//��ȡ���ű��
		deptInfo.setRemark(request.getParameter("remark"));//��ȡ���Ž���
		
		if(deptInfo.getNumber()==0){
			deptInfoDao.insert(deptInfo);
		}else{
			deptInfoDao.update(deptInfo);
		}
		return showDept(request,response);
	}
	/**
	 * �������û�ˣ���ɾ�����ţ�����ɾ��
	 */
	@RequestMapping(value="/deptOperation", params = "method=deleteDept")
	public ModelAndView deleteDept(HttpServletRequest request,HttpServletResponse response) 
			throws Exception{
		Integer number=Integer.valueOf(request .getParameter("number"));//��ȡ���ű��
		boolean bool=(boolean) userInfoDao.findById(number);
		
		String message="";//��ʾ��Ϣ
		if(bool){//������Ա��
			deptInfoDao.delete(number);
		}else{
			message="����ɾ����Ա���Ĳ���";
		}
		PrintWriter out=response.getWriter();
		out.print("alert('"+message+"');");
		return showDeptFirst(request, response);
		
		
	}
	/**
	 * ���ز�����ҳ����ͼ
	 */
	public ModelAndView showDeptFirst(HttpServletRequest request,HttpServletResponse response){
		return new ModelAndView("dept/showDeptFirst");
	}
	/**
	 * �Զ���showDept��ͼ
	 */
	@RequestMapping(value="/deptOperation", params = "method=showDept")
	public ModelAndView showDept(HttpServletRequest request,HttpServletResponse response){
		List list=deptInfoDao.findAll();//��ȡ����������Ϣ
		return new ModelAndView("dept/insertOrUpdateDept", "list", list);
		
	}
	/**
	 * ���ղ��ű�Ų�ѯ������Ϣ
	 * @param request
	 * @param response
	 * @return ���ظ��²�����Ϣҳ��
	 */
	@RequestMapping(value="/deptOperation", params = "method=findById")
	public ModelAndView findById(HttpServletRequest request,HttpServletResponse response){
		//���ղ��ű�Ų��Ҳ���
		DeptInfo dept = (DeptInfo) deptInfoDao.findById(Integer.valueOf(request.getParameter("number")));
		return new ModelAndView("dept/insertOrUpdateDept","dept",dept);
	}
}
