package dao;

import java.util.List;

import javax.jws.WebService;

import models.TestUser;

@WebService
public interface TestUserDao {

	public List <TestUser> getTestUsers();
}
