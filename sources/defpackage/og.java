package defpackage;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.google.firebase.perf.FirebasePerformance;
import defpackage.Nu;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* renamed from: og  reason: default package */
/* compiled from: InvalidationTracker */
public final class og {
    public static final String[] b = {"UPDATE", FirebasePerformance.HttpMethod.DELETE, "INSERT"};
    public volatile C0085Cd a;
    @SuppressLint({"RestrictedApi"})

    /* renamed from: a  reason: collision with other field name */
    public final Nu<c, d> f3145a = new Nu<>();

    /* renamed from: a  reason: collision with other field name */
    public final Zt f3146a;

    /* renamed from: a  reason: collision with other field name */
    public final HashMap<String, Integer> f3147a;

    /* renamed from: a  reason: collision with other field name */
    public final Map<String, Set<String>> f3148a;

    /* renamed from: a  reason: collision with other field name */
    public final AtomicBoolean f3149a = new AtomicBoolean(false);

    /* renamed from: a  reason: collision with other field name */
    public final a f3150a = new a();

    /* renamed from: a  reason: collision with other field name */
    public final b f3151a;

    /* renamed from: a  reason: collision with other field name */
    public volatile boolean f3152a = false;

    /* renamed from: a  reason: collision with other field name */
    public final String[] f3153a;

    /* renamed from: og$a */
    /* compiled from: InvalidationTracker */
    public class a implements Runnable {
        public a() {
        }

        /* JADX INFO: finally extract failed */
        public final HashSet a() {
            HashSet hashSet = new HashSet();
            Cursor g = og.this.f3146a.g(new Pw("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"));
            while (g.moveToNext()) {
                try {
                    hashSet.add(Integer.valueOf(g.getInt(0)));
                } catch (Throwable th) {
                    g.close();
                    throw th;
                }
            }
            g.close();
            if (!hashSet.isEmpty()) {
                og.this.a.j();
            }
            return hashSet;
        }

        public final void run() {
            C0408yd ydVar;
            ReentrantReadWriteLock.ReadLock readLock = og.this.f3146a.f772a.readLock();
            HashSet hashSet = null;
            try {
                readLock.lock();
                if (!og.this.a()) {
                    readLock.unlock();
                } else if (!og.this.f3149a.compareAndSet(true, false)) {
                    readLock.unlock();
                } else if (((C0408yd) og.this.f3146a.f768a.f()).f3431a.inTransaction()) {
                    readLock.unlock();
                } else {
                    Zt zt = og.this.f3146a;
                    if (zt.b) {
                        ydVar = (C0408yd) zt.f768a.f();
                        ydVar.a();
                        hashSet = a();
                        ydVar.j();
                        ydVar.b();
                    } else {
                        hashSet = a();
                    }
                    readLock.unlock();
                    if (hashSet != null && !hashSet.isEmpty()) {
                        synchronized (og.this.f3145a) {
                            Nu.e eVar = (Nu.e) og.this.f3145a.iterator();
                            if (eVar.hasNext()) {
                                ((d) ((Map.Entry) eVar.next()).getValue()).getClass();
                                throw null;
                            }
                        }
                    }
                }
            } catch (SQLiteException | IllegalStateException unused) {
            } catch (Throwable th) {
                readLock.unlock();
                throw th;
            }
        }
    }

    /* renamed from: og$b */
    /* compiled from: InvalidationTracker */
    public static class b {
        public boolean a;

        /* renamed from: a  reason: collision with other field name */
        public final int[] f3154a;

        /* renamed from: a  reason: collision with other field name */
        public final long[] f3155a;

        /* renamed from: a  reason: collision with other field name */
        public final boolean[] f3156a;
        public boolean b;

