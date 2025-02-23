package cris.org.in.ima;

import android.content.DialogInterface;
import cris.org.in.ima.FeedbackActivity;

/* compiled from: FeedbackActivity */
public final class a implements DialogInterface.OnClickListener {
    public final /* synthetic */ FeedbackActivity.h.c a;

    public a(FeedbackActivity.h.c cVar) {
        this.a = cVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        FeedbackActivity.this.finish();
    }
}
