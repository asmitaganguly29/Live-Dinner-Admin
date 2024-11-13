package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Manage_Category;


@WebServlet(urlPatterns = "/updatecategory")
public class UpdateCat_Servlet extends HttpServlet
{

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String categoryName = req.getParameter("categoryName");
		int categoryId = Integer.parseInt(req.getParameter("categoryId"));
		
		PrintWriter out = resp.getWriter();
		
		
		
		
		Manage_Category ob = new Manage_Category();
		ob.setCategoryName(categoryName);
		ob.setCategoryId(categoryId);
		RequestDispatcher rd = req.getRequestDispatcher("updatecategory.jsp");
		
		
		try {
			int res = ob.updatecategory();
			if (res==1)
			{
				req.setAttribute("message", "Updated Successfully");
				req.setAttribute("cat_id", 0);
			}
				
			else
				req.setAttribute("message", "Not Updated");
			
			rd.forward(req, resp);
			
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
