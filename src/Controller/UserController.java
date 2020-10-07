package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import Model.User;

public class UserController implements Controller {
	public Boolean CreateUser(User usr) {
		try {
			Class.forName(DB_DRIVER);
			Connection conn = DriverManager.getConnection(DB_URL, DB_USR, DB_PWD);
			
			String query = " insert into user (id, username, email, password, date) values (? , ? , ? , ? , ?)";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2,usr.getUsername());
			preparedStmt.setString(3,usr.getEmail());
			preparedStmt.setString(4,usr.getPassword());
			preparedStmt.setString(5,usr.getDate());
			preparedStmt.execute();
			preparedStmt.close();
			conn.close();
		} catch (Exception e) {
			System.err.println("error during user registration!");
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}
	public Boolean SearchUser(String email) {
		User usr = new User();
		try {
			Class.forName(DB_DRIVER);
			Connection conn = DriverManager.getConnection(DB_URL, DB_USR, DB_PWD);
			
			String query = " SELECT * FROM user WHERE email = ?";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, email);
			ResultSet rs = preparedStmt.executeQuery();
			rs.next();
			usr.setId(rs.getInt("id"));
			usr.setUsername(rs.getString("username"));
			usr.setEmail(rs.getString("email"));
			usr.setPassword(rs.getString("password"));
			usr.setDate(rs.getString("date"));
			//preparedStmt.execute();
			preparedStmt.close();
			conn.close();
		} catch (Exception e) {
			System.err.println("Kullanici aranirken hata olustu.");
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}
	public User GetUser(String email,String password) {
		User usr = new User();
		try {
			Class.forName(DB_DRIVER);
			Connection conn = DriverManager.getConnection(DB_URL, DB_USR, DB_PWD);
			
			String query = " SELECT * FROM user WHERE email = ? and password = ?";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, email);
			preparedStmt.setString(2, password);
			ResultSet rs = preparedStmt.executeQuery();
			rs.next();
			usr.setId(rs.getInt("id"));
			usr.setUsername(rs.getString("username"));
			usr.setEmail(rs.getString("email"));
			usr.setPassword(rs.getString("password"));
			usr.setDate(rs.getString("date"));
			//preparedStmt.execute();
			preparedStmt.close();
			conn.close();
		} catch (Exception e) {
			System.err.println("Kullanici aranirken hata olustu.");
			System.err.println(e.getMessage());
		}
		return usr;
	}
}
