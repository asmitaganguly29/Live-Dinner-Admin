<%@page import="bean.Manage_Items"%>
<%@page import="bean.Manage_Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Items</title>
</head>
<body>

<%
		Manage_Items it = new Manage_Items();
		if(request.getParameter("item_id")!=null)
		{
			int itemId = Integer.parseInt(request.getParameter("item_id"));
			
			Manage_Items ab = new Manage_Items();
		     ab.setItemId(itemId);
		    
		    it = ab.itembyid();
		}
	
	%>
	
	<form action="updateitems" method="post">
	
	<table>
	<tr>
	<td>
	ItemId
	</td>
	<td><input type="text" value="<% out.println(it.getItemId()); %>" name="itemId" readonly="readonly"></td>
	</tr>
	 <tr>
	 <td>
	 Item Name
	 </td>
	  <td>
	  <input type="text" value="<% out.println(it.getItemName()); %>" name="itemName">
	  </td>
	  </tr>
	  <tr>
	  <td>
	   
	  <tr>
	  <td>
	  <input type="submit" value ="Update">
	  </td>
	  </tr>
	  <tr>
	  <td>
	  		${requestScope['message'] }
	  </td>
	  </tr>
	  </table>
	  </form>
</body>
</html>