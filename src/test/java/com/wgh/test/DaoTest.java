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
		//IUserInfoDao userInfoDaoImpl1;//�û�
		@Resource
		private IDeptInfoDao deptInfoDaoImpl11;//����
		 @Test  
		 	public void test() {
			// UserInfo user=new UserInfo();
			   System.out.println(date1.toLocaleString());  
			  DeptInfo deptInfo=new DeptInfo();
				deptInfo.setName("��ҵ��");//��ȡ��������
				deptInfo.setCreateDate("1995");//��ȡ���Ŵ���ʱ��
				deptInfo.setNumber(Integer.valueOf("5"));//��ȡ���ű��
				deptInfo.setRemark("�ܺ�");//��ȡ���Ž���
				deptInfoDaoImpl11.insert(deptInfo);
			       System.out.println("��ȷִ��");
	//	fail("Not yet implemented");
	}
}
