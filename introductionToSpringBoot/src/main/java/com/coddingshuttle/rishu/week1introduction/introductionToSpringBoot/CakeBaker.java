package com.coddingshuttle.rishu.week1introduction.introductionToSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

@Component
public class CakeBaker {

    @Autowired
    FrostingService frosting;

    @Autowired
    SyrupService syrup;

    void bakeCake(){
      System.out.println(frosting.getFrosting());
      System.out.println(syrup.getSyrup());
    }
}
