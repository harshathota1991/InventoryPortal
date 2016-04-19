<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
       <%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html>
<html>
<head>
<sx:head />
<title>Update Main Page</title>
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
    $( "#DateEntered" ).datepicker({ dateFormat: 'yy-mm-dd' });
  });
  </script>
  <script>
  $(function() {
    $( "#DateSurplusPU" ).datepicker({ dateFormat: 'yy-mm-dd' });
  });
  </script>
  <script>
  $(function() {
    $( "#WarrantyEndDate" ).datepicker({ dateFormat: 'yy-mm-dd' });
  });
  </script>

</head>
<body>

<div id="header">
	<h1>SNHP Inventory Online Portal</h1>
</div>



<div id="section" >
	<div id="header" style=" background-color:#37ABC4;">
		<h2> UPDATE Asset Form</h2>
		<h3>Please fill the values to UPDATE</h3>
		<h4 style="text-align:right; "><a href = "index.jsp"> &lt;-- Back to Portal (Search, Update &amp; Report)</a></h4>
	</div>
	
	<s:form action="updateInsertValues" method="post" enctype="multipart/form-data">
<table>

<tr>
<td>
<h2 style="color:purple; font-family: cursive; text-align:right; "> Asset Description</h2>
</td>
</tr>

<tr>
<td>
<s:hidden key="PAL_ID"   value="%{UpdateBean.PAL_ID}"  />
</td>
</tr>

<tr>
<td>
<s:radio key="Owner"  value="%{UpdateDisplayBean.Owner}" label="Choose One"  list="{'Lab','Furniture','Classroom','IT'}" />
      
</td>
</tr>

<tr>
<td>
	 <s:select label="Description"   limit="1" key="AssetDescription" value="%{UpdateDisplayBean.AssetDescription}"
         list="{'Select','Book Shelf','Conference Chair','Conference Table','Desk','Desk Chair','Display Case','External Hard Drive','File Cabinet','Laboratory Equipment =/&gt; $3,000','Laboratory Equipment &lt; $3,000','Lamp/Lighting','Mac Desktop','Mac Laptop','Mobile Phone','Monitor','Notebook','Office Chair','Office Table','Desktop','PC Desktop','PC Laptop','Projector','Printer','Laser Jet','Scanner','Tablet','Telephone'}" />
  
</td>
</tr>

<tr>
<td>
<s:textfield key="AssetManufacturer" value="%{UpdateDisplayBean.AssetManufacturer}" label="Manufacturer" ></s:textfield>
  
</td>
</tr>

<tr>
<td>
 <s:textfield label="Serial Number" key="AssetSerialNumber" value="%{UpdateDisplayBean.AssetSerialNumber}" ></s:textfield>
  
</td>
</tr>

<tr>
<td>
   <s:textfield label="Model Number" key="AssetModelNameNumber" value="%{UpdateDisplayBean.AssetModelNameNumber}"></s:textfield>
  
</td>
</tr>

<tr>
<td>
  <s:textfield label="GSU Decal Number (assigned by Purchasing)" key="UpdateDisplayBean" value="%{UpdateDisplayBean.AssetGSUdecalNumber}" ></s:textfield>
  
</td>
</tr>

   <tr>
<td>

  <s:textfield label="Label Number (assigned by SNHP)" key="AssetLabelNumber" value="%{UpdateDisplayBean.AssetLabelNumber}" ></s:textfield>
  
</td>
</tr>
   
   
   <tr>
<td>
 <s:textfield label="Computer Systems Name" key="AssetCompName" value="%{UpdateDisplayBean.AssetCompName}" ></s:textfield>
 
</td>
</tr>
   
   
   <tr>
<td>
 <s:textfield label="MAC address" key="AssetMACaddress" value="%{UpdateDisplayBean.AssetMACaddress}" ></s:textfield>
 
</td>
</tr>
   
   <tr>
<td>
 <s:textfield label="IP Address" key="AssetIPaddress" value="%{UpdateDisplayBean.AssetIPaddress}" ></s:textfield>
   
</td>
</tr>
   
   <tr>
<td>
  <s:textfield label="Asset Computer Name" key="AssetOffCampusAddress" value="%{UpdateDisplayBean.AssetOffCampusAddress}" ></s:textfield>
  
