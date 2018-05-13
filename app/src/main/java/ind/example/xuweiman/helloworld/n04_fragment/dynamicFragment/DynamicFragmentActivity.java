package ind.example.xuweiman.helloworld.n04_fragment.dynamicFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;

import ind.example.xuweiman.helloworld.R;

public class DynamicFragmentActivity extends AppCompatActivity {

    private SparseArray<Fragment> fragmentMap = new SparseArray<>();
    private Fragment currentFragment;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);
        Button button = findViewById(R.id.basic_fragment_btn);

        fragmentMap.put(0, new DynamicFragment1());
        fragmentMap.put(1, new DynamicFragment2());
        replaceFragment(index);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment((++index) % 2);
            }
        });
    }

    private void replaceFragment(int position) {
        Fragment fragment = fragmentMap.get(position);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (fragment.isAdded()) {
            transaction.hide(currentFragment).show(fragment);
        } else if (currentFragment != null) {
            transaction.hide(currentFragment);
            transaction.add(R.id.dynamic_bottom_frame_layout, fragment, "fragment" + position);
        } else {
            transaction.add(R.id.dynamic_bottom_frame_layout, fragment, "fragment" + position);
        }
        transaction.addToBackStack(null); // 将fragment加入到返回栈中,应该归属到返回栈中本activity中
        transaction.commit();
        currentFragment = fragment;
    }
}
