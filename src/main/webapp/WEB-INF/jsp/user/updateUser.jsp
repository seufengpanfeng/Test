<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>'insertUser.jsp'</title>
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
		<script type="text/javascript">
	function testFileType(file) {
		var fileName = file.value.substr(file.value.lastIndexOf("."))
				.toUpperCase();
		
		if (fileName != ".JPG" && fileName != ".BMP" && fileName != ".GIF") {
			alert("上传的图片只支持BMP,JPG,GIF格式");
			file.outerHTML = file.outerHTML;
		}
	}
	function check() {
		
		var username=document.f1.name.value;
		var pattern = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/; 
		chkFlag = pattern.test(document.f1.email.value); 
		
		if (document.f1.id.value == "" || document.f1.id.value == null) {
			alert("登录帐号不能为空");
			document.f1.id.focus();
			return false;
		}
		if (document.f1.pwd.value == "" || document.f1.pwd.value == null) {
			alert("登录密码不能为空");
			document.f1.pwd.focus();
			return false;
		}
		if (document.f1.name.value == "" || document.f1.name.value == null) {
			alert("用户姓名不能为空");
			document.f1.name.focus();
			return false;
		}
		if (username.length!=0) {
			for(i=0;i<username.length;i++){
				var ftext=username.substring(i,i+1);
			if(ftext<9 || ftext>0  ){
					
					alert("用户姓名包含数字\n"+"请删除名字中的数字和特殊字符");
					document.f1.name.focus();
					return false;
				}
			
			}
			
			
		}
		if (document.f1.email.value == "" || document.f1.email.value == null) {
			alert("电子邮箱名不能为空");
			document.f1.email.focus();
			return false;
		}
		if (!chkFlag) {
			alert("电子邮箱格式不正确");
			//document.getElementById("email").innerHTML="<font color=red>邮箱格式不正确。正确的例如abc@163.com</font>"; 
			document.f1.email.focus();
			document.getElementById("email").innerHTML="<font color=red>邮箱格式不正确。正确的例如abc@163.com</font>"; 
			return false;
		}
		if (!document.f1.sex[0].checked && !document.f1.sex[1].checked) {
			alert("用户性别不能为空");
			return false;
		}
		if (document.f1.birthday.value == ""
				|| document.f1.birthday.value == null) {
			alert("出生日期不能为空");
			document.f1.birthday.focus();
			return false;
		}
		if (document.f1.come.value == "" || document.f1.come.value == null) {
			alert("入职日期不能为空");
			document.f1.come.focus();
			return false;
		}
		if (document.f1.dept.value == "0") {
			alert("请选择所属部门");
			document.f1.dept.focus();
			return false;
		}
		if (document.f1.remark.value == "" || document.f1.remark.value == null) {
			alert("用户简介不能为空");
			document.f1.remark.focus();
			return false;
		}
		return true;
	}
