package com.spring.edu.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ScheduleVo {

	/*스케줄 번호*/
	private int scheNo;
	
	/*유저 아이디*/
	private String uId;
	
	/*유저 전화번호*/
	private String uPhone;
	
	/*상품 번호*/
	private int pdNo;
	
	/*상품 이름*/
	private String pdName;
	
	/*상품 분양 유무*/
	private String pdSale;
	
	/*상품 분양 날짜*/
	private Date pdSaleDate;
	
	/*상품 분양 시간*/
	private int pdSaleTime;
	
	/*상품 분양 장소*/
	private int pdSaleSpace;
	
	/*상품 분양 메모*/
	private String pdSaleContent;
	
	
}
