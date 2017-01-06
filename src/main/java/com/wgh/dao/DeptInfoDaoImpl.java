package com.wgh.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wgh.modle.DeptInfo;

@Repository("deptInfoDaoImpl")
public class DeptInfoDaoImpl implements IDeptInfoDao {

	@Resource//自动按照bean的类型注入
	private SessionFactory sessionFactory;
	
	

	@Override
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
	public void delete(Integer number) {
		// TODO Auto-generated method stub
		Session session=this.getSession();//开启session
		DeptInfo deptInfo=(DeptInfo)session.load(DeptInfo.class, number);//通过反射机制
		session.delete(deptInfo);
		session.flush();
		session.close();
		

	}
	
	public Session getSession(){
		
		return sessionFactory.openSession();
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true,isolation=Isolation.DEFAULT)
	public List<Object> findAll() {
		// TODO Auto-generated method stub
		Session session=this.getSession();
		Query query=session.createQuery("From DeptInfo");//通过hql查询所有信息
		List list=query.list();
		return list;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true,isolation=Isolation.DEFAULT)
	public Object findById(Integer number) {
		// TODO Auto-generated method stub
		Session session=this.getSession();
		DeptInfo deptInfo=(DeptInfo)session.load(DeptInfo.class, number);//通过反射机制
		return deptInfo;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
	public void insert(Object o) {
		// TODO Auto-generated method stub
		Session session=this.getSession();
		session.save(o);
		session.flush();
		session.close();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
	public void update(Object o) {
		// TODO Auto-generated method stub
		Session session=this.getSession();
		session.update(o);
		session.flush();
		session.close();

	}


}
