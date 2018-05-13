package ind.example.xuweiman.helloworld.n03_customViews.customTitle;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import ind.example.xuweiman.helloworld.R;

/**
 * 自定义控件，同样使用layout文件进行控件绘制
 * <p>
 * 问题1：如何向自定义空间传递数据？
 */
public class CustomTitleLayout extends LinearLayout {
    public CustomTitleLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.custom_title, this);
        // 可以对控件内的子空间进行默认事件绑定
        Button backBtn = findViewById(R.id.title_back);
        Button editBtn = findViewById(R.id.title_edit);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取触发点击事件context，应该可以是activity或者其他
                ((Activity) getContext()).finish();
            }
        });

        editBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "进入编辑模式", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
