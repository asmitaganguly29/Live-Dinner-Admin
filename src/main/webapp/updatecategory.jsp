<%@page import="bean.Manage_Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Category</title>
</head>
<body>

<%
		Manage_Category cat = new Manage_Category();
		if(request.getParameter("cat_id")!=null)
		{
			int categoryId = Integer.parseInt(request.getParameter("cat_id"));
			
			Manage_Category ab = new Manage_Category();
		     ab.setCategoryId(categoryId);
		    
		    cat = ab.categorybyid();
		}
	
	%>
	
	<form action="updatecategory" method="post">
	
	<table>
	<tr>
	<td>
	CategoryId
	</td>
	<td><input type="text" value="<% out.println(cat.getCategoryId()); %>" name="categoryId" readonly="readonly"></td>
	</tr>
	 <tr>
	 <td>
	 Category Name
	 </td>
	  <td>
	  <input type="text" value="<% out.println(cat.getCategoryName()); %>" name="categoryName">
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