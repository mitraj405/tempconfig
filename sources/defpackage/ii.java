package defpackage;

import androidx.collection.SparseArrayCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.loader.app.LoaderManager;
import java.io.PrintWriter;

/* renamed from: ii  reason: default package */
/* compiled from: LoaderManagerImpl */
public final class ii extends LoaderManager {
    public final LifecycleOwner a;

    /* renamed from: a  reason: collision with other field name */
    public final b f3016a;

    /* renamed from: ii$a */
    /* compiled from: LoaderManagerImpl */
    public static class a<D> extends MutableLiveData<D> {
        public final void f() {
            throw null;
        }

        public final void g() {
            throw null;
        }

        public final void h(Observer<? super D> observer) {
            super.h(observer);
        }

        public final void i(D d) {
            super.i(d);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #0 : ");
            C1354qp.m(sb, (LifecycleOwner) null);
            sb.append("}}");
            return sb.toString();
        }
    }

    /* renamed from: ii$b */
    /* compiled from: LoaderManagerImpl */
    public static class b extends C0404yC {
        public static final a a = new a();

        /* renamed from: a  reason: collision with other field name */
        public final SparseArrayCompat<a> f3017a = new SparseArrayCompat<>();

        /* renamed from: ii$b$a */
        /* compiled from: LoaderManagerImpl */
        public static class a implements ViewModelProvider.Factory {
            public final <T extends C0404yC> T b(Class<T> cls) {
                return new b();
            }
        }

        public final void b() {
            SparseArrayCompat<a> sparseArrayCompat = this.f3017a;
            int i = sparseArrayCompat.c;
            if (i <= 0) {
                Object[] objArr = sparseArrayCompat.f1330a;
                for (int i2 = 0; i2 < i; i2++) {
                    objArr[i2] = null;
                }
                sparseArrayCompat.c = 0;
                return;
            }
            ((a) sparseArrayCompat.f1330a[0]).getClass();
            throw null;
        }
    }

    public ii(LifecycleOwner lifecycleOwner, ViewModelStore viewModelStore) {
        this.a = lifecycleOwner;
        this.f3016a = (b) new ViewModelProvider(viewModelStore, b.a).a(b.class);
    }

    @Deprecated
    public final void b(String str, PrintWriter printWriter) {
        SparseArrayCompat<a> sparseArrayCompat = this.f3016a.f3017a;
        if (sparseArrayCompat.c > 0) {
            printWriter.print(str);
            printWriter.println("Loaders:");
            String str2 = str + "    ";
            if (sparseArrayCompat.c > 0) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(sparseArrayCompat.f1329a[0]);
                printWriter.print(": ");
                printWriter.println(((a) sparseArrayCompat.f1330a[0]).toString());
                printWriter.print(str2);
                printWriter.print("mId=");
                printWriter.print(0);
                printWriter.print(" mArgs=");
                printWriter.println((Object) null);
                printWriter.print(str2);
                printWriter.print("mLoader=");
                printWriter.println((Object) null);
                throw null;
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        C1354qp.m(sb, this.a);
        sb.append("}}");
        return sb.toString();
    }
}
