<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
<%@include file="h1.jsp" %>
<div id="message" class="box">
	<h2 style="color:red">��ʾ��Ϣ</h2>
	<div class="content">
		<p>�Բ���${param.msg }������ʧ�ܣ�<a href="VoteServlet?meth=list">���ز鿴ͶƱ�б�&gt;&gt;</a></p>
	</div>
</div>
<%@include file="h2.jsp"%>
</body>
</html>