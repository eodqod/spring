package kr.manamana.select.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import kr.manamana.select.vo.AreaVO;

public class Ex01 {
	public static void main(String[] args) {
		List<AreaVO> list = JsonUtil.readAear("area.json");
		Gson gson = new Gson();
		DefaultResourceLoader loader = new DefaultResourceLoader();
		try {
			Resource resource1 = loader.getResource("classpath:area.json");
			InputStreamReader isr = new InputStreamReader(resource1.getInputStream());
			list = gson.fromJson(isr, new TypeToken<List<AreaVO>>() {}.getType());
			
			Resource resource2 = loader.getResource("classpath:area.txt");
			Scanner sc = new Scanner(resource2.getInputStream(),"UTF-8");
			System.out.println(sc.nextLine());
			while(sc.hasNextLine()) {
				String[] lines = sc.nextLine().split(",");
				AreaVO vo = new AreaVO();
				vo.setId(lines[1]);
				vo.setName(lines[2]);
				list.add(vo);
			}
			sc.close();
			/*
			list2.sort(new Comparator<AreaVO>() {
				@Override
				public int compare(AreaVO o1, AreaVO o2) {
					return o1.getId().compareTo(o2.getId());
				}
			});
			*/
			System.out.println(list);
			System.out.println(list.size() + "개");
			
			PrintWriter pw = new PrintWriter("area4.json");
			gson.toJson(list,pw);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
