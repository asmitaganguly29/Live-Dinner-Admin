<%@page import="java.util.ArrayList"%>
<%@page import="bean.Add_Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Items</title>

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
           Add Items
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Add Items</li>
          </ol>
        </section>

<form action="add_items" method="post" enctype="multipart/form-data">
<table>


<tr>
<td><h6>Select Category</h6></td>
<td>
<select name="categoryid" id="categoryid">

	<%
	    Add_Category ac = new Add_Category();
		ArrayList<Add_Category> allcategories = ac.getAllcategories();
		//foreach loop 
		for(Add_Category ab : allcategories)
		{
			out.println("<option value ='"+ab.getCategoryId()+"'>"+ab.getCategoryName()+"</option>");

		}
	%>
 </select>
 </td>
 </tr>
 </table>
 
 <br>
 <hr>
  
  <table>
 
 <tr>
 <td>
 <b>Enter Item Name</b>
 </td>
 <td>
 <input type="text" name="itemName">
 </tr>
 
 <tr>
 <td>
 <b>Enter Item Price</b>
 </td>
 <td>
 <input type="number" name="price">
 </tr>
 
 <tr>
 <td>
 <b>Enter Item Description</b>
 </td>
 <td>
 <input type="text" name="description">
 </tr>
 
 <tr>
 <td>
 <b>Enter Image</b>
 </td>
 <td>
 <input type="file" value="Browse" name="image">
 </tr>
 <tr>
 <td><input type="submit" value="submit" ></td>
 </tr>
 
 <tr>
	  <td>
	  		${requestScope['message'] }
	  </td>
	  </tr>
 </table>


</form>


<jsp:include page="jsLinks.jsp"></jsp:include>

</body>
</html>