package cgg.sma.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import cgg.sma.manage.ConnectionProvider;
import cgg.sma.model.Student;

public class StudentDAO {
	
	public static boolean insertStudentToDB(Student st) {
		boolean f=false;
		//jdbc code...
		Connection con=ConnectionProvider.createC();
		try {
		String q="insert into students(sname,sphone,scity) values(?,?,?)";
		//PreparedStatement..
		PreparedStatement ps = con.prepareStatement(q);
		//set the value of parameters
		ps.setString(1, st.getsName());
		ps.setString(2,st.getsPhone());
		ps.setString(3, st.getsCity());
		
		//execute...
		ps.executeUpdate();
		f=true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public static boolean deleteStudent(int userId) {
		boolean f=false;
		//jdbc code...
		Connection con=ConnectionProvider.createC();
		try {
		String q="delete from students where studentId=?";
		//PreparedStatement..
		PreparedStatement ps = con.prepareStatement(q);
		//set the value of parameters
		ps.setInt(1, userId);
			
		//execute...
		ps.executeUpdate();
		f=true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public static void showAllStudents() {
		boolean f=false;
		//jdbc code...
		Connection con=ConnectionProvider.createC();
		try {
		String q="select * from students";
		//PreparedStatement..
		Statement stm = con.createStatement();
			
		//execute...
		ResultSet rs = stm.executeQuery(q);
		while(rs.next()) {
			int id=rs.getInt(1);
			String name=rs.getString(2);
			String phone=rs.getString(3);
			String city=s.getString("scity");
			
			System.out.println("Id : "+id);
			System.out.println("Name : "+name);
			System.out.println("Phone No : "+phone);
			System.out.println("City : "+city);
			System.out.println("-----------------------");
			
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}
