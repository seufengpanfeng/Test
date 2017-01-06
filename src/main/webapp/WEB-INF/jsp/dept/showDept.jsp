<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>显示所有部门</title>
<style type="text/css">
<!--
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
.STYLE3 {font-size: 9pt; }
.STYLE5 {font-size: 9pt; font-weight: bold; }
-->
  </style>
  </head>
  
  <body>
    <table background="images/23_03.gif" width="755px" height="27px" border="0" align="left" cellpadding="0" cellspacing="0">
    	<tr>
    		<td width="20px">&nbsp;</td>
    		<td><span class="STYLE1">当前位置-&gt;部门管理首页</span></td>
    	</tr>
  	</table>
  	<br>
  	<br>
	<table width="775">
		<tr>
			<td height="40" align="center"><a href="insertOrUpdateDept.html">创建新部门</a></td>
		</tr>
	</table>
	<table  style="position: relative;top: 0px;left: 50px" width="650" border="1" cellpadding="0" cellspacing="1" bordercolor="#F0F4FF" bgcolor="#999999">
        <tr>
          <td height="24" bgcolor="#F0F4FF"><div align="center" class="STYLE5">部门编号</div></td>
          <td bgcolor="#F0F4FF"><div align="center" class="STYLE5">部门名称</div></td>
          <td bgcolor="#F0F4FF"><div align="center" class="STYLE5">部门成立日期</div></td>
          <td bgcolor="#F0F4FF"><div align="center" class="STYLE5">部门介绍</div></td>
          <td bgcolor="#F0F4FF"><div align="center" class="STYLE5">操作</div></td>
        </tr>
        <c:forEach items="${list}" var="item" varStatus="i">
          <tr>
            <td height="24" bgcolor="#F0F4FF"><div align="center" class="STYLE3">
              <c:out value="${item.number}"/>
            </div></td>
            <td bgcolor="#F0F4FF"><div align="center" class="STYLE3">
              <c:out value="${item.name}"/>
            </div></td>
            <td bgcolor="#F0F4FF"><div align="center" class="STYLE3">
              <c:out value="${item.createDate}"/>
            </div></td>
            <td bgcolor="#F0F4FF"><div align="center" class="STYLE3">
              <c:out value="${item.remark}"/>
            </div></td>
            <td bgcolor="#F0F4FF"><div align="center" class="STYLE3">
            	<a href="deptOperation.html?method=findById&number=${item.number}">修改</a>&nbsp;&nbsp;
            	<a href="deptOperation.html?method=deleteDept&number=${item.number}">删除</a></div></td>
          </tr>
        </c:forEach>
  </table>
  </body>
</html>
