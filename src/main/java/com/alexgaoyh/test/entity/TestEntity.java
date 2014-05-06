package com.alexgaoyh.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.alexgaoyh.common.entity.BaseEntity;

@Entity
@Table(name="test_entity")
public class TestEntity extends BaseEntity{

	@Column(nullable=false)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
