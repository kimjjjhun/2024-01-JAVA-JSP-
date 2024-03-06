package com.saeyan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.jsp.jstl.sql.Result;

//싱글톤.......

public class MemberDAO {
	
	private static MemberDAO instance = new MemberDAO();
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private MemberDAO() {
	}
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws Exception {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "ezen";
		String password = "1234";
		//1.드라이버로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//2.DB연결
		return DriverManager.getConnection(url,user,password);
	}
	//ID중복체크
	public int confirmID(String userid) {
		int result = -1;
		
		String sql = "Select userid from member where userid = ?"; 
		try {
			//1.연결
			con = getConnection();
			//2.sql문 전송
			pstmt = con.prepareStatement(sql);
			//3.맵핑
			pstmt.setString(1,userid);
			//4. 실행및결과값 받기
			rs = pstmt.executeQuery(sql);
			//중복이면 1값 아니면 -1값 [ 중복체크 ]
			if(rs.next()) {
				result = 1;
			}else {
				result = -1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//경로닫기
				if(rs != null)rs.close();
				if(con != null)con.close();
				if(pstmt != null)pstmt.close();
			}catch(Exception e) {
			e.printStackTrace();	
			}
		}
		return result;
	}
}
