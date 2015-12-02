import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class UserDAO
{
	private Statement stmt;
	private ResultSet rs;
	private Connection con;
	//connection
	public UserDAO()
	{
		con = DbUtil.getConnection();
		
	}
	
	public boolean CheckUser(UserModel um){
		boolean flag =false;
		try {
			stmt = con.createStatement();
			 rs=stmt.executeQuery("select * from user where user ='"+um.getUser()+"' and pass ='"+um.getPass()+"'"); 
			if(rs.next())
			{
				flag =true;
				um.setUser(rs.getString("user"));
				
				
			}
			else System.out.println("failed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}
	
	public boolean AddUser(UserModel um)
	{
		boolean flag =false;
		String user,fname,email,pass;
		user=um.getUser();
		fname=um.getFname();
		email=um.getEmail();
		pass=um.getPass();
	String Query="insert into user(user,fname,email,pass) values('"+user+"','"+fname+"','"+email+"','"+pass+"') ";
	try {
		
		stmt=con.createStatement();
		stmt.executeUpdate(Query);
		System.out.println(user+" "+fname+" "+email+" "+pass);
		System.out.println("Query exe insert");
		flag =true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return flag;
	}
}
