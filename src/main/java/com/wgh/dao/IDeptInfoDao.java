package com.wgh.dao;

import java.util.List;



public interface IDeptInfoDao {
	public void delete(Integer number);//��������ɾ����¼
	public List<Object>findAll();//��ѯ���м�¼
	public Object findById(Integer number);//����������Ų�ѯ��¼
	public void insert(Object o);//�����¼�¼
	public void update(Object o);//���¼�¼
	

}
