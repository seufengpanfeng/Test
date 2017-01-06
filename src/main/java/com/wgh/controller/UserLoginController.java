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
	private UDService uDService;//服务层
	
	public UserLoginController() {
		// TODO Auto-generated constructor stub
	setSessionForm(true);
	System.out.println("这里先执行");
	}
	
	
	@RequestMapping(value="/index.html")
	protected ModelAndView onSubmit(UserInfo command) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("这后里执行");
		UserInfo userInfo=command;//获取实体对象
		if(userInfo.getName()==null||userInfo.getPwd()==null){
			return new ModelAndView("index");//第一个参数是视图名
		}
		System.out.println(userInfo.getName());
		System.out.println(userInfo.getPwd());
		List list=uDService.getUserInfoDao().findByNamePwd(userInfo.getName(), userInfo.getPwd());
		if(list.isEmpty()){
			return new ModelAndView("index","error","登录失败用户名或者密码不存在");//第一个参数是视图名
			
		}
		else{
			userInfo=(UserInfo)list.get(0);//得到第一个用户
			System.out.println(userInfo.getName());
			System.out.println(userInfo.getPwd());
			if(userInfo.getNumber()==1){//编号1为系统管理员
				return new ModelAndView("admin");//进入验证成功页面
			}else{//否则为普通用户登录，显示用户的部门信息
				DeptInfo deptInfo=(DeptInfo)uDService.getIDeptInfoDao().findById(userInfo.getDept());//得出部门信息
				Map map=new HashMap();
				map.put("dept", deptInfo);//返回部门信息
				map.put("user", userInfo);//返回用户信息
				return new ModelAndView("userInfo", "map", map);//向试图传递map
				
			}
			
		}
		
	}

}
