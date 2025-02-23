package defpackage;

import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: N8  reason: default package */
/* compiled from: DependencyNode */
public class N8 implements J8 {
    public int a = 1;

    /* renamed from: a  reason: collision with other field name */
    public CD f429a = null;

    /* renamed from: a  reason: collision with other field name */
    public C0154c9 f430a = null;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList f431a = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    public boolean f432a = false;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public final CD f433b;

    /* renamed from: b  reason: collision with other field name */
    public final ArrayList f434b = new ArrayList();

    /* renamed from: b  reason: collision with other field name */
    public boolean f435b = false;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f436c = false;
    public int d = 1;

    public N8(CD cd) {
        this.f433b = cd;
    }

    public final void a(J8 j8) {
        ArrayList arrayList = this.f434b;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!((N8) it.next()).f436c) {
                return;
            }
        }
        this.f435b = true;
        CD cd = this.f429a;
        if (cd != null) {
            cd.a(this);
        }
        if (this.f432a) {
            this.f433b.a(this);
            return;
        }
        Iterator it2 = arrayList.iterator();
        N8 n8 = null;
        int i = 0;
        while (it2.hasNext()) {
            N8 n82 = (N8) it2.next();
            if (!(n82 instanceof C0154c9)) {
                i++;
                n8 = n82;
            }
        }
        if (n8 != null && i == 1 && n8.f436c) {
            C0154c9 c9Var = this.f430a;
            if (c9Var != null) {
                if (c9Var.f436c) {
                    this.b = this.d * c9Var.c;
                } else {
                    return;
                }
            }
            d(n8.c + this.b);
        }
        CD cd2 = this.f429a;
        if (cd2 != null) {
            cd2.a(this);
        }
    }

    public final void b(J8 j8) {
        this.f431a.add(j8);
        if (this.f436c) {
            j8.a(j8);
        }
    }

    public final void c() {
        this.f434b.clear();
        this.f431a.clear();
        this.f436c = false;
        this.c = 0;
        this.f435b = false;
        this.f432a = false;
    }

    public void d(int i) {
        if (!this.f436c) {
            this.f436c = true;
            this.c = i;
            Iterator it = this.f431a.iterator();
            while (it.hasNext()) {
                J8 j8 = (J8) it.next();
                j8.a(j8);
            }
        }
    }

    public final String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f433b.f81a.f1365b);
        sb.append(":");
        sb.append(C1058d.O(this.a));
        sb.append("(");
        if (this.f436c) {
            obj = Integer.valueOf(this.c);
        } else {
            obj = "unresolved";
        }
        sb.append(obj);
        sb.append(") <t=");
        sb.append(this.f434b.size());
        sb.append(":d=");
        sb.append(this.f431a.size());
        sb.append(">");
        return sb.toString();
    }
}
