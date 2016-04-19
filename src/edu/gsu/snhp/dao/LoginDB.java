package edu.gsu.snhp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.gsu.snhp.util.DBConn;

public class LoginDB {
	
	DBConn connection= new DBConn();
	Connection conn;
	String str;
	String result;
	PreparedStatement ps;
	String query;
	public String getLogin(String uname,String pwd)
	{
	try{
		conn=connection.getDBConnection();
		if(uname!=null && pwd!=null || uname!="" && pwd!=""){
			query = "select password from login where username=?";
			PreparedStatement ps= conn.prepareStatement(query);
			ps.setString(1,uname);
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				result=rs.getString("password");
			}
			}else{
				return "failure";
			}
		if(result.equals(pwd)){
			str="success";
		}
	else str="failure";
	}
	catch(SQLException e){
		e.printStackTrace();
	}
	return str;
}


}
