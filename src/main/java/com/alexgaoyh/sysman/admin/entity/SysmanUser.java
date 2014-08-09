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
}