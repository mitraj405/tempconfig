package defpackage;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import com.google.android.gms.common.Scopes;
import com.momagic.C0835h;
import com.paytm.pgsdk.sdknative.LoginActivity;
import cris.org.in.ima.IrctcImaApplication;
import cris.org.in.ima.activities.BookingOtpActivity;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.activities.PinGenerationActivity;
import cris.org.in.ima.activities.UserVerificationActivity;
import cris.org.in.prs.ima.R;
import defpackage.C0614Nv;
import rx.Subscriber;

/* renamed from: i3  reason: default package and case insensitive filesystem */
/* compiled from: BookingOtpActivity */
public final class C1169i3 extends Subscriber<JB> {
    public final /* synthetic */ BookingOtpActivity a;

    public C1169i3(BookingOtpActivity bookingOtpActivity) {
        this.a = bookingOtpActivity;
    }

    public final void onCompleted() {
        int i = BookingOtpActivity.c;
        AlertDialog alertDialog = C0535I5.f3619a;
        this.a.a.dismiss();
    }

    public final void onError(Throwable th) {
        this.a.a.dismiss();
        int i = BookingOtpActivity.c;
        xx.S(th, true, th);
    }

    public final void onNext(Object obj) {
        JB jb = (JB) obj;
        BookingOtpActivity bookingOtpActivity = this.a;
        if (jb == null || jb.getError() != null) {
            C0535I5.m(this.a, false, jb.getError(), bookingOtpActivity.getString(R.string.error), bookingOtpActivity.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            bookingOtpActivity.a.dismiss();
            return;
        }
        C0657Qt.h();
        try {
            bookingOtpActivity.a.dismiss();
            Bw e = Bw.e(bookingOtpActivity.getApplicationContext());
            if (jb.getUserIdHash() != null) {
                try {
                    C1450w1.f7026d = jb.getUserIdHash();
                    String userIdHash = jb.getUserIdHash();
                    C0614Nv.a c = e.f3534a.edit();
                    c.putString("sdflkjl", userIdHash);
                    c.commit();
                    C0835h.k(jb.getUserIdHash());
                } catch (Exception e2) {
                    int i = BookingOtpActivity.c;
                    e2.getMessage();
                }
            }
            String substring = ("USR_DES-" + jb.getGender() + jb.getUserIdHash() + IrctcImaApplication.c).substring(0, 16);
            jb.setUserName(C0535I5.t(jb.getUserName(), substring));
            jb.setEmail(C0535I5.t(jb.getEmail(), substring));
            jb.setMobile(C0535I5.t(jb.getMobile(), substring));
            if (!jb.getVerified().booleanValue()) {
                jb.setDob(C0535I5.t(jb.getDob(), substring));
                Intent intent = new Intent(bookingOtpActivity, UserVerificationActivity.class);
                intent.putExtra(Scopes.EMAIL, jb.getEmail());
                intent.putExtra(LoginActivity.MOBILE_KEY, jb.getMobile());
                intent.putExtra("userName", jb.getUserName());
                intent.putExtra("emailVerified", jb.getEmailVerified());
                intent.putExtra("mobileVerified", jb.getMobileVerified());
                intent.putExtra("gender", jb.getGender());
                intent.putExtra("age", jb.getDob());
                bookingOtpActivity.startActivity(intent);
            } else {
                e.x(jb.getFirstName());
                e.z(jb.getLastName());
                e.D(jb.getEmail());
                e.F(jb.getMobile());
                e.E(jb.getUserId().longValue());
                boolean z = bookingOtpActivity.f4152a;
                C0793b1 b1Var = C0793b1.a;
                if (z) {
                    b1Var.f3909a.b(jb.getUserName(), jb.getTimeStamp());
                    bookingOtpActivity.finish();
                    bookingOtpActivity.startActivity(new Intent(bookingOtpActivity, PinGenerationActivity.class));
                } else if (bookingOtpActivity.b) {
                    Intent intent2 = new Intent(bookingOtpActivity, HomeActivity.class);
                    C0582Li li = b1Var.f3909a;
                    String a2 = li.a(jb.getUserName());
                    if (a2 != null && a2.length() > 0) {
                        intent2.putExtra("last_login", a2);
                    }
                    C0535I5.f3616a.a = jb.getShowLastTxn();
                    C0535I5.f3616a.f3653a = jb.getLastTxnId();
                    C0535I5.f3616a.f3654a = jb.getLastTxnStatus();
                    C0535I5.f3616a.f3655a = jb.getLastTxnTimeStamp();
                    li.b(jb.getUserName(), jb.getTimeStamp());
                    bookingOtpActivity.finish();
                    bookingOtpActivity.startActivity(intent2);
                }
            }
        } catch (Exception e3) {
            int i2 = BookingOtpActivity.c;
            e3.getMessage();
            bookingOtpActivity.a.dismiss();
        }
        int i3 = BookingOtpActivity.c;
    }
}
