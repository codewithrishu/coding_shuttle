package com.coddingshuttle.rishu.week1introduction.introductionToSpringBoot;

import org.springframework.stereotype.Component;

@Component
public class StrawberrySyrup implements Syrup {

    @Override
    public String getSyrupType() {
        return "Strawberry syrup";
    }
}
