package hardware;

import java.util.ArrayList;
import java.util.List;

public abstract class Hardware {
	
	//fields
	protected static String id;
	protected String store;
	protected String brand;
	protected String model;
	protected String serialNumber;
	protected String supplier;
	
	protected int purchaseDay;
	protected int purchaseMonth;
	protected int purchaseYear;
	protected int guarantee;
	protected String user;
	protected boolean active;
	
	protected String comment;
	
	protected List<Hardware> hardwareList = new ArrayList<>();
	
	
	
	//constructor 
	@SuppressWarnings("static-access")
	public Hardware(
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
		
		
		this.id = id;
		this.store = store;
		this.brand = brand;
		this.model = model;
		this.serialNumber = serialNumber;
		this.supplier = supplier;
		
		if(keepDate) {
			this.purchaseDay = purchaseDay;
			this.purchaseMonth = purchaseMonth;
			this.purchaseYear = purchaseYear;
			this.guarantee = Integer.parseInt(guarantee);
		}
		
		this.user = user;
		this.active = active;

		this.comment = comment;
			
		
		hardwareList.add(this);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//id getter
	@SuppressWarnings("static-access")
	public String getId() {
		return this.id;
	}
	
	
}
