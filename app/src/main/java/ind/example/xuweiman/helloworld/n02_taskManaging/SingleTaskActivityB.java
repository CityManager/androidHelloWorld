package ind.example.xuweiman.helloworld.n02_taskManaging;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import ind.example.xuweiman.helloworld.R;

public class SingleTaskActivityB extends AppCompatActivity {
    private static String TAG = "SingleTaskActivityB";
    private Button singleTaskC;
    private Button singleTaskD;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_task_b);
        Log.i(TAG, "onCreate Current Task: " + getTaskId());
        singleTaskC = findViewById(R.id.singleTaskBtnC);
        singleTaskD = findViewById(R.id.singleTaskBtnD);
    }

    @Override
    protected void onStart() {
        super.onStart();
        singleTaskC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SingleTaskActivityB.this, SingleTaskActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("type", "single task A");
                startActivity(intent);
            }
        });

        singleTaskD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SingleTaskActivityB.this, SingleTaskActivity.class);
                intent.putExtra("type", "not single task A");
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        if(intent != null) {
            Log.i(TAG, "onStart Current Task: " + getTaskId());
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
