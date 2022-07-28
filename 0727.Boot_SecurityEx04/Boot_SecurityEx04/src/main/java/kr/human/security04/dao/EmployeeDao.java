package kr.human.security04.dao;

import java.util.List;
import kr.human.security04.vo.EmployeeVO;

public interface EmployeeDao {
	void insertEmployee(EmployeeVO cus);
	void insertEmployees(List<EmployeeVO> employees);
	List<EmployeeVO> getAllEmployees();
	EmployeeVO getEmployeeById(String empId);
}