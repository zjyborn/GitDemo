package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bin.Easybuy_category;
import bin.Easybuy_product;
import bin.Page;
import dao.BaseDao;
import dao.IEasybuyProduct;

public class IproductImpl extends BaseDao implements IEasybuyProduct{
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	@Override
	public List<Easybuy_product> findAllProduct(Page page) {
		List<Easybuy_product> list=new ArrayList<Easybuy_product>();
		conn = getConnection();
	    String sql="select * from(select p.* ,rownum r  from EASYBUY_PRODUCT p) temp where temp.r between ? and ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,(page.getCurrentpage()-1)*page.getPagesize()+1);
			ps.setInt(2,(page.getCurrentpage())*page.getPagesize());
			rs = ps.executeQuery();
			while(rs.next()) {
				Easybuy_product profile = new Easybuy_product();
				profile.setEp_id(rs.getInt(1));
				profile.setEp_name(rs.getString(2));
				profile.setEp_description(rs.getString(3));	
				profile.setEp_price(rs.getDouble(4));
				profile.setEp_stock(rs.getInt(5));
				profile.setEpc_id(rs.getInt(6));
				profile.setEpc_child_id(rs.getInt(7));
				profile.setEp_file_name(rs.getString(8));		
				list.add(profile);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll(conn, ps, rs);
		}					
			return list;
	}

	@Override
	public Easybuy_product findById(int ep_id) {
		Easybuy_product profile1 =new Easybuy_product();
		try {
			conn = getConnection();
			String sql = "select * from easybuy_product where ep_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,ep_id);
			rs = ps.executeQuery();
			while(rs.next()) {
				profile1.setEp_id(rs.getInt(1));
				profile1.setEp_name(rs.getString(2));
				profile1.setEp_description(rs.getString(3));	
				profile1.setEp_price(rs.getDouble(4));
				profile1.setEp_stock(rs.getInt(5));
				profile1.setEpc_id(rs.getInt(6));
				profile1.setEpc_child_id(rs.getInt(7));
				profile1.setEp_file_name(rs.getString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, ps, rs);
		}
		return profile1;
	}

	@Override
	public int update(Easybuy_product product) {
		 conn=getConnection();
		   int row=0;
		   String sql="update easybuy_product set ep_name=?,ep_description=?,ep_price=?,ep_stock=?,epc_id=?,epc_child_id=?,ep_file_name=? where ep_id=?";
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, product.getEp_name());
				ps.setString(2, product.getEp_description());
				ps.setDouble(3, product.getEp_price());
				ps.setInt(4, product.getEp_stock());
				ps.setInt(5, product.getEpc_id());
				ps.setInt(6, product.getEpc_child_id());
				ps.setString(7, product.getEp_file_name());
				ps.setInt(8, product.getEp_id());
				row=ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			return row;
	}

	@Override
	public int addProduct(Easybuy_product product) {
		conn = getConnection();
		String sql = "insert into easybuy_product values(seq_product.nextval,?,?,?,?,?,?,?)";
		int row=0;
		try {
			ps = conn.prepareStatement(sql);	   
			ps.setString(1, product.getEp_name());
			ps.setString(2,product.getEp_description()  );	
			ps.setDouble(3,product.getEp_price());
			ps.setInt(4, product.getEp_stock());
			ps.setInt(5, product.getEpc_id());
			ps.setInt(6, product.getEpc_child_id());
			ps.setString(7,product.getEp_file_name());	
			row=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, ps, rs);
		}				
		return row;
	}

	@Override
	public int deleteProduct(int ep_id) {
		conn=getConnection();
		String sql ="delete from easybuy_product where ep_id=?";
		int row=0;
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, ep_id);
		  	row=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll(conn,ps,rs);
		}
		return row;	
	}

	@Override
	public int countPage() {
		conn = getConnection();
		int count=0;
		String sql = "select count(1) from easybuy_product";
		try {
			ps = conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {		
			e.printStackTrace();
		}finally {
			closeAll(conn, ps, rs);
		}
		return count;
	}

	@Override
	public List<Easybuy_product> getAllProduct() {
		List<Easybuy_product> list=new ArrayList<Easybuy_product>();
		conn = getConnection();
	    String sql="select * from EASYBUY_PRODUCT ";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Easybuy_product profile = new Easybuy_product();
				profile.setEp_id(rs.getInt(1));
				profile.setEp_name(rs.getString(2));
				profile.setEp_description(rs.getString(3));	
				profile.setEp_price(rs.getDouble(4));
				profile.setEp_stock(rs.getInt(5));
				profile.setEpc_id(rs.getInt(6));
				profile.setEpc_child_id(rs.getInt(7));			
				profile.setEp_file_name(rs.getString(8));	
				list.add(profile);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll(conn, ps, rs);
		}					
			return list;
	}

}
