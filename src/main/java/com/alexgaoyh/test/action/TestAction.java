package com.alexgaoyh.test.action;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alexgaoyh.test.entity.TestEntity;
import com.alexgaoyh.test.service.TestService;
import com.alexgaoyh.util.email.Email;
import com.alexgaoyh.util.email.EmailUtil;

/**
 * test方法，与业务无关
 * @author gaoyihang
 *
 */
@Controller
@RequestMapping(value="test")
public class TestAction {

	private static final Logger LOGGER = Logger.getLogger(TestAction.class);
	
	@Resource
	private TestService testService;
	
	
    @RequestMapping(value="login")  
    public ModelAndView login(){
        return new ModelAndView("views/test");
    }
    
    @RequestMapping(value="test")
    @ResponseBody
    public String saveEntity() throws Exception{
    	TestEntity te = new TestEntity();
    	testService.saveOrUpdate(te);
    	return JSONObject.valueToString(te);
    }
    
}
