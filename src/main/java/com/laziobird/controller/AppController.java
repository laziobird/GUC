package com.laziobird.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.laziobird.CommonEnum;
import com.laziobird.bean.App;
import com.laziobird.service.AppService;

/**
 * 
 * @author laziobird
 *
 */
@Controller
@RequestMapping("app")
public class AppController {

	@Autowired
	private AppService appService;

	/**
	 * 所有用户
	 *
	 * @return
	 */
    @RequestMapping("/list")
    public String listAll(HttpServletRequest request,Model model) {
    	List<App> list = appService.listAll();
		model.addAttribute("appList", list);    	
        return "app/list";
    }
	
	
	/**
	 * 根据id获取系统
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping("/getapp")
	public App getAppByid(@RequestParam("id") String id) {
		return appService.getAppById(id);
	}


	@RequestMapping("/addApp")
	public int addApp(@RequestParam String name, String info, String url) {
		App app = new App();
		app.setName(name);
		app.setInfo(info);
		app.setUrl(url);
		app.setCtime(new Date());
		return appService.addApp(app);
	}


	@RequestMapping("/delApp")
	public int delApp(@RequestParam int id) {
		return appService.deleteAppById(id);
	}
	
	


	@RequestMapping("/updateApp")
	public int updateApp(@RequestParam Integer id, String info, String url) {
		App app = new App();
		app.setInfo(info);
		app.setUrl(url);		
		app.setId(id);
		return appService.updateApp(app);
	}

	@RequestMapping("/freezeOrUnfreezeApp")
	public String freezeApp(HttpServletRequest request,Model model,@RequestParam Integer appId,@RequestParam Integer status) {
		App app = new App();
		app.setStatus(status);		
		app.setId(appId);
		if(status==CommonEnum.APP_STATUS_FREEZE.getValue()){
			if(appService.freezeAppById(appId)==1){			
			}else{
				model.addAttribute("error", "冻结失败");  
			}				
		}else if(status==CommonEnum.APP_STATUS_OK.getValue()){
			if(appService.unFreezeAppById(appId)==1){			
			}else{
				model.addAttribute("error", "解冻失败");  
			}				
		}
		return listAll( request, model);
	}	
	

}
