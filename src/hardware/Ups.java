package hardware;

import java.util.ArrayList;
import java.util.List;

public class Ups extends Hardware{
	
	//fields
	private String capacity;
	private String connectionType;
	private String batteryType;
	private String numberOfBatteries;
	//ups list
	private static List<Hardware> upsList = new ArrayList<>();
	
	//constructor
	public Ups(
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
			
			String capacity,
			String connectionType,
			String batteryType,
			String numberOfBatteries) {
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
		
		this.capacity = capacity;
		this.connectionType = connectionType;
		this.batteryType = batteryType;
		this.numberOfBatteries = numberOfBatteries;
		
		
		
		if(this instanceof Ups)
			upsList.add(this);
			
		
		
	}
	
	
	
	
	
	//id auto increment
	public static String getNextId() {
		return Aid.TheFrame.getNextId(upsList);
	}
}
