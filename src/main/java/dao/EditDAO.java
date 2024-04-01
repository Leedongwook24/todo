package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EditDAO {
	String url = "jdbc:mysql://localhost:3306/todo_kadai";
	String user = "root";
	String password = "password";
	Connection conection = null;
	PreparedStatement statement = null;
	ResultSet rs = null;

	public void conect() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conection = DriverManager.getConnection(url, user, password);
	}

	public void UPDATE(Integer id, Integer user_id, String title, String content) throws Exception {
		try {
			conect();
			String sql = "UPDATE todo_list set user_id = ?, title = ?, content = ?, edit_date = ? where id = ?";
			statement = conection.prepareStatement(sql);
			statement.setInt(1, user_id);
			statement.setString(2, title);
			statement.setString(3, content);
			LocalDateTime currentDateTime = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			String edit_date = currentDateTime.format(formatter);
			statement.setString(4, edit_date);
			statement.setInt(5, id);
			statement.executeUpdate();
		} finally {
			closeResources();
		}
	}

	public void Delete(Integer id) throws Exception {
		try {
			conect();
			String sql = "UPDATE todo_list set status= 'Delete', edit_date = ? where id = ?";
			statement = conection.prepareStatement(sql);
			LocalDateTime currentDateTime = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			String edit_date = currentDateTime.format(formatter);
			statement.setString(1, edit_date);
			statement.setInt(2, id);
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
