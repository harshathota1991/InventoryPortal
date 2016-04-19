package edu.gsu.snhp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.gsu.snhp.bean.DisplayBean;
import edu.gsu.snhp.bean.SearchDetails;
import edu.gsu.snhp.util.DBConn;

public class SearchDB {

	SearchDetails sd;
	String result;
	Connection conn;
	DBConn dbConn=new DBConn();
	PreparedStatement ps;
	String query;
	ResultSet rs;
	String sql1;
	boolean flag;
	int count;
	
	
	ArrayList<DisplayBean> arrayListSearchCB1 = new ArrayList<DisplayBean>();
	
	SearchDetails searchDetails = new SearchDetails();
	
	
	
	String sql = "select PersonLastName,AssetServiceTag,AssetManufacturer,AssetDescription,"
			+ "AssetGSUdecalNumber,Owner,AssetLabelNumber,BuildingName,LocationType,"
			+ "LocationRoomNumber,PAL_ID,PersonDepartment from personassetlocation where ";
	
	public ArrayList<DisplayBean> getSearchValues(SearchDetails searchBean){
	
		//System.out.println("inside searchDB");
		try {
		conn=dbConn.getDBConnection();
		System.out.println("connection made");
	//System.out.println(searchBean.getOnOffCampus());
	
	
		if (!searchBean.getPersonLastName().equals("Select") && !searchBean.getPersonLastName().equals("")) {
			sql = sql + "PersonLastName = '" + searchBean.getPersonLastName() + "'";
			flag = true;
			count=count+1;
		}//System.out.println("person last Name"+ searchBean.getPersonLastName() );
		
		if (!searchBean.getAssetServiceTag().equals("")) {
			if(count>0){
				sql=sql+" AND";
			}
			sql = sql + " AssetServiceTag = '" + searchBean.getAssetServiceTag() + "'";
			count=count+1;
			flag = true;
		}
		
		
		if (!searchBean.getAssetGSUdecalNumber().equals("")) {
				if(count>0){
					sql=sql+" AND";
				}
			
			sql = sql + " AssetGSUdecalNumber = '" + searchBean.getAssetGSUdecalNumber() + "'";
			count=count+1;
			flag = true;
		}
		
		if (!searchBean.getOwner().equals("Select")) {
			if(count>0){
				sql=sql+" AND";
			}
			sql = sql + " Owner = '" + searchBean.getOwner() + "'";
			count=count+1;
			flag = true;
		}
		if (!searchBean.getPersonType().equals("Select")) {
			if(count>0){
				sql=sql+" AND";
			}
			sql = sql + " PersonType = '" + searchBean.getPersonType() + "'";
			count=count+1;
			flag = true;
		}
		if (!searchBean.getAssetDescription().equals("Select")) {
			if(count>0){
				sql=sql+" AND";
			}
			sql = sql + " AssetDescription = '" + searchBean.getAssetDescription() + "'";
			count=count+1;
			flag = true;
		}
		if (!searchBean.getOnOffCampus().equals("Select")) {
			if(count>0){
				sql=sql+" AND";
			}
			sql = sql + " OnOffCampus = '" + searchBean.getOnOffCampus() + "'";
			count=count+1;
			flag = true;
		}
		
		if (!searchBean.getBuildingName().equals("Select")) {
			if(count>0){
				sql=sql+" AND";
			}
			sql = sql + " BuildingName = '" + searchBean.getBuildingName() + "'";
			count=count+1;
			flag = true;
			
		}
		if (!searchBean.getPersonDepartment().equals("Select")) {
			if(count>0){
				sql=sql+" AND";
			}
			sql = sql + " PersonDepartment = '" + searchBean.getPersonDepartment() + "'";
			count=count+1;
			flag = true;
		}
		
		if (!searchBean.getWarrantyStartDate().equals("") && !searchBean.getWarrantyEndDate().equals("")) {
			if(count>0){
				sql=sql+" AND";
			}
			sql = sql + " WarrantyEndDate BETWEEN '"+searchBean.getWarrantyStartDate()+"'"+ " AND '"+searchBean.getWarrantyEndDate()+"'";
			
			
			count=count+1;
			flag = true;
			
		}
		
		
		
		
		if (flag) {
			ps=conn.prepareStatement(sql);
		} else {
			sql1 = "select PersonLastName,AssetServiceTag,AssetManufacturer,AssetDescription,AssetGSUdecalNumber,Owner,AssetLabelNumber,BuildingName,LocationType,LocationRoomNumber,PAL_ID,PersonDepartment from personassetlocation";
			ps=conn.prepareStatement(sql1);
			
		}
		
	
		
		System.out.println("Psstmt:" + ps.toString());
		
		rs= ps.executeQuery();	
		
		 
		
		while(rs.next()){
			
			DisplayBean displayBean = new DisplayBean() ;
			
			displayBean.setPersonLastName(rs.getString(1));
			displayBean.setAssetServiceTag(rs.getString(2));
			displayBean.setAssetManufacturer(rs.getString(3));
			displayBean.setAssetDescription(rs.getString(4));
			displayBean.setAssetGSUdecalNumber(rs.getString(5));
			displayBean.setOwner(rs.getString(6));
			displayBean.setAssetLabelNumber(rs.getString(7));
			displayBean.setBuildingName(rs.getString(8));
			displayBean.setLocationType(rs.getString(9));
			displayBean.setLocationRoomNumber(rs.getString(10));
			displayBean.setPAL_ID(rs.getInt(11));
			displayBean.setPersonDepartment(rs.getString(12));
		
			
		arrayListSearchCB1.add(displayBean);
		
	
		
		}
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayListSearchCB1; 
	
		//return arrayListSearchCB;
		
	}
}
