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
	private UDService uDService;//服务层
	/**
	 *   插入用户
	 */
	@RequestMapping(value="/userOperation.html", params = "method=insertUser")
	public ModelAndView FilesUpload_transferTo_spring(HttpServletRequest request,HttpServletResponse response,@RequestParam("file") MultipartFile multipartFile,UserInfo userInfo) throws Exception{
	//if(multipartFile!=null)
	{
		 //get files suffix,getOriginalFilename()取得上传时的文件名，返回的文件名,abc。jpg则suffix为abc
        String suffix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
		//文件夹是否存在，不存在则新创建
       //图片保存位置
       String savePath = "E:\\IMAGE"+ File.separator + uDService.getDataPath() + File.separator;
       uDService.checkDir(savePath);
       //图片写入的位置
       String absolutePath=savePath+uDService.getUUIDName(suffix);
       multipartFile.transferTo(new File(absolutePath));//写入当前文件
       
        if(userInfo!=null){
        	UserInfo user = new UserInfo(); // 声明user实体对象
        	user.setId( userInfo.getId()); // 为对象属性赋值
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
    		uDService.getUserInfoDao().insert(user); // 调用插入数据的方法
    		System.out.println("插入成功");
        }
       
    	
	}	

		return null;

	}
	/**
	 *   插入用户
	 */
	/*@RequestMapping(value="/userOperation.html", params = "method=insertUser")
	public ModelAndView insertUser(HttpServletRequest request,HttpServletResponse response)throws Exception{
		Map<String, String>map= uDService.getFileUpLoad().upload(request, response);//首先上传照片，并返回表单信息
		UserInfo user=new UserInfo();
		if(!map.isEmpty()){//map不为空，说明可以登录账号可以使用
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
			
			System.out.println("打印路径");
			System.out.println(map.get("face"));
			
			
			uDService.getUserInfoDao().insert(user); // 调用插入数据的方法
		}else{
			PrintWriter out=response.getWriter();
			out.print("<script type='text/javascript'>");
			out.print("alert('不能用此登录账号注册，此账号已经被使用！');");// 输出提示信息
			out.print("window.history.go(-1);"); // 后退网页
			out.print("</script>");
			out.close();
			
		}
		return null;				
	}*/
	/**
	 * 更新用用户信息
	 * 
	 * @param request
	 * @param response
	 * @return 用户管理首页
	 * @throws Exception 
	 */
	@RequestMapping(value="/userOperation.html", params = "method=updateUser")
	public ModelAndView updateUser(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, String> map = uDService.getFileUpLoad().upload(request, response);// 首先上传图片，并返回表单中的其他信息
		UserInfo user = new UserInfo(); // 声明user实体对象
		user.setId(map.get("id")); // 为对象属性赋值
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
		
		
	
		System.out.println("打印路径");
		System.out.println("更新了");
		System.out.println(map.get("pwd"));
		System.out.println(map.get("remark"));
		System.out.println(map.get("face"));
		uDService.getUserInfoDao().update(user); // 调用更新数据库的方法
		
		return showUser(request, response); // 返回用户管理首页
	}
	
	/**
	 * 用据主键编号删除用户
	 * 
	 * @param request
	 * @param response
	 * @return null
	 * @throws Exception
	 */
	@RequestMapping(value="userOperation.html", params = "method=deleteUser")
	public ModelAndView deleteUser(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Integer number = Integer.valueOf(request.getParameter("number")); // 获取用户编号

		UserInfo user = (UserInfo) uDService.getUserInfoDao().findById(number);
		String path = request.getSession().getServletContext().getRealPath("/")
				+ "face\\"+user.getFace();			//获取照片存放路径
		
		uDService.getUserInfoDao().delete(number); //调用删除数据记录的方法
		new File(path).delete();	//删除照片
		
		PrintWriter out = response.getWriter(); 	//获取out对象
		out.print("<script type='text/javascript'>");
		out.print("alert('员工删除成功！');"); 		//输出提示信息
		out.print("window.location='userOperation.html?method=showUser';"); // 返回用户管理首页
		out.print("</script>");
		out.close();
		return null;
		
	}
	
	@RequestMapping(value="userOperation.html", params = "method=showUser")
	public ModelAndView showUser(HttpServletRequest request,HttpServletResponse response){
		List list= uDService.getUserInfoDao().findJion();
		
		System.out.println("不是空的");
		if(list.isEmpty()){
			System.out.println("是空的");
			
		}else{
			System.out.println("不是空的");
		}
		
		return new ModelAndView("user/showUser","list",list);
		
	}
	/**
	 * 跟据主键编号查找用户信息
	 * 
	 * @param request
	 * @param response
	 * @return 返回用户更新页面
	 */
	@RequestMapping(value="userOperation.html", params = "method=findById")
	public ModelAndView findById(HttpServletRequest request,
			HttpServletResponse response) {
		String number = request.getParameter("number");
		List list =  uDService.getIDeptInfoDao().findAll(); // 查询部门编号与名称
		if (number == null || number.equals("")) { // 插入新记录
			return new ModelAndView("user/insertUser", "map", list);
		} else { // 更新记录
			UserInfo user = (UserInfo)  uDService.getUserInfoDao().findById(Integer.valueOf(number));
			Map map = new HashMap();
			map.put("user", user);
			map.put("list", list);
			System.out.println(user.getName());
			return new ModelAndView("user/updateUser", "map", map);
		}
	}

}
