<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理投票</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
<%@include file="h1.jsp" %>
<div id="vote" class="wrap">
	<h2>投票列表</h2>

	<ul class="list">
		<c:forEach items="${list}" var="vote" varStatus="st">
			<li class="${st.index%2==0?'':'odd'}">
				<h4>
					<em><a href="VoteServlet?meth=toEdit&sid=${vote.sid }&stitle=${vote.stitle}&stype=${vote.stype}">维护</a></em>
					<a href="VoteServlet?meth=toManager&sid=${vote.sid }&stype=${vote.stype}&stitle=${vote.stitle}&ocount=${vote.optionCount}&ucount=${vote.userCount}">${vote.stitle}</a>
				</h4>
				<p class="info">共有${vote.optionCount}个选项，已有 ${vote.userCount}个网友参与了投票。</p>
			</li>
		</c:forEach>
	</ul>
	<%--
	<ul class="list">
	<c:forEach items="${list}" var="vote" varStatus="st">
		<li class="${st.index%2==0?'':'odd'}">
			<h4>
				<em><a href="VoteServlet?meth=toEdit&vs_id=${vote.sid }">维护</a></em>
				<a href="VoteServlet?meth=toManager&vs_id=${vote.sid }&type=${vote.stype}&title=${vote.stitle}&ocount=${vote.optionCount}&ucount=${vote.userCount}">${vote.stitle}</a>
			</h4>
			<p class="info">共有${vote.optionCount}个选项，已有 ${vote.userCount}个网友参与了投票。</p>
		</li>
		</c:forEach>
	</ul>--%>
</div>
<%@include file="h2.jsp" %>
</body>
</html>
