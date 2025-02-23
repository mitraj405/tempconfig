package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzcdg extends zzfl implements zzgp {
    private static final Pattern zza = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference zzb = new AtomicReference();
    private final SSLSocketFactory zzc = new zzcdf(this);
    private final int zzd;
    private final int zze;
    private final String zzf;
    private final zzgo zzg;
    private zzfy zzh;
    private HttpURLConnection zzi;
    private InputStream zzj;
    private boolean zzk;
    private int zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    /* access modifiers changed from: private */
    public int zzq;
    private final Set zzr = new HashSet();

    public zzcdg(String str, zzgu zzgu, int i, int i2, int i3) {
        super(true);
        zzdi.zzc(str);
        this.zzf = str;
        this.zzg = new zzgo();
        this.zzd = i;
        this.zze = i2;
        this.zzq = i3;
        if (zzgu != null) {
            zzf(zzgu);
        }
    }

    private final void zzn() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                zzm.zzh("Unexpected error while disconnecting", e);
            }
            this.zzi = null;
        }
    }

    public final int zza(byte[] bArr, int i, int i2) throws zzgl {
        try {
            if (this.zzo != this.zzm) {
                byte[] bArr2 = (byte[]) zzb.getAndSet((Object) null);
                if (bArr2 == null) {
                    bArr2 = new byte[4096];
                }
                while (true) {
                    long j = this.zzo;
                    long j2 = this.zzm;
                    if (j == j2) {
                        zzb.set(bArr2);
                        break;
                    }
                    int read = this.zzj.read(bArr2, 0, (int) Math.min(j2 - j, (long) bArr2.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    } else if (read != -1) {
                        this.zzo += (long) read;
                        zzg(read);
                    } else {
                        throw new EOFException();
                    }
                }
            }
            if (i2 == 0) {
                return 0;
            }
            long j3 = this.zzn;
            if (j3 != -1) {
                long j4 = j3 - this.zzp;
                if (j4 != 0) {
                    i2 = (int) Math.min((long) i2, j4);
                }
                return -1;
            }
            int read2 = this.zzj.read(bArr, i, i2);
            if (read2 != -1) {
                this.zzp += (long) read2;
                zzg(read2);
                return read2;
            } else if (this.zzn == -1) {
                return -1;
            } else {
                throw new EOFException();
            }
        } catch (IOException e) {
            throw new zzgl(e, this.zzh, 2000, 2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0100, code lost:
        if (r2 == 0) goto L_0x0102;
     */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x00e6 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b7 A[Catch:{ IOException -> 0x028a }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e4 A[Catch:{ IOException -> 0x028a }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01b9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzb(com.google.android.gms.internal.ads.zzfy r21) throws com.google.android.gms.internal.ads.zzgl {
        /*
            r20 = this;
            r1 = r20
            r7 = r21
            java.lang.String r2 = "Unable to connect to "
            r1.zzh = r7
            r3 = 0
            r1.zzp = r3
            r1.zzo = r3
            java.net.URL r0 = new java.net.URL     // Catch:{ IOException -> 0x028a }
            android.net.Uri r5 = r7.zza     // Catch:{ IOException -> 0x028a }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x028a }
            r0.<init>(r5)     // Catch:{ IOException -> 0x028a }
            long r5 = r7.zze     // Catch:{ IOException -> 0x028a }
            long r8 = r7.zzf     // Catch:{ IOException -> 0x028a }
            r10 = 1
            boolean r11 = r7.zzb(r10)     // Catch:{ IOException -> 0x028a }
            r13 = 0
        L_0x0023:
            int r14 = r13 + 1
            r15 = 20
            if (r13 > r15) goto L_0x0273
            java.net.URLConnection r13 = r0.openConnection()     // Catch:{ IOException -> 0x028a }
            java.net.HttpURLConnection r13 = (java.net.HttpURLConnection) r13     // Catch:{ IOException -> 0x028a }
            boolean r15 = r13 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ IOException -> 0x028a }
            if (r15 == 0) goto L_0x003b
            r15 = r13
            javax.net.ssl.HttpsURLConnection r15 = (javax.net.ssl.HttpsURLConnection) r15     // Catch:{ IOException -> 0x028a }
            javax.net.ssl.SSLSocketFactory r10 = r1.zzc     // Catch:{ IOException -> 0x028a }
            r15.setSSLSocketFactory(r10)     // Catch:{ IOException -> 0x028a }
        L_0x003b:
            int r10 = r1.zzd     // Catch:{ IOException -> 0x028a }
            r13.setConnectTimeout(r10)     // Catch:{ IOException -> 0x028a }
            int r10 = r1.zze     // Catch:{ IOException -> 0x028a }
            r13.setReadTimeout(r10)     // Catch:{ IOException -> 0x028a }
            com.google.android.gms.internal.ads.zzgo r10 = r1.zzg     // Catch:{ IOException -> 0x028a }
            java.util.Map r10 = r10.zza()     // Catch:{ IOException -> 0x028a }
            java.util.Set r10 = r10.entrySet()     // Catch:{ IOException -> 0x028a }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ IOException -> 0x028a }
        L_0x0053:
            boolean r15 = r10.hasNext()     // Catch:{ IOException -> 0x028a }
            if (r15 == 0) goto L_0x0071
            java.lang.Object r15 = r10.next()     // Catch:{ IOException -> 0x028a }
            java.util.Map$Entry r15 = (java.util.Map.Entry) r15     // Catch:{ IOException -> 0x028a }
            java.lang.Object r16 = r15.getKey()     // Catch:{ IOException -> 0x028a }
            r12 = r16
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ IOException -> 0x028a }
            java.lang.Object r15 = r15.getValue()     // Catch:{ IOException -> 0x028a }
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ IOException -> 0x028a }
            r13.setRequestProperty(r12, r15)     // Catch:{ IOException -> 0x028a }
            goto L_0x0053
        L_0x0071:
            int r10 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            r18 = -1
            if (r10 != 0) goto L_0x007c
            int r10 = (r8 > r18 ? 1 : (r8 == r18 ? 0 : -1))
            if (r10 == 0) goto L_0x00ae
            goto L_0x007d
        L_0x007c:
            r3 = r5
        L_0x007d:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x028a }
            r10.<init>()     // Catch:{ IOException -> 0x028a }
            java.lang.String r12 = "bytes="
            r10.append(r12)     // Catch:{ IOException -> 0x028a }
            r10.append(r3)     // Catch:{ IOException -> 0x028a }
            java.lang.String r12 = "-"
            r10.append(r12)     // Catch:{ IOException -> 0x028a }
            java.lang.String r10 = r10.toString()     // Catch:{ IOException -> 0x028a }
            int r12 = (r8 > r18 ? 1 : (r8 == r18 ? 0 : -1))
            if (r12 == 0) goto L_0x00a9
            long r3 = r3 + r8
            long r3 = r3 + r18
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x028a }
            r12.<init>()     // Catch:{ IOException -> 0x028a }
            r12.append(r10)     // Catch:{ IOException -> 0x028a }
            r12.append(r3)     // Catch:{ IOException -> 0x028a }
            java.lang.String r10 = r12.toString()     // Catch:{ IOException -> 0x028a }
        L_0x00a9:
            java.lang.String r3 = "Range"
            r13.setRequestProperty(r3, r10)     // Catch:{ IOException -> 0x028a }
        L_0x00ae:
            java.lang.String r3 = "User-Agent"
            java.lang.String r4 = r1.zzf     // Catch:{ IOException -> 0x028a }
            r13.setRequestProperty(r3, r4)     // Catch:{ IOException -> 0x028a }
            if (r11 != 0) goto L_0x00be
            java.lang.String r3 = "Accept-Encoding"
            java.lang.String r4 = "identity"
            r13.setRequestProperty(r3, r4)     // Catch:{ IOException -> 0x028a }
        L_0x00be:
            r3 = 0
            r13.setInstanceFollowRedirects(r3)     // Catch:{ IOException -> 0x028a }
            r13.setDoOutput(r3)     // Catch:{ IOException -> 0x028a }
            r13.connect()     // Catch:{ IOException -> 0x028a }
            int r4 = r13.getResponseCode()     // Catch:{ IOException -> 0x028a }
            r10 = 300(0x12c, float:4.2E-43)
            if (r4 == r10) goto L_0x022c
            r10 = 301(0x12d, float:4.22E-43)
            if (r4 == r10) goto L_0x022c
            r10 = 302(0x12e, float:4.23E-43)
            if (r4 == r10) goto L_0x022c
            r10 = 303(0x12f, float:4.25E-43)
            if (r4 == r10) goto L_0x022c
            r10 = 307(0x133, float:4.3E-43)
            if (r4 == r10) goto L_0x022c
            r10 = 308(0x134, float:4.32E-43)
            if (r4 != r10) goto L_0x00e6
            goto L_0x022c
        L_0x00e6:
            r1.zzi = r13     // Catch:{ IOException -> 0x028a }
            int r0 = r13.getResponseCode()     // Catch:{ IOException -> 0x020c }
            r1.zzl = r0     // Catch:{ IOException -> 0x020c }
            r2 = 200(0xc8, float:2.8E-43)
            if (r0 < r2) goto L_0x01e4
            r3 = 299(0x12b, float:4.19E-43)
            if (r0 <= r3) goto L_0x00f8
            goto L_0x01e4
        L_0x00f8:
            if (r0 != r2) goto L_0x0102
            long r2 = r7.zze
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x0104
        L_0x0102:
            r2 = 0
        L_0x0104:
            r1.zzm = r2
            r2 = 1
            boolean r0 = r7.zzb(r2)
            if (r0 != 0) goto L_0x01c2
            long r2 = r7.zzf
            int r0 = (r2 > r18 ? 1 : (r2 == r18 ? 0 : -1))
            if (r0 == 0) goto L_0x0117
            r1.zzn = r2
            goto L_0x01c6
        L_0x0117:
            java.net.HttpURLConnection r0 = r1.zzi
            java.lang.String r2 = "Content-Length"
            java.lang.String r2 = r0.getHeaderField(r2)
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            java.lang.String r4 = "]"
            if (r3 != 0) goto L_0x0140
            long r5 = java.lang.Long.parseLong(r2)     // Catch:{ NumberFormatException -> 0x012c }
            goto L_0x0142
        L_0x012c:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r5 = "Unexpected Content-Length ["
            r3.<init>(r5)
            r3.append(r2)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.google.android.gms.ads.internal.util.client.zzm.zzg(r3)
        L_0x0140:
            r5 = r18
        L_0x0142:
            java.lang.String r3 = "Content-Range"
            java.lang.String r0 = r0.getHeaderField(r3)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 != 0) goto L_0x01b5
            java.util.regex.Pattern r3 = zza
            java.util.regex.Matcher r3 = r3.matcher(r0)
            boolean r8 = r3.find()
            if (r8 == 0) goto L_0x01b5
            r8 = 2
            java.lang.String r8 = r3.group(r8)     // Catch:{ NumberFormatException -> 0x01a1 }
            long r8 = java.lang.Long.parseLong(r8)     // Catch:{ NumberFormatException -> 0x01a1 }
            r10 = 1
            java.lang.String r3 = r3.group(r10)     // Catch:{ NumberFormatException -> 0x01a1 }
            long r10 = java.lang.Long.parseLong(r3)     // Catch:{ NumberFormatException -> 0x01a1 }
            long r8 = r8 - r10
            r16 = 0
            int r3 = (r5 > r16 ? 1 : (r5 == r16 ? 0 : -1))
            r10 = 1
            long r8 = r8 + r10
            if (r3 >= 0) goto L_0x0178
            r5 = r8
            goto L_0x01b5
        L_0x0178:
            int r3 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r3 == 0) goto L_0x01b5
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x01a1 }
            r3.<init>()     // Catch:{ NumberFormatException -> 0x01a1 }
            java.lang.String r10 = "Inconsistent headers ["
            r3.append(r10)     // Catch:{ NumberFormatException -> 0x01a1 }
            r3.append(r2)     // Catch:{ NumberFormatException -> 0x01a1 }
            java.lang.String r2 = "] ["
            r3.append(r2)     // Catch:{ NumberFormatException -> 0x01a1 }
            r3.append(r0)     // Catch:{ NumberFormatException -> 0x01a1 }
            r3.append(r4)     // Catch:{ NumberFormatException -> 0x01a1 }
            java.lang.String r2 = r3.toString()     // Catch:{ NumberFormatException -> 0x01a1 }
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r2)     // Catch:{ NumberFormatException -> 0x01a1 }
            long r2 = java.lang.Math.max(r5, r8)     // Catch:{ NumberFormatException -> 0x01a1 }
            r5 = r2
            goto L_0x01b5
        L_0x01a1:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Unexpected Content-Range ["
            r2.<init>(r3)
            r2.append(r0)
            r2.append(r4)
            java.lang.String r0 = r2.toString()
            com.google.android.gms.ads.internal.util.client.zzm.zzg(r0)
        L_0x01b5:
            int r0 = (r5 > r18 ? 1 : (r5 == r18 ? 0 : -1))
            if (r0 == 0) goto L_0x01bd
            long r2 = r1.zzm
            long r18 = r5 - r2
        L_0x01bd:
            r2 = r18
            r1.zzn = r2
            goto L_0x01c6
        L_0x01c2:
            long r2 = r7.zzf
            r1.zzn = r2
        L_0x01c6:
            java.net.HttpURLConnection r0 = r1.zzi     // Catch:{ IOException -> 0x01d7 }
            java.io.InputStream r0 = r0.getInputStream()     // Catch:{ IOException -> 0x01d7 }
            r1.zzj = r0     // Catch:{ IOException -> 0x01d7 }
            r2 = 1
            r1.zzk = r2
            r20.zzj(r21)
            long r2 = r1.zzn
            return r2
        L_0x01d7:
            r0 = move-exception
            r20.zzn()
            com.google.android.gms.internal.ads.zzgl r2 = new com.google.android.gms.internal.ads.zzgl
            r3 = 2000(0x7d0, float:2.803E-42)
            r4 = 1
            r2.<init>((java.io.IOException) r0, (com.google.android.gms.internal.ads.zzfy) r7, (int) r3, (int) r4)
            throw r2
        L_0x01e4:
            java.net.HttpURLConnection r0 = r1.zzi
            java.util.Map r6 = r0.getHeaderFields()
            r20.zzn()
            com.google.android.gms.internal.ads.zzgn r0 = new com.google.android.gms.internal.ads.zzgn
            int r3 = r1.zzl
            r4 = 0
            r5 = 0
            byte[] r8 = com.google.android.gms.internal.ads.zzet.zzf
            r2 = r0
            r7 = r21
            r2.<init>(r3, r4, r5, r6, r7, r8)
            int r2 = r1.zzl
            r3 = 416(0x1a0, float:5.83E-43)
            if (r2 != r3) goto L_0x020b
            com.google.android.gms.internal.ads.zzft r2 = new com.google.android.gms.internal.ads.zzft
            r3 = 2008(0x7d8, float:2.814E-42)
            r2.<init>(r3)
            r0.initCause(r2)
        L_0x020b:
            throw r0
        L_0x020c:
            r0 = move-exception
            r4 = r0
            r20.zzn()
            com.google.android.gms.internal.ads.zzgl r0 = new com.google.android.gms.internal.ads.zzgl
            android.net.Uri r3 = r7.zza
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r3 = r2.concat(r3)
            r6 = 2000(0x7d0, float:2.803E-42)
            r8 = 1
            r2 = r0
            r5 = r21
            r7 = r8
            r2.<init>(r3, r4, r5, r6, r7)
            throw r0
        L_0x022c:
            r4 = 1
            r16 = 0
            java.lang.String r10 = "Location"
            java.lang.String r10 = r13.getHeaderField(r10)     // Catch:{ IOException -> 0x028a }
            r13.disconnect()     // Catch:{ IOException -> 0x028a }
            if (r10 == 0) goto L_0x026b
            java.net.URL r12 = new java.net.URL     // Catch:{ IOException -> 0x028a }
            r12.<init>(r0, r10)     // Catch:{ IOException -> 0x028a }
            java.lang.String r0 = r12.getProtocol()     // Catch:{ IOException -> 0x028a }
            java.lang.String r10 = "https"
            boolean r10 = r10.equals(r0)     // Catch:{ IOException -> 0x028a }
            if (r10 != 0) goto L_0x0264
            java.lang.String r10 = "http"
            boolean r10 = r10.equals(r0)     // Catch:{ IOException -> 0x028a }
            if (r10 == 0) goto L_0x0254
            goto L_0x0264
        L_0x0254:
            java.net.ProtocolException r3 = new java.net.ProtocolException     // Catch:{ IOException -> 0x028a }
            java.lang.String r4 = "Unsupported protocol redirect: "
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ IOException -> 0x028a }
            java.lang.String r0 = r4.concat(r0)     // Catch:{ IOException -> 0x028a }
            r3.<init>(r0)     // Catch:{ IOException -> 0x028a }
            throw r3     // Catch:{ IOException -> 0x028a }
        L_0x0264:
            r10 = r4
            r0 = r12
            r13 = r14
            r3 = r16
            goto L_0x0023
        L_0x026b:
            java.net.ProtocolException r0 = new java.net.ProtocolException     // Catch:{ IOException -> 0x028a }
            java.lang.String r3 = "Null location redirect"
            r0.<init>(r3)     // Catch:{ IOException -> 0x028a }
            throw r0     // Catch:{ IOException -> 0x028a }
        L_0x0273:
            java.net.NoRouteToHostException r0 = new java.net.NoRouteToHostException     // Catch:{ IOException -> 0x028a }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x028a }
            r3.<init>()     // Catch:{ IOException -> 0x028a }
            java.lang.String r4 = "Too many redirects: "
            r3.append(r4)     // Catch:{ IOException -> 0x028a }
            r3.append(r14)     // Catch:{ IOException -> 0x028a }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x028a }
            r0.<init>(r3)     // Catch:{ IOException -> 0x028a }
            throw r0     // Catch:{ IOException -> 0x028a }
        L_0x028a:
            r0 = move-exception
            r4 = r0
            com.google.android.gms.internal.ads.zzgl r0 = new com.google.android.gms.internal.ads.zzgl
            android.net.Uri r3 = r7.zza
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r3 = r2.concat(r3)
            r6 = 2000(0x7d0, float:2.803E-42)
            r8 = 1
            r2 = r0
            r5 = r21
            r7 = r8
            r2.<init>(r3, r4, r5, r6, r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcdg.zzb(com.google.android.gms.internal.ads.zzfy):long");
    }

    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    public final void zzd() throws zzgl {
        try {
            InputStream inputStream = this.zzj;
            if (inputStream != null) {
                int i = zzet.zza;
                inputStream.close();
            }
            this.zzj = null;
            zzn();
            if (this.zzk) {
                this.zzk = false;
                zzh();
            }
            this.zzr.clear();
        } catch (IOException e) {
            throw new zzgl(e, this.zzh, 2000, 3);
        } catch (Throwable th) {
            this.zzj = null;
            zzn();
            if (this.zzk) {
                this.zzk = false;
                zzh();
            }
            this.zzr.clear();
            throw th;
        }
    }

    public final Map zze() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    public final void zzm(int i) {
        this.zzq = i;
        for (Socket socket : this.zzr) {
            if (!socket.isClosed()) {
                try {
                    socket.setReceiveBufferSize(this.zzq);
                } catch (SocketException e) {
                    zzm.zzk("Failed to update receive buffer size.", e);
                }
            }
        }
    }
}
