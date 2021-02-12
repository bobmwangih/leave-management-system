package dao;

import java.util.List;

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

	public List<Leave> getAllLeaves() {
		SqlSession session = MyBatisConfig.getSessionFactory().openSession();
		List<Leave> leaves= session.selectList("leaveMapper.getAllLeaves");
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
	
	public List<Leave> getLeaveByEmployeeId(String employeeId) {
		SqlSession session = MyBatisConfig.getSessionFactory().openSession();
		List<Leave> leaves = session.selectList("leaveMapper.getLeaveByEmployeeId", employeeId);
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
	
	

}
