<%@page import="studentManager.dao.StudentDao"%>
<%@page import="studentManager.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Student student = (Student)request.getAttribute("student"); 
%>
<form action="editStudent">
	<input type="text" name="id" value=<%=student.getId() %> style="display:none"><br>
	学号:<input type="text" name="num" value=<%=student.getNum() %>><br>
	姓名:<input type="text" name="name" value=<%=student.getName() %>><br>
	性别:<input type="text" name="sex" value=<%=student.getSex() %>><br>
	年龄:<input type="text" name="age" value=<%=student.getAge() %>><br>
	年级:<input type="text" name="grade" value=<%=student.getGrade() %>><br>
	电话号码:<input type="text" name="phone" value=<%=student.getPhone() %>><br>
	住址:<input type="text" name="address" value=<%=student.getAddress() %>><br>
	<input type="text" name="userId" value=<%=student.getUserId() %> style="display:none"><br>
	<input type="submit" value="提交">
</form>
</body>
</html>