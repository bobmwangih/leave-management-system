package dao;

import models.Employee;


public interface EmployeeDao {

	public Employee getEmployee(String employeeId);
	public void updateEmployee(Employee employee);
	public Employee getEmployeeAndLeaves(String employeeId);
}
   