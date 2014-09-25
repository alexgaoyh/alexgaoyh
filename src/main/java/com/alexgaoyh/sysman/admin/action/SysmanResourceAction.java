package com.alexgaoyh.sysman.admin.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alexgaoyh.common.action.BaseController;
import com.alexgaoyh.common.service.BaseService;
import com.alexgaoyh.common.vo.TreeNode;
import com.alexgaoyh.sysman.admin.entity.SysmanResource;
import com.alexgaoyh.sysman.admin.service.SysmanResourceService;

/**
 * 
 * @desc 用户后台资源资源权限表--RBAC权限管理action控制类
 *
 * @author alexgaoyh
 * @Fri Aug 08 13:29:41 CST 2014
 */
@Controller
@RequestMapping(value="admin/sysmanResource")
public class SysmanResourceAction extends BaseController<SysmanResource> {

	private static final Logger LOGGER = Logger.getLogger(SysmanResource.class);
	
	@Override
	@Resource(name = "sysmanResourceServiceImpl")
	public void setBaseService(BaseService<SysmanResource> baseService) {
		this.baseService = baseService;
	}
	
	private SysmanResourceService getService(){
		return (SysmanResourceService) this.baseService;
	}
	
	@Override
	public void getData(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		List<SysmanResource> _temp = this.getService().getRootResourceList();
		
		List<TreeNode> nodes = resourceToTreeNode(_temp);
		
		this.renderJson(nodes, response);
		
	}
	
	private List<TreeNode> resourceToTreeNode(List<SysmanResource> all) {
		List<TreeNode> nodeList = new ArrayList<TreeNode>();
		for(SysmanResource r : all){
			TreeNode node = new TreeNode();
			node.setText(r.getName());
			node.setState("open");
			node.setId(r.getPid());
			if(r.getSubResource() != null && r.getSubResource().size() > 0 ){
				node.setChildren(this.resourceToTreeNode(r.getSubResource()));
			} 
			nodeList.add(node);
		}
		return nodeList;
	}

}
