package models;

public class ignore {
	
	public String employeeId;
	public String firstName;
	public String lastName;
	public String email;
	public String jobTitle;
	public String station;
	public String dateOfJoiningService;
	public int leaveBalance;
	public String department;
	
	public ignore(String employeeId, String firstName, String lastName, String email, String jobTitle, String station,
			String dateOfJoiningService, int leaveBalance, String department) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.jobTitle = jobTitle;
		this.station = station;
		this.dateOfJoiningService = dateOfJoiningService;
		this.leaveBalance = leaveBalance;
		this.department = department;
	}

	
	


	public ignore(String employeeId, int leaveBalance) {
		super();
		this.employeeId = employeeId;
		this.leaveBalance = leaveBalance;
	}





	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}


	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", jobTitle=" + jobTitle + ", station=" + station + ", dateOfJoiningService="
				+ dateOfJoiningService + ", leaveBalance=" + leaveBalance + ", department=" + department + "]";
	}
	
	
	
}
