package ind.example.xuweiman.helloworld.n05_broadcast.orderedBroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import ind.example.xuweiman.helloworld.R;

public class OrderedBroadcastActivity extends AppCompatActivity {
    private String order_action = "ind.xwm.example.ORDERED_BROADCAST";
    private int index = 0;
    private OrderReceiver receiver;
    private OrderReceiver receiver1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordered_broadcast);

        receiver = new OrderReceiver(0);
        IntentFilter intentFilter = new IntentFilter(order_action);
        registerReceiver(receiver, intentFilter);

        receiver1 = new OrderReceiver(1);
        IntentFilter intentFilter1 = new IntentFilter(order_action);
        intentFilter1.setPriority(100);
        registerReceiver(receiver1, intentFilter1);

        Button sendBtn = findViewById(R.id.ordered_broadcast_send_btn);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(order_action);
                intent.putExtra("flag", (++index) % 2);
                sendOrderedBroadcast(intent, null);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
        unregisterReceiver(receiver1);
    }

    class OrderReceiver extends BroadcastReceiver {
        private int id;

        public OrderReceiver(int id) {
            this.id = id;
        }

        @Override
        public void onReceive(Context context, Intent intent) {
            int flag = intent.getIntExtra("flag", 0);
            Toast.makeText(context, "OrderReceiver " + id + ", receive msg:" + flag,
                    Toast.LENGTH_SHORT).show();
            if (flag == 1) {
                abortBroadcast();
            }
        }
    }
}
