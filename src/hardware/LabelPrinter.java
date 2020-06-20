package hardware;

import java.util.ArrayList;
import java.util.List;

public class LabelPrinter extends Hardware{
	
	//fields
	//label printer list
	private static List<Hardware> labelPrinterList = new ArrayList<>();
	
	
	//constructor
	public LabelPrinter(
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
		
		
		if(this instanceof LabelPrinter)
			labelPrinterList.add(this);
			
		
		
	}

	
	//id auto increment
	public static String getNextId() {
		return Aid.TheFrame.getNextId(labelPrinterList);
	}
}
