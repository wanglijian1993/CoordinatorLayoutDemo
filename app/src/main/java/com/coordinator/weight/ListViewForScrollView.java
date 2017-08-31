package com.coordinator.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * 当前类的注释:  重新ListView每次测量高度
 * 作者：WangLiJian on 2016/5/12.
 * 包名：com.fengyangts.xiaofang.views
 * 邮箱：wanglijian1214@163.com
 */
public class ListViewForScrollView extends ListView {
    public ListViewForScrollView(Context context) {
        super(context);
    }

    public ListViewForScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ListViewForScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 重写该方法,达到使ListView适应ScrollView效果
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
