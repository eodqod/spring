package kr.top2blue.maven;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CsvRecordReadingTest {

    public static void main(String[] args) throws Exception {

        String dir = "src/main/resources/";
		
        readCSV(dir, "test.csv" , ',',"UTF-8");
        System.out.println("*".repeat(80));

        readCSV(dir, "camping.csv" , ',', "EUC-KR");
        System.out.println("*".repeat(80));
        
        /*
        readCSV(dir, "sample.csv" , ',', "EUC-KR");
        System.out.println("*".repeat(80));

        readCSV(dir, "TechCrunchcontinentalUSA.csv" , ',', "EUC-KR");
        System.out.println("*".repeat(80));
        */
    }

	private static void readCSV(String path, String fileName, char delimiter, String charSet ) throws IOException {
		// csv 포맷 설정
        CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(delimiter);
        CSVParser parseCsv = CSVParser.parse(new File(path + fileName), Charset.forName(charSet), format);
		
        List<CSVRecord> list = new ArrayList<CSVRecord>();

        list = parseCsv.getRecords();
        System.out.println(list.size() + "개의 데이터가 있습니다.");
		
        for(int i=0;i<list.size();i++) {
            CSVRecord record = list.get(i);
            System.out.println(record.size() + " : " + record);
            // for(int j=0;j<record.size();j++)  System.out.println(j + " : " + record.get(j));
         }
	}
}
