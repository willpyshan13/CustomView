package will.customview;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

/**
 * @Desc: TODO
 * @Author: pengysh
 * @CreatedTime: 2017/6/1 10:14
 */
public class AninmalActivity extends AppCompatActivity {
    Button button6,button7,button8,button9,button10 ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aninmal);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button10 = (Button) findViewById(R.id.button10);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.myanimal);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                button6.startAnimation(animation);
                button7.startAnimation(animation);
                button8.startAnimation(animation);
                button9.startAnimation(animation);
                button10.startAnimation(animation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        button6.startAnimation(animation);
        button7.startAnimation(animation);
        button8.startAnimation(animation);
        button9.startAnimation(animation);
        button10.startAnimation(animation);
    }

}
