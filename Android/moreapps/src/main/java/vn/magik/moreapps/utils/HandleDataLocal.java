package vn.magik.moreapps.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by dk-darkness on 04/11/2016.
 */

public class HandleDataLocal {
    private SharedPreferences sharedPreferences;
    private Context mContext;

    public HandleDataLocal(Context mContext) {
        this.mContext = mContext;
        sharedPreferences = mContext.getSharedPreferences(Constant.PREFERENCES_SAVEDATA, mContext.MODE_PRIVATE);
    }

    public void saveData(String profile) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Constant.PREFERENCES_SAVEDATA, profile);
        editor.commit();
    }

    public String getData() {
        String profile = sharedPreferences.getString(Constant.PREFERENCES_SAVEDATA, null);
        return profile;
    }
}
