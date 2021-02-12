package models;

public class Employee extends User {

	private String email;
	//private String jobTitle;
	//private String station;
	private String dateOfJoiningService;
	private int leaveBalance;
	//private String department;
	
	public Employee(String employeeId, String firstName, String lastName,String email,String dateOfJoiningService, int leaveBalance) {
		super(employeeId,firstName,lastName);
		this.email = email;
		this.dateOfJoiningService = dateOfJoiningService;
		this.leaveBalance = leaveBalance;
	}
	


	public Employee(String employeeId, int leaveBalance) {
		super(employeeId);
		this.leaveBalance = leaveBalance;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public String getDateOfJoiningService() {
		return dateOfJoiningService;
	}

	public void setDateOfJoiningService(String dateOfJoiningService) {
		this.dateOfJoiningService = dateOfJoiningService;
	}



	public int getLeaveBalance() {
		return leaveBalance;
	}



	public void setLeaveBalance(int leaveBalance) {
		this.leaveBalance = leaveBalance;
	}


	
}
