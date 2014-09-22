package com.alexgaoyh.common.util;

import java.util.ArrayList;
import java.util.List;

import com.alexgaoyh.util.GenericUtil;

public class Pagination<E> {
   
	public Pagination() {

	}

	public Pagination(int start, int pageSize) {
		this.start = start;
		this.pageSize = pageSize;
	}

	private int start;

	private int totalCount;

	private List<E> datas;
	
	private int pageSize = 10;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<E> getDatas() {
		return datas== null? new ArrayList<E>(): datas;
	}

	public void setDatas(List<E> datas) {
		GenericUtil.getActualClass(datas.getClass(), 0);
		this.datas = datas;
	}
}