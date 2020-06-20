package Aid;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class Main {
	
	public static final String SERVERIP = "localhost";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "";
	public static final String URL = "jdbc:mysql://" + SERVERIP + ":3306/saturn";
	
	public static boolean connectionEstablished;
	
	public static void main(String[] args) {
		
		
		//db connection attempt
		try {
			
			connectionEstablished = true;
			Class.forName("com.mysql.jdbc.Driver");
			


			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			Statement statement = connection.createStatement();
			
			
			
			//initialising ArrayLists
			
			//hardware.Computer.getListItems(statement);
			hardware.CashDrawer.getListItems(statement);
			/*statement.execute("create table CashDrawer("
					+ "id char(30), "
					+ "store char(30), "
					+ "brand char(30), "
					+ "model char(30), "
					+ "serialNumber char(40), "
					+ "supplier char(30), "
					+ "purchaseDay integer, "
					+ "purchaseMonth integer, "
					+ "purchaseYear integer, "
					+ "guarantee integer, "
					+ "keepdate char(30), "
					+ "user char(30), "
					+ "active char(30), "
					+ "comment text(500), "
					+ "cashDesk char(30))");*/
			
			
			
			
			
			statement.close();
			connection.close();
			
			new welcomingFrames.WelcomeFrame(connectionEstablished, new Exception());
		
			
			
			
		} catch(Exception e) {
			connectionEstablished = false;
			new welcomingFrames.WelcomeFrame(connectionEstablished, e);
			
		}
		
		
		
		
		
		//1st app window
		

	}

}
