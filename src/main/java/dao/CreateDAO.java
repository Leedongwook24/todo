package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class CreateDAO {
	String url = "jdbc:mysql://localhost:3306/todo_kadai";
    String user = "root";
    String password ="password";
    Connection conection =null;
    
    public void conect() throws Exception{
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	conection = DriverManager.getConnection(url,user,password);
    }
	
    public ArrayList<HashMap<String,String>> select() throws Exception {
    	PreparedStatement statement = null;
    	ResultSet rs = null;
    	String sql="SELECT * FROM todo_list";
    	ArrayList<HashMap<String, String>> rows= new 
    	ArrayList<HashMap<String, String>>();
    	conect();
    	statement=conection.prepareStatement(sql);
    	rs=statement.executeQuery();
    	while(rs.next()) {
    		HashMap<String, String> columns = new HashMap<String,String>();
    		String id = rs.getString("id");
    		columns.put("id", id);
    		String title= rs.getString("title");
    		columns.put("title", title);
    		String content=rs.getString("content");
    		columns.put("content", content);
    		LocalDateTime currenttime=LocalDateTime.now();
    		String create_date=currenttime.toString();
    		columns.put("create_date",create_date);
    		rows.add(columns);
    	}
    	return rows;
    }
	
	
	
	
	
	
	
	
}
