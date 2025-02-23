package defpackage;

import android.view.View;
import cris.org.in.prs.ima.R;

/* renamed from: VB  reason: default package and case insensitive filesystem */
/* compiled from: Utils */
public final class C0720VB {
    public static void a(View view, int i, C0615Nw nw) {
        C0652Qe qe = new C0652Qe(view, view.getHeight(), i);
        qe.setAnimationListener(nw);
        qe.setDuration(200);
        view.startAnimation(qe);
    }

    public static int b(int i, boolean z) {
        if (i != 17) {
            if (i != 48) {
                if (i != 80) {
                    return -1;
                }
                if (z) {
                    return R.anim.slide_in_bottom;
                }
                return R.anim.slide_out_bottom;
            } else if (z) {
                return R.anim.slide_in_top;
            } else {
                return R.anim.slide_out_top;
            }
        } else if (z) {
            return R.anim.fade_in_center;
        } else {
            return R.anim.fade_out_center;
        }
    }
}
