<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理投票</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript">
var isIE = !!document.all;
function AddOption()
{
	var voteoptions = document.getElementById("voteoptions");
	var _p = document.createElement("p");
	var _input = document.createElement("input");
	_input.type = "text";
	_input.className = "input-text";
	_input.setAttribute("name", "options");
	_p.appendChild(_input);
	var _a = document.createElement("a");
	_a.className = "del";
	_a.setAttribute("href", "javascript:;");
	if(isIE) {
		_a.attachEvent("onclick", DelOption);
	} else {
		_a.addEventListener("click", DelOption, false);
	}
	_a.appendChild(document.createTextNode("删除"));
	_p.appendChild(_a);
	voteoptions.appendChild(_p);
}
function DelOption(e)
{
	if(!e) e = window.event;
	var a = e.srcElement || e.target;
	var obj = a.parentNode;
	obj.parentNode.removeChild(obj);
}
function myDelOption(id){
	var p = document.getElementById(id);
	p.parentNode.removeChild(p);
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

var i = 0;
var oids = new Array();
function oids(id) {
	var oid = document.getElementById(id);
	oids[i] = oid;
	alert(i);
	for(var a = 0;a<oids.length;a++){
	    alert(oids[a]);
	}
	i++;
}

function delOptions(id){
    var xmlhttp = getXMLHTTPRequest();
    var oid = document.getElementById(id);
    var oids = new Array();

    xmlhttp.Open("GET","UserServlet?meth=getRegister?username="+username);
    xmlhttp.onreadystatechange = revert;
    xmlhttp.send(null);
}
function submit(){
    var button = document.getElementById("button");

    button.submit();
}
</script>
</head>
<body>
<script type="text/javascript">

</script>
<%@include file="h1.jsp" %>
<div id="voteManage" class="box">
	<h2>管理投票</h2>
	<div class="content">
	<form method="post" action="VoteServlet?meth=doEdit">
			<dl>
				<dt>投票内容：</dt>
				<dd>
				   <input type="hidden" name="vs_id" value="${Subject.sid }"/>
				   <input type="text" class="input-text" name="title" value="${Subject.stitle }"/>
				</dd>
				<dt>投票类型：</dt>
				<dd>
		  		   <input type="radio" name="type" value="1" ${Subject.stype==1?"checked":"" }/>单选
				   <input type="radio" name="type" value="2" ${Subject.stype==2?"checked":"" }/>多选
				</dd>
				<dt>投票选项：</dt>
				
				<dd id="voteoptions">
				<c:forEach items="${Subject.olist}" var="vo" varStatus="st">
					<p id="${vo.oid }">
					<input type="text" class="input-text" name="options" onblur="" value="${vo.option }"/>
					<c:if test="${st.count>0}">
						<a href="javascript:myDelOption('${vo.oid }')" onclick="oids('${vo.oid}')">删除</a>
					</c:if>					
					</p>
				</c:forEach>
				</dd>
				<dd class="button">
					<input type="image" src="images/button_submit.gif" name="button" id="button"/>
					<a href="javascript:;" onclick="AddOption()">增加选项</a>
					<a href="Subject!list.action">取消操作</a>
				</dd>
				
			</dl>
		</form>
	</div>
</div>
<%@include file="h2.jsp" %>

</body>
</html>

