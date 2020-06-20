package technician;

import java.util.ArrayList;
import java.util.List;

public class Technician {
	
	private String id;
	private String firstName;
	private String lastName;
	
	private String telephone;
	private String email;
	
	private int birthdateDay;
	private int birthdateMonth;
	private int birthdateYear;
	
	private String comment;
	
	private List<Technician> techniciansList = new ArrayList<>();
	
	
	public Technician(
			String id,
			String firstName,
			String lastName,
			
			String telephone,
			String email,
			
			int birthdateDay,
			int birthdateMonth,
			int birthdateYear,
			boolean keepDate,
			
			String comment
			) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		
		this.telephone = telephone;
		this.email = email;
		
		if(keepDate) {
			this.birthdateDay = birthdateDay;
			this.birthdateMonth = birthdateMonth;
			this.birthdateYear = birthdateYear;
		}
		
		this.comment = comment;
		
		techniciansList.add(this);
		
	}
	

}
