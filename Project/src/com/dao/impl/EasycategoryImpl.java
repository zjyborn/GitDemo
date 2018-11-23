package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bin.Easybuy_category;
import bin.Page;
import dao.BaseDao;
import dao.IEasybuy_category;

public class EasycategoryImpl extends BaseDao implements IEasybuy_category {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	@Override
	public List<Easybuy_category> findCategoryByParent(Page page) {
		List<Easybuy_category> list=new ArrayList<Easybuy_category>();
		conn = getConnection();
	    String sql="select * from(select p.* ,rownum r  from EASYBUY_PRODUCT_CATEGORY p where p.epc_parent_id=0) temp where temp.r between ? and ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,(page.getCurrentpage()-1)*page.getPagesize()+1);
			ps.setInt(2,(page.getCurrentpage())*page.getPagesize());
			rs = ps.executeQuery();
			while(rs.next()) {
				Easybuy_category profile = new Easybuy_category();
				profile.setEpc_id(rs.getInt(1));
				profile.setEpc_name(rs.getString(2));
				profile.setEpc_parent_id(rs.getInt(3));			
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
	public List<Easybuy_category> findCategoryByParentId(int epc_ip) {
		List<Easybuy_category> list=new ArrayList<Easybuy_category>();
		conn = getConnection();
	    String sql="select * from EASYBUY_PRODUCT_CATEGORY where epc_parent_id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,epc_ip);
			rs = ps.executeQuery();
			while(rs.next()) {
				Easybuy_category profile = new Easybuy_category();
				profile.setEpc_id(rs.getInt(1));
				profile.setEpc_name(rs.getString(2));
				profile.setEpc_parent_id(rs.getInt(3));			
				list.add(profile);
			}			
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally {
			closeAll(conn, ps, rs);
		}					
			return list;
	}

	@Override
	public int countPage() {
		conn = getConnection();
		int count=0;
		String sql = "select count(1) from easybuy_product_category where epc_parent_id=0";
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
	public int updateCategory(Easybuy_category category) {
	   conn=getConnection();
	   int row=0;
	   String sql="update easybuy_product_category set epc_name=?,epc_parent_id=?  where epc_id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getEpc_name());
			ps.setInt(2, category.getEpc_parent_id());
			ps.setInt(3, category.getEpc_id());
			row=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return row;
	}

	@Override
	public int delCategory(int epc_id) {
		conn=getConnection();
		String sql ="delete from easybuy_product_category where epc_id=?";
		int row=0;
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, epc_id);
		  	row=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll(conn,ps,rs);
		}
		return row;	
	}

	@Override
	public int addCategory(Easybuy_category category) {
		conn = getConnection();
		String sql = "insert into easybuy_product_category values(seq_category.nextval,?,?)";
		int row=0;
		try {
			ps = conn.prepareStatement(sql);	   
			ps.setString(1, category.getEpc_name());
			ps.setInt(2,  category.getEpc_parent_id());	
			row=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, ps, rs);
		}				
		return row;
	}

	@Override
	public Easybuy_category findById(int epc_id) {
		Easybuy_category profile =new Easybuy_category();
		try {
			conn = getConnection();
			String sql = "select * from easybuy_product_category where epc_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,epc_id);
			rs = ps.executeQuery();
			while(rs.next()) {
				profile.setEpc_id(rs.getInt(1));
				profile.setEpc_name(rs.getString(2));
				profile.setEpc_parent_id(rs.getInt(3));			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, ps, rs);
		}
		return profile;
	}

	@Override
	public List<Easybuy_category> findCategoryByParent() {
		List<Easybuy_category> list=new ArrayList<Easybuy_category>();
		conn = getConnection();
	    String sql="select * from EASYBUY_PRODUCT_CATEGORY ";
		try {
			ps = conn.prepareStatement(sql);
//			ps.setInt(1,epc_ip);
			rs = ps.executeQuery();
			while(rs.next()) {
				Easybuy_category profile = new Easybuy_category();
				profile.setEpc_id(rs.getInt(1));
				profile.setEpc_name(rs.getString(2));
				profile.setEpc_parent_id(rs.getInt(3));			
				list.add(profile);
			}			
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally {
			closeAll(conn, ps, rs);
		}					
			return list;
	}

}
