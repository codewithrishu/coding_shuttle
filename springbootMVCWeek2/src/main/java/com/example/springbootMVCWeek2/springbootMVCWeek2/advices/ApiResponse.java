package com.example.springbootMVCWeek2.springbootMVCWeek2.advices;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ApiResponse<T>{

    private LocalDateTime timeStamp;
    private T data;
    private APIError error;

    public ApiResponse(){
        this.timeStamp = LocalDateTime.now();
    }

    public ApiResponse(T data){
        this();
        this.data = data;
    }

    public ApiResponse(APIError error){
        this();
        this.error = error;
    }

}
