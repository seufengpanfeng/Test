package com.wgh.test;

import static org.junit.Assert.*;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wgh.dao.IDeptInfoDao;
import com.wgh.modle.DeptInfo;
import com.wgh.modle.UserInfo;
//@Component

@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/applicationContext.xml"}) 
@RunWith(SpringJUnit4ClassRunner.class)  
@Service
public class DaoTest  {

	 Date date1=new Date(); 
	 
	   // @Resource
		//IUserInfoDao userInfoDaoImpl1;//用户
		@Resource
		private IDeptInfoDao deptInfoDaoImpl11;//部门
		 @Test  
		 	public void test() {
			// UserInfo user=new UserInfo();
			   System.out.println(date1.toLocaleString());  
			  DeptInfo deptInfo=new DeptInfo();
				deptInfo.setName("事业部");//获取部门名称
				deptInfo.setCreateDate("1995");//获取部门创建时间
				deptInfo.setNumber(Integer.valueOf("5"));//获取部门编号
				deptInfo.setRemark("很好");//获取部门介绍
				deptInfoDaoImpl11.insert(deptInfo);
			       System.out.println("正确执行");
	//	fail("Not yet implemented");
	}
}
