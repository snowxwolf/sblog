package com.wa.xwolf.sblog.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.wa.xwolf.sblog.bean.Diary;

@Repository
public interface DiaryDao {
	
	public void saveDiary(Map<String,Object> map);
	
	public List<Diary> finDiaries(Map<String,Object> map);
	
	public int findTotal(Map<String,Object> map);
	//逻辑删除
	public void deleteDiary(int id);
	//物理删除
	public void deleteDiarys(int id);
	
	public void updateDiary(Map<String,Object> map);
	
	public Map<String, Object> findById(int id);

}
