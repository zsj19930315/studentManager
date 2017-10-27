package studentManager.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentManager.dao.StudentDao;
import studentManager.entity.Student;

public class DeleteStudentController extends HttpServlet {

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
		StudentDao studentDao = new StudentDao();
		try {
			studentDao.deleteStudent(req.getParameter("id"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Student> students = new ArrayList<Student>();;
		try {
			students = studentDao.listStudent(req.getParameter("userId"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("students", students);
		req.getRequestDispatcher("/listStudent.jsp").forward(req, resp);
	}

}
