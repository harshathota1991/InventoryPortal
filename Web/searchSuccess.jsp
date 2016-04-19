<%@page import="edu.gsu.snhp.action.SearchValuesAction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
       <%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html>
<html>
<head>
<sx:head />
<title>Search Success Page</title>
<link rel="stylesheet" type="text/css" href="search_style.css">

<!--[if lt IE 9]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js">
</script>
<![endif]-->

<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
 	 <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">

  <script>
  $(function() {
    $( "#WarrantyEndDate" ).datepicker({ dateFormat: 'yy-mm-dd' });
  });
  </script>
  <style>

table{
width: 50%;
text-align: center;
border: 1px solid;
border-color: black;
}
tr, td{
border: 1px solid;
border-color: gray;

}

td{
font-family: sans-serif;
font-weight: bold;
}
hr{
border-color: red;
border: 3px;
border-style: double;
width: 60%;
}

</style>
  
</head>
<body >
<%

int i=1;
%>
<div id="header">
	<h1>SNHP Inventory Online Portal</h1>
</div>



<div id="section" align="center">
	<div id="header" style=" background-color:#37ABC4;">
		<h2> Search Result</h2>
		
		<h4 style="text-align:right; "><a href = "index.jsp"> &lt;-- Back to Portal (Search, Update &amp; Report)</a></h4>
	
</div>

<div class="form">
<h2 style="text-align:center; font-family: Arial Rounded MT Bold; color:#8C001A"> Total Number of Assets: <s:property value="%{getDisplayBeans().size()}"/> </h2>


<s:iterator value = "displayBeans" >
<table>
<tr>
<td style="border:none;"><h3 style="font-family: cursive; color: #CD5C5C;">Inventory Tracking-Asset <%= i++ %></h3></td>
</tr>

<tr>
<td>Person Last Name:</td>
<td><s:property value="PersonLastName"/></td></tr>

<tr>
<td>Asset Service Tag</td> 
<td><s:property value="AssetServiceTag"/></td>
</tr>

<tr>	
<td> Asset Manufacturer</td>
<td><s:property value="AssetManufacturer"/></td>
</tr>

<tr>	
<td>Asset Description</td>
<td><s:property value="AssetDescription"/></td>
</tr>

<tr>
<td>Asset GSU Decal Number</td>	
<td><s:property value="AssetGSUdecalNumber"/></td>
</tr>


<tr>
<td>Owner</td>	
<td><s:property value="Owner"/></td>
</tr>

<tr>
<td>Asset Label Number</td>
<td><s:property value="AssetLabelNumber"/></td>
</tr>

<tr>
<td>Building Name</td>	
<td><s:property value="BuildingName"/></td>
</tr>

<tr>
<td>Location Type</td>	
<td><s:property value="LocationType"/></td>
</tr>
<tr>
<td>Location Room Number</td>	
<td><s:property value="LocationRoomNumber"/></td>
</tr>
<tr>
<td> Person Department</td>	
<td><s:property value="PersonDepartment"/></td>
</tr>
<tr>
<td style="color:#8B0000; font-family: Chalkboard;">CLICK HERE TO UPDATE!</td>
<td >

<s:form action="selectUpdate" method="post">
<s:hidden key="PAL_ID"></s:hidden>
<s:submit align="center" value="UPDATE"></s:submit>

</s:form>
</td>
</tr>
</table>
</s:iterator>

<s:form  action="insertSuccess">
<h3 style="color: #000080; font-family: Arial Rounded MT Bold;"> Click for another Search!!</h3>
<s:submit align="center" cssStyle="color: maroon; "  value="CLICK HERE"></s:submit>
</s:form>

</div>


</div>

<div id="footer">
Copyright &copy; Georgia State University
</div>
</body>
</html>
