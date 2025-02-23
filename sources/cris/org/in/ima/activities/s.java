package cris.org.in.ima.activities;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cris.org.in.ima.IrctcImaApplication;
import cris.org.in.prs.ima.R;
import rx.Subscriber;

/* compiled from: LoginActivity */
public final class s extends Subscriber<C1223kn> {
    public final /* synthetic */ LoginActivity a;

    public s(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    public final void onCompleted() {
        int i = LoginActivity.e;
        AlertDialog alertDialog = C0535I5.f3619a;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:10|11) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r3 = cris.org.in.ima.activities.LoginActivity.e;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x003f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onError(java.lang.Throwable r14) {
        /*
            r13 = this;
            java.lang.String r0 = ""
            cris.org.in.ima.activities.LoginActivity r1 = r13.a
            r2 = 2131953888(0x7f1308e0, float:1.954426E38)
            defpackage.C0657Qt.a()     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            android.app.ProgressDialog r3 = r1.a     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            r3.dismiss()     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            int r3 = cris.org.in.ima.activities.LoginActivity.e     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            r14.getClass()     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            r14.getMessage()     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            boolean r3 = r14 instanceof retrofit2.HttpException     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            r4 = 0
            if (r3 == 0) goto L_0x0048
            r3 = r14
            retrofit2.HttpException r3 = (retrofit2.HttpException) r3     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            retrofit2.Response r3 = r3.response()     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            okhttp3.ResponseBody r5 = r3.errorBody()     // Catch:{ Exception -> 0x003f }
            if (r5 == 0) goto L_0x0048
            okhttp3.ResponseBody r3 = r3.errorBody()     // Catch:{ Exception -> 0x003f }
            java.lang.String r3 = r3.string()     // Catch:{ Exception -> 0x003f }
            com.fasterxml.jackson.databind.ObjectMapper r5 = defpackage.C0657Qt.h()     // Catch:{ Exception -> 0x003f }
            java.lang.Class<kn> r6 = defpackage.C1223kn.class
            java.lang.Object r3 = r5.readValue((java.lang.String) r3, r6)     // Catch:{ Exception -> 0x003f }
            kn r3 = (defpackage.C1223kn) r3     // Catch:{ Exception -> 0x003f }
            r4 = r3
            goto L_0x0048
        L_0x003f:
            int r3 = cris.org.in.ima.activities.LoginActivity.e     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            goto L_0x0048
        L_0x0042:
            r14 = move-exception
            goto L_0x010b
        L_0x0045:
            r14 = move-exception
            goto L_0x011f
        L_0x0048:
            java.lang.String r3 = r14.getMessage()     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            java.lang.String r5 = "400"
            boolean r3 = r3.contains(r5)     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            if (r3 == 0) goto L_0x0064
            android.content.Context r14 = r1.getBaseContext()     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            r0 = 2131953483(0x7f13074b, float:1.9543438E38)
            java.lang.String r0 = r1.getString(r0)     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            defpackage.C0535I5.t0(r14, r0)     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            goto L_0x0132
        L_0x0064:
            java.lang.String r14 = r14.getMessage()     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            boolean r14 = r14.contains(r0)     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            if (r14 == 0) goto L_0x00fc
            if (r4 == 0) goto L_0x00fc
            java.lang.String r14 = r4.getError_description()     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            boolean r3 = r1.isFinishing()     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            if (r3 != 0) goto L_0x0132
            java.lang.String r3 = "Bad credentials"
            boolean r3 = r14.equalsIgnoreCase(r3)     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            r5 = 2131951928(0x7f130138, float:1.9540284E38)
            r6 = 2131952688(0x7f130430, float:1.9541826E38)
            if (r3 == 0) goto L_0x00a4
            cris.org.in.ima.activities.LoginActivity r7 = r13.a     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            r8 = 0
            r14 = 2131953472(0x7f130740, float:1.9543416E38)
            java.lang.String r9 = r7.getString(r14)     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            java.lang.String r10 = r1.getString(r6)     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            java.lang.String r11 = r1.getString(r5)     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            r12 = 0
            android.app.AlertDialog r14 = defpackage.C0535I5.m(r7, r8, r9, r10, r11, r12)     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            r14.show()     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            goto L_0x0132
        L_0x00a4:
            java.lang.String r3 = r4.getErrorMessage()     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            if (r3 == 0) goto L_0x00da
            cris.org.in.ima.activities.LoginActivity r7 = r13.a     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            r8 = 0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            r0.<init>()     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            java.lang.String r3 = r4.getErrorMessage()     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            java.lang.String r3 = r3.toUpperCase()     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            r0.append(r3)     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            java.lang.String r3 = " : "
            r0.append(r3)     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            r0.append(r14)     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            java.lang.String r9 = r0.toString()     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            java.lang.String r10 = r1.getString(r6)     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            java.lang.String r11 = r1.getString(r5)     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            r12 = 0
            android.app.AlertDialog r14 = defpackage.C0535I5.m(r7, r8, r9, r10, r11, r12)     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            r14.show()     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            goto L_0x0132
        L_0x00da:
            cris.org.in.ima.activities.LoginActivity r3 = r13.a     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            r4 = 0
            boolean r0 = r14.equals(r0)     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            if (r0 == 0) goto L_0x00ea
            r14 = 2131952934(0x7f130526, float:1.9542325E38)
            java.lang.String r14 = r1.getString(r14)     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
        L_0x00ea:
            java.lang.String r6 = r1.getString(r6)     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            java.lang.String r7 = r1.getString(r5)     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            r8 = 0
            r5 = r14
            android.app.AlertDialog r14 = defpackage.C0535I5.m(r3, r4, r5, r6, r7, r8)     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            r14.show()     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            goto L_0x0132
        L_0x00fc:
            android.content.Context r14 = r1.getBaseContext()     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            r0 = 2131952536(0x7f130398, float:1.9541518E38)
            java.lang.String r0 = r1.getString(r0)     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            defpackage.C0535I5.t0(r14, r0)     // Catch:{ IllegalStateException -> 0x0045, Exception -> 0x0042 }
            goto L_0x0132
        L_0x010b:
            int r0 = cris.org.in.ima.activities.LoginActivity.e
            r14.getMessage()
            android.content.Context r14 = r1.getBaseContext()
            java.lang.String r0 = r1.getString(r2)
            defpackage.C0535I5.t0(r14, r0)
            r1.finish()
            goto L_0x0132
        L_0x011f:
            int r0 = cris.org.in.ima.activities.LoginActivity.e
            r14.getMessage()
            android.content.Context r14 = r1.getBaseContext()
            java.lang.String r0 = r1.getString(r2)
            defpackage.C0535I5.t0(r14, r0)
            r1.finish()
        L_0x0132:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.activities.s.onError(java.lang.Throwable):void");
    }

    public final void onNext(Object obj) {
        String error_description;
        C1223kn knVar = (C1223kn) obj;
        LoginActivity loginActivity = this.a;
        loginActivity.a.dismiss();
        int i = LoginActivity.e;
        knVar.toString();
        if (knVar.getError_description() != null) {
            if (knVar.getError_description().equalsIgnoreCase("Bad credentials")) {
                error_description = loginActivity.getString(R.string.please_enter_username_pass);
            } else if (knVar.getError_description().contains("Access denied")) {
                error_description = loginActivity.getString(R.string.access_denied);
            } else {
                error_description = knVar.getError_description();
            }
            C0535I5.m(loginActivity, false, error_description, loginActivity.getString(R.string.error), loginActivity.getString(R.string.OK), new r(this, knVar)).show();
            return;
        }
        loginActivity.f4209a.f3912a = knVar;
        int i2 = C1507z0.a;
        Bundle bundle = new Bundle();
        bundle.putString("login_method", "token");
        IrctcImaApplication.f4146a.logEvent("logins", bundle);
        loginActivity.f4209a.f3912a.toString();
        Bw e = Bw.e(loginActivity.getApplicationContext());
        if (!TextUtils.isEmpty(knVar.getAccess_token())) {
            e.A((String) null);
            e.C((String) null);
            e.B((String) null);
            e.F((String) null);
            e.x((String) null);
            e.z((String) null);
            e.D((String) null);
            e.E(-1);
            e.A(loginActivity.f4222e);
            e.B(loginActivity.f);
            if (!loginActivity.bookingWithOtp.isChecked()) {
                loginActivity.bookingWithOtp.setChecked(false);
                loginActivity.h = "N";
                C0535I5.f3620a = "N";
            } else {
                loginActivity.bookingWithOtp.setChecked(true);
                loginActivity.h = "OTP";
                C0535I5.f3620a = "OTP";
            }
        }
        Intent intent = new Intent(loginActivity, LoginWaitActivity.class);
        intent.putExtra("fromLoginActivity", true);
        intent.putExtra("isDashBoardLanding", loginActivity.c);
        loginActivity.finish();
        loginActivity.startActivity(intent);
    }
}
