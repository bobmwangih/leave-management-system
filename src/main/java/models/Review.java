package models;

public class Review {

	public int reviewId;
	public int leaveId;
	public String reviewType;
	public String remarks;
	public String dateOfApproval;
	public String employeeId;
	
	public Review(int leaveId, String reviewType, String remarks, String dateOfApproval, String employeeId) {
		super();
		this.leaveId = leaveId;
		this.reviewType = reviewType;
		this.remarks = remarks;
		this.dateOfApproval = dateOfApproval;
		this.employeeId = employeeId;
	}
	
	

	public Review(int reviewId, int leaveId, String reviewType, String remarks, String dateOfApproval,
			String employeeId) {
		super();
		this.reviewId = reviewId;
		this.leaveId = leaveId;
		this.reviewType = reviewType;
		this.remarks = remarks;
		this.dateOfApproval = dateOfApproval;
		this.employeeId = employeeId;
	}



	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}

	public String getReviewType() {
		return reviewType;
	}

	public void setReviewType(String reviewType) {
		this.reviewType = reviewType;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getDateOfApproval() {
		return dateOfApproval;
	}

	public void setDateOfApproval(String dateOfApproval) {
		this.dateOfApproval = dateOfApproval;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", leaveId=" + leaveId + ", reviewType=" + reviewType + ", remarks="
				+ remarks + ", dateOfApproval=" + dateOfApproval + ", employeeId=" + employeeId + "]";
	}
	
	
}
