package com.coddingshuttle.rishu.week1introduction.introductionToSpringBoot;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ProdDB implements DB {


    public String getDB() {
        return "Prod dev";
    }
}
