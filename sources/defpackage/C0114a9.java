package defpackage;

import android.content.Context;
import android.view.VelocityTracker;
import androidx.core.widget.NestedScrollView;

/* renamed from: a9  reason: default package and case insensitive filesystem */
/* compiled from: DifferentialMotionFlingController */
public final class C0114a9 {
    public float a;

    /* renamed from: a  reason: collision with other field name */
    public int f789a = -1;

    /* renamed from: a  reason: collision with other field name */
    public final a f790a;

    /* renamed from: a  reason: collision with other field name */
    public final b f791a;

    /* renamed from: a  reason: collision with other field name */
    public final Context f792a;

    /* renamed from: a  reason: collision with other field name */
    public VelocityTracker f793a;

    /* renamed from: a  reason: collision with other field name */
    public final C0142b9 f794a;

    /* renamed from: a  reason: collision with other field name */
    public final int[] f795a = {Integer.MAX_VALUE, 0};
    public int b = -1;
    public int c = -1;

    /* renamed from: a9$a */
    /* compiled from: DifferentialMotionFlingController */
    public interface a {
    }

    /* renamed from: a9$b */
    /* compiled from: DifferentialMotionFlingController */
    public interface b {
    }

    public C0114a9(Context context, NestedScrollView.c cVar) {
        Z8 z8 = new Z8(0);
        C1058d dVar = new C1058d();
        this.f792a = context;
        this.f794a = cVar;
        this.f791a = z8;
        this.f790a = dVar;
    }
}
