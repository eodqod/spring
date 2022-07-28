package kr.top2blue.maven;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CampingCsvRead {

	public static void main(String[] args) throws Exception {

		String dir = "src/main/resources/";
		List<CompanyVO> list = readCSV(dir, "camping.csv", ',', "EUC-KR");
		System.out.println(list.size());
		System.out.println("*".repeat(80));
		for (CompanyVO vo : list) {
			if(vo.getAdd1().contains("경기도 용인")) System.out.println(vo);
		}

	}

	private static List<CompanyVO> readCSV(String path, String fileName, char delimiter, String charSet)
			throws IOException {
		// csv 포맷 설정
		CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(delimiter);
		CSVParser parseCsv = CSVParser.parse(new File(path + fileName), Charset.forName(charSet), format);

		List<CSVRecord> list = new ArrayList<>();

		list = parseCsv.getRecords();

		List<CompanyVO> companyList = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			CSVRecord record = list.get(i);
			System.out.println(record);
			CompanyVO vo = new CompanyVO();
			vo.setIdx(i);
			if(record.get(0)!=null && record.get(0).trim().length()!=0) vo.setName(record.get(0));
			if(record.get(1)!=null && record.get(1).trim().length()!=0) vo.setAdd1(record.get(1));
			if(record.get(2)!=null && record.get(2).trim().length()!=0) vo.setAdd2(record.get(2));
			if(record.get(3)!=null && record.get(3).trim().length()!=0) vo.setPostcode(Integer.parseInt(record.get(3)));
			if(record.get(4)!=null && record.get(4).trim().length()!=0) vo.setEco(record.get(4));
			if(record.get(5)!=null && record.get(5).trim().length()!=0) vo.setRoomtype(record.get(5));
			if(record.get(6)!=null && record.get(6).trim().length()!=0) vo.setTheme(record.get(6));
			if(record.get(7)!=null && record.get(7).trim().length()!=0) vo.setAreacode(Integer.parseInt(record.get(7)));
			if(record.get(8)!=null && record.get(8).trim().length()!=0) vo.setCoordX(Double.parseDouble(record.get(8)));
			if(record.get(9)!=null && record.get(9).trim().length()!=0) vo.setCoordY(Double.parseDouble(record.get(9)));
			if(record.get(10)!=null && record.get(10).trim().length()!=0) vo.setCol1(record.get(10));
			if(record.get(11)!=null && record.get(11).trim().length()!=0) vo.setCol2(Integer.parseInt(record.get(11)));
			companyList.add(vo);
		}
		return companyList;
	}
}
