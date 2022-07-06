package kr.human.di.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeVO {
	private String name;
	private String employeeID;
	private String department;
	private Address address;

	public void display() {
		System.out.println("Name: " + getName());
		System.out.println("Employee ID: " + getEmployeeID());
		System.out.println("Department: " + getDepartment());
		System.out.println("Address: " + getAddress().toString());
	}
}
