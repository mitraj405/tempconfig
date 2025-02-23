package defpackage;

import android.content.Intent;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import cris.org.in.ima.fragment.TrainDashboardFragment;

/* renamed from: AA  reason: default package and case insensitive filesystem */
/* compiled from: TrainDashboardFragment */
public final class C0447AA implements View.OnTouchListener {
    public final /* synthetic */ TrainDashboardFragment a;

    public C0447AA(TrainDashboardFragment trainDashboardFragment) {
        this.a = trainDashboardFragment;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://contents.irctc.co.in/en/andMobDeal.html")));
        return false;
    }
}
