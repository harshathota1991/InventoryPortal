package edu.gsu.snhp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.gsu.snhp.bean.UpdateBean;
import edu.gsu.snhp.bean.UpdateDisplayBean;
import edu.gsu.snhp.util.DBConn;

public class UpdateDB {

	Connection conn;
	DBConn dbConn= new DBConn();
	PreparedStatement pst;
	ResultSet rs;
	String query;
	
	UpdateDisplayBean updateDisplayBean= new UpdateDisplayBean();
	
	public UpdateDisplayBean getInsertValues(UpdateBean uBean){
		
		
		System.out.println("inside searchDB");
		try {
		conn=dbConn.getDBConnection();
		System.out.println("connection made");
	
			
		query= "select PersonFirstName,PersonLastName,PersonType,PersonDepartment,"
				+ "PersonOfficePhone,PersonCellPhone,PersonHomePhone,PersonOfficeEmail,PersonTitle,"
				+ "PersonHonorific,AssetDescription,AssetManufacturer,AssetSerialNumber,AssetModelNameNumber,"
				+ "AssetGSUdecalNumber,AssetLabelNumber,AssetMACaddress,AssetIPaddress,AssetCompName,"
				+ "AssetServiceTag,DateEntered,DateSurplusPU,OnOffCampus,AssetOffCampusAddress,"
				+ "Status,TechFee,WarrantyEndDate,Comment,Owner,ImageAsset,BuildingName,LocationType,"
				+ "LocationRoomNumber,LocationRoomName,OldLocationComment,ITportLAN1,ITportPhone1,"
				+ "ITportLAN2,ITportPhone2,ITportLAN3,ITportPhone3,ITportLAN4,ITportPhone4,ITportLAN5,"
				+ "ITportPhone5,PersonHomeEmail from personassetlocation where PAL_ID ="+uBean.getPAL_ID()+"";
		
		pst=conn.prepareStatement(query);
		System.out.println("sql1"+pst.toString());
		rs=pst.executeQuery();
		System.out.println("query executed");
		while(rs.next()){
			
			
			
			if(rs.getString(1)!=null){
				updateDisplayBean.setPersonFirstName(rs.getString(1));
					
			}else{
				updateDisplayBean.setPersonFirstName("");
			}
			if(rs.getString(2)!=null){
				updateDisplayBean.setPersonLastName(rs.getString(2));
					
			}else{
				updateDisplayBean.setPersonLastName("");
				
			}
			if(rs.getString(3)!=null){
				updateDisplayBean.setPersonType(rs.getString(3));
					
			}else{
				updateDisplayBean.setPersonType("");
				
			}
			if(rs.getString(4)!=null){
				updateDisplayBean.setPersonDepartment(rs.getString(4));
					
			}else{
				updateDisplayBean.setPersonDepartment("");
				
			}
			if(rs.getString(5)!=null){
				updateDisplayBean.setPersonOfficePhone(rs.getString(5));
					
			}else{
				updateDisplayBean.setPersonOfficePhone("");
				
			}
			if(rs.getString(6)!=null){
				updateDisplayBean.setPersonCellPhone(rs.getString(6));
					
			}else{
				updateDisplayBean.setPersonCellPhone("");
				
			}if(rs.getString(7)!=null){
				updateDisplayBean.setPersonHomePhone(rs.getString(7));
					
			}else{
				updateDisplayBean.setPersonHomePhone("");;
				
			}if(rs.getString(8)!=null){
				updateDisplayBean.setPersonOfficeEmail(rs.getString(8));
					
			}else{
				updateDisplayBean.setPersonOfficeEmail("");
				
			}if(rs.getString(9)!=null){
				updateDisplayBean.setPersonTitle(rs.getString(9));
					
			}else{
				updateDisplayBean.setPersonTitle("");
				
			}if(rs.getString(10)!=null){
				updateDisplayBean.setPersonHonorific(rs.getString(10));
					
			}else{
				updateDisplayBean.setPersonHonorific("");
				
			}if(rs.getString(11)!=null){
				updateDisplayBean.setAssetDescription(rs.getString(11));
					
			}else{
				updateDisplayBean.setAssetDescription("");
				
			}if(rs.getString(12)!=null){
				updateDisplayBean.setAssetManufacturer(rs.getString(12));
					
			}else{
				
				updateDisplayBean.setAssetManufacturer("");
			}if(rs.getString(13)!=null){
				updateDisplayBean.setAssetSerialNumber(rs.getString(13));

					
			}else{
				updateDisplayBean.setAssetSerialNumber("");

				
			}if(rs.getString(14)!=null){
				updateDisplayBean.setAssetModelNameNumber(rs.getString(14));

					
			}else{
			
				updateDisplayBean.setAssetModelNameNumber("");

			}if(rs.getString(15)!=null){
				updateDisplayBean.setAssetGSUdecalNumber(rs.getString(15));
					
			}else{
				
				updateDisplayBean.setAssetGSUdecalNumber("");
				
			}if(rs.getString(16)!=null){
				updateDisplayBean.setAssetLabelNumber(rs.getString(16));
					
			}else{
				
				updateDisplayBean.setAssetLabelNumber("");
			}if(rs.getString(17)!=null){
				updateDisplayBean.setAssetMACaddress(rs.getString(17));
					
			}else{
				updateDisplayBean.setAssetMACaddress("");
				
			}if(rs.getString(18)!=null){
				updateDisplayBean.setAssetIPaddress(rs.getString(18));
					
			}else{
				updateDisplayBean.setAssetIPaddress("");
				
			}if(rs.getString(19)!=null){
				updateDisplayBean.setAssetCompName(rs.getString(19));
					
			}else{
				updateDisplayBean.setAssetCompName("");
				
			}if(rs.getString(20)!=null){
				updateDisplayBean.setAssetServiceTag(rs.getString(20));
					
			}else{
				updateDisplayBean.setAssetServiceTag("");
				
			}if(rs.getString(21)!=null){
				
				updateDisplayBean.setDateEntered(rs.getDate(21).toString());
			}else{
				updateDisplayBean.setDateEntered("");
				
			}if(rs.getString(22)!=null){
				updateDisplayBean.setDateSurplusPU(rs.getDate(22).toString());
					
			}else{
				updateDisplayBean.setDateSurplusPU("");
				
			}if(rs.getString(23)!=null){
				updateDisplayBean.setOnOffCampus(rs.getString(23));

					
			}else{
				
				updateDisplayBean.setOnOffCampus("");

			}if(rs.getString(24)!=null){
				updateDisplayBean.setAssetOffCampusAddress(rs.getString(24));
					
			}else{
				updateDisplayBean.setAssetOffCampusAddress("");
				
			}if(rs.getString(25)!=null){
				updateDisplayBean.setStatus(rs.getString(25));
					
			}else{
				updateDisplayBean.setStatus("");
				
			}if(rs.getString(26)!=null){
				updateDisplayBean.setTechFee(rs.getString(26));

					
			}else{
				updateDisplayBean.setTechFee("");

				
			}if(rs.getString(27)!=null){
				updateDisplayBean.setWarrantyEndDate(rs.getDate(27).toString());
					
			}else{
				updateDisplayBean.setWarrantyEndDate("");
				
			}if(rs.getString(28)!=null){
				updateDisplayBean.setComment(rs.getString(28));
					
			}else{
				updateDisplayBean.setComment("");
				
			}if(rs.getString(29)!=null){
				updateDisplayBean.setOwner(rs.getString(29));
					
			}else{
				updateDisplayBean.setOwner("");
				
			}if(rs.getString(30)!=null){
				updateDisplayBean.setImageAsset(rs.getString(30));
					
			}else{
				updateDisplayBean.setImageAsset("");
				
			}if(rs.getString(31)!=null){
				updateDisplayBean.setBuildingName(rs.getString(31));

					
			}else{
				updateDisplayBean.setBuildingName("");

				
			}if(rs.getString(32)!=null){
				updateDisplayBean.setLocationType(rs.getString(32));
					
			}else{
				updateDisplayBean.setLocationType("");
				
			}if(rs.getString(33)!=null){
				updateDisplayBean.setLocationRoomNumber(rs.getString(33));
					
			}else{
				updateDisplayBean.setLocationRoomNumber("");
				
			}if(rs.getString(34)!=null){
				updateDisplayBean.setLocationRoomName(rs.getString(34));
					
			}else{
				updateDisplayBean.setLocationRoomName("");
				
			}if(rs.getString(35)!=null){
				updateDisplayBean.setOldLocationComment(rs.getString(35));
					
			}else{
				updateDisplayBean.setOldLocationComment("");
				
			}if(rs.getString(36)!=null){
				updateDisplayBean.setITportLAN1(rs.getString(36));
					
			}else{
				updateDisplayBean.setITportLAN1("");
				
			}if(rs.getString(37)!=null){
				updateDisplayBean.setITportPhone1(rs.getString(37));
					
			}else{
				updateDisplayBean.setITportPhone1("");
				
			}if(rs.getString(38)!=null){
				updateDisplayBean.setITportLAN2(rs.getString(38));
					
			}else{
				updateDisplayBean.setITportLAN2("");
				
			}if(rs.getString(39)!=null){
				updateDisplayBean.setITportPhone2(rs.getString(39));
					
			}else{
				updateDisplayBean.setITportPhone2("");
				
			}if(rs.getString(40)!=null){
				updateDisplayBean.setITportLAN3(rs.getString(40));
					
			}else{
				updateDisplayBean.setITportLAN3("");
				
			}if(rs.getString(41)!=null){
				updateDisplayBean.setITportPhone3(rs.getString(41));
					
			}else{
				updateDisplayBean.setITportPhone3("");
				
			}if(rs.getString(42)!=null){
				updateDisplayBean.setITportLAN4(rs.getString(42));
					
			}else{
				updateDisplayBean.setITportLAN4("");
				
			}if(rs.getString(43)!=null){
				updateDisplayBean.setITportPhone4(rs.getString(43));

					
			}else{
				updateDisplayBean.setITportPhone4("");

				
			}if(rs.getString(44)!=null){
				updateDisplayBean.setITportLAN5(rs.getString(44));
					
			}else{
				updateDisplayBean.setITportLAN5("");
				
			}if(rs.getString(45)!=null){
				updateDisplayBean.setITportPhone5(rs.getString(45));

					
			}else{
				updateDisplayBean.setITportPhone5("");

				
			}if(rs.getString(46)!=null){
				updateDisplayBean.setPersonHomeEmail(rs.getString(46));

					
			}else{
				updateDisplayBean.setPersonHomeEmail("");

				
			}
			
				
		}
			
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	System.out.println("after DB before return"+updateDisplayBean.getPersonLastName());
		return updateDisplayBean; 
		
	}
	
}
