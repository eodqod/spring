package kr.top2blue.maven;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompanyVO {
	private int idx;
	private String name;
	private String add1;
	private String add2;
	private int postcode;
	private String eco;
	private String roomtype;
	private String theme;
	private int areacode;
	private double coordX;
	private double coordY;
	private String col1;
	private int col2;
}
