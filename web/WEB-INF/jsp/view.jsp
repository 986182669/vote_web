<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
<%@include file="h1.jsp" %>
<div id="vote" class="wrap">
	<h2>查看投票</h2>
	<ul class="list">
		<li>
			<h4>${param.vs_title }</h4>
			<p class="info">共有 ${param.ocount } 个选项，已有 ${param.ucount }个网友参与了投票。</p>
				<ol>
				<c:forEach items="${olist}" var="vb">
					<li>${vb.option}
						<div class="rate">
							<div class="ratebg"><div class="percent" style="width:${vb.percent}%"></div></div>
							<p>${vb.count }票<span>(${vb.percent }%)</span></p>
						</div>
					</li>
					</c:forEach>
				</ol>
				<div class="goback"><a href="vote.jsp">返回投票列表</a></div>
		</li>
	</ul>
</div>
<%@include file="h2.jsp" %>
</body>
</html>
