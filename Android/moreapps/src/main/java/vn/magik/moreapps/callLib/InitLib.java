package vn.magik.moreapps.callLib;

import android.content.Context;

import com.google.gson.Gson;

import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.magik.moreapps.model.Category;
import vn.magik.moreapps.retrofitapi.UserServices;
import vn.magik.moreapps.type.CheckMore;
import vn.magik.moreapps.utils.HandleDataLocal;
import vn.magik.moreapps.utils.Singleton;
import vn.magik.moreapps.model.DataResponse;

/**
 * Created by thaitien on 10/14/2016.
 */

public class InitLib {
    private static InitLib instance = null;
    private HandleDataLocal mHandleDataLocal;

    public static InitLib getInstance() {
        if (instance == null) {
            instance = new InitLib();
        }
        return instance;
    }


    public void initLab(Context mContext, String urlServer, CallBackLoadServer callBack) {
        mHandleDataLocal = new HandleDataLocal(mContext);
        if (CheckMore.isInternet(mContext)) {
            loadDataOnline(urlServer, callBack);
        } else {
            String jsonString = mHandleDataLocal.getData();
            if (jsonString != null) {
                Singleton.getInstance().setCategories(new Gson()
                        .fromJson(jsonString, DataResponse.class)
                        .getData()
                        .getCategories());
                callBack.onFinishLoadServer(0);
            }

        }

    }

    private void loadDataOnline(String urlServer, final CallBackLoadServer callBack) {
        UserServices userServices = new UserServices();
        String language = Locale.getDefault().getLanguage();
        userServices.getListData(urlServer, language, new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                if (response != null && response.isSuccessful() && response.body() != null) {
                    DataResponse dataResponse = response.body();
                    List<Category> categories = dataResponse.getData().getCategories();
                    for (int i = categories.size() - 1; i >= 0; i--) {
                        if (categories.get(i).getApps().size() == 0)
                            categories.remove(i);
                    }
                    Singleton.getInstance().setCategories(categories);
                    int count = getTotalCount(mHandleDataLocal.getData());
                    String jsonString = new Gson().toJson(response.body());
                    mHandleDataLocal.saveData(jsonString);
                    callBack.onFinishLoadServer(dataResponse.getData().getTotalApp() - count + 1);
                }
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private int getTotalCount(String jsonString) {
        if (jsonString != null) {
            return new Gson().fromJson(jsonString, DataResponse.class).getData().getTotalApp();
        } else return 0;
    }

}
