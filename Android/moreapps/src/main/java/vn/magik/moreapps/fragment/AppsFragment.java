package vn.magik.moreapps.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import vn.magik.moreapps.R;
import vn.magik.moreapps.adapter.ListAdapter;
import vn.magik.moreapps.utils.Singleton;


public class AppsFragment extends Fragment {
    private ListView listView;
    private ListAdapter listAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentmain, container, false);
        listView = (ListView) view.findViewById(R.id.listView);
        onUpdateView();
        return view;
    }

    public void onUpdateView() {
        if (listView != null) {
            listAdapter = new ListAdapter(getActivity(), Singleton.getInstance().getCategories());
            listView.setAdapter(listAdapter);
        }
    }


}
