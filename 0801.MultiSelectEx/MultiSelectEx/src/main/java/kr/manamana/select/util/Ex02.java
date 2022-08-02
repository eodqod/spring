package kr.manamana.select.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import com.google.gson.Gson;

import kr.manamana.select.vo.AreaVO;

public class Ex02 {
	// https://www.code.go.kr/cod/frt/codesearch_beop_main.do
	// 위의 데이터에서 "세종특별자치시" 만 두 줄 추가해야 함
	// 3600000000	세종특별자치시	존재
	// 3611000000	세종특별자치시 세종		존재

	public static void main(String[] args) {
		Gson gson = new Gson();
		List<AreaVO> list = new ArrayList<AreaVO>();
		DefaultResourceLoader loader = new DefaultResourceLoader();
		try {
			Resource resource = loader.getResource("classpath:dong.txt");
			Scanner sc = new Scanner(resource.getInputStream(),"UTF-8");
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				if(line.contains("00000000") && line.contains("존재")) {
					AreaVO vo = new AreaVO();
					vo.setId(line.substring(0,2));
					int end = line.lastIndexOf("존재");
					vo.setName(line.substring(10,end).trim());
					System.out.println(vo);
					list.add(vo);
				}
			}
			PrintWriter pw = new PrintWriter("sido.json");
			gson.toJson(list,pw);
			pw.close();
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
