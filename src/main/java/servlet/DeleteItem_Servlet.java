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


import bean.Manage_Items;


@WebServlet(urlPatterns = "/deleteitem")
public class DeleteItem_Servlet extends HttpServlet
{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		int itemId = Integer.parseInt(req.getParameter("item_id"));
		
		PrintWriter out = resp.getWriter();
		
		Manage_Items ob = new Manage_Items();
		ob.setItemId(itemId);
		
		//RequestDispatcher rd = req.getRequestDispatcher("manage_items.jsp");
		
		
		try {
			int res = ob.deleteitem();
			if (res==1)
			{
				out.println("Deleted Successfully");
				/*
				 * req.setAttribute("message", "Deleted Successfully");
				 * req.setAttribute("item_id", 0);
				 */
			}
				
			else
				out.println("Not Deleted");
				//req.setAttribute("message", "Not Deleted");
			
			//rd.forward(req, resp);
			
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

