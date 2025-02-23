package defpackage;

import android.graphics.Color;
import defpackage.C0335t2;

/* renamed from: D9  reason: default package */
/* compiled from: DropShadowKeyframeAnimation */
public final class D9 implements C0335t2.a {
    public final Ch a;

    /* renamed from: a  reason: collision with other field name */
    public final C0093Gc f116a;

    /* renamed from: a  reason: collision with other field name */
    public final C0335t2.a f117a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f118a = true;
    public final C0093Gc b;
    public final C0093Gc c;
    public final C0093Gc d;

    /* renamed from: D9$a */
    /* compiled from: DropShadowKeyframeAnimation */
    public class a extends C0344tk {
        public final /* synthetic */ C0344tk a;

        public a(C0344tk tkVar) {
            this.a = tkVar;
        }

        public final Object a(Fj fj) {
            Float f = (Float) this.a.a(fj);
            if (f == null) {
                return null;
            }
            return Float.valueOf(f.floatValue() * 2.55f);
        }
    }

    public D9(C0335t2.a aVar, C0359v2 v2Var, B9 b9) {
        this.f117a = aVar;
        C0335t2 b2 = b9.a.b();
        this.a = (Ch) b2;
        b2.a(this);
        v2Var.g(b2);
        C0335t2<Float, Float> b3 = b9.f44a.b();
        this.f116a = (C0093Gc) b3;
        b3.a(this);
        v2Var.g(b3);
        C0335t2<Float, Float> b4 = b9.b.b();
        this.b = (C0093Gc) b4;
        b4.a(this);
        v2Var.g(b4);
        C0335t2<Float, Float> b5 = b9.c.b();
        this.c = (C0093Gc) b5;
        b5.a(this);
        v2Var.g(b5);
        C0335t2<Float, Float> b6 = b9.d.b();
        this.d = (C0093Gc) b6;
        b6.a(this);
        v2Var.g(b6);
    }

    public final void a(Lh lh) {
        if (this.f118a) {
            this.f118a = false;
            double floatValue = ((double) ((Float) this.b.f()).floatValue()) * 0.017453292519943295d;
            float floatValue2 = ((Float) this.c.f()).floatValue();
            float sin = ((float) Math.sin(floatValue)) * floatValue2;
            float cos = ((float) Math.cos(floatValue + 3.141592653589793d)) * floatValue2;
            int intValue = ((Integer) this.a.f()).intValue();
            lh.setShadowLayer(((Float) this.d.f()).floatValue(), sin, cos, Color.argb(Math.round(((Float) this.f116a.f()).floatValue()), Color.red(intValue), Color.green(intValue), Color.blue(intValue)));
        }
    }

    public final void b(C0344tk tkVar) {
        C0093Gc gc = this.f116a;
        if (tkVar == null) {
            gc.k((C0344tk) null);
        } else {
            gc.k(new a(tkVar));
        }
    }

    public final void f() {
        this.f118a = true;
        this.f117a.f();
    }
}
