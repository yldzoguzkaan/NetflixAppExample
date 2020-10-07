package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Program;

public class ProgramController implements Controller{
	public List<String> getKinds(){
		List<String> kinds = new ArrayList<String>();
		try {
			Class.forName(DB_DRIVER);
			Connection conn = DriverManager.getConnection(DB_URL, DB_USR, DB_PWD);
			Statement st = conn.createStatement();
			String query = "SELECT name FROM kind";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				String kind_name = rs.getString("name");
				kinds.add(kind_name);
			}
			rs.close();
			st.close();
			conn.close();
			return kinds;
		} catch (Exception e) {
			System.err.println("Could not load!");
			System.err.println(e.getMessage());
			return null;
		}
	}
	public String getKindByID(int i) {
		//SELECT * FROM `program` WHERE id IN (SELECT programID FROM `program_kind` WHERE kindID = 1 OR kindID = 2 OR kindID = 3)
		String ret;
		try {
			Class.forName(DB_DRIVER);
			Connection conn = DriverManager.getConnection(DB_URL, DB_USR, DB_PWD);
			
			String query = " SELECT name FROM kind WHERE ID = ?";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, i);
			ResultSet rs = preparedStmt.executeQuery();
			rs.next();
			ret = rs.getString("name");
			//preparedStmt.execute();
			preparedStmt.close();
			conn.close();
			return ret;
		} catch (Exception e) {
			System.err.println("error!");
			System.err.println(e.getMessage());
			return null;
		}
		//return true;
		//return 1;
	}
	public String getTypeByID(int i) {
		String ret;
		try {
			Class.forName(DB_DRIVER);
			Connection conn = DriverManager.getConnection(DB_URL, DB_USR, DB_PWD);
			
			String query = " SELECT name FROM type WHERE id = ?";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, i);
			ResultSet rs = preparedStmt.executeQuery();
			rs.next();
			ret = rs.getString("name");
			preparedStmt.execute();
			preparedStmt.close();
			conn.close();
			return ret;
		} catch (Exception e) {
			System.err.println("error!");
			System.err.println(e.getMessage());
			return null;
		}
		//return true;
		//return 1;
	}
	
	public List<Integer> getProgramIDByKind(int i) {
		//SELECT * FROM `program` WHERE id IN (SELECT programID FROM `program_kind` WHERE kindID = 1 OR kindID = 2 OR kindID = 3)
		List<Integer> retList = new ArrayList<Integer>();
		try {
			Class.forName(DB_DRIVER);
			Connection conn = DriverManager.getConnection(DB_URL, DB_USR, DB_PWD);
			
			String query = " SELECT programID FROM `program_kind` WHERE kindID = ?";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, i);
			ResultSet rs = preparedStmt.executeQuery();
			while (rs.next()) {
				retList.add(rs.getInt("programID"));
			}
			preparedStmt.execute();
			preparedStmt.close();
			conn.close();
			return retList;
		} catch (Exception e) {
			System.err.println("error!");
			System.err.println(e.getMessage());
			return retList;
		}
		//return true;
		//return 1;
	}
	//SELECT kindID FROM `program_kind` WHERE programID = 1
	public List<Integer> getKindIDByProgramID(int i) {
		List<Integer> retList = new ArrayList<Integer>();
		try {
			Class.forName(DB_DRIVER);
			Connection conn = DriverManager.getConnection(DB_URL, DB_USR, DB_PWD);
			
			String query = " SELECT kindID FROM `program_kind` WHERE programID = ?";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, i);
			ResultSet rs = preparedStmt.executeQuery();
			while (rs.next()) {
				retList.add(rs.getInt("kindID"));
			}
			preparedStmt.execute();
			preparedStmt.close();
			conn.close();
			return retList;
		} catch (Exception e) {
			System.err.println("error!");
			System.err.println(e.getMessage());
			return retList;
		}
		//return true;
		//return 1;
	}
	
	
	public Program getProgramByID(int i) {
		//SELECT * FROM `program` WHERE id IN (SELECT programID FROM `program_kind` WHERE kindID = 1 OR kindID = 2 OR kindID = 3)
		Program p = new Program();
		try {
			
			List<Integer> kindIDList = new ArrayList<Integer>();
			kindIDList = getKindIDByProgramID(i);
			List<String> kindList = new ArrayList<String>();
			for(int t = 0; t<kindIDList.size(); t++) {
				kindList.add(getKindByID(kindIDList.get(t)));
			}
				
				
			Class.forName(DB_DRIVER);
			Connection conn = DriverManager.getConnection(DB_URL, DB_USR, DB_PWD);
			
			String query = " SELECT * FROM `program` WHERE id = ?";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, i);
			ResultSet rs = preparedStmt.executeQuery();
			rs.next();
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setType(getTypeByID(rs.getInt("typeID")));
			p.setEpisodeCount(rs.getInt("episode_count"));
			p.setEpisodeTime(rs.getInt("episode_time"));
			p.setScore(rs.getInt("score"));
			p.setKind(kindList);
			
			preparedStmt.execute();
			preparedStmt.close();
			conn.close();
			return p;
		} catch (Exception e) {
			System.err.println("error!");
			System.err.println(e.getMessage());
			return null;
		}
		//return true;
		//return 1;
	}
	public int getProgramCount() {
		int ret;
		try {
			Class.forName(DB_DRIVER);
			Connection conn = DriverManager.getConnection(DB_URL, DB_USR, DB_PWD);
			Statement st = conn.createStatement();
			String query = "SELECT COUNT(*) count FROM program";
			ResultSet rs = st.executeQuery(query);
			rs.next();
			ret = rs.getInt("count");
			rs.close();
			st.close();
			conn.close();
			return ret;
		} catch (Exception e) {
			System.err.println("error!");
			System.err.println(e.getMessage());
			return -1;
		}
	}
	
	public List<Program> SearchContentsByName(String text){
		List<Program> programSearchList = new ArrayList<Program>();
		List<Integer> kindIDList = new ArrayList<Integer>();
		List<String> kindList = new ArrayList<String>();
		try {
			Class.forName(DB_DRIVER);
			Connection conn = DriverManager.getConnection(DB_URL, DB_USR, DB_PWD);
			
			String query = " SELECT * FROM program WHERE name LIKE ? ";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, "%" + text + "%");
			ResultSet rs = preparedStmt.executeQuery();
			while (rs.next()) {
				Program p = new Program();
				kindIDList.clear();
				kindList.clear();
				p.setId(rs.getInt("id"));
				kindIDList = getKindIDByProgramID(p.getId());
				for(int t = 0; t<kindIDList.size(); t++) {
					kindList.add(getKindByID(kindIDList.get(t)));
				}
				p.setName(rs.getString("name"));
				p.setType(getTypeByID(rs.getInt("typeID")));
				p.setEpisodeCount(rs.getInt("episode_count"));
				p.setEpisodeTime(rs.getInt("episode_time"));
				p.setScore(rs.getInt("score"));
				p.setKind(kindList);
				programSearchList.add(p);
			}
			preparedStmt.execute();
			preparedStmt.close();
			conn.close();
			return programSearchList;
		} catch (Exception e) {
			System.err.println("error!");
			System.err.println(e.getMessage());
			return null;
		}
		//return true;
		//return 1;
	}
	
	public List<Program> SearchContentsByKind(String text){
		List<Program> plist = new ArrayList<Program>();
		List<Integer> kindIDList = new ArrayList<Integer>();
		List<Integer> programIDList = new ArrayList<Integer>();
		List<Integer> temp = new ArrayList<Integer>();
		//List<String> kindList = new ArrayList<String>();
		try {
			Class.forName(DB_DRIVER);
			Connection conn = DriverManager.getConnection(DB_URL, DB_USR, DB_PWD);
			
			String query = " SELECT id FROM kind WHERE name LIKE ? ";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, "%" + text + "%");
			ResultSet rs = preparedStmt.executeQuery();
			while (rs.next()) {
				kindIDList.add(rs.getInt("id"));
			}
			for (Integer integer : kindIDList) {
				temp = getProgramIDByKind(integer);
				for (Integer a : temp) {
					programIDList.add(a);
				}
				temp.clear();
			}
			for (Integer integer : programIDList) {
				plist.add(getProgramByID(integer));
			}
			preparedStmt.execute();
			preparedStmt.close();
			conn.close();
			return plist;
		} catch (Exception e) {
			System.err.println("error!");
			System.err.println(e.getMessage());
			return null;
		}
		//return true;
		//return 1;
	}
}
