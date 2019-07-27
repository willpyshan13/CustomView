package will.customview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class RecycleActivity extends AppCompatActivity {
    private RecyclerView mList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        mList = (RecyclerView) findViewById(R.id.recycle);
        RecycleAdapter adapter = new RecycleAdapter();
        GridLayoutManager manager = new GridLayoutManager(this,1);
        mList.setLayoutManager(manager);
        mList.setAdapter(adapter);

    }

    class RecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecycleHolder(getLayoutInflater().inflate(R.layout.activity_recycle_item,null));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 5;
        }
        class RecycleHolder extends RecyclerView.ViewHolder{

            public RecycleHolder(View itemView) {
                super(itemView);
            }
        }
    }
}
