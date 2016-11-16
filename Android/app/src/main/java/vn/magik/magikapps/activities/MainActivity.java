package vn.magik.magikapps.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import vn.magik.moreapps.adapter.ViewPagerAdapter;
import vn.magik.moreapps.callLib.CallBackLoadServer;
import vn.magik.moreapps.callLib.InitLib;
import vn.magik.moreapps.fragment.AppsFragment;
import vn.magik.magikapps.R;
import vn.magik.magikapps.fragment.TabOneFragment;

public class MainActivity extends AppCompatActivity implements CallBackLoadServer {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    TabOneFragment tabOneFragment;
    AppsFragment appsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabOneFragment = new TabOneFragment();
        appsFragment = new AppsFragment();
        initViewPagerAndTab();
        InitLib.initLab(MainActivity.this, this);

    }

    public void initViewPagerAndTab() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewAdapter.addFragment(tabOneFragment, "Tab 1");
        viewAdapter.addFragment(appsFragment, "Tab 2");
        viewPager.setAdapter(viewAdapter);
    }


    @Override
    public void onFinishLoadServer(int newApp) {
        tabOneFragment.updateAppView(newApp);
        appsFragment.onUpdateViewe();
    }


}
