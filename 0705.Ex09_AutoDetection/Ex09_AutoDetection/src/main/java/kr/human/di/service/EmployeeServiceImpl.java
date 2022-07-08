package kr.human.di.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.human.di.dao.EmployeeDao;
import kr.human.di.vo.Employee;
import lombok.extern.slf4j.Slf4j;

@Service("employeeService")
@Slf4j
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
    private DateService dateService;
	
	@Autowired
	private EmployeeDao employeeDao;
	
	
	@Override
	public void registerEmployee(Employee employee) {
		log.info("{} registerEmployee() 호출", this.getClass().getCanonicalName());
		employee.setAssessmentDate(dateService.getNextAssessmentDate());
		employeeDao.saveInDatabase(employee);
	}

}
