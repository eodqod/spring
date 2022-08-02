package kr.manamana.select.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import kr.manamana.select.vo.AreaVO;

public class ExamTotal {
	public static void main(String[] args) {
		Gson gson = new Gson();
		List<AreaVO> sidoList = null;
		List<AreaVO> gugunList = null;
		List<AreaVO> dongList = null;
		List<AreaVO> riList = null;
		List<AreaVO> totalList = new ArrayList<AreaVO>();
		
		FileReader fr = null;
		FileReader fr2 = null;
		FileReader fr3 = null;
		FileReader fr4 = null;
		try {
			fr = new FileReader("202004Sido.json");
			sidoList = gson.fromJson(fr, new TypeToken<List<AreaVO>>() {}.getType());
			System.out.println(sidoList.size() + "개");
			
			fr2 = new FileReader("202004Gugun.json");
			gugunList = gson.fromJson(fr2, new TypeToken<List<AreaVO>>() {}.getType());
			System.out.println(gugunList.size() + "개");
			
			fr3 = new FileReader("202004DongEupMyeon.json");
			dongList = gson.fromJson(fr3, new TypeToken<List<AreaVO>>() {}.getType());
			System.out.println(dongList.size() + "개");
			
			fr4 = new FileReader("202004Ri.json");
			riList = gson.fromJson(fr4, new TypeToken<List<AreaVO>>() {}.getType());
			System.out.println(riList.size() + "개");
			
			totalList.addAll(sidoList);
			totalList.addAll(gugunList);
			totalList.addAll(dongList);
			totalList.addAll(riList);
			
			totalList.sort(new Comparator<AreaVO>() {
				@Override
				public int compare(AreaVO o1, AreaVO o2) {
					return o1.getId().compareTo(o2.getId());
				}
			});
			System.out.println("전체 : " + totalList.size() + "개");
			
			PrintWriter pw = new PrintWriter("202004Total.json");
			gson.toJson(totalList,pw);
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
				fr2.close();
				fr3.close();
				fr4.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
