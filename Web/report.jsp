<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
       <%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html>
<html>

<sx:head/>
<title> Create REPORT Page</title>
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
    $( "#DateSurplusPU" ).datepicker({ dateFormat: 'yy-mm-dd' });
  });
  </script>
  <script>
  $(function() {
    $( "#WarrantyStartDate" ).datepicker({ dateFormat: 'yy-mm-dd' });
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



<div id="section" align="center">

	<div id="header" style=" background-color:#37ABC4;">
		<h2> Create Asset Report</h2>
		<h3>Please fill the values</h3>
		<h4 style="text-align:right; "><a href = "index.jsp"> &lt;-- Back to Portal (Search, Update &amp; Report)</a></h4>
	</div>
<div style="height: 50px;">
</div>
		 <s:form action="generateReport" method="post">

		<s:select  key="Owner" limit="1" value=""
         list="{'Select','Lab','Furniture','Classroom','IT'}" />
         
      	<s:select   key="AssetDescription"  limit="1"
         list="{'Select','Book Shelf','Conference Chair','Conference Table','Desk','Desk Chair','Display Case','External Hard Drive','File Cabinet','Laboratory Equipment =/&gt; $3,000','Laboratory Equipment &lt; $3,000','Lamp/Lighting','Mac Desktop','Mac Laptop','Mobile Phone','Monitor','Notebook','Office Chair','Office Table','Desktop','PC Desktop','PC Laptop','Projector','Printer','Laser Jet','Scanner','Tablet','Telephone'}" />
  	
  		<s:textfield key="DateSurplusPU" id="DateSurplusPU"></s:textfield>

	<s:select  key="OnOffCampus" limit="1" 
         list="{'Select','OnCampus','Off Campus'}" />
         
         
 	    <s:select  key="BuildingName" limit="1"
         list="{'Select','1 Park Place','Kell Hall', 'PSC', 'Urban Life'}" />
   
   <tr>
 	  <td>
   <s:select label="Department" key="PersonDepartment"  limit="1"
 	 list="{'Select','HP','Nursing','Informatics','Deans Office','Nutrition','OAA','PHG','Physical Therapy','Respiratory Therapy','Occupational Therapy'}" />
 	 </td>
  </tr>
   		<s:textfield label="Warranty Start Date" key="WarrantyStartDate" id="WarrantyStartDate"></s:textfield>
    	
   		<s:textfield label="Warranty End Date" key="WarrantyEndDate" id="WarrantyEndDate"></s:textfield>

		<s:submit align="center" label="Click Here"></s:submit>
		<s:reset align="center"></s:reset>
		
		</s:form>	
		<div style="height: 50px;">
</div>
		<div style="height: 50px;">
</div>

</div>

<div id="footer">
	Copyright &copy; Georgia State University
</div>

</body>

</html>






