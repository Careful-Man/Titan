package hardware;

import java.util.ArrayList;
import java.util.List;

public class Printer extends Hardware{
	
	//fields
	private String printerType;
	private String ip;
	private String printerInterface = "";
	//printer list
	private static List<Hardware> printerList = new ArrayList<>();
	
	
	//constructor
	public Printer(
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
			
			String printerType,
			String ip,
			String printerInterface[]) {
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
		
		this.printerType = printerType;
		this.ip = ip;
		for(String s: printerInterface) {
			this.printerInterface += s + " ";
		}
		
		
		
		if(this instanceof Printer)
			printerList.add(this);
			
		
		
	}
	
	
	
	
	
	
	//id auto increment
	public static String getNextId() {
		return Aid.TheFrame.getNextId(printerList);
	}
}
