package studentManager.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentManager.dao.StudentDao;
import studentManager.entity.Student;

public class AddStudentController extends HttpServlet {

	/** 
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student student = new Student();
		student.setId(req.getParameter("id"));
		student.setNum(req.getParameter("num"));
		student.setName(req.getParameter("name"));
		student.setSex(req.getParameter("sex"));
		student.setAge(req.getParameter("age"));
		student.setGrade(req.getParameter("grade"));
		student.setPhone(req.getParameter("phone"));
		student.setAddress(req.getParameter("address"));
		student.setUserId(req.getParameter("userId"));
		StudentDao studentDao = new StudentDao();
		try {
			studentDao.addStudent(student);
			List<Student> students = studentDao.listStudent(req.getParameter("userId"));
			req.setAttribute("students", students);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("/listStudent.jsp").forward(req, resp);
	}

}
