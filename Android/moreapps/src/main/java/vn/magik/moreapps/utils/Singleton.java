package vn.magik.moreapps.utils;

import java.util.ArrayList;
import java.util.List;

import vn.magik.moreapps.model.Category;

/**
 * Created by thaitien on 10/18/2016.
 */
public class Singleton {
    private static Singleton ourInstance = new Singleton();

    public static Singleton getInstance() {
        return ourInstance;
    }

    private List<Category> categories;

    private Singleton() {
        categories = new ArrayList<>();
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
