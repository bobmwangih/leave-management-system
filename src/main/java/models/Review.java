package models;

public class Review {

	public int reviewId;
	public int leaveId;
	public String reviewType;
	public String remarks;
	public String dateOfApproval;

	public Review() {

	}

	public Review(int reviewId, int leaveId, String reviewType, String remarks, String dateOfApproval) {
		this.reviewId = reviewId;
		this.leaveId = leaveId;
		this.reviewType = reviewType;
		this.remarks = remarks;
		this.dateOfApproval = dateOfApproval;
	}

	public Review(int leaveId, String reviewType, String remarks, String dateOfApproval) {
		super();
		this.leaveId = leaveId;
		this.reviewType = reviewType;
		this.remarks = remarks;
		this.dateOfApproval = dateOfApproval;
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

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", leaveId=" + leaveId + ", reviewType=" + reviewType + ", remarks="
				+ remarks + ", dateOfApproval=" + dateOfApproval + "]";
	}

}
