package studentManager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import studentManager.entity.User;
import studentManager.util.DBUtil;

public class UserDao {
	
	public User queryUser(String name, String password) throws SQLException {
		Connection connection = DBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("select * from T_USER where name = ? and password = ?");
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getString("id"));
				user.setName(resultSet.getString("name"));
				user.setPassword(resultSet.getString("password"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			preparedStatement.close();
			connection.close();
		}
		return null;
	}

}
