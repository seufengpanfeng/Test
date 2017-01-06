<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>普通用户登录</title>
    <!--
	<link rel="stylesheet" type="text/css" href="styles.css">
    -->
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE6 {font-size: 9pt; color: #000000; }
-->
  </style></head>
  
  <body>
  <table width="765" height="710" align="center" background="images/userInfo.jpg">
  	<tr>
		<td>
			<div>
				    <table width="500" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#000000">
      <tr>
        <td height="24" colspan="5" align="center" bgcolor="#FFFFFF"><span class="STYLE6">用户信息</span></td>
      </tr>
      <tr>
        <td height="24" rowspan="4" align="center" valign="middle" bgcolor="#FFFFFF"><img src="face/${map.user.face}"  width="100" height="100"/></td>
        <td height="24" bgcolor="#FFFFFF"><span class="STYLE6">用户姓名：</span></td>
        <td height="24" bgcolor="#FFFFFF"><span class="STYLE6">${map.user.name}</span></td>
        <td height="24" bgcolor="#FFFFFF"><span class="STYLE6">用户性别：</span></td>
        <td height="24" bgcolor="#FFFFFF"><span class="STYLE6">${map.user.sex}</span></td>
      </tr>
      <tr>
        <td height="24" bgcolor="#FFFFFF"><span class="STYLE6">出生日期：</span></td>
        <td height="24" bgcolor="#FFFFFF"><span class="STYLE6">${map.user.birthday}</span></td>
        <td height="24" bgcolor="#FFFFFF"><span class="STYLE6">入职日期：</span></td>
        <td height="24" bgcolor="#FFFFFF"><span class="STYLE6">${map.user.come}</span></td>
      </tr>
      <tr>
        <td height="24" bgcolor="#FFFFFF"><span class="STYLE6">个人简介：</span></td>
        <td height="24" colspan="3" bgcolor="#FFFFFF"><span class="STYLE6">${map.user.remark}</span></td>
      </tr>
  </table><br>
    <table width="500" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#000000">
      <tr>
        <td height="24" colspan="4" align="center" bgcolor="#FFFFFF" class="STYLE6">所在部门信息</td>
      </tr>
      <tr>
        <td height="24" bgcolor="#FFFFFF" class="STYLE6">部门名称：</td>
        <td height="24" bgcolor="#FFFFFF" class="STYLE6">${map.dept.name}</td>
        <td height="24" bgcolor="#FFFFFF" class="STYLE6">建立时间：</td>
        <td height="24" bgcolor="#FFFFFF" class="STYLE6">${map.dept.createDate}</td>
      </tr>
      <tr>
        <td height="24" bgcolor="#FFFFFF" class="STYLE6">部门介绍：</td>
        <td height="24" colspan="3" bgcolor="#FFFFFF" class="STYLE6">${map.dept.remark}</td>
      </tr>
  </table><br>
    <center><a href="index.html">退出</a></center>
			</div>
		</td>
	</tr>
  </table>
  </body>
</html>
