package com.spring.edu.utill;

import lombok.Data;

@Data
public class Criteria {

	/*검색 조건*/
	private String searchType;
	
	/*검색 키워드*/
	private String keyword;
	
	/*현재 조회하는 페이지 번호*/
	private int page;
	
	/*한 페이지당 출력하는 게시물 개수*/
	private int perPageNum;
	
	
	public Criteria() {
		this.page=1;
		this.perPageNum=10;
	}
	
	public Criteria(int perPageNum) {
		this.page=1;
		this.perPageNum=perPageNum;
	}
	
	public void setPage(int page) {
		if(page<=0) {
			this.page=1;
			return;
		}
		this.page=page;
	}
	
	public void setPerPageNum(int perPageNum) {
/*		if(perPageNum<=0  || perPageNum > 100) {
			this.perPageNum=10;
			return;
		}*/
		this.perPageNum=perPageNum;
	}
}
