package com.anikejain.check_connection;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

public class InternetConnectivity {
    Context context;

    public InternetConnectivity(Context context) {
        this.context = context;
    }

    public static boolean isInternetConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        boolean connection_flag = false;
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            connection_flag = true;
        }
        return connection_flag;
    }

    private void checkConnectionCloseActivity(Context context, int TIME) {
        if (!isInternetConnected(context)) {
            Toast.makeText(context, "Please check your internet connection", Toast.LENGTH_LONG).show();
            final Handler handler = new Handler(Looper.getMainLooper());
            handler.postDelayed(() -> {
                ((Activity)context).finish();
            }, TIME);
        }
    }
}
