package com.ott.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ott.controller.util.DBManager;
import com.ott.dto.QnAVO;

public class QnaDAO {

	private static QnaDAO instance = new QnaDAO();

	private QnaDAO() {

	}

	public static QnaDAO getInstance() {
		return instance;
	}

	public int getQnaList() {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select count(*) from qna";

		int count = 0;

		try {

			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

		return count;
	}

	public List<QnAVO> getAllList(int page, int limit) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from (select rownum rnum, qnaNum, "
				+ "userId, qnaTitle, qnaContent, QnaRegiDate, "
				+ "qnaPwd, qnaCategory from " 
		+ "(select * from qna order by qnaNum desc)) "
				+ " where rnum >= ? and rnum <= ?";

		List<QnAVO> list = new ArrayList<QnAVO>();

		try {

			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);

			int startrow = (page - 1) * limit + 1;
			int endrow = startrow + limit - 1;

			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				QnAVO vo = new QnAVO();

				vo.setQnaNum(rs.getInt("qnaNum"));
				vo.setUserId(rs.getString("userId"));
				vo.setQnaTitle(rs.getString("qnaTitle"));
				vo.setQnaContent(rs.getString("qnaContent"));
				vo.setQnaRegiDate(rs.getTimestamp("qnaRegiDate"));
				vo.setQnaPwd(rs.getString("qnaPwd"));
				vo.setQnaCategory(rs.getString("qnaCategory"));

				list.add(vo);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

		return list;
	}

	public QnAVO getOneQna(int qnaNum) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from qna where qnaNum=?";

		QnAVO vo = new QnAVO();

		try {

			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, qnaNum);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				vo.setQnaNum(rs.getInt("qnaNum"));
				vo.setUserId(rs.getString("userId"));
				vo.setQnaTitle(rs.getString("qnaTitle"));
				vo.setQnaContent(rs.getString("qnaContent"));
				vo.setQnaRegiDate(rs.getTimestamp("qnaRegiDate"));
				vo.setQnaPwd(rs.getString("qnaPwd"));
				vo.setQnaCategory(rs.getString("qnaCategory"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

		return vo;
	}

	public void insertQnA(QnAVO vo) {

		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = "insert into qna values(qna_seq.nextval,?,?,?,sysdate,?,?)";

		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			
			
			pstmt.setString(1, vo.getUserId());
			pstmt.setString(2, vo.getQnaTitle());
			pstmt.setString(3, vo.getQnaContent());
			pstmt.setString(4, vo.getQnaPwd());
			pstmt.setString(5, vo.getQnaCategory());
			
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt);
		}

	}
	
	public void updateQna(QnAVO vo) {
		
		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = "update qna set userId=?, qnaTitle=?, qnaContent = ? "
				+ ", qnaPwd = ?, qnaCategory=? where qnaNum = ? ";

		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			
			
			pstmt.setString(1, vo.getUserId());
			pstmt.setString(2, vo.getQnaTitle());
			pstmt.setString(3, vo.getQnaContent());
			pstmt.setString(4, vo.getQnaPwd());
			pstmt.setString(5, vo.getQnaCategory());
			pstmt.setInt(6, vo.getQnaNum());
			
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt);
		}
	}
	
	public void deleteQna(int qnaNum) {
		
		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = "delete from qna where qnaNum = ?";

		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, qnaNum);
			
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt);
		}
	}

}
