package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Pair;
import com.google.firebase.perf.util.Constants;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.security.DigestException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzaon {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: java.io.RandomAccessFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v12, resolved type: java.io.RandomAccessFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v13, resolved type: java.io.RandomAccessFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v14, resolved type: java.io.RandomAccessFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v15, resolved type: java.io.RandomAccessFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v16, resolved type: java.io.RandomAccessFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v17, resolved type: java.io.RandomAccessFile} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.security.cert.X509Certificate[][] zza(java.lang.String r22) throws com.google.android.gms.internal.ads.zzaok, java.lang.SecurityException, java.io.IOException {
        /*
            java.lang.String r0 = " < 8"
            java.lang.String r1 = "end > capacity: "
            java.lang.String r2 = "end < start: "
            java.lang.String r3 = "APK Signing Block sizes in header and footer do not match: "
            java.lang.String r4 = "APK Signing Block offset out of range: "
            java.lang.String r5 = "APK Signing Block size out of range: "
            java.lang.String r6 = "APK too small for APK Signing Block. ZIP Central Directory offset: "
            java.lang.String r7 = "ZIP Central Directory offset out of range: "
            java.lang.String r8 = "Not an APK file: ZIP End of Central Directory record not found in file with "
            java.io.RandomAccessFile r9 = new java.io.RandomAccessFile
            java.lang.String r10 = "r"
            r11 = r22
            r9.<init>(r11, r10)
            android.util.Pair r10 = com.google.android.gms.internal.ads.zzaoo.zzc(r9)     // Catch:{ all -> 0x0301 }
            if (r10 == 0) goto L_0x02e3
            java.lang.Object r8 = r10.first     // Catch:{ all -> 0x0301 }
            r19 = r8
            java.nio.ByteBuffer r19 = (java.nio.ByteBuffer) r19     // Catch:{ all -> 0x0301 }
            java.lang.Object r8 = r10.second     // Catch:{ all -> 0x0301 }
            java.lang.Long r8 = (java.lang.Long) r8     // Catch:{ all -> 0x0301 }
            long r13 = r8.longValue()     // Catch:{ all -> 0x0301 }
            r10 = -20
            long r10 = r10 + r13
            r15 = 0
            int r8 = (r10 > r15 ? 1 : (r10 == r15 ? 0 : -1))
            if (r8 >= 0) goto L_0x0039
            goto L_0x0045
        L_0x0039:
            r9.seek(r10)     // Catch:{ all -> 0x0301 }
            int r8 = r9.readInt()     // Catch:{ all -> 0x0301 }
            r10 = 1347094023(0x504b0607, float:1.36246794E10)
            if (r8 == r10) goto L_0x02da
        L_0x0045:
            long r10 = com.google.android.gms.internal.ads.zzaoo.zza(r19)     // Catch:{ all -> 0x0301 }
            int r8 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r8 >= 0) goto L_0x02bd
            long r7 = com.google.android.gms.internal.ads.zzaoo.zzb(r19)     // Catch:{ all -> 0x0301 }
            long r7 = r7 + r10
            int r7 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
            if (r7 != 0) goto L_0x02b4
            r7 = 32
            int r7 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r7 < 0) goto L_0x02a0
            r6 = 24
            java.nio.ByteBuffer r6 = java.nio.ByteBuffer.allocate(r6)     // Catch:{ all -> 0x0301 }
            java.nio.ByteOrder r7 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ all -> 0x0301 }
            r6.order(r7)     // Catch:{ all -> 0x0301 }
            int r8 = r6.capacity()     // Catch:{ all -> 0x0301 }
            r17 = r13
            long r12 = (long) r8     // Catch:{ all -> 0x0301 }
            long r12 = r10 - r12
            r9.seek(r12)     // Catch:{ all -> 0x0301 }
            byte[] r8 = r6.array()     // Catch:{ all -> 0x0301 }
            int r12 = r6.arrayOffset()     // Catch:{ all -> 0x0301 }
            int r13 = r6.capacity()     // Catch:{ all -> 0x0301 }
            r9.readFully(r8, r12, r13)     // Catch:{ all -> 0x0301 }
            r8 = 8
            long r12 = r6.getLong(r8)     // Catch:{ all -> 0x0301 }
            r20 = 2334950737559900225(0x20676953204b5041, double:1.3968830566012645E-152)
            int r12 = (r12 > r20 ? 1 : (r12 == r20 ? 0 : -1))
            if (r12 != 0) goto L_0x0294
            r12 = 16
            long r12 = r6.getLong(r12)     // Catch:{ all -> 0x0301 }
            r20 = 3617552046287187010(0x3234206b636f6c42, double:7.465385175170059E-67)
            int r12 = (r12 > r20 ? 1 : (r12 == r20 ? 0 : -1))
            if (r12 != 0) goto L_0x0294
            r12 = 0
            long r13 = r6.getLong(r12)     // Catch:{ all -> 0x0301 }
            int r6 = r6.capacity()     // Catch:{ all -> 0x0301 }
            r21 = r9
            long r8 = (long) r6
            int r6 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r6 < 0) goto L_0x0280
            r8 = 2147483639(0x7ffffff7, double:1.060997891E-314)
            int r6 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r6 > 0) goto L_0x0280
            r5 = 8
            long r5 = r5 + r13
            int r5 = (int) r5
            long r8 = (long) r5
            long r8 = r10 - r8
            int r6 = (r8 > r15 ? 1 : (r8 == r15 ? 0 : -1))
            if (r6 < 0) goto L_0x026c
            java.nio.ByteBuffer r4 = java.nio.ByteBuffer.allocate(r5)     // Catch:{ all -> 0x0267 }
            r4.order(r7)     // Catch:{ all -> 0x0267 }
            r6 = r21
            r6.seek(r8)     // Catch:{ all -> 0x029d }
            byte[] r5 = r4.array()     // Catch:{ all -> 0x029d }
            int r15 = r4.arrayOffset()     // Catch:{ all -> 0x029d }
            int r12 = r4.capacity()     // Catch:{ all -> 0x029d }
            r6.readFully(r5, r15, r12)     // Catch:{ all -> 0x029d }
            r20 = r10
            r5 = 0
            long r10 = r4.getLong(r5)     // Catch:{ all -> 0x029d }
            int r5 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r5 != 0) goto L_0x024d
            java.lang.Long r3 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x029d }
            android.util.Pair r3 = android.util.Pair.create(r4, r3)     // Catch:{ all -> 0x029d }
            java.lang.Object r4 = r3.first     // Catch:{ all -> 0x029d }
            java.nio.ByteBuffer r4 = (java.nio.ByteBuffer) r4     // Catch:{ all -> 0x029d }
            java.lang.Object r3 = r3.second     // Catch:{ all -> 0x029d }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ all -> 0x029d }
            long r13 = r3.longValue()     // Catch:{ all -> 0x029d }
            java.nio.ByteOrder r3 = r4.order()     // Catch:{ all -> 0x029d }
            if (r3 != r7) goto L_0x0245
            int r3 = r4.capacity()     // Catch:{ all -> 0x029d }
            int r3 = r3 + -24
            r5 = 8
            if (r3 < r5) goto L_0x0230
            int r0 = r4.capacity()     // Catch:{ all -> 0x029d }
            int r2 = r4.capacity()     // Catch:{ all -> 0x029d }
            if (r3 > r2) goto L_0x0216
            int r1 = r4.limit()     // Catch:{ all -> 0x029d }
            int r2 = r4.position()     // Catch:{ all -> 0x029d }
            r5 = 0
            r4.position(r5)     // Catch:{ all -> 0x020a }
            r4.limit(r3)     // Catch:{ all -> 0x020a }
            r0 = 8
            r4.position(r0)     // Catch:{ all -> 0x020a }
            java.nio.ByteBuffer r0 = r4.slice()     // Catch:{ all -> 0x020a }
            java.nio.ByteOrder r3 = r4.order()     // Catch:{ all -> 0x020a }
            r0.order(r3)     // Catch:{ all -> 0x020a }
            r3 = 0
            r4.position(r3)     // Catch:{ all -> 0x029d }
            r4.limit(r1)     // Catch:{ all -> 0x029d }
            r4.position(r2)     // Catch:{ all -> 0x029d }
            r12 = 0
        L_0x0140:
            boolean r1 = r0.hasRemaining()     // Catch:{ all -> 0x029d }
            if (r1 == 0) goto L_0x0202
            int r12 = r12 + 1
            int r1 = r0.remaining()     // Catch:{ all -> 0x029d }
            r2 = 8
            if (r1 < r2) goto L_0x01eb
            long r3 = r0.getLong()     // Catch:{ all -> 0x029d }
            r7 = 4
            int r1 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            java.lang.String r5 = " size out of range: "
            java.lang.String r7 = "APK Signing Block entry #"
            if (r1 < 0) goto L_0x01d0
            r8 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r1 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r1 > 0) goto L_0x01d0
            int r1 = r0.position()     // Catch:{ all -> 0x029d }
            int r3 = (int) r3     // Catch:{ all -> 0x029d }
            int r1 = r1 + r3
            int r4 = r0.remaining()     // Catch:{ all -> 0x029d }
            if (r3 > r4) goto L_0x01a9
            int r4 = r0.getInt()     // Catch:{ all -> 0x029d }
            r5 = 1896449818(0x7109871a, float:6.810044E29)
            if (r4 != r5) goto L_0x019d
            int r3 = r3 + -4
            java.nio.ByteBuffer r12 = zze(r0, r3)     // Catch:{ all -> 0x029d }
            com.google.android.gms.internal.ads.zzaoj r0 = new com.google.android.gms.internal.ads.zzaoj     // Catch:{ all -> 0x029d }
            r1 = 0
            r3 = r20
            r11 = r0
            r8 = r17
            r15 = r3
            r20 = r1
            r11.<init>(r12, r13, r15, r17, r19, r20)     // Catch:{ all -> 0x029d }
            java.nio.channels.FileChannel r1 = r6.getChannel()     // Catch:{ all -> 0x029d }
            java.security.cert.X509Certificate[][] r0 = zzl(r1, r0)     // Catch:{ all -> 0x029d }
            r6.close()     // Catch:{ all -> 0x029d }
            r6.close()     // Catch:{ IOException -> 0x019c }
        L_0x019c:
            return r0
        L_0x019d:
            r8 = r17
            r3 = r20
            r0.position(r1)     // Catch:{ all -> 0x029d }
            r20 = r3
            r17 = r8
            goto L_0x0140
        L_0x01a9:
            com.google.android.gms.internal.ads.zzaok r1 = new com.google.android.gms.internal.ads.zzaok     // Catch:{ all -> 0x029d }
            int r0 = r0.remaining()     // Catch:{ all -> 0x029d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x029d }
            r2.<init>()     // Catch:{ all -> 0x029d }
            r2.append(r7)     // Catch:{ all -> 0x029d }
            r2.append(r12)     // Catch:{ all -> 0x029d }
            r2.append(r5)     // Catch:{ all -> 0x029d }
            r2.append(r3)     // Catch:{ all -> 0x029d }
            java.lang.String r3 = ", available: "
            r2.append(r3)     // Catch:{ all -> 0x029d }
            r2.append(r0)     // Catch:{ all -> 0x029d }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x029d }
            r1.<init>(r0)     // Catch:{ all -> 0x029d }
            throw r1     // Catch:{ all -> 0x029d }
        L_0x01d0:
            com.google.android.gms.internal.ads.zzaok r0 = new com.google.android.gms.internal.ads.zzaok     // Catch:{ all -> 0x029d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x029d }
            r1.<init>()     // Catch:{ all -> 0x029d }
            r1.append(r7)     // Catch:{ all -> 0x029d }
            r1.append(r12)     // Catch:{ all -> 0x029d }
            r1.append(r5)     // Catch:{ all -> 0x029d }
            r1.append(r3)     // Catch:{ all -> 0x029d }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x029d }
            r0.<init>(r1)     // Catch:{ all -> 0x029d }
            throw r0     // Catch:{ all -> 0x029d }
        L_0x01eb:
            com.google.android.gms.internal.ads.zzaok r0 = new com.google.android.gms.internal.ads.zzaok     // Catch:{ all -> 0x029d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x029d }
            r1.<init>()     // Catch:{ all -> 0x029d }
            java.lang.String r2 = "Insufficient data to read size of APK Signing Block entry #"
            r1.append(r2)     // Catch:{ all -> 0x029d }
            r1.append(r12)     // Catch:{ all -> 0x029d }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x029d }
            r0.<init>(r1)     // Catch:{ all -> 0x029d }
            throw r0     // Catch:{ all -> 0x029d }
        L_0x0202:
            com.google.android.gms.internal.ads.zzaok r0 = new com.google.android.gms.internal.ads.zzaok     // Catch:{ all -> 0x029d }
            java.lang.String r1 = "No APK Signature Scheme v2 block in APK Signing Block"
            r0.<init>(r1)     // Catch:{ all -> 0x029d }
            throw r0     // Catch:{ all -> 0x029d }
        L_0x020a:
            r0 = move-exception
            r3 = 0
            r4.position(r3)     // Catch:{ all -> 0x029d }
            r4.limit(r1)     // Catch:{ all -> 0x029d }
            r4.position(r2)     // Catch:{ all -> 0x029d }
            throw r0     // Catch:{ all -> 0x029d }
        L_0x0216:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x029d }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x029d }
            r4.<init>(r1)     // Catch:{ all -> 0x029d }
            r4.append(r3)     // Catch:{ all -> 0x029d }
            java.lang.String r1 = " > "
            r4.append(r1)     // Catch:{ all -> 0x029d }
            r4.append(r0)     // Catch:{ all -> 0x029d }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x029d }
            r2.<init>(r0)     // Catch:{ all -> 0x029d }
            throw r2     // Catch:{ all -> 0x029d }
        L_0x0230:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x029d }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x029d }
            r4.<init>(r2)     // Catch:{ all -> 0x029d }
            r4.append(r3)     // Catch:{ all -> 0x029d }
            r4.append(r0)     // Catch:{ all -> 0x029d }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x029d }
            r1.<init>(r0)     // Catch:{ all -> 0x029d }
            throw r1     // Catch:{ all -> 0x029d }
        L_0x0245:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x029d }
            java.lang.String r1 = "ByteBuffer byte order must be little endian"
            r0.<init>(r1)     // Catch:{ all -> 0x029d }
            throw r0     // Catch:{ all -> 0x029d }
        L_0x024d:
            com.google.android.gms.internal.ads.zzaok r0 = new com.google.android.gms.internal.ads.zzaok     // Catch:{ all -> 0x029d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x029d }
            r1.<init>(r3)     // Catch:{ all -> 0x029d }
            r1.append(r10)     // Catch:{ all -> 0x029d }
            java.lang.String r2 = " vs "
            r1.append(r2)     // Catch:{ all -> 0x029d }
            r1.append(r13)     // Catch:{ all -> 0x029d }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x029d }
            r0.<init>(r1)     // Catch:{ all -> 0x029d }
            throw r0     // Catch:{ all -> 0x029d }
        L_0x0267:
            r0 = move-exception
            r1 = r21
            goto L_0x0303
        L_0x026c:
            r6 = r21
            com.google.android.gms.internal.ads.zzaok r0 = new com.google.android.gms.internal.ads.zzaok     // Catch:{ all -> 0x029d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x029d }
            r1.<init>(r4)     // Catch:{ all -> 0x029d }
            r1.append(r8)     // Catch:{ all -> 0x029d }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x029d }
            r0.<init>(r1)     // Catch:{ all -> 0x029d }
            throw r0     // Catch:{ all -> 0x029d }
        L_0x0280:
            r6 = r21
            com.google.android.gms.internal.ads.zzaok r0 = new com.google.android.gms.internal.ads.zzaok     // Catch:{ all -> 0x029d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x029d }
            r1.<init>(r5)     // Catch:{ all -> 0x029d }
            r1.append(r13)     // Catch:{ all -> 0x029d }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x029d }
            r0.<init>(r1)     // Catch:{ all -> 0x029d }
            throw r0     // Catch:{ all -> 0x029d }
        L_0x0294:
            r6 = r9
            com.google.android.gms.internal.ads.zzaok r0 = new com.google.android.gms.internal.ads.zzaok     // Catch:{ all -> 0x029d }
            java.lang.String r1 = "No APK Signing Block before ZIP Central Directory"
            r0.<init>(r1)     // Catch:{ all -> 0x029d }
            throw r0     // Catch:{ all -> 0x029d }
        L_0x029d:
            r0 = move-exception
            r1 = r6
            goto L_0x0303
        L_0x02a0:
            r1 = r9
            r3 = r10
            com.google.android.gms.internal.ads.zzaok r0 = new com.google.android.gms.internal.ads.zzaok     // Catch:{ all -> 0x02ff }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x02ff }
            r2.<init>(r6)     // Catch:{ all -> 0x02ff }
            r2.append(r3)     // Catch:{ all -> 0x02ff }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x02ff }
            r0.<init>(r2)     // Catch:{ all -> 0x02ff }
            throw r0     // Catch:{ all -> 0x02ff }
        L_0x02b4:
            r1 = r9
            com.google.android.gms.internal.ads.zzaok r0 = new com.google.android.gms.internal.ads.zzaok     // Catch:{ all -> 0x02ff }
            java.lang.String r2 = "ZIP Central Directory is not immediately followed by End of Central Directory"
            r0.<init>(r2)     // Catch:{ all -> 0x02ff }
            throw r0     // Catch:{ all -> 0x02ff }
        L_0x02bd:
            r1 = r9
            r3 = r10
            r8 = r13
            com.google.android.gms.internal.ads.zzaok r0 = new com.google.android.gms.internal.ads.zzaok     // Catch:{ all -> 0x02ff }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x02ff }
            r2.<init>(r7)     // Catch:{ all -> 0x02ff }
            r2.append(r3)     // Catch:{ all -> 0x02ff }
            java.lang.String r3 = ". ZIP End of Central Directory offset: "
            r2.append(r3)     // Catch:{ all -> 0x02ff }
            r2.append(r8)     // Catch:{ all -> 0x02ff }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x02ff }
            r0.<init>(r2)     // Catch:{ all -> 0x02ff }
            throw r0     // Catch:{ all -> 0x02ff }
        L_0x02da:
            r1 = r9
            com.google.android.gms.internal.ads.zzaok r0 = new com.google.android.gms.internal.ads.zzaok     // Catch:{ all -> 0x02ff }
            java.lang.String r2 = "ZIP64 APK not supported"
            r0.<init>(r2)     // Catch:{ all -> 0x02ff }
            throw r0     // Catch:{ all -> 0x02ff }
        L_0x02e3:
            r1 = r9
            com.google.android.gms.internal.ads.zzaok r0 = new com.google.android.gms.internal.ads.zzaok     // Catch:{ all -> 0x02ff }
            long r2 = r1.length()     // Catch:{ all -> 0x02ff }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x02ff }
            r4.<init>(r8)     // Catch:{ all -> 0x02ff }
            r4.append(r2)     // Catch:{ all -> 0x02ff }
            java.lang.String r2 = " bytes"
            r4.append(r2)     // Catch:{ all -> 0x02ff }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x02ff }
            r0.<init>(r2)     // Catch:{ all -> 0x02ff }
            throw r0     // Catch:{ all -> 0x02ff }
        L_0x02ff:
            r0 = move-exception
            goto L_0x0303
        L_0x0301:
            r0 = move-exception
            r1 = r9
        L_0x0303:
            r1.close()     // Catch:{ IOException -> 0x0306 }
        L_0x0306:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaon.zza(java.lang.String):java.security.cert.X509Certificate[][]");
    }

    private static int zzb(int i) {
        if (i == 1) {
            return 32;
        }
        if (i == 2) {
            return 64;
        }
        throw new IllegalArgumentException(lf.h("Unknown content digest algorthm: ", i));
    }

    private static int zzc(int i) {
        if (i == 513) {
            return 1;
        }
        if (i == 514) {
            return 2;
        }
        if (i == 769) {
            return 1;
        }
        switch (i) {
            case 257:
            case 259:
                return 1;
            case 258:
            case 260:
                return 2;
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x".concat(String.valueOf(Long.toHexString((long) i))));
        }
    }

    private static String zzd(int i) {
        if (i == 1) {
            return "SHA-256";
        }
        if (i == 2) {
            return "SHA-512";
        }
        throw new IllegalArgumentException(lf.h("Unknown content digest algorthm: ", i));
    }

    private static ByteBuffer zze(ByteBuffer byteBuffer, int i) throws BufferUnderflowException {
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        int i2 = i + position;
        if (i2 < position || i2 > limit) {
            throw new BufferUnderflowException();
        }
        byteBuffer.limit(i2);
        try {
            ByteBuffer slice = byteBuffer.slice();
            slice.order(byteBuffer.order());
            byteBuffer.position(i2);
            return slice;
        } finally {
            byteBuffer.limit(limit);
        }
    }

    private static ByteBuffer zzf(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() >= 4) {
            int i = byteBuffer.getInt();
            if (i < 0) {
                throw new IllegalArgumentException("Negative length");
            } else if (i <= byteBuffer.remaining()) {
                return zze(byteBuffer, i);
            } else {
                throw new IOException(lf.i("Length-prefixed field longer than remaining buffer. Field length: ", i, ", remaining: ", byteBuffer.remaining()));
            }
        } else {
            throw new IOException(lf.h("Remaining buffer too short to contain length of length-prefixed field. Remaining: ", byteBuffer.remaining()));
        }
    }

    private static void zzg(int i, byte[] bArr, int i2) {
        bArr[1] = (byte) (i & Constants.MAX_HOST_LENGTH);
        bArr[2] = (byte) ((i >>> 8) & Constants.MAX_HOST_LENGTH);
        bArr[3] = (byte) ((i >>> 16) & Constants.MAX_HOST_LENGTH);
        bArr[4] = (byte) (i >> 24);
    }

    private static void zzh(Map map, FileChannel fileChannel, long j, long j2, long j3, ByteBuffer byteBuffer) throws SecurityException {
        if (!map.isEmpty()) {
            zzaoh zzaoh = new zzaoh(fileChannel, 0, j);
            zzaoh zzaoh2 = new zzaoh(fileChannel, j2, j3 - j2);
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.order(ByteOrder.LITTLE_ENDIAN);
            long j4 = j;
            zzaoo.zzd(duplicate, j);
            zzaof zzaof = new zzaof(duplicate);
            int size = map.size();
            int[] iArr = new int[size];
            int i = 0;
            int i2 = 0;
            for (Integer intValue : map.keySet()) {
                iArr[i2] = intValue.intValue();
                i2++;
            }
            try {
                byte[][] zzk = zzk(iArr, new zzaog[]{zzaoh, zzaoh2, zzaof});
                while (i < size) {
                    int i3 = iArr[i];
                    Map map2 = map;
                    if (MessageDigest.isEqual((byte[]) map.get(Integer.valueOf(i3)), zzk[i])) {
                        i++;
                    } else {
                        throw new SecurityException(zzd(i3).concat(" digest of contents did not verify"));
                    }
                }
            } catch (DigestException e) {
                throw new SecurityException("Failed to compute digest(s) of contents", e);
            }
        } else {
            throw new SecurityException("No digests provided");
        }
    }

    private static byte[] zzi(ByteBuffer byteBuffer) throws IOException {
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new IOException("Negative length");
        } else if (i <= byteBuffer.remaining()) {
            byte[] bArr = new byte[i];
            byteBuffer.get(bArr);
            return bArr;
        } else {
            throw new IOException(lf.i("Underflow while reading length-prefixed value. Length: ", i, ", available: ", byteBuffer.remaining()));
        }
    }

    private static X509Certificate[] zzj(ByteBuffer byteBuffer, Map map, CertificateFactory certificateFactory) throws SecurityException, IOException {
        String str;
        Pair pair;
        ByteBuffer zzf = zzf(byteBuffer);
        ByteBuffer zzf2 = zzf(byteBuffer);
        byte[] zzi = zzi(byteBuffer);
        ArrayList arrayList = new ArrayList();
        byte[] bArr = null;
        int i = 0;
        byte[] bArr2 = null;
        int i2 = -1;
        while (zzf2.hasRemaining()) {
            i++;
            try {
                ByteBuffer zzf3 = zzf(zzf2);
                if (zzf3.remaining() >= 8) {
                    int i3 = zzf3.getInt();
                    arrayList.add(Integer.valueOf(i3));
                    if (!(i3 == 513 || i3 == 514 || i3 == 769)) {
                        switch (i3) {
                            case 257:
                            case 258:
                            case 259:
                            case 260:
                                break;
                            default:
                                continue;
                        }
                    }
                    if (i2 != -1) {
                        int zzc = zzc(i3);
                        int zzc2 = zzc(i2);
                        if (zzc != 1) {
                            if (zzc2 != 1) {
                            }
                        }
                    }
                    bArr2 = zzi(zzf3);
                    i2 = i3;
                } else {
                    throw new SecurityException("Signature record too short");
                }
            } catch (IOException | BufferUnderflowException e) {
                throw new SecurityException(lf.h("Failed to parse signature record #", i), e);
            }
        }
        if (i2 != -1) {
            if (i2 == 513 || i2 == 514) {
                str = "EC";
            } else if (i2 != 769) {
                switch (i2) {
                    case 257:
                    case 258:
                    case 259:
                    case 260:
                        str = "RSA";
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown signature algorithm: 0x".concat(String.valueOf(Long.toHexString((long) i2))));
                }
            } else {
                str = "DSA";
            }
            if (i2 == 513) {
                pair = Pair.create("SHA256withECDSA", (Object) null);
            } else if (i2 == 514) {
                pair = Pair.create("SHA512withECDSA", (Object) null);
            } else if (i2 != 769) {
                switch (i2) {
                    case 257:
                        pair = Pair.create("SHA256withRSA/PSS", new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                        break;
                    case 258:
                        pair = Pair.create("SHA512withRSA/PSS", new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
                        break;
                    case 259:
                        pair = Pair.create("SHA256withRSA", (Object) null);
                        break;
                    case 260:
                        pair = Pair.create("SHA512withRSA", (Object) null);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown signature algorithm: 0x".concat(String.valueOf(Long.toHexString((long) i2))));
                }
            } else {
                pair = Pair.create("SHA256withDSA", (Object) null);
            }
            String str2 = (String) pair.first;
            AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) pair.second;
            try {
                PublicKey generatePublic = KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(zzi));
                Signature instance = Signature.getInstance(str2);
                instance.initVerify(generatePublic);
                if (algorithmParameterSpec != null) {
                    instance.setParameter(algorithmParameterSpec);
                }
                instance.update(zzf);
                if (instance.verify(bArr2)) {
                    zzf.clear();
                    ByteBuffer zzf4 = zzf(zzf);
                    ArrayList arrayList2 = new ArrayList();
                    int i4 = 0;
                    while (zzf4.hasRemaining()) {
                        i4++;
                        try {
                            ByteBuffer zzf5 = zzf(zzf4);
                            if (zzf5.remaining() >= 8) {
                                int i5 = zzf5.getInt();
                                arrayList2.add(Integer.valueOf(i5));
                                if (i5 == i2) {
                                    bArr = zzi(zzf5);
                                }
                            } else {
                                throw new IOException("Record too short");
                            }
                        } catch (IOException | BufferUnderflowException e2) {
                            throw new IOException(lf.h("Failed to parse digest record #", i4), e2);
                        }
                    }
                    if (arrayList.equals(arrayList2)) {
                        int zzc3 = zzc(i2);
                        byte[] bArr3 = (byte[]) map.put(Integer.valueOf(zzc3), bArr);
                        if (bArr3 == null || MessageDigest.isEqual(bArr3, bArr)) {
                            ByteBuffer zzf6 = zzf(zzf);
                            ArrayList arrayList3 = new ArrayList();
                            int i6 = 0;
                            while (zzf6.hasRemaining()) {
                                i6++;
                                byte[] zzi2 = zzi(zzf6);
                                try {
                                    arrayList3.add(new zzaol((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(zzi2)), zzi2));
                                } catch (CertificateException e3) {
                                    throw new SecurityException(lf.h("Failed to decode certificate #", i6), e3);
                                }
                            }
                            if (arrayList3.isEmpty()) {
                                throw new SecurityException("No certificates listed");
                            } else if (Arrays.equals(zzi, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                                return (X509Certificate[]) arrayList3.toArray(new X509Certificate[arrayList3.size()]);
                            } else {
                                throw new SecurityException("Public key mismatch between certificate and signature record");
                            }
                        } else {
                            throw new SecurityException(zzd(zzc3).concat(" contents digest does not match the digest specified by a preceding signer"));
                        }
                    } else {
                        throw new SecurityException("Signature algorithms don't match between digests and signatures records");
                    }
                } else {
                    throw new SecurityException(String.valueOf(str2).concat(" signature did not verify"));
                }
            } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException e4) {
                throw new SecurityException(lf.j("Failed to verify ", str2, " signature"), e4);
            }
        } else if (i == 0) {
            throw new SecurityException("No signatures found");
        } else {
            throw new SecurityException("No supported signatures found");
        }
    }

    private static byte[][] zzk(int[] iArr, zzaog[] zzaogArr) throws DigestException {
        int length;
        int[] iArr2 = iArr;
        int i = 0;
        long j = 0;
        for (int i2 = 0; i2 < 3; i2++) {
            j += (zzaogArr[i2].zza() + 1048575) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        }
        if (j < 2097151) {
            byte[][] bArr = new byte[iArr2.length][];
            int i3 = 0;
            while (true) {
                length = iArr2.length;
                if (i3 >= length) {
                    break;
                }
                int i4 = (int) j;
                byte[] bArr2 = new byte[((zzb(iArr2[i3]) * i4) + 5)];
                bArr2[0] = 90;
                zzg(i4, bArr2, 1);
                bArr[i3] = bArr2;
                i3++;
            }
            byte[] bArr3 = new byte[5];
            bArr3[0] = -91;
            MessageDigest[] messageDigestArr = new MessageDigest[length];
            int i5 = 0;
            while (i5 < iArr2.length) {
                String zzd = zzd(iArr2[i5]);
                try {
                    messageDigestArr[i5] = MessageDigest.getInstance(zzd);
                    i5++;
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(zzd.concat(" digest not supported"), e);
                }
            }
            int i6 = 3;
            long j2 = 1048576;
            long j3 = 0;
            int i7 = 0;
            int i8 = 0;
            while (i < i6) {
                zzaog zzaog = zzaogArr[i];
                int i9 = i;
                int i10 = i7;
                long zza = zzaog.zza();
                long j4 = j2;
                long j5 = j3;
                while (zza > j3) {
                    int min = (int) Math.min(zza, j4);
                    zzg(min, bArr3, 1);
                    for (int i11 = 0; i11 < length; i11++) {
                        messageDigestArr[i11].update(bArr3);
                    }
                    try {
                        zzaog.zzb(messageDigestArr, j5, min);
                        int i12 = 0;
                        while (i12 < iArr2.length) {
                            int i13 = iArr2[i12];
                            byte[] bArr4 = bArr[i12];
                            int zzb = zzb(i13);
                            byte[] bArr5 = bArr3;
                            MessageDigest messageDigest = messageDigestArr[i12];
                            MessageDigest[] messageDigestArr2 = messageDigestArr;
                            int digest = messageDigest.digest(bArr4, (i8 * zzb) + 5, zzb);
                            if (digest == zzb) {
                                i12++;
                                bArr3 = bArr5;
                                messageDigestArr = messageDigestArr2;
                            } else {
                                throw new RuntimeException("Unexpected output size of " + messageDigest.getAlgorithm() + " digest: " + digest);
                            }
                        }
                        byte[] bArr6 = bArr3;
                        long j6 = (long) min;
                        j5 += j6;
                        zza -= j6;
                        i8++;
                        j3 = 0;
                        j4 = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
                        bArr3 = bArr6;
                        messageDigestArr = messageDigestArr;
                    } catch (IOException e2) {
                        throw new DigestException(lf.i("Failed to digest chunk #", i8, " of section #", i10), e2);
                    }
                }
                MessageDigest[] messageDigestArr3 = messageDigestArr;
                i7 = i10 + 1;
                i = i9 + 1;
                j3 = 0;
                j2 = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
                i6 = 3;
                bArr3 = bArr3;
            }
            byte[][] bArr7 = new byte[iArr2.length][];
            int i14 = 0;
            while (i14 < iArr2.length) {
                int i15 = iArr2[i14];
                byte[] bArr8 = bArr[i14];
                String zzd2 = zzd(i15);
                try {
                    bArr7[i14] = MessageDigest.getInstance(zzd2).digest(bArr8);
                    i14++;
                } catch (NoSuchAlgorithmException e3) {
                    throw new RuntimeException(zzd2.concat(" digest not supported"), e3);
                }
            }
            return bArr7;
        }
        throw new DigestException(C0709Uj.h("Too many chunks: ", j));
    }

    private static X509Certificate[][] zzl(FileChannel fileChannel, zzaoj zzaoj) throws SecurityException {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory instance = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer zzf = zzf(zzaoj.zza);
                int i = 0;
                while (zzf.hasRemaining()) {
                    i++;
                    try {
                        arrayList.add(zzj(zzf(zzf), hashMap, instance));
                    } catch (IOException | SecurityException | BufferUnderflowException e) {
                        throw new SecurityException(C1058d.y("Failed to parse/verify signer #", i, " block"), e);
                    }
                }
                if (i <= 0) {
                    throw new SecurityException("No signers found");
                } else if (!hashMap.isEmpty()) {
                    zzh(hashMap, fileChannel, zzaoj.zzb, zzaoj.zzc, zzaoj.zzd, zzaoj.zze);
                    return (X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()][]);
                } else {
                    throw new SecurityException("No content digests found");
                }
            } catch (IOException e2) {
                throw new SecurityException("Failed to read list of signers", e2);
            }
        } catch (CertificateException e3) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e3);
        }
    }
}
