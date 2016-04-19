package edu.gsu.snhp.action;



import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.gsu.snhp.bean.UpdateBean;
import edu.gsu.snhp.bean.UpdateDisplayBean;
import edu.gsu.snhp.dao.UpdateDB;

public class UpdateValuesAction extends ActionSupport implements ModelDriven<UpdateBean> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UpdateBean updateBean=new UpdateBean();
	UpdateDB updateDB= new UpdateDB();
	String result;
	UpdateDisplayBean updateDisplayBean = new UpdateDisplayBean();
	
public UpdateDisplayBean getUpdateDisplayBean() {
		return updateDisplayBean;
	}




	public void setUpdateDisplayBean(UpdateDisplayBean updateDisplayBean) {
		this.updateDisplayBean = updateDisplayBean;
	}




public String execute(){
	updateDisplayBean= updateDB.getInsertValues(getUpdateBean());
	
	if(updateDisplayBean==null){
			result="failure";
		}
		else{
			result="success";
		}
		return result;
	}




	public UpdateBean getUpdateBean() {
		return updateBean;
	}

	public void setUpdateBean(UpdateBean updateBean) {
		this.updateBean = updateBean;
	}

	
	@Override
	public UpdateBean getModel() {
		// TODO Auto-generated method stub
		return updateBean;
	}
	
}
