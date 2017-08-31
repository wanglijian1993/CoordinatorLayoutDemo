package com.coordinator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.coordinator.weight.ListViewForScrollView;

import java.util.ArrayList;
import java.util.List;

/**
 * 当前类的注释:
 * 作者：WangLiJian on 2017/8/30.
 * 邮箱：wanglijian1214@gmail.com
 */

public class ScrollChangeHeadActivity extends AppCompatActivity {
    private ListViewForScrollView lv;
    private List<String> datas;
    private ArrayAdapter arrayAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_scroll);
        lv = (ListViewForScrollView) findViewById(R.id.lv);
        datas = new ArrayList<>();
        arrayAdapter = new ArrayAdapter(this, android.R.layout.test_list_item, datas);
        lv.setAdapter(arrayAdapter);
        initDatas();
    }


    private void initDatas() {
        for (int i = 0; i < 40; i++) {
            datas.add("测试数据:" + i);
        }
        arrayAdapter.notifyDataSetChanged();
    }
}
