package com.neuedu.lvcity.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import com.neuedu.lvcity.dao.ScenicDao;
import com.neuedu.lvcity.model.Scenic;

public class ScenicDaoImpl implements ScenicDao{

	private Connection conn;
	
	public ScenicDaoImpl(Connection conn){
		this.conn = conn;
	}
	
	@Override
	public int scenicCount() {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pStatement = null;
		ResultSet rs = null;
		try{
			pStatement = conn.prepareStatement("select count(*) from scenic");
			rs = pStatement.executeQuery();
			while(rs.next()){
				
			}
		}catch(Exception e){
			
		}
		return 0;
	}

	@Override
	public List<Scenic> findAllScenic(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addScenictype(String st) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateScenic(Scenic scenic) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteScenictype(Scenic scenic) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Scenic findOneScenictype(Scenic scenic) {
		// TODO Auto-generated method stub
		return null;
	}

}
