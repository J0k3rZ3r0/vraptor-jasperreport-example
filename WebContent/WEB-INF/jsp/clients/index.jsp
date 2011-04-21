<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>VRaptor Blank Project</title>
</head>
<body>
   
   <form action="<c:url value="/clients"/>" method="post">
	    Name: <input type="text" name="client.name" /><br/>
	    Email: <input type="text" name="client.email" /><br/>
	    <input type="submit" value="Save" /><br>
	</form>
	
	<table>  
     
	   <tr>  
	      <td>Name</td>   
	      <td>Email</td>   
	   </tr>  
	   
	   <c:forEach var="client" items="${clients}">  
	   <tr>  
	      <td><c:out value="${client.name}"/></td>          
	      <td><c:out value="${client.email}"/></td>
	   </tr>      
	   </c:forEach>  
	   
	<br>
	
	Clients <br>
	
   </table> 
	
	<a href="<c:url value="/clients/csv"/>">CSV</a>
	<a href="<c:url value="/clients/xls"/>">XLS</a>
	<a href="<c:url value="/clients/docx"/>">DOCX</a>
	<a href="<c:url value="/clients/rtf"/>">RTF</a>
	<a href="<c:url value="/clients/txt"/>">TXT</a>
	<a href="<c:url value="/clients/odt"/>">ODT</a>
	<a href="<c:url value="/clients/pdf"/>">PDF</a>
    <a href="<c:url value="/clients/zip"/>">ZIP</a>
    
</body>
</html>