package com.example.taskmanager.Interface;

import com.example.taskmanager.StudentCUD;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface StudentAPI {

@POST("create")
    Call<Void> registerStudent(@Body StudentCUD std);
}
