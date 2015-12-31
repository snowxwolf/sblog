package com.xwolf.cxf.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * 封装Map为普通实体类
 * @author xwolf
 * @Date 2015-05-30  10:24  北京电信
 *
 */
public class UserMap {
	
	public static class EntryMap{
		
		private String key;
		private User value ;
		public EntryMap(){
			
		}
		public EntryMap(String key2, User user2) {
			this.key=key2;
			this.value=user2;
		}
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public User getValue() {
			return value;
		}
		public void setValue(User user) {
			this.value = user;
		}
		
		
	}
	
	private List<EntryMap>  entryMaps = new ArrayList<UserMap.EntryMap>();

	public List<EntryMap> getEntryMaps() {
		return entryMaps;
	}

	public void setEntryMaps(List<EntryMap> entryMaps) {
		this.entryMaps = entryMaps;
	}
	
	

}
