<%@page import="java.util.ArrayList"%>
<%@page import="bean.Add_Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Category</title>

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
           Add Category
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Add Category</li>
          </ol>
        </section>

<form action="add_category" method="post">

<table>
     <tr>
     <td>
     <h5>Enter Category</h5>
     </td>
     <td>
     <input type="text" placeholder="Enter category..." name="categoryName">
     </td>
     <td>
     <input type="submit" value="Add">
     </td>
     </tr>
</table>
           
<br>
<hr>
 
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