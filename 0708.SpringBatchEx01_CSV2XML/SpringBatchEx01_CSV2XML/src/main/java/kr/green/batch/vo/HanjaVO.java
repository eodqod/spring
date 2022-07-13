package kr.green.batch.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlRootElement // JAXB
@XmlType(propOrder = {"h","k","m"}) // 필드 순서
@XmlAccessorType(XmlAccessType.FIELD) // 필드에 사용하겠다.
public class HanjaVO {
	@XmlAttribute // 속성으로 쓰겠다
	private int idx;
	@XmlElement // 태그로 쓰겠다.
	private String h;
	@XmlElement // 태그로 쓰겠다.
	private String k;
	@XmlElement // 태그로 쓰겠다.
	private String m;
}
