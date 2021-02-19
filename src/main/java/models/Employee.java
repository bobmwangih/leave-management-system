package models;

import java.util.List;

public class Employee extends User {

	private String email;
	private String dateOfJoiningService;
	private int leaveBalance;
	private List<Leave> leaves;

	public Employee(String employeeId) {
		super(employeeId);

	}

	public Employee() {

	}

	public Employee(String employeeId, String firstName, String lastName, String email, String dateOfJoiningService,
			int leaveBalance) {
		super(employeeId, firstName, lastName);
		this.email = email;
		this.dateOfJoiningService = dateOfJoiningService;
		this.leaveBalance = leaveBalance;
	}

	public Employee(String employeeId, String firstName, String lastName, String email, int leaveBalance) {
		super(employeeId, firstName, lastName);
		this.email = email;
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

	public List<Leave> getLeaves() {
		return leaves;
	}

	public void setLeaves(List<Leave> leaves) {
		this.leaves = leaves;
	}

	@Override
	public String toString() {
		return "Employee [email=" + email + ", dateOfJoiningService=" + dateOfJoiningService + ", leaveBalance="
				+ leaveBalance + ", leaves=" + leaves + "]";
	}

}
