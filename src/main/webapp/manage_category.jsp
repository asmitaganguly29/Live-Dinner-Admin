<%@page import="java.util.ArrayList"%>
<%@page import="bean.Manage_Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Category</title>

 <jsp:include page="cssLinks.jsp"></jsp:include>

</head>
<body class="skin-blue">

<jsp:include page="headerpart.jsp"></jsp:include>
    
<jsp:include page="sidebar.jsp"></jsp:include>

 <!-- Right side column. Contains the navbar and content of the page -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
           Manage Category
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Manage Category</li>
          </ol>
        </section>
        
 <form action="manage_category" method="post">

  <h2><b>All Categories</b></h2>
	<table border="2px solid black" id="categorylist">
	<tr>
	<td><h4>Category ID</h4></td>
	<td><h4>Category</h4></td>
	<td><h4>Action</h4></td>
	</tr>
	
	<%
		Manage_Category ab = new Manage_Category();
		ArrayList<Manage_Category> allcategories = ab.Allcategories();
		//foreach loop 
		for(Manage_Category ac : allcategories)
		{
			out.println("<tr>");
			out.println("<td>"+ac.getCategoryId()+"</td>");
			out.println("<td>"+ac.getCategoryName()+"</td>");
			out.println("<td><a href='updatecategory.jsp?cat_id="+ac.getCategoryId()+"'>Edit</a> <a href='deleteCategory?cat_id="+ac.getCategoryId()+"'>Delete</a></td");
			out.println("</tr>");
		}
		 
	%>

</table>
</form>


<jsp:include page="jsLinks.jsp"></jsp:include>

</body>
</html>