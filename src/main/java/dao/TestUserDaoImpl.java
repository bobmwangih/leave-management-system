package dao;

import java.util.List;

import javax.jws.WebService;

import org.apache.ibatis.session.SqlSession;

import models.TestUser;
import utils.MyBatisConfig;

@WebService(endpointInterface="dao.TestUserDao")
public class TestUserDaoImpl implements TestUserDao {

	public List<TestUser> getTestUsers() {
		SqlSession session = MyBatisConfig.getSessionFactory().openSession();
		List <TestUser> testUsers = session.selectList("testUserMapper.getTestUsers");
		session.commit();
		session.close();
		return testUsers;
	}

}
