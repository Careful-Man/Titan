package store;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Store {
	
	//fields
	private String id;
	private String name;
	private String address;
	private String region;
	
	private String telephone;
	private String email;
	
	private int openingDay;
	private int openingMonth;
	private int openingYear;
	
	private String comment;
	//store list
	private static List<Store> storeList = new ArrayList<>();
	
	
	//constructor 
	public Store(
			String id, 
			String name, 
			String address, 
			String region, 
			
			String telephone,
			String email,
			
			int openingDay,
			int openingMonth,
			int openingYear,
			boolean keepDate,
			
			String comment) {

		this.id = id;
		this.name = name;
		this.address = address;
		this.region = region;
		
		this.telephone = telephone;
		this.email = email;
		
		if(keepDate) {
			this.openingDay = openingDay;
			this.openingMonth = openingMonth;
			this.openingYear = openingYear;
		}
		
		this.comment = comment;
		
		storeList.add(this);
	}
	
	
	
	
	
	
	
	public static String[] getExistingStores() {
		String[] existingStores = new String[storeList.size()];
		
		for(int i=0; i<storeList.size(); i++) {
			existingStores[i] = storeList.get(i).id + " - " + storeList.get(i).name;
		}
		
		Arrays.sort(existingStores);
		
		return existingStores;
	}
	
	//id auto increment
		public static String getNextId() {
			if(storeList.isEmpty()) 
				return "001";
			else {
				Store e = storeList.get(storeList.size() - 1);
				int returnedId = Integer.parseInt(e.id.substring(e.id.length() - 3, e.id.length())) + 1;
				if(returnedId % 10 == returnedId)	
					return "00" + returnedId;
				else if(returnedId % 100 == returnedId)
					return "0" + returnedId;
				return "" + returnedId;
			}
		}
	
	

}
