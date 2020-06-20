package hardware;

import java.util.ArrayList;
import java.util.List;

public class Scale extends Hardware{
	
	//fields
	private String connectionType;
	private String location;
	private String ip;
	//scale list
	private static List<Hardware> scaleList = new ArrayList<>();
	
	
	
	//constructor
	public Scale(
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
			
			String connectionType,
			String location,
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
		
		
		this.connectionType = connectionType;
		this.location = location;
		this.ip = ip;
		
		
		
		if(this instanceof Scale)
			scaleList.add(this);
			
		
		
	}
	
	
	
	
	//id auto increment
		public static String getNextId() {
			return Aid.TheFrame.getNextId(scaleList);
		}
}
