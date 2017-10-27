package studentManager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import studentManager.entity.Student;
import studentManager.util.DBUtil;

public class StudentDao {
	
	public void addStudent(Student student) throws SQLException {
		Connection connection = DBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("insert into T_STUDENT values (?,?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, student.getId());
			preparedStatement.setString(2, student.getNum());
			preparedStatement.setString(3, student.getName());
			preparedStatement.setString(4, student.getSex());
			preparedStatement.setString(5, student.getAge());
			preparedStatement.setString(6, student.getGrade());
			preparedStatement.setString(7, student.getPhone());
			preparedStatement.setString(8, student.getAddress());
			preparedStatement.setString(9, student.getUserId());
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			preparedStatement.close();
			connection.close();
		}
	}
	
	public void deleteStudent(String id) throws SQLException {
		Connection connection = DBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("delete from T_STUDENT where ID = ?");
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			preparedStatement.close();
			connection.close();
		}
	}
	
	public List<Student> listStudent(String userId) throws SQLException {
		List<Student> students = new ArrayList<Student>();
		Connection connection = DBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("select * from T_STUDENT where USERID = ?");
			preparedStatement.setString(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Student student = new Student();
				student.setId(resultSet.getString("id"));
				student.setNum(resultSet.getString("num"));
				student.setName(resultSet.getString("name"));
				student.setSex(resultSet.getString("sex"));
				student.setAge(resultSet.getString("age"));
				student.setGrade(resultSet.getString("grade"));
				student.setPhone(resultSet.getString("phone"));
				student.setAddress(resultSet.getString("address"));
				student.setUserId(resultSet.getString("userId"));
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			preparedStatement.close();
			connection.close();
		}
		return students;
	}
	
	public Student getStudent(String id) throws SQLException {
		Connection connection = DBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("select * from T_STUDENT where id = ?");
			preparedStatement.setString(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Student student = new Student();
				student.setId(resultSet.getString("id"));
				student.setNum(resultSet.getString("num"));
				student.setName(resultSet.getString("name"));
				student.setSex(resultSet.getString("sex"));
				student.setAge(resultSet.getString("age"));
				student.setGrade(resultSet.getString("grade"));
				student.setPhone(resultSet.getString("phone"));
				student.setAddress(resultSet.getString("address"));
				student.setUserId(resultSet.getString("userId"));
				return student;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			preparedStatement.close();
			connection.close();
		}
		return null;
	}

	public void updateStudent(Student student) throws SQLException {
		Connection connection = DBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("update T_STUDENT set NUM = ?, NAME = ?, SEX = ?, AGE = ?, GRADE = ?, PHONE = ?, ADDRESS = ? where ID = ?");
			preparedStatement.setString(1, student.getNum());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3, student.getSex());
			preparedStatement.setString(4, student.getAge());
			preparedStatement.setString(5, student.getGrade());
			preparedStatement.setString(6, student.getPhone());
			preparedStatement.setString(7, student.getAddress());
			preparedStatement.setString(8, student.getId());
			preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			preparedStatement.close();
			connection.close();
		}
	}

}
