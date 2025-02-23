package defpackage;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* renamed from: j6  reason: default package and case insensitive filesystem */
/* compiled from: CompositeException */
public final class C1190j6 extends RuntimeException {
    private static final long serialVersionUID = 3026362227162912146L;
    public a a;

    /* renamed from: a  reason: collision with other field name */
    public final List<Throwable> f5520a;
    public final String c;

    /* renamed from: j6$a */
    /* compiled from: CompositeException */
    public static final class a extends RuntimeException {
        private static final long serialVersionUID = 3875212506787802066L;

        public final String getMessage() {
            return "Chain of Causes for CompositeException In Order Received =>";
        }
    }

    /* renamed from: j6$b */
    /* compiled from: CompositeException */
    public static abstract class b {
        public abstract Object a();

        public abstract void b(String str);
    }

    /* renamed from: j6$c */
    /* compiled from: CompositeException */
    public static final class c extends b {
        public final PrintStream a;

        public c(PrintStream printStream) {
            this.a = printStream;
        }

        public final Object a() {
            return this.a;
        }

        public final void b(String str) {
            this.a.println(str);
        }
    }

    /* renamed from: j6$d */
    /* compiled from: CompositeException */
    public static final class d extends b {
        public final PrintWriter a;

        public d(PrintWriter printWriter) {
            this.a = printWriter;
        }

        public final Object a() {
            return this.a;
        }

        public final void b(String str) {
            this.a.println(str);
        }
    }

    @Deprecated
    public C1190j6() {
        throw null;
    }

