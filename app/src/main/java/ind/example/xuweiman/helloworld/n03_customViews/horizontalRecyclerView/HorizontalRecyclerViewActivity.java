package ind.example.xuweiman.helloworld.n03_customViews.horizontalRecyclerView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.List;

import ind.example.xuweiman.helloworld.R;
import ind.example.xuweiman.helloworld.n03_customViews.customListView.Fruit;
import ind.example.xuweiman.helloworld.utils.FruitUtil;

public class HorizontalRecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_recycler_view);
        List<Fruit> fruitList = FruitUtil.initFruitList();
        RecyclerView recyclerView = findViewById(R.id.recycle_view);
        HorizontalRecyclerFruitAdapter adapter = new HorizontalRecyclerFruitAdapter(fruitList, R.layout.custom_horizontal_recycler_view);
        recyclerView.setAdapter(adapter);

        // 配置水平滚动
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        recyclerView.setLayoutManager(layoutManager);

        // 配置瀑布流布局
        StaggeredGridLayoutManager layoutManager1 = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager1);
    }
}
