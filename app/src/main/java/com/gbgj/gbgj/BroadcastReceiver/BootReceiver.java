package com.gbgj.gbgj.BroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.gbgj.gbgj.Service.ScreenService;

import java.nio.channels.InterruptedByTimeoutException;

public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

        if(intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)){
            Intent i = new Intent(context, ScreenService.class);
            context.startService(i);
        }
    }
}