        public b(int i) {
            long[] jArr = new long[i];
            this.f3155a = jArr;
            boolean[] zArr = new boolean[i];
            this.f3156a = zArr;
            this.f3154a = new int[i];
            Arrays.fill(jArr, 0);
            Arrays.fill(zArr, false);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0040, code lost:
            return null;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int[] a() {
            /*
                r9 = this;
                monitor-enter(r9)
                boolean r0 = r9.a     // Catch:{ all -> 0x0042 }
                if (r0 == 0) goto L_0x003f
                boolean r0 = r9.b     // Catch:{ all -> 0x0042 }
                if (r0 == 0) goto L_0x000a
                goto L_0x003f
            L_0x000a:
                long[] r0 = r9.f3155a     // Catch:{ all -> 0x0042 }
                int r0 = r0.length     // Catch:{ all -> 0x0042 }
                r1 = 0
                r2 = r1
            L_0x000f:
                r3 = 1
                if (r2 >= r0) goto L_0x0037
                long[] r4 = r9.f3155a     // Catch:{ all -> 0x0042 }
                r5 = r4[r2]     // Catch:{ all -> 0x0042 }
                r7 = 0
                int r4 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r4 <= 0) goto L_0x001e
                r4 = r3
                goto L_0x001f
            L_0x001e:
                r4 = r1
            L_0x001f:
                boolean[] r5 = r9.f3156a     // Catch:{ all -> 0x0042 }
                boolean r6 = r5[r2]     // Catch:{ all -> 0x0042 }
                if (r4 == r6) goto L_0x002e
                int[] r6 = r9.f3154a     // Catch:{ all -> 0x0042 }
                if (r4 == 0) goto L_0x002a
                goto L_0x002b
            L_0x002a:
                r3 = 2
            L_0x002b:
                r6[r2] = r3     // Catch:{ all -> 0x0042 }
                goto L_0x0032
            L_0x002e:
                int[] r3 = r9.f3154a     // Catch:{ all -> 0x0042 }
                r3[r2] = r1     // Catch:{ all -> 0x0042 }
            L_0x0032:
                r5[r2] = r4     // Catch:{ all -> 0x0042 }
                int r2 = r2 + 1
                goto L_0x000f
            L_0x0037:
                r9.b = r3     // Catch:{ all -> 0x0042 }
                r9.a = r1     // Catch:{ all -> 0x0042 }
                int[] r0 = r9.f3154a     // Catch:{ all -> 0x0042 }
                monitor-exit(r9)     // Catch:{ all -> 0x0042 }
                return r0
            L_0x003f:
                monitor-exit(r9)     // Catch:{ all -> 0x0042 }
                r0 = 0
                return r0
            L_0x0042:
                r0 = move-exception
                monitor-exit(r9)     // Catch:{ all -> 0x0042 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.og.b.a():int[]");
        }
    }

    /* renamed from: og$c */
    /* compiled from: InvalidationTracker */
    public static abstract class c {
        public abstract void a(Set<String> set);
    }

    /* renamed from: og$d */
    /* compiled from: InvalidationTracker */
    public static class d {
    }

    public og(Zt zt, HashMap hashMap, HashMap hashMap2, String... strArr) {
        this.f3146a = zt;
        this.f3151a = new b(strArr.length);
        this.f3147a = new HashMap<>();
        this.f3148a = hashMap2;
        Collections.newSetFromMap(new IdentityHashMap());
        int length = strArr.length;
        this.f3153a = new String[length];
        for (int i = 0; i < length; i++) {
            String str = strArr[i];
            Locale locale = Locale.US;
            String lowerCase = str.toLowerCase(locale);
            this.f3147a.put(lowerCase, Integer.valueOf(i));
            String str2 = (String) hashMap.get(strArr[i]);
            if (str2 != null) {
                this.f3153a[i] = str2.toLowerCase(locale);
            } else {
                this.f3153a[i] = lowerCase;
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            Locale locale2 = Locale.US;
            String lowerCase2 = ((String) entry.getValue()).toLowerCase(locale2);
            if (this.f3147a.containsKey(lowerCase2)) {
                String lowerCase3 = ((String) entry.getKey()).toLowerCase(locale2);
                HashMap<String, Integer> hashMap3 = this.f3147a;
                hashMap3.put(lowerCase3, hashMap3.get(lowerCase2));
            }
        }
    }

    public final boolean a() {
        boolean z;
        Ky ky = this.f3146a.a;
        if (ky == null || !((C0408yd) ky).f3431a.isOpen()) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            return false;
        }
        if (!this.f3152a) {
            this.f3146a.f768a.f();
        }
        if (!this.f3152a) {
            return false;
        }
        return true;
    }

    public final void b(Ky ky, int i) {
        C0408yd ydVar = (C0408yd) ky;
        ydVar.c(C1058d.y("INSERT OR IGNORE INTO room_table_modification_log VALUES(", i, ", 0)"));
        String str = this.f3153a[i];
        StringBuilder sb = new StringBuilder();
        String[] strArr = b;
        for (int i2 = 0; i2 < 3; i2++) {
            String str2 = strArr[i2];
            sb.setLength(0);
            sb.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            sb.append("`");
            sb.append("room_table_modification_trigger_");
            sb.append(str);
            sb.append("_");
            sb.append(str2);
            sb.append("`");
            sb.append(" AFTER ");
            sb.append(str2);
            sb.append(" ON `");
            sb.append(str);
            sb.append("` BEGIN UPDATE ");
            sb.append("room_table_modification_log");
            sb.append(" SET ");
            sb.append("invalidated");
            sb.append(" = 1");
            sb.append(" WHERE ");
            sb.append("table_id");
            sb.append(" = ");
            sb.append(i);
            sb.append(" AND ");
            sb.append("invalidated");
            sb.append(" = 0");
            sb.append("; END");
            ydVar.c(sb.toString());
        }
    }

    public final void c(Ky ky) {
        C0408yd ydVar = (C0408yd) ky;
        if (!ydVar.f3431a.inTransaction()) {
            while (true) {
                try {
                    ReentrantReadWriteLock.ReadLock readLock = this.f3146a.f772a.readLock();
                    readLock.lock();
                    try {
                        int[] a2 = this.f3151a.a();
                        if (a2 == null) {
                            readLock.unlock();
                            return;
                        }
                        int length = a2.length;
                        ydVar.a();
                        for (int i = 0; i < length; i++) {
                            int i2 = a2[i];
                            if (i2 == 1) {
                                b(ydVar, i);
                            } else if (i2 == 2) {
                                String str = this.f3153a[i];
                                StringBuilder sb = new StringBuilder();
                                String[] strArr = b;
                                for (int i3 = 0; i3 < 3; i3++) {
                                    String str2 = strArr[i3];
                                    sb.setLength(0);
                                    sb.append("DROP TRIGGER IF EXISTS ");
                                    sb.append("`");
                                    sb.append("room_table_modification_trigger_");
                                    sb.append(str);
                                    sb.append("_");
                                    sb.append(str2);
                                    sb.append("`");
                                    ydVar.c(sb.toString());
                                }
                            }
                        }
                        ydVar.j();
                        ydVar.b();
                        b bVar = this.f3151a;
                        synchronized (bVar) {
                            bVar.b = false;
                        }
                        readLock.unlock();
                    } catch (Throwable th) {
                        readLock.unlock();
                        throw th;
                    }
                } catch (SQLiteException | IllegalStateException unused) {
                    return;
                }
            }
            while (true) {
            }
        }
    }
}
