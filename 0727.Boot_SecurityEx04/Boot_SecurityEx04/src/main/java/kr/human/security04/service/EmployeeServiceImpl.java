package kr.human.security04.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.human.security04.dao.EmployeeDao;
import kr.human.security04.vo.EmployeeVO;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	@Override
	public void insertEmployee(EmployeeVO employee) {
		employeeDao.insertEmployee(employee);
	}

	@Override
	public void insertEmployees(List<EmployeeVO> employees) {
		employeeDao.insertEmployees(employees);
	}

	public List<EmployeeVO> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	@Override
	public void getEmployeeById(String empId) {
		EmployeeVO employee = employeeDao.getEmployeeById(empId);
		System.out.println(employee);
	}

}