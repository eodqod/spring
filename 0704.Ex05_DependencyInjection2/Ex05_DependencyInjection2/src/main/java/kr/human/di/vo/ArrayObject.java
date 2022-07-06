package kr.human.di.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ArrayObject {
	// 배열은 어떻게 주입을 할까?
	private int [] ids;
	private String [] names;
}
