package ind.example.xuweiman.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;
import java.util.Map;

import ind.example.xuweiman.helloworld.n01_activityLifeCycle.ActivityLifeCycle;
import ind.example.xuweiman.helloworld.n02_taskManaging.DefaultTaskActivityA;
import ind.example.xuweiman.helloworld.n02_taskManaging.SingleTaskActivity;
import ind.example.xuweiman.helloworld.n02_taskManaging.SingleTopActivity;
import ind.example.xuweiman.helloworld.n03_customViews.basicListView.BasicListViewActivity;
import ind.example.xuweiman.helloworld.n03_customViews.bestUIPractice.BestUIPracticeActivity;
import ind.example.xuweiman.helloworld.n03_customViews.customListView.CustomListViewActivity;
import ind.example.xuweiman.helloworld.n03_customViews.customTitle.CustomTitleActivity;
import ind.example.xuweiman.helloworld.n03_customViews.horizontalRecyclerView.HorizontalRecyclerViewActivity;
import ind.example.xuweiman.helloworld.n03_customViews.recyclerView.RecyclerViewActivity;
import ind.example.xuweiman.helloworld.n04_fragment.basicFragment.BasicFragmentActivity;
import ind.example.xuweiman.helloworld.n04_fragment.dynamicFragment.DynamicFragmentActivity;

public class MainActivity extends AppCompatActivity {

    private Map<Button, Intent> btnMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMap.put((Button) findViewById(R.id.learnActivityLifeCycleBtn),
                new Intent(getApplicationContext(), ActivityLifeCycle.class));
        btnMap.put((Button) findViewById(R.id.learnDefaultTaskActivityBtn),
                new Intent(getApplicationContext(), DefaultTaskActivityA.class));
        btnMap.put((Button) findViewById(R.id.learnSingleTopTaskActivityBtn),
                new Intent(getApplicationContext(), SingleTopActivity.class));

        btnMap.put((Button) findViewById(R.id.learnSingleTaskActivityBtn),
                new Intent(getApplicationContext(), SingleTaskActivity.class));

        btnMap.put((Button) findViewById(R.id.learnCustomViewTitle),
                new Intent(getApplicationContext(), CustomTitleActivity.class));

        btnMap.put((Button) findViewById(R.id.learnCustomViewBasicListView),
                new Intent(getApplicationContext(), BasicListViewActivity.class));
        btnMap.put((Button) findViewById(R.id.learnCustomListView),
                new Intent(getApplicationContext(), CustomListViewActivity.class));
        btnMap.put((Button) findViewById(R.id.learnCustomRecyclerView),
                new Intent(getApplicationContext(), RecyclerViewActivity.class));
        btnMap.put((Button) findViewById(R.id.learnCustomHorizontalRecyclerView),
                new Intent(getApplicationContext(), HorizontalRecyclerViewActivity.class));
        btnMap.put((Button)findViewById(R.id.learnBestUIPractice),
                new Intent(getApplicationContext(), BestUIPracticeActivity.class));

        btnMap.put((Button) findViewById(R.id.learnBasicFragment),
                new Intent(getApplicationContext(), BasicFragmentActivity.class));

        btnMap.put((Button) findViewById(R.id.learnDynamicFragment),
                new Intent(getApplicationContext(), DynamicFragmentActivity.class));
    }

    @Override
    protected void onStart() {
        super.onStart();
        for (Map.Entry<Button, Intent> entry : btnMap.entrySet()) {
            Button button = entry.getKey();
            final Intent intent = entry.getValue();
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(intent);
                }
            });
        }
    }
}
