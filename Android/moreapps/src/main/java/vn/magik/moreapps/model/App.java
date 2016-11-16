package vn.magik.moreapps.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class App  implements Serializable{
    @SerializedName("id")
    private  int id;
    @SerializedName("name")
    private  String name;
    @SerializedName("status")
    private int status;
    @SerializedName("category")
    private int category;
    @SerializedName("feature_image")
    private String featureImage;
    @SerializedName("publish_date")
    private String publish_Date;
    @SerializedName("icon_url")
    private String icon_URL;
    @SerializedName("android")
    private String android;
    @SerializedName("web")
    private String web;

    public App(int id, String name, int status, int category,
               String featureImage, String publish_Date,
               String icon_URL, String android, String web) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.category = category;
        this.featureImage = featureImage;
        this.publish_Date = publish_Date;
        this.icon_URL = icon_URL;
        this.android = android;
        this.web = web;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStatus() {
        return status;
    }

    public int getCategory() {
        return category;
    }

    public String getFeatureImage() {
        return featureImage;
    }

    public String getPublish_Date() {
        return publish_Date;
    }

    public String getIcon_URL() {
        return icon_URL;
    }

    public String getAndroid() {
        return android;
    }

    public String getWeb() {
        return web;
    }
}
