<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>发布新投票</title>
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
function cancel() {
    var title = document.getElementById("title");
	var type = document.getElementsByName("type");

	var options = document.getElementsByName("options");
    for(var i=0;i < options.length; i++) {
     	options[i].value = "";
    }
	type[0].checked = true;
    title.value = "";

}
</script>
</head>
<body>
<%@include file="h1.jsp" %>
<div id="voteManage" class="box">
	<h2>添加新投票</h2>
	<div class="content">
	<form method="post" action="VoteServlet?meth=addNewVote">
			<dl>
				<dt>投票内容：</dt>
				<dd>
				   <input type="hidden" name="vs_id"/>
				   <input type="text" class="input-text" name="title" id="title"/>
				</dd>
				<dt>投票类型：</dt>
				<dd>
		  		   <input type="radio" name="type" checked="checked" value="1"/>单选
				   <input type="radio" name="type" value="2"/>多选
				</dd>
				<dt>投票选项：</dt>
				<dd id="voteoptions">
					<p><input type="text" class="input-text" name="options" /></p>
					<p><input type="text" class="input-text" name="options" /></p>
				</dd>
				<dd class="button">
					<input type="image" src="images/button_submit.gif" />
					<a href="javascript:;" onclick="AddOption()">增加选项</a>
					<%--<a href="Subject!list.action">取消操作</a>action--%>
					<a href="javascript:;" onclick="cancel()">取消操作</a>
				</dd>
			</dl>
		</form>
	</div>
</div>
<%@include file="h2.jsp" %>
</body>
</html>

