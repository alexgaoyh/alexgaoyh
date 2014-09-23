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
 * @desc 用户后台登陆用户表--RBAC权限管理实体
 *
 * @author alexgaoyh
 * @Fri Aug 08 14:25:29 CST 2014
 */
@Entity
@Table(name="SYSMAN_USER")
public class SysmanUser extends BaseEntity{
	
	public static int STATUS_NORMAL = 1 ;
	public static int  STATUS_FORBIDDEN = 2;
	
	
	/**
	 * 用户名
	 */
	@Column(nullable = false,length=50)
	private String userName;
	/**
	 * 密码
	 */
	@Column(nullable = false,length=32)
	private String password;
	
	/***
	 * 创建者
	 */
	@ManyToOne
	@JoinColumn(name = "creater_id")
	private SysmanUser creater;
	/**
	 * 真实姓名
	 */
	@Column(name = "real_name",length=10)
	private String realName;
	/**
	 * 电子邮件
	 */
	@Column(length=50)
	private String email;
	/**
	 * 电话
	 */
	@Column(length=20)
	private String phone;
	/**
	 * 职务
	 */
	@Column(length=20)
	private String position;
	/**
	 * 职务说明
	 */
	@Column(name = "position_desc",length=100)
	private String positonDesc;


	@ManyToMany(cascade = CascadeType.DETACH)
	@JoinTable(name = "SYSMAN_USER_ROLE", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })
	@Where(clause="delete_flag=0")
	private  List<SysmanRole> roles;
	
	/**
	 * 1 : 正常  2 :禁用
	 */
	private Integer status;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public SysmanUser getCreater() {
		return creater;
	}

	public void setCreater(SysmanUser creater) {
		this.creater = creater;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPositonDesc() {
		return positonDesc;
	}

	public void setPositonDesc(String positonDesc) {
		this.positonDesc = positonDesc;
	}

	public List<SysmanRole> getRoles() {
		return roles;
	}

	public void setRoles(List<SysmanRole> roles) {
		this.roles = roles;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}