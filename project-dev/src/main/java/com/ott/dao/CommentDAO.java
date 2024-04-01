package com.ott.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ott.controller.util.DBManager;
import com.ott.dto.CommentVO;

public class CommentDAO {

	private static CommentDAO instance = new CommentDAO();
	
	public CommentDAO() {}
	
	public static CommentDAO getInstance() {
		return instance;
	}
	
	public List<CommentVO> getAllComments(int bulletinNum){
		List<CommentVO>list = new ArrayList<CommentVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from comments where bulletinNum = ? order by commentNum desc";
		try {
			con = DBManager.getConnection();
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, bulletinNum);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CommentVO vo = new CommentVO();
				
				vo.setCommentNum(rs.getInt("commentNum"));
				vo.setCommentContent(rs.getString("commentContent"));
				vo.setCommentDate(rs.getTimestamp("commentDate"));
				vo.setUserId(rs.getString("userId"));
				
				list.add(vo);
			}
			System.out.println("댓글리스트>>" + list);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		return list;
	}
	
	public CommentVO getOneComments(int commentNum){
		CommentVO vo = new CommentVO();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from comments where commentNum = ?";
		try {
			con = DBManager.getConnection();
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, commentNum);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setCommentNum(rs.getInt("commentNum"));
				vo.setCommentContent(rs.getString("commentContent"));
				vo.setCommentDate(rs.getTimestamp("commentDate"));
				vo.setUserId(rs.getString("userId"));
				}
			
			System.out.println("테뀨vo>>" + vo);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		return vo;
	}
	
	public void insertComment(int bulletinNum, String commentContent,  String userId) {
	      
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      
	      String sql = "insert into comments(bulletinNum ,commentNum, commentContent, userid) values(? , comments_seq.nextval, ?, ?)";
	      
	      try {
	         con = DBManager.getConnection();
	         pstmt = con.prepareStatement(sql);
	         
	         pstmt.setInt(1, bulletinNum);
	         pstmt.setString(2, commentContent);
	         pstmt.setString(3, userId);
	         
	         pstmt.executeUpdate();
	         
	      }catch(Exception e) {
	         e.printStackTrace();
	      }finally {
	         DBManager.close(con, pstmt);
	      }
	   }
	
	public void deleteComment(int commentNum) {
	      
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      
	      String sql = "delete from comments where commentNum=?";
	      
	      try {
	         con = DBManager.getConnection();
	         
	         pstmt = con.prepareStatement(sql);
	         
	         pstmt.setInt(1, commentNum);
	         
	         pstmt.executeUpdate();
	         
	      }catch(Exception e) {
	         e.printStackTrace();
	      }finally {
	         DBManager.close(con, pstmt);
	      }
	   }
	
	public int updateComment(int commentNum, String commentContent) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		int result = -1;
		
		String sql ="update comments set commentContent = ? where commentNum = ?";
		
		try {
			
			con = DBManager.getConnection();
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, commentContent);
			pstmt.setInt(2, commentNum);
			
			result = pstmt.executeUpdate();
			
			System.out.println("result체크>>" + result);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt);
		}
		return result;
	}
}
