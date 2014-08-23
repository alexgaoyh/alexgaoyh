package com.alexgaoyh.admin.shiro.common;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.alexgaoyh.sysman.admin.entity.SysmanResource;

public class FilterChainFactoryBean extends HibernateTemplate  implements FactoryBean<Map<String,String>> {
	

	
	@Override
	public Map<String, String> getObject() throws Exception {
		Map<String,String>  map = new LinkedHashMap<String,String>();
		map.put("/admin/login", "anon");
		map.put("/admin/doLogin", "anon");
		map.put("/admin/defined", "anon");
		
		
		String hql ="from "+SysmanResource.class.getName() + "  where href is not null and deleteFlag = 0  "; 
		
		
		@SuppressWarnings("unchecked")
		List<SysmanResource> rs = (List<SysmanResource>) this.find(hql);
		
		for(SysmanResource r : rs){
			if(r.getHref().lastIndexOf("?") > 0 ){
				map.put(r.getHref()+"&t_="+r.getPid(), "authc,perms["+r.getPid()+"]");
			}else{
				map.put(r.getHref()+"?t_="+r.getPid(), "authc,perms["+r.getPid()+"]");
			}
		}
		map.put("/admin/**", "authc");
		return map;
	}

	@Override
	public Class<?> getObjectType() {
		return Map.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
