package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.p;
import defpackage.OB;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: LazyStringArrayList */
public final class t extends C0126c<String> implements Vh, RandomAccess {
    public final ArrayList a;

    static {
        new t(10).a = false;
    }

    public t(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    public final void add(int i, Object obj) {
        a();
        this.a.add(i, (String) obj);
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public final void clear() {
        a();
        this.a.clear();
        this.modCount++;
    }

    public final Object get(int i) {
        String str;
        ArrayList arrayList = this.a;
        Object obj = arrayList.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof x3) {
            x3 x3Var = (x3) obj;
            x3Var.getClass();
            Charset charset = p.a;
            if (x3Var.size() == 0) {
                str = "";
            } else {
                str = x3Var.g(charset);
            }
            if (x3Var.e()) {
                arrayList.set(i, str);
            }
        } else {
            byte[] bArr = (byte[]) obj;
            str = new String(bArr, p.a);
            OB.b bVar = OB.a;
            boolean z = false;
            if (OB.a.c(bArr, 0, bArr.length) == 0) {
                z = true;
            }
            if (z) {
                arrayList.set(i, str);
            }
        }
        return str;
    }

    public final Object getRaw(int i) {
        return this.a.get(i);
    }

    public final List<?> getUnderlyingElements() {
        return Collections.unmodifiableList(this.a);
    }

    public final void j(x3 x3Var) {
        a();
        this.a.add(x3Var);
        this.modCount++;
    }

    public final p.c l(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.a);
            return new t((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final Vh m() {
        if (this.a) {
            return new kB(this);
        }
        return this;
    }

    public final Object remove(int i) {
        a();
        Object remove = this.a.remove(i);
        this.modCount++;
        if (remove instanceof String) {
            return (String) remove;
        }
        if (!(remove instanceof x3)) {
            return new String((byte[]) remove, p.a);
        }
        x3 x3Var = (x3) remove;
        x3Var.getClass();
        Charset charset = p.a;
        if (x3Var.size() == 0) {
            return "";
        }
        return x3Var.g(charset);
    }

    public final Object set(int i, Object obj) {
        a();
        Object obj2 = this.a.set(i, (String) obj);
        if (obj2 instanceof String) {
            return (String) obj2;
        }
        if (!(obj2 instanceof x3)) {
            return new String((byte[]) obj2, p.a);
        }
        x3 x3Var = (x3) obj2;
        x3Var.getClass();
        Charset charset = p.a;
        if (x3Var.size() == 0) {
            return "";
        }
        return x3Var.g(charset);
    }

    public final int size() {
        return this.a.size();
    }

    public t(ArrayList<Object> arrayList) {
        this.a = arrayList;
    }

    public final boolean addAll(int i, Collection<? extends String> collection) {
        a();
        if (collection instanceof Vh) {
            collection = ((Vh) collection).getUnderlyingElements();
        }
        boolean addAll = this.a.addAll(i, collection);
        this.modCount++;
        return addAll;
    }
}
