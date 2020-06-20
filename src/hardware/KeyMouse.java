package hardware;

import java.util.ArrayList;
import java.util.List;

public class KeyMouse extends Hardware{
	
	//fields
	
	//keyboard and mouse list
	private static List<Hardware> keyMouseList = new ArrayList<>();
	
	
	
	//constructor
	public KeyMouse(
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
		
		
		
		if(this instanceof KeyMouse)
			keyMouseList.add(this);
			
		
		
	}
	
	
	public static String getNextId() {
		return Aid.TheFrame.getNextId(keyMouseList);
	}
}
