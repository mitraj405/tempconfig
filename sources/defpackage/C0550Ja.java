package defpackage;

import android.content.Intent;
import android.net.Uri;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import cris.org.in.ima.fragment.ErsDisplayFragment;
import cris.org.in.prs.ima.R;

/* renamed from: Ja  reason: default package and case insensitive filesystem */
/* compiled from: ErsDisplayFragment */
public final class C0550Ja extends ClickableSpan {
    public final /* synthetic */ ErsDisplayFragment a;

    public C0550Ja(ErsDisplayFragment ersDisplayFragment) {
        this.a = ersDisplayFragment;
    }

    public final void onClick(View view) {
        ErsDisplayFragment ersDisplayFragment = this.a;
        ersDisplayFragment.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(ersDisplayFragment.getString(R.string.tnc_vikalp))));
    }

    public final void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(true);
    }
}
