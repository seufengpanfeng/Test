package com.wgh.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;


import com.wgh.modle.UserInfo;
import com.wgh.service.UDService;
@Controller
public class UserOperationController extends MultiActionController {
	
	@Resource
	private UDService uDService;//�����
	/**
	 *   �����û�
	 */
	@RequestMapping(value="/userOperation.html", params = "method=insertUser")
	public ModelAndView FilesUpload_transferTo_spring(HttpServletRequest request,HttpServletResponse response,@RequestParam("file") MultipartFile multipartFile,UserInfo userInfo) throws Exception{
	//if(multipartFile!=null)
	{
		 //get files suffix,getOriginalFilename()ȡ���ϴ�ʱ���ļ��������ص��ļ���,abc��jpg��suffixΪabc
        String suffix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
		//�ļ����Ƿ���ڣ����������´���
       //ͼƬ����λ��
       String savePath = "E:\\IMAGE"+ File.separator + uDService.getDataPath() + File.separator;
       uDService.checkDir(savePath);
       //ͼƬд���λ��
       String absolutePath=savePath+uDService.getUUIDName(suffix);
       multipartFile.transferTo(new File(absolutePath));//д�뵱ǰ�ļ�
       
        if(userInfo!=null){
        	UserInfo user = new UserInfo(); // ����userʵ�����
        	user.setId( userInfo.getId()); // Ϊ�������Ը�ֵ
        	System.out.println(userInfo.getId());
    		user.setPwd(userInfo.getPwd());
    		System.out.println(userInfo.getPwd());
    		user.setName(userInfo.getName());
    		System.out.println(userInfo.getName());
    		user.setEmail(userInfo.getEmail());
    		System.out.println(userInfo.getEmail());
    		user.setSex(userInfo.getSex());
    		System.out.println(userInfo.getSex());
    		user.setBirthday(userInfo.getBirthday());
    		System.out.println(userInfo.getBirthday());
    		user.setCome(userInfo.getCome());
    		System.out.println(userInfo.getCome());
    		user.setDept(Integer.valueOf(userInfo.getDept().toString()));
    		System.out.println(Integer.valueOf(userInfo.getDept().toString()));
    		//userInfo.setFace(absolutePath);
    		user.setFace(absolutePath);
    		System.out.println(absolutePath);
    		user.setRemark(userInfo.getRemark());
    		System.out.println(userInfo.getRemark());
    		//user.setNumber(Integer.valueOf(userInfo.getNumber().toString()));
    		//System.out.println(Integer.valueOf(userInfo.getNumber().toString()));
    		uDService.getUserInfoDao().insert(user); // ���ò������ݵķ���
    		System.out.println("����ɹ�");
        }
       
    	
	}	

		return null;

	}
	/**
	 *   �����û�
	 */
	/*@RequestMapping(value="/userOperation.html", params = "method=insertUser")
	public ModelAndView insertUser(HttpServletRequest request,HttpServletResponse response)throws Exception{
		Map<String, String>map= uDService.getFileUpLoad().upload(request, response);//�����ϴ���Ƭ�������ر���Ϣ
		UserInfo user=new UserInfo();
		if(!map.isEmpty()){//map��Ϊ�գ�˵�����Ե�¼�˺ſ���ʹ��
			user.setId(map.get("id"));
			user.setPwd(map.get("pwd"));
			user.setName(map.get("name"));
			user.setSex(map.get("sex"));
			user.setBirthday(map.get("birthday"));
			user.setCome(map.get("come"));
			user.setDept(Integer.valueOf(map.get("dept").toString()));
			user.setFace(map.get("face"));
			user.setRemark(map.get("remark"));
			user.setEmail(map.get("email"));
			
			System.out.println("��ӡ·��");
			System.out.println(map.get("face"));
			
			
			uDService.getUserInfoDao().insert(user); // ���ò������ݵķ���
		}else{
			PrintWriter out=response.getWriter();
			out.print("<script type='text/javascript'>");
			out.print("alert('�����ô˵�¼�˺�ע�ᣬ���˺��Ѿ���ʹ�ã�');");// �����ʾ��Ϣ
			out.print("window.history.go(-1);"); // ������ҳ
			out.print("</script>");
			out.close();
			
		}
		return null;				
	}*/
	/**
	 * �������û���Ϣ
	 * 
	 * @param request
	 * @param response
	 * @return �û�������ҳ
	 * @throws Exception 
	 */
	@RequestMapping(value="/userOperation.html", params = "method=updateUser")
	public ModelAndView updateUser(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, String> map = uDService.getFileUpLoad().upload(request, response);// �����ϴ�ͼƬ�������ر��е�������Ϣ
		UserInfo user = new UserInfo(); // ����userʵ�����
		user.setId(map.get("id")); // Ϊ�������Ը�ֵ
		user.setPwd(map.get("pwd"));
		user.setName(map.get("name"));
		user.setEmail(map.get("email"));
		user.setSex(map.get("sex"));
		user.setBirthday(map.get("birthday"));
		user.setCome(map.get("come"));
		user.setDept(Integer.valueOf(map.get("dept").toString()));
		user.setFace(map.get("face"));
		user.setRemark(map.get("remark"));
		user.setNumber(Integer.valueOf(map.get("number").toString()));
		
		
	
		System.out.println("��ӡ·��");
		System.out.println("������");
		System.out.println(map.get("pwd"));
		System.out.println(map.get("remark"));
		System.out.println(map.get("face"));
		uDService.getUserInfoDao().update(user); // ���ø������ݿ�ķ���
		
		return showUser(request, response); // �����û�������ҳ
	}
	
