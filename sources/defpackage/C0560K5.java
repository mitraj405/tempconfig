package defpackage;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.widget.TextView;
import cris.org.in.ima.model.WrapperAvailablityModel;
import rx.Subscriber;

/* renamed from: K5  reason: default package and case insensitive filesystem */
/* compiled from: CommonUtil */
public final class C0560K5 extends Subscriber<C0549JD> {
    public final /* synthetic */ KD a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ProgressDialog f3673a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Context f3674a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ TextView f3675a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ WrapperAvailablityModel f3676a = null;
    public final /* synthetic */ TextView b;

    public C0560K5(ProgressDialog progressDialog, KD kd, TextView textView, TextView textView2, Context context) {
        this.f3673a = progressDialog;
        this.a = kd;
        this.f3675a = textView;
        this.b = textView2;
        this.f3674a = context;
    }

    public final void onCompleted() {
        AlertDialog alertDialog = C0535I5.f3619a;
    }

    public final void onError(Throwable th) {
        this.f3673a.dismiss();
        AlertDialog alertDialog = C0535I5.f3619a;
        xx.S(th, true, th);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x01e8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onNext(java.lang.Object r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            JD r1 = (defpackage.C0549JD) r1
            java.lang.String r2 = r1.getErrorMessage()
            android.app.ProgressDialog r3 = r0.f3673a
            android.content.Context r4 = r0.f3674a
            if (r2 != 0) goto L_0x0221
            defpackage.C0535I5.f3617a = r1
            KD r2 = r0.a
            defpackage.C0535I5.f3618a = r2
            android.widget.TextView r2 = r0.f3675a
            r5 = 0
            r2.setVisibility(r5)
            android.widget.TextView r2 = r0.b
            r6 = 1
            r2.setEnabled(r6)
            java.lang.String r6 = r1.getPassengerChartStatus()
            java.lang.String r7 = " "
            java.lang.String r8 = "%"
            java.lang.String r9 = "\\."
            r10 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            r12 = 4636737291354636288(0x4059000000000000, double:100.0)
            java.lang.String r14 = ""
            cris.org.in.ima.model.WrapperAvailablityModel r15 = r0.f3676a
            if (r6 != 0) goto L_0x0088
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r14)
            java.lang.Double r1 = r1.getProbability()
            double r16 = r1.doubleValue()
            double r16 = r16 * r12
            double r10 = r16 + r10
            r6.append(r10)
            java.lang.String r1 = r6.toString()
            java.lang.String[] r1 = r1.split(r9)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r1 = r1[r5]
            java.lang.String r1 = defpackage.C0709Uj.j(r6, r1, r8)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            android.content.res.Resources r4 = r4.getResources()
            r6 = 2131952471(0x7f130357, float:1.9541386E38)
            java.lang.String r4 = r4.getString(r6)
            r5.append(r4)
            r5.append(r7)
            r5.append(r1)
            java.lang.String r1 = r5.toString()
            r2.setText(r1)
            if (r15 == 0) goto L_0x021d
            java.lang.CharSequence r1 = r2.getText()
            r1.toString()
            goto L_0x021d
        L_0x0088:
            java.lang.String r5 = r1.getPassengerChartStatus()
            r5.getClass()
            int r6 = r5.hashCode()
            r10 = 2773(0xad5, float:3.886E-42)
            r11 = 2
            if (r6 == r10) goto L_0x00b9
            r10 = 66875(0x1053b, float:9.3712E-41)
            if (r6 == r10) goto L_0x00ae
            r10 = 80884(0x13bf4, float:1.13343E-40)
            if (r6 == r10) goto L_0x00a3
            goto L_0x00c1
        L_0x00a3:
            java.lang.String r6 = "RAC"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x00ac
            goto L_0x00c1
        L_0x00ac:
            r5 = r11
            goto L_0x00c4
        L_0x00ae:
            java.lang.String r6 = "CNF"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x00b7
            goto L_0x00c1
        L_0x00b7:
            r5 = 1
            goto L_0x00c4
        L_0x00b9:
            java.lang.String r6 = "WL"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x00c3
        L_0x00c1:
            r5 = -1
            goto L_0x00c4
        L_0x00c3:
            r5 = 0
        L_0x00c4:
            r6 = 2131099790(0x7f06008e, float:1.7811943E38)
            if (r5 == 0) goto L_0x01e8
            r10 = 1
            if (r5 == r10) goto L_0x018d
            if (r5 == r11) goto L_0x0131
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r14)
            java.lang.Double r1 = r1.getProbability()
            double r10 = r1.doubleValue()
            double r10 = r10 * r12
            r12 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r10 = r10 + r12
            r5.append(r10)
            java.lang.String r1 = r5.toString()
            java.lang.String[] r1 = r1.split(r9)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r9 = 0
            r1 = r1[r9]
            java.lang.String r1 = defpackage.C0709Uj.j(r5, r1, r8)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            android.content.res.Resources r8 = r4.getResources()
            r9 = 2131952471(0x7f130357, float:1.9541386E38)
            java.lang.String r8 = r8.getString(r9)
            r5.append(r8)
            r5.append(r7)
            r5.append(r1)
            java.lang.String r1 = r5.toString()
            r2.setText(r1)
            android.content.res.Resources r1 = r4.getResources()
            int r1 = r1.getColor(r6)
            r2.setTextColor(r1)
            r1 = 1092616192(0x41200000, float:10.0)
            r2.setTextSize(r1)
            if (r15 == 0) goto L_0x021d
            java.lang.CharSequence r1 = r2.getText()
            r1.toString()
            goto L_0x021d
        L_0x0131:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r14)
            java.lang.Double r1 = r1.getProbability()
            double r10 = r1.doubleValue()
            double r10 = r10 * r12
            r12 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r10 = r10 + r12
            r5.append(r10)
            java.lang.String r1 = r5.toString()
            java.lang.String[] r1 = r1.split(r9)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r9 = 0
            r1 = r1[r9]
            java.lang.String r1 = defpackage.C0709Uj.j(r5, r1, r8)
            java.lang.StringBuilder r1 = defpackage.lf.n(r1, r7)
            android.content.res.Resources r5 = r4.getResources()
            r7 = 2131952471(0x7f130357, float:1.9541386E38)
            java.lang.String r5 = r5.getString(r7)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            r2.setText(r1)
            android.content.res.Resources r1 = r4.getResources()
            int r1 = r1.getColor(r6)
            r2.setTextColor(r1)
            r1 = 1092616192(0x41200000, float:10.0)
            r2.setTextSize(r1)
            if (r15 == 0) goto L_0x021d
            java.lang.CharSequence r1 = r2.getText()
            r1.toString()
            goto L_0x021d
        L_0x018d:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r14)
            java.lang.Double r1 = r1.getProbability()
            double r10 = r1.doubleValue()
            double r10 = r10 * r12
            r12 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r10 = r10 + r12
            r5.append(r10)
            java.lang.String r1 = r5.toString()
            java.lang.String[] r1 = r1.split(r9)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r9 = 0
            r1 = r1[r9]
            java.lang.String r1 = defpackage.C0709Uj.j(r5, r1, r8)
            java.lang.StringBuilder r1 = defpackage.lf.n(r1, r7)
            android.content.res.Resources r5 = r4.getResources()
            r7 = 2131952471(0x7f130357, float:1.9541386E38)
            java.lang.String r5 = r5.getString(r7)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            r2.setText(r1)
            android.content.res.Resources r1 = r4.getResources()
            int r1 = r1.getColor(r6)
            r2.setTextColor(r1)
            r1 = 1092616192(0x41200000, float:10.0)
            r2.setTextSize(r1)
            if (r15 == 0) goto L_0x021d
            java.lang.CharSequence r1 = r2.getText()
            r1.toString()
            goto L_0x021d
        L_0x01e8:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r5 = "0% "
            r1.<init>(r5)
            android.content.res.Resources r5 = r4.getResources()
            r7 = 2131952471(0x7f130357, float:1.9541386E38)
            java.lang.String r5 = r5.getString(r7)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            r2.setText(r1)
            android.content.res.Resources r1 = r4.getResources()
            int r1 = r1.getColor(r6)
            r2.setTextColor(r1)
            r1 = 1092616192(0x41200000, float:10.0)
            r2.setTextSize(r1)
            if (r15 == 0) goto L_0x021d
            java.lang.CharSequence r1 = r2.getText()
            r1.toString()
        L_0x021d:
            r3.dismiss()
            goto L_0x023e
        L_0x0221:
            r2 = 0
            defpackage.C0535I5.f3617a = r2
            r3.dismiss()
            android.content.Context r5 = r0.f3674a
            r6 = 1
            java.lang.String r7 = r1.getErrorMessage()
            r8 = 0
            r1 = 2131951928(0x7f130138, float:1.9540284E38)
            java.lang.String r9 = r4.getString(r1)
            r10 = 0
            android.app.AlertDialog r1 = defpackage.C0535I5.m(r5, r6, r7, r8, r9, r10)
            r1.show()
        L_0x023e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0560K5.onNext(java.lang.Object):void");
    }
}
