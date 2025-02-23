package defpackage;

import android.graphics.PointF;
import java.util.List;

/* renamed from: we  reason: default package */
/* compiled from: GradientColorKeyframeAnimation */
public final class we extends Ch {
    public final /* synthetic */ int a;
    public final Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public we(List list, int i) {
        super(list);
        this.a = i;
        if (i != 1) {
            int i2 = 0;
            ue ueVar = (ue) ((Bh) list.get(0)).f65a;
            i2 = ueVar != null ? ueVar.f3317a.length : i2;
            this.b = new ue(new int[i2], new float[i2]);
            return;
        }
        super(list);
        this.b = new bv();
    }

    public final Object g(Bh bh, float f) {
        T t;
        T t2 = bh.f65a;
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                ue ueVar = (ue) obj;
                ue ueVar2 = (ue) t2;
                ue ueVar3 = (ue) bh.f69b;
                ueVar.getClass();
                int[] iArr = ueVar2.f3317a;
                int length = iArr.length;
                int[] iArr2 = ueVar3.f3317a;
                if (length == iArr2.length) {
                    for (int i2 = 0; i2 < iArr.length; i2++) {
                        float f2 = ueVar2.a[i2];
                        float f3 = ueVar3.a[i2];
                        PointF pointF = C0308ql.a;
                        ueVar.a[i2] = lf.a(f3, f2, f, f2);
                        ueVar.f3317a[i2] = r1.p(f, iArr[i2], iArr2[i2]);
                    }
                    return ueVar;
                }
                StringBuilder sb = new StringBuilder("Cannot interpolate between gradients. Lengths vary (");
                sb.append(iArr.length);
                sb.append(" vs ");
                throw new IllegalArgumentException(lf.k(sb, iArr2.length, ")"));
            default:
                if (t2 == null || (t = bh.f69b) == null) {
                    throw new IllegalStateException("Missing values for keyframe.");
                }
                bv bvVar = (bv) t2;
                bv bvVar2 = (bv) t;
                C0344tk tkVar = this.f3287a;
                if (tkVar != null) {
                    bv bvVar3 = (bv) tkVar.b(bh.a, bh.f64a.floatValue(), bvVar, bvVar2, f, e(), this.a);
                    if (bvVar3 != null) {
                        return bvVar3;
                    }
                }
                bv bvVar4 = (bv) obj;
                float f4 = bvVar.a;
                float f5 = bvVar2.a;
                PointF pointF2 = C0308ql.a;
                float a2 = lf.a(f5, f4, f, f4);
                float f6 = bvVar.b;
                float a3 = lf.a(bvVar2.b, f6, f, f6);
                bvVar4.a = a2;
                bvVar4.b = a3;
                return bvVar4;
        }
    }
}
