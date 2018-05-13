package ind.example.xuweiman.helloworld.n03_customViews.basicListView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import ind.example.xuweiman.helloworld.R;

public class BasicListViewActivity extends AppCompatActivity {

    private String[] data = {
            "Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape",
            "Pineapple", "Strawberry", "Cherry", "Mango",
            "Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape",
            "Pineapple", "Strawberry", "Cherry", "Mango"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_list_view);
        ListView listView = findViewById(R.id.basic_list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(BasicListViewActivity.this,
                android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapter);
    }
}
