package com.wa.xwolf.sblog.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wa.xwolf.sblog.bean.Diary;
import com.wa.xwolf.sblog.dao.DiaryDao;

@Service
public class DiaryService {

	@Autowired
	private DiaryDao diaryDao;

	public void saveDiary(Map<String, Object> map) {
		diaryDao.saveDiary(map);
	}

	public List<Diary> finDiaries(Map<String, Object> map) {
		return diaryDao.finDiaries(map);
	}

	public int findTotal(Map<String, Object> map) {
		return diaryDao.findTotal(map);
	}

	// 逻辑删除
	public void deleteDiary(int id) {
		diaryDao.deleteDiary(id);
	}

	// 物理删除
	public void deleteDiarys(int id) {
		diaryDao.deleteDiarys(id);
	}

	public void updateDiary(Map<String, Object> map) {
		diaryDao.updateDiary(map);
	}

	public Map<String, Object> findById(int id) {
		return diaryDao.findById(id);
	}

}
