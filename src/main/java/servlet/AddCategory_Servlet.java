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

import bean.Add_Category;



@WebServlet(urlPatterns = "/add_category")

public class AddCategory_Servlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String categoryName = req.getParameter("categoryName");
		
		Add_Category ob = new Add_Category();
		ob.setCategoryName(categoryName);
		
        PrintWriter out = resp.getWriter();
		
        try {
        	int res = ob.addcategory();
			if (res==1)
			{
				RequestDispatcher rd = req.getRequestDispatcher("add_category.jsp");
				req.setAttribute("message", "Added Successfully");
				rd.forward(req, resp);
			}
			else
			{
				RequestDispatcher ab = req.getRequestDispatcher("add_category.jsp");
				req.setAttribute("message", "Failed");
				ab.forward(req, resp);
			}
			
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
