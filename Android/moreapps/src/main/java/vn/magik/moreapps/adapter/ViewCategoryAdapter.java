package vn.magik.moreapps.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import vn.magik.moreapps.R;
import vn.magik.moreapps.model.App;
import vn.magik.moreapps.utils.Constant;
import vn.magik.moreapps.utils.LoadImage;

/**
 * Created by ThaiVanTien on 9/30/2016.
 */

public class ViewCategoryAdapter extends RecyclerView.Adapter<ViewCategoryAdapter.MyHolderView>{

    private List<App> listDemo;
    private  Context context;

    public class MyHolderView extends RecyclerView.ViewHolder{
        private TextView txtTitle, txtIsInstall;
        private ImageView imgView, imgIsInstall;
        private MyHolderView(View itemView) {
            super(itemView);
            txtTitle = (TextView)itemView.findViewById(R.id.txtTitle);
            imgView = (ImageView)itemView.findViewById(R.id.imgCategory);
            txtIsInstall  = (TextView)itemView.findViewById(R.id.txtIsInstall);
        }
        public TextView getTxtTitle(){
            return txtTitle;
        }
        public ImageView getImgview(){
            return imgView;
        }
        public TextView getTxtIsInstall(){
            return txtIsInstall;
        }
    }



    public ViewCategoryAdapter(List<App> listDemo, Context context){
        this.listDemo = listDemo;
        this.context = context;
    }
    @Override
    public MyHolderView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_category, parent, false);
        return new MyHolderView(view);
    }

    @Override
    public void onBindViewHolder(MyHolderView holder, final int position) {

       holder.getTxtTitle().setText(listDemo.get(position).getName());

        //set app isInstall();
        if(isAppInstall(listDemo.get(position).getAndroid())){
            holder.getTxtIsInstall().setText("");
            holder.getTxtIsInstall().setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.ic_briefcase_check, 0, 0, 0);
        }
        //Load Image...
        LoadImage.getImage(context,listDemo.get(position).getIcon_URL(),holder.getImgview());

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Constant.BASE_URL_CHPLAY + listDemo.get(position).getAndroid())));
            }
        });
    }

    public boolean isAppInstall(String url){
        Intent itent = context.getPackageManager().getLaunchIntentForPackage(url);
        if(itent!= null){
            return true;
        }
        return false;
    }
    @Override
    public int getItemCount() {
        return listDemo.size();
    }


}
