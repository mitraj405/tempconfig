package defpackage;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;

/* renamed from: LC  reason: default package and case insensitive filesystem */
/* compiled from: ViewPumpContextWrapper.kt */
public final class C0575LC extends ContextWrapper {
    public static final a a = new a();

    /* renamed from: a  reason: collision with other field name */
    public static final /* synthetic */ KProperty[] f3693a;

    /* renamed from: a  reason: collision with other field name */
    public final C1277nB f3694a = new C1277nB(new b(this));

    /* renamed from: LC$a */
    /* compiled from: ViewPumpContextWrapper.kt */
    public static final class a {
    }

    /* renamed from: LC$b */
    /* compiled from: ViewPumpContextWrapper.kt */
    public static final class b extends C0595Mh implements Function0<C0811c> {
        public final /* synthetic */ C0575LC a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(C0575LC lc) {
            super(0);
            this.a = lc;
        }

        public final Object invoke() {
            C0575LC lc = this.a;
            LayoutInflater from = LayoutInflater.from(lc.getBaseContext());
            C1177ig.b(from, "LayoutInflater.from(baseContext)");
            return new C0811c(from, lc, false);
        }
    }

    static {
        C0532Hq hq = new C0532Hq(C0584Ls.a(C0575LC.class), "inflater", "getInflater()Lio/github/inflationx/viewpump/internal/-ViewPumpLayoutInflater;");
        C0584Ls.a.getClass();
        f3693a = new KProperty[]{hq};
    }

    public C0575LC(Context context) {
        super(context);
    }

    public static final C0575LC a(Context context) {
        a.getClass();
        C1177ig.g(context, "base");
        return new C0575LC(context);
    }

    public final Object getSystemService(String str) {
        C1177ig.g(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
        if (!C1177ig.a("layout_inflater", str)) {
            return super.getSystemService(str);
        }
        KProperty kProperty = f3693a[0];
        return (C0811c) this.f3694a.getValue();
    }
}
