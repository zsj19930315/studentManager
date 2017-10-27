package studentManager.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentManager.dao.StudentDao;
import studentManager.entity.Student;

public class GetStudentController extends HttpServlet {

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
		Student student = null;
		try {
			student = studentDao.getStudent(req.getParameter("id"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("student", student);
		req.getRequestDispatcher("/editStudent.jsp").forward(req, resp);
	}

}
