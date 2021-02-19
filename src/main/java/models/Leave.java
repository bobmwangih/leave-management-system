package models;

public class Leave {

	private int leaveId;
	private String employeeId;
	private String leaveType;
	private int daysRequested;
	private String startDate;
	private String endDate;
	private String address;
	private String dateOfApplication;
	private String status;
	private String dateOfApproval;
	private String approverId;
	private Review review;
	private Employee employee;
	private Approver approver;

	public Leave() {

	}

	public Leave(String employeeId, String leaveType, int daysRequested, String startDate, String endDate,
			String address, String dateOfApplication, String status) {
		super();
		this.employeeId = employeeId;
		this.leaveType = leaveType;
		this.daysRequested = daysRequested;
		this.startDate = startDate;
		this.endDate = endDate;
		this.address = address;
		this.dateOfApplication = dateOfApplication;
		this.status = status;
	}

	public Leave(int leaveId, String employeeId, String leaveType, int daysRequested, String startDate, String endDate,
			String address, String dateOfApplication, String status) {
		super();
		this.leaveId = leaveId;
		this.employeeId = employeeId;
		this.leaveType = leaveType;
		this.daysRequested = daysRequested;
		this.startDate = startDate;
		this.endDate = endDate;
		this.address = address;
		this.dateOfApplication = dateOfApplication;
		this.status = status;
	}

	public Leave(int leaveId, String employeeId, String leaveType, int daysRequested, String startDate, String endDate,
			String address, String dateOfApplication, String status, String dateOfApproval, String approverId) {
		super();
		this.leaveId = leaveId;
		this.employeeId = employeeId;
		this.leaveType = leaveType;
		this.daysRequested = daysRequested;
		this.startDate = startDate;
		this.endDate = endDate;
		this.address = address;
		this.dateOfApplication = dateOfApplication;
		this.status = status;
		this.dateOfApproval = dateOfApproval;
		this.approverId = approverId;
	}

	public Leave(int leaveId, String status, String dateOfApproval, String approverId) {
		super();
		this.leaveId = leaveId;
		this.status = status;
		this.dateOfApproval = dateOfApproval;
		this.approverId = approverId;
	}

	public int getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public int getDaysRequested() {
		return daysRequested;
	}

	public void setDaysRequested(int daysRequested) {
		this.daysRequested = daysRequested;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDateOfApplication() {
		return dateOfApplication;
	}

	public void setDateOfApplication(String dateOfApplication) {
		this.dateOfApplication = dateOfApplication;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDateOfApproval() {
		return dateOfApproval;
	}

	public void setDateOfApproval(String dateOfApproval) {
		this.dateOfApproval = dateOfApproval;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getApproverId() {
		return approverId;
	}

	public void setApproverId(String approverId) {
		this.approverId = approverId;
	}

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Approver getApprover() {
		return approver;
	}

	public void setApprover(Approver approver) {
		this.approver = approver;
	}

	@Override
	public String toString() {
		return "Leave [leaveId=" + leaveId + ", employeeId=" + employeeId + ", leaveType=" + leaveType
				+ ", daysRequested=" + daysRequested + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", address=" + address + ", dateOfApplication=" + dateOfApplication + ", status=" + status
				+ ", dateOfApproval=" + dateOfApproval + ", approverId=" + approverId + ", review=" + getReview()
				+ ", employee=" + getEmployee() + ", approver=" + getApprover() + "]";
	}

}
