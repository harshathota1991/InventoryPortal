<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<s:head />
<title> LoginPage</title>
<link rel="stylesheet" type="text/css" href="login_style.css">
</head>
<body>

<div id="header">
<h1>SNHP Inventory Online Portal</h1>
</div>



<div id="section">



<div class="login-page">
<div class="form">
<h2>Login</h2>
<s:form class="login-form" action="getLogin" method="post" >
<s:textfield key="username" label="Username" ></s:textfield>
<s:password key="password"  label="Password" ></s:password>
<s:submit></s:submit>    
</s:form>
</div>
</div>
</div>

<div id="footer">
Copyright &copy; Georgia State University
</div>

</body>
</html>
