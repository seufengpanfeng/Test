package com.wgh.pojo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
 import java.text.SimpleDateFormat;
 import java.util.Date;
 import java.util.UUID;
 //@Component
public  class Files_Utils_DG {
	
	/**
	 * 构造函数
	 */
	private Files_Utils_DG(){
		throw new Error("The class Cannot be instance!");
	}
	/**
	       * spring mvc files Upload method (transferTo method)
	       * MultipartFile use TransferTo method upload
	       *
	       * @param request       HttpServletRequest
	       * @param multipartFile MultipartFile(spring)
	      * @param filePath      filePath example "/files/Upload"
	       * @return
	*/
	public static String FilesUpload_transferTo_spring(HttpServletRequest request, MultipartFile multipartFile, String filePath){
		
		         if (multipartFile != null) {
			              //get files suffix,getOriginalFilename()取得上传时的文件名，返回的文件名
			              String suffix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
			              //filePath+fileName the complex file Name
			              
			              String absolutePath = getAndSetAbsolutePath(request, filePath, suffix);
			              //return relative Path
			             // String relativePath = getRelativePath(filePath, suffix);
			              String relativePath = "E:\\ABC";
			             System.out.println("绝对位置"+absolutePath);
			             System.out.println("相对位置"+getServerPath(request, filePath));
			              try {
			                  //save file
			                  multipartFile.transferTo(new File(absolutePath));//将上传的文件写到指定位置
			                  System.out.println("成功了");
			                  //return relative Path
			                  return relativePath;
			                  
			              } catch (IOException e) {
			                  e.printStackTrace();
			                  return null;
			              }
			          } else
			              return null;
	}
	
	
	     //-------------------------------------------------------------------------------
     //return server absolute path（real path）
	     public static String getServerPath(HttpServletRequest request, String filePath) {
	        // return request.getSession().getServletContext().getRealPath(filePath);
	    	 return request.getSession().getServletContext().getRealPath(filePath);
	     }
	 
	     //return a dir that named date of today ; example:20160912
	     public static String getDataPath() {
	         return new SimpleDateFormat("yyyyMMdd").format(new Date());
	     }
	     
	          //check if the path has exist if not create it
	     public static void checkDir(String savePath) {
	    	 System.out.println("创建文件夹");
	              File dir = new File(savePath);
	              if (!dir.exists() || !dir.isDirectory()) {
	            	  System.out.println("创建文件夹成功了");
	                  dir.mkdir();
	              }
	          }
	     	
	     
	         //return an UUID Name parameter (suffix cover '.') example： ".jpg"、".txt"
	         public static String getUUIDName(String suffix) {
	              return UUID.randomUUID().toString() + suffix;// make new file name
	          }

	          
	              //return server absolute path（real path） the style is  “server absolute path/DataPath/UUIDName”filePath example "/files/Upload"
	      //在windows上File.separator代表\
	         public static String getAndSetAbsolutePath(HttpServletRequest request, String filePath, String suffix) {
	         //String savePath = getServerPath(request, filePath) + File.separator + getDataPath() + File.separator;//example:F:/qixiao/files/Upload/20160912/
	         String savePath = "E:\\IMAGE"+ File.separator + getDataPath() + File.separator;
	         //  String savePath= "e:/tupian/files"; 
	    	  checkDir(savePath);//check if the path has exist if not create it
	              return savePath + getUUIDName(suffix);
	            }
	        
	          
	               
	                  //get the relative path of files style is “/filePath/DataPath/UUIDName”filePath example "/files/Upload"
	         public static String getRelativePath(String filePath, String suffix) {
	             return filePath + File.separator + getDataPath() + File.separator + getUUIDName(suffix);//example:/files/Upload/20160912/
	            }

	         
	         
	              /**
	               * @param request  HttpServletRequest
	               * @param response HttpServletResponse
	               * @param filePath example "/filesOut/Download/mst.txt"
	               * @return
	               */
	              public static void FilesDownload_stream(HttpServletRequest request, HttpServletResponse response, String filePath) {
	                 //get server path (real path)
	                 String realPath = request.getSession().getServletContext().getRealPath(filePath);
	                 File file = new File(realPath);
	                 String filenames = file.getName();
	                 InputStream inputStream;
	                 try {
	                     inputStream = new BufferedInputStream(new FileInputStream(file));
	                     //这个方法可以在读写操作前先得知数据流里有多少个字节可以读取
	                     byte[] buffer = new byte[inputStream.available()];
	                     inputStream.read(buffer);
	                     inputStream.close();
	                     response.reset();
	                     // 先去掉文件名称中的空格,然后转换编码格式为utf-8,保证不出现乱码,这个文件名称用于浏览器的下载框中自动显示的文件名
	                     //服务端向客户端游览器发送文件时，如果是浏览器支持的文件类型，一般会默认使用浏览器打开，比如txt、jpg等，会直接在浏览器中显示，
	                     //如果需要提示用户保存，就要利用Content-Disposition进行一下处理，关键在于一定要加上attachment：
	                     //Response.AppendHeader("Content-Disposition","attachment;filename=FileName.txt");

	                     response.addHeader("Content-Disposition", "attachment;filename=" + new String(filenames.replaceAll(" ", "").getBytes("utf-8"), "iso8859-1"));
	                     response.addHeader("Content-Length", "" + file.length());//发送的长度
	                     OutputStream os = new BufferedOutputStream(response.getOutputStream());
	                     response.setContentType("application/octet-stream");//8进制文件
	                     os.write(buffer);// 输出文件
	                     os.flush();
	                     os.close();
	                 } catch (Exception e) {
	                     e.printStackTrace();
	                 }
	             }



}
