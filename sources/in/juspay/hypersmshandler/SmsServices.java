package in.juspay.hypersmshandler;

import android.content.IntentFilter;
import androidx.annotation.Keep;
import in.juspay.hyper.constants.LogCategory;
import in.juspay.hyper.constants.LogSubCategory;

public class SmsServices {
    public SmsConsentHandler a;
    public final SmsComponents b;
    public final String c = "SmsServices";

    /* renamed from: in.juspay.hypersmshandler.SmsServices$2  reason: invalid class name */
    class AnonymousClass2 extends SmsConsentHandler {
        public final void c() {
            SmsServices smsServices = SmsServices.this;
            SmsConsentHandler smsConsentHandler = smsServices.a;
            if (smsConsentHandler != null) {
                smsConsentHandler.e();
            }
            AnonymousClass2 r1 = new AnonymousClass2(smsServices.b);
            smsServices.a = r1;
            r1.d = null;
        }
    }

    @Keep
    public SmsServices(SmsComponents smsComponents) {
        this.b = smsComponents;
    }

    public final SmsComponents a() {
        return this.b;
    }

    @Keep
    public JuspayDuiHook createDeliveredSMSReceiver() {
        return new DeliverReceiver();
    }

    @Keep
    public void createSMSConsent() {
        try {
            if (this.a == null && this.b.getContext().getPackageManager().checkPermission("android.permission.READ_SMS", "com.google.android.gms") == 0) {
                AnonymousClass1 r0 = new SmsConsentHandler(this.b) {
                    public final void c() {
                        SmsServices smsServices = SmsServices.this;
                        SmsConsentHandler smsConsentHandler = smsServices.a;
                        if (smsConsentHandler != null) {
                            smsConsentHandler.e();
                        }
                        AnonymousClass2 r1 = new AnonymousClass2(smsServices.b);
                        smsServices.a = r1;
                        r1.d = null;
                    }
                };
                this.a = r0;
                r0.d = null;
            }
        } catch (Exception e) {
            this.b.getTracker().trackAndLogException(this.c, LogCategory.LIFECYCLE, "hyper_sdk", "sms_consent", "Exception happened while initializing", e);
        }
    }

