package com.neuedu.lvcity.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.dao.ScenictypeDao;
import com.neuedu.lvcity.model.Banar;
import com.neuedu.lvcity.model.Scenictype;

public class ScenictypeDaoImpl implements ScenictypeDao{

	/**
	 * ���ݿ�����
	 */
	private Connection conn;

	/**
	 * ���췽��
	 * 
	 * @param conn
	 *            ���ݿ�����
	 */
	public ScenictypeDaoImpl(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public int scenictypeCount() {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pStatement = null;
		ResultSet rs = null;
		try{
			pStatement = conn.prepareStatement("select count(*) from scenictype");
			rs = pStatement.executeQuery();
			while(rs.next()){
				result = rs.getInt("count(*)");
			}
		}catch(SQLException e){
			System.out.println("�ڲ�ѯͳ��scenictype��ʱ�������.������Ϣ�� "+e.getMessage());
		}finally{
			DBUtils.closeStatement(rs, pStatement);
		}
		return result;
	}

	@Override
	public List<Scenictype> findAllScenictype(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<Scenictype> list = new ArrayList<Scenictype>();
		PreparedStatement pStatement = null;
		ResultSet rs = null;
		int startPage = (int)map.get("startPage");
		int endPage = (int)map.get("endPage");
		try{
			pStatement = conn.prepareStatement("select * from scenictype limit ?,?");
			pStatement.setInt(1,startPage );
			pStatement.setInt(2, endPage);
			rs = pStatement.executeQuery();
			while(rs.next()){
				Scenictype scenictype = new Scenictype();
				scenictype.setStid(rs.getInt("stid"));
				scenictype.setSt(rs.getString("st"));
				list.add(scenictype);
			}
		}catch(SQLException e){
			System.out.println("�ڲ�ѯȫ��scenictype��ʱ�������.������Ϣ�� ��" + e.getMessage());	
		}finally{
			DBUtils.closeStatement(rs, pStatement);
		}
		return list;
	}

	@Override
	public int addScenictype(String st) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pStatement = null;
		try{
			pStatement = conn.prepareStatement("insert into scenictype(st) values (?)");
			pStatement.setString(1, st);
			result = pStatement.executeUpdate();
		}catch(SQLException e){
			System.out.println("����scenictype����.������Ϣ�� ��" + e.getMessage());			
		}finally{
			DBUtils.closeStatement(null, pStatement);
		}
		return result;
	}

	@Override
	public int updateScenictype(Scenictype scenictype) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pStatement = null;
		try{
			pStatement = conn.prepareStatement("update scenictype set st = ? where stid = ?");
			pStatement.setString(1, scenictype.getSt());
			pStatement.setInt(2, scenictype.getStid());
			result = pStatement.executeUpdate();
		}catch(SQLException e){
			System.out.println("�༭scenictype����.������Ϣ�� ��" + e.getMessage());	
		}finally{
			DBUtils.closeStatement(null, pStatement);
		}
		return result;
	}

	@Override
	public int deleteScenictype(Scenictype scenictype) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pStatement = null;
		try{
			pStatement = conn.prepareStatement("delete from scenictype where stid = ?");
			pStatement.setInt(1, scenictype.getStid());
			result = pStatement.executeUpdate();
		}catch(SQLException e){
			System.out.println("ɾ��scenictype����.������Ϣ�� ��" + e.getMessage());
		}finally{
			DBUtils.closeStatement(null, pStatement);
		}
		return result;
	}

	@Override
	public Scenictype findOneScenictype(Scenictype scenictype) {
		// TODO Auto-generated method stub
		return null;
	}

}
