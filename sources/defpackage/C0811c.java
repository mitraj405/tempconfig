package defpackage;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import defpackage.C0562KC;
import in.juspay.hyper.constants.LogCategory;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: c  reason: default package and case insensitive filesystem */
/* compiled from: -ViewPumpLayoutInflater.kt */
public final class C0811c extends LayoutInflater {
    public static final C0715Uy a = C1354qp.d0(a.a);

    /* renamed from: a  reason: collision with other field name */
    public static final b f3926a = new b();

    /* renamed from: a  reason: collision with other field name */
    public static final LinkedHashSet f3927a;

    /* renamed from: a  reason: collision with other field name */
    public final C0050c f3928a;

    /* renamed from: a  reason: collision with other field name */
    public final d f3929a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f3930a;
    public boolean b;

    /* renamed from: c$a */
    /* compiled from: -ViewPumpLayoutInflater.kt */
    public static final class a extends C0595Mh implements Function0<Field> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        public final Object invoke() {
            Field declaredField = LayoutInflater.class.getDeclaredField("mConstructorArgs");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                return declaredField;
            }
            throw new IllegalArgumentException("No constructor arguments field found in LayoutInflater!".toString());
        }
    }

    /* renamed from: c$b */
    /* compiled from: -ViewPumpLayoutInflater.kt */
    public static final class b {
        public static final /* synthetic */ KProperty[] a;

        static {
            C0532Hq hq = new C0532Hq(C0584Ls.a(b.class), "CONSTRUCTOR_ARGS_FIELD", "getCONSTRUCTOR_ARGS_FIELD()Ljava/lang/reflect/Field;");
            C0584Ls.a.getClass();
            a = new KProperty[]{hq};
        }

        public static final Field a(b bVar) {
            bVar.getClass();
            C0715Uy uy = C0811c.a;
            KProperty kProperty = a[0];
            return (Field) uy.getValue();
        }
    }

    /* renamed from: c$c  reason: collision with other inner class name */
    /* compiled from: -ViewPumpLayoutInflater.kt */
    public static final class C0050c implements C0680Sb {
        public final C0811c a;

        public C0050c(C0811c cVar) {
            C1177ig.g(cVar, "inflater");
            this.a = cVar;
        }

        public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            C0811c cVar;
            C1177ig.g(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
            C1177ig.g(context, LogCategory.CONTEXT);
            Iterator it = C0811c.f3927a.iterator();
            View view2 = null;
            while (true) {
                boolean hasNext = it.hasNext();
                cVar = this.a;
                if (!hasNext) {
                    break;
                }
                try {
                    view2 = cVar.createView(str, (String) it.next(), attributeSet);
                    if (view2 != null) {
                        break;
                    }
                } catch (ClassNotFoundException unused) {
                }
            }
            if (view2 == null) {
                return C0811c.b(cVar, str, attributeSet);
            }
            return view2;
        }
    }

    /* renamed from: c$d */
    /* compiled from: -ViewPumpLayoutInflater.kt */
    public static final class d implements C0680Sb {
        public final C0811c a;

        public d(C0811c cVar) {
            C1177ig.g(cVar, "inflater");
            this.a = cVar;
        }

        public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            C1177ig.g(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
            C1177ig.g(context, LogCategory.CONTEXT);
            return C0811c.a(this.a, view, str, attributeSet);
        }
    }

    /* renamed from: c$e */
    /* compiled from: -ViewPumpLayoutInflater.kt */
    public static final class e extends g {
        public final f a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(LayoutInflater.Factory2 factory2, C0811c cVar) {
            super(factory2);
            C1177ig.g(cVar, "inflater");
            this.a = new f(factory2, cVar);
        }

        public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            C1177ig.g(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
            C1177ig.g(context, LogCategory.CONTEXT);
            C0562KC.a.getClass();
            return C0562KC.b.a().a(new Ef(str, context, attributeSet, view, this.a)).f3584a;
        }
    }

    /* renamed from: c$f */
    /* compiled from: -ViewPumpLayoutInflater.kt */
    public static final class f extends h {
        public final C0811c a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(LayoutInflater.Factory2 factory2, C0811c cVar) {
            super(factory2);
            C1177ig.g(cVar, "inflater");
            this.a = cVar;
        }

        public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            C1177ig.g(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
            C1177ig.g(context, LogCategory.CONTEXT);
            View onCreateView = this.a.onCreateView(view, str, context, attributeSet);
            LinkedHashSet linkedHashSet = C0811c.f3927a;
            C0811c cVar = this.a;
            cVar.getClass();
            C0562KC.a.getClass();
            if (!C0562KC.b.a().b || onCreateView != null || C1337py.X0(str, '.') <= -1) {
                return onCreateView;
            }
            if (cVar.f3930a) {
                return cVar.cloneInContext(context).createView(str, (String) null, attributeSet);
            }
            b bVar = C0811c.f3926a;
            Object obj = b.a(bVar).get(cVar);
            if (obj != null) {
                Object[] objArr = (Object[]) obj;
                Object obj2 = objArr[0];
                objArr[0] = context;
                r1.Q(b.a(bVar), cVar, objArr);
                try {
                    onCreateView = cVar.createView(str, (String) null, attributeSet);
                    objArr[0] = obj2;
                } catch (ClassNotFoundException unused) {
                    objArr[0] = obj2;
                } catch (Throwable th) {
                    objArr[0] = obj2;
                    r1.Q(b.a(bVar), cVar, objArr);
                    throw th;
                }
                r1.Q(b.a(bVar), cVar, objArr);
                return onCreateView;
            }
            throw new C0633PA("null cannot be cast to non-null type kotlin.Array<kotlin.Any>");
        }
    }

    /* renamed from: c$g */
    /* compiled from: -ViewPumpLayoutInflater.kt */
    public static class g implements LayoutInflater.Factory2 {
        public final h a;

        public g(LayoutInflater.Factory2 factory2) {
            C1177ig.g(factory2, "factory2");
            this.a = new h(factory2);
        }

        public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
            C1177ig.g(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
            C1177ig.g(context, LogCategory.CONTEXT);
            return onCreateView((View) null, str, context, attributeSet);
        }

        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            C1177ig.g(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
            C1177ig.g(context, LogCategory.CONTEXT);
            C0562KC.a.getClass();
            return C0562KC.b.a().a(new Ef(str, context, attributeSet, view, this.a)).f3584a;
        }
    }

    /* renamed from: c$h */
    /* compiled from: -ViewPumpLayoutInflater.kt */
    public static class h implements C0680Sb {
        public final LayoutInflater.Factory2 a;

        public h(LayoutInflater.Factory2 factory2) {
            C1177ig.g(factory2, "factory2");
            this.a = factory2;
        }

        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            C1177ig.g(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
            C1177ig.g(context, LogCategory.CONTEXT);
            return this.a.onCreateView(view, str, context, attributeSet);
        }
    }

    /* renamed from: c$i */
    /* compiled from: -ViewPumpLayoutInflater.kt */
    public static final class i implements LayoutInflater.Factory {
        public final j a;

        public i(LayoutInflater.Factory factory) {
            C1177ig.g(factory, "factory");
            this.a = new j(factory);
        }

        public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
            C1177ig.g(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
            C1177ig.g(context, LogCategory.CONTEXT);
            C0562KC.a.getClass();
            return C0562KC.b.a().a(new Ef(str, context, attributeSet, this.a)).f3584a;
        }
    }

    /* renamed from: c$j */
    /* compiled from: -ViewPumpLayoutInflater.kt */
    public static final class j implements C0680Sb {
        public final LayoutInflater.Factory a;

        public j(LayoutInflater.Factory factory) {
            C1177ig.g(factory, "factory");
            this.a = factory;
        }

        public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            C1177ig.g(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
            C1177ig.g(context, LogCategory.CONTEXT);
            return this.a.onCreateView(str, context, attributeSet);
        }
    }

    static {
        String[] strArr = {"android.widget.", "android.webkit."};
        LinkedHashSet linkedHashSet = new LinkedHashSet(r1.H(2));
        for (int i2 = 0; i2 < 2; i2++) {
            linkedHashSet.add(strArr[i2]);
        }
        f3927a = linkedHashSet;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0811c(LayoutInflater layoutInflater, Context context, boolean z) {
        super(layoutInflater, context);
        boolean z2;
        C1177ig.g(layoutInflater, "original");
        C1177ig.g(context, "newContext");
        int i2 = Build.VERSION.SDK_INT;
        boolean z3 = true;
        if (i2 <= 28) {
            int i3 = s3.a;
            if (i2 >= 29) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                z3 = false;
            }
        }
        this.f3930a = z3;
        this.f3928a = new C0050c(this);
        this.f3929a = new d(this);
        C0562KC.a.getClass();
        C0562KC.b.a();
        if (!z) {
            if (getFactory2() != null && !(getFactory2() instanceof g)) {
                setFactory2(getFactory2());
            }
            if (getFactory() != null && !(getFactory() instanceof i)) {
                setFactory(getFactory());
            }
        }
    }

    public static final View a(C0811c cVar, View view, String str, AttributeSet attributeSet) {
        cVar.getClass();
        try {
            return super.onCreateView(view, str, attributeSet);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static final View b(C0811c cVar, String str, AttributeSet attributeSet) {
        cVar.getClass();
        try {
            return super.onCreateView(str, attributeSet);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public final LayoutInflater cloneInContext(Context context) {
        C1177ig.g(context, "newContext");
        return new C0811c(this, context, true);
    }

    public final View inflate(int i2, ViewGroup viewGroup, boolean z) {
        return super.inflate(i2, viewGroup, z);
    }

    public final View onCreateView(View view, String str, AttributeSet attributeSet) throws ClassNotFoundException {
        C1177ig.g(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
        C0562KC.a.getClass();
        C0562KC a2 = C0562KC.b.a();
        Context context = getContext();
        C1177ig.b(context, LogCategory.CONTEXT);
        return a2.a(new Ef(str, context, attributeSet, view, this.f3929a)).f3584a;
    }

    public final void setFactory(LayoutInflater.Factory factory) {
        C1177ig.g(factory, "factory");
        if (!(factory instanceof i)) {
            super.setFactory(new i(factory));
        } else {
            super.setFactory(factory);
        }
    }

    public final void setFactory2(LayoutInflater.Factory2 factory2) {
        C1177ig.g(factory2, "factory2");
        if (!(factory2 instanceof g)) {
            super.setFactory2(new g(factory2));
        } else {
            super.setFactory2(factory2);
        }
    }

    public final View inflate(XmlPullParser xmlPullParser, ViewGroup viewGroup, boolean z) {
        Method method;
        C1177ig.g(xmlPullParser, "parser");
        if (!this.b) {
            C0562KC.a.getClass();
            if (C0562KC.b.a().f3682a) {
                if (!(getContext() instanceof LayoutInflater.Factory2)) {
                    this.b = true;
                } else {
                    Method[] methods = LayoutInflater.class.getMethods();
                    int length = methods.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            method = null;
                            break;
                        }
                        method = methods[i2];
                        C1177ig.b(method, FirebaseAnalytics.Param.METHOD);
                        if (C1177ig.a(method.getName(), "setPrivateFactory")) {
                            method.setAccessible(true);
                            break;
                        }
                        i2++;
                    }
                    Object[] objArr = new Object[1];
                    Context context = getContext();
                    if (context != null) {
                        objArr[0] = new e((LayoutInflater.Factory2) context, this);
                        if (method != null) {
                            try {
                                method.invoke(this, Arrays.copyOf(objArr, 1));
                            } catch (IllegalAccessException | InvocationTargetException unused) {
                            }
                        }
                        this.b = true;
                    } else {
                        throw new C0633PA("null cannot be cast to non-null type android.view.LayoutInflater.Factory2");
                    }
                }
            }
        }
        View inflate = super.inflate(xmlPullParser, viewGroup, z);
        C1177ig.b(inflate, "super.inflate(parser, root, attachToRoot)");
        return inflate;
    }

    public final View onCreateView(String str, AttributeSet attributeSet) throws ClassNotFoundException {
        C1177ig.g(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
        C0562KC.a.getClass();
        C0562KC a2 = C0562KC.b.a();
        Context context = getContext();
        C1177ig.b(context, LogCategory.CONTEXT);
        return a2.a(new Ef(str, context, attributeSet, this.f3928a)).f3584a;
    }
}
