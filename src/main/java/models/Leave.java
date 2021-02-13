package models;

public class Leave {

	public int leaveId;
	public String employeeId;
	public String leaveType;
	public int daysRequested;
	public String startDate;
	public String endDate;
	public String address;
	public String dateOfApplication;
	public String status;
	public String dateOfApproval;
	public String approverId;
	
	public Leave() {
		
	}



	public Leave(String employeeId, String leaveType, int daysRequested,String startDate,String endDate, String address, String dateOfApplication,
			String status) {
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
	
	

	public Leave(int leaveId, String employeeId, String leaveType, int daysRequested,String startDate,String endDate, String address,
			String dateOfApplication, String status) {
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



	public Leave(int leaveId, String employeeId, String leaveType, int daysRequested,String startDate,String endDate, String address,
			String dateOfApplication, String status, String dateOfApproval) {
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
	}



	


	public Leave(int leaveId, String status, String dateOfApproval) {
		super();
		this.leaveId = leaveId;
		this.status = status;
		this.dateOfApproval = dateOfApproval;
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



	@Override
	public String toString() {
		return "Leave [leaveId=" + leaveId + ", employeeId=" + employeeId + ", leaveType=" + leaveType
				+ ", daysRequested=" + daysRequested + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", address=" + address + ", dateOfApplication=" + dateOfApplication + ", status=" + status
				+ ", dateOfApproval=" + dateOfApproval + ", approverId=" + approverId + "]";
	}




	
}

