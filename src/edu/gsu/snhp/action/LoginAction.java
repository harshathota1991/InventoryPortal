package edu.gsu.snhp.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.gsu.snhp.bean.LoginDetails;
import edu.gsu.snhp.dao.LoginDB;

public class LoginAction extends ActionSupport implements ModelDriven<LoginDetails>{

	
	private static final long serialVersionUID = 1L;
	private LoginDetails logindetails= new LoginDetails();
	LoginDB ldb=new LoginDB();
	
	String str;


	public void validate(){
		 if ( logindetails.getUsername().length() == 0 ){ 
			 
		        addFieldError( "logindetails.username", "User name is required." );
		         
		    }
		     
		             
		    if ( logindetails.getPassword().length() == 0 ){ 
		 
		        addFieldError( "logindetails.password", "Email is required." );
		         
		    }
	}
	
	public String execute()
	{
		str=ldb.getLogin(logindetails.getUsername(),logindetails.getPassword());
		System.out.println(str);
		
		return str;
		
	}
	
	public LoginDetails getLogindetails() {
		return logindetails;
	}


	public void setLogindetails(LoginDetails logindetails) {
		this.logindetails = logindetails;
	}
	@Override
	public LoginDetails getModel() {
		// TODO Auto-generated method stub
		return logindetails;
	}
	
}
