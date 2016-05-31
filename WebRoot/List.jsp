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

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript">
	function update(id){
	  	if(confirm("是否修改?")){
			location.href="ToUpdate?id="+id;
		}
	}
</script>
</head>
<body>
	<table align="center" border="1">
		<tr>
			<td>流水号</td>
			<td>用户名称</td>
			<td>手机号</td>
			<td>年龄</td>
			<td>爱好</td>
			<td>邮箱</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${list}" var="list">
			<tr>
				<td>${list.id }</td>
				<td>${list.name }</td>
				<td>${list.iphone }</td>
				<td>${list.age }</td>
				<td>${list.love }</td>
				<td>${list.email }</td>
				<td><input type="button" value="修改" onclick="update(${list.id})" />
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
