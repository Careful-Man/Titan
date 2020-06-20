package hardware;

import java.util.ArrayList;
import java.util.List;

public class HandheldScanner extends Hardware{
	
	//fields
	private String ip;
	private String ram;
	private String storageSpace;
	//handheld scanner list
	private static List<Hardware> handheldScannerList = new ArrayList<>();
	
	
	//constructor
	public HandheldScanner(
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
			
			String ip,
			String ram,
			String storageSpace) {

		//sent to superclass constructor
		super(
				id, 
				brand, 
				model, 
				serialNumber,
				store,
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
		this.ram = ram;
		this.storageSpace = storageSpace;
		
		
		
		if(this instanceof HandheldScanner)
			handheldScannerList.add(this);	
		
		
		
	}
	
	
	//id auto increment
	public static String getNextId() {
		return Aid.TheFrame.getNextId(handheldScannerList);
	}
	
	
}
