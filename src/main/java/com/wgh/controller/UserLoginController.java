package com.wgh.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.wgh.modle.DeptInfo;
import com.wgh.modle.UserInfo;
import com.wgh.service.UDService;

@Controller
@SuppressWarnings("deprecation")
@Scope("prototype")
public class UserLoginController extends SimpleFormController {


	@Resource
	private UDService uDService;//�����
	
	public UserLoginController() {
		// TODO Auto-generated constructor stub
	setSessionForm(true);
	System.out.println("������ִ��");
	}
	
	
	@RequestMapping(value="/index.html")
	protected ModelAndView onSubmit(UserInfo command) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("�����ִ��");
		UserInfo userInfo=command;//��ȡʵ�����
		if(userInfo.getName()==null||userInfo.getPwd()==null){
			return new ModelAndView("index");//��һ����������ͼ��
		}
		System.out.println(userInfo.getName());
		System.out.println(userInfo.getPwd());
		List list=uDService.getUserInfoDao().findByNamePwd(userInfo.getName(), userInfo.getPwd());
		if(list.isEmpty()){
			return new ModelAndView("index","error","��¼ʧ���û����������벻����");//��һ����������ͼ��
			
		}
		else{
			userInfo=(UserInfo)list.get(0);//�õ���һ���û�
			System.out.println(userInfo.getName());
			System.out.println(userInfo.getPwd());
			if(userInfo.getNumber()==1){//���1Ϊϵͳ����Ա
				return new ModelAndView("admin");//������֤�ɹ�ҳ��
			}else{//����Ϊ��ͨ�û���¼����ʾ�û��Ĳ�����Ϣ
				DeptInfo deptInfo=(DeptInfo)uDService.getIDeptInfoDao().findById(userInfo.getDept());//�ó�������Ϣ
				Map map=new HashMap();
				map.put("dept", deptInfo);//���ز�����Ϣ
				map.put("user", userInfo);//�����û���Ϣ
				return new ModelAndView("userInfo", "map", map);//����ͼ����map
				
			}
			
		}
		
	}

}
