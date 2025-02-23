package defpackage;

import android.content.Intent;
import android.net.Uri;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import cris.org.in.ima.fragment.ERSFragment;

/* renamed from: Q9  reason: default package and case insensitive filesystem */
/* compiled from: ERSFragment */
public final class C0647Q9 extends ClickableSpan {
    public final /* synthetic */ ERSFragment a;

    public C0647Q9(ERSFragment eRSFragment) {
        this.a = eRSFragment;
    }

    public final void onClick(View view) {
        short s;
        C0486Dp dp = new C0486Dp();
        dp.setLocation("CNF_PAGE_LINK");
        ERSFragment eRSFragment = this.a;
        dp.setPnr(eRSFragment.f4548a.getPnrNumber());
        dp.setReservationId(Long.valueOf(Long.parseLong(eRSFragment.f4548a.getReservationId())));
        short s2 = 0;
        if (eRSFragment.f4548a.getNumberOfAdults() == null) {
            s = 0;
        } else {
            s = eRSFragment.f4548a.getNumberOfAdults().shortValue();
        }
        if (eRSFragment.f4548a.getNumberOfChilds() != null) {
            s2 = eRSFragment.f4548a.getNumberOfChilds().shortValue();
        }
        dp.setPsgnCount(Integer.valueOf(s + s2));
        eRSFragment.p(dp);
        eRSFragment.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(C1450w1.f7018b.get("pledgeUrl"))));
    }

    public final void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(true);
    }
}
