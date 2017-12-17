<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>参与投票</title>
<link type="text/css" rel="stylesheet" href="../../../../li/vote/WebRoot/css/style.css" />
</head>
<body>
<%@include file="../../../../li/vote/WebRoot/h1.jsp" %>
<div id="vote" class="wrap">
	<h2>参与投票</h2>
	<ul class="list">
		<li>
			<h4>${param.title}</h4>
			<p class="info">共有 ${param.ocount}个选项，已有 ${param.ucount}亿 个网友参与了投票。</p>
			<form method="post" action="">
			    <input type="hidden" name="entityId" value="${param.vs_id }"/> 
				<ol>
				<c:forEach items="${list}" var="vote">
					<li><input type="${param.type=1?'radio':'checkbox' }" name="options"  value="${vote.vo_id }"/>${vote.vo_option}</li>
				</c:forEach>
				</ol>
				<p class="voteView"><input type="image" src="../../../../li/vote/WebRoot/images/button_vote.gif" /><a href="Vote!view.action?entityId=<s:property value='subject.id'/>"><img src="../../../../li/vote/WebRoot/images/button_view.gif" /></a></p>
			</form>
		</li>
	</ul>
</div>
<%@include file="../../../../li/vote/WebRoot/h2.jsp" %>
</body>
</html>
