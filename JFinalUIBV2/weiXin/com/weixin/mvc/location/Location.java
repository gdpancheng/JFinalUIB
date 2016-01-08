package com.weixin.mvc.location;

import java.sql.Timestamp;

import org.apache.log4j.Logger;

import com.platform.annotation.Table;
import com.platform.constant.ConstantInit;
import com.platform.mvc.base.BaseModel;

@SuppressWarnings("unused")
//@Table(tableName= "wx_location")
public class Location extends BaseModel<Location> {
	
	private static final long serialVersionUID = 2051998642258015518L;

	private static Logger log = Logger.getLogger(Location.class);
	
	public static final Location dao = new Location();

	/**
	 * 字段描述： 
	 * 字段类型：varchar(32)  长度：32
	 */
	public static final String column_ids = "ids";
	
	/**
	 * 字段描述： 
	 * 字段类型：varchar(32)  长度：32
	 */
	public static final String column_open_id = "open_id";
	
	/**
	 * 字段描述： 
	 * 字段类型：varchar(50)  长度：50
	 */
	public static final String column_lng = "lng";
	
	/**
	 * 字段描述： 
	 * 字段类型：varchar(50)  长度：50
	 */
	public static final String column_lat = "lat";
	
	/**
	 * 字段描述： 
	 * 字段类型：varchar(50)  长度：50
	 */
	public static final String column_bd09_lng = "bd09_lng";
	
	/**
	 * 字段描述： 
	 * 字段类型：varchar(50)  长度：50
	 */
	public static final String column_bd09_lat = "bd09_lat";
	
	/**
	 * 字段描述： 
	 * 字段类型：timestamp  长度：null
	 */
	public static final String column_createdate = "createdate";
	
	
	/**
	 * sqlId : weixin.location.splitPage
	 * 描述：分页from
	 */
	public static final String sqlId_splitPage = "weixin.location.splitPage";

	private String ids;
	private String open_id;
	private String lng;
	private String lat;
	private String bd09_lng;
	private String bd09_lat;
	private String createdate;
	
	public void setIds(String ids){
		set(column_ids, ids);
	}
	public String getIds() {
		return get(column_ids);
	}
	public void setOpen_id(String open_id){
		set(column_open_id, open_id);
	}
	public String getOpen_id() {
		return get(column_open_id);
	}
	public void setLng(String lng){
		set(column_lng, lng);
	}
	public String getLng() {
		return get(column_lng);
	}
	public void setLat(String lat){
		set(column_lat, lat);
	}
	public String getLat() {
		return get(column_lat);
	}
	public void setBd09_lng(String bd09_lng){
		set(column_bd09_lng, bd09_lng);
	}
	public String getBd09_lng() {
		return get(column_bd09_lng);
	}
	public void setBd09_lat(String bd09_lat){
		set(column_bd09_lat, bd09_lat);
	}
	public String getBd09_lat() {
		return get(column_bd09_lat);
	}
	public void setCreatedate(Timestamp createdate){
		set(column_createdate, createdate);
	}
	public Timestamp getCreatedate() {
		return get(column_createdate);
	}
}