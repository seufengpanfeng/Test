package com.wgh.pojo;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sun.javafx.collections.MappingChange.Map;
import com.wgh.dao.IUserInfoDao;
import com.wgh.modle.UserInfo;

public class MVC_FileUpload {
	@Resource
	private IUserInfoDao userInfoDao;//用于判断登录账号是否被占用
	
	public ModelAndView FilesUpload_transferTo_spring(HttpServletRequest request,HttpServletResponse response,MultipartFile multipartFile,String savePath,UserInfo userInfo) throws Exception{
	if(multipartFile!=null){
		 //get files suffix,getOriginalFilename()取得上传时的文件名，返回的文件名,abc。jpg则suffix为abc
        String suffix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
		//文件夹是否存在，不存在则新创建
        File dir = new File(savePath);
        if (!dir.exists() || !dir.isDirectory()) {
      	  System.out.println("创建文件夹成功了");
            dir.mkdir();
        }
        
        if(userInfo!=null){
        	UserInfo user = new UserInfo(); // 声明user实体对象
        	user.setId( userInfo.getId()); // 为对象属性赋值
    		user.setPwd(userInfo.getPwd());
    		user.setName(userInfo.getName());
    		user.setEmail(userInfo.getEmail());
    		user.setSex(userInfo.getEmail());
    		user.setBirthday(userInfo.getBirthday());
    		user.setCome(userInfo.getCome());
    		user.setDept(Integer.valueOf(userInfo.getDept().toString()));
    		user.setFace(userInfo.getFace());
    		user.setRemark(userInfo.getRemark());
    		user.setNumber(Integer.valueOf(userInfo.getNumber().toString()));
    	
        }
       
    	
	}	
		
		
		return null;
		
		
	}

	

}
