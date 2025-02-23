package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: ji  reason: default package */
/* compiled from: LocalBroadcastManager */
public final class ji {
    public static final Object a = new Object();

    /* renamed from: a  reason: collision with other field name */
    public static ji f3034a;

    /* renamed from: a  reason: collision with other field name */
    public final Context f3035a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<b> f3036a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public final HashMap<BroadcastReceiver, ArrayList<c>> f3037a = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    public final a f3038a;
    public final HashMap<String, ArrayList<c>> b = new HashMap<>();

    /* renamed from: ji$a */
    /* compiled from: LocalBroadcastManager */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
            r3 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
            if (r3 >= r1) goto L_0x000b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
            r4 = r2[r3];
            r5 = r4.f3039a.size();
            r6 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0032, code lost:
            if (r6 >= r5) goto L_0x004c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0034, code lost:
            r7 = r4.f3039a.get(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x003e, code lost:
            if (r7.b != false) goto L_0x0049;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0040, code lost:
            r7.a.onReceive(r11.f3035a, r4.a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0049, code lost:
            r6 = r6 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x004c, code lost:
            r3 = r3 + 1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void handleMessage(android.os.Message r11) {
            /*
                r10 = this;
                int r0 = r11.what
                r1 = 1
                if (r0 == r1) goto L_0x0009
                super.handleMessage(r11)
                goto L_0x0017
            L_0x0009:
                ji r11 = defpackage.ji.this
            L_0x000b:
                java.util.HashMap<android.content.BroadcastReceiver, java.util.ArrayList<ji$c>> r0 = r11.f3037a
                monitor-enter(r0)
                java.util.ArrayList<ji$b> r1 = r11.f3036a     // Catch:{ all -> 0x004f }
                int r1 = r1.size()     // Catch:{ all -> 0x004f }
                if (r1 > 0) goto L_0x0018
                monitor-exit(r0)     // Catch:{ all -> 0x004f }
            L_0x0017:
                return
            L_0x0018:
                ji$b[] r2 = new defpackage.ji.b[r1]     // Catch:{ all -> 0x004f }
                java.util.ArrayList<ji$b> r3 = r11.f3036a     // Catch:{ all -> 0x004f }
                r3.toArray(r2)     // Catch:{ all -> 0x004f }
                java.util.ArrayList<ji$b> r3 = r11.f3036a     // Catch:{ all -> 0x004f }
                r3.clear()     // Catch:{ all -> 0x004f }
                monitor-exit(r0)     // Catch:{ all -> 0x004f }
                r0 = 0
                r3 = r0
            L_0x0027:
                if (r3 >= r1) goto L_0x000b
                r4 = r2[r3]
                java.util.ArrayList<ji$c> r5 = r4.f3039a
                int r5 = r5.size()
                r6 = r0
            L_0x0032:
                if (r6 >= r5) goto L_0x004c
                java.util.ArrayList<ji$c> r7 = r4.f3039a
                java.lang.Object r7 = r7.get(r6)
                ji$c r7 = (defpackage.ji.c) r7
                boolean r8 = r7.b
                if (r8 != 0) goto L_0x0049
                android.content.BroadcastReceiver r7 = r7.a
                android.content.Context r8 = r11.f3035a
                android.content.Intent r9 = r4.a
                r7.onReceive(r8, r9)
            L_0x0049:
                int r6 = r6 + 1
                goto L_0x0032
            L_0x004c:
                int r3 = r3 + 1
                goto L_0x0027
            L_0x004f:
                r11 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x004f }
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.ji.a.handleMessage(android.os.Message):void");
        }
    }

    /* renamed from: ji$b */
    /* compiled from: LocalBroadcastManager */
    public static final class b {
        public final Intent a;

        /* renamed from: a  reason: collision with other field name */
        public final ArrayList<c> f3039a;

        public b(Intent intent, ArrayList<c> arrayList) {
            this.a = intent;
            this.f3039a = arrayList;
        }
    }

    /* renamed from: ji$c */
    /* compiled from: LocalBroadcastManager */
    public static final class c {
        public final BroadcastReceiver a;

        /* renamed from: a  reason: collision with other field name */
        public final IntentFilter f3040a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f3041a;
        public boolean b;

        public c(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
            this.f3040a = intentFilter;
            this.a = broadcastReceiver;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.a);
            sb.append(" filter=");
            sb.append(this.f3040a);
            if (this.b) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    public ji(Context context) {
        this.f3035a = context;
        this.f3038a = new a(context.getMainLooper());
    }

    public static ji a(Context context) {
        ji jiVar;
        synchronized (a) {
            if (f3034a == null) {
                f3034a = new ji(context.getApplicationContext());
            }
            jiVar = f3034a;
        }
        return jiVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d9, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00db, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(android.content.Intent r23) {
        /*
            r22 = this;
            r1 = r22
            r0 = r23
            java.util.HashMap<android.content.BroadcastReceiver, java.util.ArrayList<ji$c>> r2 = r1.f3037a
            monitor-enter(r2)
            java.lang.String r10 = r23.getAction()     // Catch:{ all -> 0x00dc }
            android.content.Context r3 = r1.f3035a     // Catch:{ all -> 0x00dc }
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ all -> 0x00dc }
            java.lang.String r11 = r0.resolveTypeIfNeeded(r3)     // Catch:{ all -> 0x00dc }
            android.net.Uri r12 = r23.getData()     // Catch:{ all -> 0x00dc }
            java.lang.String r13 = r23.getScheme()     // Catch:{ all -> 0x00dc }
            java.util.Set r14 = r23.getCategories()     // Catch:{ all -> 0x00dc }
            int r3 = r23.getFlags()     // Catch:{ all -> 0x00dc }
            r3 = r3 & 8
            r9 = 0
            if (r3 == 0) goto L_0x002d
            r16 = 1
            goto L_0x002f
        L_0x002d:
            r16 = r9
        L_0x002f:
            if (r16 == 0) goto L_0x0034
            r23.toString()     // Catch:{ all -> 0x00dc }
        L_0x0034:
            java.util.HashMap<java.lang.String, java.util.ArrayList<ji$c>> r3 = r1.b     // Catch:{ all -> 0x00dc }
            java.lang.String r4 = r23.getAction()     // Catch:{ all -> 0x00dc }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x00dc }
            r8 = r3
            java.util.ArrayList r8 = (java.util.ArrayList) r8     // Catch:{ all -> 0x00dc }
            if (r8 == 0) goto L_0x00da
            if (r16 == 0) goto L_0x0048
            r8.toString()     // Catch:{ all -> 0x00dc }
        L_0x0048:
            r3 = 0
            r7 = r3
            r6 = r9
        L_0x004b:
            int r3 = r8.size()     // Catch:{ all -> 0x00dc }
            if (r6 >= r3) goto L_0x00aa
            java.lang.Object r3 = r8.get(r6)     // Catch:{ all -> 0x00dc }
            r5 = r3
            ji$c r5 = (defpackage.ji.c) r5     // Catch:{ all -> 0x00dc }
            if (r16 == 0) goto L_0x005f
            android.content.IntentFilter r3 = r5.f3040a     // Catch:{ all -> 0x00dc }
            java.util.Objects.toString(r3)     // Catch:{ all -> 0x00dc }
        L_0x005f:
            boolean r3 = r5.f3041a     // Catch:{ all -> 0x00dc }
            if (r3 == 0) goto L_0x006e
            r18 = r6
            r20 = r8
            r19 = r10
            r21 = r11
            r10 = r7
            r11 = r9
            goto L_0x009f
        L_0x006e:
            android.content.IntentFilter r3 = r5.f3040a     // Catch:{ all -> 0x00dc }
            java.lang.String r17 = "LocalBroadcastManager"
            r4 = r10
            r15 = r5
            r5 = r11
            r18 = r6
            r6 = r13
            r19 = r10
            r10 = r7
            r7 = r12
            r20 = r8
            r8 = r14
            r21 = r11
            r11 = r9
            r9 = r17
            int r3 = r3.match(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00dc }
            if (r3 < 0) goto L_0x009f
            if (r16 == 0) goto L_0x008f
            java.lang.Integer.toHexString(r3)     // Catch:{ all -> 0x00dc }
        L_0x008f:
            if (r10 != 0) goto L_0x0097
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x00dc }
            r7.<init>()     // Catch:{ all -> 0x00dc }
            goto L_0x0098
        L_0x0097:
            r7 = r10
        L_0x0098:
            r7.add(r15)     // Catch:{ all -> 0x00dc }
            r3 = 1
            r15.f3041a = r3     // Catch:{ all -> 0x00dc }
            goto L_0x00a0
        L_0x009f:
            r7 = r10
        L_0x00a0:
            int r6 = r18 + 1
            r9 = r11
            r10 = r19
            r8 = r20
            r11 = r21
            goto L_0x004b
        L_0x00aa:
            r10 = r7
            r11 = r9
            if (r10 == 0) goto L_0x00da
            r9 = r11
        L_0x00af:
            int r3 = r10.size()     // Catch:{ all -> 0x00dc }
            if (r9 >= r3) goto L_0x00c0
            java.lang.Object r3 = r10.get(r9)     // Catch:{ all -> 0x00dc }
            ji$c r3 = (defpackage.ji.c) r3     // Catch:{ all -> 0x00dc }
            r3.f3041a = r11     // Catch:{ all -> 0x00dc }
            int r9 = r9 + 1
            goto L_0x00af
        L_0x00c0:
            java.util.ArrayList<ji$b> r3 = r1.f3036a     // Catch:{ all -> 0x00dc }
            ji$b r4 = new ji$b     // Catch:{ all -> 0x00dc }
            r4.<init>(r0, r10)     // Catch:{ all -> 0x00dc }
            r3.add(r4)     // Catch:{ all -> 0x00dc }
            ji$a r0 = r1.f3038a     // Catch:{ all -> 0x00dc }
            r3 = 1
            boolean r0 = r0.hasMessages(r3)     // Catch:{ all -> 0x00dc }
            if (r0 != 0) goto L_0x00d8
            ji$a r0 = r1.f3038a     // Catch:{ all -> 0x00dc }
            r0.sendEmptyMessage(r3)     // Catch:{ all -> 0x00dc }
        L_0x00d8:
            monitor-exit(r2)     // Catch:{ all -> 0x00dc }
            return
        L_0x00da:
            monitor-exit(r2)     // Catch:{ all -> 0x00dc }
            return
        L_0x00dc:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00dc }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ji.b(android.content.Intent):void");
    }
}
