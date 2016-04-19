<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<title> InsertSuccess</title>
<link rel="stylesheet" type="text/css" href="login_style.css">
</head>
<body>

<div id="header">
<h1>SNHP Inventory Online Portal</h1>
</div>



<div id="section">



<div class="login-page">
  <div class="form">
    <h1>Sorry, No records Found !!</h1>
    <s:form action="insertSuccess">
<s:submit label="Click for another search" value="Click"></s:submit>
</s:form>

  </div>
</div>

</div>

<div id="footer">
Copyright &copy; Georgia State University
</div>

</body>
</html>
