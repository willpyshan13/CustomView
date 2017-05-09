package will.customview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import will.baselibrary.widget.ActivityOrderView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ActivityOrderView morderView, morderView1, morderView2;
    private RecyclerView mRecycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecycleView = (RecyclerView) findViewById(R.id.recycle);
//        TableGridManager manager = new TableGridManager(5);
        GridLayoutManager manager = new GridLayoutManager(this, 3);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                Log.d(TAG, position + "");
                if (position==0||position % 4 == 1) {
                    return 3;
                } else {
                    return 1;
                }
            }
        });
        LinearLayoutManager manager1 = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecycleView.setLayoutManager(manager1);
//        mRecycleView.setAdapter(new RecycleViewAdapter());
        mRecycleView.setAdapter(new RecycleVeAdapter());
//        morderView = (ActivityOrderView) findViewById(R.id.order_view);
//        morderView1 = (ActivityOrderView) findViewById(R.id.order_view1);
//        morderView2 = (ActivityOrderView) findViewById(R.id.order_view2);
//        addChiView(morderView);
//        addChiView(morderView1);
//        addChiView(morderView2);
    }

    private class RecycleVeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.activity_overview_item_ve, null);
            return new ViewGrid(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 6;
        }

        class ViewGrid extends RecyclerView.ViewHolder {
            private RecyclerView morderView;

            public ViewGrid(View itemView) {
                super(itemView);
                morderView = (RecyclerView) itemView.findViewById(R.id.vel_recycle);

                LinearLayoutManager manager1 = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
                morderView.setLayoutManager(manager1);
                morderView.setAdapter(new RecycleHoAdapter());
            }
        }
    }

    private class RecycleHoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.activity_overview_item, null);
            return new ViewGrid(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 6;
        }

        class ViewGrid extends RecyclerView.ViewHolder {
            private ActivityOrderView morderView;

            public ViewGrid(View itemView) {
                super(itemView);
                morderView = (ActivityOrderView) itemView.findViewById(R.id.order);
            }
        }
    }

    private class RecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view;

            Log.d(TAG, "onCreateViewHolder " + viewType);
            if (viewType == 1) {
                view = getLayoutInflater().inflate(R.layout.activity_overview_title_item, null);
                return new ViewTitle(view);
            } else if (viewType == 2) {
                view = getLayoutInflater().inflate(R.layout.activity_overview_head_item, null);
                return new ViewHead(view);
            } else {
                view = getLayoutInflater().inflate(R.layout.activity_overview_item, null);
                return new ViewGrid(view);
            }
        }

        @Override
        public int getItemViewType(int position) {
            if (position == 0) {
                return 2;
            } else if (position % 4 == 1) {
                Log.d(TAG, "getItemViewType ");
                return 1;
            } else {
                return super.getItemViewType(position);
            }
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 25;
        }

        class ViewGrid extends RecyclerView.ViewHolder {
            private ActivityOrderView morderView;

            public ViewGrid(View itemView) {
                super(itemView);
                morderView = (ActivityOrderView) itemView.findViewById(R.id.order);
            }
        }

        class ViewTitle extends RecyclerView.ViewHolder {
            private TextView morderView;

            public ViewTitle(View itemView) {
                super(itemView);
                morderView = (TextView) itemView.findViewById(R.id.time_tv);
            }
        }

        class ViewHead extends RecyclerView.ViewHolder {
            private TextView morderView;

            public ViewHead(View itemView) {
                super(itemView);
                morderView = (TextView) itemView.findViewById(R.id.time_tv);
            }
        }
    }

    public void addChiView(ActivityOrderView morderView) {
        TextView view;
        view = new TextView(this);
        view.setText("￥1000");
        view.setTextColor(Color.WHITE);
        morderView.addView(view);
        for (int i = 0; i < 32; i++) {
            view = new TextView(this);
            switch (i % 5) {
                case 1:
                    view.setBackgroundResource(R.drawable.bg_common_blue);
                    break;
                case 2:
                    view.setBackgroundResource(R.drawable.bg_common_gray);
                    break;
                case 3:
                    view.setBackgroundResource(R.drawable.bg_common_green);
                    break;
                case 4:
                    view.setBackgroundResource(R.drawable.bg_common_);
                    break;
                case 0:
                    view.setBackgroundResource(R.drawable.bg_common_red);
                    break;
            }
            morderView.addView(view);
        }
    }
}
