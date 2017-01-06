package com.wgh.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wgh.dao.IDeptInfoDao;
import com.wgh.dao.IUserInfoDao;
import com.wgh.modle.UserInfo;
import com.wgh.pojo.FileUpload;
import com.wgh.pojo.Files_Utils_DG;
@Service("uDServiceImpl")
public class UDServiceImpl implements UDService {
	@Resource(name="deptInfoDaoImpl")
	private IDeptInfoDao deptInfoDaoImpl;
	@Resource(name="userInfoDaoImpl")
	private IUserInfoDao userInfoDaoImpl;
	@Resource
	private FileUpload fileUpload;
	
	private UserInfo userInfo;
	
	
	@Override
	public IUserInfoDao getUserInfoDao() {
		// TODO Auto-generated method stub
		return userInfoDaoImpl;

	}

	@Override
	public IDeptInfoDao getIDeptInfoDao() {
		// TODO Auto-generated method stub
		return deptInfoDaoImpl;
	}

	@Override
	public FileUpload getFileUpLoad() {
		// TODO Auto-generated method stub
		return fileUpload;
	}

	@Override
	public UserInfo getUserInfo() {
		// TODO Auto-generated method stub
		return userInfo;
	}

	@Override
	public String getDataPath() {
		return new SimpleDateFormat("yyyyMMdd").format(new Date());
		
	}

	@Override
	public String getUUIDName(String suffix) {
		  return UUID.randomUUID().toString() + suffix;// make new file name
	
	}

	@Override
	public void checkDir(String savePath) {
		
	    	 System.out.println("创建文件夹");
	              File dir = new File(savePath);
	              if (!dir.exists() || !dir.isDirectory()) {
	            	  System.out.println("创建文件夹成功了");
	                  dir.mkdir();
	              }
	          }
		


}
