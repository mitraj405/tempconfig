package cris.org.in.ima.activities;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import cris.org.in.ima.activities.IRCTCConnectActivity;
import cris.org.in.prs.ima.R;

/* renamed from: cris.org.in.ima.activities.b  reason: case insensitive filesystem */
/* compiled from: IRCTCConnectActivity */
public final class C0845b implements DialogInterface.OnClickListener {
    public final /* synthetic */ Oy a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ IRCTCConnectActivity.e f4375a;

    /* renamed from: cris.org.in.ima.activities.b$a */
    /* compiled from: IRCTCConnectActivity */
    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            C0845b bVar = C0845b.this;
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

    /* renamed from: cris.org.in.ima.activities.b$b  reason: collision with other inner class name */
    /* compiled from: IRCTCConnectActivity */
    public class C0057b implements DialogInterface.OnClickListener {
        public C0057b() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            C0845b bVar = C0845b.this;
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

    /* renamed from: cris.org.in.ima.activities.b$c */
    /* compiled from: IRCTCConnectActivity */
    public class c implements DialogInterface.OnClickListener {
        public c() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            IRCTCConnectActivity.m(IRCTCConnectActivity.this);
        }
    }

    public C0845b(IRCTCConnectActivity.e eVar, Oy oy) {
        this.f4375a = eVar;
        this.a = oy;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        C1450w1.f7010a.clear();
        Oy oy = this.a;
        C1450w1.f7010a = oy.getDisableRange();
        IRCTCConnectActivity.e eVar = this.f4375a;
        C1450w1.f7023c = IRCTCConnectActivity.l(IRCTCConnectActivity.this, oy.getDisableRange());
        C1450w1.f7008a = oy.getJuspayLoadDTO();
        if (oy.getJuspayLoadDTO() != null) {
            C0535I5.f3649j = true;
        }
        if (oy.getForceUpdate().booleanValue()) {
            dialogInterface.dismiss();
            C0535I5.p(IRCTCConnectActivity.this, false, oy.getInfoMsg().get(0), IRCTCConnectActivity.this.getString(R.string.upgrade_information), IRCTCConnectActivity.this.getString(R.string.upgrade), new a(), (String) null, (DialogInterface.OnClickListener) null).show();
        } else if (oy.getUpdateRequired().booleanValue()) {
            dialogInterface.dismiss();
            C0535I5.p(IRCTCConnectActivity.this, false, oy.getInfoMsg().get(0), IRCTCConnectActivity.this.getString(R.string.upgrade_information), IRCTCConnectActivity.this.getString(R.string.upgrade), new C0057b(), IRCTCConnectActivity.this.getString(R.string.no_thanks), new c()).show();
        } else {
            dialogInterface.dismiss();
            IRCTCConnectActivity.m(IRCTCConnectActivity.this);
        }
    }
}
