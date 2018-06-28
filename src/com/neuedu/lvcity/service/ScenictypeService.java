package com.neuedu.lvcity.service;

import java.util.List;
import java.util.Map;

import com.neuedu.lvcity.model.Scenictype;

public interface ScenictypeService {
	public int scenictypeCount();
	public List<Scenictype> findAllScenictype(Map<String, Object> map);
	public int addScenictype(String imagePath);
	public int updateScenictype(Scenictype scenictype);
	public int deleteScenictype(Scenictype scenictype);
	public Scenictype findOneScenictype(Scenictype scenictype);
}
