<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"
	import="Model.member"    
%>
<%
	member m = (member)session.getAttribute("M");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
	<h2>登入成功</h2>
	<h2><%=m.getName() %>歡迎你!</h2>
	<a href="../porder/index.jsp">進入購物</a>
</body>
</html>