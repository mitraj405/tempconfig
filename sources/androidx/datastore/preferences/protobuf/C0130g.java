package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.nio.charset.Charset;

/* renamed from: androidx.datastore.preferences.protobuf.g  reason: case insensitive filesystem */
/* compiled from: CodedOutputStreamWriter */
public final class C0130g {
    public final s5 a;

    public C0130g(s5 s5Var) {
        Charset charset = p.a;
        if (s5Var != null) {
            this.a = s5Var;
            s5Var.f3248a = this;
            return;
        }
        throw new NullPointerException("output");
    }

    public final void a(int i, boolean z) throws IOException {
        this.a.C(i, z);
    }

    public final void b(int i, x3 x3Var) throws IOException {
        this.a.E(i, x3Var);
    }

    public final void c(int i, double d) throws IOException {
        s5 s5Var = this.a;
        s5Var.getClass();
        s5Var.I(i, Double.doubleToRawLongBits(d));
    }

    public final void d(int i, int i2) throws IOException {
        this.a.K(i, i2);
    }

    public final void e(int i, int i2) throws IOException {
        this.a.G(i, i2);
    }

    public final void f(int i, long j) throws IOException {
        this.a.I(i, j);
    }

    public final void g(int i, float f) throws IOException {
        s5 s5Var = this.a;
        s5Var.getClass();
        s5Var.G(i, Float.floatToRawIntBits(f));
    }

    public final void h(int i, kv kvVar, Object obj) throws IOException {
        s5 s5Var = this.a;
        s5Var.S(i, 3);
        kvVar.b((A) obj, s5Var.f3248a);
        s5Var.S(i, 4);
    }

    public final void i(int i, int i2) throws IOException {
        this.a.K(i, i2);
    }

    public final void j(int i, long j) throws IOException {
        this.a.V(i, j);
    }

    public final void k(int i, kv kvVar, Object obj) throws IOException {
        this.a.M(i, (A) obj, kvVar);
    }

    public final void l(int i, Object obj) throws IOException {
        boolean z = obj instanceof x3;
        s5 s5Var = this.a;
        if (z) {
            s5Var.P(i, (x3) obj);
        } else {
            s5Var.O(i, (A) obj);
        }
    }

    public final void m(int i, int i2) throws IOException {
        this.a.G(i, i2);
    }

    public final void n(int i, long j) throws IOException {
        this.a.I(i, j);
    }

    public final void o(int i, int i2) throws IOException {
        this.a.T(i, (i2 >> 31) ^ (i2 << 1));
    }

    public final void p(int i, long j) throws IOException {
        this.a.V(i, (j >> 63) ^ (j << 1));
    }

    public final void q(int i, int i2) throws IOException {
        this.a.T(i, i2);
    }

    public final void r(int i, long j) throws IOException {
        this.a.V(i, j);
    }
}
