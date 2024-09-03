package com.coddingshuttle.rishu.week1introduction.introductionToSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {

    @Autowired
    DB db;

    String getDB(){
        return db.getDB();
    }
}
