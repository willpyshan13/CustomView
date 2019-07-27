package will.customview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * @Desc: TODO
 * @Author: pengysh
 * @CreatedTime: 2017/5/9 14:56
 */
public class DemoActivity extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
        findViewById(R.id.button7).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                startActivity(new Intent(DemoActivity.this,MainActivity.class));
                break;
            case R.id.button2:
                startActivity(new Intent(DemoActivity.this,FlowRadioGroupActivity.class));
                break;
            case R.id.button3:
                startActivity(new Intent(DemoActivity.this,ShapeActivity.class));
                break;
            case R.id.button4:
                startActivity(new Intent(DemoActivity.this,RecycleActivity.class));
                break;
            case R.id.button5:
                startActivity(new Intent(DemoActivity.this,AninmalActivity.class));
                break;
            case R.id.button6:
                startActivity(new Intent(DemoActivity.this,BaseNfcActivity.class));
                break;
            case R.id.button7:
                startActivity(new Intent(DemoActivity.this,TranslateActivity.class));
                break;
        }
    }
}
