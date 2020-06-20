package hardware;

import java.util.ArrayList;
import java.util.List;

public class Router extends Hardware{
	
	//fields
	@SuppressWarnings("unused")
	private String ip;
	
	//thermal printer list
	private static List<Hardware> routerList = new ArrayList<>();
	
	
	
	//constructor
	public Router(
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
			
			String ip) {
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
		
		this.ip = ip;
		
		
		
		
		if(this instanceof Router)
			routerList.add(this);
			
		
		
	}
	
	
	//id auto increment
	public static String getNextId() {
		return Aid.TheFrame.getNextId(routerList);
	}
}
