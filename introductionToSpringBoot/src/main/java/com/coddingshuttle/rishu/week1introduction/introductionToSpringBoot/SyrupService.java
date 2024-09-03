package com.coddingshuttle.rishu.week1introduction.introductionToSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SyrupService {

    @Autowired
    Syrup syrup;

    String getSyrup(){
        return syrup.getSyrupType();
    }
}
