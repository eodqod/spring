package kr.human.di.vo;

import lombok.NoArgsConstructor;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class License {
    private String number="123456ABC";
}
