package vn.magik.moreapps.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ThaiVanTien on 9/29/2016.
 */

public class DataResponse {
    @SerializedName("error")
    private int error;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private Data data;

    public int getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public Data getData() {
        return data;
    }

    public class Data {
        @SerializedName("total_app")
        private int totalApp;
        @SerializedName("categories")
        private List<Category> categories;

        public int getTotalApp() {
            return totalApp;
        }

        public List<Category> getCategories() {
            return categories;
        }
    }

}
