package ind.example.xuweiman.helloworld.n05_broadcast.basicBroadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ind.example.xuweiman.helloworld.R;

public class LocalBroadcastActivity extends AppCompatActivity {
    private LocalBroadcastManager broadcastManager;
    private String action = "ind.xwm.example.LOCAL_BROADCAST";
    private InternetStateReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_broadcast);
        broadcastManager = LocalBroadcastManager.getInstance(this);
        receiver = new InternetStateReceiver();
        IntentFilter intentFilter = new IntentFilter(action);
        broadcastManager.registerReceiver(receiver, intentFilter);

        Button sendBtn = findViewById(R.id.local_broadcast_send_btn);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(action);
                broadcastManager.sendBroadcast(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        broadcastManager.unregisterReceiver(receiver);
    }
}
