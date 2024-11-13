<%@page import="bean.Add_Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.Manage_Items"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Items</title>

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
           Manage Items
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Manage Items</li>
          </ol>
        </section>
		  <form action=" " method="get">     
		      <table>
				<tr>
					<td><h6>Select Category</h6></td>
				<td>
					<select id="cat_id" name="cat_id">
				
					<%
				
						Add_Category ab = new Add_Category();
							ArrayList<Add_Category> allcategories = ab.getAllcategories();
							//foreach loop 
							for(Add_Category ac : allcategories)
							{
								out.println("<option value ='"+ac.getCategoryId()+"'>"+ac.getCategoryName()+"</option>");
				
							}
					%>
				 </select>
		 		</td>
		 	</tr>
			 <tr>
			 		<td><input type="submit" value="Search" name="search"> 
			 </td>
			 </tr>
			 </table>
		 </form>
		 
		 
		 <c:if test="${param.cat_id > 0 }">
			
			
			<jsp:useBean id="n" class="bean.Manage_Items"></jsp:useBean>
            <jsp:setProperty property="categoryId" name="n" value="${param.cat_id}"/>
			
			<%
		
				ArrayList<Manage_Items> view = n.itemby_id();
				//foreach loop 
				//out.println("Size "+view.size());
				if(view.size() == 0)
				{
					out.println("There are no items available");
				}
				else 
				out.println("<h2><b>Items</b></h2>");		
				
				{
					out.println("<table border='2px' bordercolor='black'>");
					out.println("<tr>");
					out.println("<th>"+ "ItemId" +"</th>");
					out.println("<th>"+ "Item" +"</th>");
					out.println("<th>"+ "Action" +"</th>");
					
					for(Manage_Items ac: view)
					{
						out.println("<tr>");
						out.println("<td>"+ac.getItemId()+"</td>");
						out.println("<td>"+ac.getItemName()+"</td>");
						
						out.println("<td><a href='update_items.jsp?item_id="+ac.getItemId()+"'>Edit</a> <a onclick='deleteitem("+ac.getItemId()+")'>Delete</a></td");
						out.println("</tr>");
					}
					out.println("</table");
				}
				
				 
			%>
					
				</c:if>
				
				
		

 
	
	
	
	


  

<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
<jsp:include page="jsLinks.jsp"></jsp:include>
<script>
 function deleteitem(id)
 {
	 
	 $.ajax({
		 url:"deleteitem",
		 method:"get",
		 data:{"item_id":id},
		 success:function(response)
		 {
			 alert(response);
			 window.location.href = "";
		 }
	 })
	 
 }

</script>

</body>
</html>