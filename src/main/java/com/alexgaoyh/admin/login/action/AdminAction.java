package com.alexgaoyh.admin.login.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alexgaoyh.admin.login.shiro.captcha.constant.CaptchaConstant;
import com.alexgaoyh.admin.login.shiro.captcha.exception.CaptchaException;
import com.alexgaoyh.sysman.admin.entity.SysmanUser;

@Controller
@RequestMapping(value="admin")
public class AdminAction {

	private static final Logger LOGGER = Logger.getLogger(AdminAction.class);
	
	/**
	 * 登陆页
	 * @param error
	 * @param model
	 * @return
	 */
	@RequestMapping(value="login")  
    public ModelAndView login(@RequestParam(value = "error", required = false) boolean error,ModelMap model){
		
		
		Subject subject = SecurityUtils.getSubject();
		//可以使用 subject.isAuthenticated() 以判断当前用户已经登录过了 此时可以直接通过subject.getSession()去获取我们放入session的信息了。
		System.out.println(" subject.isAuthenticated() = "+subject.isAuthenticated());
		SysmanUser user = (SysmanUser) subject.getPrincipal();
		
		
		if(user != null){
			model.put("userName", user.getUserName());
			System.out.println("user = "+user.getUserName());
		}
		
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
	public ModelAndView manager() {
		
		return new ModelAndView("views/admin/manager");

	}
	
	/**
	 * den
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public ModelAndView doLogin(HttpServletRequest request, HttpServletResponse response) {

		Map<String, Boolean> map = new HashMap<String, Boolean>();
		
		boolean loginStatus = false;
		boolean captchaStatus = false;
		
		String captcha = request.getParameter("Captcha");
		String exitCode = (String) request.getSession().getAttribute(CaptchaConstant.KEY_CAPTCHA);
		if (null == captcha || !captcha.equalsIgnoreCase(exitCode)) {
			System.out.println("验证码错误");
		}else{
			captchaStatus = true;
			
			String username = request.getParameter("userName");
			String password = request.getParameter("password");
			String rememberMe = request.getParameter("rememberMe");
			
			Md5Hash md5Hash = new Md5Hash(password);
			
			UsernamePasswordToken token = new UsernamePasswordToken(username, md5Hash.toHex(), Boolean.parseBoolean(rememberMe));
			
			System.out.println(token.getUsername());
			System.out.println(token.getPassword());
			
			try {
				Subject subject = SecurityUtils.getSubject();
				subject.login(token);
				token.clear();
				SysmanUser user = (SysmanUser) subject.getPrincipal();
				subject.getSession().setAttribute("adminCurrentUser", user);
				loginStatus = true;
				
			} catch (UnknownAccountException ex) {
				ex.printStackTrace();
				
			} catch (IncorrectCredentialsException ex) {
				ex.printStackTrace();
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		map.put("loginStatus", loginStatus);
		map.put("captchaStatus", captchaStatus);
		
		ModelAndView mav = new ModelAndView("views/admin/index", map);

		return mav;
	}
}
