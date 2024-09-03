package com.coddingshuttle.rishu.week1introduction.introductionToSpringBoot;

import org.springframework.stereotype.Component;

@Component
public class StrwaberryFrosting implements Frosting {
    @Override
    public String getFrostingType() {
        return "Strawberry frosting";
    }
}
