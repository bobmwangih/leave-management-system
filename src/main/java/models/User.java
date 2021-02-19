package models;

public class User {

	private String employeeId;
	private String firstName;
	private String lastName;

	public User() {

	}

	public User(String employeeId, String firstName, String lastName) {

		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public User(String employeeId) {
		super();
		this.employeeId = employeeId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeID(String employeeId) {
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

}
