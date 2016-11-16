package vn.magik.moreapps.retrofitapi;

import retrofit2.Call;
import retrofit2.http.GET;
import vn.magik.moreapps.model.DataRespone;

/**
 * Created by ThaiVanTien on 9/29/2016.
 */
public interface CategoryApi {
    @GET("api.php")
    Call<DataRespone> getCallListData();
}


