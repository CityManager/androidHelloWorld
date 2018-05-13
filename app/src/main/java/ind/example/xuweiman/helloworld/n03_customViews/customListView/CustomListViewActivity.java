package ind.example.xuweiman.helloworld.n03_customViews.customListView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ind.example.xuweiman.helloworld.R;
import ind.example.xuweiman.helloworld.utils.FruitUtil;

public class CustomListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);
        ListView listview = findViewById(R.id.custom_list_view);
        final List<Fruit> fruits = FruitUtil.initFruitList();
        FruitAdapter fruitAdapter = new FruitAdapter(CustomListViewActivity.this, R.layout.custom_list_view, fruits);
        listview.setAdapter(fruitAdapter);

        // 可以在这里给 ListView的item添加点击事件 setOnItemClickListener 了解一下
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruits.get(position);
                Toast.makeText(getApplicationContext(), fruit.getFruitName(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
