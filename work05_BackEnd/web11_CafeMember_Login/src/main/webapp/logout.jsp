<%@page import="web.servlet.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member vo = (Member)session.getAttribute("vo");
	if (vo == null) { //로그인이 되어있지 않다면... 로그인 페이지로 연결...
%>
	<h3><a href="login.js">로그인 하기</a></h3>		
<%
	} else { //로그인이 된 상태라면... 로그아웃을 진행(세션을 death)
		System.out.println("로그아웃~");
		session.invalidate();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function logout() {
		alert("Logout~~!!");
	}
</script>
</head>
<body onload="return logout()">
<b>로그아웃 되셨습니다</b><br>
<a href="index.html">INDEX로 가기</a>
</body>
</html>