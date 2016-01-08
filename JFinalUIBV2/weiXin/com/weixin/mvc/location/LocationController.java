package com.weixin.mvc.location;

import org.apache.log4j.Logger;

import com.platform.constant.ConstantInit;
import com.platform.mvc.base.BaseController;

/**
 * 位置管理
 * @author 董华健
 */
//@Controller(controllerKey = "/jf/wx/location")
public class LocationController extends BaseController {

	private static Logger log = Logger.getLogger(LocationController.class);
	
	public void index(){
		log.debug("微信用户位置管理：分页");
		paging(ConstantInit.db_dataSource_main, splitPage, Location.sqlId_splitPage);
		render("/weiXin/location/list.html");
	}
	
	public void delete() {
		Location.dao.deleteById(getPara());
		redirect("/jf/wx/location");
	}
	
}