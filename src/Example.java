import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import dao.StudentDao;
import dao.UniversityDao;
import universityJDBC.Students;
import universityJDBC.University;
import utitity.JdbcConnection;

public class Example {

	public static void main(String[] args) {
		//University u = new University("academi", 19);
//		University u1 = new University("unito", 18);
		Students s = new Students("bbb", 13, 16);
	//	Students s1 = new Students("bbb", 19, 19);
//		Students s2 = new Students("samane",20,12);
//		System.out.println(s1.getName()+" "+s1.getS_id()+" "+s1.getU_id());
//		System.out.println(s.getName()+" "+s.getS_id()+" "+s.getU_id());
		StudentDao sdao=new StudentDao();
		UniversityDao udao=new UniversityDao();
		
		//sdao.creatStudent(s2);
//		sdao.updateStudent(s);
		//sdao.deleteStudent(s2);
		//udao.createUniversity(u);
	//	udao.deleteUniversity(u);
//		udao.updateUniversity(u);
		
//	sdao.getAllStudents().stream().forEach(student -> System.out.println(student.getName()+" "+student.getS_id()));
	
//		sdao.getStudentsByName("bbb").stream().forEach(student -> System.out.println(student.getName()+" "+student.getS_id()));
//	Students s=sdao.getStudentById(19);
//	System.out.println(s.getName()+"  "+s.getS_id());
		//udao.getAllUniversity().stream().forEach(u->System.out.println(u.getName()+" "+u.getU_id()));
          
	University u=udao.getUniversityByName("POLITO");
	System.out.println(u.getName()+" "+u.getU_id());
	}

}
