package com.android.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://t.weather.sojson.com/api/weather/city/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        com.android.RetrofitService.RetrofitService request = retrofit.create(com.android.RetrofitService.RetrofitService.class);
        Call<WeatherBean> call = request.getWeather();
        call.enqueue(new Callback<WeatherBean>() {
            @Override
            public void onResponse(Call<WeatherBean> call, Response<WeatherBean> response) {
                Toast.makeText(getBaseContext(), response.body().getDate(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<WeatherBean> call, Throwable t) {

            }
        });
    }
}
