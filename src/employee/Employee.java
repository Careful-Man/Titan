package employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Employee {
	
	private static String id;
	private String firstName;
	private String lastName;
	
	private String telephone;
	private String email;
	
	private int birthdateDay;
	private int birthdateMonth;
	private int birthdateYear;
	
	private String department;
	
	private String comment;
	
	private static List<Employee> employeesList = new ArrayList<>();
	
	
	public Employee(
			String id,
			String firstName,
			String lastName,
			
			String telephone,
			String email,
			
			int birthdateDay,
			int birthdateMonth,
			int birthdateYear,
			boolean keepDate,
			
			String department,
			
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
		
		this.department = department;
		
		this.comment = comment;
		
		employeesList.add(this);
		
	}
	
	
	
	public static String[] getExistingEmployees() {
		String[] existingEmployees = new String[employeesList.size()];
		
		for(int i=0; i<employeesList.size(); i++) {
			existingEmployees[i] = employeesList.get(i).lastName + " - " + employeesList.get(i).department;
		}
		
		Arrays.parallelSort(existingEmployees);
		
		return existingEmployees;
	}
	
	
	
	public static String getNextId() {
		if(employeesList.isEmpty()) 
			return "001";
		else {
			Employee e = employeesList.get(employeesList.size() - 1);
			int returnedId = Integer.parseInt(e.id.substring(e.id.length() - 3, e.id.length())) + 1;
			if(returnedId % 10 == returnedId)	
				return "00" + returnedId;
			else if(returnedId % 100 == returnedId)
				return "0" + returnedId;
			return "" + returnedId;
		}
	}
	

}
