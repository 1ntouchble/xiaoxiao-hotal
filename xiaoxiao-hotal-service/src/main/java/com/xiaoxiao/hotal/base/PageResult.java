package com.xiaoxiao.hotal.base;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.List;

public class PageResult<T> implements Serializable {

	/**
	 * 列表查询结果
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 搜索到的信息总数
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private long totalResults;
	/**
	 * 是否存在下一页
	 */
	private boolean hasNext;

	/**
	 * 列表数据
	 */
	private List<T> data;
	private int pageSize;

	private int pageNo;

	public PageResult() {
	}

	public PageResult(Page<T> pageList) {
		super();
		this.pageNo = pageList.getPageNum();
		this.pageSize = pageList.getPageSize();
		this.totalResults = pageList.getTotal();
		this.data = pageList.getResult();
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public long getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(long totalResults) {
		this.totalResults = totalResults;
	}

	public boolean isHasNext() {
		return hasNext;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "PageResult [totalResults=" + totalResults + ", hasNext=" + hasNext + ", data=" + data + "]";
	}
}