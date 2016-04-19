package edu.gsu.snhp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import edu.gsu.snhp.bean.SearchDetails;
import edu.gsu.snhp.bean.SearchUpdateBean;
import edu.gsu.snhp.util.DBConn;

public class SearchUpdateDB {

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
	
	
	ArrayList<SearchUpdateBean> arrayListSearchCB1 = new ArrayList<SearchUpdateBean>();
	
	SearchDetails searchDetails = new SearchDetails();
	
	
	String sql;
	
	public ArrayList<SearchUpdateBean> getSearchValues(HashMap<Integer, String> testList){
	
		try {
			conn=dbConn.getDBConnection();
	
		/*	if(personLastName!=null && !personLastName.equals("")){
		sql = "select PersonLastName,AssetServiceTag,AssetManufacturer,AssetDescription,"
				+ "AssetGSUdecalNumber,Owner,AssetLabelNumber,BuildingName,LocationType,"
				+ "LocationRoomNumber,PAL_ID,PersonDepartment from personassetlocation "
				+ "WHERE PersonLastName = '"+personLastName+"'";
			}
			else
			{
				sql = "select PersonLastName,AssetServiceTag,AssetManufacturer,AssetDescription,"
						+ "AssetGSUdecalNumber,Owner,AssetLabelNumber,BuildingName,LocationType,"
						+ "LocationRoomNumber,PAL_ID,PersonDepartment from personassetlocation ";
			}

			ps=conn.prepareStatement(sql);
	
			*/
			
			sql = "select PersonLastName,AssetServiceTag,AssetManufacturer,AssetDescription,"
					+ "AssetGSUdecalNumber,Owner,AssetLabelNumber,BuildingName,LocationType,"
					+ "LocationRoomNumber,PAL_ID,PersonDepartment from personassetlocation where ";
			
			if (!testList.get(10).equals("Select") && testList.get(10)!=null && !testList.get(10).equals("")) {
				sql = sql + "PersonLastName = '" + testList.get(10) + "'";
				flag = true;
				count=count+1;
			}
			
			if (testList.get(1)!=null && !testList.get(1).equals("")){
				if(count>0){
					sql=sql+" AND";
				}
				sql = sql + " AssetServiceTag = '" + testList.get(1) + "'";
				count=count+1;
				flag = true;
			}
			
			
			if (testList.get(2)!=null && !testList.get(2).equals("")) {
					if(count>0){
						sql=sql+" AND";
					}
				
				sql = sql + " AssetGSUdecalNumber = '" + testList.get(2) + "'";
				count=count+1;
				flag = true;
			}
			
			if (testList.get(3)!=null && !testList.get(3).equals("Select")) {
				if(count>0){
					sql=sql+" AND";
				}
				sql = sql + " Owner = '" + testList.get(3) + "'";
				count=count+1;
				flag = true;
			}
			if (testList.get(4)!=null && !testList.get(4).equals("Select")) {
				if(count>0){
					sql=sql+" AND";
				}
				sql = sql + " PersonType = '" + testList.get(4) + "'";
				count=count+1;
				flag = true;
			}
			if (testList.get(5)!=null && !testList.get(5).equals("Select")) {
				if(count>0){
					sql=sql+" AND";
				}
				sql = sql + " AssetDescription = '" + testList.get(5) + "'";
				count=count+1;
				flag = true;
			}
			if (testList.get(6)!=null && !testList.get(6).equals("Select")) {
				if(count>0){
					sql=sql+" AND";
				}
				sql = sql + " OnOffCampus = '" + testList.get(6) + "'";
				count=count+1;
				flag = true;
			}
			
			if (testList.get(7)!=null && !testList.get(7).equals("Select")) {
				if(count>0){
					sql=sql+" AND";
				}
				sql = sql + " BuildingName = '" + testList.get(7) + "'";
				count=count+1;
				flag = true;
				
			}
			if (testList.get(8)!=null && !testList.get(8).equals("Select")) {
				if(count>0){
					sql=sql+" AND";
				}
				sql = sql + " PersonDepartment = '" + testList.get(8) + "'";
				count=count+1;
				flag = true;
			}
			
			if (testList.get(9)!=null && !testList.get(11).equals("") && !testList.get(9).equals("")) {
				if(count>0){
					sql=sql+" AND";
				}
				sql = sql + " WarrantyEndDate BETWEEN '"+testList.get(11)+"'"+ " AND '"+testList.get(9)+"'";
				
				
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
			
			SearchUpdateBean searchUpdateBean= new SearchUpdateBean();
			
			
			searchUpdateBean.setPersonLastName(rs.getString(1));
			searchUpdateBean.setAssetServiceTag(rs.getString(2));
			searchUpdateBean.setAssetManufacturer(rs.getString(3));
			searchUpdateBean.setAssetDescription(rs.getString(4));
			searchUpdateBean.setAssetGSUdecalNumber(rs.getString(5));
			searchUpdateBean.setOwner(rs.getString(6));
			searchUpdateBean.setAssetLabelNumber(rs.getString(7));
			searchUpdateBean.setBuildingName(rs.getString(8));
			searchUpdateBean.setLocationType(rs.getString(9));
			searchUpdateBean.setLocationRoomNumber(rs.getString(10));
			searchUpdateBean.setPAL_ID(rs.getInt(11));
			searchUpdateBean.setPersonDepartment(rs.getString(12));
		
			
		arrayListSearchCB1.add(searchUpdateBean);
		
	
		
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
