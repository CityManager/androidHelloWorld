package ind.example.xuweiman.helloworld.n04_fragment.dynamicFragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import ind.example.xuweiman.helloworld.R;

public class DynamicFragment2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dynamic_fragment_1, container, false);
        Button button = view.findViewById(R.id.dynamic_bottom_fragment_btn);
        button.setText("按钮2");
        TextView textView = view.findViewById(R.id.dynamic_bottom_fragment_text);
        textView.setText("这个是Dynamic Fragment 2");
        return view;
    }
}
