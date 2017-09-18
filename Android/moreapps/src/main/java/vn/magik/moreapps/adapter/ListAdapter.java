package vn.magik.moreapps.adapter;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import vn.magik.moreapps.R;
import vn.magik.moreapps.fragment.FeatureFragment;
import vn.magik.moreapps.model.App;
import vn.magik.moreapps.model.Category;
import vn.magik.moreapps.utils.Constant;

/**
 * Created by ThaiVanTien on 9/30/2016.
 */

public class ListAdapter extends BaseAdapter implements Runnable {
    private FragmentActivity activity;
    private List<Category> listDemo;
    private ViewPager pager;
    Handler handler = new Handler();

    public ListAdapter(FragmentActivity activity, List<Category> listDemo) {
        this.activity = activity;
        this.listDemo = listDemo;
    }

    @Override
    public int getCount() {
        return listDemo.size();
    }

    @Override
    public Object getItem(int i) {
        return listDemo.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    int paperid = 1;

    @Override
    public View getView(int positon, View view, ViewGroup viewGroup) {
        LayoutInflater mInflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (listDemo.get(positon).getName().equalsIgnoreCase("feature")) {
            view = mInflater.inflate(R.layout.viewpagerfeature, null);
            pager = (ViewPager) view.findViewById(R.id.viewpager);
            pager.setId(paperid++);
            showAppsFeature(listDemo.get(positon).getApps());

        } else {
            view = mInflater.inflate(R.layout.view_full_category, null);
            //update name.
            TextView text = (TextView) view.findViewById(R.id.txtTitleCate);
            text.setText(listDemo.get(positon).getName());

            //update desc
            TextView textDes = (TextView) view.findViewById(R.id.txtDescCate);
            textDes.setText(listDemo.get(positon).getDescription());
            textDes.setVisibility(
                    listDemo.get(positon).getDescription().equals("")? View.GONE: View.VISIBLE);

            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewAllCate);
            recyclerView.setLayoutManager(new LinearLayoutManager(activity.getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
            recyclerView.setAdapter(new ViewCategoryAdapter(listDemo.get(positon).getApps(), view.getContext()));
        }
        return view;
    }

    boolean isHandleRuning = false;

    public void showAppsFeature(List<App> apps) {
        FeatureViewPagerAdapter viewAdapter = new FeatureViewPagerAdapter(activity.getSupportFragmentManager());
        if (listDemo != null) {
            for (int i = 0; i < apps.size(); i++) {
                FeatureFragment featureFragment = new FeatureFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable(Constant.KEY_IMAGE_APP, apps.get(i));
                featureFragment.setArguments(bundle);
                viewAdapter.addFragment(featureFragment, "");
            }
        }

        pager.setAdapter(viewAdapter);
        if (!isHandleRuning) {
            isHandleRuning = true;
            handler.postDelayed(this, 5000);
        }
    }


    @Override
    public void run() {
        int page = pager.getCurrentItem() + 1;
        if (page > pager.getAdapter().getCount() - 1) {
            page = 0;
        }
       // Log.d("HUONG", "page: " + page + "pager.getAdapter().getCount(): " + pager.getAdapter().getCount());
        pager.setCurrentItem(page);
        handler.postDelayed(this, 5000);
    }
}
