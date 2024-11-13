package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Add_Category 
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
	
	public int addcategory() throws SQLException
	   {
		    Connection conn = dbConnect();
	 		
	 		//3. SQL Query (Insert, Update, Delete, Read)
	 		String sql = "Insert into category(categoryName) values(?)";
	 		
	 		//4. Statement & Execute
	 		PreparedStatement ps = conn.prepareStatement(sql);
	 		ps.setString(1, categoryName);
	 		
	 		int response = ps.executeUpdate();
	 		
	 		//5. close connection
	 		conn.close();
	 		
	 		return response;
		}
	
	public ArrayList<Add_Category> getAllcategories() throws SQLException
	 {
		Connection conn = dbConnect();
		
		String sql = "select *from category order by categoryId";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		 		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Add_Category> allcategories = new ArrayList<Add_Category>();
		
		while(rs.next())
		{
			Add_Category new_cat = new Add_Category();
			new_cat.setCategoryId(rs.getInt("categoryId"));
			new_cat.setCategoryName(rs.getString("categoryName"));
			
			
			allcategories.add(new_cat);
		}
		
		conn.close();
		
		return allcategories;
}

	 
	   
}


