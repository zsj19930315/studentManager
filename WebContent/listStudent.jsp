<%@page import="studentManager.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">学生管理系统</h1>
<hr>
<table border=1 align="center">
	<tr>
		<th style="display:none">ID</th>
		<th>学号</th>
		<th>姓名</th>
		<th>性别</th>
		<th>年龄</th>
		<th>年级</th>
		<th>电话号码</th>
		<th>住址</th>
		<th style="display:none">User外键</th>
		<th>添加</th>
		<th>修改</th>
		<th>删除</th>
	</tr>
	<%
		@SuppressWarnings("unchecked")
		List<Student> students = (List<Student>)request.getAttribute("students");
		for(Iterator<Student> it=students.iterator();it.hasNext();){            
			Student student=(Student)it.next();
	%>
	<tr>
		<td style="display:none"><%=student.getId() %></td>
		<td><%=student.getNum() %></td>
		<td><%=student.getName() %></td>
		<td><%=student.getSex() %></td>
		<td><%=student.getAge() %></td>
		<td><%=student.getGrade() %></td>
		<td><%=student.getPhone() %></td>
		<td><%=student.getAddress() %></td>
		<td style="display:none"><%=student.getUserId() %></td>
		<td><a href="addStudent.jsp?userId=<%=student.getUserId() %>">点我添加</a></td>
		<td><a href="getStudent?id=<%=student.getId() %>">点我修改</a></td>
		<td><a href="deleteStudent?id=<%=student.getId() %>&userId=<%=student.getUserId() %>">点我删除</a></td>
	</tr>
	<%
		}
	%>
</table>
</body>
</html>