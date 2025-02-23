package androidx.core.app;

import android.app.PendingIntent;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;

/* compiled from: NotificationCompat */
public final class a {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final PendingIntent f1759a;

    /* renamed from: a  reason: collision with other field name */
    public final Bundle f1760a;

    /* renamed from: a  reason: collision with other field name */
    public IconCompat f1761a;

    /* renamed from: a  reason: collision with other field name */
    public final CharSequence f1762a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f1763a;

    /* renamed from: a  reason: collision with other field name */
    public final pt[] f1764a;
    @Deprecated
    public final int b;

    /* renamed from: b  reason: collision with other field name */
    public final boolean f1765b = true;
    public final boolean c;
    public final boolean d;

    /* renamed from: androidx.core.app.a$a  reason: collision with other inner class name */
    /* compiled from: NotificationCompat */
    public static final class C0009a {
        public final int a;

        /* renamed from: a  reason: collision with other field name */
        public final PendingIntent f1766a;

        /* renamed from: a  reason: collision with other field name */
        public final Bundle f1767a;

        /* renamed from: a  reason: collision with other field name */
        public final IconCompat f1768a;

        /* renamed from: a  reason: collision with other field name */
        public final CharSequence f1769a;

        /* renamed from: a  reason: collision with other field name */
        public final ArrayList<pt> f1770a;

        /* renamed from: a  reason: collision with other field name */
        public final boolean f1771a;
        public final boolean b;
        public final boolean c;
        public final boolean d;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public C0009a(int i, String str, PendingIntent pendingIntent) {
            this(i != 0 ? IconCompat.b((Resources) null, "", i) : null, str, pendingIntent, new Bundle());
        }

        /* JADX WARNING: type inference failed for: r1v6, types: [java.lang.Object[]] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.core.app.a a() {
            /*
                r17 = this;
                r0 = r17
                boolean r1 = r0.c
                if (r1 != 0) goto L_0x0007
                goto L_0x000b
            L_0x0007:
                android.app.PendingIntent r1 = r0.f1766a
                if (r1 == 0) goto L_0x0076
            L_0x000b:
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>()
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>()
                java.util.ArrayList<pt> r3 = r0.f1770a
                if (r3 == 0) goto L_0x0030
                java.util.Iterator r3 = r3.iterator()
            L_0x001d:
                boolean r4 = r3.hasNext()
                if (r4 == 0) goto L_0x0030
                java.lang.Object r4 = r3.next()
                pt r4 = (defpackage.pt) r4
                r4.getClass()
                r2.add(r4)
                goto L_0x001d
            L_0x0030:
                boolean r3 = r1.isEmpty()
                r4 = 0
                if (r3 == 0) goto L_0x0039
                r11 = r4
                goto L_0x0046
            L_0x0039:
                int r3 = r1.size()
                pt[] r3 = new defpackage.pt[r3]
                java.lang.Object[] r1 = r1.toArray(r3)
                pt[] r1 = (defpackage.pt[]) r1
                r11 = r1
            L_0x0046:
                boolean r1 = r2.isEmpty()
                if (r1 == 0) goto L_0x004d
                goto L_0x005a
            L_0x004d:
                int r1 = r2.size()
                pt[] r1 = new defpackage.pt[r1]
                java.lang.Object[] r1 = r2.toArray(r1)
                r4 = r1
                pt[] r4 = (defpackage.pt[]) r4
            L_0x005a:
                r10 = r4
                androidx.core.app.a r1 = new androidx.core.app.a
                androidx.core.graphics.drawable.IconCompat r6 = r0.f1768a
                java.lang.CharSequence r7 = r0.f1769a
                android.app.PendingIntent r8 = r0.f1766a
                android.os.Bundle r9 = r0.f1767a
                boolean r12 = r0.f1771a
                int r13 = r0.a
                boolean r14 = r0.b
                boolean r15 = r0.c
                boolean r2 = r0.d
                r5 = r1
                r16 = r2
                r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
                return r1
            L_0x0076:
                java.lang.NullPointerException r1 = new java.lang.NullPointerException
                java.lang.String r2 = "Contextual Actions must contain a valid PendingIntent"
                r1.<init>(r2)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.a.C0009a.a():androidx.core.app.a");
        }

        public C0009a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle) {
            this.f1771a = true;
            this.b = true;
            this.f1768a = iconCompat;
            this.f1769a = NotificationCompat$Builder.c(charSequence);
            this.f1766a = pendingIntent;
            this.f1767a = bundle;
            this.f1770a = null;
            this.f1771a = true;
            this.a = 0;
            this.b = true;
            this.c = false;
            this.d = false;
        }
    }

    public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, pt[] ptVarArr, pt[] ptVarArr2, boolean z, int i, boolean z2, boolean z3, boolean z4) {
        this.f1761a = iconCompat;
        if (iconCompat != null) {
            int i2 = iconCompat.a;
            if ((i2 == -1 ? IconCompat.a.c(iconCompat.f1781a) : i2) == 2) {
                this.b = iconCompat.c();
            }
        }
        this.f1762a = NotificationCompat$Builder.c(charSequence);
        this.f1759a = pendingIntent;
        this.f1760a = bundle == null ? new Bundle() : bundle;
        this.f1764a = ptVarArr;
        this.f1763a = z;
        this.a = i;
        this.f1765b = z2;
        this.c = z3;
        this.d = z4;
    }

    public final IconCompat a() {
        int i;
        if (this.f1761a == null && (i = this.b) != 0) {
            this.f1761a = IconCompat.b((Resources) null, "", i);
        }
        return this.f1761a;
    }
}
