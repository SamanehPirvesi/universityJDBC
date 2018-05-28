package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import universityJDBC.Students;
import utitity.JdbcConnection;

public class StudentDao {
	public void creatStudent(Students s) {
		Connection conn = JdbcConnection.getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO STUDENTS(NAME,S_ID,U_ID)VALUES(?,?,?)");
			stmt.setString(1, s.getName());
			stmt.setInt(2, s.getS_id());
			stmt.setInt(3, s.getU_id());
			stmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		JdbcConnection.closeConnection(conn);
	}

	public void updateStudent(Students s) {
		Connection conn = JdbcConnection.getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement("UPDATE STUDENTS SET NAME=?,U_ID=? WHERE S_ID=?");
			stmt.setString(1, s.getName());
			stmt.setInt(2, s.getU_id());
			stmt.setInt(3, s.getS_id());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JdbcConnection.closeConnection(conn);
	}

	public void deleteStudent(Students s) {
		Connection conn = JdbcConnection.getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM STUDENTS WHERE S_ID=?");
			stmt.setInt(1, s.getS_id());
			stmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		JdbcConnection.closeConnection(conn);

	}

	public List<Students> getAllStudents() {
		Connection conn = JdbcConnection.getConnection();
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("SELECT * FROM STUDENTS");
			ResultSet result = stmt.executeQuery();
			List<Students> students = new ArrayList<>();
			while (result.next()) {
				int s_id = result.getInt(1);
				String name = result.getString("NAME");
				int u_id = result.getInt(3);

				Students s = new Students(name, s_id, u_id);
				students.add(s);
			}

			return students;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		JdbcConnection.closeConnection(conn);

		return null;
	}

	public Students getStudentById(int id) {
		Connection conn = JdbcConnection.getConnection();
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("SELECT * FROM STUDENTS WHERE S_ID=?");
			stmt.setInt(1, id);
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				int s_id = result.getInt(1);
				String name = result.getString("NAME");
				int u_id = result.getInt(3);

				Students s = new Students(name, s_id, u_id);
			
				return s;
				
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		JdbcConnection.closeConnection(conn);
		return null;
	}
	public List<Students> getStudentsByName(String name){
			Connection conn = JdbcConnection.getConnection();
			PreparedStatement stmt;
			try {
				stmt = conn.prepareStatement("SELECT * FROM STUDENTS WHERE NAME=?");
				stmt.setString(1, name);
				ResultSet result = stmt.executeQuery();
				List<Students> students = new ArrayList<>();
				while (result.next()) {
					int s_id = result.getInt(1);
					String stdentName = result.getString("NAME");
					int u_id = result.getInt(3);

					Students s = new Students(stdentName, s_id, u_id);
					students.add(s);
					
					
				}
				return students;

			} catch (SQLException e) {

				e.printStackTrace();
			}
			
			JdbcConnection.closeConnection(conn);
			return null;
		
	}
}
