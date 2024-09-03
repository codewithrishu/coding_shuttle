package com.coddingshuttle.rishu.week1introduction.introductionToSpringBoot;


import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppleConfig {

    @Bean
    Apple getApple(){
        return new Apple();
    }
}
