package hardware;

import java.util.ArrayList;
import java.util.List;

public class Monitor extends Hardware{
	
	//fields
	@SuppressWarnings("unused")
	private String location;
	//monitor list
	private static List<Hardware> monitorList = new ArrayList<>();
	
	
	
	
	//constructor
	public Monitor(
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
			
			String location) {
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
		this.location = location;

		
		if(this instanceof Monitor)
			monitorList.add(this);
			
		
		
	}
	
	
	//id auto increment
	public static String getNextId() {
		return Aid.TheFrame.getNextId(monitorList);
	}
}
