<%@page import="edu.gsu.snhp.bean.CreateReportBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
       <%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html>
<html>
<head>
<sx:head />
<title>Insert Page</title>
<link rel="stylesheet" type="text/css" href="search_style.css">

<!--[if lt IE 9]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js">
</script>
<![endif]-->

<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
 <script src="//code.jquery.com/jquery-1.10.2.js"></script>
 <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<style>

table{
width: 50%;
text-align: center;
border: 2px solid;
border-color: black;
}
tr, td{
border: 1px solid;
border-color: olive;

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
  <script>
  $(function() {
    $( "#WarrantyEndDate" ).datepicker({ dateFormat: 'yy-mm-dd' });
  });
  </script>
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
		<h2> Report Result</h2>
		
		<h4 style="text-align:right; "><a href = "index.jsp"> &lt;-- Back to Portal (Search, Update &amp; Report)</a></h4>
	</div>

<div class="form">


<h2 style="text-align:center; font-family: cursive; color:#8C001A"> Total Number of Assets: <s:property value="%{getCreateReportList().size()}"/> </h2>

<s:iterator value = "createReportList" >

<table >

<tr>
<td style="border: 0px;">	<h3 style="color:#8C001A; font-family: cursive;"> Asset Number <%= i++ %></h3>

	</td>
</tr>
<tr>
<td>Person FirstName</td>

<td><s:property value="PersonFirstName" /></td>
</tr>

<tr>
<td>	Person LastName	</td>
<td><s:property value="PersonLastName" /></td>
</tr>

<tr>
<td>	Person Type	</td>
<td><s:property value="PersonType" /></td>
</tr>

<tr>
<td>	Person Department	</td>
<td> <s:property value="PersonDepartment" /> </td>
</tr>

<tr>
<td>	Person Office Phone	</td>
<td> <s:property value="PersonOfficePhone" /> </td>
</tr>

<tr>
<td>	Person Cell Phone	</td>
<td> <s:property value="PersonCellPhone" /> </td>
</tr>

<tr>
<td>	Person Home Phone	</td>
<td>	<s:property value="PersonHomePhone" /> </td>
</tr>

<tr>
<td>	Person Office Email	</td>
<td> <s:property value="PersonOfficeEmail" /> </td>
</tr>

<tr>
<td>	Person Home Email</td>
<td> <s:property value="PersonHomeEmail" /> </td>
</tr>

<tr>
<td>	Person Title	</td>
<td>	<s:property value="PersonTitle" /> </td>
</tr>

<tr>
<td>	Person Honorific	</td>
<td>	<s:property value="PersonHonorific" /> </td>
</tr>

<tr>
<td>	Asset Description	</td>
<td>	<s:property value="AssetDescription" /> </td>
</tr>

<tr>
<td>	Asset Manufacturer	</td>
<td>	<s:property value="AssetManufacturer" /> </td>
</tr>

<tr>
<td>	Asset SerialNumber</td>
<td>	<s:property value="AssetSerialNumber" /> </td>
</tr>

<tr>
<td>	Asset Model Name Number	</td>
<td>	<s:property value="AssetModelNameNumber" /> </td>
</tr>

<tr>
<td>	Asset GSUdecal Number	</td>
<td>	<s:property value="AssetGSUdecalNumber" /> </td>
</tr>

<tr>
<td>	Asset Label Number	</td>
<td>	<s:property value="AssetLabelNumber" /> </td>
</tr>

<tr>
<td>	Asset MAC address	</td>
<td>	<s:property value="AssetMACaddress" />	</td>
</tr>

<tr>
<td>	Asset IP address	</td>
<td>	<s:property value="AssetIPaddress" />	</td>
</tr>

<tr>
<td>	Asset CompName	</td>
<td>	<s:property value="AssetCompName" />	</td>
</tr>

<tr>
<td>	Asset Service Tag	</td>
<td>	<s:property value="AssetServiceTag" /> </td>
</tr>

<tr>
<td>	Date Entered	</td>
<td>	<s:property value="DateEntered" /> </td>
</tr>

<tr>
<td>	Date Surplus	</td>
<td>	<s:property value="DateSurplusPU" />	</td>
</tr>

<tr>
<td>	On/Off Campus	</td>
<td>	<s:property value="OnOffCampus" />	</td>
</tr>

<tr>
<td>	Asset OffCampus Address	</td>
<td>	<s:property value="AssetOffCampusAddress" />	</td>
</tr>

<tr>
<td>	Status	</td>
<td>	<s:property value="Status" />	</td>
</tr>

<tr>
<td>	TechFee	</td>
<td>	<s:property value="TechFee" />	</td>
</tr>

<tr>
<td>	Warranty End Date	</td>
<td>	<s:property value="WarrantyEndDate" />	</td>
</tr>

<tr>
<td>	Comment	</td>
<td>	<s:property value="Comment" />	</td>
</tr>

<tr>
<td>	Owner	</td>
<td>	<s:property value="Owner" />	</td>
</tr>

<tr>
<td>	Image Asset	</td>
<td>	<s:property value="ImageAsset" />	</td>
</tr>

<tr>
<td>	Building Name	</td>
<td>	<s:property value="BuildingName" />	</td>
</tr>

<tr>
<td>	Location Type	</td>
<td>	<s:property value="LocationType" />	</td>
</tr>

<tr>
<td>	Location Room Number	</td>
<td>	<s:property value="LocationRoomNumber" />	</td>
</tr>

<tr>
<td>	Location Room Name	</td>
<td>	<s:property value="LocationRoomName" />	</td>
</tr>

<tr>
<td>	Old Location Comment	</td>
<td>	<s:property value="OldLocationComment" />	</td>
</tr>

<tr>
<td>	IT port LAN1	</td>
<td>	<s:property value="ITportLAN1" /> </td>
</tr>

<tr>
<td>	IT port Phone1	</td>
<td>	<s:property value="ITportPhone1" />	</td>
</tr>

<tr>
<td>	IT port LAN2	</td>
<td>	<s:property value="ITportLAN2" />	</td>
</tr>

<tr>
<td>	IT port Phone2	</td>
<td>	<s:property value="ITportPhone2" />	</td>
</tr>

<tr>
<td>	IT port LAN3	</td>
<td>	<s:property value="ITportLAN3" />	</td>
</tr>

<tr>
<td>	IT port Phone3	</td>
<td>	<s:property value="ITportPhone3" />	</td>
</tr>

<tr>
<td>	IT port LAN4	</td>
<td>	<s:property value="ITportLAN4" />	</td>
</tr>

<tr>
<td>	IT port Phone4	</td>
<td>	<s:property value="ITportPhone4" />	</td>
</tr>

<tr>
<td>	IT port LAN5	</td>
<td>	<s:property value="ITportLAN5" />	</td>
</tr>

<tr>
<td>	IT port Phone5	</td>
<td>	<s:property value="ITportPhone5" />
</td>
</tr>

<tr>
<td>	Person Home Email	</td>
<td><s:property value="PersonHomeEmail" /></td>
</tr>



<tr>
<td>	Image	</td>

<td><img width=200 height=150 alt = "No Preview Available" src=image.jsp?idd=<s:property value="PAL_ID"/> ></img></td>  
</tr>

</table>
<hr>

</s:iterator>


</div>



</div>
<div align="center">
<s:form action="insertSuccess" >
<s:submit align="center" value="Click for another SEARCH"></s:submit>
</s:form>

</div>

<div id="footer">

Copyright &copy; Georgia State University
</div>
</body>
</html>

