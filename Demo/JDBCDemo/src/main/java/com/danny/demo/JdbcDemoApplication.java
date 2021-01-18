package com.danny.demo;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class JdbcDemoApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(JdbcDemoApplication.class, args);
//	}
//
//}


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcDemoApplication {

	public static void main(String[] args) throws Exception {

		/*
		查找
		 */
		List<Student> students = queryStudents();
		System.out.println(students);
		/*
		增加
		 */
//		insertStudent();
	}

	static List<Student> queryStudents() throws SQLException {

		List<Student> students = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(jdbcUrl,jdbcUsername,jdbcPassword)) {
			try (PreparedStatement ps = connection.
					prepareStatement("SELECT * FROM students WHERE grade = ? AND score >= ?")) {
				ps.setInt(1,3);
				ps.setInt(2,90);
				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						students.add(extractRow(rs));
					}
				}
			}
		}
		return students;
	}

	static int insertStudent() throws SQLException {

		try (Connection connection = DriverManager.getConnection(jdbcUrl,jdbcUsername,jdbcPassword)) {
			try (PreparedStatement ps = connection.
					prepareStatement("INSERT INTO students (id,grade,name,gender,score) VALUES (?,?,?,?,?)")) {
				ps.setObject(1,999);
				ps.setObject(2,1);
				ps.setObject(3,"Bob");
				ps.setObject(4,1);
				ps.setObject(5,95);
				int result = ps.executeUpdate();
				System.out.println(result == 1 ? "Insert Succes" : "Insert fail");
				return result;
			}
		}

	}


	static Student extractRow(ResultSet rs) throws SQLException {
		var std = new Student();
		std.setId(rs.getLong("id"));
		std.setName(rs.getString("name"));
		std.setGender(rs.getBoolean("gender"));
		std.setGrade(rs.getInt("grade"));
		std.setScore(rs.getInt("score"));
		return std;
	}


	static final String jdbcUrl = "jdbc:mysql://localhost:3306/learnjdbc?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC";
	static final String jdbcUsername = "root";
	static final String jdbcPassword = "cai123321";


}