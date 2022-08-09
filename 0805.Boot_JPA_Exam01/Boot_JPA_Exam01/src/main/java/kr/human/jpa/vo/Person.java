package kr.human.jpa.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idx;
	private String name;
	private int age;
	private boolean gender;
	private Date regDate;
	
	public Person(String name, int age, boolean gender, Date regDate) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.regDate = regDate;
	}
	
}