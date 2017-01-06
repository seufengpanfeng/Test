<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>'updateDept.jsp'</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #F0F4FF;
}
.STYLE3 {
	font-size: 9pt;
	color: #FFFFFF;
}
.STYLE6 {font-size: 10pt}
-->
  </style>
  </head>
  
  <body>
      <table  background="images/23_03.gif" width="755px" height="27px" border="0" align="left" cellpadding="0" cellspacing="0">
    	<tr>
    		<td width="20px">&nbsp;</td>
    		<td><span class="STYLE3">当前位置-&gt;部门信息</span></td>
    	</tr>
  	</table>
  	<br><br>
	<form action="deptOperation.html?method=insertOrUpdateDept" method="post">
    	<table style="position: relative;top:20px;left:40px">
    		<tr>
    			<td height="24"><span class="STYLE6">部门名称：</span></td>
    			<td height="24">
    				<input name="name" type="text" value="${dept.name}">
    				<input name="number" type="hidden" value="${dept.number==null?0:dept.number}">
    			</td>
    		</tr>
    		<tr>
    			<td height="24"><span class="STYLE6">部门成立日期：</span></td>
    			<td height="24"><input name="createDate" type="text" value="${dept.createDate}"></td>
    		</tr>
    		<tr>
    			<td height="24"><span class="STYLE6">部门介绍：</span></td>
    			<td height="24"><input name="remark" type="text" value="${dept.remark}"></td>
    		</tr>
    		<tr>
   			  <td height="24" colspan="2" align="right"><span class="STYLE6">
   			  <input type="submit" value="确定">
   			  &nbsp;&nbsp;</span></td>
    		</tr>
    	</table>
	</form>
  </body>
</html>
