package edu.gsu.snhp.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.gsu.snhp.bean.DisplayBean;
import edu.gsu.snhp.bean.SearchDetails;
import edu.gsu.snhp.bean.TestDB;
import edu.gsu.snhp.dao.SearchDB;

public class SearchValuesAction extends ActionSupport implements ModelDriven<SearchDetails> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	SearchDetails searchDetails = new SearchDetails();
	String str;
	SearchDB sdb=new SearchDB();
	
	DisplayBean displayBean =new DisplayBean();
	
	public ArrayList<DisplayBean> displayBeans= new ArrayList<DisplayBean>();
	
	public ArrayList<DisplayBean> getDisplayBeans() {
		return displayBeans;
	}


	public void setDisplayBeans(ArrayList<DisplayBean> displayBeans) {
		this.displayBeans = displayBeans;
	}
	
	public String execute(){
		
	       
		TestDB td= new TestDB();
		
		td.setAssetServiceTag(getSearchDetails().getAssetServiceTag());
		
		td.setAssetGSUdecalNumber(getSearchDetails().getAssetGSUdecalNumber());
		
		td.setOwner(getSearchDetails().getOwner());
		
		td.setPersonType(getSearchDetails().getPersonType());
		
		td.setAssetDescription(getSearchDetails().getAssetDescription());
		
		td.setOnOffCampus(getSearchDetails().getOnOffCampus());
		
		td.setBuildingName(getSearchDetails().getBuildingName());
		
		td.setPersonDepartment(getSearchDetails().getPersonDepartment());
		
		td.setWarrantyEndDate(getSearchDetails().getWarrantyEndDate());
		
		td.setPersonLastName(getSearchDetails().getPersonLastName());
		
		td.setWarrantyStartDate(getSearchDetails().getWarrantyStartDate());
		
		
		
		
		System.out.println("set aiyindi person department"+td.getPersonDepartment());
		
		displayBeans=sdb.getSearchValues(getSearchDetails());
		
		 
		this.setDisplayBeans(displayBeans);
		

		if(displayBeans.isEmpty()){
			str="failure";
		}
		else 
		{
			str="success";
		}
		return str;
	}
	
	
	


	public SearchDetails getSearchDetails() {
		return searchDetails;
	}


	public void setSearchDetails(SearchDetails searchDetails) {
		this.searchDetails = searchDetails;
	}


	@Override
	public SearchDetails getModel() {
		// TODO Auto-generated method stub
		return searchDetails;
	}
	
	
	
	
}
