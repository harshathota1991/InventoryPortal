<%@ page import="java.sql.*,java.io.*,java.util.*" %>   
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
   pageEncoding="ISO-8859-1" session="false"%>  
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
 <html>  
 <head>  
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
 <title>post</title>  
 </head>  
 <body>  
 <%  
 try {  Class.forName("com.mysql.jdbc.Driver");
	Connection	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/snhpinventory", "inventory", "h9HrzQLZ7N");
	PreparedStatement ps = con.prepareStatement("select ImageDocs from personassetlocation where PAL_ID = ?");  
   String idd = request.getParameter("idd");  
   int id=Integer.parseInt(idd);  
   
   ps.setInt(1,id );
   OutputStream os;
   InputStream is;
   os = response.getOutputStream();  
   ResultSet rs = ps.executeQuery();  
   while(rs.next()){  
   Blob b = rs.getBlob("ImageDocs");  
   response.setContentType("image/jpeg");  
   response.setContentLength((int) b.length());  
    is = b.getBinaryStream();  
   
   byte buf[] = new byte[(int) b.length()];  
   is.read(buf);  
   os.write(buf); 
   
   }
  
     
 }catch (IllegalStateException e) {  
	   System.out.println(e.getMessage());  
	 }  
 catch (Exception ex) {  
   System.out.println(ex.getMessage());  
 }  
 %>  
 </body>  
 </html>  