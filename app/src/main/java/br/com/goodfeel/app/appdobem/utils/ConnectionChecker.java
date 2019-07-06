package br.com.goodfeel.app.appdobem.utils;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.support.design.widget.Snackbar;
import android.view.View;

import br.com.goodfeel.app.appdobem.R;

public class ConnectionChecker {

    private Context context;

    public ConnectionChecker(Context context) {
        this.context = context;
    }

    private boolean deviceIsConnected() {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED || manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            return true;
        } else {
            return false;
        }
    }

    public void promptUser(View rootLayout) {
        if (!deviceIsConnected()) {
            Snackbar connectionSnackbar = Snackbar.make(rootLayout, R.string.connectivity_status, Snackbar.LENGTH_INDEFINITE);

            connectionSnackbar.setAction(R.string.connectivity_status_check, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                }
            });

            connectionSnackbar.show();
        }
    }
}
