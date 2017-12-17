<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<div id="header" class="wrap">
	<img src="images/logo.gif" />
</div>
<div id="navbar" class="wrap">
	<div class="profile">
		您好，${empty sessionScope.User ? "<a href='login.jsp'>请登录</a>" : sessionScope.User.uname}
		<span class=""></span>
		<span class="return"><a href="VoteServlet?meth=getListAll">返回列表</a></span>
		<%--<span class="addnew"><a href="/addVote">添加新投票</a></span>--%>
		<span class="addnew"><a href="/addVote?meth=addVote">添加新投票</a></span>
		<span class="modify"><a href="VoteServlet?meth=toManage">维护</a></span>
		<span class="inin"><a href="UserServlet?meth=retreatsafely">安全退出</a></span>
	</div>
	<div id="navbar" class="wrap">
	<div class="search">
		<form method="post" action="VoteServlet?meth=list">
			<input type="text" name="title" class="input-text" value="${param.title }"/>
			<input type="submit" name="submit" class="input-button" value="" />
		</form>
	</div>
</div>