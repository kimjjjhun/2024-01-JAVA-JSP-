package com.ott.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ott.controller.util.DBManager;
import com.ott.dto.ContentVO;

public class ContentDAO {

	private static ContentDAO instance = new ContentDAO();

	private ContentDAO() {

	}

	public static ContentDAO getInstance() {
		return instance;
	}

	
	public int getContentList() {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select count(*) from content";
		int count=0; 
		
		try {
			
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		
		
		
		return count;
	}
	
	public List<ContentVO> getAllContentList(int page, int limit) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<ContentVO> list = new ArrayList<ContentVO>();

		String sql = "select * from (select rownum rnum, contentNum, "
				+ "contentName, genre, actor, year, story, poster, director "
				+ "from (select * from content order by contentNum desc)) "
				+ "where rnum >=? and rnum <= ?";

		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			
			int startrow = (page - 1)*limit+1;
			int endrow = startrow+limit-1;
			
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ContentVO vo = new ContentVO();

				vo.setContentNum(rs.getInt("contentNum"));
				vo.setContentName(rs.getString("contentName"));
				vo.setGenre(rs.getString("genre"));
				vo.setActor(rs.getString("actor"));
				vo.setYear(rs.getInt("year"));
				vo.setStory(rs.getString("story"));
				vo.setPoster(rs.getString("poster"));
				vo.setDirector(rs.getString("director"));

				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

		return list;
	}
	
	public List<ContentVO> getAllContent() {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<ContentVO> list = new ArrayList<ContentVO>();

		String sql = "select * from content order by contentNum desc";

		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ContentVO vo = new ContentVO();

				vo.setContentNum(rs.getInt("contentNum"));
				vo.setContentName(rs.getString("contentName"));
				vo.setGenre(rs.getString("genre"));
				vo.setActor(rs.getString("actor"));
				vo.setYear(rs.getInt("year"));
				vo.setStory(rs.getString("story"));
				vo.setPoster(rs.getString("poster"));
				vo.setDirector(rs.getString("director"));

				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

		return list;
	}

	public ContentVO getOneContent(int contentNum) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from content where contentNum=?";

		ContentVO vo = new ContentVO();
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, contentNum);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo.setContentNum(rs.getInt("contentNum"));
				vo.setContentName(rs.getString("contentName"));
				vo.setGenre(rs.getString("genre"));
				vo.setActor(rs.getString("actor"));
				vo.setYear(rs.getInt("year"));
				vo.setStory(rs.getString("story"));
				vo.setPoster(rs.getString("poster"));
				vo.setDirector(rs.getString("director"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

		return vo;
	}

	public void insertContent(ContentVO vo) {

		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = "insert into content values(content_seq.nextval,?,?,?,?,?,?,?)";

		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, vo.getContentName());
			pstmt.setString(2, vo.getGenre());
			pstmt.setString(3, vo.getActor());
			pstmt.setInt(4, vo.getYear());
			pstmt.setString(5, vo.getStory());
			pstmt.setString(6, vo.getPoster());
			pstmt.setString(7, vo.getDirector());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt);
		}

	}

	public void updateContent(ContentVO vo) {

		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = "update content set contentName=?, genre=?, actor=?, year=?, "
				+ "story = ?, poster=?, director=? where contentNum=?";

		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, vo.getContentName());
			pstmt.setString(2, vo.getGenre());
			pstmt.setString(3, vo.getActor());
			pstmt.setInt(4, vo.getYear());
			pstmt.setString(5, vo.getStory());
			pstmt.setString(6, vo.getPoster());
			pstmt.setString(7, vo.getDirector());
			pstmt.setInt(8, vo.getContentNum());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt);
		}

	}

	public void deleteContent(int contentNum) {

		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = "delete from content where contentNum = ?";

		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, contentNum);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt);
		}
	}


	
	
	

	public ContentVO selectCotentTitle(String contentName) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from content where contentTitle=?";

		ContentVO vo = new ContentVO();
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, contentName);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo.setContentNum(rs.getInt("contentNum"));
				vo.setContentName(rs.getString("contentName"));
				vo.setGenre(rs.getString("genre"));
				vo.setActor(rs.getString("actor"));
				vo.setYear(rs.getInt("year"));
				vo.setStory(rs.getString("story"));
				vo.setPoster(rs.getString("poster"));
				vo.setDirector(rs.getString("director"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

		return vo;
	}

	public ContentVO selectCotentGenre(String genre) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from content where genre=?";

		ContentVO vo = new ContentVO();
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, genre);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo.setContentNum(rs.getInt("contentNum"));
				vo.setContentName(rs.getString("contentName"));
				vo.setGenre(rs.getString("genre"));
				vo.setActor(rs.getString("actor"));
				vo.setYear(rs.getInt("year"));
				vo.setStory(rs.getString("story"));
				vo.setPoster(rs.getString("poster"));
				vo.setDirector(rs.getString("director"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

		return vo;
	}

	public ContentVO selectCotentActor(String actor) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from content where contentTitle=?";

		ContentVO vo = new ContentVO();
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, actor);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo.setContentNum(rs.getInt("contentNum"));
				vo.setContentName(rs.getString("contentName"));
				vo.setGenre(rs.getString("genre"));
				vo.setActor(rs.getString("actor"));
				vo.setYear(rs.getInt("year"));
				vo.setStory(rs.getString("story"));
				vo.setPoster(rs.getString("poster"));
				vo.setDirector(rs.getString("director"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

		return vo;
	}

}
