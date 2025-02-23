package defpackage;

import android.content.Intent;
import android.net.Uri;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import cris.org.in.ima.fragment.VikalpSystemFragment;
import cris.org.in.prs.ima.R;

/* renamed from: fD  reason: default package and case insensitive filesystem */
/* compiled from: VikalpSystemFragment */
public final class C1107fD extends ClickableSpan {
    public final /* synthetic */ VikalpSystemFragment a;

    public C1107fD(VikalpSystemFragment vikalpSystemFragment) {
        this.a = vikalpSystemFragment;
    }

    public final void onClick(View view) {
        VikalpSystemFragment vikalpSystemFragment = this.a;
        vikalpSystemFragment.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(vikalpSystemFragment.getString(R.string.tnc_vikalp))));
    }

    public final void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(true);
    }
}
