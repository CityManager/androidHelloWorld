package ind.example.xuweiman.helloworld.n05_broadcast.basicBroadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import ind.example.xuweiman.helloworld.R;


/**
 * 动态注册广播，与发送广播, 注册的广播可以接收安卓全局广播
 * 1. 自定义广播action
 * 2. 实现广播接收器 InternetStateReceiver
 * 3. 注册与解除注册广播接收器（可以在onCreate与onDestroy对应进行，也可以在onResume与onPause之间对应进行）
 */
public class BasicBroadcastActivity extends AppCompatActivity {

    private InternetStateReceiver internetStateReceiver;
    private String basic_broadcast = "ind.example.xuweiman.broadcast.BASIC_BROADCAST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_broadcast);
        internetStateReceiver = new InternetStateReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(basic_broadcast);
        registerReceiver(internetStateReceiver, intentFilter);

        Button sendBtn = findViewById(R.id.basic_broadcast_send_btn);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(basic_broadcast);
                BasicBroadcastActivity.this.sendBroadcast(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(internetStateReceiver);
    }
}
