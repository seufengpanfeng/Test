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
.STYLE2 {font-size: 9pt}
.STYLE4 {font-size: 9pt; color: #FFFFFF; }
</style>
		<script type="text/javascript">
	function testFileType(file) {
		var fileName = file.value.substr(file.value.lastIndexOf("."))
				.toUpperCase();
		var username=document.f1.name.value;
		if (fileName != ".JPG" && fileName != ".BMP" && fileName != ".GIF") {
			alert("上传的图片只支持BMP,JPG,GIF格式");
			file.outerHTML = file.outerHTML;
		}
	}
	function check() {
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
		
		if (document.f1.email.indexOf("@",0)==-1) {
			alert("电子邮箱格式不正确");
			document.f1.email.focus();
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
		if (document.f1.file.value == "" || document.f1.file.value == null) {
			alert("用户头像不能为空");
			document.f1.file.focus();
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
					<span class="STYLE4">当前位置-&gt;创建新用户</span>				</td>
			</tr>
		</table>
		<br><br>
		<form name="f1" action="userOperation.html?method=insertUser"
			method="post" enctype="multipart/form-data" onSubmit="return check()">
			<table style="position:relative;top:20px;left:70px;" width="540px" border="0" cellspacing="1" bgcolor="#999999">
				<tr>
					<td height="32" bgcolor="#F0F4FF"><div align="center"><span class="STYLE2">
					  登录帐号：					</span></div></td>
					<td bgcolor="#F0F4FF">
						<span class="STYLE2">&nbsp;
						<input type="text" name="id" id="id">
				        </span></td>
					<td bgcolor="#F0F4FF"><span class="STYLE2">
					  6-10位英文字母或数字					</span></td>
				</tr>
				<tr>
					<td height="32" bgcolor="#F0F4FF"><div align="center"><span class="STYLE2">
					  登录密码：					</span></div></td>
					<td bgcolor="#F0F4FF">
						<span class="STYLE2">&nbsp;
						<input type="text" name="pwd" id="pwd">
				        </span></td>
					<td bgcolor="#F0F4FF"><span class="STYLE2">
					  6-10位英文字母或数字					</span></td>
				</tr>
				<tr>
					<td height="32" bgcolor="#F0F4FF"><div align="center"><span class="STYLE2">
					  用户姓名：					</span></div></td>
					<td bgcolor="#F0F4FF">
						<span class="STYLE2">&nbsp;
						<input type="text" name="name" id="name">
				        </span></td>
					<td bgcolor="#F0F4FF"><span class="STYLE2">
					  10位以内中文					</span></td>
				</tr>
				<!--下面是新加的-->
				<tr>
					<td height="32" bgcolor="#F0F4FF"><div align="center"><span class="STYLE2">
					  用户邮箱：					</span></div></td>
					<td bgcolor="#F0F4FF">
						<span class="STYLE2">&nbsp;
						<input type="text" name="email" id="email">
				        </span></td>
					<td bgcolor="#F0F4FF"><span class="STYLE2">
					  输入合法的邮箱					</span></td>
				</tr>
				<tr>
					<td height="32" bgcolor="#F0F4FF"><div align="center"><span class="STYLE2">
					  用户性别：					</span></div></td>
					<td bgcolor="#F0F4FF">
						<span class="STYLE2">
						<input type="radio" value="男" name="sex">
						男
						<input type="radio" value="女" name="sex">
				  女		          </span></td>
					<td bgcolor="#F0F4FF"><span class="STYLE2">
					  选择用户性别					</span></td>
				</tr>
				<tr>
					<td height="32" bgcolor="#F0F4FF"><div align="center"><span class="STYLE2">
					  出生日期：					</span></div></td>
					<td bgcolor="#F0F4FF">
						<span class="STYLE2">&nbsp;
						<input type="text" name="birthday">
				        </span></td>
					<td bgcolor="#F0F4FF"><span class="STYLE2">
					  格式：YYYY-MM-DD					</span></td>
				</tr>
				<tr>
					<td height="32" bgcolor="#F0F4FF"><div align="center"><span class="STYLE2">
					  入职日期：					</span></div></td>
					<td bgcolor="#F0F4FF">
						<span class="STYLE2">&nbsp;
						<input type="text" name="come">
				        </span></td>
					<td bgcolor="#F0F4FF"><span class="STYLE2">
					  格式：YYYY-MM-DD					</span></td>
				</tr>
				<tr>
					<td height="32" bgcolor="#F0F4FF"><div align="center"><span class="STYLE2">
					  所属部门：					</span></div></td>
					<td bgcolor="#F0F4FF">
						<span class="STYLE2">&nbsp;
						<select name="dept">
						  <option value="0">
						    选择部门...					      </option>
						  <c:forEach items="${map}" var="item" varStatus="i">
						    <option value="${item.number}">
						      ${item.name}					        </option>
					      </c:forEach>
					    </select>
				        </span></td>
					<td bgcolor="#F0F4FF"><span class="STYLE2">
					  选择所在部门					</span></td>
				</tr>
				<tr>
					<td height="32" bgcolor="#F0F4FF"><div align="center"><span class="STYLE2">
					  用户照片：					</span></div></td>
					<td colspan="2" bgcolor="#F0F4FF">
						<span class="STYLE2">&nbsp;
						<input type="file" name="file" onChange="testFileType(this)">
				        </span></td>
				</tr>
				<tr>
					<td bgcolor="#F0F4FF"><div align="center"><span class="STYLE2">
					  个人简介：					</span></div></td>
					<td colspan="2" bgcolor="#F0F4FF">
						<span class="STYLE2">&nbsp;
						<textarea name="remark" cols="40" rows="5" id="remark"></textarea>
				        </span></td>
				</tr>
				<tr>
					<td height="32" colspan="3" align="center" bgcolor="#F0F4FF">
						<span class="STYLE2">
                        <input type="submit" value="确定">
&nbsp;&nbsp;
						<input type="reset" value="重置">
		          </span></td>
				</tr>
		  </table>
		</form>
	</body>
</html>
