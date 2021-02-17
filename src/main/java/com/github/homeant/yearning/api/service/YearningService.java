package com.github.homeant.yearning.api.service;

import com.github.homeant.yearning.api.domain.Login;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface YearningService {
    @POST("/ldap")
    @Headers("content-type: application/json;charset=UTF-8")
    Call<ResponseBody> login(@Body Login login);
}
