package kr.human.security04.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import kr.human.security04.vo.EmployeeVO;

@Repository("employeeDao")
public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDao {

	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	@Override
	public void insertEmployee(EmployeeVO emp) {
		String sql = "INSERT INTO employee (empId, empName) VALUES (?, ?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				emp.getEmpId(), emp.getEmpName()
		});
	}
	
	@Override
	public void insertEmployees(final List<EmployeeVO> employees) {
		String sql = "INSERT INTO employee (empId, empName) VALUES (?, ?)";
		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				EmployeeVO employee = employees.get(i);
				ps.setString(1, employee.getEmpId());
				ps.setString(2, employee.getEmpName());
			}
			public int getBatchSize() {
				return employees.size();
			}
		});

	}
	@Override
	public List<EmployeeVO> getAllEmployees(){
		String sql = "SELECT * FROM employee";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<EmployeeVO> result = new ArrayList<EmployeeVO>();
		for(Map<String, Object> row:rows){
			EmployeeVO emp = new EmployeeVO();
			emp.setEmpId((String)row.get("empId"));
			emp.setEmpName((String)row.get("empName"));
			result.add(emp);
		}
		
		return result;
	}

	@SuppressWarnings("deprecation")
	@Override
	public EmployeeVO getEmployeeById(String empId) {
		String sql = "SELECT * FROM employee WHERE empId = ?";
		return (EmployeeVO)getJdbcTemplate().queryForObject(sql, new Object[]{empId}, new RowMapper<EmployeeVO>(){
			@Override
			public EmployeeVO mapRow(ResultSet rs, int rwNumber) throws SQLException {
				EmployeeVO emp = new EmployeeVO();
				emp.setEmpId(rs.getString("empId"));
				emp.setEmpName(rs.getString("empName"));
				return emp;
			}
		});
	}

}
