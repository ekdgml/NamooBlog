package com.namoo.blog.shared.page;

public class PageInfo {
	//
	private int pageNo;
	private int countPerPage;
	
	//--------------------------------------------------------------------------------
	//constructor
	
	public PageInfo() {
		//
		this.pageNo = 1;
		this.countPerPage = 10;
	}
	
	public PageInfo(int pageNo, int countPerPage) {
		//
		this.pageNo = pageNo;
		this.countPerPage = countPerPage;
	}
	//--------------------------------------------------------------------------------
	
	/**
	 * MySQL의 LIMIT의 시작인덱스 값으로 사용한다.
	 * 
	 * @return
	 */
	public int getStartIndex() {
		//
		return (pageNo - 1) * countPerPage;
	}
	
	//--------------------------------------------------------------------------------
	//getter, setter
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getCountPerPage() {
		return countPerPage;
	}
	public void setCountPerPage(int countPerPage) {
		this.countPerPage = countPerPage;
	}
}