</script>
	</head>

	<body>
	<table background="images/23_03.gif" width="755px" height="27px"
			border="0" align="left" cellpadding="0" cellspacing="0">
			<tr>
				<td width="20px">&nbsp;
					
			  </td>
				<td>
					<span class="STYLE4 STYLE1">当前位置-&gt;修改用户信息</span>				</td>
			</tr>
		</table>
		<br><br>
		<form name="f1" action="userOperation.html?method=updateUser"
			 enctype="multipart/form-data" onsubmit="return check();" method="post">
			<table width="540px" cellspacing="1" bgcolor="#999999" style="position:relative; top:20px; left:40px">
				<tr>
					<td height="32" bgcolor="#F0F4FF">
				  <div align="center">登录帐号：					</div></td>
					<td height="32" bgcolor="#F0F4FF">
						&nbsp;
						<input type="text" name="id" id="id" value="${map.user.id}"
							readonly="readonly">
						<input type="hidden" name="number" value="${map.user.number}">
				  <input type="hidden" name="face" value="${map.user.face}">					</td>
					<td height="32" bgcolor="#F0F4FF">
						该项不可以修改					</td>
				</tr>
				<tr>
					<td height="32" bgcolor="#F0F4FF">
				  <div align="center">登录密码：					</div></td>
					<td height="32" bgcolor="#F0F4FF">
						&nbsp;
				  <input type="text" name="pwd" id="pwd" value="${map.user.pwd}">					</td>
					<td height="32" bgcolor="#F0F4FF">
						6-10位英文字母或数字					</td>
				</tr>
				<tr>
					<td height="32" bgcolor="#F0F4FF">
				  <div align="center">用户姓名：					</div></td>
					<td height="32" bgcolor="#F0F4FF">
						&nbsp;
				  <input type="text" name="name" id="name" value="${map.user.name}">					</td>
					<td height="32" bgcolor="#F0F4FF">
						10位以内中文					</td>
				</tr>
				<tr>
					<td height="32" bgcolor="#F0F4FF">
				  <div align="center">用户性别：					</div></td>
					<td height="32" bgcolor="#F0F4FF">
						<input type="radio" value="男" name="sex">
						男
						<input type="radio" value="女" name="sex">
						女
				  <script type="text/javascript">
	if ("男" == "${map.user.sex}") {
		document.f1.sex[0].checked = 'checked';
	} else {
		document.f1.sex[1].checked = 'checked';
	}
</script>					</td>
					<td height="32" bgcolor="#F0F4FF">
						选择用户性别					</td>
				</tr>
				<tr>
					<td height="32" bgcolor="#F0F4FF">
				  <div align="center">电子邮箱：					</div></td>
					<td height="32" bgcolor="#F0F4FF">
						&nbsp;
				  <input type="text" name="email" value="${map.user.email}">					</td>
					<td height="32" bgcolor="#F0F4FF">
						电子邮箱				</td>
				</tr>
				<tr>
					<td height="32" bgcolor="#F0F4FF">
				  <div align="center">出生日期：					</div></td>
					<td height="32" bgcolor="#F0F4FF">
						&nbsp;
				  <input type="text" name="birthday" value="${map.user.birthday}">					</td>
					<td height="32" bgcolor="#F0F4FF">
						格式：YYYY-MM-DD					</td>
				</tr>
				<tr>
					<td height="32" bgcolor="#F0F4FF">
				  <div align="center">入职日期：					</div></td>
					<td height="32" bgcolor="#F0F4FF">
						&nbsp;
				  <input type="text" name="come" value="${map.user.come}">					</td>
					<td height="32" bgcolor="#F0F4FF">
						格式：YYYY-MM-DD					</td>
				</tr>
				<tr>
					<td height="32" bgcolor="#F0F4FF">
				  <div align="center">所属部门：					</div></td>
					<td height="32" bgcolor="#F0F4FF">
						&nbsp;
						<select name="dept">
							<option value="0">
								选择部门...							</option>
							<c:forEach items="${map.list}" var="item" varStatus="i">
								<option value="${item.number}">
									${item.name}								</option>
							</c:forEach>
						</select>
				  <script type="text/javascript">
	document.f1.dept.value = "${map.user.dept}";
</script>					</td>
					<td height="32" bgcolor="#F0F4FF">
						选择所在部门					</td>
				</tr>
				<tr>
					<td height="32" bgcolor="#F0F4FF">
				  <div align="center">用户照片：					</div></td>
					<td height="32" colspan="2" bgcolor="#F0F4FF">
						&nbsp;
				  <input type="file" name="file" onChange="testFileType(this)"
							value="${map.user.face}">					</td>
				</tr>
				<tr>
					<td height="32" bgcolor="#F0F4FF">
				  <div align="center">个人简介：</div></td>
					<td height="32" colspan="2" bgcolor="#F0F4FF">&nbsp;
				  <textarea name="remark" cols="40" rows="5" id="remark">${map.user.remark}</textarea>					</td>
				</tr>
				<tr>
					<td height="32" colspan="3" align="center" bgcolor="#F0F4FF">
						<input type="submit" value="确定" >&nbsp;&nbsp;
				  		<input type="reset" value="重置">
				    </td>
				</tr>
		  </table>
		</form>
	</body>
</html>
