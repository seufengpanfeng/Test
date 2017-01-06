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
	IUserInfoDao userInfoDao;//用户
	@Resource
	IDeptInfoDao deptInfoDao;//部门
	
	/**
	 * 更新或者添加部门
	 */
	@RequestMapping(value="/deptOperation", params = "method=insertOrUpdateDept")
	public ModelAndView insertOrUpdateDept(HttpServletRequest request,HttpServletResponse response){
		DeptInfo deptInfo=new DeptInfo();
		deptInfo.setName(request.getParameter("name"));//获取部门名称
		deptInfo.setCreateDate(request.getParameter("createDate"));//获取部门创建时间
		deptInfo.setNumber(Integer.valueOf(request .getParameter("number")));//获取部门编号
		deptInfo.setRemark(request.getParameter("remark"));//获取部门介绍
		
		if(deptInfo.getNumber()==0){
			deptInfoDao.insert(deptInfo);
		}else{
			deptInfoDao.update(deptInfo);
		}
		return showDept(request,response);
	}
	/**
	 * 如果部门没人，就删除部门，否则不删除
	 */
	@RequestMapping(value="/deptOperation", params = "method=deleteDept")
	public ModelAndView deleteDept(HttpServletRequest request,HttpServletResponse response) 
			throws Exception{
		Integer number=Integer.valueOf(request .getParameter("number"));//获取部门编号
		boolean bool=(boolean) userInfoDao.findById(number);
		
		String message="";//提示信息
		if(bool){//部门无员工
			deptInfoDao.delete(number);
		}else{
			message="不能删除有员工的部门";
		}
		PrintWriter out=response.getWriter();
		out.print("alert('"+message+"');");
		return showDeptFirst(request, response);
		
		
	}
	/**
	 * 返回部门主页的视图
	 */
	public ModelAndView showDeptFirst(HttpServletRequest request,HttpServletResponse response){
		return new ModelAndView("dept/showDeptFirst");
	}
	/**
	 * 自定义showDept视图
	 */
	@RequestMapping(value="/deptOperation", params = "method=showDept")
	public ModelAndView showDept(HttpServletRequest request,HttpServletResponse response){
		List list=deptInfoDao.findAll();//获取表中所有信息
		return new ModelAndView("dept/insertOrUpdateDept", "list", list);
		
	}
	/**
	 * 按照部门编号查询部门信息
	 * @param request
	 * @param response
	 * @return 返回更新部门信息页面
	 */
	@RequestMapping(value="/deptOperation", params = "method=findById")
	public ModelAndView findById(HttpServletRequest request,HttpServletResponse response){
		//按照部门编号查找部门
		DeptInfo dept = (DeptInfo) deptInfoDao.findById(Integer.valueOf(request.getParameter("number")));
		return new ModelAndView("dept/insertOrUpdateDept","dept",dept);
	}
}
