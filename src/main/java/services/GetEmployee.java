package services;

import java.util.List;

import javax.jws.WebService;

import models.TestUser;


public interface GetEmployee {

	public List<TestUser> getEmployee();
}


