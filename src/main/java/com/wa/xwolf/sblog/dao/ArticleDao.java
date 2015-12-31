package com.wa.xwolf.sblog.dao;

import java.util.List;
import java.util.Map;

import com.wa.xwolf.sblog.bean.Article;

public interface ArticleDao {
	
	public void addArticle(Map<String,Object> map);
	
	public Article findById(int id);
	
	public void deleteArticle(int id);
	
	public List<Article> findArticles(Map<String,Object> map);
	
	public void updateArticle (Map<String,Object> map);
	
	public Map<String, Object> getContentById(int id);
	
	public int findTotal (Map<String,Object> map);

}
