package kr.human.di.vo;

import lombok.Data;

import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class Driver {
	@Autowired // 자동으로 객체를 주입해라
    private License license;
}
