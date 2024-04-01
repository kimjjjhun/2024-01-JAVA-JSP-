package com.ott.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ott.controller.util.DBManager;
import com.ott.dto.QnAReplyVO;

public class QnAReplyDAO {

	private static QnAReplyDAO instance = new QnAReplyDAO();
	
	private QnAReplyDAO() {
		
	}
	
	public static QnAReplyDAO getInstance() {
		return instance;
	}
	
	public List<QnAReplyVO> getAllQnAReply(){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from qnaReply order by replyNum";
		
		List<QnAReplyVO> list = new ArrayList<QnAReplyVO>();
		
		try {
			
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				QnAReplyVO vo = new QnAReplyVO();
				
				vo.setReplyContent(rs.getString("replyContent"));
				vo.setReplyRegiDate(rs.getTimestamp("replyRegiDate"));
				vo.setReplyNum(rs.getInt("replyNum"));
				vo.setQnaNum(rs.getInt("qnaNum"));
				
				
				list.add(vo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		
		return list;
	}
	
	public QnAReplyVO getOneQnAReply(int qnaNum) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from qnaReply where qnaNum = ?";
		
		QnAReplyVO vo = new QnAReplyVO();
		try {
			
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,qnaNum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				vo.setReplyContent(rs.getString("replyContent"));
				vo.setReplyRegiDate(rs.getTimestamp("replyRegiDate"));
				vo.setReplyNum(rs.getInt("replyNum"));
				
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		
		return vo;
	}
	
	public void insertQnAReply(QnAReplyVO rVo) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into qnaReply values(qnaReply_seq.nextval,?,sysdate,?)";
		
		try {
			
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			
			
			pstmt.setString(1, rVo.getReplyContent());
			pstmt.setInt(2, rVo.getQnaNum());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt);
		}
		
	}

	
	
	
	
}
