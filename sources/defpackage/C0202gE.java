package defpackage;

import androidx.work.ListenableWorker;
import defpackage.fo;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/* renamed from: gE  reason: default package and case insensitive filesystem */
/* compiled from: WorkRequest */
public abstract class C0202gE {
    public final C0214hE a;

    /* renamed from: a  reason: collision with other field name */
    public final Set<String> f2963a;

    /* renamed from: a  reason: collision with other field name */
    public final UUID f2964a;

    /* renamed from: gE$a */
    /* compiled from: WorkRequest */
    public static abstract class a<B extends a<?, ?>, W extends C0202gE> {
        public C0214hE a;

        /* renamed from: a  reason: collision with other field name */
        public final HashSet f2965a;

        /* renamed from: a  reason: collision with other field name */
        public UUID f2966a = UUID.randomUUID();

        public a(Class<? extends ListenableWorker> cls) {
            HashSet hashSet = new HashSet();
            this.f2965a = hashSet;
            this.a = new C0214hE(this.f2966a.toString(), cls.getName());
            hashSet.add(cls.getName());
        }

        public final fo a() {
            boolean z;
            fo foVar = new fo((fo.a) this);
            T6 t6 = this.a.f2988a;
            boolean z2 = true;
            if (t6.f540a.a.size() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z && !t6.c && !t6.f541a && !t6.f542b) {
                z2 = false;
            }
            if (!this.a.f2992a || !z2) {
                this.f2966a = UUID.randomUUID();
                C0214hE hEVar = new C0214hE(this.a);
                this.a = hEVar;
                hEVar.f2991a = this.f2966a.toString();
                return foVar;
            }
            throw new IllegalArgumentException("Expedited jobs only support network and storage constraints");
        }
    }

    public C0202gE(UUID uuid, C0214hE hEVar, HashSet hashSet) {
        this.f2964a = uuid;
        this.a = hEVar;
        this.f2963a = hashSet;
    }
}
