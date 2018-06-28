package com.neuedu.lvcity.dao;

import java.util.List;
import java.util.Map;

import com.neuedu.lvcity.model.Scenic;

public interface ScenicDao {
	public int scenicCount();
	public List<Scenic> findAllScenic(Map<String, Object> map);
	public int addScenictype(String st);
	public int updateScenic(Scenic scenic);
	public int deleteScenictype(Scenic scenic);
	public Scenic findOneScenictype(Scenic scenic);
}
