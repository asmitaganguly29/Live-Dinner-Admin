package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Manage_Items
{
	private int itemId;
	private String itemName;
    private int categoryId;
    

	public int getCategoryId() 
	{
		return categoryId;
	}
	public void setCategoryId(int categoryId)
	{
		this.categoryId = categoryId;
	}
	
	public int getItemId() 
	{
		return itemId;
	}
	public void setItemId(int itemId) 
	{
		this.itemId = itemId;
	}
	public String getItemName() 
	{
		return itemName;
	}
	public void setItemName(String itemName) 
	{
		this.itemName = itemName;
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
	

	public int updateitem() throws SQLException
	   {
	   Connection conn = dbConnect();
		
		//3. SQL Query (Insert, Update, Delete, Read)
		String sql = "Update items set itemName=? where itemId=?";
		
		//4. Statement & Execute
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, itemName);
		ps.setInt(2, itemId);
		
		int response = ps.executeUpdate();
		
		//5. close connection
		conn.close();
		
		return response;
	}
	 
	 public int deleteitem() throws SQLException
	  {
    Connection conn = dbConnect();
		
		//3. SQL Query (Insert, Update, Delete, Read)
		String sql = "Delete from items where itemId=?";
		
		//4. Statement & Execute
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, itemId);
		
		int response = ps.executeUpdate();
		
		//5. close connection
		conn.close();
		
		return response;
	}
	 
	 public ArrayList<Manage_Items> Allitems() throws SQLException
	 {
		Connection conn = dbConnect();
 		
 		String sql = "select *from items order by itemId";
 		
 		PreparedStatement ps = conn.prepareStatement(sql);
 		 		
 		ResultSet rs = ps.executeQuery();
 		
 		ArrayList<Manage_Items> allitems = new ArrayList<Manage_Items>();
 		
 		while(rs.next())
 		{
 			Manage_Items new_item = new Manage_Items();
 			new_item.setItemId(rs.getInt("itemId"));
 			new_item.setItemName(rs.getString("itemName"));
 			
 			
 			allitems.add(new_item);
 		}
 		
 		conn.close();
 		
 		return allitems;
 }
	 
	 public ArrayList<Manage_Items> itemby_id() throws SQLException
	 {
		 System.out.println("cid = "+categoryId);
		 
		Connection conn = dbConnect();
 		
 		String sql = "select *from items where categoryId=?";
 		
 		PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setInt(1, categoryId);
	    
	    ResultSet rs = ps.executeQuery();
 		
 		ArrayList<Manage_Items> view_items = new ArrayList<Manage_Items>();
 		
 		while(rs.next())
 		{
 			Manage_Items mi = new Manage_Items();
 			mi.setCategoryId(rs.getInt("categoryId"));
 			mi.setItemId(rs.getInt("itemId"));
 			mi.setItemName(rs.getString("itemName"));
 			
 			view_items.add(mi);
 		}
 		
 		conn.close();
 		//System.out.println("items: "+view_items.size());
 		
 		return view_items;
 }
	 
	 public Manage_Items itembyid() throws SQLException
		{
	       Connection conn = dbConnect();
	       
	       String sql = "Select *from items where itemId=?";
			
		   PreparedStatement ps = conn.prepareStatement(sql);
		   ps.setInt(1, itemId);
			
	       ResultSet rs = ps.executeQuery();
	       
	       Manage_Items new_item = new Manage_Items();
		     
		     if(rs.next())
		     {
		    	
		    	 new_item.setItemId(rs.getInt("itemId"));
		    	 new_item.setItemName(rs.getString("itemName"));
				 
		     }
		     else
		     {
		    	 new_item = null;
		     }
			
		     return new_item;
		}


}
