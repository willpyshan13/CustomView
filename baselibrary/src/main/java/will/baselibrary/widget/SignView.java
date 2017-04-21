package will.baselibrary.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * @Desc: 手写签名view
 * @Author: pengysh
 * @CreatedTime: 2017/4/21 15:56
 */
public class SignView extends View {
    private static final String TAG = "SignView";
    private int mLength = 400;
    private Paint paint = new Paint();
    private Path mPath = new Path();
    private Canvas mCanvas;
    private int width,height;
    private void initPaint(){
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);

    }
    public SignView(Context context) {
        super(context);
        initPaint();
    }

    public SignView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public SignView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    public SignView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initPaint();
    }

    private void drawLine(float x,float y){
        Log.d(TAG,"drawLine"+x+"===y:"+y);
        mCanvas.drawPoint(x,y,paint);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d(TAG,"dispatchTouchEvent "+event.getAction());
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_MOVE:
//                drawLine(event.getX(),event.getY());
                break;
        }

        invalidate();
        return true;
    }



    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //取出宽度的具体数值
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        //取出宽度的测量模式
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        Log.d(TAG,"widthSize:"+widthSize+"   heightSize:"+heightSize+"   widthMode:"+widthMode+"   heightMode:"+heightMode);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    //画线跟画圈
    private void drawCircle(Canvas canvas){
        canvas.translate(width/2,height/2);
        int height = (int) (Math.sqrt(3)/2*mLength);

        //画线
        canvas.drawLine(-mLength,0,mLength,0,paint);
        canvas.drawLine(-mLength/2,height,mLength/2,-height,paint);
        canvas.drawLine(mLength/2,height,-mLength/2,-height,paint);

        //画方框
        for(int i = 0;i<8;i++){
            mPath.reset();
            int length = mLength-i*50;
            height = (int) (Math.sqrt(3)/2*length);
            mPath.moveTo(-length,0);
            mPath.lineTo(-length/2,height);
            mPath.lineTo(length/2,height);
            mPath.lineTo(length,0);
            mPath.lineTo(length/2,-height);
            mPath.lineTo(-length/2,-height);
            mPath.close();
            canvas.drawPath(mPath,paint);
        }

        //画技能图
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setAlpha(50);
        mPath.moveTo(-333,0);
        mPath.lineTo(-123,122);
        mPath.lineTo(123,123);
        mPath.lineTo(201,0);
        mPath.lineTo(150,-90);
        mPath.lineTo(-123,-132);
        mPath.close();
        canvas.drawPath(mPath,paint);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawCircle(canvas);

//        mCanvas = canvas;
//        mCanvas.drawPoint(200, 200, paint);     //在坐标(200,200)位置绘制一个点
//        mCanvas.drawPoints(new float[]{          //绘制一组点，坐标位置由float数组指定
//                500,500,
//                500,600,
//                500,700
//        },paint);
//        canvas.translate(width/2,height/2);
//
//        int height = (int) (Math.sqrt(3)/2*200);
//        canvas.drawLine(-200,0,200,0,paint);
//        canvas.drawLine(-100,height,100,-height,paint);
//        canvas.drawLine(100,height,-100,-height,paint);
//
////        mPath.addRect(-100,-100,100,100, Path.Direction.CW);
//        mPath.moveTo(-200,0);
//
//        mPath.lineTo(-100,height);
//        mPath.lineTo(100,height);
//        mPath.lineTo(200,0);
//        mPath.lineTo(100,-height);
//        mPath.lineTo(-100,-height);
//        mPath.close();
////        Path path = new Path();
////
////        path.addRect(-200,-200,200,200, Path.Direction.CW);
////
////        mPath.addPath(path,0,0);
////        Path path1 = new Path();
////        path1.addRect(-50,-50,50,50, Path.Direction.CW);
//////        path1.setLastPoint(0,50);
////        mPath.addPath(path1,0,0);
//        canvas.drawPath(mPath,paint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.d(TAG,"w:"+w+" h:"+h);
        width = w;
        height = h;
        mCanvas = new Canvas();
    }


}
