package hardware;

import java.util.ArrayList;
import java.util.List;

public class Edps extends Hardware{
	
	//fields
	private String cashDesk;
	private String ip;
	
	//thermal printer list
	private static List<Hardware> edpsList = new ArrayList<>();
	
	
	
	//constructor
	public Edps(
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
		
		
		this.cashDesk = cashDesk;
		this.ip = ip;
		
		
		
		if(this instanceof Edps)
			edpsList.add(this);
			
		
		
	}
	
	
	//id auto increment
	public static String getNextId() {
		return Aid.TheFrame.getNextId(edpsList);
	}
}
