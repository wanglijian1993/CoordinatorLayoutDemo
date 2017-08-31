package com.coordinator;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

/**
 * 当前类的注释: 模拟支付弹窗
 * 作者：WangLiJian on 2017/8/30.
 * 邮箱：wanglijian1214@gmail.com
 */

public class PayStyleActivity extends AppCompatActivity {

    private NestedScrollView scrollView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_style);
        scrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        final BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(scrollView);
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                Log.e("bottom", "onStateChanged=======newState:" + newState);
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                Log.e("bottom", "onSlide=====slideOffset:" + slideOffset);

            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetBehavior.setState(bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED ?
                        BottomSheetBehavior.STATE_EXPANDED : BottomSheetBehavior.STATE_COLLAPSED);
            }
        });
    }
}
