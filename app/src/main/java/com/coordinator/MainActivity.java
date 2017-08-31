package com.coordinator;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Class[] activitys = new Class[]{PayStyleActivity.class, TransChangeButtonActivity.class, ScrollChangeHeadActivity.class, CollapsingToolbarActivity.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void toPay(View v) {
        goToActivity(activitys[0]);
    }

    public void toTrans(View v) {
        goToActivity(activitys[1]);
    }

    public void toScrollView(View v) {
        goToActivity(activitys[2]);
    }

    public void toChangeHead(View v) {
        goToActivity(activitys[3]);

    }

    private void goToActivity(Class activity) {
        startActivity(new Intent(this, activity));
    }
}
