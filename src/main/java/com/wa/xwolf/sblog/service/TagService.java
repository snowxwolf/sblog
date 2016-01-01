package com.wa.xwolf.sblog.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wa.xwolf.sblog.bean.Tag;
import com.wa.xwolf.sblog.dao.TagDao;

@Service
public class TagService {
	@Autowired
	private TagDao tagDao;

	public void saveTag(Map<String, Object> map) {
		tagDao.saveTag(map);
	}

	public void deleteTag(int id) {
		tagDao.deleteTag(id);
	}

	public void updateTag(Map<String, Object> map) {
		tagDao.updateTag(map);
	}

	public List<Tag> findTags(Map<String, Object> map) {
		return tagDao.findTags(map);
	}

	public int findTotal(Map<String, Object> map) {
		return tagDao.findTotal(map);
	}

	public Tag findById(int id) {
		return tagDao.findById(id);
	}

	public List<Tag> findTagTree() {
		return tagDao.findTagTree();
	}

}
