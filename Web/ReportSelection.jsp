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

<div id="header" style=" background-color:#37ABC4;">
		<h2> SNHP Reports</h2>
		
		<h4 style="text-align:right; "><a href = "index.jsp"> &lt;-- Back to Portal (Search, Update &amp; Report)</a></h4>
	</div>

<div class="login-page">
  <div class="form">
    
 <h2>Create View Report</h2>   
<form action="viewReportSelect" method="post">
<input type="submit" value="Create View Report">
</form>

<h2>Create Excel Report</h2>
<form action="viewReportExcel" method="post">
<input type="submit" value="Create Excel">
</form>



<h2>Create PDF report</h2>
<form action="viewReportPDF" method="post">
<input type="submit" value="Create PDF">
</form>
  </div>
</div>
</div>


<div id="footer">
Copyright &copy; Georgia State University
</div>

</body>
</html>