	/**
	 * �þ��������ɾ���û�
	 * 
	 * @param request
	 * @param response
	 * @return null
	 * @throws Exception
	 */
	@RequestMapping(value="userOperation.html", params = "method=deleteUser")
	public ModelAndView deleteUser(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Integer number = Integer.valueOf(request.getParameter("number")); // ��ȡ�û����

		UserInfo user = (UserInfo) uDService.getUserInfoDao().findById(number);
		String path = request.getSession().getServletContext().getRealPath("/")
				+ "face\\"+user.getFace();			//��ȡ��Ƭ���·��
		
		uDService.getUserInfoDao().delete(number); //����ɾ�����ݼ�¼�ķ���
		new File(path).delete();	//ɾ����Ƭ
		
		PrintWriter out = response.getWriter(); 	//��ȡout����
		out.print("<script type='text/javascript'>");
		out.print("alert('Ա��ɾ���ɹ���');"); 		//�����ʾ��Ϣ
		out.print("window.location='userOperation.html?method=showUser';"); // �����û�������ҳ
		out.print("</script>");
		out.close();
		return null;
		
	}
	
	@RequestMapping(value="userOperation.html", params = "method=showUser")
	public ModelAndView showUser(HttpServletRequest request,HttpServletResponse response){
		List list= uDService.getUserInfoDao().findJion();
		
		System.out.println("���ǿյ�");
		if(list.isEmpty()){
			System.out.println("�ǿյ�");
			
		}else{
			System.out.println("���ǿյ�");
		}
		
		return new ModelAndView("user/showUser","list",list);
		
	}
	/**
	 * ����������Ų����û���Ϣ
	 * 
	 * @param request
	 * @param response
	 * @return �����û�����ҳ��
	 */
	@RequestMapping(value="userOperation.html", params = "method=findById")
	public ModelAndView findById(HttpServletRequest request,
			HttpServletResponse response) {
		String number = request.getParameter("number");
		List list =  uDService.getIDeptInfoDao().findAll(); // ��ѯ���ű��������
		if (number == null || number.equals("")) { // �����¼�¼
			return new ModelAndView("user/insertUser", "map", list);
		} else { // ���¼�¼
			UserInfo user = (UserInfo)  uDService.getUserInfoDao().findById(Integer.valueOf(number));
			Map map = new HashMap();
			map.put("user", user);
			map.put("list", list);
			System.out.println(user.getName());
			return new ModelAndView("user/updateUser", "map", map);
		}
	}

}
