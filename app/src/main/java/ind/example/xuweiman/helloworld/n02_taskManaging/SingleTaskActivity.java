package ind.example.xuweiman.helloworld.n02_taskManaging;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import ind.example.xuweiman.helloworld.R;

/**
 * SingleTaskActivity 和 SingleTaskActivityB 两个类进行演示
 * 配置 SingleTaskActivityB 为single task ： android:launchMode="singleTask"  -- manifest.xml
 * 代码方式single task启动activity： intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
 * <p>
 * 流程：
 * 任务1： A
 * <p>
 * A -> B(manifest.xml配置默认就是single task):
 * 任务1： A
 * 任务2： B
 * <p>
 * B -> A:
 * 任务1： A
 * 任务2： B -- A
 * <p>
 * A -> B:
 * 任务1： A
 * 任务2： B （A被destroy，B的newIntent被调用）
 * <p>
 * B -> A(single task模式)：
 * 任务1： A （A被destroy，然后，A再一次被创建）
 * 任务2： B
 * -- 备注：如果A activity在manifest.xml中有配置不同的 android:taskAffinity="a.b.c.d"，则预计会有三个任务出现。
 *
 * 注意： 如果没有配置 android:taskAffinity="a.b.c.d" 则B activity不会独立出来一个新的task
 */
public class SingleTaskActivity extends AppCompatActivity {
    private static String TAG = "SingleTaskActivity";
    private Button singleTaskB;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_task);
        singleTaskB = findViewById(R.id.singleTaskBtnB);
        Log.i(TAG, "onCreate Current Task: " + getTaskId());
    }


    @Override
    protected void onStart() {
        super.onStart();

        singleTaskB.setOnClickListener(new View.OnClickListener() { // manifest.xml中已经设置，single task
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SingleTaskActivity.this, SingleTaskActivityB.class);
                intent.putExtra("type", "single task B");
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        if (intent != null) {
            String type = intent.getStringExtra("type");
            Log.i(TAG, "type: " + type);
        }
        Log.i(TAG, "onStart Current Task: " + getTaskId() + " -- " + (++index));
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop -- Current Task: " + getTaskId());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy -- Current Task: " + getTaskId());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i(TAG, "onNewIntent -- Current Task: " + getTaskId());
    }
}
