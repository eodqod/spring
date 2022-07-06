package kr.human.di.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
	private String name;
	private String employeeID;
	private String department;

	// Method
	public String getName() {
		return name;
	}

	// Method
	// Overriding toString() method of String class
	@Override
	public String toString() {
		return ("[Name: " + name + ", Employee Id: " + employeeID + ", Department: " + department + "]");
	}

}
