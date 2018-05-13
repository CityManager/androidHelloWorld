package ind.example.xuweiman.helloworld.n03_customViews.bestUIPractice;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import ind.example.xuweiman.helloworld.R;

public class MsgAdapter extends RecyclerView.Adapter {
    private List<Msg> msgList;
    private int resourceId;

    public MsgAdapter(List<Msg> msgs, int resourceId) {
        this.msgList = msgs;
        this.resourceId = resourceId;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resourceId, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.receiveLayout = view.findViewById(R.id.left_layout);
        viewHolder.receiveTextView = view.findViewById(R.id.left_msg);
        viewHolder.sendLayout = view.findViewById(R.id.right_layout);
        viewHolder.sendTextView = view.findViewById(R.id.right_msg);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Msg msg = msgList.get(position);
        ViewHolder vh = (ViewHolder)holder;
        if(msg != null) {
            if(msg.getType() == Msg.TYPE_RECEIVED) {
                vh.receiveLayout.setVisibility(View.VISIBLE);
                vh.receiveTextView.setText(msg.getContent());
                vh.sendLayout.setVisibility(View.GONE);
            } else if(msg.getType() == Msg.TYPE_SEND) {
                vh.receiveLayout.setVisibility(View.GONE);
                vh.sendLayout.setVisibility(View.VISIBLE);
                vh.sendTextView.setText(msg.getContent());
            } else {
                holder.itemView.setVisibility(View.GONE);
            }
        } else {
            holder.itemView.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return msgList == null ? 0 : msgList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout receiveLayout;
        TextView receiveTextView;
        LinearLayout sendLayout;
        TextView sendTextView;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
