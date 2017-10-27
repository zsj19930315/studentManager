<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="addStudent">
	ID:<input type="text" name="id" value="7"><br>
	学号:<input type="text" name="num" value="005"><br>
	姓名:<input type="text" name="name" value="小小"><br>
	性别:<input type="text" name="sex" value="女"><br>
	年龄:<input type="text" name="age" value="16"><br>
	年级:<input type="text" name="grade" value="2"><br>
	电话号码:<input type="text" name="phone" value="18859595656"><br>
	住址:<input type="text" name="address" value="北京"><br>
	<input type="text" name="userId" value=<%=request.getParameter("userId") %> style="display:none"><br>
	<input type="submit" value="提交">
</form>
</body>
</html>