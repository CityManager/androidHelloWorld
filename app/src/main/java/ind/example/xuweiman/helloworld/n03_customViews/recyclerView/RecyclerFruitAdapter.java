package ind.example.xuweiman.helloworld.n03_customViews.recyclerView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ind.example.xuweiman.helloworld.R;
import ind.example.xuweiman.helloworld.n03_customViews.customListView.Fruit;

public class RecyclerFruitAdapter extends RecyclerView.Adapter<RecyclerFruitAdapter.ViewHolder> {

    private List<Fruit> fruits;

    public RecyclerFruitAdapter(List<Fruit> fruitList) {
        fruits = fruitList;
    }

    /**
     *
     * @param parent  -- setAdapter 本对象的那个view对象
     * @param viewType -- 不知道
     * @return ViewHolder
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 获取自定义的 组合控件,这整个控件作为 RecyclerView的一个Item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_recycler_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.imageView = view.findViewById(R.id.custom_list_view_image);
        viewHolder.textView = view.findViewById(R.id.custom_list_view_text);
        return viewHolder;
    }

    /**
     * RecyclerView的每一个item出现到屏幕时调用，用于初始化初始化即将显示的那个Item
     * @param holder  ViewHolder
     * @param position 即将显示的item的index
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Fruit fruit = fruits.get(position);
        holder.imageView.setImageResource(fruit.getFruitImageId());
        holder.textView.setText(fruit.getFruitName());
    }

    @Override
    public int getItemCount() {
        return fruits == null ? 0 : fruits.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.custom_list_view_image);
            textView = itemView.findViewById(R.id.custom_list_view_text);
        }
    }
}
