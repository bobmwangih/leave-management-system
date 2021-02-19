package dao;

import org.apache.ibatis.session.SqlSession;

import models.Leave;
import utils.MyBatisConfig;

public class ReportsDaoImpl implements ReportsDao {

////getting one Leave,Review and Employee
	public Leave leaveWithReviewAndItsActors(int leaveId) {
		SqlSession session = MyBatisConfig.getSessionFactory().openSession();
		Leave leave = session.selectOne("leaveMapper.leaveWithReviewAndItsActors", leaveId);
		session.commit();
		session.close();
		return leave;
	}
	
}