    public C1190j6(List list) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Throwable th = (Throwable) it.next();
                if (th instanceof C1190j6) {
                    linkedHashSet.addAll(((C1190j6) th).f5520a);
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException());
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException());
        }
        arrayList.addAll(linkedHashSet);
        List<Throwable> unmodifiableList = Collections.unmodifiableList(arrayList);
        this.f5520a = unmodifiableList;
        this.c = unmodifiableList.size() + " exceptions occurred. ";
    }

    public static void a(StringBuilder sb, Throwable th, String str) {
        sb.append(str);
        sb.append(th);
        sb.append(10);
        for (StackTraceElement append : th.getStackTrace()) {
            sb.append("\t\tat ");
            sb.append(append);
            sb.append(10);
        }
        if (th.getCause() != null) {
            sb.append("\tCaused by: ");
            a(sb, th.getCause(), "");
        }
    }

    public final void b(b bVar) {
        StringBuilder sb = new StringBuilder(128);
        sb.append(this);
        sb.append(10);
        for (StackTraceElement append : getStackTrace()) {
            sb.append("\tat ");
            sb.append(append);
            sb.append(10);
        }
        int i = 1;
        for (Throwable a2 : this.f5520a) {
            sb.append("  ComposedException ");
            sb.append(i);
            sb.append(" :\n");
            a(sb, a2, "\t");
            i++;
        }
        synchronized (bVar.a()) {
            bVar.b(sb.toString());
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:10|(1:(1:13)(1:(2:14|(1:53)(1:(2:54|17)(1:18)))))(0)|19|(4:22|(2:24|56)(2:25|57)|55|20)|26|27|28|29|(1:49)(1:(2:32|50)(2:33|(2:34|(1:51)(1:(3:58|37|52)(1:38)))))) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x0070 */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0016 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.Throwable getCause() {
        /*
            r8 = this;
            monitor-enter(r8)
            j6$a r0 = r8.a     // Catch:{ all -> 0x008e }
            if (r0 != 0) goto L_0x008a
            j6$a r0 = new j6$a     // Catch:{ all -> 0x008e }
            r0.<init>()     // Catch:{ all -> 0x008e }
            java.util.HashSet r1 = new java.util.HashSet     // Catch:{ all -> 0x008e }
            r1.<init>()     // Catch:{ all -> 0x008e }
            java.util.List<java.lang.Throwable> r2 = r8.f5520a     // Catch:{ all -> 0x008e }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x008e }
            r3 = r0
        L_0x0016:
            boolean r4 = r2.hasNext()     // Catch:{ all -> 0x008e }
            if (r4 == 0) goto L_0x0088
            java.lang.Object r4 = r2.next()     // Catch:{ all -> 0x008e }
            java.lang.Throwable r4 = (java.lang.Throwable) r4     // Catch:{ all -> 0x008e }
            boolean r5 = r1.contains(r4)     // Catch:{ all -> 0x008e }
            if (r5 == 0) goto L_0x0029
            goto L_0x0016
        L_0x0029:
            r1.add(r4)     // Catch:{ all -> 0x008e }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x008e }
            r5.<init>()     // Catch:{ all -> 0x008e }
            java.lang.Throwable r6 = r4.getCause()     // Catch:{ all -> 0x008e }
            if (r6 == 0) goto L_0x004b
            if (r6 != r4) goto L_0x003a
            goto L_0x004b
        L_0x003a:
            r5.add(r6)     // Catch:{ all -> 0x008e }
            java.lang.Throwable r7 = r6.getCause()     // Catch:{ all -> 0x008e }
            if (r7 == 0) goto L_0x004b
            if (r7 != r6) goto L_0x0046
            goto L_0x004b
        L_0x0046:
            java.lang.Throwable r6 = r6.getCause()     // Catch:{ all -> 0x008e }
            goto L_0x003a
        L_0x004b:
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x008e }
        L_0x004f:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x008e }
            if (r6 == 0) goto L_0x006d
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x008e }
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x008e }
            boolean r7 = r1.contains(r6)     // Catch:{ all -> 0x008e }
            if (r7 == 0) goto L_0x0069
            java.lang.RuntimeException r4 = new java.lang.RuntimeException     // Catch:{ all -> 0x008e }
            java.lang.String r6 = "Duplicate found in causal chain so cropping to prevent loop ..."
            r4.<init>(r6)     // Catch:{ all -> 0x008e }
            goto L_0x004f
        L_0x0069:
            r1.add(r6)     // Catch:{ all -> 0x008e }
            goto L_0x004f
        L_0x006d:
            r3.initCause(r4)     // Catch:{ all -> 0x0070 }
        L_0x0070:
            java.lang.Throwable r4 = r3.getCause()     // Catch:{ all -> 0x008e }
            if (r4 == 0) goto L_0x0016
            if (r4 != r3) goto L_0x0079
            goto L_0x0016
        L_0x0079:
            r3 = r4
        L_0x007a:
            java.lang.Throwable r4 = r3.getCause()     // Catch:{ all -> 0x008e }
            if (r4 == 0) goto L_0x0016
            if (r4 != r3) goto L_0x0083
            goto L_0x0016
        L_0x0083:
            java.lang.Throwable r3 = r3.getCause()     // Catch:{ all -> 0x008e }
            goto L_0x007a
        L_0x0088:
            r8.a = r0     // Catch:{ all -> 0x008e }
        L_0x008a:
            j6$a r0 = r8.a     // Catch:{ all -> 0x008e }
            monitor-exit(r8)
            return r0
        L_0x008e:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1190j6.getCause():java.lang.Throwable");
    }

    public final String getMessage() {
        return this.c;
    }

    public final void printStackTrace() {
        printStackTrace(System.err);
    }

    public final void printStackTrace(PrintStream printStream) {
        b(new c(printStream));
    }

    public final void printStackTrace(PrintWriter printWriter) {
        b(new d(printWriter));
    }

    public C1190j6(Throwable... thArr) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        for (C1190j6 j6Var : thArr) {
            if (j6Var instanceof C1190j6) {
                linkedHashSet.addAll(j6Var.f5520a);
            } else if (j6Var != null) {
                linkedHashSet.add(j6Var);
            } else {
                linkedHashSet.add(new NullPointerException());
            }
        }
        arrayList.addAll(linkedHashSet);
        List<Throwable> unmodifiableList = Collections.unmodifiableList(arrayList);
        this.f5520a = unmodifiableList;
        this.c = unmodifiableList.size() + " exceptions occurred. ";
    }
}
