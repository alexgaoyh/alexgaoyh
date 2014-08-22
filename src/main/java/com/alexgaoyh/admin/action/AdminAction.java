package com.alexgaoyh.admin.action;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="admin")
public class AdminAction {

	private static final Logger LOGGER = Logger.getLogger(AdminAction.class);
	
	@RequestMapping(value="login")  
    public ModelAndView login(@RequestParam(value = "error", required = false) boolean error,ModelMap model){
		if (error == true) {
			model.put("error","You have entered an invalid username or password!");
		} else {
			model.put("error", "");
		}
        return new ModelAndView("views/admin/login");
    }
	
	/**
	 * 指定无访问额权限页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/denied", method = RequestMethod.GET)
	public ModelAndView denied() {
		
		return new ModelAndView("views/admin/denied");
		
	}
	
	/**
	 * 跳转到adminpage页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/manager", method = RequestMethod.GET)
	public ModelAndView getAadminPage() {
		
		return new ModelAndView("views/admin/manager");

	}
}
