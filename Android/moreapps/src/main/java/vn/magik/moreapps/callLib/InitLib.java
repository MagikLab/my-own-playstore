package vn.magik.moreapps.callLib;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.magik.moreapps.type.CheckMore;
import vn.magik.moreapps.utils.HandleDataLocal;
import vn.magik.moreapps.utils.Singleton;
import vn.magik.moreapps.model.DataRespone;
import vn.magik.moreapps.retrofitapi.CallRetrolfit;
import vn.magik.moreapps.retrofitapi.CategoryApi;

/**
 * Created by thaitien on 10/14/2016.
 */

public class InitLib {

    static HandleDataLocal mHandleDataLocal;

    public static void initLab(Context mContext, CallBackLoadServer callBack) {
        if (CheckMore.isInternet(mContext)) {
            loadDataOnline(mContext, callBack);
        } else {
            mHandleDataLocal = new HandleDataLocal(mContext);
            String jsonString = mHandleDataLocal.getData();
            if (jsonString != null) {
                Singleton.getInstance().setCategories(new Gson()
                        .fromJson(jsonString, DataRespone.class)
                        .getData()
                        .getCategories());
                callBack.onFinishLoadServer(0);
            }

        }

    }

    public static void loadDataOnline(final Context context, final CallBackLoadServer callBack) {
        CategoryApi categoryApi = CallRetrolfit.getRetrolfit().create(CategoryApi.class);
        retrofit2.Call<DataRespone> callListData = categoryApi.getCallListData();
        callListData.enqueue(new Callback<DataRespone>() {
            @Override
            public void onResponse(Call<DataRespone> call, Response<DataRespone> response) {
                DataRespone dataRespone = response.body();
                Singleton.getInstance().setCategories(dataRespone.getData().getCategories());
                //Log.d("HUONG", "Categories size" + Singleton.getInstance().getCategories().size());
                mHandleDataLocal = new HandleDataLocal(context);
                Gson gs = new Gson();
                int count = getTotalCount(mHandleDataLocal.getData());
                String jsonString = gs.toJson(response.body());
                mHandleDataLocal.saveData(jsonString);
                callBack.onFinishLoadServer(dataRespone.getData().getTotalApp() - count + 1);
            }

            @Override
            public void onFailure(Call<DataRespone> call, Throwable t) {

            }
        });
    }

    private static int getTotalCount(String jsonString) {
        if (jsonString != null) {
            return new Gson().fromJson(jsonString, DataRespone.class).getData().getTotalApp();
        } else return 0;
    }

}
