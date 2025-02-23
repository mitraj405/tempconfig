package defpackage;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;

/* renamed from: gp  reason: default package and case insensitive filesystem */
/* compiled from: PathKeyframeAnimation */
public final class C0206gp extends Ch<PointF> {
    public final PathMeasure a = new PathMeasure();

    /* renamed from: a  reason: collision with other field name */
    public final PointF f2971a = new PointF();

    /* renamed from: a  reason: collision with other field name */
    public fp f2972a;

    /* renamed from: a  reason: collision with other field name */
    public final float[] f2973a = new float[2];

    public C0206gp(List<? extends Bh<PointF>> list) {
        super(list);
    }

    public final Object g(Bh bh, float f) {
        fp fpVar = (fp) bh;
        Path path = fpVar.f2943a;
        if (path == null) {
            return (PointF) bh.f65a;
        }
        C0344tk tkVar = this.f3287a;
        if (tkVar != null) {
            PointF pointF = (PointF) tkVar.b(fpVar.a, fpVar.f64a.floatValue(), (PointF) fpVar.f65a, (PointF) fpVar.f69b, e(), f, this.a);
            if (pointF != null) {
                return pointF;
            }
        }
        fp fpVar2 = this.f2972a;
        PathMeasure pathMeasure = this.a;
        if (fpVar2 != fpVar) {
            pathMeasure.setPath(path, false);
            this.f2972a = fpVar;
        }
        float[] fArr = this.f2973a;
        pathMeasure.getPosTan(pathMeasure.getLength() * f, fArr, (float[]) null);
        PointF pointF2 = this.f2971a;
        pointF2.set(fArr[0], fArr[1]);
        return pointF2;
    }
}
