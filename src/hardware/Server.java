package hardware;

import java.util.ArrayList;
import java.util.List;

public class Server extends Hardware{
	
	//fields
	private String cpu;
	private String cpuFrequency;
	private String cpuBits;
	private String ram;
	private String storageType;
	private String storageSpace;
	private String os;
	private String osBits;
	private String osSN;
	private String netName;
	private String netSpeed;
	private String antivirus;
	//server list
	private static List<Hardware> serverList = new ArrayList<>();
	
	
	//constructor
	public Server(
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
			
			
			String cpu, 
			String cpuFrequency,
			String cpuBits, 
			String ram, 
			String storageType, 
			String storageSpace, 
			String os, 
			String osBits, 
			String osSN, 
			String netName, 
			String netSpeed, 
			String antivirus) {
		
		//sent to superclass constructor
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
		
		
		//this class' exclusive fields
		this.cpu = cpu;
		this.cpuFrequency = cpuFrequency;
		this.cpuBits = cpuBits;
		this.ram = ram;
		this.storageType = storageType;
		this.storageSpace = storageSpace;
		this.os = os;
		this.osBits = osBits;
		this.osSN = osSN;
		this.netName = netName;
		this.netSpeed = netSpeed;
		this.antivirus = antivirus;
		
		
		
		if(this instanceof Server)
			serverList.add(this);
		
		
		
	}
	
	
	
	
	
	
	
	
	
	public static String getNextId() {
		return Aid.TheFrame.getNextId(serverList);
	}
	
	
	
}
