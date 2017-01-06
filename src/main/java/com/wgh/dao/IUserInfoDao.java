package com.wgh.dao;

import java.util.List;



public interface IUserInfoDao {
	public void delete(Integer number);//根据主键编号删除记录
	public List<Object> findAll();
	/**
	 * 根据主键编号查询用户信息
	 * @param number - 主键编号
	 * @return 用户记录
	 */
	public Object findById(Integer number) ;
	/**
	 * 插入用新用户信息
	 * @param o - 用户实体对象
	 */
	public void insert(Object o);
	/**
	 * 更新用户信息
	 * @param o - 用户实体对象
	 */
	public void update(Object o);
	/**
	 * 验证用户登录信息
	 * @param id - 用户登录名
	 * @param pwd - 用户登录密码
	 * @return 用户信息
	 */
	public List findByNamePwd(String name,String pwd);
	/**
	 * 检查用户名登录账号是否被使用
	 * @param id 用户登录账号
	 * @return true未被使用，false已被使用
	 */
	public boolean findByName(String id);
	/**
	 * 使用部门编联合查询出用户所在部门名称
	 * @return lise
	 */
	public List findJion();
	/**
	 * 查询指定部门是否有员工
	 * @param dept - 部门编号
	 * @return 如果此部门中没有员工返回true否则返回false。
	 */
	public boolean findBydept(Integer dept);

}
