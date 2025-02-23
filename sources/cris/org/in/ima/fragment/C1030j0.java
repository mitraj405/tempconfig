package cris.org.in.ima.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import cris.org.in.ima.fragment.ReviewAndPayFragment;

/* renamed from: cris.org.in.ima.fragment.j0  reason: case insensitive filesystem */
/* compiled from: ReviewAndPayFragment */
public final class C1030j0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ E4 a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ReviewAndPayFragment.k.a f5238a;

    public C1030j0(ReviewAndPayFragment.k.a aVar, E4 e4) {
        this.f5238a = aVar;
        this.a = e4;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        try {
            AlertDialog alertDialog = C0535I5.f3619a;
            ReviewAndPayFragment reviewAndPayFragment = ReviewAndPayFragment.this;
            if (10 == reviewAndPayFragment.c) {
                reviewAndPayFragment.q(this.a.getCaptchaQuestion());
            } else {
                reviewAndPayFragment.otpInput.setText("");
            }
        } catch (Exception e) {
            String str = ReviewAndPayFragment.x;
            e.getMessage();
        }
    }
}
