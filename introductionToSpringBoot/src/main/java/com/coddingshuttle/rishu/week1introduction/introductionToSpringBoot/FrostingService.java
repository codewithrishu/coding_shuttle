package com.coddingshuttle.rishu.week1introduction.introductionToSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FrostingService {

    @Autowired
    Frosting frosting;

    String getFrosting(){
        return frosting.getFrostingType();
    }
}
