package ind.example.xuweiman.helloworld.n02_taskManaging;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import ind.example.xuweiman.helloworld.R;

/**
 * 默认情况：
 * 1. activity 支持多次实例化进行入栈
 * 2. back键出栈时会多次回到相同的页面（但是实例时不同的）
 */
public class DefaultTaskActivityA extends AppCompatActivity {
    private static String TAG = "DefaultTaskActivityA";
    private Context context;
    private Button defaultBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.default_task_activity_a);
        defaultBtn = findViewById(R.id.intentDefaultTaskActivityB);
        context = this;

        defaultBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, DefaultTaskActivityB.class));
            }
        });
        Log.i(TAG, "onCreate " + TAG);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume " + TAG);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i(TAG, "onNewIntent "+ TAG);
    }
}
