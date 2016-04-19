<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="index_style.css">
</head>
<body>

<div id="header">
<h1>SNHP Inventory Online Portal</h1>
</div>

<div id="section">



<div class="login-page">
  <div class="form">
    <h2>SEARCH &amp; UPDATE</h2>

<form action="searchAction" method="post">
You can Search and Update the assets here !<input type="submit" value="Search">
</form>

<h2>INSERT ASSETS</h2>
<form action="insertAction" method="post">
You can Insert the assets here !<input type="submit" value="Insert">
</form>



<h2>CREATE A REPORT</h2>
<form action="reportAction" method="post">
Download reports<input type="submit" value="Report">
</form>

  </div>
</div>
</div>


<div id="footer">
Copyright &copy; Georgia State University
</div>

</body>
</html>
