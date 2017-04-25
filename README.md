# My-own-playstore
Make a android store for your company, your team.

# Config:
Server:
Create Api return as http://work.magik.vn/api.php

Android Client:
add library to dependencies:

    dependencies {
        compile 'vn.magik.libraries:moreapps:1.4'
    }
    
We have Fragment "AppsFragment", so we can add Fragment to Activty:

Function Init load api

    public static final String URL = "http://work.magik.vn/api.php";
    InitLib.getInstance().initLab(MagikAppsActivity.this, URL, new CallBackLoadServer() {
        @Override
        public void onFinishLoadServer(int totalApps) {
            //todo update new app
        }
    });
    
Function add fragment to View, you must to call function Init before add Fragment to view

    private void addFragment(){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        AppsFragment appsFragment = new AppsFragment();
        fragmentTransaction.add(R.id.view_contain, appsFragment);
        fragmentTransaction.commit();
    }


# View sample

Aplication of Magiklab:

![alt tag](https://lh3.googleusercontent.com/kES48RhXSEe1J4W-W2vpU-F_T4qiUIdUOFIhD9tF987bPC3L-MNrX0vy37lxkZnf7rE=h310-rw)
![alt tag](https://lh3.googleusercontent.com/Y99IO5J-ZZmCVIwTun1M9B6cjG9mHh-JUeCIo3l2PB_t5sMB9Ru4IcMUC8EnRTvgEA=h310-rw)

Detail: https://play.google.com/store/apps/details?id=vn.magik.labstore
