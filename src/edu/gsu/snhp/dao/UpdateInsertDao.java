package edu.gsu.snhp.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import edu.gsu.snhp.bean.UpdateDisplayBean;
import edu.gsu.snhp.util.DBConn;

public class UpdateInsertDao {

		
		DBConn db=new DBConn();
		Connection conn;
		PreparedStatement ps;
		String result;
		int resultDB;
		String sql;
		
		
		public int getUpdateResult(UpdateDisplayBean updateDB){
			try {
				
					conn= db.getDBConnection();

			sql="update personassetlocation set PersonFirstName=?,PersonLastName=?,PersonDepartment=?,"
							+ "PersonOfficePhone=?,PersonCellPhone=?,PersonHomePhone=?,PersonOfficeEmail=?,PersonTitle=?,"
							+ "PersonHonorific=?,AssetDescription=?,AssetManufacturer=?,AssetSerialNumber=?,AssetModelNameNumber=?,"
							+ "AssetGSUdecalNumber=?,AssetLabelNumber=?,AssetMACaddress=?,AssetIPaddress=?,AssetCompName=?,"
							+ "AssetServiceTag=?,DateEntered=?,DateSurplusPU=?,OnOffCampus=?,AssetOffCampusAddress=?,"
							+ "Status=?,TechFee=?,WarrantyEndDate=?,Comment=?,Owner=?,ImageAsset=?,BuildingName=?,LocationType=?,"
							+ "LocationRoomNumber=?,LocationRoomName=?,OldLocationComment=?,ITportLAN1=?,ITportPhone1=?,"
							+ "ITportLAN2=?,ITportPhone2=?,ITportLAN3=?,ITportPhone3=?,ITportLAN4=?,ITportPhone4=?,ITportLAN5=?,"
							+ "ITportPhone5=?,PersonHomeEmail=?,PersonType=?,ImageDocs=? where PAL_ID ="+Integer.parseInt(updateDB.getPAL_ID())+"";
			
					
					ps=conn.prepareStatement(sql);
					System.out.println("update psst");
					System.out.println("palid value from bean"+updateDB.getPAL_ID());
					
					if(updateDB.getPersonFirstName()!=null && !updateDB.getPersonFirstName().equals("")){
						ps.setString(1, updateDB.getPersonFirstName());
					}else{
						ps.setString(1, null);
					}
					
					if(updateDB.getPersonLastName()!=null && !updateDB.getPersonLastName().equals("")){
						ps.setString(2, updateDB.getPersonLastName());
					}else{
						ps.setString(2, null);
					}
					
			
					if(updateDB.getPersonDepartment()!=null && !updateDB.getPersonDepartment().equals("")){
						ps.setString(3, updateDB.getPersonDepartment());
					}else{
						ps.setString(3, null);
					}
					
					if(updateDB.getPersonOfficePhone()!=null && !updateDB.getPersonOfficePhone().equals("")){
						ps.setString(4, updateDB.getPersonOfficePhone());
					}else{
						ps.setString(4, null);
					}
					
					if(updateDB.getPersonCellPhone()!=null && !updateDB.getPersonCellPhone().equals("")){
						ps.setString(5, updateDB.getPersonCellPhone());
					}else{
						ps.setString(5, null);
					}
					
					if(updateDB.getPersonHomePhone() != null && !updateDB.getPersonHomePhone().equals("")){
						ps.setString(6, updateDB.getPersonHomePhone());
					}else{
						ps.setString(6, null);
					}
					
					if( updateDB.getPersonOfficeEmail() != null && !updateDB.getPersonOfficeEmail().equals("") ){
						ps.setString(7, updateDB.getPersonOfficeEmail());
					}else{
						ps.setString(7, null);
					}
					
					if(updateDB.getPersonTitle()!=null && !updateDB.getPersonTitle().equals("")){
						ps.setString(8, updateDB.getPersonTitle());
					}else{
						ps.setString(8, null);
					}
					if( updateDB.getPersonHonorific() != null && !updateDB.getPersonHonorific().equals("")){
						ps.setString(9, updateDB.getPersonHonorific());
					}else{
						ps.setString(9, null);
					}
					if(updateDB.getAssetDescription() !=null && !updateDB.getAssetDescription().equals("")){
						ps.setString(10, updateDB.getAssetDescription());
					}else{
						ps.setString(10, null);
					}
					if(updateDB.getAssetManufacturer() !=null && !updateDB.getAssetManufacturer().equals("") ){
						ps.setString(11, updateDB.getAssetManufacturer());
					}else{
						ps.setString(11, null);
					}
					if(updateDB.getAssetSerialNumber()!=null && !updateDB.getAssetSerialNumber().equals("")){
						ps.setString(12, updateDB.getAssetSerialNumber());
					}else{
						ps.setString(12, null);
					}
					
					if(updateDB.getAssetModelNameNumber()!=null && !updateDB.getAssetModelNameNumber().equals("")){
						ps.setString(13, updateDB.getAssetModelNameNumber());
					}else{
						ps.setString(13, null);
					}
					
					if( updateDB.getAssetGSUdecalNumber()!=null && !updateDB.getAssetGSUdecalNumber().equals("") ){
						ps.setString(14, updateDB.getAssetGSUdecalNumber());
					}else{
						ps.setString(14, null);
					}
					
					if(updateDB.getAssetLabelNumber()!=null && !updateDB.getAssetLabelNumber().equals("")){
						ps.setString(15, updateDB.getAssetLabelNumber());
					}else{
						ps.setString(15, null);
					}
					
					if( updateDB.getAssetMACaddress()!=null && !updateDB.getAssetMACaddress().equals("")){
						ps.setString(16, updateDB.getAssetMACaddress());
					}else{
						ps.setString(16, null);
					}
					
					if(updateDB.getAssetIPaddress()!=null && !updateDB.getAssetIPaddress().equals("")){
						ps.setString(17, updateDB.getAssetIPaddress());
					}else{
						ps.setString(17, null);
					}
					
					if(updateDB.getAssetCompName()!=null && !updateDB.getAssetCompName().equals("")){
						ps.setString(18, updateDB.getAssetCompName());
					}else{
						ps.setString(18, null);
					}
					
				
					if(updateDB.getAssetServiceTag()!=null && !updateDB.getAssetServiceTag().equals("") ){
						ps.setString(19, updateDB.getAssetServiceTag());
					}else{
						ps.setString(19, null);
					}
					
					System.out.println(updateDB.getDateEntered());
					if( updateDB.getDateEntered()!=null && !updateDB.getDateEntered().equals(""))
					{
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				        java.util.Date parsed = format.parse((String)updateDB.getDateEntered());
				        java.sql.Date sql = new java.sql.Date(parsed.getTime()); 
			
						ps.setDate(20,sql);
					} else {
						ps.setDate(20,null);
					}
					
					
					if(updateDB.getDateSurplusPU()!=null && !updateDB.getDateSurplusPU().equals("")){
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
						java.util.Date parsed1 = format.parse((String)updateDB.getDateSurplusPU());
				        java.sql.Date sql1 = new java.sql.Date(parsed1.getTime());
				        
						ps.setDate(21, sql1);
					} else {
						ps.setDate(21, null);
					}
					
					
					if(updateDB.getOnOffCampus()!=null && !updateDB.getOnOffCampus().equals("")){
						ps.setString(22, updateDB.getOnOffCampus());
					}else{
						ps.setString(22, "");
					}
					
					
					if(updateDB.getAssetOffCampusAddress()!=null && !updateDB.getAssetOffCampusAddress().equals("")){
						ps.setString(23, updateDB.getAssetOffCampusAddress());
					}else{
						ps.setString(23, "");
					}
					
					
					if(updateDB.getStatus()!=null && !updateDB.getStatus().equals("")){
						ps.setString(24, updateDB.getStatus());
					}else{
						ps.setString(24, "");
					}
					
					if(updateDB.getTechFee()!=null && !updateDB.getTechFee().equals("")){
						ps.setString(25, updateDB.getTechFee());
					}else{
						ps.setString(25, "");
					}
					
					if(updateDB.getWarrantyEndDate()!=null && !updateDB.getWarrantyEndDate().equals("")){
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
						java.util.Date parsed2 = format.parse((String)updateDB.getWarrantyEndDate());
				        java.sql.Date sql2 = new java.sql.Date(parsed2.getTime());
						ps.setDate(26, sql2);
						
					} else {
						ps.setDate(26, null);
					}
					
					if(updateDB.getComment()!=null && !updateDB.getComment().equals("")){
						ps.setString(27, updateDB.getComment());
					}else{
						ps.setString(27, "");
					}
					
					if(updateDB.getOwner()!=null && !updateDB.getOwner().equals("")){
						ps.setString(28, updateDB.getOwner());
					}else{
						ps.setString(28, "");
					}
					
					if(updateDB.getImageAsset()!=null && !updateDB.getImageAsset().equals("")){
						ps.setString(29, updateDB.getImageAsset());
					}else{
						ps.setString(29, "");
					}
					if(updateDB.getBuildingName()!=null && !updateDB.getBuildingName().equals("")){
						ps.setString(30, updateDB.getBuildingName());
					}else{
						ps.setString(30, "");
					}
					if(updateDB.getLocationType()!=null && !updateDB.getLocationType().equals("")){
						ps.setString(31, updateDB.getLocationType());
					}else{
						ps.setString(31, "");
					}
					
					if(updateDB.getLocationRoomNumber()!=null && !updateDB.getLocationRoomNumber().equals("")){
						ps.setString(32, updateDB.getLocationRoomNumber());
					}else{
						ps.setString(32, "");
					}
					
					if(updateDB.getLocationRoomName()!=null && !updateDB.getLocationRoomName().equals("")){
						ps.setString(33, updateDB.getLocationRoomName());
					}else{
						ps.setString(33, "");
					}
					
					if(updateDB.getOldLocationComment()!=null && !updateDB.getOldLocationComment().equals("")){
						ps.setString(34, updateDB.getOldLocationComment());
					}else{
						ps.setString(34, "");
					}
					
					if(updateDB.getITportLAN1()!=null && !updateDB.getITportLAN1().equals("")){
						ps.setString(35, updateDB.getITportLAN1());
					}else{
						ps.setString(35, "");
					}
					
					if(updateDB.getITportPhone1()!=null && !updateDB.getITportPhone1().equals("")){
						ps.setString(36, updateDB.getITportPhone1());
					}else{
						ps.setString(36, "");
					}
					if(updateDB.getITportLAN2()!=null && !updateDB.getITportLAN2().equals("")){
						ps.setString(37, updateDB.getITportLAN2());
					}else{
						ps.setString(37, "");
					}
					if(updateDB.getITportPhone2()!=null && !updateDB.getITportPhone2().equals("")){
						ps.setString(38, updateDB.getITportPhone2());
					}else{
						ps.setString(38, "");
					}
					
					if(updateDB.getITportLAN3()!=null && !updateDB.getITportLAN3().equals("")){
						ps.setString(39, updateDB.getITportLAN3());
					}else{
						ps.setString(39, "");
					}
					if(updateDB.getITportPhone3()!=null && !updateDB.getITportPhone3().equals("")){
						ps.setString(40, updateDB.getITportPhone3());
					}else{
						ps.setString(40, "");
					}
					
					if(updateDB.getITportLAN4()!=null && !updateDB.getITportLAN4().equals("")){
						ps.setString(41, updateDB.getITportLAN4());
					}else{
						ps.setString(41, "");
					}
					
					if(updateDB.getITportPhone4()!=null && !updateDB.getITportPhone4().equals("")){
						ps.setString(42, updateDB.getITportPhone4());
					}else{
						ps.setString(42, "");
					}
					
					if(updateDB.getITportLAN5()!=null && !updateDB.getITportLAN5().equals("")){
						ps.setString(43, updateDB.getITportLAN5());
					}else{
						ps.setString(43, "");
					}
					if(updateDB.getITportPhone5()!=null && !updateDB.getITportPhone5().equals("")){
						ps.setString(44, updateDB.getITportPhone5());
					}else{
						ps.setString(44, "");
					}
					if(updateDB.getPersonHomeEmail()!=null && !updateDB.getPersonHomeEmail().equals("")){
						ps.setString(45, updateDB.getPersonHomeEmail());
					}else{
						ps.setString(45, "");
					}
					if(updateDB.getPersonType()!=null && !updateDB.getPersonType().equals("")){
						ps.setString(46, updateDB.getPersonType());
					}else{
						ps.setString(46, "");
					}
					
					if(updateDB.getImageDocs()!=null && updateDB.getImageDocs().equals("") )
					{
						FileInputStream fis = new FileInputStream(updateDB.getImageDocs());
						ps.setBinaryStream(47, fis, (int)updateDB.getImageDocs().length());
					
				} else {
					ps.setBinaryStream(47, null);
				}
					
					System.out.println("Final Update:" + ps.toString());
					
					
					resultDB=ps.executeUpdate();
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}
			
			return resultDB;
		}
	

}
