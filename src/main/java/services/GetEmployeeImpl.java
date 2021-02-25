package services;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import dao.TestUserDao;
import models.TestUser;


public class GetEmployeeImpl implements GetEmployee {
	
	@Autowired
	private TestUserDao testUserDao;
	
	public List<TestUser> getEmployee() {
		List<TestUser> testUsers = testUserDao.getTestUsers();
		System.out.println(testUsers);
		return testUsers;
	}



}
