package hardware;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Computer extends Hardware {
	
	//fields
	private String cpu;
	private String cpuFrequency;
	private String cpuBits;
	private String ram;
	private String storageType;
	private String storageSpace;
	private String ipAddress;
	private String os;
	private String osBits;
	private String osSN;
	private String office;
	private String officeSN;
	private String licenses;
	private String netName;
	private String netSpeed;
	private String antivirus;
	private int winUpdateMonth;
	private int winUpdateYear;
	
	//computer list 
	private static List<Hardware> computerList = new ArrayList<>();
	
	
	//constructor
	
	public Computer(
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
			
			
			String cpu, 
			String cpuFrequency,
			String cpuBits, 
			String ram, 
			String storageType, 
			String storageSpace, 
			String ipAddress,
			String os, 
			String osBits, 
			String osSN, 
			String office,
			String officeSN, 
			String lisences,
			String netName, 
			String netSpeed, 
			String antivirus,
			int winUpdateMonth,
			int winUpdateYear,
			
			boolean insert) {
		
		//sent to superclass constructor
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
		
		
		//this class' exclusive fields
		this.cpu = cpu;
		this.cpuFrequency = cpuFrequency;
		this.cpuBits = cpuBits;
		this.ram = ram;
		this.storageType = storageType;
		this.storageSpace = storageSpace;
		this.ipAddress = ipAddress;
		this.os = os;
		this.osBits = osBits;
		this.osSN = osSN;
		this.office = office;
		this.officeSN = officeSN;
		this.licenses = lisences;
		
		this.netName = netName;
		this.netSpeed = netSpeed;
		this.antivirus = antivirus;
		this.winUpdateMonth = winUpdateMonth;
		this.winUpdateYear = winUpdateYear;
		
		
		
		
		
		
		if(this instanceof Computer && insert) {
			computerList.add(this);
			
		}
		
		
		
	}
	
	
	
	//id auto increment
	public static String getNextId() {
		return Aid.TheFrame.getNextId(computerList);
	}



	
	
	
	
	//retrieve items from Saturn db
	public static void getListItems(Statement statement) throws SQLException {
		ResultSet rs = statement.executeQuery("select * from Computer");
		
		while(rs.next()) {
			new Computer(
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
					
					
					
					rs.getString(15),//cpu
					rs.getString(16),
					rs.getString(17),
					rs.getString(18),
					rs.getString(19),
					rs.getString(20),
					rs.getString(21),
					rs.getString(22),
					rs.getString(23),
					rs.getString(24),
					rs.getString(25),
					rs.getString(26),
					rs.getString(27),
					rs.getString(28),
					rs.getString(29),
					rs.getString(30),
					Integer.parseInt(rs.getString(31)),
					Integer.parseInt(rs.getString(32)),
					
					
					
					false);
		}
		
	}
	
	
}
