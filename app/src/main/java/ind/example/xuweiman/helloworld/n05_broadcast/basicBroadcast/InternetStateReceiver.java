package ind.example.xuweiman.helloworld.n05_broadcast.basicBroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class InternetStateReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (manager != null) {
            NetworkInfo info = manager.getActiveNetworkInfo();
            if (info != null && info.isAvailable()) {
                Toast.makeText(context, "网络可用", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(context, "网络不可用", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(context, "无法获取设备状态", Toast.LENGTH_LONG).show();
        }
    }

}
