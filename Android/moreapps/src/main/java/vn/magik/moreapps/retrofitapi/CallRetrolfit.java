package vn.magik.moreapps.retrofitapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vn.magik.moreapps.utils.Constant;

/**
 * Created by ThaiVanTien on 10/5/2016.
 */

public class CallRetrolfit {
    public static Retrofit getRetrolfit() {
        return new Retrofit.Builder().baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
