package com.laziobird.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laziobird.CommonEnum;
import com.laziobird.bean.App;
import com.laziobird.bean.AppMapper;

/**
 * 
 * @author laziobird
 *
 */
@Service
public class AppService {
	@Autowired
	private AppMapper appMapper;


	public List<App> listAll() {
		return appMapper.showAll();
	}


	public App getAppById(String id) {
		return appMapper.getById(id);
	}

	public int freezeAppById(Integer id) {
		App app = new App();
		app.setId(id);
		app.setStatus(CommonEnum.APP_STATUS_FREEZE.getValue());
		return appMapper.updateStatusById(app);
	}
	
	public int unFreezeAppById(Integer id) {
		App app = new App();
		app.setId(id);
		app.setStatus(CommonEnum.APP_STATUS_OK.getValue());
		return appMapper.updateStatusById(app);
	}	

	public int deleteAppById(Integer id) {
		App app = new App();
		app.setId(id);
		app.setStatus(CommonEnum.APP_STATUS_DELETE.getValue());
		return appMapper.updateStatusById(app);
	}


	/**
	 * 有没有重复用户名
	 * @param name
	 * @return
	 */
	public boolean hasSameName(String name) {
		return appMapper.countByName(name) > 0 ? true : false;
	}


	public int addApp(App app) {
		return appMapper.insert(app);
	}

	public int updateApp(App app) {
		return appMapper.update(app);
	}
}
