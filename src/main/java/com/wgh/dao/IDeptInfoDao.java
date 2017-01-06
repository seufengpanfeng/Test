package com.wgh.dao;

import java.util.List;



public interface IDeptInfoDao {
	public void delete(Integer number);//根据主键删除记录
	public List<Object>findAll();//查询所有记录
	public Object findById(Integer number);//根据主键编号查询记录
	public void insert(Object o);//插入新纪录
	public void update(Object o);//更新记录
	

}
