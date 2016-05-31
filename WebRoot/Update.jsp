<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'Update.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
.c1 {
	color:red;
}
</style>
<script type="text/javascript" src="js/jquery-1.9.1.js" ></script>
<script type="text/javascript" >
	//验证
	function check() {
		var name = $("#name").val();
		var regName = /^[a-zA-Z][a-zA-Z0-9]{3,15}$/;
		if (regName.test(name) == false) {
			alert("用户名输入不正确,请重新输入!");
			return false;
		}
		var iphone = $("#iphone").val();
		var regIphone = /^1\d{10}$/;
		if (regIphone.test(iphone) == false) {
			alert("手机号输入不正确,请重新输入!");
			return false;
		}
		var age = $("#age").val();
		var regAge = /^120$|^((1[0-1]|[1-9])?\d)$/;
		if (regAge.test(age) == false) {
			alert("年龄输入不正确,请重新输入!");
			return false;
		}
		var email = $("#email").val();
		var regEmail = /^\w+@\w+.[a-zA-Z]{2,3}(.[a-zA-Z]{2,3})?$/;
		if (regEmail.test(email) == false) {
			alert("邮箱不符合规范,请重新输入!");
			return false;
		}
		return true; //最终都验证完返回 return
	}
	$(function() {
		//绑定获得焦点事件
		//提交订单
		$("#myform").submit(function() {
			return check();
		});
	});
</script>
</head>
<body>
	<form action="Update" method="post" id="myform">
		<table align="center" border="1">
			<tr>
				<td>流水号:&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="id"
					name="id" readonly="readonly" value="${emp.id}"></td>
			</tr>
			<tr>
				<td>用户名称:<input type="text" id="name" name="name"
					value="${emp.name}"><span class="c1">首字必须是字符,后面的必须是字符和数字共4-16位</span></td>
			</tr>
			<tr>
				<td>手机号:&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="iphone"
					name="iphone" value="${emp.iphone}"><span class="c1">首字符为1,后面的十位都是数字</span></td>
			<tr>
				<td>年龄:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
					type="text" id="age" name="age" value="${emp.age}"><span class="c1">必须为0-120的数字</span></td>
			</tr>
			<tr>
				<td>爱好:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="love">
						<option value="">请选择</option>
						<c:forEach items="${str}" var="s">
							<option value="${s}" ${emp.love==s? "selected=selected":""}>${s}</option>
						</c:forEach>
				</select>
				</td>
			</tr>
			<tr>
				<td>邮箱帐号:<input type="text" id="email" name="email"
					value="${emp.email}"><span class="c1">例如:981028102@.com</span></td>
			</tr>
			<tr>
				<td><input style="color: blue" type="submit" value="修改">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="List"><input
						style="color: blue" type="button" value="取消"> </a></td>
			</tr>
		</table>
	</form>
</body>
</html>
