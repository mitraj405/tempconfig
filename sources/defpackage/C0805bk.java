package defpackage;

import android.content.DialogInterface;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.fragment.MakePaymentNewFragment;
import in.juspay.hypersdk.ui.HyperPaymentsCallbackAdapter;

/* renamed from: bk  reason: default package and case insensitive filesystem */
/* compiled from: MakePaymentNewFragment */
public final class C0805bk extends HyperPaymentsCallbackAdapter {
    public final /* synthetic */ MakePaymentNewFragment a;

    /* renamed from: bk$a */
    /* compiled from: MakePaymentNewFragment */
    public class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ String c;

        public a(String str) {
            this.c = str;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            C0805bk bkVar = C0805bk.this;
            C0535I5.W(this.c, false, bkVar.a.f4771a, (String) null, (String) null);
            HomeActivity.B(bkVar.a.getActivity());
        }
    }

    /* renamed from: bk$b */
    /* compiled from: MakePaymentNewFragment */
    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            C0805bk bkVar = C0805bk.this;
            C0535I5.W("pending_vbv", false, bkVar.a.f4771a, (String) null, (String) null);
            HomeActivity.B(bkVar.a.getActivity());
            C0793b1.a.f3912a = null;
        }
    }

    /* renamed from: bk$c */
    /* compiled from: MakePaymentNewFragment */
    public class c implements DialogInterface.OnClickListener {
        public c() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            C0805bk bkVar = C0805bk.this;
            C0535I5.W("pending_vbv", false, bkVar.a.f4771a, (String) null, (String) null);
            HomeActivity.B(bkVar.a.getActivity());
        }
    }

    public C0805bk(MakePaymentNewFragment makePaymentNewFragment) {
        this.a = makePaymentNewFragment;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0197, code lost:
        r9 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0198, code lost:
        if (r9 == 0) goto L_0x01d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x019a, code lost:
        if (r9 == 2) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x019d, code lost:
        if (r9 == 3) goto L_0x01c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x01a0, code lost:
        if (r9 == 4) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x01a3, code lost:
        defpackage.C0535I5.m(r3.getContext(), true, r3.getString(cris.org.in.prs.ima.R.string.juspay_pending_msg), "Juspayerror", r3.getString(cris.org.in.prs.ima.R.string.OK), new defpackage.C0805bk.c(r1)).show();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x01c5, code lost:
        cris.org.in.ima.activities.HomeActivity.B(r3.getActivity());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x01cd, code lost:
        cris.org.in.ima.activities.HomeActivity.C(r3.getActivity());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x01d5, code lost:
        cris.org.in.ima.activities.HomeActivity.B(r3.getActivity());
     */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0282 A[Catch:{ Exception -> 0x011e }] */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x02a2 A[Catch:{ Exception -> 0x011e }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c6 A[SYNTHETIC, Splitter:B:51:0x00c6] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00e8 A[Catch:{ Exception -> 0x011e }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x010f A[Catch:{ Exception -> 0x011e }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0130 A[Catch:{ Exception -> 0x011e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onEvent(org.json.JSONObject r23, in.juspay.hypersdk.data.JuspayResponseHandler r24) {
        /*
            r22 = this;
            r1 = r22
            r0 = r23
            java.lang.String r2 = "Invalid bankID."
            cris.org.in.ima.fragment.MakePaymentNewFragment r3 = r1.a
            r6 = 1
            java.lang.String r7 = "event"
            java.lang.String r7 = r0.getString(r7)     // Catch:{ Exception -> 0x011e }
            int r8 = r7.hashCode()     // Catch:{ Exception -> 0x011e }
            r10 = 3
            r11 = 4
            r13 = 2
            switch(r8) {
                case -1870252837: goto L_0x0042;
                case -1670904345: goto L_0x0038;
                case -174112336: goto L_0x002e;
                case 24468461: goto L_0x0024;
                case 462997423: goto L_0x001a;
                default: goto L_0x0019;
            }     // Catch:{ Exception -> 0x011e }
        L_0x0019:
            goto L_0x004c
        L_0x001a:
            java.lang.String r8 = "sessionExpired"
            boolean r8 = r7.equals(r8)     // Catch:{ Exception -> 0x011e }
            if (r8 == 0) goto L_0x004c
            r8 = r13
            goto L_0x004d
        L_0x0024:
            java.lang.String r8 = "process_result"
            boolean r8 = r7.equals(r8)     // Catch:{ Exception -> 0x011e }
            if (r8 == 0) goto L_0x004c
            r8 = r11
            goto L_0x004d
        L_0x002e:
            java.lang.String r8 = "hide_loader"
            boolean r8 = r7.equals(r8)     // Catch:{ Exception -> 0x011e }
            if (r8 == 0) goto L_0x004c
            r8 = 0
            goto L_0x004d
        L_0x0038:
            java.lang.String r8 = "paymentAttempt"
            boolean r8 = r7.equals(r8)     // Catch:{ Exception -> 0x011e }
            if (r8 == 0) goto L_0x004c
            r8 = r10
            goto L_0x004d
        L_0x0042:
            java.lang.String r8 = "log_stream"
            boolean r8 = r7.equals(r8)     // Catch:{ Exception -> 0x011e }
            if (r8 == 0) goto L_0x004c
            r8 = r6
            goto L_0x004d
        L_0x004c:
            r8 = -1
        L_0x004d:
            if (r8 == 0) goto L_0x02e4
            if (r8 == r13) goto L_0x02c6
            java.lang.String r15 = "payload"
            if (r8 == r10) goto L_0x020e
            if (r8 == r11) goto L_0x0059
            goto L_0x0317
        L_0x0059:
            java.lang.String r2 = "error"
            r0.optBoolean(r2)     // Catch:{ Exception -> 0x011e }
            org.json.JSONObject r2 = r0.optJSONObject(r15)     // Catch:{ Exception -> 0x011e }
            if (r2 == 0) goto L_0x006b
            java.lang.String r8 = "status"
            java.lang.String r2 = r2.optString(r8)     // Catch:{ Exception -> 0x011e }
            goto L_0x006c
        L_0x006b:
            r2 = 0
        L_0x006c:
            java.lang.String r8 = "errorCode"
            java.lang.String r8 = r0.optString(r8)     // Catch:{ Exception -> 0x011e }
            java.lang.String r15 = "errorMessage"
            java.lang.String r15 = r0.optString(r15)     // Catch:{ Exception -> 0x011e }
            if (r15 == 0) goto L_0x009c
            java.lang.String r15 = r15.trim()     // Catch:{ Exception -> 0x011e }
            int r15 = r15.length()     // Catch:{ Exception -> 0x011e }
            if (r15 <= 0) goto L_0x009c
            android.content.Context r15 = r3.getContext()     // Catch:{ Exception -> 0x011e }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011e }
            r9.<init>()     // Catch:{ Exception -> 0x011e }
            r9.append(r8)     // Catch:{ Exception -> 0x011e }
            java.lang.String r5 = " - "
            r9.append(r5)     // Catch:{ Exception -> 0x011e }
            java.lang.String r5 = r9.toString()     // Catch:{ Exception -> 0x011e }
            defpackage.C0535I5.t0(r15, r5)     // Catch:{ Exception -> 0x011e }
        L_0x009c:
            java.lang.String r5 = "JP_006"
            java.lang.String r9 = "JP_002"
            if (r8 == 0) goto L_0x00b8
            java.lang.String r15 = "JP_000"
            boolean r15 = r8.equalsIgnoreCase(r15)     // Catch:{ Exception -> 0x011e }
            if (r15 != 0) goto L_0x00b6
            boolean r15 = r8.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x011e }
            if (r15 != 0) goto L_0x00b6
            boolean r15 = r8.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x011e }
            if (r15 == 0) goto L_0x00b8
        L_0x00b6:
            r15 = r6
            goto L_0x00b9
        L_0x00b8:
            r15 = 0
        L_0x00b9:
            r7 = 2131952989(0x7f13055d, float:1.9542436E38)
            java.lang.String r14 = "pending_vbv"
            java.lang.String r12 = "backpressed"
            java.lang.String r11 = "ABORT"
            java.lang.String r10 = "user_aborted"
            if (r15 == 0) goto L_0x0130
            int r13 = r8.hashCode()     // Catch:{ Exception -> 0x011e }
            r4 = -2099650631(0xffffffff82d9dfb9, float:-3.2013695E-37)
            if (r13 == r4) goto L_0x00dd
            r4 = -2099650627(0xffffffff82d9dfbd, float:-3.2013704E-37)
            if (r13 == r4) goto L_0x00d5
            goto L_0x00e5
        L_0x00d5:
            boolean r4 = r8.equals(r5)     // Catch:{ Exception -> 0x011e }
            if (r4 == 0) goto L_0x00e5
            r9 = r6
            goto L_0x00e6
        L_0x00dd:
            boolean r4 = r8.equals(r9)     // Catch:{ Exception -> 0x011e }
            if (r4 == 0) goto L_0x00e5
            r9 = 0
            goto L_0x00e6
        L_0x00e5:
            r9 = -1
        L_0x00e6:
            if (r9 == 0) goto L_0x010f
            if (r9 == r6) goto L_0x00ec
            goto L_0x01dc
        L_0x00ec:
            android.content.Context r16 = r3.getContext()     // Catch:{ Exception -> 0x011e }
            r17 = 1
            java.lang.String r18 = r3.getString(r7)     // Catch:{ Exception -> 0x011e }
            java.lang.String r19 = "Juspayerror"
            r4 = 2131951928(0x7f130138, float:1.9540284E38)
            java.lang.String r20 = r3.getString(r4)     // Catch:{ Exception -> 0x011e }
            bk$b r4 = new bk$b     // Catch:{ Exception -> 0x011e }
            r4.<init>()     // Catch:{ Exception -> 0x011e }
            r21 = r4
            android.app.AlertDialog r4 = defpackage.C0535I5.m(r16, r17, r18, r19, r20, r21)     // Catch:{ Exception -> 0x011e }
            r4.show()     // Catch:{ Exception -> 0x011e }
            goto L_0x01dc
        L_0x010f:
            boolean r4 = r2.equalsIgnoreCase(r12)     // Catch:{ Exception -> 0x011e }
            if (r4 == 0) goto L_0x0121
            androidx.fragment.app.FragmentActivity r4 = r3.getActivity()     // Catch:{ Exception -> 0x011e }
            cris.org.in.ima.activities.HomeActivity.C(r4)     // Catch:{ Exception -> 0x011e }
            goto L_0x01dc
        L_0x011e:
            r0 = move-exception
            goto L_0x02ec
        L_0x0121:
            boolean r4 = r2.equalsIgnoreCase(r10)     // Catch:{ Exception -> 0x011e }
            if (r4 == 0) goto L_0x01dc
            androidx.fragment.app.FragmentActivity r4 = r3.getActivity()     // Catch:{ Exception -> 0x011e }
            cris.org.in.ima.activities.HomeActivity.B(r4)     // Catch:{ Exception -> 0x011e }
            goto L_0x01dc
        L_0x0130:
            int r4 = r2.hashCode()     // Catch:{ Exception -> 0x011e }
            switch(r4) {
                case -1875974461: goto L_0x018d;
                case -592873500: goto L_0x0183;
                case -482144909: goto L_0x0179;
                case 108960: goto L_0x016e;
                case 62073616: goto L_0x0166;
                case 330873691: goto L_0x015e;
                case 722587238: goto L_0x0154;
                case 1039967579: goto L_0x014c;
                case 1113644194: goto L_0x0144;
                case 1722194021: goto L_0x0139;
                default: goto L_0x0137;
            }     // Catch:{ Exception -> 0x011e }
        L_0x0137:
            goto L_0x0197
        L_0x0139:
            java.lang.String r4 = "api_failure"
            boolean r4 = r2.equals(r4)     // Catch:{ Exception -> 0x011e }
            if (r4 == 0) goto L_0x0197
            r9 = 8
            goto L_0x0198
        L_0x0144:
            boolean r4 = r2.equals(r14)     // Catch:{ Exception -> 0x011e }
            if (r4 == 0) goto L_0x0197
            r9 = 4
            goto L_0x0198
        L_0x014c:
            boolean r4 = r2.equals(r12)     // Catch:{ Exception -> 0x011e }
            if (r4 == 0) goto L_0x0197
            r9 = r13
            goto L_0x0198
        L_0x0154:
            java.lang.String r4 = "authorizing"
            boolean r4 = r2.equals(r4)     // Catch:{ Exception -> 0x011e }
            if (r4 == 0) goto L_0x0197
            r9 = 5
            goto L_0x0198
        L_0x015e:
            boolean r4 = r2.equals(r10)     // Catch:{ Exception -> 0x011e }
            if (r4 == 0) goto L_0x0197
            r9 = 3
            goto L_0x0198
        L_0x0166:
            boolean r4 = r2.equals(r11)     // Catch:{ Exception -> 0x011e }
            if (r4 == 0) goto L_0x0197
            r9 = 0
            goto L_0x0198
        L_0x016e:
            java.lang.String r4 = "new"
            boolean r4 = r2.equals(r4)     // Catch:{ Exception -> 0x011e }
            if (r4 == 0) goto L_0x0197
            r9 = 9
            goto L_0x0198
        L_0x0179:
            java.lang.String r4 = "close_sdk"
            boolean r4 = r2.equals(r4)     // Catch:{ Exception -> 0x011e }
            if (r4 == 0) goto L_0x0197
            r9 = r6
            goto L_0x0198
        L_0x0183:
            java.lang.String r4 = "authentication_failed"
            boolean r4 = r2.equals(r4)     // Catch:{ Exception -> 0x011e }
            if (r4 == 0) goto L_0x0197
            r9 = 7
            goto L_0x0198
        L_0x018d:
            java.lang.String r4 = "authorization_failed"
            boolean r4 = r2.equals(r4)     // Catch:{ Exception -> 0x011e }
            if (r4 == 0) goto L_0x0197
            r9 = 6
            goto L_0x0198
        L_0x0197:
            r9 = -1
        L_0x0198:
            if (r9 == 0) goto L_0x01d5
            if (r9 == r13) goto L_0x01cd
            r4 = 3
            if (r9 == r4) goto L_0x01c5
            r4 = 4
            if (r9 == r4) goto L_0x01a3
            goto L_0x01dc
        L_0x01a3:
            android.content.Context r16 = r3.getContext()     // Catch:{ Exception -> 0x011e }
            r17 = 1
            java.lang.String r18 = r3.getString(r7)     // Catch:{ Exception -> 0x011e }
            java.lang.String r19 = "Juspayerror"
            r4 = 2131951928(0x7f130138, float:1.9540284E38)
            java.lang.String r20 = r3.getString(r4)     // Catch:{ Exception -> 0x011e }
            bk$c r4 = new bk$c     // Catch:{ Exception -> 0x011e }
            r4.<init>()     // Catch:{ Exception -> 0x011e }
            r21 = r4
            android.app.AlertDialog r4 = defpackage.C0535I5.m(r16, r17, r18, r19, r20, r21)     // Catch:{ Exception -> 0x011e }
            r4.show()     // Catch:{ Exception -> 0x011e }
            goto L_0x01dc
        L_0x01c5:
            androidx.fragment.app.FragmentActivity r4 = r3.getActivity()     // Catch:{ Exception -> 0x011e }
            cris.org.in.ima.activities.HomeActivity.B(r4)     // Catch:{ Exception -> 0x011e }
            goto L_0x01dc
        L_0x01cd:
            androidx.fragment.app.FragmentActivity r4 = r3.getActivity()     // Catch:{ Exception -> 0x011e }
            cris.org.in.ima.activities.HomeActivity.C(r4)     // Catch:{ Exception -> 0x011e }
            goto L_0x01dc
        L_0x01d5:
            androidx.fragment.app.FragmentActivity r4 = r3.getActivity()     // Catch:{ Exception -> 0x011e }
            cris.org.in.ima.activities.HomeActivity.B(r4)     // Catch:{ Exception -> 0x011e }
        L_0x01dc:
            boolean r4 = r3.f4791c     // Catch:{ Exception -> 0x011e }
            if (r4 == 0) goto L_0x0317
            boolean r4 = r2.equals(r14)     // Catch:{ Exception -> 0x011e }
            if (r4 != 0) goto L_0x0317
            boolean r4 = r2.equals(r10)     // Catch:{ Exception -> 0x011e }
            if (r4 != 0) goto L_0x0317
            boolean r2 = r2.equals(r11)     // Catch:{ Exception -> 0x011e }
            if (r2 != 0) goto L_0x0317
            if (r15 != 0) goto L_0x0317
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x011e }
            r2.<init>()     // Catch:{ Exception -> 0x011e }
            Do r4 = new Do     // Catch:{ Exception -> 0x011e }
            java.lang.String r5 = "juspayResponse"
            java.lang.String r0 = r23.toString()     // Catch:{ Exception -> 0x011e }
            r4.<init>(r5, r0)     // Catch:{ Exception -> 0x011e }
            r2.add(r4)     // Catch:{ Exception -> 0x011e }
            xl r0 = defpackage.C1480xl.f7038a     // Catch:{ Exception -> 0x011e }
            r0.c(r3, r2)     // Catch:{ Exception -> 0x011e }
            goto L_0x0317
        L_0x020e:
            r4 = 0
            r3.f4791c = r4     // Catch:{ Exception -> 0x011e }
            org.json.JSONObject r0 = r0.optJSONObject(r15)     // Catch:{ Exception -> 0x011e }
            java.lang.String r5 = "supported_reference_ids"
            org.json.JSONArray r5 = r0.getJSONArray(r5)     // Catch:{ Exception -> 0x011e }
            java.lang.String r5 = r5.getString(r4)     // Catch:{ Exception -> 0x011e }
            java.lang.String r4 = "gateway_id"
            java.lang.String r4 = r0.getString(r4)     // Catch:{ Exception -> 0x011e }
            java.lang.String r7 = "juspayEnableFlag"
            java.lang.String r7 = r0.getString(r7)     // Catch:{ Exception -> 0x011e }
            if (r5 == 0) goto L_0x02b4
            boolean r8 = r5.isEmpty()     // Catch:{ Exception -> 0x011e }
            if (r8 != 0) goto L_0x02b4
            xl r8 = defpackage.C1480xl.f7038a     // Catch:{ Exception -> 0x011e }
            java.lang.String r9 = "txnReference"
            java.lang.String r0 = r0.optString(r9)     // Catch:{ Exception -> 0x011e }
            r8.f7046c = r0     // Catch:{ Exception -> 0x011e }
            r3.g = r5     // Catch:{ Exception -> 0x011e }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x011e }
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x011e }
            int r0 = defpackage.C1058d.d(r0)     // Catch:{ Exception -> 0x011e }
            r3.c = r0     // Catch:{ Exception -> 0x011e }
            if (r0 == 0) goto L_0x02a6
            if (r7 == 0) goto L_0x0260
            java.lang.String r0 = "1"
            boolean r0 = r7.equals(r0)     // Catch:{ Exception -> 0x011e }
            if (r0 == 0) goto L_0x0260
            int r0 = r3.c     // Catch:{ Exception -> 0x011e }
            r3.t(r0, r4, r7)     // Catch:{ Exception -> 0x011e }
            goto L_0x0317
        L_0x0260:
            int r0 = r3.c     // Catch:{ Exception -> 0x011e }
            android.app.AlertDialog r2 = defpackage.C0535I5.f3619a     // Catch:{ Exception -> 0x011e }
            r2 = 11
            r5 = 16
            r8 = 10
            r9 = 3
            if (r0 == r9) goto L_0x027f
            r9 = 6
            if (r0 == r9) goto L_0x027f
            r9 = 7
            if (r0 == r9) goto L_0x027f
            r9 = 4
            if (r0 == r9) goto L_0x027f
            if (r0 == r8) goto L_0x027f
            if (r0 == r5) goto L_0x027f
            if (r0 != r2) goto L_0x027d
            goto L_0x027f
        L_0x027d:
            r9 = 0
            goto L_0x0280
        L_0x027f:
            r9 = r6
        L_0x0280:
            if (r9 == 0) goto L_0x02a2
            java.lang.String r0 = "CLOSE_SDK"
            cf r9 = r3.f4771a     // Catch:{ Exception -> 0x011e }
            r10 = 0
            r11 = 0
            defpackage.C0535I5.W(r0, r11, r9, r10, r10)     // Catch:{ Exception -> 0x011e }
            int r0 = r3.c     // Catch:{ Exception -> 0x011e }
            if (r0 == r8) goto L_0x029d
            if (r0 == r5) goto L_0x029d
            if (r0 != r2) goto L_0x0294
            goto L_0x029d
        L_0x0294:
            int r0 = defpackage.C1058d.h(r0)     // Catch:{ Exception -> 0x011e }
            r3.g(r0)     // Catch:{ Exception -> 0x011e }
            goto L_0x0317
        L_0x029d:
            r3.t(r0, r4, r7)     // Catch:{ Exception -> 0x011e }
            goto L_0x0317
        L_0x02a2:
            r3.t(r0, r4, r7)     // Catch:{ Exception -> 0x011e }
            goto L_0x0317
        L_0x02a6:
            android.content.Context r0 = r3.getContext()     // Catch:{ Exception -> 0x011e }
            defpackage.C0535I5.t0(r0, r2)     // Catch:{ Exception -> 0x011e }
            cf r0 = r3.f4771a     // Catch:{ Exception -> 0x011e }
            r4 = 0
            defpackage.C0535I5.W(r2, r6, r0, r4, r4)     // Catch:{ Exception -> 0x011e }
            goto L_0x0317
        L_0x02b4:
            android.content.Context r0 = r3.getContext()     // Catch:{ Exception -> 0x011e }
            java.lang.String r2 = "Invalid bankID "
            defpackage.C0535I5.t0(r0, r2)     // Catch:{ Exception -> 0x011e }
            java.lang.String r0 = "Invalid bankID"
            cf r2 = r3.f4771a     // Catch:{ Exception -> 0x011e }
            r4 = 0
            defpackage.C0535I5.W(r0, r6, r2, r4, r4)     // Catch:{ Exception -> 0x011e }
            goto L_0x0317
        L_0x02c6:
            android.content.Context r0 = r3.getContext()     // Catch:{ Exception -> 0x011e }
            r8 = 1
            java.lang.String r9 = "JP Session Expired"
            java.lang.String r10 = "Error"
            r2 = 2131951928(0x7f130138, float:1.9540284E38)
            java.lang.String r11 = r3.getString(r2)     // Catch:{ Exception -> 0x011e }
            bk$a r12 = new bk$a     // Catch:{ Exception -> 0x011e }
            r12.<init>(r7)     // Catch:{ Exception -> 0x011e }
            r7 = r0
            android.app.AlertDialog r0 = defpackage.C0535I5.m(r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x011e }
            r0.show()     // Catch:{ Exception -> 0x011e }
            goto L_0x0317
        L_0x02e4:
            android.app.ProgressDialog r0 = r3.f4766a     // Catch:{ Exception -> 0x011e }
            r0.dismiss()     // Catch:{ Exception -> 0x011e }
            defpackage.C0822cf.f3936a = r6     // Catch:{ Exception -> 0x011e }
            goto L_0x0317
        L_0x02ec:
            boolean r2 = cris.org.in.ima.fragment.MakePaymentNewFragment.d
            r0.getMessage()
            cf r2 = r3.f4771a
            defpackage.C0822cf.f3936a = r6
            android.content.Context r7 = r3.getContext()
            r8 = 1
            java.lang.String r9 = r0.getMessage()
            java.lang.String r10 = "Juspayerror"
            r2 = 2131951928(0x7f130138, float:1.9540284E38)
            java.lang.String r11 = r3.getString(r2)
            r12 = 0
            android.app.AlertDialog r0 = defpackage.C0535I5.m(r7, r8, r9, r10, r11, r12)
            r0.show()
            cf r0 = r3.f4771a
            java.lang.String r2 = "Some Exception"
            r3 = 0
            defpackage.C0535I5.W(r2, r6, r0, r3, r3)
        L_0x0317:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0805bk.onEvent(org.json.JSONObject, in.juspay.hypersdk.data.JuspayResponseHandler):void");
    }
}
