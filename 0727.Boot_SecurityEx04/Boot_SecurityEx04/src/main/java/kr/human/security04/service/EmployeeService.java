package kr.human.security04.service;

import java.util.List;

import kr.human.security04.vo.EmployeeVO;

public interface EmployeeService {
	void insertEmployee(EmployeeVO emp);
	void insertEmployees(List<EmployeeVO> employees);
	List<EmployeeVO> getAllEmployees();
	void getEmployeeById(String empid);
}