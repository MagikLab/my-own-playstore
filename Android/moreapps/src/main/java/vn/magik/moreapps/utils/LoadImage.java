package vn.magik.moreapps.utils;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import vn.magik.moreapps.R;

/**
 * Created by dk-darkness on 04/11/2016.
 */

public class LoadImage {
    public static void getImage(Context mContext, String url , ImageView imageView){
        Picasso.with(mContext)
                .load(url)
                .placeholder(R.drawable.loading)
                .into(imageView);
    }
}
