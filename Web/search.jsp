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

  <script>
  $(function() {
    $( "#WarrantyEndDate" ).datepicker({ dateFormat: 'yy-mm-dd' });
  });
  </script>
  <script>
  $(function() {
    $( "#WarrantyStartDate" ).datepicker({ dateFormat: 'yy-mm-dd' });
  });
  </script>
  
  
</head>
<body >

<div id="header" >
	<h1>SNHP Inventory Online Portal</h1>
</div>



<div id="section" align="center" >
	<div id="header" style=" background-color:#37ABC4;">
		<h2> Search Asset Form</h2>
		<h3>Please fill the values</h3>
		<h4 style="text-align:right; "><a href = "index.jsp"> &lt;-- Back to Portal (Search, Update &amp; Report)</a></h4>
	</div>

<div style="height: 50px;">
</div>
	<s:form action="searchValues" method="post" >

		
			 <sx:autocompleter label="Person Last Name" headerValue="select" key="PersonLastName"  maxlength="30"
         list="{'Select','Abernathy','Andrews','Ari','Aycock','Bacon','Bates','Benardot','Brown','Browning','Bryant','Butler','Cardriche','Carmon','Casseus','Chen','Clark','Cody','Cole','Corley','Cranford','Cranwell Bruce','Dabney','Desk','Difalco','Dodson','Durham','Eades','Eastman','Esmond','Evans','Faison','Fisher','Florman','Front','FrontDesk','FrontDesk (rear)','Ganji','Garcia','Gardenhire','Go','Goodfellow','Gordon','Gore','Grant','Grantham','Green','Greer','Han','Harwood','Helvig','Henes','Hewell','Hightower','Holloway','Hopkins','Horne','Hudson','Huggins','Irwin','Jefferson','Johnson','Kelley','Kibler','Killian','Kirkendoll','Lab','Lawrence','Lee','Lewis','Little','Lobby','Long','Lorio','Luckie','Marcus','Mathews','May','Mccarroll','McCory','McRory','Mckesson','Mcmanus','Melon','Middleton','Miller','Milner','Milon','Minick','Mo','Molet','Moloney','Morelli','Muirhead','Mukenge','Murray','Nash','Ndirangu','Nelson','Norman','Norrington','Nucci','Nunez','Okhee','Parker','Part Time Instructor','Plitnick','Polovich','Reed','Rhodes','Richardson','Riley','Riley Pace','Roberts','Roseberry','Sheard','Sims','Slade','Smarr','Smith','Spratling','Stephens','Stith','Summers','Surplus','Swaray','Taylor','Thomas','Thomas Meikle','Thompson','Tice','Todd','Townsend','Tsai','Wade','Wang','Warren','Washington','Williamson','Wilmoth','Woolfalk','Zimmerman' }" />
  
			            	
		      <s:textfield key="AssetServiceTag" label="Service Tag" maxlength="30" ></s:textfield>
         
		     <s:textfield key="AssetGSUdecalNumber" label="GSU Decal Number" maxlength="30" ></s:textfield>
         
		<s:select label="Owner" key="Owner" limit="1" 
         list="{'Select','Lab','Furniture','Classroom','IT'}" />
   
				
			<s:select label="Person Type" key="PersonType" limit="1" headerValue="select"
         list="{'Select','Staff','Faculty', 'Student'}" />
   
					
				
			 <s:select label="Description"  key="AssetDescription"  limit="1"
         list="{'Select','Book Shelf','Conference Chair','Conference Table','Desk','Desk Chair','Display Case','External Hard Drive','File Cabinet','Laboratory Equipment =/&gt; $3,000','Laboratory Equipment &lt; $3,000','Lamp/Lighting','Mac Desktop','Mac Laptop','Mobile Phone','Monitor','Notebook','Office Chair','Office Table','Desktop','PC Desktop','PC Laptop','Projector','Printer','Laser Jet','Scanner','Tablet','Telephone'}" />
  
				<s:select label="OnOff Campus" key="OnOffCampus" limit="1" 
         list="{'Select','OnCampus','Off Campus'}" />
   
   
				 <s:select label="Building Name" key="BuildingName" limit="1"
         list="{'Select','1 Park Place','Kell Hall', 'PSC', 'Urban Life'}" />
   
				
				 <s:select label="Department" key="PersonDepartment"  limit="1"
      			 list="{'Select','HP','Nursing','Informatics','Deans Office','Nutrition','OAA','PHG','Physical Therapy','Respiratory Therapy'}" />
      
			<s:textfield label="Warranty Start Date" key="WarrantyStartDate" maxlength="30" id="WarrantyStartDate"></s:textfield>
    	
			<s:textfield label="Warranty End Date" key="WarrantyEndDate" maxlength="30" id="WarrantyEndDate"></s:textfield>
    		
				<s:submit align="center" label="ENTER"></s:submit>
				<s:reset align="center"></s:reset>
	</s:form>
	


<div style="height: 50px;">
</div>



</div>

<div id="footer" >
Copyright &copy; Georgia State University
</div>

</body>
</html>
