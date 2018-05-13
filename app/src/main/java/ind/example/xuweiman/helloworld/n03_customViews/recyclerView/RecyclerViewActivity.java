package ind.example.xuweiman.helloworld.n03_customViews.recyclerView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import ind.example.xuweiman.helloworld.R;
import ind.example.xuweiman.helloworld.n03_customViews.customListView.Fruit;
import ind.example.xuweiman.helloworld.utils.FruitUtil;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        List<Fruit> fruitList = FruitUtil.initFruitList();
        RecyclerView recyclerView = findViewById(R.id.recycle_view);
        RecyclerFruitAdapter adapter = new RecyclerFruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);

        // RecyclerView 自己内部时没有默认布局配置的，需要我们手工设置
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }
}
