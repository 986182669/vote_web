<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="/css/style.css" />
<%--	<script type="text/javascript" src="/js/jquery.js"></script>--%>
<script type="text/javascript">
    function $(id) {
        return document.getElementById(id);
    }
    function $v(id) {
        return document.getElementById(id).value;
    }
    function checkname(){
        var user = $v("username");
        var divname = $("divname");
        if(user==""||user==null){
			divname.className = "error";
            divname.innerHTML = "用户名不能为空";
        }else {
            divname.innerHTML = "";
        }
    }
    function checkpwd() {
        var password = $v("password")
        var divname2 = $("divname2");
        if (password==""||password==null){
            divname2.className = "error";
            divname2.innerHTML = "密码不能为空";
        }else {
            divname2.innerHTML = "";
		}
    }

    function  getXmlHttpRequest() {
        var xmlHttp;
        if (window.XMLHttpRequest){
            xmlHttp = new XMLHttpRequest();
        }else {
            xmlHttp = new ActiveXObject("Microsoft.XMLHttp");
        }

       return xmlHttp;
    }
    function checkuser() {
		var xhr = getXmlHttpRequest();
		xhr.open("GET","/UserServlet?meth=login",true);
		xhr.onreadystatechange = function () {
		    if(xhr.readyState==4){
		        var a = xhr.responseText;
		        alert(a);
			}
        };
		xhr.send(null);

    }
</script>
	<style type="text/css">
		div.error{
			color: red;
		}

	</style>
</head>
<body>
<div id="header" class="wrap">
	<img src="images/logo.gif" />
</div>
<div id="login" class="wrap">
	<div class="main">
		<div class="corner"></div>
		<div class="introduce">
			<h2></h2>
			<p>网上调查系统...</p>
		</div>
		<div class="login">
			<h2>用户登录</h2>
			<form method="post" action="/UserServlet?meth=login" onsubmit="return false;">
				<dl id="loginBox">
					<dt>用户名：</dt>
					<dd><input type="text" class="input-text" name="username" id="username" onblur="checkname();" /></dd><div id="divname"></div>
					<dt>密　码：</dt>
					<dd><input type="password" class="input-text" name="password" id="password" onblur="checkpwd();" /></dd><div id="divname2"></div>
					<dt></dt>
					<dd><input type="submit" class="input-button" value="登录" onclick="checkuser();"/> <a href="/reg">新用户注册</a></dd>
					<<input type="button" value="ajax" onclick="checkuser();">
				<%--	<dd>
						<input type="text" class="input-text" id="imageCode"/>
						<img src="/UserServlet?meth=imageCode" alt="验证码" id="checkimgcode"/><a href="javaScript:change();">看不清楚</a>
					</dd>--%>
				</dl>
			</form>
			<div class="error"></div>
		</div>
	</div>
</div>
<div class="wrap">
</div>
<%@include file="WEB-INF/jsp/h2.jsp" %>
</body>
</html>
