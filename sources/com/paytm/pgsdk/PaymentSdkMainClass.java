package com.paytm.pgsdk;

import android.content.Context;

public class PaymentSdkMainClass {
    public final Context a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f4098a = false;
    public boolean b = true;
    public boolean c = true;

    public PaymentSdkMainClass(Context context) {
        this.a = context;
    }

    public boolean getHideHeader() {
        return this.f4098a;
    }

    public boolean getIsstaging() {
        return this.c;
    }

    public boolean getSendAllChecksumResponseParametersToPGServer() {
        return this.b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x005d, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x005e, code lost:
        r8.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void pay(java.util.LinkedHashMap<java.lang.String, java.lang.String> r8, com.paytm.pgsdk.PaytmMerchant r9, boolean r10, com.paytm.pgsdk.PaytmClientCertificate r11, boolean r12, boolean r13, com.paytm.pgsdk.PaytmPaymentTransactionCallback r14) {
        /*
            r7 = this;
            r7.c = r12     // Catch:{ Exception -> 0x005d }
            if (r12 != 0) goto L_0x0006
            r0 = 1
            goto L_0x0007
        L_0x0006:
            r0 = 0
        L_0x0007:
            defpackage.C1488xu.a = r0     // Catch:{ Exception -> 0x005d }
            defpackage.C1354qp.f6916a = r13     // Catch:{ Exception -> 0x005d }
            if (r12 == 0) goto L_0x0024
            java.lang.Class<np> r12 = defpackage.C1286np.class
            monitor-enter(r12)     // Catch:{ Exception -> 0x005d }
            np r13 = defpackage.C1286np.a()     // Catch:{ all -> 0x0021 }
            r13.getClass()     // Catch:{ all -> 0x0021 }
            java.lang.String r0 = "https://pguat.paytm.com/paytmchecksum/CheckSumGenerator.jsp"
            r13.f5604a = r0     // Catch:{ all -> 0x0021 }
            java.lang.String r0 = "https://pguat.paytm.com/oltp-web/processTransaction"
            r13.b = r0     // Catch:{ all -> 0x0021 }
            monitor-exit(r12)     // Catch:{ Exception -> 0x005d }
            goto L_0x0037
        L_0x0021:
            r8 = move-exception
            monitor-exit(r12)     // Catch:{ Exception -> 0x005d }
            throw r8     // Catch:{ Exception -> 0x005d }
        L_0x0024:
            java.lang.Class<np> r12 = defpackage.C1286np.class
            monitor-enter(r12)     // Catch:{ Exception -> 0x005d }
            np r13 = defpackage.C1286np.a()     // Catch:{ all -> 0x005a }
            r13.getClass()     // Catch:{ all -> 0x005a }
            java.lang.String r0 = "https://secure.paytm.in/oltp-web/generateChecksum"
            r13.f5604a = r0     // Catch:{ all -> 0x005a }
            java.lang.String r0 = "https://secure.paytm.in/oltp-web/processTransaction"
            r13.b = r0     // Catch:{ all -> 0x005a }
            monitor-exit(r12)     // Catch:{ Exception -> 0x005d }
        L_0x0037:
            r1 = r13
            dl r12 = defpackage.C1073dl.a()     // Catch:{ Exception -> 0x005d }
            r12.f5446a = r8     // Catch:{ Exception -> 0x005d }
            nh r12 = new nh     // Catch:{ Exception -> 0x005d }
            r12.<init>((java.lang.Object) r8)     // Catch:{ Exception -> 0x005d }
            monitor-enter(r1)     // Catch:{ Exception -> 0x005d }
            r1.f5605a = r12     // Catch:{ all -> 0x0057 }
            r1.f5602a = r9     // Catch:{ all -> 0x0057 }
            r1.f5601a = r11     // Catch:{ all -> 0x0057 }
            monitor-exit(r1)     // Catch:{ Exception -> 0x005d }
            android.content.Context r2 = r7.a     // Catch:{ Exception -> 0x005d }
            boolean r3 = r7.f4098a     // Catch:{ Exception -> 0x005d }
            boolean r5 = r7.b     // Catch:{ Exception -> 0x005d }
            r4 = r10
            r6 = r14
            r1.b(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x005d }
            goto L_0x0061
        L_0x0057:
            r8 = move-exception
            monitor-exit(r1)     // Catch:{ Exception -> 0x005d }
            throw r8     // Catch:{ Exception -> 0x005d }
        L_0x005a:
            r8 = move-exception
            monitor-exit(r12)     // Catch:{ Exception -> 0x005d }
            throw r8     // Catch:{ Exception -> 0x005d }
        L_0x005d:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0061:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.pgsdk.PaymentSdkMainClass.pay(java.util.LinkedHashMap, com.paytm.pgsdk.PaytmMerchant, boolean, com.paytm.pgsdk.PaytmClientCertificate, boolean, boolean, com.paytm.pgsdk.PaytmPaymentTransactionCallback):void");
    }

    public void setDyanamicValues(boolean z, boolean z2, boolean z3, boolean z4, String str) {
        C1073dl.f5442a = z;
        C1073dl.f5443c = z2;
        C1073dl.b = z3;
        C1073dl.d = z4;
        if (str == null || str.length() <= 0) {
            C1073dl.c = "#ff33b5e5";
        } else {
            C1073dl.c = str;
        }
    }

    public void setHideHeader(boolean z) {
        this.f4098a = z;
    }

    public void setResIdAppIcon(int i) {
        C1073dl.a = i;
    }

    public void setSendAllChecksumResponseParametersToPGServer(boolean z) {
        this.b = z;
    }
}
