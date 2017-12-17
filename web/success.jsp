<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
<%@include file="/WEB-INF/jsp/h1.jsp" %>
<div id="message" class="box">
	<h2>提示信息</h2>
	<div class="content">
		<p>恭喜：${param.msg }操作成功！<a href="VoteServlet?meth=getListAll">返回查看投票列表&gt;&gt;</a></p>
	</div>
</div>
<%@include file="/WEB-INF/jsp/h2.jsp" %>
</body>
</html>