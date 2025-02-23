package defpackage;

import java.io.IOException;
import java.util.zip.Inflater;
import okio.BufferedSource;
import okio.Source;
import okio.Timeout;

/* renamed from: Qf  reason: default package and case insensitive filesystem */
/* compiled from: InflaterSource */
public final class C0653Qf implements Source {
    public final Inflater a;

    /* renamed from: a  reason: collision with other field name */
    public final BufferedSource f3766a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f3767a;
    public int c;

    public C0653Qf(As as, Inflater inflater) {
        this.f3766a = as;
        this.a = inflater;
    }

    public final void close() throws IOException {
        if (!this.f3767a) {
            this.a.end();
            this.f3767a = true;
            this.f3766a.close();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0071 A[Catch:{ DataFormatException -> 0x00ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0065 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long read(okio.Buffer r8, long r9) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 0
            int r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r2 < 0) goto L_0x00c5
            boolean r3 = r7.f3767a
            if (r3 != 0) goto L_0x00bd
            if (r2 != 0) goto L_0x000d
            return r0
        L_0x000d:
            java.util.zip.Inflater r0 = r7.a
            boolean r1 = r0.needsInput()
            okio.BufferedSource r2 = r7.f3766a
            r3 = 1
            if (r1 != 0) goto L_0x0019
            goto L_0x004c
        L_0x0019:
            int r1 = r7.c
            if (r1 != 0) goto L_0x001e
            goto L_0x002c
        L_0x001e:
            int r4 = r0.getRemaining()
            int r1 = r1 - r4
            int r4 = r7.c
            int r4 = r4 - r1
            r7.c = r4
            long r4 = (long) r1
            r2.d0(r4)
        L_0x002c:
            int r1 = r0.getRemaining()
            if (r1 != 0) goto L_0x00b5
            boolean r1 = r2.h0()
            if (r1 == 0) goto L_0x003a
            r1 = r3
            goto L_0x004d
        L_0x003a:
            okio.Buffer r1 = r2.d()
            Ov r1 = r1.f5624a
            int r4 = r1.b
            int r5 = r1.a
            int r4 = r4 - r5
            r7.c = r4
            byte[] r1 = r1.f3745a
            r0.setInput(r1, r5, r4)
        L_0x004c:
            r1 = 0
        L_0x004d:
            Ov r3 = r8.w(r3)     // Catch:{ DataFormatException -> 0x00ae }
            int r4 = r3.b     // Catch:{ DataFormatException -> 0x00ae }
            int r4 = 8192 - r4
            long r4 = (long) r4     // Catch:{ DataFormatException -> 0x00ae }
            long r4 = java.lang.Math.min(r9, r4)     // Catch:{ DataFormatException -> 0x00ae }
            int r4 = (int) r4     // Catch:{ DataFormatException -> 0x00ae }
            byte[] r5 = r3.f3745a     // Catch:{ DataFormatException -> 0x00ae }
            int r6 = r3.b     // Catch:{ DataFormatException -> 0x00ae }
            int r4 = r0.inflate(r5, r6, r4)     // Catch:{ DataFormatException -> 0x00ae }
            if (r4 <= 0) goto L_0x0071
            int r9 = r3.b     // Catch:{ DataFormatException -> 0x00ae }
            int r9 = r9 + r4
            r3.b = r9     // Catch:{ DataFormatException -> 0x00ae }
            long r9 = r8.f5623a     // Catch:{ DataFormatException -> 0x00ae }
            long r0 = (long) r4     // Catch:{ DataFormatException -> 0x00ae }
            long r9 = r9 + r0
            r8.f5623a = r9     // Catch:{ DataFormatException -> 0x00ae }
            return r0
        L_0x0071:
            boolean r4 = r0.finished()     // Catch:{ DataFormatException -> 0x00ae }
            if (r4 != 0) goto L_0x0089
            boolean r4 = r0.needsDictionary()     // Catch:{ DataFormatException -> 0x00ae }
            if (r4 == 0) goto L_0x007e
            goto L_0x0089
        L_0x007e:
            if (r1 != 0) goto L_0x0081
            goto L_0x000d
        L_0x0081:
            java.io.EOFException r8 = new java.io.EOFException     // Catch:{ DataFormatException -> 0x00ae }
            java.lang.String r9 = "source exhausted prematurely"
            r8.<init>(r9)     // Catch:{ DataFormatException -> 0x00ae }
            throw r8     // Catch:{ DataFormatException -> 0x00ae }
        L_0x0089:
            int r9 = r7.c     // Catch:{ DataFormatException -> 0x00ae }
            if (r9 != 0) goto L_0x008e
            goto L_0x009c
        L_0x008e:
            int r10 = r0.getRemaining()     // Catch:{ DataFormatException -> 0x00ae }
            int r9 = r9 - r10
            int r10 = r7.c     // Catch:{ DataFormatException -> 0x00ae }
            int r10 = r10 - r9
            r7.c = r10     // Catch:{ DataFormatException -> 0x00ae }
            long r9 = (long) r9     // Catch:{ DataFormatException -> 0x00ae }
            r2.d0(r9)     // Catch:{ DataFormatException -> 0x00ae }
        L_0x009c:
            int r9 = r3.a     // Catch:{ DataFormatException -> 0x00ae }
            int r10 = r3.b     // Catch:{ DataFormatException -> 0x00ae }
            if (r9 != r10) goto L_0x00ab
            Ov r9 = r3.a()     // Catch:{ DataFormatException -> 0x00ae }
            r8.f5624a = r9     // Catch:{ DataFormatException -> 0x00ae }
            defpackage.Qv.a(r3)     // Catch:{ DataFormatException -> 0x00ae }
        L_0x00ab:
            r8 = -1
            return r8
        L_0x00ae:
            r8 = move-exception
            java.io.IOException r9 = new java.io.IOException
            r9.<init>(r8)
            throw r9
        L_0x00b5:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "?"
            r8.<init>(r9)
            throw r8
        L_0x00bd:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "closed"
            r8.<init>(r9)
            throw r8
        L_0x00c5:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "byteCount < 0: "
            java.lang.String r9 = defpackage.C0709Uj.h(r0, r9)
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0653Qf.read(okio.Buffer, long):long");
    }

    public final Timeout timeout() {
        return this.f3766a.timeout();
    }
}
