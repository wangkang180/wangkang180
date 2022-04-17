package com.kuang.daoIMP;



import com.kuang.bean.Student;
import com.kuang.connection.DataBaseConnection;
import com.kuang.dao.StudentDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOIMP implements StudentDAO {
	// 添加操作
	    public void insert(Student s){
	      String sql = "INSERT INTO student (id,name) values (?,?)";
	    PreparedStatement pstmt = null;
	    DataBaseConnection conn = null;
	    //针对数据库的具体操作
	    try{
	        conn = new DataBaseConnection();
			Connection connection = conn.getConnection();

			pstmt = conn.getConnection().prepareStatement(sql);
	        pstmt.setLong(1,s.getID());
	        //pstmt.setString(1,s.getID());
	        pstmt.setString(2,s.getName());
	  
	        pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	        }
	     catch(Exception e){
	    	e.printStackTrace();
		 }
	      }

	    public void update(Student s){
	    	String sql = "update student set iD = ? ,name = ? where id= ? ";

			PreparedStatement pstmt = null;
			DataBaseConnection conn = null;
			//针对数据库的具体操作
			try{
				conn = new DataBaseConnection();

				pstmt = conn.getConnection().prepareStatement(sql);
				pstmt.setLong(1,s.getID());
				//pstmt.setString(1,s.getID());
				pstmt.setString(2,s.getName());
				pstmt.setLong(3,s.getID());
				pstmt.executeUpdate();
				pstmt.close();
				conn.close();
			}
			catch(Exception e){  }
		}


	    public void delete(long iD){
			String sql = "delete from student where iD= ?";

			PreparedStatement pstmt = null;
			DataBaseConnection conn = null;
			//针对数据库的具体操作
			try{
				conn = new DataBaseConnection();

				pstmt = conn.getConnection().prepareStatement(sql);

				pstmt.setLong(1,iD);
				pstmt.executeUpdate();
				pstmt.close();
				conn.close();
			}
			catch(Exception e){  }
		}



public Student findByID(long iD){
		Student student = null;
		String sql = "select * from student where iD= ?";

		PreparedStatement pstmt = null;
		DataBaseConnection conn = null;
		//针对数据库的具体操作
		try{
		conn = new DataBaseConnection();

		pstmt = conn.getConnection().prepareStatement(sql);
		pstmt.setLong(1,iD);

		ResultSet rs=pstmt.executeQuery();

		if(rs.next()) {
			student = new Student();

			student.setID(rs.getLong("iD"));
			student.setName(rs.getString("name"));
		}
		pstmt.close();
		conn.close();
		}
		catch(Exception e){

		}
		return student;
}


	    public List findAll(){

			List<Student> students = new ArrayList<Student>();
			String sql = "select * from student";

			try{
			PreparedStatement pstmt = null;
			DataBaseConnection conn = null;
			conn = new DataBaseConnection();

			pstmt = conn.getConnection().prepareStatement(sql);
			ResultSet rs =pstmt.executeQuery();
			//针对数据库的具体操作
			while(rs.next()){
				Student student = new Student();

				student.setID(rs.getInt("iD"));
				student.setName(rs.getString("name"));
				students.add(student);
			}
			pstmt.close();
			conn.close();
			}
			catch(Exception e){  }
			return students;

		}



}
