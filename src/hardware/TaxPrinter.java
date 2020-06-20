package hardware;

import java.util.ArrayList;
import java.util.List;

public class TaxPrinter extends Hardware{
	
	//fields
	@SuppressWarnings("unused")
	private String registryNumber;
	
	//thermal printer list
	private static List<Hardware> thermalPrinterList = new ArrayList<>();
	
	
	
	//constructor
	public TaxPrinter(
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
			
			String registryNumber) {
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
		
		this.registryNumber = registryNumber;
		
		
		
		if(this instanceof TaxPrinter)
			thermalPrinterList.add(this);
			
		
		
	}
	
	
	//id auto increment
	public static String getNextId() {
		return Aid.TheFrame.getNextId(thermalPrinterList);
	}
}
