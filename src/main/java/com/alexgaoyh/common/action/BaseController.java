package com.alexgaoyh.common.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alexgaoyh.common.entity.BaseEntity;
import com.alexgaoyh.common.service.BaseService;

public abstract class BaseController<E extends BaseEntity> {
	
	protected BaseService<E> baseService;
	
	public abstract void setBaseService(BaseService<E> baseService);

	public BaseService<E> getBaseService() {
		return baseService;
	}

	/**
	 * 后台list页面
	 * 如请求地址为：   	http://localhost:8080/web/sysmanRole/list
	 * 则返回的页面应该在    /web/WEB-INF/views/sysmanRole/list.jsp
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		RequestMapping rm = this.getClass().getAnnotation(RequestMapping.class);
		String moduleName = "";
		if (rm != null) {
			String[] values = rm.value();
			if (ArrayUtils.isNotEmpty(values)) {
				moduleName = values[0];
			}
		}
		if (moduleName.endsWith("/")) {
			moduleName = moduleName.substring(0, moduleName.length() - 1);
		}
		System.out.println(moduleName);
		return new ModelAndView("views/" + moduleName + "/list");
	}
	
	
	@RequestMapping(value="getData")
    @ResponseBody
	public void getData(HttpServletRequest request) {
		System.out.println(request.getParameter("page"));//easyui datagrid 分页 页号
		System.out.println(request.getParameter("rows"));//easyui datagrid 分页 页数
		System.out.println(this.getBaseService());
	}
	
}
