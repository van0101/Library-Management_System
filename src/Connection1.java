import java.sql.*;
public class Connection1 
{
	static String name="root";
	static String pwd="sql";
	static String url="jdbc:mysql://localhost:3306/library";
	static Connection con=null;
	public static Connection getConnection()
	{
		if(con!=null)
		{
			return con;//ensures singleton connection
		}
		return getConnection(url,name,pwd);
	}
	private static Connection getConnection(String u,String n,String p)
	{
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(u,n,p);
		}
		catch(Exception e)
		{
			System.out.println("Driver not registered");
			e.printStackTrace();
		}
		
		return con;
		
	}
}
