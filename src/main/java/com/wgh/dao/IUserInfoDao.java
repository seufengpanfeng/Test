package com.wgh.dao;

import java.util.List;



public interface IUserInfoDao {
	public void delete(Integer number);//�����������ɾ����¼
	public List<Object> findAll();
	/**
	 * ����������Ų�ѯ�û���Ϣ
	 * @param number - �������
	 * @return �û���¼
	 */
	public Object findById(Integer number) ;
	/**
	 * ���������û���Ϣ
	 * @param o - �û�ʵ�����
	 */
	public void insert(Object o);
	/**
	 * �����û���Ϣ
	 * @param o - �û�ʵ�����
	 */
	public void update(Object o);
	/**
	 * ��֤�û���¼��Ϣ
	 * @param id - �û���¼��
	 * @param pwd - �û���¼����
	 * @return �û���Ϣ
	 */
	public List findByNamePwd(String name,String pwd);
	/**
	 * ����û�����¼�˺��Ƿ�ʹ��
	 * @param id �û���¼�˺�
	 * @return trueδ��ʹ�ã�false�ѱ�ʹ��
	 */
	public boolean findByName(String id);
	/**
	 * ʹ�ò��ű����ϲ�ѯ���û����ڲ�������
	 * @return lise
	 */
	public List findJion();
	/**
	 * ��ѯָ�������Ƿ���Ա��
	 * @param dept - ���ű��
	 * @return ����˲�����û��Ա������true���򷵻�false��
	 */
	public boolean findBydept(Integer dept);

}
