package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Add_Items 
{
	private int itemId;
	private int categoryId;
	private String itemName;
	private double price;
	private String description;
	private String image;
	
	public double getPrice() 
	{
		return price;
	}
	public void setPrice(double price) 
	{
		this.price = price;
	}
	public String getDescription() 
	{
		return description;
	}
	public void setDescription(String description) 
	{
		this.description = description;
	}
	public String getImage() 
	{
		return image;
	}
	public void setImage(String image) 
	{
		this.image = image;
	}
	public int getItemId()
	{
		return itemId;
	}
	public void setItemId(int itemId) 
	{
		this.itemId = itemId;
	}
	public int getCategoryId() 
	{
		return categoryId;
	}
	public void setCategoryId(int categoryId)
	{
		this.categoryId = categoryId;
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
	
	 public int additems() throws SQLException
	   {
		    Connection conn = dbConnect();
	 		
	 		//3. SQL Query (Insert, Update, Delete, Read)
	 		String sql = "Insert into items(categoryId, itemName, price, description, image) values(?, ?, ?, ?, ?)";
	 		
	 		//4. Statement & Execute
	 		PreparedStatement ps = conn.prepareStatement(sql);
	 		ps.setInt(1, categoryId);
	 		ps.setString(2, itemName);
	 		ps.setDouble(3, price);
	 		ps.setString(4, description);
	 		ps.setString(5, image);
	 		
	 		int response = ps.executeUpdate();
	 		
	 		//5. close connection
	 		conn.close();
	 		
	 		return response;
		}
	 
	 public ArrayList<Add_Items> getAllitems() throws SQLException
	 {
		Connection conn = dbConnect();
 		
 		String sql = "select *from items";
 		
 		PreparedStatement ps = conn.prepareStatement(sql);
 		 		
 		ResultSet rs = ps.executeQuery();
 		
 		ArrayList<Add_Items> allitems = new ArrayList<Add_Items>();
 		
 		while(rs.next())
 		{
 			Add_Items ab = new Add_Items();
 			ab.setCategoryId(rs.getInt("categoryId"));
 			ab.setItemId(rs.getInt("itemId"));
 			ab.setItemName(rs.getString("itemName"));
 			ab.setPrice(rs.getDouble("price"));
 			ab.setDescription(rs.getString("description"));
 			ab.setImage(rs.getString("image"));
 			
 			
 			allitems.add(ab);
 		}
 		
 		conn.close();
 		
 		return allitems;
 }
	 
	 public ArrayList<Add_Items> itembyid() throws SQLException
	 {
		Connection conn = dbConnect();
 		
 		String sql = "select *from items where categoryId=?";
 		
 		PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setInt(1, categoryId);
	    
	    ResultSet rs = ps.executeQuery();
 		
 		ArrayList<Add_Items> view_items = new ArrayList<Add_Items>();
 		
 		while(rs.next())
 		{
 			Add_Items add = new Add_Items();
 			add.setCategoryId(rs.getInt("categoryId"));
 			add.setItemId(rs.getInt("itemId"));
 			add.setItemName(rs.getString("itemName"));
 			add.setPrice(rs.getDouble("price"));
 			add.setDescription(rs.getString("description"));
 			add.setImage(rs.getString("image"));
 
 			
 			view_items.add(add);
 		}
 		
 		conn.close();
 		
 		return view_items;
 }
		 
	
}
