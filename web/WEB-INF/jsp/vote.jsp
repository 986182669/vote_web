<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>参与投票</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
</head>
<body>

<script type="text/javascript">
    function radio(obj) {
        var stype = <%=request.getAttribute("stype")%>
      	var options = document.getElementsByName("options");
      	if(stype==1){
            for(var i = 0;i<options.length;i++){
                if(options[i].value==obj.value){
                    options[i].checked = true;
                }else{
                    options[i].checked=false;
                }
            }
        }
    }
</script>
<%@include file="h1.jsp" %>
<div id="vote" class="wrap">
	<h2>参与投票</h2>
	<ul class="olist">
		<li>
			<h4>${param.stitle}</h4>
			<p class="info">共有${param.optionCount }个选项，已有 ${param.userCount} 个网友参与了投票。</p>
			<input type="hidden" name="stype" id="stype" value="${stype }"/>
			<form method="post" action="VoteServlet?meth=doVote"}>
			    <input type="hidden" name="sid" value="${param.sid }"/>
				<ol>
				<c:forEach items="${olist}" var="vo">
					<li>
						<input type="checkbox" name="options" value="${vo.oid}" onclick="radio(this);"/>${vo.option}
					</li>
				</c:forEach>
				</ol>
				<p class="voteView">
					<input type="image" src="../images/button_vote.gif" />
					<a href="VoteServlet?meth=toView&sid=${param.sid}&optionCount=${param.optionCount}&userCount=${param.userCount}"/>
						<s:property value='${vo.sid }'/>
						<img src="../images/button_view.gif" />
					</a>
				</p>
			</form>
		</li>
	</ul>w
</div>
<%@include file="h2.jsp" %>

</body>
</html>