</td>
</tr>
   
   <tr>
<td>
 <s:textfield label="Service Tag" key="AssetServiceTag" value="%{UpdateDisplayBean.AssetServiceTag}" ></s:textfield>
 
</td>
</tr>
   
   <tr>
<td>
<s:textfield label="Date Entered" key="DateEntered" value="%{UpdateDisplayBean.DateEntered}" id="DateEntered"></s:textfield>
   
</td>
</tr>
   
   <tr>
<td>
<s:textfield label="Surplus Date Pick Up" key="DateSurplusPU" value="%{UpdateDisplayBean.DateSurplusPU}" id="DateSurplusPU"></s:textfield>
  
</td>
</tr>
   
   <tr>
<td>
 <s:radio label="ON or OFF Campus" key="OnOffCampus"  value="%{UpdateDisplayBean.OnOffCampus}" list="{'Off Campus','OnCampus'}" />
  
</td>
</tr>
   
   <tr>
<td>
<s:radio label="Status: In Use or Not in Use" key="Status" value="%{UpdateDisplayBean.Status}" list="{'In Use','Not In Use'}" />
  
</td>
</tr>
   
   <tr>
<td>
 <s:radio label="Tech Fee Used?" key="TechFee" value="%{UpdateDisplayBean.TechFee}" list="{'Yes','No'}" />
	
</td>
</tr>
   
  <tr>
<td>
<s:textfield label="Warranty End Date" key="WarrantyEndDate" value="%{UpdateDisplayBean.WarrantyEndDate}" id="WarrantyEndDate"></s:textfield>
    
</td>
</tr>

  <tr>
<td>
 <s:textfield label="Comments" key="Comment" value="%{UpdateDisplayBean.Comment}" ></s:textfield>
	
</td>
</tr>

  <tr>
<td>
<s:textfield label="Image Asset" key="ImageAsset" value="%{UpdateDisplayBean.ImageAsset}" ></s:textfield>
	
</td>
</tr>

  <tr>
<td>
		<s:file label="Upload an image" key="ImageDocs"></s:file>
  
</td>
</tr>
  
     <tr>
<td>
<h2 style="color:purple; font-family: cursive; text-align:right; "> Asset Location</h2>
</td>
</tr>

    <tr>
<td>
<s:select label="Building Name" key="BuildingName"  values="%{UpdateDisplayBean.BuildingName}" limit="1"
         list="{'Select','1 Park Place','Kell Hall', 'PSC', 'Urban Life'}" />
   
</td>
</tr>
    
    <tr>
<td>
 <s:select label="Location Type" key="LocationType" value="%{UpdateDisplayBean.LocationType}" limit="1"
         list="{'Select','Classroom','Home','Lab','Lobby','Office','Public Area'}" />
    
</td>
</tr>
    
    <tr>
<td>
   <s:textfield label="Room Number" key="LocationRoomNumber" value="%{UpdateDisplayBean.LocationRoomNumber}" ></s:textfield>
  
</td>
</tr>
    
    <tr>
<td>
 <s:textfield label="Room Name" key="LocationRoomName" value="%{UpdateDisplayBean.LocationRoomName}" ></s:textfield>
   
</td>
</tr>
    
    <tr>
<td>
 <s:textfield label="Previous Location" key="OldLocationComment" value="%{UpdateDisplayBean.OldLocationComment}" ></s:textfield>
   
</td>
</tr>
    
    <tr>
<td>
 <s:textfield label="IT Port Lan1" key="ITportLAN1" value="%{UpdateDisplayBean.ITportLAN1}" ></s:textfield>
  	
</td>
</tr>
    
    <tr>
<td>
<s:textfield label="IT Port Phone1" key="ITportPhone1" value="%{UpdateDisplayBean.ITportPhone1}" ></s:textfield>
  	
</td>
</tr>
    
    <tr>
<td>
<s:textfield label="IT Port Lan2" key="ITportLAN2" value="%{UpdateDisplayBean.ITportLAN2}" ></s:textfield>
 	
</td>
</tr>
    
    <tr>
<td>

 	<s:textfield label="IT Port Phone2" key="ITportPhone2" value="%{UpdateDisplayBean.ITportPhone2}" ></s:textfield>
  	
