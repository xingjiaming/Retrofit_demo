package com.android.RetrofitService;

import com.android.myapplication.WeatherBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2018/5/10.
 */

public interface RetrofitService {
    /*
     * http://t.weather.sojson.com/api/weather/city/101030100
     * */
    @GET("101030100/")
    Call<WeatherBean> getWeather();
}
