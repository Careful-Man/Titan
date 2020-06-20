package hardware;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CashDrawer extends Hardware{
	
	//fields
	private String cashDesk;
	
	//thermal printer list
	private static List<Hardware> cashDrawerList = new ArrayList<>();
	
	
	
	//constructor
	@SuppressWarnings("static-access")
	public CashDrawer(
			String id,
			String store,
			String brand, 
			String model, 
			String serialNumber, 
			String supplier,
			
			int purchaseDay,
			int purchaseMonth,
			int purchaseYear,
			String guarantee,
			boolean keepDate,
			String user,
			boolean active,
			
			String comment,
			
			String cashDesk,
			boolean insert) throws SQLException {
		super(
				id,
				store,
				brand,
				model,
				serialNumber,
				supplier,
				
				purchaseDay,
				purchaseMonth,
				purchaseYear,
				guarantee,
				keepDate,
				user,
				active,
				
				comment);
		
		this.cashDesk = cashDesk;
		
		
		//Insert into arraylist and database
		if(this instanceof CashDrawer && insert) {
			//arraylist
			cashDrawerList.add(this);
			//database
			Statement statement = Aid.TheFrame.getStatement();
			statement.execute("insert into CashDrawer values "
					+ "('" + this.id + "'," 
					+ " '" + this.store + "',"
					+ " '" + this.brand + "',"
					+ " '" + this.model + "',"
					+ " '" + this.serialNumber + "',"
					+ " '" + this.supplier + "',"
					
					+ " '" + this.purchaseDay + "',"
					+ " '" + this.purchaseMonth + "',"
					+ " '" + this.purchaseYear + "',"
					+ " '" + this.guarantee + "',"
					+ " '" + keepDate + "',"
					+ " '" + this.user + "',"
					+ " '" + this.active + "',"
					
					+ " '" + this.comment + "',"
					
					+ " '" + this.cashDesk + "')");
		}else {
			//arraylist
			cashDrawerList.add(this);
		}
		
		
		
	}
	
	
	//id auto increment
	public static String getNextId() {
		return Aid.TheFrame.getNextId(cashDrawerList);
	}

	
	
	
	
	
	//retrieve items from Saturn db
	public static void getListItems(Statement statement) throws SQLException {
		
		ResultSet rs = statement.executeQuery("select * from cashdrawer");
		while(rs.next()) {
			new CashDrawer(
					rs.getString(1),//id
					rs.getString(2),//store
					rs.getString(3),//brand
					rs.getString(4),//model
					rs.getString(5),//sn
					rs.getString(6),//supplier
					
					Integer.parseInt(rs.getString(7)),//p day
					Integer.parseInt(rs.getString(8)),//p month
					Integer.parseInt(rs.getString(9)),//p year
					rs.getString(10),//guarantee
					Boolean.parseBoolean(rs.getString(11)),//keep date
					rs.getString(12),//user
					Boolean.parseBoolean(rs.getString(13)),//active
					
					rs.getString(14),//comment
					
					
					
					rs.getString(15),//cash desk
					
					false);
		}
		
		
	}
	
	
	
	
}
