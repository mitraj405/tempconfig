package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;

/* renamed from: KC  reason: default package and case insensitive filesystem */
/* compiled from: ViewPump.kt */
public final class C0562KC {
    public static final b a = new b();

    /* renamed from: a  reason: collision with other field name */
    public static C0562KC f3679a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList f3680a;

    /* renamed from: a  reason: collision with other field name */
    public final List<C1156hg> f3681a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f3682a;
    public final boolean b;

    /* renamed from: KC$a */
    /* compiled from: ViewPump.kt */
    public static final class a extends C0595Mh implements Function0<r1> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        public final Object invoke() {
            return new r1();
        }
    }

    /* renamed from: KC$b */
    /* compiled from: ViewPump.kt */
    public static final class b {
        public static final /* synthetic */ KProperty[] a;

        static {
            C0532Hq hq = new C0532Hq(C0584Ls.a(b.class), "reflectiveFallbackViewCreator", "getReflectiveFallbackViewCreator()Lio/github/inflationx/viewpump/FallbackViewCreator;");
            C0584Ls.a.getClass();
            a = new KProperty[]{hq};
        }

        public static C0562KC a() {
            C0562KC kc = C0562KC.f3679a;
            if (kc != null) {
                return kc;
            }
            C0562KC kc2 = new C0562KC(C1472x5.b0(new ArrayList()), true, true);
            C0562KC.f3679a = kc2;
            return kc2;
        }
    }

    static {
        C1354qp.d0(a.a);
    }

    public C0562KC(List list, boolean z, boolean z2) {
        this.f3681a = list;
        this.f3682a = z;
        this.b = z2;
        Collection collection = list;
        C0773a aVar = new C0773a();
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(aVar);
        this.f3680a = new ArrayList(arrayList);
    }

    public final Ff a(Ef ef) {
        ArrayList arrayList = this.f3680a;
        C1177ig.g(arrayList, "interceptors");
        if (arrayList.size() > 0) {
            return ((C1156hg) arrayList.get(0)).intercept(new C0791b(arrayList, 1, ef));
        }
        throw new AssertionError("no interceptors added to the chain");
    }
}
