package com.anikejain.check_connection;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

public class InternetConnectivity {

    public static boolean isInternetConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        boolean connection_flag = false;
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            connection_flag = true;
        }
        return connection_flag;
    }

    public static void checkConnectionCloseActivity(Context context, int TIME) {
        if (!isInternetConnected(context)) {
            final Handler handler = new Handler(Looper.getMainLooper());
            handler.postDelayed(() -> ((Activity) context).finishAffinity(), TIME);
        }
    }

    public static void checkConnectionCloseActivity(Context context, int TIME, String message) {
        if (!isInternetConnected(context)) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
            final Handler handler = new Handler(Looper.getMainLooper());
            handler.postDelayed(() -> ((Activity) context).finishAffinity(), TIME);
        }
    }
}
