package com.coddingshuttle.rishu.week1introduction.introductionToSpringBoot;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Primary
public class ChocolateSyrup implements Syrup{


    @Override
    public String getSyrupType() {
        return "Chocolate syrup";
    }
}
