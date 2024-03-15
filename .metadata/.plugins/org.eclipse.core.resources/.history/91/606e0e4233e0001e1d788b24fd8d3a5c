package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.ProductVO;

import util.DBManager;

public class ProductDAO {
	
	private static ProductDAO instance = new ProductDAO();
	
	private ProductDAO() {}

	public static ProductDAO getInstance() {
		return instance;
	}
	
	public List<ProductVO> selectAllProudcts(){
		
		String sql = "select * from product order by code desc";
		
		List<ProductVO> list = new ArrayList<ProductVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProductVO vo = new ProductVO();
				
				vo.setCode(rs.getInt("code"));
				vo.setName(rs.getString("name"));
				vo.setPrice(rs.getInt("price"));
				vo.setPictureUrl(rs.getString("pictureurl"));
				vo.setDescription(rs.getString("description"));
				
				list.add(vo);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		
		return list;
	}
	
	void insertProduct(ProductVO vo) {
		
	}
	
	int confirmID(String userid) {
		return 0;
	}
	
	int userCheck(String userid, String pwd) {
		return 0;
	}
	
	ProductVO selectProductByCode(String code) {
		return null;
	}
	
	void updateProduct(ProductVO vo) {
		
	}
}
