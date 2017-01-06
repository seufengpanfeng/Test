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
	private IUserInfoDao userInfoDao;//�����жϵ�¼�˺��Ƿ�ռ��
	
	public ModelAndView FilesUpload_transferTo_spring(HttpServletRequest request,HttpServletResponse response,MultipartFile multipartFile,String savePath,UserInfo userInfo) throws Exception{
	if(multipartFile!=null){
		 //get files suffix,getOriginalFilename()ȡ���ϴ�ʱ���ļ��������ص��ļ���,abc��jpg��suffixΪabc
        String suffix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
		//�ļ����Ƿ���ڣ����������´���
        File dir = new File(savePath);
        if (!dir.exists() || !dir.isDirectory()) {
      	  System.out.println("�����ļ��гɹ���");
            dir.mkdir();
        }
        
        if(userInfo!=null){
        	UserInfo user = new UserInfo(); // ����userʵ�����
        	user.setId( userInfo.getId()); // Ϊ�������Ը�ֵ
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
