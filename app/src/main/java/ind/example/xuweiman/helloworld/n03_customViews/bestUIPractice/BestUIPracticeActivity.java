package ind.example.xuweiman.helloworld.n03_customViews.bestUIPractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import ind.example.xuweiman.helloworld.R;
import ind.example.xuweiman.helloworld.utils.MsgUtil;

public class BestUIPracticeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best_uipractice);
        final List<Msg> msgList = MsgUtil.initMsgList();
        final RecyclerView recyclerView = findViewById(R.id.msg_recycler_view);
        final MsgAdapter msgAdapter = new MsgAdapter(msgList, R.layout.msg_item);
        recyclerView.setAdapter(msgAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        final EditText editText = findViewById(R.id.msg_input_text);
        Button sendBtn = findViewById(R.id.msg_send_btn);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = editText.getText().toString();
                if(!"".equals(content)) {
                    editText.setText("");

                    Msg msg = new Msg(content, Msg.TYPE_SEND);
                    msgList.add(msg);

                    // 通知view更新与通知滚到到最后一行
                    msgAdapter.notifyItemInserted(msgList.size() - 1);
                    recyclerView.scrollToPosition(msgList.size() - 1);
                }
            }
        });
    }
}
