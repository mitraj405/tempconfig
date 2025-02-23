package defpackage;

import java.util.ArrayList;
import java.util.List;

/* renamed from: tk  reason: default package and case insensitive filesystem */
/* compiled from: MaskKeyframeAnimation */
public class C0344tk {
    public final Object a;
    public Object b;
    public final Object c;

    public C0344tk(List list) {
        this.c = list;
        this.a = new ArrayList(list.size());
        this.b = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            ((List) this.a).add(new sw(((C0331sk) list.get(i)).f3277a.a));
            ((List) this.b).add(((C0331sk) list.get(i)).b.b());
        }
    }

    public Object a(Fj fj) {
        return this.c;
    }

    public final Object b(float f, float f2, Object obj, Object obj2, float f3, float f4, float f5) {
        Fj fj = (Fj) this.a;
        fj.a = f;
        fj.b = f2;
        fj.f211a = obj;
        fj.f212b = obj2;
        fj.c = f3;
        fj.d = f4;
        fj.e = f5;
        return a(fj);
    }

    public /* synthetic */ C0344tk(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.a = bArr;
        this.b = bArr2;
        this.c = bArr3;
    }

    public /* synthetic */ C0344tk() {
        this.a = new Fj();
        this.c = null;
    }

    public /* synthetic */ C0344tk(Ow ow) {
        this.a = new Fj();
        this.c = null;
        this.c = ow;
    }
}
