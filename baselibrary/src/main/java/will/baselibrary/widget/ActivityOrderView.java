package will.baselibrary.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import will.baselibrary.R;


/**
 * @Desc: TODO
 * @Author: pengysh
 * @CreatedTime: 2017/4/26 9:45
 */
public class ActivityOrderView extends ViewGroup {
    private static final String TAG = "ActivityOrderView";
    int mDivider = 5;
    int mTextViewTopMargin = 15;
    int mDefaultXCount = 4;
    int mDefaultYCount = 8;
    private Context mContext;
    public ActivityOrderView(Context context) {
        super(context);
        this.mContext = context;
        initData();
        Log.d(TAG, "ActivityOrderView 1");
    }

    public ActivityOrderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        initData();
        Log.d(TAG, "ActivityOrderView 2");
    }

    public ActivityOrderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        Log.d(TAG, "ActivityOrderView 3");
    }

    public void initData(){
        TextView view;
        view = new TextView(mContext);
        view.setText("￥1000");
        view.setTextColor(Color.BLACK);
        addView(view);
        for (int i =0;i<32;i++){
            view = new TextView(mContext);
            switch (i%5){
                case 1:
                    view.setBackgroundResource(R.drawable.blue);
                    break;
                case 2:
                    view.setBackgroundResource(R.drawable.gray);
                    break;
                case 3:
                    view.setBackgroundResource(R.drawable.green);
                    break;
                case 4:
                    view.setBackgroundResource(R.drawable.circle);
                    break;
                case 0:
                    view.setBackgroundResource(R.drawable.red);
                    break;
            }
            addView(view);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSpec = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpec = MeasureSpec.getSize(heightMeasureSpec);
        int childWidth = 0;
        int childHeight = 0;
        for (int i = 0; i < getChildCount(); i++) {
            View childView = getChildAt(i);

            childWidth = MeasureSpec.makeMeasureSpec(widthSpec, MeasureSpec.UNSPECIFIED);
            childHeight = MeasureSpec.makeMeasureSpec(heightSpec, MeasureSpec.UNSPECIFIED);
            Log.d(TAG, "childWidth1 " + childWidth + "   childHeight  " + childHeight);
            childView.measure(childWidth, childHeight);
            childWidth = childView.getWidth();
            childHeight = childView.getHeight();
            Log.d(TAG, "childWidth2 " + childWidth + "   childHeight  " + childHeight);
        }
        widthSpec = (childWidth+2*mDivider)*mDefaultXCount;
        heightSpec = (childHeight+2*mDivider)*mDefaultYCount;
        Log.d(TAG, "onMeasure " + widthSpec + "   heightSpec  " + heightSpec+"  "+getSuggestedMinimumWidth());
        setMeasuredDimension(widthSpec, heightSpec);
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return super.generateDefaultLayoutParams();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//        Log.d(TAG, "onLayout " + getChildCount());
        int tempTop = 0;
        int tempLeft = 0;
        int tempBottom = 0;
        int tempRight = 0;
        for (int i = 0; i < getChildCount(); i++) {
            View childView = getChildAt(i);
            int width = childView.getMeasuredWidth();
            int height = childView.getMeasuredHeight();
            int measureWidth = getMeasuredWidth();
//            Log.d(TAG,"width:"+width+" height:"+height+"  measure "+measureWidth);
            if (i == 0) {
                Log.d(TAG,"l:"+l+"  t:"+t+"   R:"+r+"  B:"+b);
                Log.d(TAG,"l:"+(width)+" t:"+(b/2-height)+"  r:"+(r/2+width)+"  b:"+(b/2+height));
                childView.layout((r-l)/(mDefaultXCount-1),mTextViewTopMargin,(r-l)/2+width,b/2+height);
            } else {
                tempLeft = (i-1) % mDefaultXCount * (mDivider * 2 + width) + mDivider;
                tempRight = (i-1) % mDefaultXCount * (mDivider * 2 + width) + mDivider + width;
                tempTop = ((i-1) / mDefaultXCount + 1) * (mDivider * 2 + height) + mDivider;
                tempBottom = ((i-1) / mDefaultXCount + 1) * (mDivider * 2 + height) + mDivider + height;
                childView.layout(tempLeft, tempTop, tempRight, tempBottom);
//                Log.d(TAG, i+"    onLayout left " + tempLeft + " top " + tempTop + "  right " + tempRight + "　bottom　" + tempBottom);
            }
        }
    }
}
