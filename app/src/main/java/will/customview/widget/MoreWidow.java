package will.customview.widget;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

import will.customview.R;

public class MoreWidow extends PopupWindow {
    private View view;

    public MoreWidow(Context context) {
        super(context);
        view = LayoutInflater.from(context).inflate(R.layout.sellshop_more_window, null);
        this.setFocusable(true);
//        this.setAnimationStyle(R.style.AnimBottom);
//        ColorDrawable dw = new ColorDrawable(0xb0000000);
//        this.setBackgroundDrawable(dw);
        setBackgroundDrawable(new BitmapDrawable());
        setContentView(view);
    }

}
