package vn.magik.moreapps.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ThaiVanTien on 9/29/2016.
 */

public class Category {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("type")
    private String type;
    @SerializedName("description")
    private String description;
    @SerializedName("apps")
    private List<App> apps;

    public Category(String id, String name, String type, String description, List<App> apps) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.apps = apps;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public List<App> getApps() {
        return apps;
    }
}
