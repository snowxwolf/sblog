package com.wa.xwolf.sblog.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wa.xwolf.sblog.bean.Article;
import com.wa.xwolf.sblog.dao.ArticleDao;

@Service
public class ArticleService {
	@Autowired
	private ArticleDao articleDao;

	public void addArticle(Map<String, Object> map) {
		articleDao.addArticle(map);
	}

	public Article findById(int id) {
		return articleDao.findById(id);
	}

	public void deleteArticle(int id) {
		articleDao.deleteArticle(id);
	}

	public List<Article> findArticles(Map<String, Object> map) {
		return articleDao.findArticles(map);
	}

	public void updateArticle(Map<String, Object> map) {
		articleDao.updateArticle(map);
	}

	public Map<String, Object> getContentById(int id) {
		return articleDao.getContentById(id);
	}

	public int findTotal(Map<String, Object> map) {
		return articleDao.findTotal(map);
	}
}
