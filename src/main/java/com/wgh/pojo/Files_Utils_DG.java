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
	 * ���캯��
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
			              //get files suffix,getOriginalFilename()ȡ���ϴ�ʱ���ļ��������ص��ļ���
			              String suffix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
			              //filePath+fileName the complex file Name
			              
			              String absolutePath = getAndSetAbsolutePath(request, filePath, suffix);
			              //return relative Path
			             // String relativePath = getRelativePath(filePath, suffix);
			              String relativePath = "E:\\ABC";
			             System.out.println("����λ��"+absolutePath);
			             System.out.println("���λ��"+getServerPath(request, filePath));
			              try {
			                  //save file
			                  multipartFile.transferTo(new File(absolutePath));//���ϴ����ļ�д��ָ��λ��
			                  System.out.println("�ɹ���");
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
     //return server absolute path��real path��
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
	    	 System.out.println("�����ļ���");
	              File dir = new File(savePath);
	              if (!dir.exists() || !dir.isDirectory()) {
	            	  System.out.println("�����ļ��гɹ���");
	                  dir.mkdir();
	              }
	          }
	     	
	     
	         //return an UUID Name parameter (suffix cover '.') example�� ".jpg"��".txt"
	         public static String getUUIDName(String suffix) {
	              return UUID.randomUUID().toString() + suffix;// make new file name
	          }

	          
	              //return server absolute path��real path�� the style is  ��server absolute path/DataPath/UUIDName��filePath example "/files/Upload"
	      //��windows��File.separator����\
	         public static String getAndSetAbsolutePath(HttpServletRequest request, String filePath, String suffix) {
	         //String savePath = getServerPath(request, filePath) + File.separator + getDataPath() + File.separator;//example:F:/qixiao/files/Upload/20160912/
	         String savePath = "E:\\IMAGE"+ File.separator + getDataPath() + File.separator;
	         //  String savePath= "e:/tupian/files"; 
	    	  checkDir(savePath);//check if the path has exist if not create it
	              return savePath + getUUIDName(suffix);
	            }
	        
	          
	               
	                  //get the relative path of files style is ��/filePath/DataPath/UUIDName��filePath example "/files/Upload"
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
	                     //������������ڶ�д����ǰ�ȵ�֪���������ж��ٸ��ֽڿ��Զ�ȡ
	                     byte[] buffer = new byte[inputStream.available()];
	                     inputStream.read(buffer);
	                     inputStream.close();
	                     response.reset();
	                     // ��ȥ���ļ������еĿո�,Ȼ��ת�������ʽΪutf-8,��֤����������,����ļ�������������������ؿ����Զ���ʾ���ļ���
	                     //�������ͻ��������������ļ�ʱ������������֧�ֵ��ļ����ͣ�һ���Ĭ��ʹ��������򿪣�����txt��jpg�ȣ���ֱ�������������ʾ��
	                     //�����Ҫ��ʾ�û����棬��Ҫ����Content-Disposition����һ�´����ؼ�����һ��Ҫ����attachment��
	                     //Response.AppendHeader("Content-Disposition","attachment;filename=FileName.txt");

	                     response.addHeader("Content-Disposition", "attachment;filename=" + new String(filenames.replaceAll(" ", "").getBytes("utf-8"), "iso8859-1"));
	                     response.addHeader("Content-Length", "" + file.length());//���͵ĳ���
	                     OutputStream os = new BufferedOutputStream(response.getOutputStream());
	                     response.setContentType("application/octet-stream");//8�����ļ�
	                     os.write(buffer);// ����ļ�
	                     os.flush();
	                     os.close();
	                 } catch (Exception e) {
	                     e.printStackTrace();
	                 }
	             }



}
