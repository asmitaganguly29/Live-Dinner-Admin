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


@WebServlet(urlPatterns = "/updateitems")
public class UpdateItem_Servlet extends HttpServlet
{

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String itemName = req.getParameter("itemName");
		int itemId = Integer.parseInt(req.getParameter("itemId"));
		
		PrintWriter out = resp.getWriter();
		
		
		
		
		Manage_Items ob = new Manage_Items();
		ob.setItemName(itemName);
		ob.setItemId(itemId);
		RequestDispatcher rd = req.getRequestDispatcher("update_items.jsp");
		
		
		try {
			int res = ob.updateitem();
			if (res==1)
			{
				req.setAttribute("message", "Updated Successfully");
				req.setAttribute("item_id", 0);
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
