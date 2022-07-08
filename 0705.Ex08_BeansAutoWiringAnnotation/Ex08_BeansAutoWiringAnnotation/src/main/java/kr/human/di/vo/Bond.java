package kr.human.di.vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Bond {
    @Autowired
//    @Qualifier("Mustang")
    @Qualifier("Ferari") // 모호성이 있을경우에는 지정을 해줘야 한다.
    private Car car;
     
    public void showCar(){
        car.getCarName();
    }
}
