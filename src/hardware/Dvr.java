package hardware;

import java.util.ArrayList;
import java.util.List;

public class Dvr extends Hardware{
	
	//fields
	private String numOfCams;
	private String resolution;
	//monitor list
	private static List<Hardware> dvrList = new ArrayList<>();
	
	
	
	
	//constructor
	public Dvr(
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
			
			String numOfCams,
			String resolution) {
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
		
		
		this.numOfCams = numOfCams;
		this.resolution = resolution;

		
		
		if(this instanceof Dvr)
			dvrList.add(this);
			
		
		
	}
	
	
	//id auto increment
	public static String getNextId() {
		return Aid.TheFrame.getNextId(dvrList);
	}
}
