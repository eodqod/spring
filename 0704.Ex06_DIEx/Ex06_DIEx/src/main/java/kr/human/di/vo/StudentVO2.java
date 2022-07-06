package kr.human.di.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentVO2 {
	private int id;
	private MathCheat mathCheat;

	public void cheating() {
		System.out.println("My ID is: " + id);
		mathCheat.mathCheating();
	}
}
