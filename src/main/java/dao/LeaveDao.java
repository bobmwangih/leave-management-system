package dao;

import java.util.List;

import models.Leave;


public interface LeaveDao {

//saving a new leave	
	public void saveLeave(Leave leave);

//getting all leaves that haven't been approved	
	public List<Leave> getAllPendingLeaves(String status);

//get one leave	by its id
	public Leave getLeaveById(int leaveId);

//save an existing leave to the database	
	public void updateEditedLeave(Leave leave);

//getting all leaves that have not been reviewed  -for editing/deleting	
	public List<Leave> getLeaveByEmployeeIdForEditing(String employeeId, String status);

//deletes a leave with status-pending	
	public void delete(int leaveId);

//getting all leaves that have a status-approved/rejected	
	public List<Leave> getLeaveAndReview(String employeeId);

//getting one leave that has a status-approved/rejected--used to show the remarks	
	public Leave getLeaveByIdWithReview(int leaveId);

//getting all leaves whose status:-approved/rejected with their reviews	 
	public List<Leave> AllLeavesWithReview();

// updating leave details after a review has been inserted
	public void updateLeave(Leave leave);
}
