package kr.green.batch.vo;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.joda.time.LocalDate;
// XML에 저장되어있는 문자열을 자바 객체로 변환할떄 처리할 어뎁터 클래스
// unmarshal : XML의 Text데이터를 자바 객체로 변환
// marshal   : 자바 객체를 XML의 Text데이터로 변환
public class LocalDateAdapter extends XmlAdapter<String, LocalDate>{

	@Override
	public LocalDate unmarshal(String v) throws Exception {
		return new LocalDate(v);
	}

	@Override
	public String marshal(LocalDate v) throws Exception {
		return v.toString();
	}

}
/*
// 성별을 boolean으로 저장했다면 문자로 바꿔주는 어뎁터를 만들어 사용한다.
class GenderAdapter extends XmlAdapter<String, Boolean>{

	@Override
	public Boolean unmarshal(String v) throws Exception {
		return v.equals("남자");
	}

	@Override
	public String marshal(Boolean v) throws Exception {
		return v ? "남자" : "여자";
	}
	
}
*/
/*
class DateAdapter extends XmlAdapter<String, Date>{

	@Override
	public Date unmarshal(String v) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		return sdf.parse(v);
	}

	@Override
	public String marshal(Date v) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		return sdf.format(v);
	}
	
}
*/