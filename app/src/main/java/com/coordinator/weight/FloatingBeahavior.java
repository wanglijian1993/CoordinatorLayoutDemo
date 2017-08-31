package com.coordinator.weight;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * 当前类的注释:
 * 作者：WangLiJian on 2017/8/30.
 * 邮箱：wanglijian1214@gmail.com
 */

public class FloatingBeahavior extends FloatingActionButton.Behavior {
    public FloatingBeahavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param parent
     * @param child      设置Beahavior行为的View
     * @param dependency 决定一个child是否有一个其他特殊的兄弟view（dependency）作为布局依赖
     * @return
     */
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
        return super.layoutDependsOn(parent, child, dependency) || dependency instanceof NestedScrollView;
    }

    /**
     * @param parent
     * @param child
     * @param dependency
     * @return
     */
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
        if (dependency instanceof NestedScrollView) {
            CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) child.getLayoutParams();
            int fab_BM = lp.bottomMargin;
            int distance = child.getHeight() + fab_BM;
            child.setY(dependency.getY() - distance);
        }

        return super.onDependentViewChanged(parent, child, dependency);

    }

    /**
     * 当一个CoordinatorLayout的子view准备去开始一个嵌套滑动时调用
     *
     * @param coordinatorLayout 根布局coordinatorLayout
     * @param child             这个behavior所关联的coordinatorLayout的子view
     * @param directTargetChild 包含target 嵌套滚动操作的coordinatorLayout子view
     * @param target            开始嵌套滑动的coordinatorLayout子view。
     * @param nestedScrollAxes  嵌套滚动的轴线。See
     *                          {@link ViewCompat#SCROLL_AXIS_HORIZONTAL},
     *                          {@link ViewCompat#SCROLL_AXIS_VERTICAL}
     * @return 如果behavior希望接受这个嵌套滚动，则返回true。
     * @see NestedScrollingParent#onStartNestedScroll(View, View, int)
     */
    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View directTargetChild, View target, int nestedScrollAxes) {
        return super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes);
    }

    /**
     * 当嵌套滑动已经被CoordinatorLayout接受时调用。
     * <p>
     * 参数同上。
     *
     * @see NestedScrollingParent#onNestedScrollAccepted(View, View, int)
     */
    @Override
    public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View directTargetChild, View target, int nestedScrollAxes) {
        super.onNestedScrollAccepted(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes);
    }

    /**
     * 嵌套滚动结束时调用。
     * <p>
     * 参数同上。
     *
     * @see NestedScrollingParent#onStopNestedScroll(View)
     */
    @Override
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target) {
        super.onStopNestedScroll(coordinatorLayout, child, target);
    }

    /**
     * target滑动之后调用
     *
     * @param coordinatorLayout 同上
     * @param child             同上
     * @param target            同上
     * @param dxConsumed        水平方向target滑动的距离(消耗的距离px)，左滑大于0，右滑小于0
     * @param dyConsumed        垂直方向target滑动的距离(消耗的距离px)，上滑大于0，下滑小于0
     * @param dxUnconsumed      水平方向target未滑动的距离(但是被用户请求了)
     * @param dyUnconsumed      垂直方向target未滑动的距离(但是被用户请求了)
     * @see NestedScrollingParent#onNestedScroll(View, int, int, int, int)
     */
    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
    }

    /**
     * target准备滑动时（滑动之前）调用
     *
     * @param coordinatorLayout 同上
     * @param child             同上
     * @param target            同上
     * @param dx                水平方向target想要滑动的距离（用户请求的）
     * @param dy                垂直方向target想要滑动的距离（用户请求的）
     * @param consumed          需要我们自己传入。 consumed[0] 已经被消费的水平方向滑动的距离, consumed[1] 已经被消费的垂直方向滑动的距离
     * @see NestedScrollingParent#onNestedPreScroll(View, int, int, int[])
     */
    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
    }

    /**
     * target在fling（飞速滚动）之后调用
     *
     * @param coordinatorLayout 同上
     * @param child             同上
     * @param target            同上
     * @param velocityX         水平方向的速度
     * @param velocityY         垂直方向的速度
     * @param consumed          child是否fling了
     * @return behavior是否消费了这个fling
     * @see NestedScrollingParent#onNestedFling(View, float, float, boolean)
     */

    @Override
    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target, float velocityX, float velocityY, boolean consumed) {
        return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);
    }

    /**
     * target在fling（飞速滚动）之前调用
     * <p>
     * 参数同onNestedFling方法。
     *
     * @see NestedScrollingParent#onNestedPreFling(View, float, float)
     */
    @Override
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target, float velocityX, float velocityY) {
        return super.onNestedPreFling(coordinatorLayout, child, target, velocityX, velocityY);
    }
}