    @Keep
    public JuspayDuiHook createSMSReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
        intentFilter.setPriority(999);
        try {
            if (!a("android.permission.RECEIVE_SMS")) {
                return null;
            }
            SmsReceiver smsReceiver = new SmsReceiver(this);
            smsReceiver.a = intentFilter;
            return smsReceiver;
        } catch (Throwable th) {
            this.b.getTracker().trackAndLogException(this.c, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, "sms_receiver", "Failed to register SMS broadcast receiver (Ignoring)", th);
            return null;
        }
    }

    @Keep
    public JuspayDuiHook createSendSMSReceiver() {
        return new SentReceiver(this.b);
    }

    @Keep
    public JuspayDuiHook createSmsReceiverForConsent() {
        try {
            SmsReceiver smsReceiver = new SmsReceiver(this);
            smsReceiver.a = null;
            return smsReceiver;
        } catch (Exception e) {
            this.b.getTracker().trackAndLogException(this.c, LogCategory.API_CALL, LogSubCategory.ApiCall.SDK, "sms_consent", "Failed to register SMS Consent", e);
            return null;
        }
    }

    @Keep
    public JuspayDuiHook createSmsRetriever() {
        return new SmsRetriever(this.b);
    }

    @Keep
    public String fetchSms(String str, String str2, String str3) {
        return a(str2, str, str3);
    }

    @Keep
    public void unregisterSmsConsent() {
        SmsConsentHandler smsConsentHandler = this.a;
        if (smsConsentHandler != null) {
            smsConsentHandler.e();
            this.a = null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x007f A[Catch:{ JSONException -> 0x00fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x011a A[SYNTHETIC, Splitter:B:34:0x011a] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0123 A[Catch:{ all -> 0x011f }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0126 A[Catch:{ all -> 0x011f }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0130 A[SYNTHETIC, Splitter:B:44:0x0130] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x017b A[SYNTHETIC, Splitter:B:53:0x017b] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x018a A[Catch:{ Exception -> 0x0185 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01c2  */
    /* JADX WARNING: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(java.lang.String r22, java.lang.String r23, java.lang.String r24) {
        /*
            r21 = this;
            r1 = r21
            r0 = r22
            r2 = r24
            java.lang.String r3 = "android.permission.READ_SMS"
            boolean r3 = r1.a(r3)
            if (r3 == 0) goto L_0x01a5
            java.lang.String r3 = ""
            if (r0 == 0) goto L_0x0018
            boolean r5 = r0.equals(r3)
            if (r5 == 0) goto L_0x001a
        L_0x0018:
            java.lang.String r0 = "inbox"
        L_0x001a:
            java.lang.String r5 = "content://sms/"
            java.lang.String r0 = r5.concat(r0)
            android.net.Uri r6 = android.net.Uri.parse(r0)
            java.lang.String r7 = "_id"
            java.lang.String r8 = "address"
            java.lang.String r9 = "body"
            java.lang.String r10 = "date"
            java.lang.String r11 = "status"
            java.lang.String r12 = "type"
            java.lang.String[] r7 = new java.lang.String[]{r7, r8, r9, r10, r11, r12}
            java.lang.String r10 = "date DESC"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.lang.String r8 = "value"
            java.lang.String r9 = "selector"
            java.lang.String r11 = "operator"
            java.lang.String r12 = "field"
            if (r2 == 0) goto L_0x0057
            boolean r14 = r2.equals(r3)     // Catch:{ JSONException -> 0x00fc }
            if (r14 == 0) goto L_0x0051
            goto L_0x0057
        L_0x0051:
            org.json.JSONArray r14 = new org.json.JSONArray     // Catch:{ JSONException -> 0x00fc }
            r14.<init>(r2)     // Catch:{ JSONException -> 0x00fc }
            goto L_0x0078
        L_0x0057:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00fc }
            r2.<init>()     // Catch:{ JSONException -> 0x00fc }
            java.lang.String r14 = "date"
            r2.put(r12, r14)     // Catch:{ JSONException -> 0x00fc }
            java.lang.String r14 = ">"
            r2.put(r11, r14)     // Catch:{ JSONException -> 0x00fc }
            java.lang.String r14 = "?"
            r2.put(r9, r14)     // Catch:{ JSONException -> 0x00fc }
            r14 = r23
            r2.put(r8, r14)     // Catch:{ JSONException -> 0x00fc }
            org.json.JSONArray r14 = new org.json.JSONArray     // Catch:{ JSONException -> 0x00fc }
            r14.<init>()     // Catch:{ JSONException -> 0x00fc }
            r14.put(r2)     // Catch:{ JSONException -> 0x00fc }
        L_0x0078:
            r2 = 0
        L_0x0079:
            int r15 = r14.length()     // Catch:{ JSONException -> 0x00fc }
            if (r2 >= r15) goto L_0x00fc
            org.json.JSONObject r15 = r14.getJSONObject(r2)     // Catch:{ JSONException -> 0x00fc }
            java.lang.String r4 = r15.getString(r12)     // Catch:{ JSONException -> 0x00fc }
            java.lang.String r13 = r15.getString(r11)     // Catch:{ JSONException -> 0x00fc }
            r16 = r11
            java.lang.String r11 = r15.getString(r9)     // Catch:{ JSONException -> 0x00fc }
            r17 = r9
            java.lang.String r9 = r15.getString(r8)     // Catch:{ JSONException -> 0x00fc }
            r18 = r8
            java.lang.String r8 = "next"
            java.lang.String r8 = r15.optString(r8, r3)     // Catch:{ JSONException -> 0x00fc }
            r19 = r3
            java.lang.String r3 = "separator"
            r20 = r12
            java.lang.String r12 = ","
            java.lang.String r3 = r15.optString(r3, r12)     // Catch:{ JSONException -> 0x00fc }
            int r12 = r14.length()     // Catch:{ JSONException -> 0x00fc }
            java.lang.String r15 = " "
            if (r2 == r12) goto L_0x00c6
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x00fc }
            r12.<init>()     // Catch:{ JSONException -> 0x00fc }
            r12.append(r15)     // Catch:{ JSONException -> 0x00fc }
            r12.append(r8)     // Catch:{ JSONException -> 0x00fc }
            r12.append(r15)     // Catch:{ JSONException -> 0x00fc }
            java.lang.String r8 = r12.toString()     // Catch:{ JSONException -> 0x00fc }
            goto L_0x00c8
        L_0x00c6:
            r8 = r19
        L_0x00c8:
            r0.append(r4)     // Catch:{ JSONException -> 0x00fc }
            r0.append(r15)     // Catch:{ JSONException -> 0x00fc }
            r0.append(r13)     // Catch:{ JSONException -> 0x00fc }
            r0.append(r15)     // Catch:{ JSONException -> 0x00fc }
            r0.append(r11)     // Catch:{ JSONException -> 0x00fc }
            r0.append(r8)     // Catch:{ JSONException -> 0x00fc }
            java.lang.String[] r3 = r9.split(r3)     // Catch:{ JSONException -> 0x00fc }
            int r4 = r3.length     // Catch:{ JSONException -> 0x00fc }
            r8 = 0
        L_0x00e0:
            if (r8 >= r4) goto L_0x00ee
            r9 = r3[r8]     // Catch:{ JSONException -> 0x00fc }
            java.lang.String r9 = r9.trim()     // Catch:{ JSONException -> 0x00fc }
            r5.add(r9)     // Catch:{ JSONException -> 0x00fc }
            int r8 = r8 + 1
            goto L_0x00e0
        L_0x00ee:
            int r2 = r2 + 1
            r11 = r16
            r9 = r17
            r8 = r18
            r3 = r19
            r12 = r20
            goto L_0x0079
        L_0x00fc:
            r2 = 0
            java.lang.String[] r3 = new java.lang.String[r2]
            java.lang.Object[] r3 = r5.toArray(r3)
            r9 = r3
            java.lang.String[] r9 = (java.lang.String[]) r9
            in.juspay.hypersmshandler.SmsComponents r3 = r1.b     // Catch:{ Exception -> 0x018e }
            android.content.Context r3 = r3.getContext()     // Catch:{ Exception -> 0x018e }
            android.content.ContentResolver r5 = r3.getContentResolver()     // Catch:{ Exception -> 0x018e }
            java.lang.String r8 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x018e }
            android.database.Cursor r3 = r5.query(r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x018e }
            if (r3 == 0) goto L_0x0123
            int r13 = r3.getCount()     // Catch:{ all -> 0x011f }
            goto L_0x0124
        L_0x011f:
            r0 = move-exception
            r2 = r0
            r4 = 0
            goto L_0x0179
        L_0x0123:
            r13 = r2
        L_0x0124:
            if (r13 <= 0) goto L_0x012d
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ all -> 0x011f }
            r0.<init>()     // Catch:{ all -> 0x011f }
            r4 = r0
            goto L_0x012e
        L_0x012d:
            r4 = 0
        L_0x012e:
            if (r3 == 0) goto L_0x0188
            boolean r0 = r3.moveToNext()     // Catch:{ all -> 0x0177 }
            if (r0 == 0) goto L_0x0188
            r0 = 1
            java.lang.String r0 = r3.getString(r0)     // Catch:{ all -> 0x0177 }
            r2 = 2
            java.lang.String r2 = r3.getString(r2)     // Catch:{ all -> 0x0177 }
            r5 = 3
            long r5 = r3.getLong(r5)     // Catch:{ all -> 0x0177 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x0177 }
            r6 = 4
            java.lang.String r6 = r3.getString(r6)     // Catch:{ all -> 0x0177 }
            r7 = 5
            java.lang.String r7 = r3.getString(r7)     // Catch:{ all -> 0x0177 }
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ all -> 0x0177 }
            r8.<init>()     // Catch:{ all -> 0x0177 }
            java.lang.String r9 = "from"
            r8.put(r9, r0)     // Catch:{ all -> 0x0177 }
            java.lang.String r0 = "body"
            r8.put(r0, r2)     // Catch:{ all -> 0x0177 }
            java.lang.String r0 = "time"
            r8.put(r0, r5)     // Catch:{ all -> 0x0177 }
            java.lang.String r0 = "status"
            r8.put(r0, r6)     // Catch:{ all -> 0x0177 }
            java.lang.String r0 = "type"
            r8.put(r0, r7)     // Catch:{ all -> 0x0177 }
            if (r4 == 0) goto L_0x012e
            r4.put(r8)     // Catch:{ all -> 0x0177 }
            goto L_0x012e
        L_0x0177:
            r0 = move-exception
            r2 = r0
        L_0x0179:
            if (r3 == 0) goto L_0x0184
            r3.close()     // Catch:{ all -> 0x017f }
            goto L_0x0184
        L_0x017f:
            r0 = move-exception
            r3 = r0
            r2.addSuppressed(r3)     // Catch:{ Exception -> 0x0185 }
        L_0x0184:
            throw r2     // Catch:{ Exception -> 0x0185 }
        L_0x0185:
            r0 = move-exception
            r11 = r0
            goto L_0x0191
        L_0x0188:
            if (r3 == 0) goto L_0x01b9
            r3.close()     // Catch:{ Exception -> 0x0185 }
            goto L_0x01b9
        L_0x018e:
            r0 = move-exception
            r11 = r0
            r4 = 0
        L_0x0191:
            in.juspay.hypersmshandler.SmsComponents r0 = r1.b
            in.juspay.hypersmshandler.Tracker r5 = r0.getTracker()
            java.lang.String r6 = r1.c
            java.lang.String r7 = "action"
            java.lang.String r8 = "system"
            java.lang.String r9 = "utils"
            java.lang.String r10 = "Exception while trying to read previous sms from Inbox"
            r5.trackAndLogException(r6, r7, r8, r9, r10, r11)
            goto L_0x01b9
        L_0x01a5:
            in.juspay.hypersmshandler.SmsComponents r0 = r1.b
            in.juspay.hypersmshandler.Tracker r2 = r0.getTracker()
            java.lang.String r3 = "system"
            java.lang.String r4 = "error"
            java.lang.String r5 = "utils"
            java.lang.String r6 = "readsmsfrominbox"
            java.lang.String r7 = "No permission to read SMS"
            r2.trackAction(r3, r4, r5, r6, r7)
            r4 = 0
        L_0x01b9:
            if (r4 == 0) goto L_0x01c7
            int r0 = r4.length()
            if (r0 != 0) goto L_0x01c2
            goto L_0x01c7
        L_0x01c2:
            java.lang.String r0 = r4.toString()
            return r0
        L_0x01c7:
            java.lang.String r0 = "[]"
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersmshandler.SmsServices.a(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public final boolean a(String str) {
        return r1.k(this.b.getContext(), str) == 0;
    }
}
