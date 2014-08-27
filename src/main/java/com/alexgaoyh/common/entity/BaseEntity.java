package com.alexgaoyh.common.entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;


/**
 * 
 * @author Administrator
 * 
 */
@MappedSuperclass
public class BaseEntity implements Serializable {
	
	public final static int DELETE_FLAG_YES = 1 ;
	public final static int DELETE_FLAG_NO = 0 ;

	@Id
	@GeneratedValue(generator = "_increment")
	@GenericGenerator(name = "_increment", strategy = "increment")
	@Column(length=32)
	private Integer pid;
	
	/**
	 * 删除标志  1已经删除，0 正常
	 */
	@Column(precision = 1,name ="delete_flag")
	private Integer deleteFlag = DELETE_FLAG_NO ;
	
	@Temporal(TemporalType.TIMESTAMP)
	private  Date createTime  = new Date ();

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	

}
