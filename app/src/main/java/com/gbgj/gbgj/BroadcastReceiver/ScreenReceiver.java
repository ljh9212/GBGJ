package com.gbgj.gbgj.BroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.gbgj.gbgj.Activity.LockScreenActivity;

public class ScreenReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

        		if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
        			Intent i = new Intent(context, LockScreenActivity.class);
        			i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        			context.startActivity(i);
        		}
    }
}
