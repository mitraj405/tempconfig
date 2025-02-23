package defpackage;

/* renamed from: cy  reason: default package */
/* compiled from: StopLogic */
public final class cy extends Wl {
    public Gx a;

    /* renamed from: a  reason: collision with other field name */
    public ay f2861a;

    /* renamed from: a  reason: collision with other field name */
    public final dy f2862a;

    public cy() {
        dy dyVar = new dy();
        this.f2862a = dyVar;
        this.f2861a = dyVar;
    }

    public final float a() {
        return this.f2861a.b();
    }

    public final void b(float f, float f2, float f3, float f4, float f5, float f6) {
        boolean z;
        dy dyVar = this.f2862a;
        this.f2861a = dyVar;
        dyVar.j = f;
        if (f > f2) {
            z = true;
        } else {
            z = false;
        }
        dyVar.f2878a = z;
        if (z) {
            dyVar.d(-f3, f - f2, f5, f6, f4);
            return;
        }
        dyVar.d(f3, f2 - f, f5, f6, f4);
    }

    public final float getInterpolation(float f) {
        return this.f2861a.getInterpolation(f);
    }
}
