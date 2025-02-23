package androidx.fragment.app;

import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public abstract class FragmentTransaction {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public CharSequence f2116a;

    /* renamed from: a  reason: collision with other field name */
    public String f2117a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<a> f2118a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public boolean f2119a;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public CharSequence f2120b;

    /* renamed from: b  reason: collision with other field name */
    public ArrayList<String> f2121b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f2122b = true;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public ArrayList<String> f2123c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f2124c = false;
    public int d;
    public int e;
    public int f;
    public int g;

    public static final class a {
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public Fragment f2125a;

        /* renamed from: a  reason: collision with other field name */
        public Lifecycle.State f2126a;
        public int b;

        /* renamed from: b  reason: collision with other field name */
        public Lifecycle.State f2127b;
        public int c;
        public int d;
        public int e;

        public a() {
        }

        public a(Fragment fragment, int i) {
            this.a = i;
            this.f2125a = fragment;
            Lifecycle.State state = Lifecycle.State.RESUMED;
            this.f2126a = state;
            this.f2127b = state;
        }

        public a(Fragment fragment, Lifecycle.State state) {
            this.a = 10;
            this.f2125a = fragment;
            this.f2126a = fragment.mMaxState;
            this.f2127b = state;
        }
    }

    @Deprecated
    public FragmentTransaction() {
    }

    public final void b(a aVar) {
        this.f2118a.add(aVar);
        aVar.b = this.a;
        aVar.c = this.b;
        aVar.d = this.c;
        aVar.e = this.d;
    }

    public abstract int c();

    public abstract int d();

    public abstract void e();

    public void f(Fragment fragment) {
        b(new a(fragment, 6));
    }

    public void g(int i, Fragment fragment, String str, int i2) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str2 = fragment.mTag;
            if (str2 == null || str.equals(str2)) {
                fragment.mTag = str;
            } else {
                StringBuilder sb = new StringBuilder("Can't change tag of fragment ");
                sb.append(fragment);
                sb.append(": was ");
                throw new IllegalStateException(C1058d.B(sb, fragment.mTag, " now ", str));
            }
        }
        if (i != 0) {
            if (i != -1) {
                int i3 = fragment.mFragmentId;
                if (i3 == 0 || i3 == i) {
                    fragment.mFragmentId = i;
                    fragment.mContainerId = i;
                } else {
                    throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i);
                }
            } else {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
        }
        b(new a(fragment, i2));
    }

    public void h(Fragment fragment, Lifecycle.State state) {
        b(new a(fragment, state));
    }

    public FragmentTransaction(int i) {
    }
}
