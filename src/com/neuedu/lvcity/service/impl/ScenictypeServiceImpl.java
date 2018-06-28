package com.neuedu.lvcity.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.dao.ScenictypeDao;
import com.neuedu.lvcity.dao.impl.ScenictypeDaoImpl;
import com.neuedu.lvcity.model.Scenictype;
import com.neuedu.lvcity.service.ScenictypeService;

public class ScenictypeServiceImpl implements ScenictypeService{

	private static final ScenictypeService instance = new ScenictypeServiceImpl();
	
	public static ScenictypeService getInStance(){
		return instance;
	}
	
	private ScenictypeServiceImpl(){
		
	}
	
	@Override
	public int scenictypeCount() {
		// TODO Auto-generated method stub
		Connection conn = null;
		int result = 0;
		try{
			conn = DBUtils.getConnection();
			ScenictypeDao scenictypeDao = new ScenictypeDaoImpl(conn);
			result = scenictypeDao.scenictypeCount();
		}catch(Exception e){
			System.out.println("查询统计所有scenictype错误"+e.getMessage());
		}finally{
			DBUtils.closeConnection(conn);
		}
		return result;
	}

	@Override
	public List<Scenictype> findAllScenictype(Map<String, Object> map) {
		// TODO Auto-generated method stub
		Connection conn = null;
		List<Scenictype> scenictypes = null;
		try{
			conn = DBUtils.getConnection();
			ScenictypeDao scenictypeDao = new ScenictypeDaoImpl(conn);
			scenictypes = scenictypeDao.findAllScenictype(map);
		}catch(Exception e){
			System.out.println("查询所有scenictype错误"+e.getMessage());
		}finally{
			DBUtils.closeConnection(conn);
		}
		return scenictypes;
	}

	@Override
	public int addScenictype(String imagePath) {
		// TODO Auto-generated method stub
		int result = 0;
		Connection conn = null;
		try{
			conn = DBUtils.getConnection();
			DBUtils.beginTransaction(conn);
			ScenictypeDao scenictypeDao = new ScenictypeDaoImpl(conn);
			result = scenictypeDao.addScenictype(imagePath);
			DBUtils.commit(conn);
		}catch(Exception e){
			System.out.println("增加scenictype错误"+e.getMessage());
		}finally{
			DBUtils.closeConnection(conn);
		}
		return result;
	}

	@Override
	public int updateScenictype(Scenictype scenictype) {
		// TODO Auto-generated method stub
		int result = 0;
		Connection conn = null;
		try{
			conn = DBUtils.getConnection();
			DBUtils.beginTransaction(conn);
			ScenictypeDao ScenictypeDao = new ScenictypeDaoImpl(conn);
			result = ScenictypeDao.updateScenictype(scenictype);
			DBUtils.commit(conn);
		}catch(Exception e){
			System.out.println("编辑scenictype错误"+e.getMessage());
		}finally{
			DBUtils.closeConnection(conn);
		}
		return result;
	}

	@Override
	public int deleteScenictype(Scenictype scenictype) {
		// TODO Auto-generated method stub
		int result = 0;
		Connection conn = null;
		try{
			conn = DBUtils.getConnection();
			DBUtils.beginTransaction(conn);
			ScenictypeDao ScenictypeDao = new ScenictypeDaoImpl(conn);
			result = ScenictypeDao.deleteScenictype(scenictype);
			DBUtils.commit(conn);
		}catch(Exception e){
			System.out.println("删除scenictype错误"+e.getMessage());
		}finally{
			DBUtils.closeConnection(conn);
		}
		return result;
	}

	@Override
	public Scenictype findOneScenictype(Scenictype scenictype) {
		// TODO Auto-generated method stub
		return null;
	}

}
