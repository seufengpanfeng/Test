package com.wgh.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import com.wgh.dao.IDeptInfoDao;
import com.wgh.dao.IUserInfoDao;
import com.wgh.modle.UserInfo;
import com.wgh.pojo.FileUpload;
import com.wgh.pojo.Files_Utils_DG;

public interface UDService {
	
	public IUserInfoDao getUserInfoDao();
	public IDeptInfoDao getIDeptInfoDao();
	public FileUpload   getFileUpLoad();
	public UserInfo     getUserInfo();
	  //return a dir that named date of today ; example:20160912
    public String getDataPath() ;
	//public Files_Utils_DG getFile();
    public String getUUIDName(String suffix) ;
    public void checkDir(String savePath);
   	

}
