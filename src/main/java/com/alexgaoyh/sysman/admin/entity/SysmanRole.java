package com.alexgaoyh.sysman.admin.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.alexgaoyh.common.entity.BaseEntity;

/**
 * 
 * @desc 用户后台登陆用户角色表--RBAC权限管理实体
 *
 * @author alexgaoyh
 * @Fri Aug 08 14:27:52 CST 2014
 */
@Entity
@Table(name="SYSMAN_ROLE")
public class SysmanRole extends BaseEntity{
	
	/**
	 * 角色名
	 */
	@Column(nullable =false,length=50)
	private String name;
	/**
	 * 角色描述
	 */
	@Column(length=200)
	private String description;
	/**
	 * 拥有权限
	 */
	@ManyToMany(cascade = CascadeType.DETACH)
	@JoinTable(name="SYSMAN_ROLE_RESOURCE",joinColumns ={@JoinColumn(name="role_id")},inverseJoinColumns={@JoinColumn(name="resource_id")})
	@Where(clause="delete_flag=0")
	private List<SysmanResource> resource;  
	
	/***
	 * 创建者
	 */
	@ManyToOne
	@JoinColumn(name = "creater_id")
	private SysmanUser creater;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<SysmanResource> getResource() {
		return resource;
	}

	public void setResource(List<SysmanResource> resource) {
		this.resource = resource;
	}

	public SysmanUser getCreater() {
		return creater;
	}

	public void setCreater(SysmanUser creater) {
		this.creater = creater;
	}
	
	
}