package vn.magik.moreapps.retrofitapi;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vn.magik.moreapps.model.DataResponse;

/**
 * Created by ThaiVanTien on 10/5/2016.
 */

public class UserServices {
    private CategoryApi service;
    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String BASE_URL = "http://work.magik.vn/";

    private <S> S createService(Class<S> serviceClass) {
        Gson gson = new GsonBuilder().setDateFormat(DATE_TIME_FORMAT).create();
        Retrofit.Builder builder = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson));
        OkHttpClient client = new OkHttpClient();
        Retrofit retrofit = builder.client(client).build();
        return retrofit.create(serviceClass);
    }

    public UserServices() {
        service = createService(CategoryApi.class);
    }

    public void getListData(String urlServer, String language, Callback<DataResponse> dataResponseCallback) {
        Call<DataResponse> call = service.getCallListData(urlServer, language);
        call.enqueue(dataResponseCallback);
    }

}
