package dao;

import java.util.List;

import models.Leave;

public interface LeaveDao {

	public void saveLeave(Leave leave);
	public List<Leave> getAllPendingLeaves(String status);
	public Leave getLeaveById(int leaveId);
	public void updateLeave(Leave leave);
	public void updateEditedLeave(Leave leave);
	public List<Leave> getLeaveByEmployeeIdForEditing(String employeeId,String status);
	public void delete(int leaveId);
	public List<Leave> getLeaveAndReview(String employeeId);
	public List<Leave> AllLeavesWithReview();
	public Leave getLeaveByIdWithReview(int leaveId); 
	public List<Leave> leavezWithReview();
}
