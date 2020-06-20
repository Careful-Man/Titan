package hardware;

import java.util.ArrayList;
import java.util.List;

public class Switch extends Hardware{
	
	//fields
	
	//thermal printer list
	private static List<Hardware> switchList = new ArrayList<>();
	
	
	
	//constructor
	public Switch(
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
			
			String comment) {
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
		
		
		
		
		if(this instanceof Switch)
			switchList.add(this);
			
		
		
	}
	
	
	//id auto increment
	public static String getNextId() {
		return Aid.TheFrame.getNextId(switchList);
	}
}
