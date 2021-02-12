package dao;

import java.util.List;

import models.Leave;

public interface LeaveDao {

	public void saveLeave(Leave leave);
	public List<Leave> getAllLeaves();
	public Leave getLeaveById(int leaveId);
	public void updateLeave(Leave leave);
	public void updateEditedLeave(Leave leave);
	public List<Leave> getLeaveByEmployeeId(String employeeId);
	public void delete(int leaveId);
}
