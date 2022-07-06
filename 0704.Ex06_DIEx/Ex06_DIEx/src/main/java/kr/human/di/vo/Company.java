package kr.human.di.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Company {

	private String companyName;
	private List<Employee> employees;

	// method
	public String getCompanyName() {
		return companyName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	// Method
	public void display() {
		System.out.println("Company: " + companyName);
		System.out.println("Empoyees:");

		// Iterating over using for each loop
		for (Employee employee : employees) {
			System.out.println(employee.toString());
		}
	}
}
