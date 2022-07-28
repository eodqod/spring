package kr.top2blue.security.service;

import java.util.List;
import kr.top2blue.security.vo.Employee;

public interface EmployeeService {
	void insertEmployee(Employee emp);
	void insertEmployees(List<Employee> employees);
	List<Employee> getAllEmployees();
	void getEmployeeById(String empid);
}