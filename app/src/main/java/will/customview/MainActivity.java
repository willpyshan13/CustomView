package will.customview;

import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import will.baselibrary.widget.ActivityOrderView;
import will.baselibrary.widget.TableGridManager;

public class MainActivity extends AppCompatActivity {
    private ActivityOrderView morderView,morderView1,morderView2;
    private RecyclerView mRecycleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecycleView = (RecyclerView) findViewById(R.id.recycle);
        TableGridManager manager = new TableGridManager(5);
        mRecycleView.setLayoutManager(manager);
        mRecycleView.setAdapter(new RecycleViewAdapter());

//        morderView = (ActivityOrderView) findViewById(R.id.order_view);
//        morderView1 = (ActivityOrderView) findViewById(R.id.order_view1);
//        morderView2 = (ActivityOrderView) findViewById(R.id.order_view2);
//        addChiView(morderView);
//        addChiView(morderView1);
//        addChiView(morderView2);
    }

    private class RecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.activity_overview_item,null);
            return new ViewH(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 18;
        }
        class ViewH extends RecyclerView.ViewHolder{
            private ActivityOrderView morderView;
            public ViewH(View itemView) {
                super(itemView);
                morderView = (ActivityOrderView) itemView.findViewById(R.id.order);
            }
        }
    }

    public void addChiView(ActivityOrderView morderView){
        TextView view;
        view = new TextView(this);
        view.setText("￥1000");
        view.setTextColor(Color.WHITE);
        morderView.addView(view);
        for (int i =0;i<32;i++){
            view = new TextView(this);
            switch (i%5){
                case 1:
//                    view.setBackgroundResource(R.drawable.blue);
                    break;
                case 2:
//                    view.setBackgroundResource(R.drawable.gray);
                    break;
                case 3:
//                    view.setBackgroundResource(R.drawable.green);
                    break;
                case 4:
//                    view.setBackgroundResource(R.drawable.circle);
                    break;
                case 0:
//                    view.setBackgroundResource(R.drawable.red);
                    break;
            }
            morderView.addView(view);
        }
    }
}
