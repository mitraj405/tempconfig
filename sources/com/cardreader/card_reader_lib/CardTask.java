package com.cardreader.card_reader_lib;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.nfc.tech.NfcA;
import android.os.Build;
import androidx.annotation.Keep;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class CardTask {
    public static Aa a;

    /* renamed from: a  reason: collision with other field name */
    public static final IntentFilter[] f2776a = {new IntentFilter("android.nfc.action.TECH_DISCOVERED"), new IntentFilter("android.nfc.action.TAG_DISCOVERED")};

    /* renamed from: a  reason: collision with other field name */
    public static final String[][] f2777a = {new String[]{NfcA.class.getName(), IsoDep.class.getName()}};

    /* renamed from: a  reason: collision with other field name */
    public PendingIntent f2778a;

    /* renamed from: a  reason: collision with other field name */
    public NfcAdapter f2779a;

    @Keep
    public CardTask() {
        a = new Aa();
    }

    public static boolean a(byte[] bArr) {
        boolean z;
        byte[] W = C1354qp.W(bArr, Ba.c, Ba.i);
        r1.g(W);
        if (W != null) {
            String str = "";
            try {
                for (byte b : W) {
                    str = str + String.format("%02X", new Object[]{Byte.valueOf(b)});
                }
                String[] split = str.split("D");
                Aa aa = a;
                aa.c = split[0];
                aa.d = split[1].substring(2, 4);
                a.e = split[1].substring(0, 2);
                z = true;
            } catch (Exception e) {
                e.toString();
                z = false;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    @Keep
    public List<C0243k0> extractAfl(byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        while (byteArrayInputStream.available() >= 4) {
            C0243k0 k0Var = new C0243k0();
            k0Var.a = byteArrayInputStream.read() >> 3;
            k0Var.b = byteArrayInputStream.read();
            k0Var.c = byteArrayInputStream.read();
            byteArrayInputStream.read();
            arrayList.add(k0Var);
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:131:0x0279  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0281 A[SYNTHETIC] */
    @androidx.annotation.Keep
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean extractPublicData(android.nfc.tech.IsoDep r17, byte[] r18) throws java.io.IOException {
        /*
            r16 = this;
            r1 = r17
            r0 = r18
            r2 = 0
            if (r0 != 0) goto L_0x0009
            r3 = r2
            goto L_0x000a
        L_0x0009:
            int r3 = r0.length
        L_0x000a:
            r4 = 4
            r5 = 5
            if (r0 == 0) goto L_0x0014
            int r6 = r0.length
            if (r6 == 0) goto L_0x0014
            int r6 = r0.length
            int r6 = r6 + r5
            goto L_0x0015
        L_0x0014:
            r6 = r4
        L_0x0015:
            r7 = 1
            int r6 = r6 + r7
            byte[] r6 = new byte[r6]
            byte r8 = (byte) r2
            r6[r2] = r8
            r9 = 164(0xa4, float:2.3E-43)
            byte r9 = (byte) r9
            r6[r7] = r9
            byte r9 = (byte) r4
            r10 = 2
            r6[r10] = r9
            r9 = 3
            r6[r9] = r8
            if (r0 == 0) goto L_0x0037
            int r11 = r0.length
            if (r11 == 0) goto L_0x0037
            byte r3 = (byte) r3
            r6[r4] = r3
            int r3 = r0.length
            java.lang.System.arraycopy(r0, r2, r6, r5, r3)
            int r0 = r0.length
            int r0 = r0 + r5
            goto L_0x0038
        L_0x0037:
            r0 = r4
        L_0x0038:
            byte r3 = r6[r0]
            int r3 = r3 + r8
            byte r3 = (byte) r3
            r6[r0] = r3
            defpackage.r1.g(r6)
            byte[] r0 = r1.transceive(r6)
            defpackage.r1.g(r0)
            java.lang.String r3 = "9000"
            byte[] r6 = defpackage.r1.t(r3)
            if (r0 == 0) goto L_0x0066
            int r11 = r0.length
            if (r11 >= r10) goto L_0x0054
            goto L_0x0066
        L_0x0054:
            int r11 = r0.length
            int r11 = r11 - r10
            byte r11 = r0[r11]
            byte r12 = r6[r2]
            if (r11 != r12) goto L_0x0066
            int r11 = r0.length
            int r11 = r11 - r7
            byte r11 = r0[r11]
            byte r6 = r6[r7]
            if (r11 != r6) goto L_0x0066
            r6 = r7
            goto L_0x0067
        L_0x0066:
            r6 = r2
        L_0x0067:
            if (r6 == 0) goto L_0x0289
            defpackage.r1.g(r0)
            mf[] r6 = new defpackage.mf[r7]
            tz r11 = defpackage.Ba.b
            r6[r2] = r11
            byte[] r6 = defpackage.C1354qp.W(r0, r6)
            int r11 = r6.length
            java.lang.String r12 = ""
            r13 = r2
        L_0x007a:
            if (r13 >= r11) goto L_0x009a
            byte r14 = r6[r13]
            java.lang.StringBuilder r12 = defpackage.xx.J(r12)
            java.lang.Object[] r15 = new java.lang.Object[r7]
            java.lang.Byte r14 = java.lang.Byte.valueOf(r14)
            r15[r2] = r14
            java.lang.String r14 = "%02X"
            java.lang.String r14 = java.lang.String.format(r14, r15)
            r12.append(r14)
            java.lang.String r12 = r12.toString()
            int r13 = r13 + 1
            goto L_0x007a
        L_0x009a:
            Aa r6 = a
            r6.getClass()
            mf[] r6 = new defpackage.mf[r7]
            tz r11 = defpackage.Ba.g
            r6[r2] = r11
            byte[] r0 = defpackage.C1354qp.W(r0, r6)
            if (r0 == 0) goto L_0x00ae
            defpackage.r1.g(r0)
        L_0x00ae:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            if (r0 == 0) goto L_0x00f3
            java.io.ByteArrayInputStream r11 = new java.io.ByteArrayInputStream
            r11.<init>(r0)
        L_0x00ba:
            int r0 = r11.available()
            if (r0 <= 0) goto L_0x00f3
            int r0 = r11.available()
            if (r0 < r10) goto L_0x00db
            byte[] r0 = defpackage.C1354qp.n0(r11)
            mf r0 = defpackage.C1354qp.v0(r0)
            int r12 = defpackage.C1354qp.o0(r11)
            sz r13 = new sz
            r13.<init>(r0, r12)
            r6.add(r13)
            goto L_0x00ba
        L_0x00db:
            cA r0 = new cA
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Data length < 2 : "
            r1.<init>(r2)
            int r2 = r11.available()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00f3:
            java.io.ByteArrayOutputStream r11 = new java.io.ByteArrayOutputStream
            r11.<init>()
            tz r0 = defpackage.Ba.e     // Catch:{ IOException -> 0x0132 }
            byte[] r0 = r0.f3308a     // Catch:{ IOException -> 0x0132 }
            r11.write(r0)     // Catch:{ IOException -> 0x0132 }
            java.util.Iterator r0 = r6.iterator()     // Catch:{ IOException -> 0x0132 }
            r12 = r2
        L_0x0104:
            boolean r13 = r0.hasNext()     // Catch:{ IOException -> 0x0132 }
            if (r13 == 0) goto L_0x0114
            java.lang.Object r13 = r0.next()     // Catch:{ IOException -> 0x0132 }
            sz r13 = (defpackage.sz) r13     // Catch:{ IOException -> 0x0132 }
            int r13 = r13.a     // Catch:{ IOException -> 0x0132 }
            int r12 = r12 + r13
            goto L_0x0104
        L_0x0114:
            r11.write(r12)     // Catch:{ IOException -> 0x0132 }
            java.util.Iterator r0 = r6.iterator()     // Catch:{ IOException -> 0x0132 }
        L_0x011b:
            boolean r6 = r0.hasNext()     // Catch:{ IOException -> 0x0132 }
            if (r6 == 0) goto L_0x0136
            java.lang.Object r6 = r0.next()     // Catch:{ IOException -> 0x0132 }
            sz r6 = (defpackage.sz) r6     // Catch:{ IOException -> 0x0132 }
            r6.toString()     // Catch:{ IOException -> 0x0132 }
            byte[] r6 = defpackage.Ca.a(r6)     // Catch:{ IOException -> 0x0132 }
            r11.write(r6)     // Catch:{ IOException -> 0x0132 }
            goto L_0x011b
        L_0x0132:
            r0 = move-exception
            r0.toString()
        L_0x0136:
            byte[] r0 = r11.toByteArray()
            if (r0 != 0) goto L_0x013e
            r6 = r2
            goto L_0x013f
        L_0x013e:
            int r6 = r0.length
        L_0x013f:
            if (r0 == 0) goto L_0x0147
            int r11 = r0.length
            if (r11 == 0) goto L_0x0147
            int r11 = r0.length
            int r11 = r11 + r5
            goto L_0x0148
        L_0x0147:
            r11 = r4
        L_0x0148:
            int r11 = r11 + r7
            byte[] r11 = new byte[r11]
            r12 = 128(0x80, float:1.794E-43)
            byte r12 = (byte) r12
            r11[r2] = r12
            r12 = 168(0xa8, float:2.35E-43)
            byte r12 = (byte) r12
            r11[r7] = r12
            r11[r10] = r8
            r11[r9] = r8
            if (r0 == 0) goto L_0x0168
            int r12 = r0.length
            if (r12 == 0) goto L_0x0168
            byte r6 = (byte) r6
            r11[r4] = r6
            int r6 = r0.length
            java.lang.System.arraycopy(r0, r2, r11, r5, r6)
            int r0 = r0.length
            int r0 = r0 + r5
            goto L_0x0169
        L_0x0168:
            r0 = r4
        L_0x0169:
            byte r6 = r11[r0]
            int r6 = r6 + r8
            byte r6 = (byte) r6
            r11[r0] = r6
            byte[] r0 = r1.transceive(r11)
            if (r0 == 0) goto L_0x0178
            defpackage.r1.g(r0)
        L_0x0178:
            byte[] r6 = defpackage.r1.t(r3)
            if (r0 == 0) goto L_0x0194
            int r11 = r0.length
            if (r11 >= r10) goto L_0x0182
            goto L_0x0194
        L_0x0182:
            int r11 = r0.length
            int r11 = r11 - r10
            byte r11 = r0[r11]
            byte r12 = r6[r2]
            if (r11 != r12) goto L_0x0194
            int r11 = r0.length
            int r11 = r11 - r7
            byte r11 = r0[r11]
            byte r6 = r6[r7]
            if (r11 != r6) goto L_0x0194
            r6 = r7
            goto L_0x0195
        L_0x0194:
            r6 = r2
        L_0x0195:
            if (r6 == 0) goto L_0x0289
            defpackage.r1.g(r0)
            mf[] r6 = new defpackage.mf[r7]
            tz r11 = defpackage.Ba.d
            r6[r2] = r11
            byte[] r6 = defpackage.C1354qp.W(r0, r6)
            if (r6 == 0) goto L_0x01bd
            defpackage.r1.g(r6)
            int r0 = r6.length
            int r11 = r6.length
            if (r0 <= r11) goto L_0x01ae
            int r0 = r6.length
        L_0x01ae:
            int r0 = r0 - r10
            if (r0 > 0) goto L_0x01b5
            byte[] r0 = new byte[r2]
            r6 = r0
            goto L_0x01bb
        L_0x01b5:
            byte[] r11 = new byte[r0]
            java.lang.System.arraycopy(r6, r10, r11, r2, r0)
            r6 = r11
        L_0x01bb:
            r11 = r2
            goto L_0x01cd
        L_0x01bd:
            boolean r11 = a(r0)
            if (r11 != 0) goto L_0x01cd
            mf[] r6 = new defpackage.mf[r7]
            tz r12 = defpackage.Ba.f
            r6[r2] = r12
            byte[] r6 = defpackage.C1354qp.W(r0, r6)
        L_0x01cd:
            r12 = r16
            if (r6 == 0) goto L_0x0287
            java.util.List r0 = r12.extractAfl(r6)
            java.util.Iterator r0 = r0.iterator()
        L_0x01d9:
            boolean r6 = r0.hasNext()
            if (r6 == 0) goto L_0x0287
            java.lang.Object r6 = r0.next()
            k0 r6 = (defpackage.C0243k0) r6
            int r13 = r6.b
        L_0x01e7:
            int r14 = r6.c
            if (r13 > r14) goto L_0x01d9
            int r14 = r6.a
            int r14 = r14 << r9
            r14 = r14 | r4
            byte[] r5 = new byte[r5]
            r5[r2] = r8
            r15 = 178(0xb2, float:2.5E-43)
            byte r15 = (byte) r15
            r5[r7] = r15
            byte r7 = (byte) r13
            r5[r10] = r7
            byte r14 = (byte) r14
            r5[r9] = r14
            byte r14 = r5[r4]
            int r14 = r14 + r8
            byte r14 = (byte) r14
            r5[r4] = r14
            byte[] r4 = r1.transceive(r5)
            java.lang.String r5 = "6C"
            byte[] r5 = defpackage.r1.t(r5)
            if (r4 == 0) goto L_0x0227
            int r14 = r4.length
            if (r14 >= r10) goto L_0x0214
            goto L_0x0227
        L_0x0214:
            int r14 = r4.length
            int r14 = r14 - r10
            byte r10 = r4[r14]
            byte r14 = r5[r2]
            if (r10 != r14) goto L_0x0227
            int r10 = r4.length
            r14 = 1
            int r10 = r10 - r14
            byte r10 = r4[r10]
            byte r5 = r5[r14]
            if (r10 != r5) goto L_0x0227
            r5 = 1
            goto L_0x0228
        L_0x0227:
            r5 = r2
        L_0x0228:
            if (r5 == 0) goto L_0x0251
            int r5 = r6.a
            int r5 = r5 << r9
            r5 = r5 | 4
            int r10 = r4.length
            r14 = 1
            int r10 = r10 + -1
            byte r4 = r4[r10]
            r10 = 5
            byte[] r9 = new byte[r10]
            r9[r2] = r8
            r9[r14] = r15
            r14 = 2
            r9[r14] = r7
            byte r5 = (byte) r5
            r14 = 3
            r9[r14] = r5
            r5 = 4
            byte r7 = r9[r5]
            byte r4 = (byte) r4
            int r7 = r7 + r4
            byte r4 = (byte) r7
            r9[r5] = r4
            byte[] r4 = r1.transceive(r9)
            r5 = r10
            goto L_0x0253
        L_0x0251:
            r14 = r9
            r5 = 5
        L_0x0253:
            byte[] r7 = defpackage.r1.t(r3)
            if (r4 == 0) goto L_0x0273
            int r9 = r4.length
            r10 = 2
            if (r9 >= r10) goto L_0x025e
            goto L_0x0271
        L_0x025e:
            int r9 = r4.length
            int r9 = r9 - r10
            byte r9 = r4[r9]
            byte r15 = r7[r2]
            if (r9 != r15) goto L_0x0271
            int r9 = r4.length
            r15 = 1
            int r9 = r9 - r15
            byte r9 = r4[r9]
            byte r7 = r7[r15]
            if (r9 != r7) goto L_0x0275
            r7 = r15
            goto L_0x0277
        L_0x0271:
            r15 = 1
            goto L_0x0275
        L_0x0273:
            r15 = 1
            r10 = 2
        L_0x0275:
            r7 = r15
            r15 = r2
        L_0x0277:
            if (r15 == 0) goto L_0x0281
            boolean r4 = a(r4)
            if (r4 == 0) goto L_0x0280
            goto L_0x0288
        L_0x0280:
            r11 = r4
        L_0x0281:
            int r13 = r13 + 1
            r4 = 4
            r9 = r14
            goto L_0x01e7
        L_0x0287:
            r4 = r11
        L_0x0288:
            return r4
        L_0x0289:
            r12 = r16
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardreader.card_reader_lib.CardTask.extractPublicData(android.nfc.tech.IsoDep, byte[]):boolean");
    }

    @Keep
    public String getCardDetails(Intent intent) {
        NfcAdapter nfcAdapter;
        try {
            if (intent.getAction().equals("android.nfc.action.TECH_DISCOVERED") && (nfcAdapter = this.f2779a) != null && nfcAdapter.isEnabled()) {
                Tag tag = (Tag) intent.getParcelableExtra("android.nfc.extra.TAG");
                if (tag != null) {
                    readWithPSE(IsoDep.get(tag));
                }
                Aa aa = a;
                String str = aa.c;
                String str2 = aa.d;
                String str3 = aa.e;
                if (str == null || str2 == null || str3 == null) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("cardNumber", a.c);
                jSONObject.put("expiryMonth", a.d);
                jSONObject.put("expiryYear", a.e);
                return jSONObject.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Keep
    public boolean isNFCEnabled(Context context) {
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(context);
        this.f2779a = defaultAdapter;
        if (defaultAdapter != null) {
            return defaultAdapter.isEnabled();
        }
        return false;
    }

    @Keep
    public boolean isNFCSupported(Context context) {
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(context);
        this.f2779a = defaultAdapter;
        if (defaultAdapter == null) {
            return false;
        }
        return true;
    }

    @Keep
    public void onPauseClone(Activity activity) {
        NfcAdapter nfcAdapter = this.f2779a;
        if (nfcAdapter != null) {
            nfcAdapter.disableForegroundDispatch(activity);
        }
    }

    @Keep
    public void onResumeClone(Activity activity) {
        if (Build.VERSION.SDK_INT >= 31) {
            this.f2778a = PendingIntent.getActivity(activity.getApplicationContext(), 0, new Intent(activity.getApplicationContext(), activity.getClass()).addFlags(536870912), 33554432);
        } else {
            this.f2778a = PendingIntent.getActivity(activity.getApplicationContext(), 0, new Intent(activity.getApplicationContext(), activity.getClass()).addFlags(536870912), 67108864);
        }
        this.f2779a.enableForegroundDispatch(activity, this.f2778a, f2776a, f2777a);
    }

    @Keep
    public boolean readWithPSE(IsoDep isoDep) throws IOException {
        int i;
        int i2;
        boolean z;
        byte[] bArr;
        byte[] bytes = "2PAY.SYS.DDF01".getBytes();
        isoDep.connect();
        if (bytes == null) {
            i = 0;
        } else {
            i = bytes.length;
        }
        int i3 = 4;
        if (bytes == null || bytes.length == 0) {
            i2 = 4;
        } else {
            i2 = bytes.length + 5;
        }
        byte[] bArr2 = new byte[(i2 + 1)];
        byte b = (byte) 0;
        bArr2[0] = b;
        bArr2[1] = (byte) 164;
        bArr2[2] = (byte) 4;
        bArr2[3] = b;
        if (!(bytes == null || bytes.length == 0)) {
            bArr2[4] = (byte) i;
            System.arraycopy(bytes, 0, bArr2, 5, bytes.length);
            i3 = bytes.length + 5;
        }
        bArr2[i3] = (byte) (bArr2[i3] + b);
        byte[] transceive = isoDep.transceive(bArr2);
        r1.g(transceive);
        byte[] t = r1.t("9000");
        if (transceive == null || transceive.length < 2 || transceive[transceive.length - 2] != t[0] || transceive[transceive.length - 1] != t[1]) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator it = C1354qp.X(transceive, Ba.f48a, Ba.j).iterator();
            while (it.hasNext()) {
                C0301pz pzVar = (C0301pz) it.next();
                mf mfVar = pzVar.a;
                tz tzVar = Ba.j;
                byte[] bArr3 = pzVar.f3176a;
                if (mfVar != tzVar || arrayList.size() == 0) {
                    arrayList.add(bArr3);
                } else {
                    byte[] bArr4 = (byte[]) arrayList.get(arrayList.size() - 1);
                    if (bArr4 == null) {
                        if (bArr3 == null) {
                            bArr = null;
                        } else {
                            bArr = (byte[]) bArr3.clone();
                        }
                    } else if (bArr3 == null) {
                        bArr = (byte[]) bArr4.clone();
                    } else {
                        byte[] bArr5 = new byte[(bArr4.length + bArr3.length)];
                        System.arraycopy(bArr4, 0, bArr5, 0, bArr4.length);
                        System.arraycopy(bArr3, 0, bArr5, bArr4.length, bArr3.length);
                        bArr = bArr5;
                    }
                    arrayList.add(bArr);
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                byte[] bArr6 = (byte[]) it2.next();
                r1.g(bArr6);
                try {
                    if (extractPublicData(isoDep, bArr6)) {
                        isoDep.close();
                        return true;
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        isoDep.close();
        return false;
    }
}
