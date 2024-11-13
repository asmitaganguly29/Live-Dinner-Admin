package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Manage_Category 
{

	private int categoryId;
	private String categoryName;
	
	public int getCategoryId() 
	{
		return categoryId;
	}
	public void setCategoryId(int categoryId) 
	{
		this.categoryId = categoryId;
	}
	public String getCategoryName() 
	{
		return categoryName;
	}
	public void setCategoryName(String categoryName)
	{
		this.categoryName = categoryName;
	}
	
	public static Connection dbConnect() throws SQLException
	{
		//1. Register Driver
 		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
 		
 		//2. Connection(Url, User, Password)
 		String url = "jdbc:mysql://localhost:3306/asmita";
 		String user = "root"; //bydefault
 		String password = "";
 		
 		Connection conn = DriverManager.getConnection(url, user,password);
 		
 		return conn;
	}
	
	public int updatecategory() throws SQLException
	   {
	   Connection conn = dbConnect();
		
		//3. SQL Query (Insert, Update, Delete, Read)
		String sql = "Update category set categoryName=? where categoryId=?";
		
		//4. Statement & Execute
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, categoryName);
		ps.setInt(2, categoryId);
		
		int response = ps.executeUpdate();
		
		//5. close connection
		conn.close();
		
		return response;
	}
	 
	 public int deletecategory() throws SQLException
	  {
    Connection conn = dbConnect();
		
		//3. SQL Query (Insert, Update, Delete, Read)
		String sql = "Delete from category where categoryId=?";
		
		//4. Statement & Execute
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, categoryId);
		
		int response = ps.executeUpdate();
		
		//5. close connection
		conn.close();
		
		return response;
	}
	 
	 
	 public Manage_Category categorybyid() throws SQLException
		{
	       Connection conn = dbConnect();
	       
	       String sql = "Select *from category where categoryId=?";
			
		   PreparedStatement ps = conn.prepareStatement(sql);
		   ps.setInt(1, categoryId);
			
	       ResultSet rs = ps.executeQuery();
	       
	       Manage_Category new_category = new Manage_Category();
		     
		     if(rs.next())
		     {
		    	
		    	 new_category.setCategoryId(rs.getInt("categoryId"));
		    	 new_category.setCategoryName(rs.getString("categoryId"));
				 
		     }
		     else
		     {
		    	 new_category = null;
		     }
			
		     return new_category;
		}
	 
	 
	 public ArrayList<Manage_Category> Allcategories() throws SQLException
	 {
		Connection conn = dbConnect();
 		
 		String sql = "select *from category order by categoryId";
 		
 		PreparedStatement ps = conn.prepareStatement(sql);
 		 		
 		ResultSet rs = ps.executeQuery();
 		
 		ArrayList<Manage_Category> allcategories = new ArrayList<Manage_Category>();
 		
 		while(rs.next())
 		{
 			Manage_Category new_cat = new Manage_Category();
 			new_cat.setCategoryId(rs.getInt("categoryId"));
 			new_cat.setCategoryName(rs.getString("categoryName"));
 			
 			
 			allcategories.add(new_cat);
 		}
 		
 		conn.close();
 		
 		return allcategories;
 }
}
	
