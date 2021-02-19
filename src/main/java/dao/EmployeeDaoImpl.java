package dao;

import org.apache.ibatis.session.SqlSession;

import models.Employee;
import utils.MyBatisConfig;

public class EmployeeDaoImpl implements EmployeeDao{

	public Employee getEmployee(String employeeId) {
		SqlSession session = MyBatisConfig.getSessionFactory().openSession();
		Employee employee =session.selectOne("employeeMapper.getEmployeeById", employeeId);
		session.commit();
		session.close();
		return employee;
	}

	public void updateEmployee(Employee employee) {
		SqlSession session = MyBatisConfig.getSessionFactory().openSession();
		session.update("employeeMapper.updateEmployee", employee);
		session.commit();
		session.close();
	}

	public Employee getEmployeeAndLeaves(String employeeId) {
		SqlSession session = MyBatisConfig.getSessionFactory().openSession();
		Employee employee =session.selectOne("employeeMapper.getEmployeeLeaves",employeeId);
		session.commit();
		session.close();
		return employee;
	}

}
