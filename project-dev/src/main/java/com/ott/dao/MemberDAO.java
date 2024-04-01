package com.ott.dao;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ott.controller.util.DBManager;
import com.ott.dto.MemberVO;

public class MemberDAO {

	private static MemberDAO instance = new MemberDAO();

	private MemberDAO() {
	}

	public static MemberDAO getInstance() {
		return instance;
	}

	public int getMemberList() {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select count(*) from member";

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

	public List<MemberVO> getAllMemberList(int page, int limit) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from " + "(select rownum rnum, userId,admin, name, pwd, " + "email, phone, address from "
				+ "(select * from member order by userId desc)) " + "where rnum >= ? and rnum <= ?";

		List<MemberVO> list = new ArrayList<MemberVO>();

		try {

			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);

			int startrow = (page - 1) * limit + 1;
			int endrow = startrow + limit - 1;

			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberVO vo = new MemberVO();

				vo.setAdmin(rs.getInt("admin"));
				vo.setName(rs.getString("name"));
				vo.setUserId(rs.getString("userId"));
				vo.setPwd(rs.getString("pwd"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));

				list.add(vo);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

		return list;

	}

	public List<MemberVO> getAllMember() {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from member order by userId desc";

		List<MemberVO> list = new ArrayList<MemberVO>();

		try {

			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MemberVO vo = new MemberVO();

				vo.setAdmin(rs.getInt("admin"));
				vo.setName(rs.getString("name"));
				vo.setUserId(rs.getString("userId"));
				vo.setPwd(rs.getString("pwd"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));

				list.add(vo);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

		return list;

	}

	public MemberVO getOneMember(String userId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from member where userId = ?";

		MemberVO vo = new MemberVO();

		try {

			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				vo.setAdmin(rs.getInt("admin"));
				vo.setName(rs.getString("name"));
				vo.setUserId(rs.getString("userId"));
				vo.setPwd(rs.getString("pwd"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

		return vo;
	}

	public void deleteMember(String userId) {
		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = "delete from member where userId = ?";

		try {

			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt);
		}

	}


// 회원가입
	//ID중복체크
			public int confirmID(String userId) {
				
				String sql = "select userid from member where userid =?";
				int result = -1;
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				System.out.println("userid" + userId);
				try {
					con = DBManager.getConnection();
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, userId);
					
					rs = pstmt.executeQuery();
					
					if(rs.next()) {
						result = 1; // ID 사용가능
					}else {
						result = -1; // ID중복 사용불가
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					DBManager.close(con, pstmt, rs);
				}
				return result;
			}

	// 회원가입
	public int insertMember(MemberVO mVo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = -1;
		String sql = "INSERT INTO member (userid, admin, name, pwd, email, phone, address)VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			con = DBManager.getConnection();

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, mVo.getUserId());
			pstmt.setInt(2, mVo.getAdmin());
			pstmt.setString(3, mVo.getName());
			pstmt.setString(4, mVo.getPwd());
			pstmt.setString(5, mVo.getEmail());
			pstmt.setString(6, mVo.getPhone());
			pstmt.setString(7, mVo.getAddress());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt);
		}
		return result;
	}

// 로그인체크
	public int userCheck(String userId, String pwd) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int result = -1;

		String sql = "select pwd from member where userid = ?";

		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getString("pwd").equals(pwd)) {
					result = 1; // 아이디,비밀번호 일치
				} else {
					result = -1; // 비밀번호 불일치
				}
			} else {
				result = 0; // 아이디 불일치
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		return result;
	}

	public MemberVO getMember(String userid) {
		String sql = "select * from member where userid=?";
		MemberVO mVo = new MemberVO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				mVo.setUserId(rs.getString("userId"));
				mVo.setAdmin(rs.getInt("admin"));
				mVo.setName(rs.getString("name"));
				mVo.setPwd(rs.getString("pwd"));
				mVo.setEmail(rs.getString("email"));
				mVo.setPhone(rs.getString("phone"));
				mVo.setAddress(rs.getString("address"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		return mVo;
	}
	// id찾기
	public String findId(String name,String email) {
		String sql = "select userid from member where name = ? and email = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String userid = null;

		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				userid = rs.getString("userId");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		return userid;
	}

// pw찾기
	public String findPw(String userId, String email) {
		String sql = "select pwd from member where userid = ? and email = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String pwd = null;

		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, email);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				pwd = rs.getString("pwd");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		return pwd;
	}
	
	public int updateMember(MemberVO vo) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = -1;
		String sql = "update member set  name=?, "
				+ "  email=?, phone=?, address=? where userId=?";

		try {
			con = DBManager.getConnection();

			pstmt = con.prepareStatement(sql);
			
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getPhone());
			pstmt.setString(4, vo.getAddress());
			pstmt.setString(5, vo.getUserId());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt);
		}
		
		return result;
	}

}
