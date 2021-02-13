package dao;

import org.apache.ibatis.session.SqlSession;

import models.Approver;
import utils.MyBatisConfig;

public class ApproverDaoImpl implements ApproverDao {

	public Approver getApproverAndReviews() {
		SqlSession session = MyBatisConfig.getSessionFactory().openSession();
		Approver approver =session.selectOne("approverMapper.getApprover");
		session.commit();
		session.close();
		return approver;
	}

}
