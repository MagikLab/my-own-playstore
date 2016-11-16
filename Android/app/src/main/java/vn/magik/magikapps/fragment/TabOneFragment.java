package vn.magik.magikapps.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import vn.magik.moreapps.activities.MagikAppsActivity;
import vn.magik.magikapps.R;

/**
 * Created by thaitien on 10/12/2016.
 */

public class TabOneFragment extends Fragment implements View.OnClickListener {
    TextView tvNumberNewApps;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle bundle) {
        final View view = inflater.inflate(R.layout.tabone, container, false);
        View viewMoreApps = view.findViewById(R.id.view_more_apps);
        viewMoreApps.setOnClickListener(this);
        tvNumberNewApps = (TextView) view.findViewById(R.id.idtxtCount);
        return view;
    }

    public void updateAppView(int numberNewApp) {
        if (numberNewApp > 0) {
            tvNumberNewApps.setText(String.valueOf(numberNewApp));
            tvNumberNewApps.setVisibility(View.VISIBLE);
        } else {
            tvNumberNewApps.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), MagikAppsActivity.class);
        startActivity(intent);
        tvNumberNewApps.setVisibility(View.GONE);
    }
}
