import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;




public class TransactionDAO
{
	private Statement stmt;
	private ResultSet rs;
	private Connection con;
	public TransactionDAO()
	{
		con = DbUtil.getConnection();	
	}
	
	public List<TransModel> getTransByUser(String user){
		List<TransModel> history = new ArrayList<TransModel>();
		Statement st;
		try {
			System.out.println("getTransByUser");
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from transaction where user='"+user+"'");
			while(rs.next()){
				TransModel hm = new TransModel();
				
				hm.setAmount(rs.getDouble("amount"));
				hm.setDescr(rs.getString("descr"));
				hm.setTransID(rs.getInt("transID"));
				hm.setType(rs.getString("type"));
				hm.setDate(rs.getString("date"));
				hm.setUser(rs.getString("user"));
				history.add(hm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return history;
	}
	
	public void addToHistory(TransModel hm) {
		try {
			stmt = con.createStatement();
			String query = "insert into transaction(descr,user,type,amount) values('"+hm.getDescr()+"' , '"+hm.getUser()+"' , '"+hm.getType()+"' , "+hm.getAmount()+")";
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getAmountInAccountByUser(String user) {
		String result = "";
		try {
			float credit = 0;
			float debit = 0;
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select sum(amount) as total from transaction where user='"+user+"' and type = 'CR'");
			if(rs.next()){
				if(rs.getString("total")!=null){
					credit = Float.parseFloat(rs.getString("total"));
				}
				
			}
			rs.close();
			rs = st.executeQuery("select sum(amount) as total from transaction where user='"+user+"' and type = 'DB'");
			if(rs.next()){
				if(rs.getString("total")!=null){
					debit = Float.parseFloat(rs.getString("total"));
				}
				
			}
			
			result = String.valueOf(debit - credit);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
