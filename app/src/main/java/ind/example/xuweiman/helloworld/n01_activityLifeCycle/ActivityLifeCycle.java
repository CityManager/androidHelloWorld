package ind.example.xuweiman.helloworld.n01_activityLifeCycle;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ind.example.xuweiman.helloworld.R;

public class ActivityLifeCycle extends AppCompatActivity {

    private TextView textView;
    private String myState = "cccc";
    private Button dialogBtn;
    private Button sendBtn;
    private Button selectBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        textView = findViewById(R.id.helloTxt);
        dialogBtn = findViewById(R.id.dialogBtn);
        sendBtn = findViewById(R.id.sendBtn);
        selectBtn = findViewById(R.id.selectBtn);

        if (savedInstanceState != null) {
            myState = savedInstanceState.getString("myState");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        dialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNormalDialog();
            }
        });
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"xuwm3@asiainfo.com"});
                startActivity(intent);
            }
        });

        selectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts/people")), 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println("resultCode:" + resultCode);
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.putExtras(data);
                startActivity(intent);
            }
        }

    }

    private void showNormalDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("测试activity是否会onPause");
        builder.setMessage("情况日志输出");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("onResume");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        textView.setText(savedInstanceState.getString("textView"));
        System.out.println("bbbbbb");
        System.out.println(myState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("textView", "你好");
        outState.putString("myState", "随意保存状态");
        System.out.println("aaaaaa");
    }


}

