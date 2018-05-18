package com.spring.edu.utill;

import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.spring.edu.vo.ProductVo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class ProductExcelDownload extends AbstractExcelView {
	
	@SuppressWarnings("unlikely-arg-type")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String firstName = null;
		String fullName = "";
		firstName = new SimpleDateFormat("yyyyMMdd").format(new Date());
		fullName = firstName + "_상품리스트_엑셀다운로드.xls";
		
		Sheet workSheet = null;
		Row row = null;
		
		List<ProductVo> productExcelList = (List<ProductVo>) model.get("List");
		workSheet = workbook.createSheet("상품리스트");
		
		row = workSheet.createRow(0);
		
		row.createCell(0).setCellValue("상품번호");
		row.createCell(1).setCellValue("상품이름");
		row.createCell(2).setCellValue("상품성별");
		row.createCell(3).setCellValue("상품품종");
		row.createCell(4).setCellValue("상품가격");
		row.createCell(5).setCellValue("상품분양여부");
		row.createCell(6).setCellValue("상품예방접종");
		row.createCell(7).setCellValue("상품생년월일");
		row.createCell(8).setCellValue("상품이미지");
		row.createCell(9).setCellValue("상품등록일");
		
		System.out.println("listExcel.size() >> " + productExcelList.size());
								
		int rowIndex = 1;
		for(ProductVo list : productExcelList) {
			row = workSheet.createRow(rowIndex);
			row.createCell(0).setCellValue(list.getPdNo());
			row.createCell(1).setCellValue(list.getPdName());
			row.createCell(2).setCellValue(list.getPdGender());
			row.createCell(3).setCellValue(list.getPdKind());
			row.createCell(4).setCellValue(list.getPdPrice());
			row.createCell(5).setCellValue(list.getPdSale());
			row.createCell(6).setCellValue(list.getPdVaccine());
			row.createCell(7).setCellValue(list.getPdBirth());
			row.createCell(8).setCellValue(list.getPdImg());
			row.createCell(9).setCellValue(list.getPdRegdate());
			rowIndex++;
			
		}
		
		for (int i = 0; i <  productExcelList.size(); i++){ 
        	workSheet.autoSizeColumn(i); 
        	workSheet.setColumnWidth(i, (workSheet.getColumnWidth(i)) + 2000); 
        }
		
		try {

			response.setHeader("Content-Disposition", "attachement; filename=\""
	                + java.net.URLEncoder.encode(fullName, "UTF-8") + "\";charset=\"UTF-8\"");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
