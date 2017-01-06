<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>首页</title>
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
-->
</style></head>
  
  <body>
	<table width="500" height="195" align="center">
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>
    <form method="post">
    	<table width="500" height="195" align="center" background="images/login.jpg">
    		<tr>
				<td colspan="2">&nbsp;</td>
				<td>${error}</td>
			</tr>	
			<tr>
				<td width="214">&nbsp;</td>
    			<td width="68">用户名：</td>
   			  <td width="202"><input name="name" type="text"></td>
    		</tr>
	    	<tr>
				<td>&nbsp;</td>
    			<td>密码：</td>
	    		<td><input name="pwd" type="password"></td>
    		</tr>
    		<tr>
				<td>&nbsp;</td>
    			<td colspan="2" align="right"><input type="submit" value="登 录">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
    		</tr>
   	  </table>
    </form>
  </body>
</html>
