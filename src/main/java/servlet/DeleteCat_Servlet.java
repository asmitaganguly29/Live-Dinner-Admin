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


@WebServlet(urlPatterns = "/deleteCategory")
public class DeleteCat_Servlet extends HttpServlet
{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		int categoryId = Integer.parseInt(req.getParameter("cat_id"));
		
		PrintWriter out = resp.getWriter();
		
		Manage_Category ob = new Manage_Category();
		ob.setCategoryId(categoryId);
		
		RequestDispatcher rd = req.getRequestDispatcher("manage_category.jsp");
		
		
		try {
			int res = ob.deletecategory();
			if (res==1)
			{
				req.setAttribute("message", "Deleted Successfully");
				req.setAttribute("prodid", 0);
			}
				
			else
				req.setAttribute("message", "Not Deleted");
			
			rd.forward(req, resp);
			
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
