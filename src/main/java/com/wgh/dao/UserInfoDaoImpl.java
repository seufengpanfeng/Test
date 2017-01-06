package com.wgh.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wgh.modle.UserInfo;

@Repository("userInfoDaoImpl")
public class UserInfoDaoImpl implements IUserInfoDao {

	@Resource
	private SessionFactory sessionFactory;
	/* (non-Javadoc)
	 * @see com.wgh.dao.IUserInfoDao#delete(java.lang.Integer)
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
	public void delete(Integer number) {
		// TODO Auto-generated method stub
		Session session=this.getSession();
		UserInfo userInfo =(UserInfo)session.get(UserInfo.class, number);
		session.delete(userInfo);
		session.flush();

	}

	/* (non-Javadoc)
	 * @see com.wgh.dao.IUserInfoDao#findAll()
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
	public List<Object> findAll() {
		// TODO Auto-generated method stub
		Session session=this.getSession();
		
		Query query=session.createQuery("FROM UserInfo");
		List list=query.list();
		return list;
	}

	/* (non-Javadoc)
	 * @see com.wgh.dao.IUserInfoDao#findById(java.lang.Integer)
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
	public Object findById(Integer number) {
		// TODO Auto-generated method stub
		Session session=this.getSession();
		UserInfo userInfo=(UserInfo)session.get(UserInfo.class,number);
		return userInfo;
	}

	/* (non-Javadoc)
	 * @see com.wgh.dao.IUserInfoDao#insert(java.lang.Object)
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true,isolation=Isolation.DEFAULT)
	public void insert(Object o) {
		// TODO Auto-generated method stub
		Session session=this.getSession();
		session.save(o);
		

	}

	/* (non-Javadoc)
	 * @see com.wgh.dao.IUserInfoDao#update(java.lang.Object)
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
	public void update(Object o) {
		// TODO Auto-generated method stub
		Session session=this.getSession();
		//session.beginTransaction();
		session.update(o);
		session.flush();		//Êä³ö»º´æ
		//session.getTransaction().commit();
	}

	/* (non-Javadoc)
	 * @see com.wgh.dao.IUserInfoDao#findByNamePwd(java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true,isolation=Isolation.DEFAULT)
	public List findByNamePwd(String name, String pwd) {
		// TODO Auto-generated method stub

			
		Session session=this.getSession();
		Query query =  session.createQuery("From UserInfo Where name='"+ name + "' And pwd='"+ pwd +"'");
		//Query query =  session.createQuery("From UserInfo Where pwd='"+ pwd +"'");
		List list=query.list();
		return list;
	}

	/* (non-Javadoc)
	 * @see com.wgh.dao.IUserInfoDao#findByName(java.lang.String)
	 */
	@Override
	public boolean findByName(String name) {
		// TODO Auto-generated method stub
		Session session=this.getSession();
		Query query=session.createQuery("FROM UserInfo WHERE name='"+name+"'");
		List list=query.list();
		if(list.isEmpty()){
			return true;
		}else{
			return false;
		}
		
	}

	/* (non-Javadoc)
	 * @see com.wgh.dao.IUserInfoDao#findJion()
	 */
	@Override
	public List findJion() {
		// TODO Auto-generated method stub
		Session session=this.getSession();
		Query query=session.createQuery("FROM UserInfo u,DeptInfo d WHERE u.dept=d.number order by u.number");
		List list=query.list();
		return list;
	}

	/* (non-Javadoc)
	 * @see com.wgh.dao.IUserInfoDao#findBydept(java.lang.Integer)
	 */
	@Override
	public boolean findBydept(Integer dept) {
		// TODO Auto-generated method stub
		Session session=this.getSession();
		Query query=session.createQuery("FROM UserInfo WHERE dept='"+dept+"'");
		List list=query.list();
		if(list.isEmpty()){
			return true;
		}else{
			return false;
		}
	
	}
	public Session getSession(){
		
		return sessionFactory.openSession();
	}

}
