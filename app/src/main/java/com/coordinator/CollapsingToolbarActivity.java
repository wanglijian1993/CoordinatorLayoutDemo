package com.coordinator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.coordinator.utils.AppBarStateChangeListener;
import com.coordinator.weight.ListViewForScrollView;

import java.util.ArrayList;
import java.util.List;

/**
 * 当前类的注释:
 * 作者：WangLiJian on 2017/8/30.
 * 邮箱：wanglijian1214@gmail.com
 */

public class CollapsingToolbarActivity extends AppCompatActivity {
    private ListView lv;
    private List<String> datas;
    private ArrayAdapter arrayAdapter;
    private Toolbar toolbar;
    private ActionBar actionBar;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private AppBarLayout appBarLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_collapsing);
        lv = (ListView) findViewById(R.id.lv);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbarlayout);
        appBarLayout = (AppBarLayout) findViewById(R.id.barlayout);
        initBar();
        datas = new ArrayList<>();
        arrayAdapter = new ArrayAdapter(this, android.R.layout.test_list_item, datas);
        lv.setAdapter(arrayAdapter);
        initDatas();
        appBarLayout.addOnOffsetChangedListener(new AppBarStateChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state) {
                Log.d("STATE", state.name());
                if (state == State.EXPANDED) {
                    Log.d("STATE","展开状态");
                    //展开状态
                } else if (state == State.COLLAPSED) {
                    Log.d("STATE","折叠状态");
                    //折叠状态
                } else {
                    Log.d("STATE","中间状态");
                    //中间状态
                }
            }
        });

    }

    private void initBar() {
        toolbar = (Toolbar) findViewById(R.id.bar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private void initDatas() {
        for (int i = 0; i < 40; i++) {
            datas.add("测试数据:" + i);
        }
        arrayAdapter.notifyDataSetChanged();
    }


}
