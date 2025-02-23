package defpackage;

/* renamed from: q9  reason: default package */
/* compiled from: DocumentData */
public final class q9 {
    public float a;

    /* renamed from: a  reason: collision with other field name */
    public int f3178a;

    /* renamed from: a  reason: collision with other field name */
    public String f3179a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f3180a;
    public float b;

    /* renamed from: b  reason: collision with other field name */
    public int f3181b;

    /* renamed from: b  reason: collision with other field name */
    public String f3182b;
    public float c;

    /* renamed from: c  reason: collision with other field name */
    public int f3183c;
    public float d;

    /* renamed from: d  reason: collision with other field name */
    public int f3184d;

    public q9(String str, String str2, float f, int i, int i2, float f2, float f3, int i3, int i4, float f4, boolean z) {
        this.f3179a = str;
        this.f3182b = str2;
        this.a = f;
        this.f3178a = i;
        this.f3181b = i2;
        this.b = f2;
        this.c = f3;
        this.f3183c = i3;
        this.f3184d = i4;
        this.d = f4;
        this.f3180a = z;
    }

    public final int hashCode() {
        String str = this.f3182b;
        int V = ((xx.V(this.f3178a) + (((int) (((float) lf.g(str, this.f3179a.hashCode() * 31, 31)) + this.a)) * 31)) * 31) + this.f3181b;
        long floatToRawIntBits = (long) Float.floatToRawIntBits(this.b);
        return (((V * 31) + ((int) (floatToRawIntBits ^ (floatToRawIntBits >>> 32)))) * 31) + this.f3183c;
    }

    public q9() {
    }
}
