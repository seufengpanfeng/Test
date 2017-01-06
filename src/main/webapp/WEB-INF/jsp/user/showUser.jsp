<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>显视所有用户</title>
		<style type="text/css">
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #F0F4FF;
}
.STYLE1 {
	color: #FFFFFF;
	font-size: 9pt;
}
</style>
		
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
	<body>
		<table background="images/23_03.gif" width="755px" height="27px"
			border="0" align="left" cellpadding="0" cellspacing="0">
			<tr>
				<td width="20px">&nbsp;</td>
				<td>
					<span class="STYLE1">当前位置-&gt;用户管理首页</span>
				</td>
			</tr>
		</table>
		<br>
		<br>
		<table width="755px" height="48">
			<tr>
				<td align="center">
					<a href="userOperation.html?method=findById">创建新用户</a>
				</td>
			</tr>
		</table>
		
	
		<table width="730" border="0" cellspacing="1" bgcolor="#999999">
			<c:forEach items="${list}" var="item" varStatus="i">
				<tr>
					<td width="128" height="128" rowspan="5" align="center"
						valign="middle" bgcolor="#F0F4FF">
						
						  <img src="${item[0].face}" width="100" height="100">
						
					</td>
					<td height="23" colspan="3" align="right" bgcolor="#F0F4FF">
						<a href="userOperation.html?method=findById&number=${item[0].number}">修改</a>
						&nbsp;&nbsp;
						<a href="userOperation.html?method=deleteUser&number=${item[0].number}">删除</a>
						&nbsp;&nbsp;&nbsp;
					</td>
					
				</tr>
				
				<tr>
					<td height="23" bgcolor="#F0F4FF">
						用户编号：
						<c:out value="${item[0].number}" />
					</td>
					<td height="23" bgcolor="#F0F4FF">
						登录帐号：
						<c:out value="${item[0].id}" />
					</td>
					<td height="23" bgcolor="#F0F4FF">
						登录密码：
						<c:out value="${item[0].pwd}" />
					</td>
				</tr>
				<tr>
					<td height="23" bgcolor="#F0F4FF">
						用户姓名：
						<c:out value="${item[0].name}" />
					</td>
					<td height="23" bgcolor="#F0F4FF">
						用户性别：
						<c:out value="${item[0].sex}" />
					</td>
					<td height="23" bgcolor="#F0F4FF">
						出生日期：
						<c:out value="${item[0].birthday}" />
					</td>
				</tr>
				<tr>
					<td height="23" bgcolor="#F0F4FF">
						入职日期：
						<c:out value="${item[0].come}" />
					</td>
					<td height="23" bgcolor="#F0F4FF">
						所属部门：
						<c:out value="${item[1].name}" />
					</td>
					<td height="23" bgcolor="#F0F4FF">
						电子邮箱：
						<c:out value="${item[0].email}" />
					</td>
				</tr>
				<tr>
					
					<td height="23" colspan="3" bgcolor="#F0F4FF">
						个人介绍：
						<c:out value="${item[0].remark}" />
					</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>
