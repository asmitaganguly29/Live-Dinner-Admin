package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import bean.Add_Items;


@WebServlet(urlPatterns = "/add_items")

public class AddItem_Servlet extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		MultipartRequest mr = new MultipartRequest(req, "C:\\Users\\user\\eclipse-workspace\\Asmita_Ganguly\\LiveDinnerAdmin\\src\\main\\webapp\\Items");

		int categoryid = Integer.parseInt(mr.getParameter("categoryid"));
		String itemName = mr.getParameter("itemName");
		String description = mr.getParameter("description");
  		double price = Integer.parseInt(mr.getParameter("price"));
        File file = mr.getFile("image");
		
		String image = "Items/"+file.getName();
		 
		
		
		
		Add_Items ob = new Add_Items();
		ob.setCategoryId(categoryid);
		ob.setItemName(itemName);
		ob.setPrice(price);
		ob.setImage(image);
		ob.setDescription(description);
		
		
		PrintWriter out = resp.getWriter();
       
        RequestDispatcher rd = req.getRequestDispatcher("add_items.jsp");
		try {
			int res = ob.additems();
			if (res==1)
				{
					req.setAttribute("message", "Added Successfully");
				}
			
			else
				req.setAttribute("message", "Not Added");			
			    rd.forward(req, resp);
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

