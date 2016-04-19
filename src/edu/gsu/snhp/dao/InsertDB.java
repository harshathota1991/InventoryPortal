package edu.gsu.snhp.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import edu.gsu.snhp.bean.InsertDetails;
import edu.gsu.snhp.util.DBConn;

public class InsertDB {

	Connection conn;
	DBConn dbConn=new DBConn();
	PreparedStatement ps;
	String query;
	int dbResult;
	
	public int insertValues(InsertDetails insertDetails) throws ParseException{
		
		try {
			conn=dbConn.getDBConnection();
			System.out.println("in insert DB query ");
			System.out.println(insertDetails.getDateEntered());
			
			
				query="insert into personassetlocation(PersonFirstName,PersonLastName,PersonType,PersonDepartment,PersonOfficePhone,PersonCellPhone,PersonHomePhone,PersonOfficeEmail,PersonTitle,PersonHonorific,AssetDescription,AssetManufacturer,AssetSerialNumber,AssetModelNameNumber,AssetGSUdecalNumber,AssetLabelNumber,AssetMACaddress,AssetIPaddress,AssetCompName,AssetServiceTag,DateEntered,DateSurplusPU,OnOffCampus,AssetOffCampusAddress,Status,TechFee,WarrantyEndDate,Comment,Owner,ImageAsset,BuildingName,LocationType,LocationRoomNumber,LocationRoomName,OldLocationComment,ITportLAN1,ITportPhone1,ITportLAN2,ITportPhone2,ITportLAN3,ITportPhone3,ITportLAN4,ITportPhone4,ITportLAN5,ITportPhone5,PersonHomeEmail,ImageDocs) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				
				ps=conn.prepareStatement(query);
				ps.setString(1, insertDetails.getPersonFirstName());
				ps.setString(2, insertDetails.getPersonLastName());
				ps.setString(3, insertDetails.getPersonType());
				ps.setString(4, insertDetails.getPersonDepartment());
				ps.setString(5, insertDetails.getPersonOfficePhone());
				ps.setString(6, insertDetails.getPersonCellPhone());
				ps.setString(7, insertDetails.getPersonHomePhone());
				ps.setString(8, insertDetails.getPersonOfficeEmail());
				ps.setString(9, insertDetails.getPersonTitle());
				ps.setString(10, insertDetails.getPersonHonorific());
				ps.setString(11, insertDetails.getAssetDescription());
				ps.setString(12, insertDetails.getAssetManufacturer());
				ps.setString(13, insertDetails.getAssetSerialNumber());
				ps.setString(14, insertDetails.getAssetModelNameNumber());
				ps.setString(15, insertDetails.getAssetGSUdecalNumber());
				ps.setString(16, insertDetails.getAssetLabelNumber());
				ps.setString(17, insertDetails.getAssetMACaddress());
				ps.setString(18, insertDetails.getAssetIPaddress());
				ps.setString(19, insertDetails.getAssetCompName());
				ps.setString(20, insertDetails.getAssetServiceTag());
			
				
				
		        
				ps.setString(23, insertDetails.getOnOffCampus());
				ps.setString(24, insertDetails.getAssetOffCampusAddress());
				ps.setString(25, insertDetails.getStatus());
				ps.setString(26, insertDetails.getTechFee());
				
				ps.setString(28, insertDetails.getComment());
				ps.setString(29, insertDetails.getOwner());
				ps.setString(30, insertDetails.getImageAsset());
				ps.setString(31, insertDetails.getBuildingName());
				ps.setString(32, insertDetails.getLocationType());
				ps.setString(33, insertDetails.getLocationRoomNumber());
				ps.setString(34, insertDetails.getLocationRoomName());
				ps.setString(35, insertDetails.getOldLocationComment());
				ps.setString(36, insertDetails.getITportLAN1());
				ps.setString(37, insertDetails.getITportLAN2());
				ps.setString(38, insertDetails.getITportLAN3());
				ps.setString(39, insertDetails.getITportLAN4());
				ps.setString(40, insertDetails.getITportLAN5());
				ps.setString(41, insertDetails.getITportPhone1());
				ps.setString(42, insertDetails.getITportPhone2());
				ps.setString(43, insertDetails.getITportPhone3());
				ps.setString(44, insertDetails.getITportPhone4());
				ps.setString(45, insertDetails.getITportPhone5()); 
				ps.setString(46,insertDetails.getPersonHomeEmail());
				
				
				if(insertDetails.getImageDocs()!=null )
				{
					FileInputStream fis = new FileInputStream(insertDetails.getImageDocs());
					ps.setBinaryStream(47, fis, (int)insertDetails.getImageDocs().length());
				
			} else {
				ps.setBinaryStream(47, null);
			}
				
				System.out.println("Date Entered:"+insertDetails.getDateEntered());
				
			if(!insertDetails.getDateEntered().equals(""))
			{
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		        java.util.Date parsed = format.parse((String)insertDetails.getDateEntered());
		        java.sql.Date sql = new java.sql.Date(parsed.getTime());
	
				ps.setDate(21,sql);
			} else {
				ps.setDate(21,null);
			}
			if(!insertDetails.getDateSurplusPU().equals("")){
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date parsed1 = format.parse((String)insertDetails.getDateSurplusPU());
		        java.sql.Date sql1 = new java.sql.Date(parsed1.getTime());
		        
				ps.setDate(22, sql1);
			} else {
				ps.setDate(22, null);
			}
			if(!insertDetails.getWarrantyEndDate().equals("")){
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date parsed2 = format.parse((String)insertDetails.getWarrantyEndDate());
		        java.sql.Date sql2 = new java.sql.Date(parsed2.getTime());
				ps.setDate(27, sql2);
				
			} else {
				ps.setDate(27, null);
			}
			
			dbResult=ps.executeUpdate();
			
			System.out.println("result after db transc"+dbResult);
			
		}catch (SQLException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dbResult;
	}
	
}
