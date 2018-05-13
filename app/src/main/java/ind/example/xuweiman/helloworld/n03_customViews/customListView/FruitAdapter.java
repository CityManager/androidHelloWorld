package ind.example.xuweiman.helloworld.n03_customViews.customListView;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ind.example.xuweiman.helloworld.R;

public class FruitAdapter extends ArrayAdapter<Fruit> {
    private static String TAG = "FruitAdapter";
    private int resourceId; // 布局资源文件id

    public FruitAdapter(@NonNull Context context, int resource, @NonNull List<Fruit> objects) {
        super(context, resource, objects);
        this.resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        Fruit fruit = getItem(position);
//        View view;
//        if(convertView == null) {
//            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
//        } else {
//            view = convertView;
//        }
//        ImageView imageView = view.findViewById(R.id.custom_list_view_image);
//        TextView textView = view.findViewById(R.id.custom_list_view_text);
//        if(fruit != null) {
//            imageView.setImageResource(fruit.getFruitImageId());
//            textView.setText(fruit.getFruitName());
//        } else {
//            Log.i(TAG, "fruits数据为空");
//        }
//        return view;

        // 下面 利用viewHolder来存储已经获取的控件，相对高效一些
        Fruit fruit = getItem(position);
        View view;
        ViewHolder viewHolder;
        if(convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = view.findViewById(R.id.custom_list_view_image);
            viewHolder.textView = view.findViewById(R.id.custom_list_view_text);
            view.findViewWithTag("a");
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        if(fruit != null) {
            viewHolder.imageView.setImageResource(fruit.getFruitImageId());
            viewHolder.textView.setText(fruit.getFruitName());
        } else {
            Log.i(TAG, "fruits数据为空");
        }
        return view;
    }


    class ViewHolder {
        ImageView imageView;
        TextView textView;
    }
}
