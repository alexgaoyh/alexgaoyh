package com.alexgaoyh.admin.login.action;

import java.util.HashMap;
import java.util.List;
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
import com.alexgaoyh.sysman.admin.entity.SysmanResource;
import com.alexgaoyh.sysman.admin.entity.SysmanUser;
import com.alexgaoyh.sysman.admin.util.SysmanResourceUtil;

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
		Subject subject = SecurityUtils.getSubject();
		SysmanUser user = (SysmanUser) subject.getPrincipal();
		
		return new ModelAndView("views/admin/denied");
		
	}
	
	/**
	 * 跳转到manager页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/manager", method = RequestMethod.GET)
	public ModelAndView manager() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Subject subject = SecurityUtils.getSubject();
		SysmanUser user = (SysmanUser) subject.getPrincipal();
		
		List<SysmanResource> sysmanResourceList = SysmanResourceUtil.getResourceListByUser(user);
		
		map.put("sysmanUser", user);
		map.put("sysmanResourceList", sysmanResourceList);
		
		return new ModelAndView("views/admin/manager", map);

	}
	
	/**
	 * 后台shiro登陆方法
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
	
	
	/**
	 * shiro 登出方法
	 * @return
	 */
	@RequestMapping(value="logout")
	public ModelAndView doLogout() {
		Subject subject = SecurityUtils.getSubject();
		if (subject.isAuthenticated()) {
			SysmanUser user = (SysmanUser) subject.getPrincipal();
			System.out.println("登出用户：" + user.getUserName() );
			subject.logout(); // session 会销毁，在SessionListener监听session销毁，清理权限缓存
		}
		
		return new ModelAndView("views/admin/login");
	}
}
