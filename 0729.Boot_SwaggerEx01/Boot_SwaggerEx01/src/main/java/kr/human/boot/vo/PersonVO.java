package kr.human.boot.vo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JacksonXmlRootElement
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonVO {
	@JacksonXmlProperty
	private String name;
	@JacksonXmlProperty
	private int age;
	@JacksonXmlProperty
	private boolean gender;

	@Override
	public String toString() {
		return name + "(" + age + "세, " + (gender ? "남":"여")+")";
	}

}
