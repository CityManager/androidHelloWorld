package ind.example.xuweiman.helloworld.n02_taskManaging;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import ind.example.xuweiman.helloworld.R;

/**
 * A->B->C , C在栈顶
 * 1. 默认情况下 C重新intent到自己，则 A->B->C->C  存在多个C实例
 * 2. single top 情况下 C重新intent到自己，则 A->B->C 不存在多个C实例，
 *    每次intent自己会在自己的onNewIntent获取到该Intent对象
 *    back键会直接让B到栈顶，而不是c回到先前的状态
 *
 * single top 有两种配置方式：
 * 1. manifest.xml 中为Activity设置属性： android:launchMode="singleTop"
 * 2. Intent中设置标志位： intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
 * 注意： intent.addFlags 能够覆盖manifest.xml的launchMode设置
 */
public class SingleTopActivity extends AppCompatActivity {
    private static String TAG = "SingleTopActivity";
    private Button startSingleTopBtn;
    private Button startNonSingleTopBtn;
    private String ext = "default";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_top_task_activity);
        startNonSingleTopBtn = findViewById(R.id.intentNonSingleTopTaskBtn);
        startSingleTopBtn = findViewById(R.id.intentSingleTopTaskBtn);
        Log.i(TAG, "onCreate " + TAG);
        Intent intent = getIntent();
        if(intent != null) {
            String intentStr = intent.getStringExtra("ext");
            Log.i(TAG, "onCreate " + intentStr);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        startSingleTopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ext = "测试";
                Intent intent = new Intent(getApplicationContext(), SingleTopActivity.class);
                intent.putExtra("ext", ext);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        startNonSingleTopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ext = "测试2";
                Intent intent = new Intent(getApplicationContext(), SingleTopActivity.class);
                intent.putExtra("ext", ext);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String intentStr = intent.getStringExtra("ext");
        Log.i(TAG, intentStr);
        if (ext.equals(intentStr)) {
            Log.i(TAG, "同一个Activity实例");
        } else {
            Log.i(TAG, "不是同一个Activity实例");
        }
    }
}
