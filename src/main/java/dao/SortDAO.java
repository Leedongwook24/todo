package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class SortDAO {
    private String url = "jdbc:mysql://localhost:3306/todo_kadai";
    private String user = "root";
    private String password = "password";

    public ArrayList<HashMap<String,String>> select(String sort_type, String asc_or_desc) throws SQLException, ClassNotFoundException {
        ArrayList<HashMap<String, String>> rows = new ArrayList<HashMap<String, String>>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM todo_list ORDER BY " + sort_type + " " + asc_or_desc + " WHERE status != 'Delete' ";
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();

            while (rs.next()) {
                HashMap<String, String> columns = new HashMap<String,String>();
                String id = rs.getString("id");
                columns.put("id", id);
                String title = rs.getString("title");
                columns.put("title", title);
                String content = rs.getString("content");
                columns.put("content", content);
                String create_date = rs.getString("create_date");
                columns.put("create_date", create_date);
        		String priority=rs.getString("priority");
        		columns.put("priority", priority);
                rows.add(columns);
            }
        } finally {
            // 자원 해제
            if (rs != null) {
                rs.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return rows;
    }
}