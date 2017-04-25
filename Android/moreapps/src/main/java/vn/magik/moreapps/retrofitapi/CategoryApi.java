package vn.magik.moreapps.retrofitapi;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;
import vn.magik.moreapps.model.DataResponse;

/**
 * Created by ThaiVanTien on 9/29/2016.
 */
public interface CategoryApi {
    @GET
    Call<DataResponse> getCallListData(@Url String url, @Query("language") String language);
}


