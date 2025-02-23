package androidx.emoji2.text;

import android.os.Handler;
import android.os.Looper;
import androidx.collection.ArraySet;
import androidx.emoji2.text.EmojiCompatInitializer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: EmojiCompat */
public final class d {
    public static volatile d a;

    /* renamed from: a  reason: collision with other field name */
    public static final Object f2004a = new Object();

    /* renamed from: a  reason: collision with other field name */
    public volatile int f2005a = 3;

    /* renamed from: a  reason: collision with other field name */
    public final Handler f2006a;

    /* renamed from: a  reason: collision with other field name */
    public final ArraySet f2007a;

    /* renamed from: a  reason: collision with other field name */
    public final b f2008a;

    /* renamed from: a  reason: collision with other field name */
    public final a f2009a;

    /* renamed from: a  reason: collision with other field name */
    public final g f2010a;

    /* renamed from: a  reason: collision with other field name */
    public final ReentrantReadWriteLock f2011a;
    public final int b;

    /* compiled from: EmojiCompat */
    public static final class a extends b {
        public volatile f a;

        /* renamed from: a  reason: collision with other field name */
        public volatile h f2012a;

        public a(d dVar) {
            super(dVar);
        }
    }

    /* compiled from: EmojiCompat */
    public static class b {
        public final d a;

        public b(d dVar) {
            this.a = dVar;
        }
    }

    /* compiled from: EmojiCompat */
    public static abstract class c {
        public int a = 0;

        /* renamed from: a  reason: collision with other field name */
        public final b f2013a = new b();

        /* renamed from: a  reason: collision with other field name */
        public final g f2014a;

        public c(g gVar) {
            this.f2014a = gVar;
        }
    }

    /* renamed from: androidx.emoji2.text.d$d  reason: collision with other inner class name */
    /* compiled from: EmojiCompat */
    public interface C0019d {
    }

    /* compiled from: EmojiCompat */
    public static class f implements Runnable {
        public final ArrayList a;
        public final int c;

        public f(List list, int i, Throwable th) {
            if (list != null) {
                this.a = new ArrayList(list);
                this.c = i;
                return;
            }
            throw new NullPointerException("initCallbacks cannot be null");
        }

        public final void run() {
            ArrayList arrayList = this.a;
            int size = arrayList.size();
            int i = 0;
            if (this.c != 1) {
                while (i < size) {
                    ((e) arrayList.get(i)).a();
                    i++;
                }
                return;
            }
            while (i < size) {
                ((e) arrayList.get(i)).b();
                i++;
            }
        }
    }

    /* compiled from: EmojiCompat */
    public interface g {
        void a(h hVar);
    }

    /* compiled from: EmojiCompat */
    public static abstract class h {
        public abstract void a(Throwable th);

        public abstract void b(h hVar);
    }

    /* compiled from: EmojiCompat */
    public static class i {
    }

