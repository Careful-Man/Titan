package store;

public class StoreRecord {
	
	//fields
	private String name;
	private int id;
	private int telephone;
	private String address;
	private String region;
	
	private String comment;
	
	
	//constructor no1
	//requires all fields
	public StoreRecord(String name, int id, int telephone, String address, String region, String comment) {
		this.name = name;
		this.id = id;
		this.telephone = telephone;
		this.address = address;
		this.region = region;
		this.comment = comment;
	}
	
	

}
