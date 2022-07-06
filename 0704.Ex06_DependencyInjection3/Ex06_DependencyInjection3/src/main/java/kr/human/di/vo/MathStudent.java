package kr.human.di.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MathStudent {
	private int id;
	private MathCheat mathCheat;

	public void cheating() {
		System.out.println("학번 : " + id);
		mathCheat.mathCheating();
	}
}
