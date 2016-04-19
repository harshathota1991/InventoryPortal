package edu.gsu.snhp.action;

import java.text.ParseException;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.gsu.snhp.bean.InsertDetails;
import edu.gsu.snhp.dao.InsertDB;

public class InsertValuesAction extends ActionSupport implements ModelDriven<InsertDetails>  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	InsertDetails insertDetails= new InsertDetails();
	InsertDB insertDB;
	int resultDB;
	String result;
	
	public int getResultDB() {
		return resultDB;
	}


	public void setResultDB(int resultDB) {
		this.resultDB = resultDB;
	}


	public InsertDetails getInsertDetails() {
		return insertDetails;
	}


	public void setInsertDetails(InsertDetails insertDetails) {
		this.insertDetails = insertDetails;
	}


	public String execute() throws ParseException{
		System.out.println("in execute");
		insertDB=new InsertDB();
		resultDB = insertDB.insertValues(getInsertDetails());
		if(resultDB!=0){
			result="success";
			//System.out.println("result from execute"+result);
		}else
		{
			result="failure";
			//System.out.println("result from execute"+result);
		}
		return result;
	}
	
	
	@Override
	public InsertDetails getModel() {
		// TODO Auto-generated method stub
		return insertDetails;
	}

}
