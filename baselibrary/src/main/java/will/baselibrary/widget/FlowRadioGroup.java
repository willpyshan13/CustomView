package will.baselibrary.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;

/**
 * @Desc: TODO
 * @Author: pengysh
 * @CreatedTime: 2017/5/9 14:28
 */
public class FlowRadioGroup extends RadioGroup {
    private static final String TAG = "FlowRadioGroup";
    public FlowRadioGroup(Context context) {
        super(context);
    }

    public FlowRadioGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.d("FlowRadioGroup", "onMeasure");
        int layoutWidth = MeasureSpec.getSize(widthMeasureSpec);
        int layoutHeight = MeasureSpec.getSize(heightMeasureSpec);
        for (int i = 0; i < getChildCount(); i++) {
            View childView = getChildAt(i);
            childView.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
            Log.d("FlowRadioGroup", "onMeasure  measure childWidth:" + childView.getMeasuredWidth());
        }
        Log.d("FlowRadioGroup", "onMeasure  layoutWidth:" + layoutWidth + "  layoutHeight:  " + layoutHeight);
        setMeasuredDimension(layoutWidth, layoutHeight);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Log.d("FlowRadioGroup", "onLayout");
        int layoutWidth = getMeasuredWidth();
        int childLeft = 0;
        int childRightt = 0;
        int childTop = 0;
        int childBottom = 0;
        int raw = 0;
        int tempWidth = 0;
        for (int i = 0; i < getChildCount(); i++) {
            View childView = getChildAt(i);
            childRightt = tempWidth + childView.getMeasuredWidth();
            if (childRightt > layoutWidth) {
                raw++;
                tempWidth = 0;
                childRightt = tempWidth + childView.getMeasuredWidth();
            }
            childLeft = tempWidth;
            childTop  = raw * childView.getMeasuredHeight();
            childBottom= (raw + 1) * childView.getMeasuredHeight();

            Log.d("FlowRadioGroup", "childLeft:" + childLeft + "  childRightt:" + childRightt + "  childTop:" + childTop + "   childBottom:" + childBottom);
            childView.layout(childLeft, childTop, childRightt, childBottom);
            tempWidth += childView.getMeasuredWidth();
        }
    }
}