    public d(EmojiCompatInitializer.a aVar) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f2011a = reentrantReadWriteLock;
        g gVar = aVar.f2014a;
        this.f2010a = gVar;
        int i2 = aVar.a;
        this.b = i2;
        this.f2008a = aVar.f2013a;
        this.f2006a = new Handler(Looper.getMainLooper());
        this.f2007a = new ArraySet();
        a aVar2 = new a(this);
        this.f2009a = aVar2;
        reentrantReadWriteLock.writeLock().lock();
        if (i2 == 0) {
            try {
                this.f2005a = 0;
            } catch (Throwable th) {
                this.f2011a.writeLock().unlock();
                throw th;
            }
        }
        reentrantReadWriteLock.writeLock().unlock();
        if (b() == 0) {
            try {
                gVar.a(new c(aVar2));
            } catch (Throwable th2) {
                d(th2);
            }
        }
    }

    public static d a() {
        d dVar;
        boolean z;
        synchronized (f2004a) {
            dVar = a;
            if (dVar != null) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                throw new IllegalStateException("EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
            }
        }
        return dVar;
    }

    public final int b() {
        this.f2011a.readLock().lock();
        try {
            return this.f2005a;
        } finally {
            this.f2011a.readLock().unlock();
        }
    }

    public final void c() {
        boolean z;
        boolean z2 = true;
        if (this.b == 1) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (b() != 1) {
                z2 = false;
            }
            if (!z2) {
                this.f2011a.writeLock().lock();
                try {
                    if (this.f2005a != 0) {
                        this.f2005a = 0;
                        this.f2011a.writeLock().unlock();
                        a aVar = this.f2009a;
                        d dVar = aVar.a;
                        try {
                            dVar.f2010a.a(new c(aVar));
                        } catch (Throwable th) {
                            dVar.d(th);
                        }
                    }
                } finally {
                    this.f2011a.writeLock().unlock();
                }
            }
        } else {
            throw new IllegalStateException("Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        }
    }

    /* JADX INFO: finally extract failed */
    public final void d(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f2011a.writeLock().lock();
        try {
            this.f2005a = 2;
            arrayList.addAll(this.f2007a);
            this.f2007a.clear();
            this.f2011a.writeLock().unlock();
            this.f2006a.post(new f(arrayList, this.f2005a, th));
        } catch (Throwable th2) {
            this.f2011a.writeLock().unlock();
            throw th2;
        }
    }

    /* JADX INFO: finally extract failed */
    public final void e() {
        ArrayList arrayList = new ArrayList();
        this.f2011a.writeLock().lock();
        try {
            this.f2005a = 1;
            arrayList.addAll(this.f2007a);
            this.f2007a.clear();
            this.f2011a.writeLock().unlock();
            this.f2006a.post(new f(arrayList, this.f2005a, (Throwable) null));
        } catch (Throwable th) {
            this.f2011a.writeLock().unlock();
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00e1, code lost:
        if (r3.b(r15, r6, r13, r5.f2020c.f2031a) != false) goto L_0x0102;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00e3, code lost:
        if (r0 != null) goto L_0x00ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00e5, code lost:
        r0 = new defpackage.lB((android.text.Spannable) new android.text.SpannableString(r15));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00ef, code lost:
        r10 = r5.f2020c.f2031a;
        r3.f2016a.getClass();
        r0.setSpan(new defpackage.C0144bB(r10), r6, r13, 33);
        r7 = r7 + 1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008f A[Catch:{ all -> 0x0175 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ab A[Catch:{ all -> 0x0175 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.CharSequence f(int r13, int r14, java.lang.CharSequence r15) {
        /*
            r12 = this;
            int r0 = r12.b()
            r1 = 0
            r2 = 1
            if (r0 != r2) goto L_0x000a
            r0 = r2
            goto L_0x000b
        L_0x000a:
            r0 = r1
        L_0x000b:
            if (r0 == 0) goto L_0x018f
            if (r13 < 0) goto L_0x0187
            if (r14 < 0) goto L_0x017f
            if (r13 > r14) goto L_0x0015
            r0 = r2
            goto L_0x0016
        L_0x0015:
            r0 = r1
        L_0x0016:
            java.lang.String r3 = "start should be <= than end"
            defpackage.C1354qp.q(r0, r3)
            r0 = 0
            if (r15 != 0) goto L_0x001f
            return r0
        L_0x001f:
            int r3 = r15.length()
            if (r13 > r3) goto L_0x0027
            r3 = r2
            goto L_0x0028
        L_0x0027:
            r3 = r1
        L_0x0028:
            java.lang.String r4 = "start should be < than charSequence length"
            defpackage.C1354qp.q(r3, r4)
            int r3 = r15.length()
            if (r14 > r3) goto L_0x0035
            r3 = r2
            goto L_0x0036
        L_0x0035:
            r3 = r1
        L_0x0036:
            java.lang.String r4 = "end should be < than charSequence length"
            defpackage.C1354qp.q(r3, r4)
            int r3 = r15.length()
            if (r3 == 0) goto L_0x017e
            if (r13 != r14) goto L_0x0045
            goto L_0x017e
        L_0x0045:
            androidx.emoji2.text.d$a r3 = r12.f2009a
            androidx.emoji2.text.f r3 = r3.a
            r3.getClass()
            boolean r4 = r15 instanceof defpackage.Cx
            if (r4 == 0) goto L_0x0056
            r5 = r15
            Cx r5 = (defpackage.Cx) r5
            r5.a()
        L_0x0056:
            java.lang.Class<pa> r5 = defpackage.C0295pa.class
            if (r4 != 0) goto L_0x0076
            boolean r6 = r15 instanceof android.text.Spannable     // Catch:{ all -> 0x0175 }
            if (r6 == 0) goto L_0x005f
            goto L_0x0076
        L_0x005f:
            boolean r6 = r15 instanceof android.text.Spanned     // Catch:{ all -> 0x0175 }
            if (r6 == 0) goto L_0x007e
            r6 = r15
            android.text.Spanned r6 = (android.text.Spanned) r6     // Catch:{ all -> 0x0175 }
            int r7 = r13 + -1
            int r8 = r14 + 1
            int r6 = r6.nextSpanTransition(r7, r8, r5)     // Catch:{ all -> 0x0175 }
            if (r6 > r14) goto L_0x007e
            lB r0 = new lB     // Catch:{ all -> 0x0175 }
            r0.<init>((java.lang.CharSequence) r15)     // Catch:{ all -> 0x0175 }
            goto L_0x007e
        L_0x0076:
            lB r0 = new lB     // Catch:{ all -> 0x0175 }
            r6 = r15
            android.text.Spannable r6 = (android.text.Spannable) r6     // Catch:{ all -> 0x0175 }
            r0.<init>((android.text.Spannable) r6)     // Catch:{ all -> 0x0175 }
        L_0x007e:
            if (r0 == 0) goto L_0x00a9
            java.lang.Object[] r5 = r0.getSpans(r13, r14, r5)     // Catch:{ all -> 0x0175 }
            pa[] r5 = (defpackage.C0295pa[]) r5     // Catch:{ all -> 0x0175 }
            if (r5 == 0) goto L_0x00a9
            int r6 = r5.length     // Catch:{ all -> 0x0175 }
            if (r6 <= 0) goto L_0x00a9
            int r6 = r5.length     // Catch:{ all -> 0x0175 }
            r7 = r1
        L_0x008d:
            if (r7 >= r6) goto L_0x00a9
            r8 = r5[r7]     // Catch:{ all -> 0x0175 }
            int r9 = r0.getSpanStart(r8)     // Catch:{ all -> 0x0175 }
            int r10 = r0.getSpanEnd(r8)     // Catch:{ all -> 0x0175 }
            if (r9 == r14) goto L_0x009e
            r0.removeSpan(r8)     // Catch:{ all -> 0x0175 }
        L_0x009e:
            int r13 = java.lang.Math.min(r9, r13)     // Catch:{ all -> 0x0175 }
            int r14 = java.lang.Math.max(r10, r14)     // Catch:{ all -> 0x0175 }
            int r7 = r7 + 1
            goto L_0x008d
        L_0x00a9:
            if (r13 == r14) goto L_0x016c
            int r5 = r15.length()     // Catch:{ all -> 0x0175 }
            if (r13 < r5) goto L_0x00b3
            goto L_0x016c
        L_0x00b3:
            androidx.emoji2.text.f$a r5 = new androidx.emoji2.text.f$a     // Catch:{ all -> 0x0175 }
            androidx.emoji2.text.h r6 = r3.f2017a     // Catch:{ all -> 0x0175 }
            androidx.emoji2.text.h$a r6 = r6.f2028a     // Catch:{ all -> 0x0175 }
            r5.<init>(r6)     // Catch:{ all -> 0x0175 }
            int r6 = java.lang.Character.codePointAt(r15, r13)     // Catch:{ all -> 0x0175 }
            r7 = r1
        L_0x00c1:
            r8 = r6
        L_0x00c2:
            r6 = r13
        L_0x00c3:
            r9 = 33
            r10 = 2147483647(0x7fffffff, float:NaN)
            r11 = 2
            if (r13 >= r14) goto L_0x0120
            if (r7 >= r10) goto L_0x0120
            int r10 = r5.a(r8)     // Catch:{ all -> 0x0175 }
            if (r10 == r2) goto L_0x0110
            if (r10 == r11) goto L_0x0104
            r11 = 3
            if (r10 == r11) goto L_0x00d9
            goto L_0x00c3
        L_0x00d9:
            androidx.emoji2.text.h$a r10 = r5.f2020c     // Catch:{ all -> 0x0175 }
            oa r10 = r10.f2031a     // Catch:{ all -> 0x0175 }
            boolean r10 = r3.b(r15, r6, r13, r10)     // Catch:{ all -> 0x0175 }
            if (r10 != 0) goto L_0x0102
            if (r0 != 0) goto L_0x00ef
            lB r0 = new lB     // Catch:{ all -> 0x0175 }
            android.text.SpannableString r10 = new android.text.SpannableString     // Catch:{ all -> 0x0175 }
            r10.<init>(r15)     // Catch:{ all -> 0x0175 }
            r0.<init>((android.text.Spannable) r10)     // Catch:{ all -> 0x0175 }
        L_0x00ef:
            androidx.emoji2.text.h$a r10 = r5.f2020c     // Catch:{ all -> 0x0175 }
            oa r10 = r10.f2031a     // Catch:{ all -> 0x0175 }
            androidx.emoji2.text.d$i r11 = r3.f2016a     // Catch:{ all -> 0x0175 }
            r11.getClass()     // Catch:{ all -> 0x0175 }
            bB r11 = new bB     // Catch:{ all -> 0x0175 }
            r11.<init>(r10)     // Catch:{ all -> 0x0175 }
            r0.setSpan(r11, r6, r13, r9)     // Catch:{ all -> 0x0175 }
            int r7 = r7 + 1
        L_0x0102:
            r6 = r8
            goto L_0x00c1
        L_0x0104:
            int r9 = java.lang.Character.charCount(r8)     // Catch:{ all -> 0x0175 }
            int r13 = r13 + r9
            if (r13 >= r14) goto L_0x00c3
            int r8 = java.lang.Character.codePointAt(r15, r13)     // Catch:{ all -> 0x0175 }
            goto L_0x00c3
        L_0x0110:
            int r13 = java.lang.Character.codePointAt(r15, r6)     // Catch:{ all -> 0x0175 }
            int r13 = java.lang.Character.charCount(r13)     // Catch:{ all -> 0x0175 }
            int r13 = r13 + r6
            if (r13 >= r14) goto L_0x00c2
            int r8 = java.lang.Character.codePointAt(r15, r13)     // Catch:{ all -> 0x0175 }
            goto L_0x00c2
        L_0x0120:
            int r14 = r5.a     // Catch:{ all -> 0x0175 }
            if (r14 != r11) goto L_0x0135
            androidx.emoji2.text.h$a r14 = r5.f2019b     // Catch:{ all -> 0x0175 }
            oa r14 = r14.f2031a     // Catch:{ all -> 0x0175 }
            if (r14 == 0) goto L_0x0135
            int r14 = r5.c     // Catch:{ all -> 0x0175 }
            if (r14 > r2) goto L_0x0134
            boolean r14 = r5.c()     // Catch:{ all -> 0x0175 }
            if (r14 == 0) goto L_0x0135
        L_0x0134:
            r1 = r2
        L_0x0135:
            if (r1 == 0) goto L_0x015c
            if (r7 >= r10) goto L_0x015c
            androidx.emoji2.text.h$a r14 = r5.f2019b     // Catch:{ all -> 0x0175 }
            oa r14 = r14.f2031a     // Catch:{ all -> 0x0175 }
            boolean r14 = r3.b(r15, r6, r13, r14)     // Catch:{ all -> 0x0175 }
            if (r14 != 0) goto L_0x015c
            if (r0 != 0) goto L_0x014b
            lB r14 = new lB     // Catch:{ all -> 0x0175 }
            r14.<init>((java.lang.CharSequence) r15)     // Catch:{ all -> 0x0175 }
            r0 = r14
        L_0x014b:
            androidx.emoji2.text.h$a r14 = r5.f2019b     // Catch:{ all -> 0x0175 }
            oa r14 = r14.f2031a     // Catch:{ all -> 0x0175 }
            androidx.emoji2.text.d$i r1 = r3.f2016a     // Catch:{ all -> 0x0175 }
            r1.getClass()     // Catch:{ all -> 0x0175 }
            bB r1 = new bB     // Catch:{ all -> 0x0175 }
            r1.<init>(r14)     // Catch:{ all -> 0x0175 }
            r0.setSpan(r1, r6, r13, r9)     // Catch:{ all -> 0x0175 }
        L_0x015c:
            if (r0 == 0) goto L_0x0169
            android.text.Spannable r13 = r0.a     // Catch:{ all -> 0x0175 }
            if (r4 == 0) goto L_0x0167
            Cx r15 = (defpackage.Cx) r15
            r15.b()
        L_0x0167:
            r15 = r13
            goto L_0x0174
        L_0x0169:
            if (r4 == 0) goto L_0x0174
            goto L_0x016e
        L_0x016c:
            if (r4 == 0) goto L_0x0174
        L_0x016e:
            r13 = r15
            Cx r13 = (defpackage.Cx) r13
            r13.b()
        L_0x0174:
            return r15
        L_0x0175:
            r13 = move-exception
            if (r4 == 0) goto L_0x017d
            Cx r15 = (defpackage.Cx) r15
            r15.b()
        L_0x017d:
            throw r13
        L_0x017e:
            return r15
        L_0x017f:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r14 = "end cannot be negative"
            r13.<init>(r14)
            throw r13
        L_0x0187:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r14 = "start cannot be negative"
            r13.<init>(r14)
            throw r13
        L_0x018f:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "Not initialized yet"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.d.f(int, int, java.lang.CharSequence):java.lang.CharSequence");
    }

    public final void g(e eVar) {
        if (eVar != null) {
            this.f2011a.writeLock().lock();
            try {
                if (this.f2005a != 1) {
                    if (this.f2005a != 2) {
                        this.f2007a.add(eVar);
                    }
                }
                this.f2006a.post(new f(Arrays.asList(new e[]{eVar}), this.f2005a, (Throwable) null));
            } finally {
                this.f2011a.writeLock().unlock();
            }
        } else {
            throw new NullPointerException("initCallback cannot be null");
        }
    }

    /* compiled from: EmojiCompat */
    public static abstract class e {
        public void a() {
        }

        public void b() {
        }
    }
}