</td>
</tr>
    
    <tr>
<td>
<s:textfield label="IT Port Lan3" key="ITportLAN3" value="%{UpdateDisplayBean.ITportLAN3}" ></s:textfield>
  	
</td>
</tr>
    
    <tr>
<td>
<s:textfield label="IT Port Phone3" key="ITportPhone3" value="%{UpdateDisplayBean.ITportPhone3}" ></s:textfield>
  	
</td>
</tr>
    
    <tr>
<td>
<s:textfield label="IT Port Lan4" key="ITportLAN4" value="%{UpdateDisplayBean.ITportLAN4}" ></s:textfield>
  	
</td>
</tr>
    
    <tr>
<td>
<s:textfield label="IT Port Phone4" key="ITportPhone4" value="%{UpdateDisplayBean.ITportPhone4}" ></s:textfield>
  	
</td>
</tr>
    
    <tr>
<td>
<s:textfield label="IT Port Lan5" key="ITportLAN5" value="%{UpdateDisplayBean.ITportLAN5}" ></s:textfield>
</td>
</tr>
    
    
    <tr>
<td>
<s:textfield label="IT Port Phone5" key="ITportPhone5" value="%{UpdateDisplayBean.ITportPhone5}" ></s:textfield>
   
</td>
</tr>
    
  	  <tr>
<td>
<h2 style="color:purple; font-family: cursive; text-align:center; "> Person associated with (responsible for) the Asset</h2>
</td>
</tr>

<tr>
<td>
<s:textfield label="First Name" key="PersonFirstName" value="%{UpdateDisplayBean.PersonFirstName}" ></s:textfield>
  
</td>
</tr>

<tr>
<td>
<s:textfield label="Last Name" key="PersonLastName" value="%{UpdateDisplayBean.PersonLastName}" ></s:textfield>
  
</td>
</tr>

<tr>
<td>
<s:textfield label="Dr., Ms., Mr., etc" key="PersonHonorific" value="%{UpdateDisplayBean.PersonHonorific}" ></s:textfield>
    
</td>
</tr>

<tr>
<td>
<s:select label="Person's Role" key="PersonType"  limit="1" value="%{UpdateDisplayBean.PersonType}"
         list="{'Select','Faculty','Staff','Student'}" />
     
</td>
</tr>

<tr>
<td>
 <s:textfield label="Title/Position" key="PersonTitle" value="%{UpdateDisplayBean.PersonTitle}" ></s:textfield>
      
</td>
</tr>

<tr>
<td>
    <s:textfield label="Office Phone" key="PersonOfficePhone" value="%{UpdateDisplayBean.PersonOfficePhone}" ></s:textfield>
 
</td>
</tr>

<tr>
<td>
  <s:textfield label="Cell Phone" key="PersonCellPhone" value="%{UpdateDisplayBean.PersonCellPhone}" ></s:textfield>
 
</td>
</tr>

<tr>
<td>
 <s:textfield label="Home Phone" key="PersonHomePhone" value="%{UpdateDisplayBean.PersonHomePhone}" ></s:textfield>
 
</td>
</tr>

<tr>
<td>
        <s:textfield label="Office Email" key="PersonOfficeEmail" value="%{UpdateDisplayBean.PersonOfficeEmail}" ></s:textfield>
 
</td>
</tr>

<tr>
<td>
 <s:textfield label="Home Email" key="PersonHomeEmail" value="%{UpdateDisplayBean.PersonHomeEmail}" ></s:textfield>
 
</td>
</tr>

<tr>
<td>

            <s:select label="Person's Department" key="PersonDepartment"  value="%{UpdateDisplayBean.PersonDepartment}" limit="1"
      			 list="{'Select','HP','Nursing','Informatics','Deans Office','Nutrition','OAA','PHG','Physical Therapy','Respiratory Therapy'}" />
     
</td>
</tr>

<tr>
<td>
 
		<s:submit  align="center" label="INSERT"></s:submit>
		<s:reset align="center" label="CLEAR ALL"></s:reset>

</td>
</tr>

     
</table>
</s:form>



</div>

<div id="footer">
Copyright &copy; Georgia State University
</div>

</body>
</html>


