package ind.example.xuweiman.helloworld.n02_taskManaging;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import ind.example.xuweiman.helloworld.R;


public class DefaultTaskActivityB extends AppCompatActivity {
    private static String TAG = "DefaultTaskActivityB";
    private Button defaultBtn;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.default_task_activity_b);
        defaultBtn = findViewById(R.id.intentDefaultTaskActivityA);

        defaultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DefaultTaskActivityA.class));
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
