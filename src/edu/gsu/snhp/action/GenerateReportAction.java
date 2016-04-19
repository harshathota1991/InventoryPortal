package edu.gsu.snhp.action;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.jdbc.Blob;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.gsu.snhp.bean.CreateReportBean;
import edu.gsu.snhp.bean.GenerateReportBean;
import edu.gsu.snhp.dao.ExcelDB;
import edu.gsu.snhp.dao.ReportDB;
import edu.gsu.snhp.util.DBConn;




public class GenerateReportAction extends ActionSupport implements ModelDriven<GenerateReportBean>{

	
	private static final long serialVersionUID = 1L;
	String result;
	GenerateReportBean generateReportBean = new GenerateReportBean();
	ReportDB reportDB= new ReportDB();
	ExcelDB excelDB= new ExcelDB();
	public ArrayList<CreateReportBean> createReportList = new ArrayList<CreateReportBean>();
	CreateReportBean createReportBean= new CreateReportBean();
	private InputStream inputStream;
	private String reportFile;
	private String pdfFile;
	
	
	
	

	public String getGenerateView(){
		
		//System.out.println("in execute report");
		
		createReportList=reportDB.getReportValues(generateReportBean); 
		//System.out.println(createReportList.size());

		this.setCreateReportList(createReportList);

				
		if(createReportList.isEmpty()){
			
			result="failure";
		}else {
			result="success";
		}
		
		return result;
	}

	public String getGenerateExcel(){
		
		//System.out.println("in execute Excel report");
		HSSFWorkbook myWorkBook = new HSSFWorkbook();
		HSSFSheet mySheet = myWorkBook.createSheet();
		try {
		Calendar calendar = Calendar.getInstance();
		createReportList=excelDB.getReportValues(generateReportBean); 
		this.setCreateReportList(createReportList);
		//System.out.println((createReportList.size()));
		reportFile = "SNHP Report" + calendar.get(Calendar.YEAR)+ "".concat(".xls");
		Row headerRow = mySheet.createRow(0);
		headerRow.setHeightInPoints(50);
		Cell titleCell = headerRow.createCell(0);
		titleCell.setCellValue("SNHP DB Report "+ calendar.get(Calendar.YEAR) + "");
		setStudentAllInfo(mySheet, createReportList);
		try {
		ByteArrayOutputStream boas = new ByteArrayOutputStream();
		myWorkBook.write(boas);
		setInputStream(new ByteArrayInputStream(boas.toByteArray()));
		} catch(IOException e) {
				e.printStackTrace();
		}
		} catch (Exception e) {
				e.printStackTrace();
		}
		return SUCCESS;
		}

	
	
