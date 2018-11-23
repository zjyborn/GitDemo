package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bin.Easybuy_user;
import bin.Page;
import dao.BaseDao;
import dao.EasybyUser;

public class EasybyuserImpl extends BaseDao implements EasybyUser{
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	@Override
	public List<Easybuy_user> findByPage(Page page) {
		List<Easybuy_user> list=new ArrayList<Easybuy_user>();
		conn = getConnection();
	    String sql="select * from(select p.* ,rownum r  from easybuy_user p) temp where temp.r between ? and ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,(page.getCurrentpage()-1)*page.getPagesize()+1);
			ps.setInt(2,(page.getCurrentpage())*page.getPagesize());
			rs = ps.executeQuery();
			while(rs.next()) {
				Easybuy_user profile = new Easybuy_user();
				profile.setEu_user_id(rs.getString(1));
				profile.setEu_user_name(rs.getString(2));
				profile.setEu_password(rs.getString(3));
				profile.setEu_sex(rs.getInt(4));
				profile.setEu_birthday(rs.getString(5));	
				profile.setEu_identity_code(rs.getString(6));
				profile.setEu_email(rs.getString(7));
				profile.setEu_mobile(rs.getString(8));
				profile.setEu_address(rs.getString(9));
				profile.setEu_login(rs.getInt(10));
				profile.setEu_status(rs.getInt(11));
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
	public Easybuy_user findById(String eu_user_id) {
		Easybuy_user profile =new Easybuy_user();
		try {
			conn = getConnection();
			String sql = "select * from easybuy_user where eu_user_id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, eu_user_id);
			rs = ps.executeQuery();
			while(rs.next()) {			
				profile.setEu_user_id(rs.getString(1));
				profile.setEu_user_name(rs.getString(2));
				profile.setEu_password(rs.getString(3));
				profile.setEu_sex(rs.getInt(4));
				profile.setEu_birthday(rs.getString(5));	
				profile.setEu_identity_code(rs.getString(6));
				profile.setEu_email(rs.getString(7));
				profile.setEu_mobile(rs.getString(8));
				profile.setEu_address(rs.getString(9));
				profile.setEu_login(rs.getInt(10));
				profile.setEu_status(rs.getInt(11));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, ps, rs);
		}
		return profile;
	}

	@Override
	public int delById(String user_id) {
		conn=getConnection();
		String sql ="delete from easybuy_user where eu_user_id=?";
		int row=0;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, user_id);
		  	row=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll(conn,ps,rs);
		}
		return row;
	}
	@Override
	public int update(Easybuy_user user) {
		 int row=0;
		 conn = getConnection();
		String sql="update easybuy_user set eu_user_name=?,eu_password=?,eu_sex=?,eu_birthday=to_date(?,'yyyy-MM-dd hh24:mi:ss'),eu_mobile=?,eu_address=? where eu_user_id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getEu_user_name());
			ps.setString(2, user.getEu_password());
			ps.setInt(3, user.getEu_sex());
			ps.setString(4, user.getEu_birthday());
			ps.setString(5, user.getEu_mobile());
			ps.setString(6, user.getEu_address());
			ps.setString(7, user.getEu_user_id());	
			row=ps.executeUpdate();		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public int countPage() {
		conn = getConnection();
		int count=0;
		String sql = "select count(1) from easybuy_user";
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

}
