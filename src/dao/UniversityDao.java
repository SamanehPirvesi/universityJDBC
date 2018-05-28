package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import universityJDBC.Students;
import universityJDBC.University;
import utitity.JdbcConnection;

public class UniversityDao {
	public void createUniversity(University u) {
		Connection conn=JdbcConnection.getConnection();
		
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("INSERT INTO UNIVERSITY(NAME,U_ID)VALUES(?,?)");
			stmt.setString(1,u.getName());
			stmt.setInt(2,u.getU_id());
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		JdbcConnection.closeConnection(conn);
		
	}
	public void deleteUniversity(University u) {
		Connection conn=JdbcConnection.getConnection();
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("DELETE FROM UNIVERSITY WHERE NAME=?");
			stmt.setString(1, u.getName());
			stmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		JdbcConnection.closeConnection(conn);
		
	}
	
	public void updateUniversity(University u) {
		Connection conn=JdbcConnection.getConnection();
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("UPDATE UNIVERSITY SET NAME=? WHERE U_ID=?");
			stmt.setString(1,u.getName());
			stmt.setInt(2,u.getU_id());
			stmt.executeUpdate();

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		JdbcConnection.closeConnection(conn);
		
	}
	public List<University> getAllUniversity(){
		Connection conn=JdbcConnection.getConnection();
		PreparedStatement stmt;
		
			try {
				stmt = conn.prepareStatement("SELECT * FROM UNIVERSITY");
				ResultSet result = stmt.executeQuery();
				List<University> listOfUniversity = new ArrayList<>();
				while (result.next()) {
					int u_id = result.getInt(1);
					String name = result.getString("NAME");
					
					University s = new University(name, u_id);
					listOfUniversity.add(s);
				}
				return listOfUniversity;
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			return null;
	}
	public University getUniversityByName(String name){
		Connection conn=JdbcConnection.getConnection();
		PreparedStatement stmt;
		
			try {
				stmt = conn.prepareStatement("SELECT * FROM UNIVERSITY WHERE NAME=?");
				stmt.setString(1,name);
				ResultSet result = stmt.executeQuery();
				 while (result.next()) {
					int u_id = result.getInt(1);
					String universityName = result.getString("NAME");
					
					University s = new University(universityName, u_id);
					return s;
				}
				
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			return null;
		
		
		
	}
}
