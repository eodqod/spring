package kr.manamana.select.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

import kr.manamana.select.vo.AreaVO;

public class ExamRi {
	public static void main(String[] args) {
		Scanner sc = null;
		List<AreaVO> list = new ArrayList<AreaVO>();
		try {
			sc = new Scanner(new File("dong.txt"), "UTF-8");
			int count = 0;
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				line = line.replaceAll("( )+", ",");
				line = line.replaceAll("\\t+", ",");
				String[] lines = line.split(",");
				if (!lines[0].endsWith("00") && line.endsWith("존재")) {
					AreaVO vo = new AreaVO();
					vo.setId(lines[0]);
					vo.setName(lines[lines.length-2]);
					count++;
					System.out.println(count + " : " + vo.toString());
					list.add(vo);
					
				}
			}
			System.out.println(list.size() + "개");
			PrintWriter pw = new PrintWriter("202004Ri.json");
			Gson gson = new Gson();
			gson.toJson(list,pw);
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}
}
