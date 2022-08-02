package kr.manamana.select.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

import kr.manamana.select.vo.AreaVO;

public class ExamGugun {
	public static void main(String[] args) {
		Scanner sc = null;
		List<AreaVO> list = new ArrayList<AreaVO>();
		try {
			sc = new Scanner(new File("dong.txt"),"UTF-8");
			int count=0;
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				line = line.replaceAll("( )+", ",");
				line = line.replaceAll("\\t+", ",");
				String[] lines = line.split(",");
				if(lines[0].endsWith("00000") && lines.length>=4 && line.endsWith("존재")) {
					AreaVO vo = new AreaVO();
					vo.setId(lines[0].substring(0,5));
					if(lines.length==4) {
						vo.setName(lines[2]);
					}else{
						vo.setName(lines[2] + " " + lines[3]);
					}
					count++;
					System.out.println(count + " : " + vo.toString());
					list.add(vo);
				}
			}
			System.out.println(list.size() + "개");
			// 구가 있는 시는 버려보자!!!!
			List<AreaVO> list2 = new ArrayList<AreaVO>();
			for(int i=0;i<list.size();i++) {
				AreaVO vo = list.get(i);
				if(vo.getId().endsWith("1")) {
					System.out.println(list.get(i-1)); //
					list2.add(list.get(i-1));
				}
			}
			System.out.println(list2.size() + "개");
			for(AreaVO vo : list2) {
				System.out.println("삭제 :" + vo);
				list.remove(vo);
			}
			System.out.println(list.size() + "개");
			
			PrintWriter pw = new PrintWriter("202004Gugun.json");
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
