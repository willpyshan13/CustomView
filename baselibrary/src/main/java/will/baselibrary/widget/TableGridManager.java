package will.baselibrary.widget;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * @Desc: TODO
 * @Author: pengysh
 * @CreatedTime: 2017/4/28 17:29
 */
public class TableGridManager extends RecyclerView.LayoutManager {
    private static final String TAG = "TableGridManager";
    int mSpanCount = -1;
    int mDivider = 5;

    public TableGridManager(int spanCount){
        this.mSpanCount = spanCount;
        setAutoMeasureEnabled(true);
    }
    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public int scrollHorizontallyBy(int dx, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return super.scrollHorizontallyBy(dx, recycler, state);
    }

    @Override
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return super.scrollVerticallyBy(dy, recycler, state);
    }

//    @Override
//    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int widthSpec, int heightSpec) {
//        super.onMeasure(recycler, state, widthSpec, heightSpec);
//        int layoutWidth = View.MeasureSpec.getSize(widthSpec);
//        int layoutHeight = View.MeasureSpec.getSize(heightSpec);
//        Log.d(TAG, "onMeasure layoutWidth " + layoutWidth + "   layoutHeight  " + layoutHeight+"  child count "+getChildCount());
//        int childWidth = 0, childHeight = 0;
//        for (int i = 0; i < getChildCount(); i++) {
//            View childView = getChildAt(i);
//            childWidth = View.MeasureSpec.makeMeasureSpec(layoutWidth, View.MeasureSpec.UNSPECIFIED);
//            childHeight = View.MeasureSpec.makeMeasureSpec(layoutHeight, View.MeasureSpec.UNSPECIFIED);
//            Log.d(TAG, "onMeasure childWidth1 " + childWidth + "   childHeight  " + childHeight);
//            childView.measure(childWidth, childHeight);
//        }
//        layoutWidth = childWidth * mSpanCount;
//        int left = getChildCount() % mSpanCount;
//        int heightCount = getChildCount() / mSpanCount;
//        if (left > 0)
//            heightCount++;
//        layoutHeight = childHeight * heightCount;
//        Log.d(TAG, "onMeasure layoutWidth " + layoutWidth + "   layoutHeight  " + layoutHeight);
//        setMeasuredDimension(layoutWidth, layoutHeight);
//    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        super.onLayoutChildren(recycler, state);
        int tempTop = 0;
        int tempLeft = 0;
        int tempBottom = 0;
        int tempRight = 0;
        for (int i = 0; i < getChildCount(); i++) {
            View view = getChildAt(i);
            int width = view.getMeasuredWidth();
            int height = view.getMeasuredHeight();
            Log.d(TAG, "onLayoutChildren childWidth1 " + width + "   childHeight  " + height);
            tempLeft = (i - 1) % mSpanCount * (mDivider * 2 + width) + mDivider;
            tempRight = (i - 1) % mSpanCount * (mDivider * 2 + width) + mDivider + width;
            tempTop = ((i - 1) / mSpanCount + 1) * (mDivider * 2 + height) + mDivider;
            tempBottom = ((i - 1) / mSpanCount + 1) * (mDivider * 2 + height) + mDivider + height;
            view.layout(tempLeft, tempTop, tempRight, tempBottom);
            Log.d(TAG, i + " onLayoutChildren   onLayout left " + tempLeft + " top " + tempTop + "  right " + tempRight + "　bottom　" + tempBottom);
        }
    }

    @Override
    public boolean canScrollVertically() {
        return true;
    }

    @Override
    public boolean canScrollHorizontally() {
        return mSpanCount > 3 ? true : false;
    }
}
