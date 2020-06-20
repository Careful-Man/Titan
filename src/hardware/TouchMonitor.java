package hardware;

import java.util.ArrayList;
import java.util.List;

public class TouchMonitor extends Hardware{
	
	//fields
	//touch monitor list
	private static List<Hardware> touchMonitorList = new ArrayList<>();
	
	
	
	//constructor
	public TouchMonitor(
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
		
		
		
		if(this instanceof TouchMonitor)
			touchMonitorList.add(this);
		
		
		
	}
	
	
	
	
	//id auto increment
	public static String getNextId() {
		return Aid.TheFrame.getNextId(touchMonitorList);
	}
}