			private void setStudentAllInfo(HSSFSheet mySheet, ArrayList<CreateReportBean> studentBeans) 
			{
				int rowNum = 2;
				HSSFRow myRow = null;
				final String[] errorSource = { "PersonFirstName","PersonLastName","PersonType","PersonDepartment","PersonOfficePhone","PersonCellPhone","PersonHomePhone","PersonOfficeEmail","PersonTitle","PersonHonorific","AssetDescription","AssetManufacturer","AssetSerialNumber","AssetModelNameNumber","AssetGSUdecalNumber","AssetLabelNumber","AssetMACaddress","AssetIPaddress","AssetCompName","AssetServiceTag","DateEntered","DateSurplusPU","OnOffCampus","AssetOffCampusAddress","Status","TechFee","WarrantyEndDate","Comment","Owner","ImageAsset","BuildingName","LocationType","LocationRoomNumber","LocationRoomName","OldLocationComment","ITportLAN1","ITportPhone1","ITportLAN2","ITportPhone2","ITportLAN3","ITportPhone3","ITportLAN4","ITportPhone4","ITportLAN5","ITportPhone5","PersonHomeEmail" };
				try{
						Row header = mySheet.createRow(1);
						for (int i = 0; i < errorSource.length; i++) 
						{
							Cell monthCell = header.createCell(i);
							monthCell.setCellValue(errorSource[i]);
						}
						for (CreateReportBean studentBean : studentBeans) 
						{
							myRow = mySheet.createRow(rowNum++);
							
							myRow.createCell(0).setCellValue(studentBean.getPersonFirstName());
							
							myRow.createCell(1).setCellValue(studentBean.getPersonLastName());
							
							myRow.createCell(2).setCellValue(studentBean.getPersonType());
							
							myRow.createCell(3).setCellValue(studentBean.getPersonDepartment());
							
							myRow.createCell(4).setCellValue(studentBean.getPersonOfficePhone());
							
							myRow.createCell(5).setCellValue(studentBean.getPersonCellPhone());
							
							myRow.createCell(6).setCellValue(studentBean.getPersonHomePhone());
							
							myRow.createCell(7).setCellValue(studentBean.getPersonOfficeEmail());
							
							myRow.createCell(8).setCellValue(studentBean.getPersonTitle());
							
							myRow.createCell(9).setCellValue(studentBean.getPersonHonorific());
							
							myRow.createCell(10).setCellValue(studentBean.getAssetDescription());
							
							myRow.createCell(11).setCellValue(studentBean.getAssetManufacturer());
							
							myRow.createCell(12).setCellValue(studentBean.getAssetSerialNumber());
							
							myRow.createCell(13).setCellValue(studentBean.getAssetModelNameNumber());
							
							myRow.createCell(14).setCellValue(studentBean.getAssetGSUdecalNumber());
							
							myRow.createCell(15).setCellValue(studentBean.getAssetLabelNumber());
							
							myRow.createCell(16).setCellValue(studentBean.getAssetMACaddress());
							
							myRow.createCell(17).setCellValue(studentBean.getAssetIPaddress());
							
							myRow.createCell(18).setCellValue(studentBean.getAssetCompName());
							
							myRow.createCell(19).setCellValue(studentBean.getAssetServiceTag());
							
							myRow.createCell(20).setCellValue(studentBean.getDateEntered());
							
							myRow.createCell(21).setCellValue(studentBean.getDateSurplusPU());
							
							myRow.createCell(22).setCellValue(studentBean.getOnOffCampus());
							
							myRow.createCell(23).setCellValue(studentBean.getAssetOffCampusAddress());
							
							myRow.createCell(24).setCellValue(studentBean.getStatus());
							
							myRow.createCell(25).setCellValue(studentBean.getTechFee());
							
							myRow.createCell(26).setCellValue(studentBean.getWarrantyEndDate());
							
							myRow.createCell(27).setCellValue(studentBean.getComment());
							
							myRow.createCell(28).setCellValue(studentBean.getOwner());
							
							myRow.createCell(29).setCellValue(studentBean.getImageAsset());
							
							myRow.createCell(30).setCellValue(studentBean.getBuildingName());
							
							myRow.createCell(31).setCellValue(studentBean.getLocationType());
							
							myRow.createCell(32).setCellValue(studentBean.getLocationRoomNumber());
							
							myRow.createCell(33).setCellValue(studentBean.getLocationRoomName());
							
							myRow.createCell(34).setCellValue(studentBean.getOldLocationComment());
							
							myRow.createCell(35).setCellValue(studentBean.getITportLAN1());
							
							myRow.createCell(36).setCellValue(studentBean.getITportPhone1());
							
							myRow.createCell(37).setCellValue(studentBean.getITportLAN2());
							
							myRow.createCell(38).setCellValue(studentBean.getITportPhone2());
							
							myRow.createCell(39).setCellValue(studentBean.getITportLAN3());
							
							myRow.createCell(40).setCellValue(studentBean.getITportPhone3());
							
							myRow.createCell(41).setCellValue(studentBean.getITportLAN4());
							
							myRow.createCell(42).setCellValue(studentBean.getITportPhone4());
							
							myRow.createCell(43).setCellValue(studentBean.getITportLAN5());
							
							myRow.createCell(44).setCellValue(studentBean.getITportPhone5());
							
							myRow.createCell(45).setCellValue(studentBean.getPersonHomeEmail()); 
							
				
						} 
					}
					catch (Exception e) 
					{
						e.printStackTrace();
					}	
		
			}
			
			
	public String getGeneratePDF(){
		
		//System.out.println("in pdf action");
		
		try {
			
		//Calendar calendar = Calendar.getInstance();

		createReportList=excelDB.getReportValues(generateReportBean); 
		this.setCreateReportList(createReportList);
		Rectangle pagesize = new Rectangle(4000,4000);
		 Document document = new Document(pagesize);
         ByteArrayOutputStream baos = new ByteArrayOutputStream();
         PdfWriter writer = PdfWriter.getInstance(document, baos);
         writer.setUserunit(4000f);

        try{
        document.open();
        
        
        
        PdfPTable pdfTable =new PdfPTable(47); // 47 is number of columns in table
		
		pdfTable.setWidthPercentage(100); //Width 100%
		pdfTable.setSpacingBefore(10f); //Space before table
		pdfTable.setSpacingAfter(10f); //Space after table
		
        //Set Column widths
        float[] columnWidths = {10f,10f,10f,10f,10f,10f,10f,10f,10f,10f,10f,10f,10f,10f,10f,10f,10f,10f,10f,10f,10f,10f,10f,10f,10f,10f,10f,10f,10f,10f,10f,10f,10f,10f,10f,10f,10f,10f,10f,10f,10f,10f,10f,10f,10f,10f,10f};
        pdfTable.setWidths(columnWidths);
        
       
 
       PdfPCell cell1 = new PdfPCell(new Paragraph("Person First Name"));
        cell1.setBorderColor(BaseColor.BLUE);
        cell1.setPaddingLeft(10);
        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell cell2 = new PdfPCell(new Paragraph("Person Last Name"));
        cell2.setBorderColor(BaseColor.BLUE);
        cell2.setPaddingLeft(10);
        cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell cell3 = new PdfPCell(new Paragraph("Person Type"));
        cell3.setBorderColor(BaseColor.BLUE);
        cell3.setPaddingLeft(10);
        cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
        
        PdfPCell cell4 = new PdfPCell(new Paragraph("Person Department"));
        cell4.setBorderColor(BaseColor.BLUE);
        cell4.setPaddingLeft(10);
        cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell cell5 = new PdfPCell(new Paragraph("Person Office Phone"));
        cell5.setBorderColor(BaseColor.BLUE);
        cell5.setPaddingLeft(10);
        cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell cell6 = new PdfPCell(new Paragraph("Person Cell Phone"));
        cell6.setBorderColor(BaseColor.BLUE);
        cell6.setPaddingLeft(10);
        cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell cell7 = new PdfPCell(new Paragraph("Person Home Phone"));
        cell7.setBorderColor(BaseColor.BLUE);
        cell7.setPaddingLeft(10);
        cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell7.setVerticalAlignment(Element.ALIGN_MIDDLE);
        
        PdfPCell cell8 = new PdfPCell(new Paragraph("Person Office Email"));
        cell8.setBorderColor(BaseColor.BLUE);
        cell8.setPaddingLeft(10);
        cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell8.setVerticalAlignment(Element.ALIGN_MIDDLE);
        
        PdfPCell cell9 = new PdfPCell(new Paragraph("Person Home Email"));
        cell9.setBorderColor(BaseColor.BLUE);
        cell9.setPaddingLeft(10);
        cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell9.setVerticalAlignment(Element.ALIGN_MIDDLE);   
        
        PdfPCell cell10 = new PdfPCell(new Paragraph("Person Title"));
        cell10.setBorderColor(BaseColor.BLUE);
        cell10.setPaddingLeft(10);
        cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell10.setVerticalAlignment(Element.ALIGN_MIDDLE);   
        
        PdfPCell cell11 = new PdfPCell(new Paragraph("Person Honorific"));
        cell11.setBorderColor(BaseColor.BLUE);
        cell11.setPaddingLeft(10);
        cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell11.setVerticalAlignment(Element.ALIGN_MIDDLE);  
        
        PdfPCell cell12 = new PdfPCell(new Paragraph("Asset Description"));
        cell12.setBorderColor(BaseColor.BLUE);
        cell12.setPaddingLeft(10);
        cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell12.setVerticalAlignment(Element.ALIGN_MIDDLE); 
        
        PdfPCell cell13 = new PdfPCell(new Paragraph("Asset Manufacturer"));
        cell13.setBorderColor(BaseColor.BLUE);
        cell13.setPaddingLeft(10);
        cell13.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell13.setVerticalAlignment(Element.ALIGN_MIDDLE); 
       
        PdfPCell cell14 = new PdfPCell(new Paragraph("Asset Serial Number"));
        cell14.setBorderColor(BaseColor.BLUE);
        cell14.setPaddingLeft(10);
        cell14.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell14.setVerticalAlignment(Element.ALIGN_MIDDLE); 
        
        PdfPCell cell15 = new PdfPCell(new Paragraph("Asset Model Name Number"));
        cell15.setBorderColor(BaseColor.BLUE);
        cell15.setPaddingLeft(10);
        cell15.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell15.setVerticalAlignment(Element.ALIGN_MIDDLE); 
        
       
        PdfPCell cell16 = new PdfPCell(new Paragraph("Asset GSU Decal Number"));
        cell16.setBorderColor(BaseColor.BLUE);
        cell16.setPaddingLeft(10);
        cell16.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell16.setVerticalAlignment(Element.ALIGN_MIDDLE); 
        
        PdfPCell cell17 = new PdfPCell(new Paragraph("Asset Label Number"));
        cell17.setBorderColor(BaseColor.BLUE);
        cell17.setPaddingLeft(10);
        cell17.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell17.setVerticalAlignment(Element.ALIGN_MIDDLE); 
        
        
        PdfPCell cell18 = new PdfPCell(new Paragraph("Asset MAC Address"));
        cell18.setBorderColor(BaseColor.BLUE);
        cell18.setPaddingLeft(10);
        cell18.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell18.setVerticalAlignment(Element.ALIGN_MIDDLE); 
        
        PdfPCell cell19 = new PdfPCell(new Paragraph("Asset IP Address"));
        cell19.setBorderColor(BaseColor.BLUE);
        cell19.setPaddingLeft(10);
        cell19.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell19.setVerticalAlignment(Element.ALIGN_MIDDLE); 
        
        PdfPCell cell20 = new PdfPCell(new Paragraph("Asset Comp Name"));
        cell20.setBorderColor(BaseColor.BLUE);
        cell20.setPaddingLeft(10);
        cell20.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell20.setVerticalAlignment(Element.ALIGN_MIDDLE); 
        
        PdfPCell cell21 = new PdfPCell(new Paragraph("Asset Service Tag"));
        cell21.setBorderColor(BaseColor.BLUE);
        cell21.setPaddingLeft(10);
        cell21.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell21.setVerticalAlignment(Element.ALIGN_MIDDLE); 
        
        
        PdfPCell cell22 = new PdfPCell(new Paragraph("Date Entered"));
        cell22.setBorderColor(BaseColor.BLUE);
        cell22.setPaddingLeft(10);
        cell22.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell22.setVerticalAlignment(Element.ALIGN_MIDDLE); 
        
        
        PdfPCell cell23 = new PdfPCell(new Paragraph("Date Surplus PU"));
        cell23.setBorderColor(BaseColor.BLUE);
        cell23.setPaddingLeft(10);
        cell23.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell23.setVerticalAlignment(Element.ALIGN_MIDDLE); 
        
        
        PdfPCell cell24 = new PdfPCell(new Paragraph("On OFF Campus"));
        cell24.setBorderColor(BaseColor.BLUE);
        cell24.setPaddingLeft(10);
        cell24.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell24.setVerticalAlignment(Element.ALIGN_MIDDLE); 
        
        
        PdfPCell cell25 = new PdfPCell(new Paragraph("Asset Off Campus Address"));
        cell25.setBorderColor(BaseColor.BLUE);
        cell25.setPaddingLeft(10);
        cell25.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell25.setVerticalAlignment(Element.ALIGN_MIDDLE); 
        
        
        PdfPCell cell26 = new PdfPCell(new Paragraph("Status"));
        cell26.setBorderColor(BaseColor.BLUE);
        cell26.setPaddingLeft(10);
        cell26.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell26.setVerticalAlignment(Element.ALIGN_MIDDLE); 
        
        
        PdfPCell cell27 = new PdfPCell(new Paragraph("Tech Fee"));
        cell27.setBorderColor(BaseColor.BLUE);
        cell27.setPaddingLeft(10);
        cell27.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell27.setVerticalAlignment(Element.ALIGN_MIDDLE); 
        
        
        PdfPCell cell28 = new PdfPCell(new Paragraph("Warranty End Date"));
        cell28.setBorderColor(BaseColor.BLUE);
        cell28.setPaddingLeft(10);
        cell28.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell28.setVerticalAlignment(Element.ALIGN_MIDDLE); 
        
        
        PdfPCell cell29 = new PdfPCell(new Paragraph("Comment"));
        cell29.setBorderColor(BaseColor.BLUE);
        cell29.setPaddingLeft(10);
        cell29.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell29.setVerticalAlignment(Element.ALIGN_MIDDLE); 
        
        
        PdfPCell cell30 = new PdfPCell(new Paragraph("Owner"));
        cell30.setBorderColor(BaseColor.BLUE);
        cell30.setPaddingLeft(10);
        cell30.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell30.setVerticalAlignment(Element.ALIGN_MIDDLE); 
        
        PdfPCell cell31 = new PdfPCell(new Paragraph("Image Asset"));
        cell31.setBorderColor(BaseColor.BLUE);
        cell31.setPaddingLeft(10);
        cell31.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell31.setVerticalAlignment(Element.ALIGN_MIDDLE); 
        
        
        PdfPCell cell32 = new PdfPCell(new Paragraph("Building Name"));
        cell32.setBorderColor(BaseColor.BLUE);
        cell32.setPaddingLeft(10);
        cell32.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell32.setVerticalAlignment(Element.ALIGN_MIDDLE); 
        
        PdfPCell cell33 = new PdfPCell(new Paragraph("Location Type"));
        cell33.setBorderColor(BaseColor.BLUE);
        cell33.setPaddingLeft(10);
        cell33.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell33.setVerticalAlignment(Element.ALIGN_MIDDLE); 
        
        PdfPCell cell34 = new PdfPCell(new Paragraph("Location Room Number "));
        cell34.setBorderColor(BaseColor.BLUE);
        cell34.setPaddingLeft(10);
        cell34.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell34.setVerticalAlignment(Element.ALIGN_MIDDLE); 
        
        PdfPCell cell35 = new PdfPCell(new Paragraph("Location Room Name"));
        cell35.setBorderColor(BaseColor.BLUE);
        cell35.setPaddingLeft(10);
        cell35.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell35.setVerticalAlignment(Element.ALIGN_MIDDLE); 
        
        PdfPCell cell36 = new PdfPCell(new Paragraph("Old Location Comment"));
        cell36.setBorderColor(BaseColor.BLUE);
        cell36.setPaddingLeft(10);
        cell36.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell36.setVerticalAlignment(Element.ALIGN_MIDDLE); 
        
        PdfPCell cell37 = new PdfPCell(new Paragraph("IT port LAN1"));
        cell37.setBorderColor(BaseColor.BLUE);
        cell37.setPaddingLeft(10);
        cell37.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell37.setVerticalAlignment(Element.ALIGN_MIDDLE); 
        
        PdfPCell cell38 = new PdfPCell(new Paragraph("IT port Phone1"));
        cell38.setBorderColor(BaseColor.BLUE);
        cell38.setPaddingLeft(10);
        cell38.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell38.setVerticalAlignment(Element.ALIGN_MIDDLE); 
        
        PdfPCell cell39 = new PdfPCell(new Paragraph("IT port LAN2"));
        cell39.setBorderColor(BaseColor.BLUE);
        cell39.setPaddingLeft(10);
        cell39.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell39.setVerticalAlignment(Element.ALIGN_MIDDLE); 
        
        PdfPCell cell40= new PdfPCell(new Paragraph("IT port Phone2"));
        cell40.setBorderColor(BaseColor.BLUE);
        cell40.setPaddingLeft(10);
        cell40.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell40.setVerticalAlignment(Element.ALIGN_MIDDLE); 
        
        PdfPCell cell41 = new PdfPCell(new Paragraph("IT port LAN3"));
        cell41.setBorderColor(BaseColor.BLUE);
        cell41.setPaddingLeft(10);
        cell41.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell41.setVerticalAlignment(Element.ALIGN_MIDDLE); 
        
        PdfPCell cell42 = new PdfPCell(new Paragraph("IT port Phone3"));
        cell42.setBorderColor(BaseColor.BLUE);
        cell42.setPaddingLeft(10);
        cell42.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell42.setVerticalAlignment(Element.ALIGN_MIDDLE); 
        
        PdfPCell cell43 = new PdfPCell(new Paragraph("IT port LAN4"));
        cell43.setBorderColor(BaseColor.BLUE);
        cell43.setPaddingLeft(10);
        cell43.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell43.setVerticalAlignment(Element.ALIGN_MIDDLE); 
        
        PdfPCell cell44 = new PdfPCell(new Paragraph("IT port Phone4"));
        cell44.setBorderColor(BaseColor.BLUE);
        cell44.setPaddingLeft(10);
        cell44.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell44.setVerticalAlignment(Element.ALIGN_MIDDLE); 
        
        PdfPCell cell45 = new PdfPCell(new Paragraph("IT port LAN5"));
        cell45.setBorderColor(BaseColor.BLUE);
        cell45.setPaddingLeft(10);
        cell45.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell45.setVerticalAlignment(Element.ALIGN_MIDDLE); 
        
        PdfPCell cell46 = new PdfPCell(new Paragraph("IT port Phone5"));
        cell46.setBorderColor(BaseColor.BLUE);
        cell46.setPaddingLeft(10);
        cell46.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell46.setVerticalAlignment(Element.ALIGN_MIDDLE); 
        
        PdfPCell cell47 = new PdfPCell(new Paragraph("Image"));
        cell47.setBorderColor(BaseColor.BLUE);
        cell47.setPaddingLeft(10);
        cell47.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell47.setVerticalAlignment(Element.ALIGN_MIDDLE); 
        
        cell1.setUseBorderPadding(true);
        cell2.setUseBorderPadding(true);
        cell3.setUseBorderPadding(true);
        cell4.setUseBorderPadding(true);
        cell5.setUseBorderPadding(true);
        cell6.setUseBorderPadding(true);
        cell7.setUseBorderPadding(true);
        cell8.setUseBorderPadding(true);
        cell9.setUseBorderPadding(true);
        cell10.setUseBorderPadding(true);
        cell11.setUseBorderPadding(true);
        cell12.setUseBorderPadding(true);
        cell13.setUseBorderPadding(true);
        cell14.setUseBorderPadding(true);
        cell15.setUseBorderPadding(true);
        cell16.setUseBorderPadding(true);
        cell17.setUseBorderPadding(true);
        cell18.setUseBorderPadding(true);
        cell19.setUseBorderPadding(true);
        cell20.setUseBorderPadding(true);
        cell21.setUseBorderPadding(true);
        cell22.setUseBorderPadding(true);
        cell23.setUseBorderPadding(true);
        cell24.setUseBorderPadding(true);
        cell25.setUseBorderPadding(true);
        cell26.setUseBorderPadding(true);
        cell27.setUseBorderPadding(true);
        cell28.setUseBorderPadding(true);
        cell29.setUseBorderPadding(true);
        cell30.setUseBorderPadding(true);
        cell31.setUseBorderPadding(true);
        cell32.setUseBorderPadding(true);
        cell33.setUseBorderPadding(true);
        cell34.setUseBorderPadding(true);
        cell35.setUseBorderPadding(true);
        cell36.setUseBorderPadding(true);
        cell37.setUseBorderPadding(true);
        cell38.setUseBorderPadding(true);
        cell39.setUseBorderPadding(true);
        cell40.setUseBorderPadding(true);
        cell41.setUseBorderPadding(true);
        cell42.setUseBorderPadding(true);
        cell43.setUseBorderPadding(true);
        cell44.setUseBorderPadding(true);
        cell45.setUseBorderPadding(true);
        cell46.setUseBorderPadding(true);
        cell47.setUseBorderPadding(true);
         
        pdfTable.addCell(cell1);
        pdfTable.addCell(cell2);
        pdfTable.addCell(cell3);
        pdfTable.addCell(cell4);
        pdfTable.addCell(cell5);
        pdfTable.addCell(cell6);
        pdfTable.addCell(cell7);
        pdfTable.addCell(cell8);
        pdfTable.addCell(cell9);
        pdfTable.addCell(cell10);
        pdfTable.addCell(cell11);
        pdfTable.addCell(cell12);
        pdfTable.addCell(cell13);
        pdfTable.addCell(cell14);
        pdfTable.addCell(cell15);
        pdfTable.addCell(cell16);
        pdfTable.addCell(cell17);
        pdfTable.addCell(cell18);
        pdfTable.addCell(cell19);
        pdfTable.addCell(cell20);
        pdfTable.addCell(cell21);
        pdfTable.addCell(cell22);
        pdfTable.addCell(cell23);
        pdfTable.addCell(cell24);
        pdfTable.addCell(cell25);
        pdfTable.addCell(cell26);
        pdfTable.addCell(cell27);
        pdfTable.addCell(cell28);
        pdfTable.addCell(cell29);
        pdfTable.addCell(cell30);
        pdfTable.addCell(cell31);
        pdfTable.addCell(cell32);
        pdfTable.addCell(cell33);
        pdfTable.addCell(cell34);
        pdfTable.addCell(cell35);
        pdfTable.addCell(cell36);
        pdfTable.addCell(cell37);
        pdfTable.addCell(cell38);
        pdfTable.addCell(cell39);
        pdfTable.addCell(cell40);
        pdfTable.addCell(cell41);
        pdfTable.addCell(cell42);
        pdfTable.addCell(cell43);
        pdfTable.addCell(cell44);
        pdfTable.addCell(cell45);
        pdfTable.addCell(cell46);
        pdfTable.addCell(cell47);
        
        pdfTable.setHeaderRows(1);
        PdfPCell[] cells = pdfTable.getRow(0).getCells(); 
        	for (int j=0;j<cells.length;j++){
	  	     cells[j].setBackgroundColor(BaseColor.LIGHT_GRAY);
	  	  }
        
        
        System.out.println("CreateReportList Size in for loop:" + createReportList.size());	
        	
        for (int i=0;i<createReportList.size();i++){
        	System.out.println("CreateReportList Size in for loop iii:" + i);
        
        pdfTable.addCell(createReportList.get(i).getPersonFirstName());
        pdfTable.addCell(createReportList.get(i).getPersonLastName());
        pdfTable.addCell(createReportList.get(i).getPersonType());
        pdfTable.addCell(createReportList.get(i).getPersonDepartment());
        pdfTable.addCell(createReportList.get(i).getPersonOfficePhone());
        pdfTable.addCell(createReportList.get(i).getPersonCellPhone());
        pdfTable.addCell(createReportList.get(i).getPersonHomePhone());
        pdfTable.addCell(createReportList.get(i).getPersonOfficeEmail());
        pdfTable.addCell(createReportList.get(i).getPersonHomeEmail());
        pdfTable.addCell(createReportList.get(i).getPersonTitle());
 
        pdfTable.addCell(createReportList.get(i).getPersonHonorific());
        pdfTable.addCell(createReportList.get(i).getAssetDescription());
        pdfTable.addCell(createReportList.get(i).getAssetManufacturer());
        pdfTable.addCell(createReportList.get(i).getAssetSerialNumber());
        pdfTable.addCell(createReportList.get(i).getAssetModelNameNumber());
        pdfTable.addCell(createReportList.get(i).getAssetGSUdecalNumber());
        pdfTable.addCell(createReportList.get(i).getAssetLabelNumber());
        pdfTable.addCell(createReportList.get(i).getAssetMACaddress());
        pdfTable.addCell(createReportList.get(i).getAssetIPaddress());
        pdfTable.addCell(createReportList.get(i).getAssetCompName());
        
        pdfTable.addCell(createReportList.get(i).getAssetServiceTag());
        pdfTable.addCell(createReportList.get(i).getDateEntered().toString());
        pdfTable.addCell(createReportList.get(i).getDateSurplusPU().toString());
        pdfTable.addCell(createReportList.get(i).getOnOffCampus());
        pdfTable.addCell(createReportList.get(i).getAssetOffCampusAddress());
        pdfTable.addCell(createReportList.get(i).getStatus());
        pdfTable.addCell(createReportList.get(i).getTechFee());
        pdfTable.addCell(createReportList.get(i).getWarrantyEndDate().toString());
        pdfTable.addCell(createReportList.get(i).getComment());
        pdfTable.addCell(createReportList.get(i).getOwner());
        
        pdfTable.addCell(createReportList.get(i).getImageAsset());
        pdfTable.addCell(createReportList.get(i).getBuildingName());
        pdfTable.addCell(createReportList.get(i).getLocationType());
        pdfTable.addCell(createReportList.get(i).getLocationRoomNumber());
        pdfTable.addCell(createReportList.get(i).getLocationRoomName());
        pdfTable.addCell(createReportList.get(i).getOldLocationComment());
        pdfTable.addCell(createReportList.get(i).getITportLAN1());
        pdfTable.addCell(createReportList.get(i).getITportPhone1());
        pdfTable.addCell(createReportList.get(i).getITportLAN2());
        pdfTable.addCell(createReportList.get(i).getITportPhone2());
        
        pdfTable.addCell(createReportList.get(i).getITportLAN3());
        pdfTable.addCell(createReportList.get(i).getITportPhone3());
        pdfTable.addCell(createReportList.get(i).getITportLAN4());
        pdfTable.addCell(createReportList.get(i).getITportPhone4());
        pdfTable.addCell(createReportList.get(i).getITportLAN5());
        pdfTable.addCell(createReportList.get(i).getITportPhone5());
        System.out.println("1");
        
        try {  
        		Connection conn;
        		DBConn con=new DBConn();
        		conn=con.getDBConnection();
				PreparedStatement ps = conn.prepareStatement("select ImageDocs from personassetlocation where PAL_ID = ?"); 
        		System.out.println("2");
        		int idd = createReportList.get(i).getPAL_ID();  
        		ps.setInt(1,idd );
        		OutputStream os = new OutputStream() {
				@Override
				public void write(int c) throws IOException {
				}
        		};
        		System.out.println("3");
        	   InputStream is;
        	   System.out.println(ps.toString());
        	   ResultSet rs = ps.executeQuery(); 
        	   System.out.println("4");
        	   
        	   
        	   
        	   //System.out.println(rs.getBlob(1));
        	   //System.out.println(rs.getBlob("ImageDocs"));
        	   
        	   //if (!rs.getBlob(1).equals(null)) {
        		   System.out.println("1");
        		   rs.next();
            	   Blob b = (Blob) rs.getBlob("ImageDocs");
            	   System.out.println("b::" + b);
            	   if (b != null) {
            		   int x = (int) b.length();
                	   System.out.println(x);
                	
                	   is = b.getBinaryStream();  
                	   byte buf[] = new byte[(int) b.length()];  
                	   is.read(buf);  
                	   os.write(buf); 
                	   Image image= Image.getInstance(buf);
                	    
                	   pdfTable.addCell(image);
                	   os.close();
            	   
            	   }
            	   else {
            		   System.out.println("else::");
            		   pdfTable.addCell("No Image");
            	   }
            	   
            	   //System.out.println("Binary Stream:" + b.getBytes(1, (int) b.length()));
            	   
            	   
        	   
            	   /*} else {
        	   		System.out.println("2");
        		   pdfTable.addCell("no image");
        	   }*/
        	     
        	  // while(rs.next()){
        	   /*rs.next();
        	   Blob b = (Blob) rs.getBlob("ImageDocs");
        	   
        	   int x = (int) b.length();
        	   System.out.println(x);
        	   if(x>300500){
        	   is = b.getBinaryStream();  
        	   byte buf[] = new byte[(int) b.length()];  
        	   is.read(buf);  
        	   os.write(buf); 
        	   Image image= Image.getInstance(buf);
        	    
        	   pdfTable.addCell(image);
          	   os.close();
        	   }
        	   else{
        		   System.out.println("in else");
        	      pdfTable.addCell("no image");
        	   }*/
        	   }
        	   
        	   //}
        	   
        	  

        	     
        	 
        	 catch (Exception ex) {  
        	  // System.out.println(ex.getMessage());  
        	 } 
        }
        
        
        
        document.add(new Paragraph("SNHP Inventory Database Report"));
        document.add(new Paragraph("Report Generated On - "+new Date().toString()));	

        document.add(pdfTable);
        
        document.close(); 
        
        
        }catch(Exception e){
        	 baos.reset();
        	e.printStackTrace();
        }
       
		setInputStream(new ByteArrayInputStream(baos.toByteArray()));
        
		
		}catch (Exception e) {
	       e.printStackTrace();
	    }
		
		return SUCCESS;
	}
	
	
	public ArrayList<CreateReportBean> getCreateReportList() {
		return createReportList;
	}

	public void setCreateReportList(ArrayList<CreateReportBean> createReportList) {
		this.createReportList = createReportList;
	}
	
	public GenerateReportBean getGenerateReportBean() {
		return generateReportBean;
	}

	public void setGenerateReportBean(GenerateReportBean generateReportBean) {
		this.generateReportBean = generateReportBean;
	}
	
	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getReportFile() {
		return reportFile;
	}

	public void setReportFile(String reportFile) {
		this.reportFile = reportFile;
	}
	

	@Override
	public GenerateReportBean getModel() {
		// TODO Auto-generated method stub
		return generateReportBean;
	}

	public String getPdfFile() {
		return pdfFile;
	}

	public void setPdfFile(String pdfFile) {
		this.pdfFile = pdfFile;
	}
	
	
	
}
