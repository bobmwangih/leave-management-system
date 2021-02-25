package models;

public class TestUser {


	private String employeeId;
	private String firstName;
	private String lastName;
	
	
	
	public TestUser() {
		
	}

	public TestUser(String firstName, String lastName, String employeeId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
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

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "TestUserDao [firstName=" + firstName + ", lastName=" + lastName + ", employeeId=" + employeeId + "]";
	}
	
	
}
