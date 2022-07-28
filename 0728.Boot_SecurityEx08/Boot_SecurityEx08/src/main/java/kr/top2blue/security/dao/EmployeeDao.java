package kr.top2blue.security.dao;

import java.util.List;

import kr.top2blue.security.vo.Employee;

public interface EmployeeDao {
	void insertEmployee(Employee employee);
	void insertEmployees(List<Employee> employees);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(String empId);
}