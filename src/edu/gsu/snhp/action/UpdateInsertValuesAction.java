package edu.gsu.snhp.action;

import java.util.ArrayList;
import java.util.HashMap;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.gsu.snhp.bean.SearchUpdateBean;
import edu.gsu.snhp.bean.TestDB;
import edu.gsu.snhp.bean.UpdateDisplayBean;
import edu.gsu.snhp.dao.SearchUpdateDB;
import edu.gsu.snhp.dao.UpdateInsertDao;

public class UpdateInsertValuesAction extends ActionSupport implements ModelDriven<UpdateDisplayBean> {

	
	private static final long serialVersionUID = 1L;
	
	UpdateDisplayBean updateBean= new UpdateDisplayBean();
	public ArrayList<SearchUpdateBean> searchUpdateBean= new ArrayList<SearchUpdateBean>();
	UpdateInsertDao updateInsertDao= new UpdateInsertDao();
	SearchUpdateDB searchUpdateDB= new SearchUpdateDB();
	int dbResult;
	String result;
	
	HashMap<Integer, String> testList = new HashMap<Integer, String>();


	public String execute() {
	
		dbResult = updateInsertDao.getUpdateResult(getUpdateBean());

		
		if(dbResult!=0)
		{
			
		/*	testList.put("AssetServiceTag", TestDB.AssetServiceTag);
			testList.put("AssetGSUdecalNumber", TestDB.AssetGSUdecalNumber);
			testList.put("Owner", TestDB.Owner);
			testList.put("PersonType", TestDB.PersonType);
			testList.put("AssetDescription", TestDB.AssetDescription);
			testList.put("OnOffCampus", TestDB.OnOffCampus);
			testList.put("BuildingName", TestDB.BuildingName);
			testList.put("PersonDepartment", TestDB.PersonDepartment);
			testList.put("WarrantyEndDate", TestDB.WarrantyEndDate);
			testList.put("PersonLastName", TestDB.PersonLastName);
			testList.put("WarrantyStartDate", TestDB.WarrantyStartDate); */
			
			testList.put(1, TestDB.AssetServiceTag);
			testList.put(2, TestDB.AssetGSUdecalNumber);
			testList.put(3, TestDB.Owner);
			testList.put(4, TestDB.PersonType);
			testList.put(5, TestDB.AssetDescription);
			testList.put(6, TestDB.OnOffCampus);
			testList.put(7, TestDB.BuildingName);
			testList.put(8, TestDB.PersonDepartment);
			testList.put(9, TestDB.WarrantyEndDate);
			testList.put(10, TestDB.PersonLastName);
			testList.put(11, TestDB.WarrantyStartDate);

			searchUpdateBean=searchUpdateDB.getSearchValues(testList);
			this.setSearchUpdateBean(searchUpdateBean);
			
			if(searchUpdateBean.isEmpty()){
				result="failure";
			}else{
				result="success";
			}
		}
		else result="failure";
		return result;
	}
	


	public int getDbResult() {
		return dbResult;
	}


	public void setDbResult(int dbResult) {
		this.dbResult = dbResult;
	}
	
	public UpdateDisplayBean getUpdateBean() {
		return updateBean;
	}

	public void setUpdateBean(UpdateDisplayBean updateBean) {
		this.updateBean = updateBean;
	}

	public ArrayList<SearchUpdateBean> getSearchUpdateBean() {
		return searchUpdateBean;
	}

	public void setSearchUpdateBean(ArrayList<SearchUpdateBean> searchUpdateBean) {
		this.searchUpdateBean = searchUpdateBean;
	}
	
	@Override
	public UpdateDisplayBean getModel() {
		// TODO Auto-generated method stub
		return updateBean;
	}
	
	

}
