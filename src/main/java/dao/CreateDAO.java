package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CreateDAO {
	Connection conection = null;
	PreparedStatement statement = null;
	ResultSet rs = null;

	public boolean conect() throws Exception {
		String url = "jdbc:mysql://localhost:3306/todo_kadai";
		String user = "root";
		String password = "password";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conection = DriverManager.getConnection(url, user, password);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void Insert(Integer user_id, String title, String content) throws Exception {
		try {
			conect();
			String sql = "INSERT INTO todo_list (user_id, title, content, create_date, status, Priority) VALUES (?, ?, ?, ?, ?, ?)";
			statement = conection.prepareStatement(sql);
			statement.setInt(1, user_id);
			statement.setString(2, title);
			statement.setString(3, content);
			LocalDateTime currentDateTime = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			String create_date = currentDateTime.format(formatter);
			statement.setString(4, create_date);
			String inprogress = "In_Progress";
			statement.setString(5, inprogress);
			statement.setInt(6, 2);
			statement.executeUpdate();
		} finally {
			closeResources();
		}

	}

	private void closeResources() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (conection != null) {
				conection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
