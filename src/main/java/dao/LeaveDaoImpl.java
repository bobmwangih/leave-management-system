package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import models.Leave;
import utils.MyBatisConfig;

public class LeaveDaoImpl implements LeaveDao {
	

	public void saveLeave(Leave leave) {
		SqlSession session = MyBatisConfig.getSessionFactory().openSession();
		session.insert("leaveMapper.insertLeave", leave);
		session.commit();
		session.close();
	}

	public List<Leave> getAllPendingLeaves(String status) {
		SqlSession session = MyBatisConfig.getSessionFactory().openSession();
		List<Leave> leaves= session.selectList("leaveMapper.getAllPendingLeaves",status);
		session.commit();
		session.close();
		return leaves;
	}

	public Leave getLeaveById(int leaveId) {
		SqlSession session = MyBatisConfig.getSessionFactory().openSession();
		Leave leave = session.selectOne("leaveMapper.getLeaveById", leaveId);
		session.commit();
		session.close();
		return leave;
	}
	
	public List<Leave> getLeaveByEmployeeIdForEditing(String employeeId,String status) {
		Map<String,String> details= new HashMap<String, String>();
		details.put("employeeId", employeeId);
		details.put("status", status);
		SqlSession session = MyBatisConfig.getSessionFactory().openSession();
		List<Leave> leaves = session.selectList("leaveMapper.getLeaveByEmployeeId", details);
		session.commit();
		session.close();
		return leaves;
	}

	public void updateLeave(Leave leave) {
		SqlSession session = MyBatisConfig.getSessionFactory().openSession();
		session.update("leaveMapper.updateLeave", leave);
		session.commit();
		session.close();
		
	}

	public void updateEditedLeave(Leave leave) {
		SqlSession session = MyBatisConfig.getSessionFactory().openSession();
		session.update("leaveMapper.updateEditedLeave", leave);
		session.commit();
		session.close();
		
		
	}

	public void delete(int leaveId) {
		SqlSession session = MyBatisConfig.getSessionFactory().openSession();
		session.delete("leaveMapper.delete", leaveId);
		session.commit();
		session.close();
		
	}

	public List<Leave> getLeaveAndReview(String employeeId) {
		SqlSession session = MyBatisConfig.getSessionFactory().openSession();
		List<Leave> leaves = session.selectList("leaveMapper.leaveWithReview", employeeId);
		session.commit();
		session.close();
		return leaves;
	}

	public Leave getOneLeaveAndReview(String employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Leave> AllLeavesWithReview() {
		SqlSession session = MyBatisConfig.getSessionFactory().openSession();
		List<Leave> leaves = session.selectList("leaveMapper.AllLeavesWithReview");
		session.commit();
		session.close();
		return leaves;
	}
	
	

}
