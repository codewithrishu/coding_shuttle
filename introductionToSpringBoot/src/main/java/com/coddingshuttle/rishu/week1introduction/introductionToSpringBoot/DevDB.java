package com.coddingshuttle.rishu.week1introduction.introductionToSpringBoot;


import org.springframework.stereotype.Component;

@Component
public class DevDB implements DB{


    public String getDB() {
        return "db dev";
    }
}
