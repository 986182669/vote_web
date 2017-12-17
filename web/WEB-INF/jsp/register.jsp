<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注   册</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />

<script src="Calendar3.js" type="text/javascript"></script>
<script type="text/javascript">
	
	function checkname(){
		var uname = document.getElementById("username").value;
		var msg = document.getElementById("msg");
		
		msg.innerHTML = "";
		if(uname==""){
			msg.innerText = "用户名不能为空";
			return false;	
		}
		return true;
	}
	function checkpassword(){
		var password = document.getElementById("password").value;
		var msg = document.getElementById("msg");
		msg.innerHTML = "";
		if(password==""){
			msg.innerText = "密码不能为空";
			return false;
		}
		return true;
		
	}
	function checkpassword2(){
		var password = document.getElementById("password").value;
		var password2 = document.getElementById("password2").value;
		var msg = document.getElementById("msg");
		msg.innerHTML = "";
		if(password!=password2){
			msg.innerText = "两次密码不一致";
			return false;
		}
		return true;
	}
	function check(){
		var uname = document.getElementById("username").value;
		var password = document.getElementById("password").value;
		var password2 = document.getElementById("password2").value;
		var msg = document.getElementById("msg");
		msg.innerHTML = "";
		if(uname==""){
			msg.innerText = "用户名不能为空";
			return false;	
		}
		msg.innerHTML = "";
		if(password==""){
			msg.innerText = "密码不能为空";
			return false;
		}
		msg.innerHTML = "";
		if(password!=password2){
			msg.innerText = "两次密码不一致";
			return false;
		}
		return true;
	}
	var xmlhttp = false;
	function getXMLHTTPRequest() { 
		var xmlhttp; 
		try{ 
			xmlhttp=new XMLHttpRequest(); 
		} catch (e) { 
// 			Internet Explorer 
		try { 
			xmlhttp=new ActiveXObject("Msxml2.XMLHTTP"); 
			}catch (e) 	{ 
				try { 
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
				} catch (e) { 
					alert("您的浏览器不支持AJAX！"); 
					return false; 
				} 
			} 
		} 
	}

	
	function transmit(){
		var xmlhttp = getXMLHTTPRequest();
		var username = document.getElementById("username").value;
		xmlhttp.Open("GET","UserServlet?meth=getRegister?username="+username);
		xmlhttp.onreadystatechange = revert;
		xmlhttp.send(null);
	}
	function revert(){
		var msg = document.getElementById("msg");
		if (xmlhttp.readyState == 4) {
			var err = document.getElementById("err");
			alert(err);
			if (err==0) {
				msg.innerHTML = "&lt;span style='color1:red;>&lt;/span>";
			}else{
				msg.innerHTML = "&lt;spen style='color:green;'>用户可用&lt;/spen>";
			}
		}
	}
</script>
</head>
<body>
<%@include file="h1.jsp" %>
<div id="register" class="box">
	<h2>新用户注册</h2>
	<div class="content">
	   <form method="post" onsubmit="return check();" action="UserServlet?meth=reg" >
			<dl>
				<dt >用户名：</dt>
				<dd><input type="text" class="input-text" name="username" id="username" onblur="checkname();" onkeyup="transmit();" /></dd>
				<dt>密码：</dt>
				<dd><input type="password" class="input-text" name="password" id="password" onblur="checkpassword();"/></dd>
				<dt>确认密码：</dt>
				<dd><input type="password" class="input-text" name="password2" id="password2" onblur="checkpassword2();"/></dd>
				<dt >年輪：</dt>
					<dd><input type="text" class="input-text" name="age" id="age"/></dd>
    			<dt >性別：</dt>
				<dd><input type="radio"  name="sex" id="sex" value="1"/>男
					<input type="radio"  name="sex" id="sex" value="0"/>女
				</dd>
				<dt >手机号码：</dt>
				<dd><input type="text" class="input-text" name="tel" id="tel"  /></dd>
				
			<%--	<dt >出生日期：</dt>
				<dd><input name="control_date2" type="text" id="control_date2" size="10"
                       maxlength="10" onclick="new Calendar().show(this);" readonly="readonly" /></dd>--%>
				<dt >愛好：</dt>
				<dd><input type="text" class="input-text" name="hobbies" id="hobbies" onblur="checkname();" onkeyup="transmit();" /></dd>
				
				<dt ></dt>
			
				<dd><input type="text" class="input-text" name="hobbies" id="hobbies" onblur="checkname();" onkeyup="transmit();" /></dd>
				
				<dt></dt>
				<dd><input type="submit" class="input-button" name="submit" value="" /></dd>
			</dl>
		</form>
		<div class="err" id="msg">${param.err}</div>
	</div>
</div>
<%@include file="h2.jsp" %>
</body>
</html>
