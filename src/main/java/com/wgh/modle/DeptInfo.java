package com.wgh.modle;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


//model��
@Entity
@Table(name="tb_deptinfo")
public class DeptInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer number;//���ű��
	private String name;//��������
	private String createDate;//���Ŵ�������
	private String remark;//���Ž���
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="number",nullable=true)//�������ɲ���
	public Integer getNumber() {
		return number;
	}
	
	public void setNumber(Integer number) {
		this.number = number;
	}
	//@Length(min=1,max=32)
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="createDate")
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	@Column(name="Remark")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	

}
