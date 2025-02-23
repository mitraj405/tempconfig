package cris.org.in.ima.activities;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import cris.org.in.ima.activities.IRCTCConnectActivity;

/* renamed from: cris.org.in.ima.activities.d  reason: case insensitive filesystem */
/* compiled from: IRCTCConnectActivity */
public final class C0847d implements DialogInterface.OnClickListener {
    public final /* synthetic */ IRCTCConnectActivity.e a;

    public C0847d(IRCTCConnectActivity.e eVar) {
        this.a = eVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        IRCTCConnectActivity.e eVar = this.a;
        String packageName = IRCTCConnectActivity.this.getPackageName();
        try {
            IRCTCConnectActivity iRCTCConnectActivity = IRCTCConnectActivity.this;
            iRCTCConnectActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName)));
        } catch (ActivityNotFoundException e) {
            int i2 = IRCTCConnectActivity.d;
            e.getMessage();
            IRCTCConnectActivity iRCTCConnectActivity2 = IRCTCConnectActivity.this;
            iRCTCConnectActivity2.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + packageName)));
        }
    }
}
