<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<title> UpdateSuccess</title>
<link rel="stylesheet" type="text/css" href="login_style.css">

</head>
<body>

<div id="header">
<h1>SNHP Inventory Online Portal</h1>
</div>



<div id="section">



<div class="login-page">
  <div class="form">
    <h1>Update Success !!</h1>
    
    <h3>Successfully inserted <s:property value="resultDB" /> rows !!</h3>
  
  <div style="height:30px;">
  
  </div>
  <h4>Click here for home page</h4> 
<s:form action="insertSuccess">

<s:submit align="center" value="Click here"></s:submit>
</s:form>
  </div>
</div>

</div>

<div id="footer">
Copyright &copy; Georgia State University
</div>

</body>
</html>
