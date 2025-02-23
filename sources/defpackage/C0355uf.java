package defpackage;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;

/* renamed from: uf  reason: default package and case insensitive filesystem */
/* compiled from: ImageLayer */
public final class C0355uf extends C0359v2 {
    public final Gj a;

    /* renamed from: a  reason: collision with other field name */
    public WB f3318a;

    /* renamed from: a  reason: collision with other field name */
    public final Rect f3319a = new Rect();
    public WB b;

    /* renamed from: b  reason: collision with other field name */
    public final Rect f3320b = new Rect();
    public final Lh g = new Lh(3);

    public C0355uf(Ej ej, Sh sh) {
        super(ej, sh);
        Gj gj;
        C0181ej ejVar = ej.f145a;
        if (ejVar == null) {
            gj = null;
        } else {
            gj = ejVar.f2908b.get(sh.f533b);
        }
        this.a = gj;
    }

    public final void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        Gj gj = this.a;
        if (gj != null) {
            float c = UB.c();
            rectF.set(0.0f, 0.0f, ((float) gj.a) * c, ((float) gj.b) * c);
            this.f3359c.mapRect(rectF);
        }
    }

    public final void e(C0344tk tkVar, Object obj) {
        super.e(tkVar, obj);
        if (obj == Kj.f351a) {
            if (tkVar == null) {
                this.f3318a = null;
            } else {
                this.f3318a = new WB(tkVar, null);
            }
        } else if (obj != Kj.a) {
        } else {
            if (tkVar == null) {
                this.b = null;
            } else {
                this.b = new WB(tkVar, null);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:82:0x012f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void l(android.graphics.Canvas r15, android.graphics.Matrix r16, int r17) {
        /*
            r14 = this;
            r1 = r14
            WB r0 = r1.b
            Ej r2 = r1.f3341a
            Gj r3 = r1.a
            r4 = 0
            if (r0 == 0) goto L_0x0014
            java.lang.Object r0 = r0.f()
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            if (r0 == 0) goto L_0x0014
            goto L_0x0135
        L_0x0014:
            Sh r0 = r1.f3345a
            java.lang.String r0 = r0.f533b
            android.graphics.drawable.Drawable$Callback r5 = r2.getCallback()
            r6 = 1
            r7 = 0
            if (r5 != 0) goto L_0x0022
            r5 = r7
            goto L_0x0063
        L_0x0022:
            tf r5 = r2.f149a
            if (r5 == 0) goto L_0x004c
            android.graphics.drawable.Drawable$Callback r8 = r2.getCallback()
            if (r8 != 0) goto L_0x002d
            goto L_0x0038
        L_0x002d:
            boolean r9 = r8 instanceof android.view.View
            if (r9 == 0) goto L_0x0038
            android.view.View r8 = (android.view.View) r8
            android.content.Context r8 = r8.getContext()
            goto L_0x0039
        L_0x0038:
            r8 = r7
        L_0x0039:
            android.content.Context r5 = r5.f3299a
            if (r8 != 0) goto L_0x003f
            if (r5 == 0) goto L_0x0045
        L_0x003f:
            boolean r5 = r5.equals(r8)
            if (r5 == 0) goto L_0x0047
        L_0x0045:
            r5 = r6
            goto L_0x0048
        L_0x0047:
            r5 = r4
        L_0x0048:
            if (r5 != 0) goto L_0x004c
            r2.f149a = r7
        L_0x004c:
            tf r5 = r2.f149a
            if (r5 != 0) goto L_0x0061
            tf r5 = new tf
            android.graphics.drawable.Drawable$Callback r8 = r2.getCallback()
            java.lang.String r9 = r2.f157c
            ej r10 = r2.f145a
            java.util.Map<java.lang.String, Gj> r10 = r10.f2908b
            r5.<init>(r8, r9, r10)
            r2.f149a = r5
        L_0x0061:
            tf r5 = r2.f149a
        L_0x0063:
            if (r5 == 0) goto L_0x012b
            java.lang.String r8 = r5.f3300a
            java.util.Map<java.lang.String, Gj> r9 = r5.f3301a
            java.lang.Object r9 = r9.get(r0)
            Gj r9 = (defpackage.Gj) r9
            if (r9 != 0) goto L_0x0073
            goto L_0x012b
        L_0x0073:
            android.graphics.Bitmap r10 = r9.f233a
            if (r10 == 0) goto L_0x007a
            r0 = r10
            goto L_0x012c
        L_0x007a:
            android.graphics.BitmapFactory$Options r10 = new android.graphics.BitmapFactory$Options
            r10.<init>()
            r10.inScaled = r6
            r11 = 160(0xa0, float:2.24E-43)
            r10.inDensity = r11
            java.lang.String r11 = r9.f234a
            java.lang.String r12 = "data:"
            boolean r12 = r11.startsWith(r12)
            if (r12 == 0) goto L_0x00c4
            java.lang.String r12 = "base64,"
            int r12 = r11.indexOf(r12)
            if (r12 <= 0) goto L_0x00c4
            r8 = 44
            int r8 = r11.indexOf(r8)     // Catch:{ IllegalArgumentException -> 0x00bd }
            int r8 = r8 + r6
            java.lang.String r6 = r11.substring(r8)     // Catch:{ IllegalArgumentException -> 0x00bd }
            byte[] r6 = android.util.Base64.decode(r6, r4)     // Catch:{ IllegalArgumentException -> 0x00bd }
            int r8 = r6.length
            android.graphics.Bitmap r6 = android.graphics.BitmapFactory.decodeByteArray(r6, r4, r8, r10)
            java.lang.Object r8 = defpackage.C0343tf.a
            monitor-enter(r8)
            java.util.Map<java.lang.String, Gj> r5 = r5.f3301a     // Catch:{ all -> 0x00ba }
            java.lang.Object r0 = r5.get(r0)     // Catch:{ all -> 0x00ba }
            Gj r0 = (defpackage.Gj) r0     // Catch:{ all -> 0x00ba }
            r0.f233a = r6     // Catch:{ all -> 0x00ba }
            monitor-exit(r8)     // Catch:{ all -> 0x00ba }
            goto L_0x0110
        L_0x00ba:
            r0 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x00ba }
            throw r0
        L_0x00bd:
            r0 = move-exception
            java.lang.String r5 = "data URL did not have correct base64 format."
            defpackage.Ai.c(r5, r0)
            goto L_0x012b
        L_0x00c4:
            boolean r12 = android.text.TextUtils.isEmpty(r8)     // Catch:{ IOException -> 0x0125 }
            if (r12 != 0) goto L_0x011d
            android.content.Context r12 = r5.f3299a     // Catch:{ IOException -> 0x0125 }
            android.content.res.AssetManager r12 = r12.getAssets()     // Catch:{ IOException -> 0x0125 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0125 }
            r13.<init>()     // Catch:{ IOException -> 0x0125 }
            r13.append(r8)     // Catch:{ IOException -> 0x0125 }
            r13.append(r11)     // Catch:{ IOException -> 0x0125 }
            java.lang.String r8 = r13.toString()     // Catch:{ IOException -> 0x0125 }
            java.io.InputStream r8 = r12.open(r8)     // Catch:{ IOException -> 0x0125 }
            android.graphics.Bitmap r8 = android.graphics.BitmapFactory.decodeStream(r8, r7, r10)     // Catch:{ IllegalArgumentException -> 0x0115 }
            int r10 = r9.a
            int r9 = r9.b
            UB$a r11 = defpackage.UB.f567a
            int r11 = r8.getWidth()
            if (r11 != r10) goto L_0x00fb
            int r11 = r8.getHeight()
            if (r11 != r9) goto L_0x00fb
            r6 = r8
            goto L_0x0102
        L_0x00fb:
            android.graphics.Bitmap r6 = android.graphics.Bitmap.createScaledBitmap(r8, r10, r9, r6)
            r8.recycle()
        L_0x0102:
            java.lang.Object r8 = defpackage.C0343tf.a
            monitor-enter(r8)
            java.util.Map<java.lang.String, Gj> r5 = r5.f3301a     // Catch:{ all -> 0x0112 }
            java.lang.Object r0 = r5.get(r0)     // Catch:{ all -> 0x0112 }
            Gj r0 = (defpackage.Gj) r0     // Catch:{ all -> 0x0112 }
            r0.f233a = r6     // Catch:{ all -> 0x0112 }
            monitor-exit(r8)     // Catch:{ all -> 0x0112 }
        L_0x0110:
            r0 = r6
            goto L_0x012c
        L_0x0112:
            r0 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x0112 }
            throw r0
        L_0x0115:
            r0 = move-exception
            r5 = r0
            java.lang.String r0 = "Unable to decode image."
            defpackage.Ai.c(r0, r5)
            goto L_0x012b
        L_0x011d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ IOException -> 0x0125 }
            java.lang.String r5 = "You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder"
            r0.<init>(r5)     // Catch:{ IOException -> 0x0125 }
            throw r0     // Catch:{ IOException -> 0x0125 }
        L_0x0125:
            r0 = move-exception
            java.lang.String r5 = "Unable to open asset."
            defpackage.Ai.c(r5, r0)
        L_0x012b:
            r0 = r7
        L_0x012c:
            if (r0 == 0) goto L_0x012f
            goto L_0x0135
        L_0x012f:
            if (r3 == 0) goto L_0x0134
            android.graphics.Bitmap r0 = r3.f233a
            goto L_0x0135
        L_0x0134:
            r0 = r7
        L_0x0135:
            if (r0 == 0) goto L_0x0197
            boolean r5 = r0.isRecycled()
            if (r5 != 0) goto L_0x0197
            if (r3 != 0) goto L_0x0140
            goto L_0x0197
        L_0x0140:
            float r5 = defpackage.UB.c()
            Lh r6 = r1.g
            r7 = r17
            r6.setAlpha(r7)
            WB r7 = r1.f3318a
            if (r7 == 0) goto L_0x0158
            java.lang.Object r7 = r7.f()
            android.graphics.ColorFilter r7 = (android.graphics.ColorFilter) r7
            r6.setColorFilter(r7)
        L_0x0158:
            r15.save()
            r15.concat(r16)
            int r7 = r0.getWidth()
            int r8 = r0.getHeight()
            android.graphics.Rect r9 = r1.f3319a
            r9.set(r4, r4, r7, r8)
            boolean r2 = r2.e
            android.graphics.Rect r7 = r1.f3320b
            if (r2 == 0) goto L_0x017f
            int r2 = r3.a
            float r2 = (float) r2
            float r2 = r2 * r5
            int r2 = (int) r2
            int r3 = r3.b
            float r3 = (float) r3
            float r3 = r3 * r5
            int r3 = (int) r3
            r7.set(r4, r4, r2, r3)
            goto L_0x0190
        L_0x017f:
            int r2 = r0.getWidth()
            float r2 = (float) r2
            float r2 = r2 * r5
            int r2 = (int) r2
            int r3 = r0.getHeight()
            float r3 = (float) r3
            float r3 = r3 * r5
            int r3 = (int) r3
            r7.set(r4, r4, r2, r3)
        L_0x0190:
            r2 = r15
            r15.drawBitmap(r0, r9, r7, r6)
            r15.restore()
        L_0x0197:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0355uf.l(android.graphics.Canvas, android.graphics.Matrix, int):void");
    }
}
