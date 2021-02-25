package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import models.Leave;
import utils.MyBatisConfig;
 

public class LeaveDaoImpl implements LeaveDao{
	
	
//saving a new leave
	public void saveLeave(Leave leave) {
		SqlSession session = MyBatisConfig.getSessionFactory().openSession();
		session.insert("leaveMapper.insertLeave", leave);
		session.commit();
		session.close();
	}

//getting all leaves that haven't been approved
	public List<Leave> getAllPendingLeaves(String status) {
		SqlSession session = MyBatisConfig.getSessionFactory().openSession();
		List<Leave> leaves= session.selectList("leaveMapper.getAllPendingLeaves",status);
		session.commit();
		session.close();
		return leaves;
	}

//get one leave	by its id
	public Leave getLeaveById(int leaveId) {
		SqlSession session = MyBatisConfig.getSessionFactory().openSession();
		Leave leave = session.selectOne("leaveMapper.getLeaveById", leaveId);
		session.commit();
		session.close();
		return leave;
	}
	
//getting all leaves that have not been reviewed for a given employee -for editing/deleting
	public List<Leave> getLeaveByEmployeeIdForEditing(String employeeId,String status) {
		Map<String,String> queryDetails= new HashMap<String, String>();
		queryDetails.put("employeeId", employeeId);
		queryDetails.put("status", status);
		SqlSession session = MyBatisConfig.getSessionFactory().openSession();
		List<Leave> leaves = session.selectList("leaveMapper.getLeaveByEmployeeIdAndStatus", queryDetails);
		session.commit();
		session.close();
		return leaves;
	}

//save an existing leave to the database
	public void updateEditedLeave(Leave leave) {
		SqlSession session = MyBatisConfig.getSessionFactory().openSession();
		session.update("leaveMapper.updateEditedLeave", leave);
		session.commit();
		session.close();
		
		
	}

//deletes a leave with status-pending
	public void delete(int leaveId) {
		SqlSession session = MyBatisConfig.getSessionFactory().openSession();
		session.delete("leaveMapper.delete", leaveId);
		session.commit();
		session.close();
		
	}

//getting all leaves that have a status-approved/rejected for a specific employee
	public List<Leave> getLeaveAndReview(String employeeId) {
		SqlSession session = MyBatisConfig.getSessionFactory().openSession();
		List<Leave> leaves = session.selectList("leaveMapper.AllLeavesByEmployeeIdWithReview", employeeId);
		session.commit();
		session.close();
		return leaves;
	}
	
//getting one leave that has a status-approved/rejected--used to show the remarks
	public Leave getLeaveByIdWithReview(int leaveId) {
		SqlSession session = MyBatisConfig.getSessionFactory().openSession();
		Leave leave = session.selectOne("leaveMapper.oneLeaveByLeaveIdWithReview", leaveId);
		session.commit();
		session.close();
		return leave;
	}

//getting all leaves whose status:-approved/rejected with their reviews	
	public List<Leave> AllLeavesWithReview() {
		SqlSession session = MyBatisConfig.getSessionFactory().openSession();
		List<Leave> leaves = session.selectList("leaveMapper.AllLeavesWithReview");
		session.commit();
		session.close();
		return leaves;
	}

//update Leave after review has been inserted
	public void updateLeave(Leave leave) {
		SqlSession session = MyBatisConfig.getSessionFactory().openSession();
		session.update("leaveMapper.updateLeaveAfterReview", leave);
		session.commit();
		session.close();
	}

	

}
