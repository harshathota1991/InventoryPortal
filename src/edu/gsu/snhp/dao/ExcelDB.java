package edu.gsu.snhp.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Blob;

import edu.gsu.snhp.bean.CreateReportBean;
import edu.gsu.snhp.bean.GenerateReportBean;
import edu.gsu.snhp.util.DBConn;

	public class ExcelDB {

		
		
		ArrayList<CreateReportBean> createReportList= new ArrayList<CreateReportBean>();
		Connection conn;
		DBConn con=new DBConn();
		PreparedStatement ps;
		ResultSet rs;
		Blob image;
		byte[] imgdata;
		HttpServletResponse response;
		
		int count;
		boolean flag;
		String sql1="select PersonFirstName,PersonLastName,PersonType,PersonDepartment,"
				+ "PersonOfficePhone,PersonCellPhone,PersonHomePhone,PersonOfficeEmail,PersonTitle,"
				+ "PersonHonorific,AssetDescription,AssetManufacturer,AssetSerialNumber,AssetModelNameNumber,"
				+ "AssetGSUdecalNumber,AssetLabelNumber,AssetMACaddress,AssetIPaddress,AssetCompName,"
				+ "AssetServiceTag,DateEntered,DateSurplusPU,OnOffCampus,AssetOffCampusAddress,"
				+ "Status,TechFee,WarrantyEndDate,Comment,Owner,ImageAsset,BuildingName,LocationType,"
				+ "LocationRoomNumber,LocationRoomName,OldLocationComment,ITportLAN1,ITportPhone1,"
				+ "ITportLAN2,ITportPhone2,ITportLAN3,ITportPhone3,ITportLAN4,ITportPhone4,ITportLAN5,"
				+ "ITportPhone5,PersonHomeEmail,PAL_ID from personassetlocation";
		
		String sql= "select PersonFirstName,PersonLastName,PersonType,PersonDepartment,"
				+ "PersonOfficePhone,PersonCellPhone,PersonHomePhone,PersonOfficeEmail,PersonTitle,"
				+ "PersonHonorific,AssetDescription,AssetManufacturer,AssetSerialNumber,AssetModelNameNumber,"
				+ "AssetGSUdecalNumber,AssetLabelNumber,AssetMACaddress,AssetIPaddress,AssetCompName,"
				+ "AssetServiceTag,DateEntered,DateSurplusPU,OnOffCampus,AssetOffCampusAddress,"
				+ "Status,TechFee,WarrantyEndDate,Comment,Owner,ImageAsset,BuildingName,LocationType,"
				+ "LocationRoomNumber,LocationRoomName,OldLocationComment,ITportLAN1,ITportPhone1,"
				+ "ITportLAN2,ITportPhone2,ITportLAN3,ITportPhone3,ITportLAN4,ITportPhone4,ITportLAN5,"
				+ "ITportPhone5,PersonHomeEmail,PAL_ID from personassetlocation where";
		
		public ArrayList<CreateReportBean> getReportValues(GenerateReportBean generateReportBean) {
			// TODO Auto-generated method stub
			
			try {
				conn=con.getDBConnection();
				System.out.println("connection made in Report DB");
				
				if (!generateReportBean.getOwner().equals("Select") ) {
					sql = sql + " Owner = '" + generateReportBean.getOwner() + "'";
					count=count+1;
					flag = true;
				}
				
				if(!generateReportBean.getAssetDescription().equals("Select")){
					if(count>0){
						sql=sql+" AND";			
					}
					sql=sql+" AssetDescription = '"+generateReportBean.getAssetDescription()+"'";
					count=count+1;
					flag=true;
				}
				
				if (!generateReportBean.getDateSurplusPU().equals("")) {
					if(count>0){
						sql=sql+" AND";
					}
					sql = sql + " DateSurplusPU = '" + generateReportBean.getDateSurplusPU() + "'";
					count=count+1;
					flag = true;
				}
				
				if (!generateReportBean.getOnOffCampus().equals("Select") ) {
					if(count>0){
						sql=sql+" AND";
					}
					sql = sql + " OnOffCampus = '" + generateReportBean.getOnOffCampus() + "'";
					count=count+1;
					flag = true;
				}
				if (!generateReportBean.getBuildingName().equals("Select")) {
					if(count>0){
						sql=sql+" AND";
					}
					sql = sql + " BuildingName = '" + generateReportBean.getBuildingName() + "'";
					count=count+1;
					flag = true;
					
				}
				
				if (!generateReportBean.getPersonDepartment().equals("Select") ) {
					if(count>0){
						sql=sql+" AND";
					}
					sql = sql + " PersonDepartment = '" + generateReportBean.getPersonDepartment() + "'";
					count=count+1;
					flag = true;
				}
				
				if (!generateReportBean.getWarrantyStartDate().equals("") && !generateReportBean.getWarrantyEndDate().equals("")) {
					if(count>0){
						sql=sql+" AND";
					}
					sql = sql + " WarrantyEndDate BETWEEN '"+generateReportBean.getWarrantyStartDate()+"'"+ " AND '"+generateReportBean.getWarrantyEndDate()+"'";
					
					
					count=count+1;
					flag = true;
					
				}
				
				
				if (flag) {
					ps=conn.prepareStatement(sql);
				} else {
					ps=conn.prepareStatement(sql1);
					
				}
				
				System.out.println("PreparedStatement"+ps.toString());
				
				rs=ps.executeQuery();
				while(rs.next()){
					
					CreateReportBean createReportBean=new CreateReportBean();
					
			
					
					if(rs.getString(1)!=null){
						createReportBean.setPersonFirstName(rs.getString(1));
							
					}else{
						createReportBean.setPersonFirstName("");
					}
					if(rs.getString(2)!=null){
						createReportBean.setPersonLastName(rs.getString(2));
							
					}else{
						createReportBean.setPersonLastName("");
						
					}
					if(rs.getString(3)!=null){
						createReportBean.setPersonType(rs.getString(3));
							
					}else{
						createReportBean.setPersonType("");
						
					}
					if(rs.getString(4)!=null){
						createReportBean.setPersonDepartment(rs.getString(4));
							
					}else{
						createReportBean.setPersonDepartment("");
						
					}
					if(rs.getString(5)!=null){
						createReportBean.setPersonOfficePhone(rs.getString(5));
							
					}else{
						createReportBean.setPersonOfficePhone("");
						
					}
					if(rs.getString(6)!=null){
						createReportBean.setPersonCellPhone(rs.getString(6));
							
					}else{
						createReportBean.setPersonCellPhone("");
						
					}if(rs.getString(7)!=null){
						createReportBean.setPersonHomePhone(rs.getString(7));
							
					}else{
						createReportBean.setPersonHomePhone("");;
						
					}if(rs.getString(8)!=null){
						createReportBean.setPersonOfficeEmail(rs.getString(8));
							
					}else{
						createReportBean.setPersonOfficeEmail("");
						
					}if(rs.getString(9)!=null){
						createReportBean.setPersonTitle(rs.getString(9));
							
					}else{
						createReportBean.setPersonTitle("");
						
					}if(rs.getString(10)!=null){
						createReportBean.setPersonHonorific(rs.getString(10));
							
					}else{
						createReportBean.setPersonHonorific("");
						
					}if(rs.getString(11)!=null){
						createReportBean.setAssetDescription(rs.getString(11));
							
					}else{
						createReportBean.setAssetDescription("");
						
					}if(rs.getString(12)!=null){
						createReportBean.setAssetManufacturer(rs.getString(12));
							
					}else{
						
						createReportBean.setAssetManufacturer("");
					}if(rs.getString(13)!=null){
						createReportBean.setAssetSerialNumber(rs.getString(13));

							
					}else{
						createReportBean.setAssetSerialNumber("");

						
					}if(rs.getString(14)!=null){
						createReportBean.setAssetModelNameNumber(rs.getString(14));

							
					}else{
					
						createReportBean.setAssetModelNameNumber("");

					}if(rs.getString(15)!=null){
						createReportBean.setAssetGSUdecalNumber(rs.getString(15));
							
					}else{
						
						createReportBean.setAssetGSUdecalNumber("");
						
					}if(rs.getString(16)!=null){
						createReportBean.setAssetLabelNumber(rs.getString(16));
							
					}else{
						
						createReportBean.setAssetLabelNumber("");
					}if(rs.getString(17)!=null){
						createReportBean.setAssetMACaddress(rs.getString(17));
							
					}else{
						createReportBean.setAssetMACaddress("");
						
					}if(rs.getString(18)!=null){
						createReportBean.setAssetIPaddress(rs.getString(18));
							
					}else{
						createReportBean.setAssetIPaddress("");
						
					}if(rs.getString(19)!=null){
						createReportBean.setAssetCompName(rs.getString(19));
							
					}else{
						createReportBean.setAssetCompName("");
						
					}if(rs.getString(20)!=null){
						createReportBean.setAssetServiceTag(rs.getString(20));
							
					}else{
						createReportBean.setAssetServiceTag("");
						
					}if(rs.getString(21)!=null){
						
						createReportBean.setDateEntered(rs.getDate(21).toString());
					}else{
						createReportBean.setDateEntered("");
						
					}if(rs.getString(22)!=null){
						createReportBean.setDateSurplusPU(rs.getDate(22).toString());
							
					}else{
						createReportBean.setDateSurplusPU("");
						
					}if(rs.getString(23)!=null){
						createReportBean.setOnOffCampus(rs.getString(23));

							
					}else{
						
						createReportBean.setOnOffCampus("");

					}if(rs.getString(24)!=null){
						createReportBean.setAssetOffCampusAddress(rs.getString(24));
							
					}else{
						createReportBean.setAssetOffCampusAddress("");
						
					}if(rs.getString(25)!=null){
						createReportBean.setStatus(rs.getString(25));
							
					}else{
						createReportBean.setStatus("");
						
					}if(rs.getString(26)!=null){
						createReportBean.setTechFee(rs.getString(26));

							
					}else{
						createReportBean.setTechFee("");

						
					}if(rs.getString(27)!=null){
						createReportBean.setWarrantyEndDate(rs.getDate(27).toString());
							
					}else{
						createReportBean.setWarrantyEndDate("");
						
					}if(rs.getString(28)!=null){
						createReportBean.setComment(rs.getString(28));
							
					}else{
						createReportBean.setComment("");
						
					}if(rs.getString(29)!=null){
						createReportBean.setOwner(rs.getString(29));
							
					}else{
						createReportBean.setOwner("");
						
					}if(rs.getString(30)!=null){
						createReportBean.setImageAsset(rs.getString(30));
							
					}else{
						createReportBean.setImageAsset("");
						
					}if(rs.getString(31)!=null){
						createReportBean.setBuildingName(rs.getString(31));

							
					}else{
						createReportBean.setBuildingName("");

						
					}if(rs.getString(32)!=null){
						createReportBean.setLocationType(rs.getString(32));
							
					}else{
						createReportBean.setLocationType("");
						
					}if(rs.getString(33)!=null){
						createReportBean.setLocationRoomNumber(rs.getString(33));
							
					}else{
						createReportBean.setLocationRoomNumber("");
						
					}if(rs.getString(34)!=null){
						createReportBean.setLocationRoomName(rs.getString(34));
							
					}else{
						createReportBean.setLocationRoomName("");
						
					}if(rs.getString(35)!=null){
						createReportBean.setOldLocationComment(rs.getString(35));
							
					}else{
						createReportBean.setOldLocationComment("");
						
					}if(rs.getString(36)!=null){
						createReportBean.setITportLAN1(rs.getString(36));
							
					}else{
						createReportBean.setITportLAN1("");
						
					}if(rs.getString(37)!=null){
						createReportBean.setITportPhone1(rs.getString(37));
							
					}else{
						createReportBean.setITportPhone1("");
						
					}if(rs.getString(38)!=null){
						createReportBean.setITportLAN2(rs.getString(38));
							
					}else{
						createReportBean.setITportLAN2("");
						
					}if(rs.getString(39)!=null){
						createReportBean.setITportPhone2(rs.getString(39));
							
					}else{
						createReportBean.setITportPhone2("");
						
					}if(rs.getString(40)!=null){
						createReportBean.setITportLAN3(rs.getString(40));
							
					}else{
						createReportBean.setITportLAN3("");
						
					}if(rs.getString(41)!=null){
						createReportBean.setITportPhone3(rs.getString(41));
							
					}else{
						createReportBean.setITportPhone3("");
						
					}if(rs.getString(42)!=null){
						createReportBean.setITportLAN4(rs.getString(42));
							
					}else{
						createReportBean.setITportLAN4("");
						
					}if(rs.getString(43)!=null){
						createReportBean.setITportPhone4(rs.getString(43));

							
					}else{
						createReportBean.setITportPhone4("");

						
					}if(rs.getString(44)!=null){
						createReportBean.setITportLAN5(rs.getString(44));
							
					}else{
						createReportBean.setITportLAN5("");
						
					}if(rs.getString(45)!=null){
						createReportBean.setITportPhone5(rs.getString(45));

							
					}else{
						createReportBean.setITportPhone5("");

						
					}if(rs.getString(46)!=null){
						createReportBean.setPersonHomeEmail(rs.getString(46));

							
					}else{
						createReportBean.setPersonHomeEmail("");

					}
					
					createReportBean.setPAL_ID(rs.getInt(47));
					
					createReportBean.setImageDocs(null);
					
					
					
					createReportList.add(createReportBean);
					
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//System.out.println(createReportList.get(0).getMyImage());
			System.out.println("bean added to arraylist and returnd");

				
			return createReportList;

		}

	}