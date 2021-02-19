package dao;

import models.Leave;

public interface ReportsDao {

//getting one Leave,Review and Employee
	public Leave leaveWithReviewAndItsActors(int leaveId);
}
