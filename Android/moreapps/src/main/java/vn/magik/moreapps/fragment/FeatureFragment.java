package vn.magik.moreapps.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import vn.magik.moreapps.R;
import vn.magik.moreapps.model.App;
import vn.magik.moreapps.utils.Constant;
import vn.magik.moreapps.utils.LoadImage;

/**
 * Created by thaitien on 10/19/2016.
 */

public class FeatureFragment extends Fragment implements View.OnClickListener {
    App app;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle bundle) {
        View view = inflater.inflate(R.layout.view_image_feature, container, false);
        bundle = getArguments();

        app = (App) bundle.getSerializable(Constant.KEY_IMAGE_APP);
        ImageView imgFeature = (ImageView) view.findViewById(R.id.imgViewFeature);
        imgFeature.setOnClickListener(this);
        LoadImage.getImage(getActivity(), app.getFeatureImage(), imgFeature);
        return view;
    }

    @Override
    public void onClick(View v) {
        getActivity().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Constant.BASE_URL_CHPLAY + app.getAndroid())));
    }
}
