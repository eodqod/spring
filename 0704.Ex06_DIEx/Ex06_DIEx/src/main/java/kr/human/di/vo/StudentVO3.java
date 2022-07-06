package kr.human.di.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentVO3 {
	private int id;
	private String studentName;

	public void displayInfo() {
		System.out.println("Student Name is " + studentName + " and Roll Number is " + id);
	}
}
