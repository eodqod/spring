package kr.top2blue.maven;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex01 {
	public static void main(String[] args) {
		String str1 = "한놈,두식이,석삼,너구리,오징어";
		String ar[] = str1.split(",");
		System.out.println(ar.length + "개 : " + Arrays.toString(ar));
		StringTokenizer st = new StringTokenizer(str1, ",");
		System.out.println(st.countTokens() + "개");
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		System.out.println("-".repeat(40));
		
		String str2 = "한놈,두식이,,,석삼,너구리,오징어,,,";
		String ar2[] = str2.split(",");
		System.out.println(ar2.length + "개 : " + Arrays.toString(ar2));
		StringTokenizer st2 = new StringTokenizer(str2, ",");
		System.out.println(st2.countTokens() + "개");
		while (st2.hasMoreTokens()) {
			System.out.println(st2.nextToken());
		}
		System.out.println("-".repeat(40));

		String str3 = "한놈,두식이,,,석삼,너구리,오징어,,,";
		String ar3[] = str3.split(",", 10);
		System.out.println(ar3.length + "개 : " + Arrays.toString(ar3));
		StringTokenizer st3 = new StringTokenizer(str2, ",", true);
		System.out.println(st3.countTokens() + "개");
		while (st3.hasMoreTokens()) {
			System.out.println(st3.nextToken());
		}
	}
}
