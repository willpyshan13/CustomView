package will.baselibrary.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * @Desc: TODO
 * @Author: pengysh
 * @CreatedTime: 2017/5/3 10:10
 */
public class SingleLineLayout extends ViewGroup {
    private static final String TAG = "SingleLineLayout";
    private Context mContext;
    public SingleLineLayout(Context context) {
        super(context);
    }

    public SingleLineLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        initData();
    }

    private void initData() {
        for (int i = 0;i<3;i++){
            addView(new ActivityOrderView(mContext));
        }
    }

    public SingleLineLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int layoutHeight = MeasureSpec.getSize(heightMeasureSpec);
        int layoutWidth = MeasureSpec.getSize(widthMeasureSpec);
        int width = 0,height=0;
        for (int i = 0;i<getChildCount();i++){
            View view = getChildAt(i);
            int widthChild = MeasureSpec.makeMeasureSpec(layoutWidth,MeasureSpec.UNSPECIFIED);
            int heightChild = MeasureSpec.makeMeasureSpec(layoutHeight,MeasureSpec.UNSPECIFIED);
            view.measure(widthChild,heightChild);
            width+=widthChild;
            height=Math.max(height,view.getMeasuredHeight());
        }
        Log.d(TAG, "onMeasure childWidth1 " + width + "   childHeight  " + height);
        setMeasuredDimension(width,height);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int tempTop = 0;
        int tempLeft = 0;
        int tempBottom = 0;
        int tempRight = 0;
        for (int i = 0; i < getChildCount(); i++) {
            View view = getChildAt(i);
            int width = view.getMeasuredWidth();
            int height = view.getMeasuredHeight();
            Log.d(TAG, "onLayoutChildren childWidth1 " + width + "   childHeight  " + height);
            tempRight = tempLeft+view.getMeasuredWidth();
            tempBottom = tempTop+view.getMeasuredHeight();
            view.layout(tempLeft, tempTop, tempRight, tempBottom);
            tempLeft+=view.getMeasuredHeight();
            Log.d(TAG, i + " onLayoutChildren   onLayout left " + tempLeft + " top " + tempTop + "  right " + tempRight + "　bottom　" + tempBottom);
        }
    }
}
