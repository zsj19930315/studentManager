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
import studentManager.dao.UserDao;
import studentManager.entity.Student;
import studentManager.entity.User;

public class LoginController extends HttpServlet {

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
		UserDao userDao = new UserDao();
		User user = null;
		try {
			user = userDao.queryUser(req.getParameter("name"), req.getParameter("password"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (null != user) {
			StudentDao studentDao = new StudentDao();
			List<Student> students = new ArrayList<Student>();;
			try {
				students = studentDao.listStudent(user.getId());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			req.setAttribute("students", students);
			req.getRequestDispatcher("/listStudent.jsp").forward(req, resp);
		}
	}

}
