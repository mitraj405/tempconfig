package defpackage;

import android.database.Cursor;
import androidx.work.Data;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.logging.type.LogSeverity;
import defpackage.C0214hE;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: jE  reason: default package and case insensitive filesystem */
/* compiled from: WorkSpecDao_Impl */
public final class C0236jE implements C0224iE {
    public final Zt a;

    /* renamed from: a  reason: collision with other field name */
    public final a f3025a;

    /* renamed from: a  reason: collision with other field name */
    public final b f3026a;

    /* renamed from: a  reason: collision with other field name */
    public final c f3027a;

    /* renamed from: a  reason: collision with other field name */
    public final d f3028a;

    /* renamed from: a  reason: collision with other field name */
    public final e f3029a;

    /* renamed from: a  reason: collision with other field name */
    public final f f3030a;

    /* renamed from: a  reason: collision with other field name */
    public final g f3031a;

    /* renamed from: a  reason: collision with other field name */
    public final h f3032a;

    /* renamed from: jE$a */
    /* compiled from: WorkSpecDao_Impl */
    public class a extends C0094Ha<C0214hE> {
        public a(Zt zt) {
            super(zt);
        }

        public final String b() {
            return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: byte[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.io.ObjectOutputStream} */
        /* JADX WARNING: type inference failed for: r3v2 */
        /* JADX WARNING: type inference failed for: r3v8 */
        /* JADX WARNING: type inference failed for: r3v21 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:80:0x01bf A[SYNTHETIC, Splitter:B:80:0x01bf] */
        /* JADX WARNING: Removed duplicated region for block: B:87:0x01d2  */
        /* JADX WARNING: Removed duplicated region for block: B:88:0x01d8  */
        /* JADX WARNING: Removed duplicated region for block: B:91:0x01e2 A[SYNTHETIC, Splitter:B:91:0x01e2] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void d(defpackage.C0085Cd r17, java.lang.Object r18) {
            /*
                r16 = this;
                r1 = r17
                r0 = r18
                hE r0 = (defpackage.C0214hE) r0
                java.lang.String r2 = r0.f2991a
                r3 = 1
                if (r2 != 0) goto L_0x000f
                r1.e(r3)
                goto L_0x0012
            L_0x000f:
                r1.h(r3, r2)
            L_0x0012:
                UD r2 = r0.f2989a
                int r2 = defpackage.oE.f(r2)
                long r4 = (long) r2
                r2 = 2
                r1.c(r2, r4)
                java.lang.String r4 = r0.f2995b
                r5 = 3
                if (r4 != 0) goto L_0x0026
                r1.e(r5)
                goto L_0x0029
            L_0x0026:
                r1.h(r5, r4)
            L_0x0029:
                java.lang.String r4 = r0.f2997c
                r6 = 4
                if (r4 != 0) goto L_0x0032
                r1.e(r6)
                goto L_0x0035
            L_0x0032:
                r1.h(r6, r4)
            L_0x0035:
                androidx.work.Data r4 = r0.f2990a
                byte[] r4 = androidx.work.Data.c(r4)
                r7 = 5
                if (r4 != 0) goto L_0x0042
                r1.e(r7)
                goto L_0x0045
            L_0x0042:
                r1.a(r7, r4)
            L_0x0045:
                androidx.work.Data r4 = r0.f2994b
                byte[] r4 = androidx.work.Data.c(r4)
                r8 = 6
                if (r4 != 0) goto L_0x0052
                r1.e(r8)
                goto L_0x0055
            L_0x0052:
                r1.a(r8, r4)
            L_0x0055:
                r4 = 7
                long r8 = r0.f2987a
                r1.c(r4, r8)
                r4 = 8
                long r8 = r0.f2993b
                r1.c(r4, r8)
                r4 = 9
                long r8 = r0.f2996c
                r1.c(r4, r8)
                int r4 = r0.a
                long r8 = (long) r4
                r4 = 10
                r1.c(r4, r8)
                int r4 = r0.b
                int r8 = defpackage.xx.V(r4)
                java.lang.String r10 = " to int"
                java.lang.String r11 = "Could not convert "
                if (r8 == 0) goto L_0x009a
                if (r8 != r3) goto L_0x0081
                r4 = r3
                goto L_0x009b
            L_0x0081:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>(r11)
                java.lang.String r2 = defpackage.xx.W(r4)
                r1.append(r2)
                r1.append(r10)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x009a:
                r4 = 0
            L_0x009b:
                r8 = 11
                long r12 = (long) r4
                r1.c(r8, r12)
                r4 = 12
                long r12 = r0.d
                r1.c(r4, r12)
                r4 = 13
                long r12 = r0.e
                r1.c(r4, r12)
                r4 = 14
                long r12 = r0.f
                r1.c(r4, r12)
                r4 = 15
                long r12 = r0.g
                r1.c(r4, r12)
                boolean r4 = r0.f2992a
                r8 = 16
                long r12 = (long) r4
                r1.c(r8, r12)
                int r4 = r0.c
                int r8 = defpackage.xx.V(r4)
                if (r8 == 0) goto L_0x00ea
                if (r8 != r3) goto L_0x00d1
                r4 = r3
                goto L_0x00eb
            L_0x00d1:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>(r11)
                java.lang.String r2 = defpackage.C0709Uj.w(r4)
                r1.append(r2)
                r1.append(r10)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x00ea:
                r4 = 0
            L_0x00eb:
                r8 = 17
                long r12 = (long) r4
                r1.c(r8, r12)
                T6 r0 = r0.f2988a
                r12 = 23
                r13 = 22
                r14 = 21
                r15 = 20
                r7 = 19
                r9 = 18
                if (r0 == 0) goto L_0x01f5
                Em r8 = r0.f539a
                int r4 = r8.ordinal()
                if (r4 == 0) goto L_0x0138
                if (r4 == r3) goto L_0x0139
                if (r4 == r2) goto L_0x0136
                if (r4 == r5) goto L_0x0134
                if (r4 == r6) goto L_0x0132
                int r2 = android.os.Build.VERSION.SDK_INT
                r3 = 30
                if (r2 < r3) goto L_0x011d
                Em r2 = defpackage.Em.TEMPORARILY_UNMETERED
                if (r8 != r2) goto L_0x011d
                r3 = 5
                goto L_0x0139
            L_0x011d:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>(r11)
                r1.append(r8)
                r1.append(r10)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x0132:
                r3 = r6
                goto L_0x0139
            L_0x0134:
                r3 = r5
                goto L_0x0139
            L_0x0136:
                r3 = r2
                goto L_0x0139
            L_0x0138:
                r3 = 0
            L_0x0139:
                long r2 = (long) r3
                r1.c(r9, r2)
                boolean r2 = r0.f541a
                long r2 = (long) r2
                r1.c(r7, r2)
                boolean r2 = r0.f542b
                long r2 = (long) r2
                r1.c(r15, r2)
                boolean r2 = r0.c
                long r2 = (long) r2
                r1.c(r14, r2)
                boolean r2 = r0.d
                long r2 = (long) r2
                r1.c(r13, r2)
                long r2 = r0.f538a
                r1.c(r12, r2)
                long r2 = r0.b
                r4 = 24
                r1.c(r4, r2)
                b7 r0 = r0.f540a
                java.util.HashSet r2 = r0.a
                int r2 = r2.size()
                r3 = 0
                if (r2 != 0) goto L_0x016e
                goto L_0x01d0
            L_0x016e:
                java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream
                r2.<init>()
                java.io.ObjectOutputStream r4 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x01b9 }
                r4.<init>(r2)     // Catch:{ IOException -> 0x01b9 }
                java.util.HashSet r0 = r0.a
                int r3 = r0.size()     // Catch:{ IOException -> 0x01a2, all -> 0x01a0 }
                r4.writeInt(r3)     // Catch:{ IOException -> 0x01a2, all -> 0x01a0 }
                java.util.Iterator r0 = r0.iterator()     // Catch:{ IOException -> 0x01a2, all -> 0x01a0 }
            L_0x0185:
                boolean r3 = r0.hasNext()     // Catch:{ IOException -> 0x01a2, all -> 0x01a0 }
                if (r3 == 0) goto L_0x01a4
                java.lang.Object r3 = r0.next()     // Catch:{ IOException -> 0x01a2, all -> 0x01a0 }
                b7$a r3 = (defpackage.C0141b7.a) r3     // Catch:{ IOException -> 0x01a2, all -> 0x01a0 }
                android.net.Uri r5 = r3.a     // Catch:{ IOException -> 0x01a2, all -> 0x01a0 }
                java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x01a2, all -> 0x01a0 }
                r4.writeUTF(r5)     // Catch:{ IOException -> 0x01a2, all -> 0x01a0 }
                boolean r3 = r3.f2730a     // Catch:{ IOException -> 0x01a2, all -> 0x01a0 }
                r4.writeBoolean(r3)     // Catch:{ IOException -> 0x01a2, all -> 0x01a0 }
                goto L_0x0185
            L_0x01a0:
                r0 = move-exception
                goto L_0x01b3
            L_0x01a2:
                r0 = move-exception
                goto L_0x01b5
            L_0x01a4:
                r4.close()     // Catch:{ IOException -> 0x01a8 }
                goto L_0x01ad
            L_0x01a8:
                r0 = move-exception
                r3 = r0
                r3.printStackTrace()
            L_0x01ad:
                r2.close()     // Catch:{ IOException -> 0x01b1 }
                goto L_0x01cc
            L_0x01b1:
                r0 = move-exception
                goto L_0x01c9
            L_0x01b3:
                r1 = r0
                goto L_0x01e0
            L_0x01b5:
                r3 = r4
                goto L_0x01ba
            L_0x01b7:
                r0 = move-exception
                goto L_0x01de
            L_0x01b9:
                r0 = move-exception
            L_0x01ba:
                r0.printStackTrace()     // Catch:{ all -> 0x01b7 }
                if (r3 == 0) goto L_0x01ad
                r3.close()     // Catch:{ IOException -> 0x01c3 }
                goto L_0x01ad
            L_0x01c3:
                r0 = move-exception
                r3 = r0
                r3.printStackTrace()
                goto L_0x01ad
            L_0x01c9:
                r0.printStackTrace()
            L_0x01cc:
                byte[] r3 = r2.toByteArray()
            L_0x01d0:
                if (r3 != 0) goto L_0x01d8
                r2 = 25
                r1.e(r2)
                goto L_0x0211
            L_0x01d8:
                r2 = 25
                r1.a(r2, r3)
                goto L_0x0211
            L_0x01de:
                r1 = r0
                r4 = r3
            L_0x01e0:
                if (r4 == 0) goto L_0x01eb
                r4.close()     // Catch:{ IOException -> 0x01e6 }
                goto L_0x01eb
            L_0x01e6:
                r0 = move-exception
                r3 = r0
                r3.printStackTrace()
            L_0x01eb:
                r2.close()     // Catch:{ IOException -> 0x01ef }
                goto L_0x01f4
            L_0x01ef:
                r0 = move-exception
                r2 = r0
                r2.printStackTrace()
            L_0x01f4:
                throw r1
            L_0x01f5:
                r1.e(r9)
                r1.e(r7)
                r1.e(r15)
                r1.e(r14)
                r1.e(r13)
                r1.e(r12)
                r0 = 24
                r1.e(r0)
                r2 = 25
                r1.e(r2)
            L_0x0211:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.C0236jE.a.d(Cd, java.lang.Object):void");
        }
    }

    /* renamed from: jE$b */
    /* compiled from: WorkSpecDao_Impl */
    public class b extends Cw {
        public b(Zt zt) {
            super(zt);
        }

        public final String b() {
            return "DELETE FROM workspec WHERE id=?";
        }
    }

    /* renamed from: jE$c */
    /* compiled from: WorkSpecDao_Impl */
    public class c extends Cw {
        public c(Zt zt) {
            super(zt);
        }

        public final String b() {
            return "UPDATE workspec SET output=? WHERE id=?";
        }
    }

    /* renamed from: jE$d */
    /* compiled from: WorkSpecDao_Impl */
    public class d extends Cw {
        public d(Zt zt) {
            super(zt);
        }

        public final String b() {
            return "UPDATE workspec SET period_start_time=? WHERE id=?";
        }
    }

    /* renamed from: jE$e */
    /* compiled from: WorkSpecDao_Impl */
    public class e extends Cw {
        public e(Zt zt) {
            super(zt);
        }

        public final String b() {
            return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
        }
    }

    /* renamed from: jE$f */
    /* compiled from: WorkSpecDao_Impl */
    public class f extends Cw {
        public f(Zt zt) {
            super(zt);
        }

        public final String b() {
            return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
        }
    }

    /* renamed from: jE$g */
    /* compiled from: WorkSpecDao_Impl */
    public class g extends Cw {
        public g(Zt zt) {
            super(zt);
        }

        public final String b() {
            return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
        }
    }

    /* renamed from: jE$h */
    /* compiled from: WorkSpecDao_Impl */
    public class h extends Cw {
        public h(Zt zt) {
            super(zt);
        }

        public final String b() {
            return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
        }
    }

    public C0236jE(Zt zt) {
        this.a = zt;
        this.f3025a = new a(zt);
        this.f3026a = new b(zt);
        this.f3027a = new c(zt);
        this.f3028a = new d(zt);
        this.f3029a = new e(zt);
        this.f3030a = new f(zt);
        this.f3031a = new g(zt);
        this.f3032a = new h(zt);
        new AtomicBoolean(false);
    }

    public final void a(String str) {
        Zt zt = this.a;
        zt.b();
        b bVar = this.f3026a;
        C0085Cd a2 = bVar.a();
        if (str == null) {
            a2.e(1);
        } else {
            a2.h(1, str);
        }
        zt.c();
        try {
            a2.j();
            zt.h();
        } finally {
            zt.f();
            bVar.c(a2);
        }
    }

    public final ArrayList b() {
        bu buVar;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        bu c2 = bu.c(1, "SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 ORDER BY period_start_time LIMIT ?");
        c2.e(1, (long) LogSeverity.INFO_VALUE);
        Zt zt = this.a;
        zt.b();
        Cursor g2 = zt.g(c2);
        try {
            int N = C1354qp.N(g2, "required_network_type");
            int N2 = C1354qp.N(g2, "requires_charging");
            int N3 = C1354qp.N(g2, "requires_device_idle");
            int N4 = C1354qp.N(g2, "requires_battery_not_low");
            int N5 = C1354qp.N(g2, "requires_storage_not_low");
            int N6 = C1354qp.N(g2, "trigger_content_update_delay");
            int N7 = C1354qp.N(g2, "trigger_max_content_delay");
            int N8 = C1354qp.N(g2, "content_uri_triggers");
            int N9 = C1354qp.N(g2, FacebookMediationAdapter.KEY_ID);
            int N10 = C1354qp.N(g2, RemoteConfigConstants.ResponseFieldKey.STATE);
            int N11 = C1354qp.N(g2, "worker_class_name");
            int N12 = C1354qp.N(g2, "input_merger_class_name");
            int N13 = C1354qp.N(g2, "input");
            int N14 = C1354qp.N(g2, "output");
            buVar = c2;
            try {
                int N15 = C1354qp.N(g2, "initial_delay");
                int N16 = C1354qp.N(g2, "interval_duration");
                int N17 = C1354qp.N(g2, "flex_duration");
                int N18 = C1354qp.N(g2, "run_attempt_count");
                int N19 = C1354qp.N(g2, "backoff_policy");
                int N20 = C1354qp.N(g2, "backoff_delay_duration");
                int N21 = C1354qp.N(g2, "period_start_time");
                int N22 = C1354qp.N(g2, "minimum_retention_duration");
                int N23 = C1354qp.N(g2, "schedule_requested_at");
                int N24 = C1354qp.N(g2, "run_in_foreground");
                int N25 = C1354qp.N(g2, "out_of_quota_policy");
                int i = N14;
                ArrayList arrayList = new ArrayList(g2.getCount());
                while (g2.moveToNext()) {
                    String string = g2.getString(N9);
                    int i2 = N9;
                    String string2 = g2.getString(N11);
                    int i3 = N11;
                    T6 t6 = new T6();
                    int i4 = N;
                    t6.f539a = oE.c(g2.getInt(N));
                    if (g2.getInt(N2) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    t6.f541a = z;
                    if (g2.getInt(N3) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    t6.f542b = z2;
                    if (g2.getInt(N4) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    t6.c = z3;
                    if (g2.getInt(N5) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    t6.d = z4;
                    int i5 = N2;
                    int i6 = N3;
                    t6.f538a = g2.getLong(N6);
                    t6.b = g2.getLong(N7);
                    t6.f540a = oE.a(g2.getBlob(N8));
                    C0214hE hEVar = new C0214hE(string, string2);
                    hEVar.f2989a = oE.e(g2.getInt(N10));
                    hEVar.f2997c = g2.getString(N12);
                    hEVar.f2990a = Data.a(g2.getBlob(N13));
                    int i7 = i;
                    hEVar.f2994b = Data.a(g2.getBlob(i7));
                    int i8 = N13;
                    int i9 = N15;
                    int i10 = i5;
                    hEVar.f2987a = g2.getLong(i9);
                    int i11 = N4;
                    int i12 = N16;
                    int i13 = i9;
                    hEVar.f2993b = g2.getLong(i12);
                    int i14 = i12;
                    int i15 = N17;
                    int i16 = i11;
                    hEVar.f2996c = g2.getLong(i15);
                    int i17 = N18;
                    hEVar.a = g2.getInt(i17);
                    int i18 = N19;
                    int i19 = i17;
                    hEVar.b = oE.b(g2.getInt(i18));
                    int i20 = i15;
                    int i21 = N20;
                    int i22 = i14;
                    hEVar.d = g2.getLong(i21);
                    int i23 = i18;
                    int i24 = N21;
                    int i25 = i21;
                    hEVar.e = g2.getLong(i24);
                    int i26 = i24;
                    int i27 = N22;
                    int i28 = i23;
                    hEVar.f = g2.getLong(i27);
                    int i29 = i27;
                    int i30 = N23;
                    int i31 = i26;
                    hEVar.g = g2.getLong(i30);
                    int i32 = N24;
                    if (g2.getInt(i32) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    hEVar.f2992a = z5;
                    int i33 = N25;
                    int i34 = i32;
                    hEVar.c = oE.d(g2.getInt(i33));
                    hEVar.f2988a = t6;
                    arrayList.add(hEVar);
                    i = i7;
                    N2 = i10;
                    N15 = i13;
                    N16 = i22;
                    N20 = i25;
                    N21 = i31;
                    N24 = i34;
                    N11 = i3;
                    N = i4;
                    N25 = i33;
                    N23 = i30;
                    N13 = i8;
                    N9 = i2;
                    N3 = i6;
                    int i35 = i28;
                    N22 = i29;
                    N4 = i16;
                    N17 = i20;
                    N18 = i19;
                    N19 = i35;
                }
                g2.close();
                buVar.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                g2.close();
                buVar.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            buVar = c2;
            g2.close();
            buVar.release();
            throw th;
        }
    }

    public final ArrayList c(int i) {
        bu buVar;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        bu c2 = bu.c(1, "SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY period_start_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))");
        c2.e(1, (long) i);
        Zt zt = this.a;
        zt.b();
        Cursor g2 = zt.g(c2);
        try {
            int N = C1354qp.N(g2, "required_network_type");
            int N2 = C1354qp.N(g2, "requires_charging");
            int N3 = C1354qp.N(g2, "requires_device_idle");
            int N4 = C1354qp.N(g2, "requires_battery_not_low");
            int N5 = C1354qp.N(g2, "requires_storage_not_low");
            int N6 = C1354qp.N(g2, "trigger_content_update_delay");
            int N7 = C1354qp.N(g2, "trigger_max_content_delay");
            int N8 = C1354qp.N(g2, "content_uri_triggers");
            int N9 = C1354qp.N(g2, FacebookMediationAdapter.KEY_ID);
            int N10 = C1354qp.N(g2, RemoteConfigConstants.ResponseFieldKey.STATE);
            int N11 = C1354qp.N(g2, "worker_class_name");
            int N12 = C1354qp.N(g2, "input_merger_class_name");
            int N13 = C1354qp.N(g2, "input");
            int N14 = C1354qp.N(g2, "output");
            buVar = c2;
            try {
                int N15 = C1354qp.N(g2, "initial_delay");
                int N16 = C1354qp.N(g2, "interval_duration");
                int N17 = C1354qp.N(g2, "flex_duration");
                int N18 = C1354qp.N(g2, "run_attempt_count");
                int N19 = C1354qp.N(g2, "backoff_policy");
                int N20 = C1354qp.N(g2, "backoff_delay_duration");
                int N21 = C1354qp.N(g2, "period_start_time");
                int N22 = C1354qp.N(g2, "minimum_retention_duration");
                int N23 = C1354qp.N(g2, "schedule_requested_at");
                int N24 = C1354qp.N(g2, "run_in_foreground");
                int N25 = C1354qp.N(g2, "out_of_quota_policy");
                int i2 = N14;
                ArrayList arrayList = new ArrayList(g2.getCount());
                while (g2.moveToNext()) {
                    String string = g2.getString(N9);
                    int i3 = N9;
                    String string2 = g2.getString(N11);
                    int i4 = N11;
                    T6 t6 = new T6();
                    int i5 = N;
                    t6.f539a = oE.c(g2.getInt(N));
                    if (g2.getInt(N2) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    t6.f541a = z;
                    if (g2.getInt(N3) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    t6.f542b = z2;
                    if (g2.getInt(N4) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    t6.c = z3;
                    if (g2.getInt(N5) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    t6.d = z4;
                    int i6 = N2;
                    int i7 = N3;
                    t6.f538a = g2.getLong(N6);
                    t6.b = g2.getLong(N7);
                    t6.f540a = oE.a(g2.getBlob(N8));
                    C0214hE hEVar = new C0214hE(string, string2);
                    hEVar.f2989a = oE.e(g2.getInt(N10));
                    hEVar.f2997c = g2.getString(N12);
                    hEVar.f2990a = Data.a(g2.getBlob(N13));
                    int i8 = i2;
                    hEVar.f2994b = Data.a(g2.getBlob(i8));
                    int i9 = N15;
                    int i10 = i6;
                    int i11 = N13;
                    hEVar.f2987a = g2.getLong(i9);
                    int i12 = N4;
                    int i13 = N16;
                    int i14 = i9;
                    hEVar.f2993b = g2.getLong(i13);
                    int i15 = i13;
                    int i16 = N17;
                    int i17 = i12;
                    hEVar.f2996c = g2.getLong(i16);
                    int i18 = N18;
                    hEVar.a = g2.getInt(i18);
                    int i19 = N19;
                    int i20 = i18;
                    hEVar.b = oE.b(g2.getInt(i19));
                    int i21 = i16;
                    int i22 = N20;
                    int i23 = i15;
                    hEVar.d = g2.getLong(i22);
                    int i24 = i19;
                    int i25 = N21;
                    int i26 = i22;
                    hEVar.e = g2.getLong(i25);
                    int i27 = i25;
                    int i28 = N22;
                    int i29 = i24;
                    hEVar.f = g2.getLong(i28);
                    int i30 = i28;
                    int i31 = N23;
                    int i32 = i27;
                    hEVar.g = g2.getLong(i31);
                    int i33 = N24;
                    if (g2.getInt(i33) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    hEVar.f2992a = z5;
                    int i34 = N25;
                    int i35 = i33;
                    hEVar.c = oE.d(g2.getInt(i34));
                    hEVar.f2988a = t6;
                    arrayList.add(hEVar);
                    i2 = i8;
                    N2 = i10;
                    N24 = i35;
                    N9 = i3;
                    N11 = i4;
                    N = i5;
                    N25 = i34;
                    N13 = i11;
                    N15 = i14;
                    N16 = i23;
                    N20 = i26;
                    N21 = i32;
                    N23 = i31;
                    N3 = i7;
                    int i36 = i29;
                    N22 = i30;
                    N4 = i17;
                    N17 = i21;
                    N18 = i20;
                    N19 = i36;
                }
                g2.close();
                buVar.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                g2.close();
                buVar.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            buVar = c2;
            g2.close();
            buVar.release();
            throw th;
        }
    }

    public final ArrayList d() {
        bu buVar;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        bu c2 = bu.c(0, "SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=1");
        Zt zt = this.a;
        zt.b();
        Cursor g2 = zt.g(c2);
        try {
            int N = C1354qp.N(g2, "required_network_type");
            int N2 = C1354qp.N(g2, "requires_charging");
            int N3 = C1354qp.N(g2, "requires_device_idle");
            int N4 = C1354qp.N(g2, "requires_battery_not_low");
            int N5 = C1354qp.N(g2, "requires_storage_not_low");
            int N6 = C1354qp.N(g2, "trigger_content_update_delay");
            int N7 = C1354qp.N(g2, "trigger_max_content_delay");
            int N8 = C1354qp.N(g2, "content_uri_triggers");
            int N9 = C1354qp.N(g2, FacebookMediationAdapter.KEY_ID);
            int N10 = C1354qp.N(g2, RemoteConfigConstants.ResponseFieldKey.STATE);
            int N11 = C1354qp.N(g2, "worker_class_name");
            int N12 = C1354qp.N(g2, "input_merger_class_name");
            int N13 = C1354qp.N(g2, "input");
            int N14 = C1354qp.N(g2, "output");
            buVar = c2;
            try {
                int N15 = C1354qp.N(g2, "initial_delay");
                int N16 = C1354qp.N(g2, "interval_duration");
                int N17 = C1354qp.N(g2, "flex_duration");
                int N18 = C1354qp.N(g2, "run_attempt_count");
                int N19 = C1354qp.N(g2, "backoff_policy");
                int N20 = C1354qp.N(g2, "backoff_delay_duration");
                int N21 = C1354qp.N(g2, "period_start_time");
                int N22 = C1354qp.N(g2, "minimum_retention_duration");
                int N23 = C1354qp.N(g2, "schedule_requested_at");
                int N24 = C1354qp.N(g2, "run_in_foreground");
                int N25 = C1354qp.N(g2, "out_of_quota_policy");
                int i = N14;
                ArrayList arrayList = new ArrayList(g2.getCount());
                while (g2.moveToNext()) {
                    String string = g2.getString(N9);
                    int i2 = N9;
                    String string2 = g2.getString(N11);
                    int i3 = N11;
                    T6 t6 = new T6();
                    int i4 = N;
                    t6.f539a = oE.c(g2.getInt(N));
                    if (g2.getInt(N2) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    t6.f541a = z;
                    if (g2.getInt(N3) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    t6.f542b = z2;
                    if (g2.getInt(N4) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    t6.c = z3;
                    if (g2.getInt(N5) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    t6.d = z4;
                    int i5 = N2;
                    int i6 = N3;
                    t6.f538a = g2.getLong(N6);
                    t6.b = g2.getLong(N7);
                    t6.f540a = oE.a(g2.getBlob(N8));
                    C0214hE hEVar = new C0214hE(string, string2);
                    hEVar.f2989a = oE.e(g2.getInt(N10));
                    hEVar.f2997c = g2.getString(N12);
                    hEVar.f2990a = Data.a(g2.getBlob(N13));
                    int i7 = i;
                    hEVar.f2994b = Data.a(g2.getBlob(i7));
                    int i8 = N13;
                    int i9 = N15;
                    int i10 = i5;
                    hEVar.f2987a = g2.getLong(i9);
                    int i11 = N4;
                    int i12 = N16;
                    int i13 = i9;
                    hEVar.f2993b = g2.getLong(i12);
                    int i14 = i12;
                    int i15 = N17;
                    int i16 = i11;
                    hEVar.f2996c = g2.getLong(i15);
                    int i17 = N18;
                    hEVar.a = g2.getInt(i17);
                    int i18 = N19;
                    int i19 = i17;
                    hEVar.b = oE.b(g2.getInt(i18));
                    int i20 = i15;
                    int i21 = N20;
                    int i22 = i14;
                    hEVar.d = g2.getLong(i21);
                    int i23 = i18;
                    int i24 = N21;
                    int i25 = i21;
                    hEVar.e = g2.getLong(i24);
                    int i26 = i24;
                    int i27 = N22;
                    int i28 = i23;
                    hEVar.f = g2.getLong(i27);
                    int i29 = i27;
                    int i30 = N23;
                    int i31 = i26;
                    hEVar.g = g2.getLong(i30);
                    int i32 = N24;
                    if (g2.getInt(i32) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    hEVar.f2992a = z5;
                    int i33 = N25;
                    int i34 = i32;
                    hEVar.c = oE.d(g2.getInt(i33));
                    hEVar.f2988a = t6;
                    arrayList.add(hEVar);
                    i = i7;
                    N2 = i10;
                    N15 = i13;
                    N16 = i22;
                    N20 = i25;
                    N21 = i31;
                    N24 = i34;
                    N11 = i3;
                    N = i4;
                    N25 = i33;
                    N23 = i30;
                    N13 = i8;
                    N9 = i2;
                    N3 = i6;
                    int i35 = i28;
                    N22 = i29;
                    N4 = i16;
                    N17 = i20;
                    N18 = i19;
                    N19 = i35;
                }
                g2.close();
                buVar.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                g2.close();
                buVar.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            buVar = c2;
            g2.close();
            buVar.release();
            throw th;
        }
    }

    public final ArrayList e() {
        bu buVar;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        bu c2 = bu.c(0, "SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at<>-1");
        Zt zt = this.a;
        zt.b();
        Cursor g2 = zt.g(c2);
        try {
            int N = C1354qp.N(g2, "required_network_type");
            int N2 = C1354qp.N(g2, "requires_charging");
            int N3 = C1354qp.N(g2, "requires_device_idle");
            int N4 = C1354qp.N(g2, "requires_battery_not_low");
            int N5 = C1354qp.N(g2, "requires_storage_not_low");
            int N6 = C1354qp.N(g2, "trigger_content_update_delay");
            int N7 = C1354qp.N(g2, "trigger_max_content_delay");
            int N8 = C1354qp.N(g2, "content_uri_triggers");
            int N9 = C1354qp.N(g2, FacebookMediationAdapter.KEY_ID);
            int N10 = C1354qp.N(g2, RemoteConfigConstants.ResponseFieldKey.STATE);
            int N11 = C1354qp.N(g2, "worker_class_name");
            int N12 = C1354qp.N(g2, "input_merger_class_name");
            int N13 = C1354qp.N(g2, "input");
            int N14 = C1354qp.N(g2, "output");
            buVar = c2;
            try {
                int N15 = C1354qp.N(g2, "initial_delay");
                int N16 = C1354qp.N(g2, "interval_duration");
                int N17 = C1354qp.N(g2, "flex_duration");
                int N18 = C1354qp.N(g2, "run_attempt_count");
                int N19 = C1354qp.N(g2, "backoff_policy");
                int N20 = C1354qp.N(g2, "backoff_delay_duration");
                int N21 = C1354qp.N(g2, "period_start_time");
                int N22 = C1354qp.N(g2, "minimum_retention_duration");
                int N23 = C1354qp.N(g2, "schedule_requested_at");
                int N24 = C1354qp.N(g2, "run_in_foreground");
                int N25 = C1354qp.N(g2, "out_of_quota_policy");
                int i = N14;
                ArrayList arrayList = new ArrayList(g2.getCount());
                while (g2.moveToNext()) {
                    String string = g2.getString(N9);
                    int i2 = N9;
                    String string2 = g2.getString(N11);
                    int i3 = N11;
                    T6 t6 = new T6();
                    int i4 = N;
                    t6.f539a = oE.c(g2.getInt(N));
                    if (g2.getInt(N2) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    t6.f541a = z;
                    if (g2.getInt(N3) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    t6.f542b = z2;
                    if (g2.getInt(N4) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    t6.c = z3;
                    if (g2.getInt(N5) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    t6.d = z4;
                    int i5 = N2;
                    int i6 = N3;
                    t6.f538a = g2.getLong(N6);
                    t6.b = g2.getLong(N7);
                    t6.f540a = oE.a(g2.getBlob(N8));
                    C0214hE hEVar = new C0214hE(string, string2);
                    hEVar.f2989a = oE.e(g2.getInt(N10));
                    hEVar.f2997c = g2.getString(N12);
                    hEVar.f2990a = Data.a(g2.getBlob(N13));
                    int i7 = i;
                    hEVar.f2994b = Data.a(g2.getBlob(i7));
                    int i8 = N13;
                    int i9 = N15;
                    int i10 = i5;
                    hEVar.f2987a = g2.getLong(i9);
                    int i11 = N4;
                    int i12 = N16;
                    int i13 = i9;
                    hEVar.f2993b = g2.getLong(i12);
                    int i14 = i12;
                    int i15 = N17;
                    int i16 = i11;
                    hEVar.f2996c = g2.getLong(i15);
                    int i17 = N18;
                    hEVar.a = g2.getInt(i17);
                    int i18 = N19;
                    int i19 = i17;
                    hEVar.b = oE.b(g2.getInt(i18));
                    int i20 = i15;
                    int i21 = N20;
                    int i22 = i14;
                    hEVar.d = g2.getLong(i21);
                    int i23 = i18;
                    int i24 = N21;
                    int i25 = i21;
                    hEVar.e = g2.getLong(i24);
                    int i26 = i24;
                    int i27 = N22;
                    int i28 = i23;
                    hEVar.f = g2.getLong(i27);
                    int i29 = i27;
                    int i30 = N23;
                    int i31 = i26;
                    hEVar.g = g2.getLong(i30);
                    int i32 = N24;
                    if (g2.getInt(i32) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    hEVar.f2992a = z5;
                    int i33 = N25;
                    int i34 = i32;
                    hEVar.c = oE.d(g2.getInt(i33));
                    hEVar.f2988a = t6;
                    arrayList.add(hEVar);
                    i = i7;
                    N2 = i10;
                    N15 = i13;
                    N16 = i22;
                    N20 = i25;
                    N21 = i31;
                    N24 = i34;
                    N11 = i3;
                    N = i4;
                    N25 = i33;
                    N23 = i30;
                    N13 = i8;
                    N9 = i2;
                    N3 = i6;
                    int i35 = i28;
                    N22 = i29;
                    N4 = i16;
                    N17 = i20;
                    N18 = i19;
                    N19 = i35;
                }
                g2.close();
                buVar.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                g2.close();
                buVar.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            buVar = c2;
            g2.close();
            buVar.release();
            throw th;
        }
    }

    public final UD f(String str) {
        UD ud;
        bu c2 = bu.c(1, "SELECT state FROM workspec WHERE id=?");
        if (str == null) {
            c2.h(1);
        } else {
            c2.j(1, str);
        }
        Zt zt = this.a;
        zt.b();
        Cursor g2 = zt.g(c2);
        try {
            if (g2.moveToFirst()) {
                ud = oE.e(g2.getInt(0));
            } else {
                ud = null;
            }
            return ud;
        } finally {
            g2.close();
            c2.release();
        }
    }

    public final ArrayList g(String str) {
        bu c2 = bu.c(1, "SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)");
        if (str == null) {
            c2.h(1);
        } else {
            c2.j(1, str);
        }
        Zt zt = this.a;
        zt.b();
        Cursor g2 = zt.g(c2);
        try {
            ArrayList arrayList = new ArrayList(g2.getCount());
            while (g2.moveToNext()) {
                arrayList.add(g2.getString(0));
            }
            return arrayList;
        } finally {
            g2.close();
            c2.release();
        }
    }

    public final ArrayList h(String str) {
        bu c2 = bu.c(1, "SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)");
        if (str == null) {
            c2.h(1);
        } else {
            c2.j(1, str);
        }
        Zt zt = this.a;
        zt.b();
        Cursor g2 = zt.g(c2);
        try {
            ArrayList arrayList = new ArrayList(g2.getCount());
            while (g2.moveToNext()) {
                arrayList.add(g2.getString(0));
            }
            return arrayList;
        } finally {
            g2.close();
            c2.release();
        }
    }

    public final C0214hE i(String str) {
        bu buVar;
        C0214hE hEVar;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        String str2 = str;
        bu c2 = bu.c(1, "SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE id=?");
        if (str2 == null) {
            c2.h(1);
        } else {
            c2.j(1, str2);
        }
        Zt zt = this.a;
        zt.b();
        Cursor g2 = zt.g(c2);
        try {
            int N = C1354qp.N(g2, "required_network_type");
            int N2 = C1354qp.N(g2, "requires_charging");
            int N3 = C1354qp.N(g2, "requires_device_idle");
            int N4 = C1354qp.N(g2, "requires_battery_not_low");
            int N5 = C1354qp.N(g2, "requires_storage_not_low");
            int N6 = C1354qp.N(g2, "trigger_content_update_delay");
            int N7 = C1354qp.N(g2, "trigger_max_content_delay");
            int N8 = C1354qp.N(g2, "content_uri_triggers");
            int N9 = C1354qp.N(g2, FacebookMediationAdapter.KEY_ID);
            int N10 = C1354qp.N(g2, RemoteConfigConstants.ResponseFieldKey.STATE);
            int N11 = C1354qp.N(g2, "worker_class_name");
            int N12 = C1354qp.N(g2, "input_merger_class_name");
            int N13 = C1354qp.N(g2, "input");
            int N14 = C1354qp.N(g2, "output");
            buVar = c2;
            try {
                int N15 = C1354qp.N(g2, "initial_delay");
                int N16 = C1354qp.N(g2, "interval_duration");
                int N17 = C1354qp.N(g2, "flex_duration");
                int N18 = C1354qp.N(g2, "run_attempt_count");
                int N19 = C1354qp.N(g2, "backoff_policy");
                int N20 = C1354qp.N(g2, "backoff_delay_duration");
                int N21 = C1354qp.N(g2, "period_start_time");
                int N22 = C1354qp.N(g2, "minimum_retention_duration");
                int N23 = C1354qp.N(g2, "schedule_requested_at");
                int N24 = C1354qp.N(g2, "run_in_foreground");
                int N25 = C1354qp.N(g2, "out_of_quota_policy");
                if (g2.moveToFirst()) {
                    String string = g2.getString(N9);
                    String string2 = g2.getString(N11);
                    int i = N25;
                    T6 t6 = new T6();
                    t6.f539a = oE.c(g2.getInt(N));
                    if (g2.getInt(N2) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    t6.f541a = z;
                    if (g2.getInt(N3) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    t6.f542b = z2;
                    if (g2.getInt(N4) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    t6.c = z3;
                    if (g2.getInt(N5) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    t6.d = z4;
                    t6.f538a = g2.getLong(N6);
                    t6.b = g2.getLong(N7);
                    t6.f540a = oE.a(g2.getBlob(N8));
                    hEVar = new C0214hE(string, string2);
                    hEVar.f2989a = oE.e(g2.getInt(N10));
                    hEVar.f2997c = g2.getString(N12);
                    hEVar.f2990a = Data.a(g2.getBlob(N13));
                    hEVar.f2994b = Data.a(g2.getBlob(N14));
                    hEVar.f2987a = g2.getLong(N15);
                    hEVar.f2993b = g2.getLong(N16);
                    hEVar.f2996c = g2.getLong(N17);
                    hEVar.a = g2.getInt(N18);
                    hEVar.b = oE.b(g2.getInt(N19));
                    hEVar.d = g2.getLong(N20);
                    hEVar.e = g2.getLong(N21);
                    hEVar.f = g2.getLong(N22);
                    hEVar.g = g2.getLong(N23);
                    if (g2.getInt(N24) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    hEVar.f2992a = z5;
                    hEVar.c = oE.d(g2.getInt(i));
                    hEVar.f2988a = t6;
                } else {
                    hEVar = null;
                }
                g2.close();
                buVar.release();
                return hEVar;
            } catch (Throwable th) {
                th = th;
                g2.close();
                buVar.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            buVar = c2;
            g2.close();
            buVar.release();
            throw th;
        }
    }

    public final ArrayList j(String str) {
        bu c2 = bu.c(1, "SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)");
        if (str == null) {
            c2.h(1);
        } else {
            c2.j(1, str);
        }
        Zt zt = this.a;
        zt.b();
        Cursor g2 = zt.g(c2);
        try {
            int N = C1354qp.N(g2, FacebookMediationAdapter.KEY_ID);
            int N2 = C1354qp.N(g2, RemoteConfigConstants.ResponseFieldKey.STATE);
            ArrayList arrayList = new ArrayList(g2.getCount());
            while (g2.moveToNext()) {
                C0214hE.a aVar = new C0214hE.a();
                aVar.f2998a = g2.getString(N);
                aVar.a = oE.e(g2.getInt(N2));
                arrayList.add(aVar);
            }
            return arrayList;
        } finally {
            g2.close();
            c2.release();
        }
    }

    public final int k(String str, long j) {
        Zt zt = this.a;
        zt.b();
        g gVar = this.f3031a;
        C0085Cd a2 = gVar.a();
        a2.c(1, j);
        if (str == null) {
            a2.e(2);
        } else {
            a2.h(2, str);
        }
        zt.c();
        try {
            int j2 = a2.j();
            zt.h();
            return j2;
        } finally {
            zt.f();
            gVar.c(a2);
        }
    }

    public final void l(String str, Data data) {
        Zt zt = this.a;
        zt.b();
        c cVar = this.f3027a;
        C0085Cd a2 = cVar.a();
        byte[] c2 = Data.c(data);
        if (c2 == null) {
            a2.e(1);
        } else {
            a2.a(1, c2);
        }
        if (str == null) {
            a2.e(2);
        } else {
            a2.h(2, str);
        }
        zt.c();
        try {
            a2.j();
            zt.h();
        } finally {
            zt.f();
            cVar.c(a2);
        }
    }

    public final void m(String str, long j) {
        Zt zt = this.a;
        zt.b();
        d dVar = this.f3028a;
        C0085Cd a2 = dVar.a();
        a2.c(1, j);
        if (str == null) {
            a2.e(2);
        } else {
            a2.h(2, str);
        }
        zt.c();
        try {
            a2.j();
            zt.h();
        } finally {
            zt.f();
            dVar.c(a2);
        }
    }

    public final int n(UD ud, String... strArr) {
        Zt zt = this.a;
        zt.b();
        StringBuilder sb = new StringBuilder("UPDATE workspec SET state=? WHERE id IN (");
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            sb.append("?");
            if (i < length - 1) {
                sb.append(",");
            }
        }
        sb.append(")");
        String sb2 = sb.toString();
        zt.a();
        zt.b();
        C0085Cd cd = new C0085Cd(((C0408yd) zt.f768a.f()).f3431a.compileStatement(sb2));
        cd.c(1, (long) oE.f(ud));
        int i2 = 2;
        for (String str : strArr) {
            if (str == null) {
                cd.e(i2);
            } else {
                cd.h(i2, str);
            }
            i2++;
        }
        zt.c();
        try {
            int j = cd.j();
            zt.h();
            return j;
        } finally {
            zt.f();
        }
    }
}
