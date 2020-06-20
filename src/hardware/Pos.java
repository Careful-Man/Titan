package hardware;

import java.util.ArrayList;
import java.util.List;

public class Pos extends Hardware{
	
	//fields
	private String cashDesk;
	private String ip;
	private String ram;
	private String storageType;
	private String storageSpace;
	//pos list
	private static List<Hardware> posList = new ArrayList<>();
	
	
	//constructor
	public Pos(
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
			String ip,
			String ram,
			String storageType,
			String storageSpace) {
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
		this.ram = ram;
		this.storageType = storageType;
		this.storageSpace = storageSpace;
		
		
		
		if(this instanceof Pos)
			posList.add(this);
			
		
		
	}
	
	
	//id auto increment
	public static String getNextId() {
		return Aid.TheFrame.getNextId(posList);
	}
	
	
	
}
