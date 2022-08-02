package kr.manamana.select.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import kr.manamana.select.vo.AreaVO;

public class Ex03 {
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
			Resource resource2 = loader.getResource("classpath:sido.json");
			List<AreaVO> sidoList = null;
			InputStreamReader isr = new InputStreamReader(resource2.getInputStream());
			sidoList = gson.fromJson(isr, new TypeToken<List<AreaVO>>() {}.getType());
			for(AreaVO vo : sidoList) {
				Scanner sc = new Scanner(resource.getInputStream(),"UTF-8");
				List<AreaVO> gulist = new ArrayList<AreaVO>();
				while(sc.hasNextLine()) {
					String line = sc.nextLine();
					if(line.startsWith(vo.getId()) && line.contains("00000") && line.contains("존재")) {
						AreaVO areaVO = new AreaVO();
						line = line.replaceAll("( )+", ",");
						line = line.replaceAll("\\t+", ",");
						String[] strings = line.split(",");
						areaVO.setId(strings[0].substring(0,5));
						if(strings[0].endsWith("00000") && strings.length==5)
							areaVO.setName( strings[2] + " " + strings[3] );
						else 
							areaVO.setName( strings[2] );
						
						if(!areaVO.getName().equals("존재")) gulist.add(areaVO);
					}
				}
				PrintWriter pw = new PrintWriter("gu"+vo.getId()+".json");
				gson.toJson(gulist,pw);
				pw.close();
				sc.close();
				System.out.println(vo.getId() + " : " + gulist.size() + "개");
				list.addAll(gulist);
			}
			PrintWriter pw = new PrintWriter("sigu.json");
			gson.toJson(list,pw);
			pw.close();
			System.out.println("전체 : " + list.size() + "개");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
