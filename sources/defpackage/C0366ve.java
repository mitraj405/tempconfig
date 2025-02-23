package defpackage;

import java.util.ArrayList;

/* renamed from: ve  reason: default package and case insensitive filesystem */
/* compiled from: GradientColorInflaterCompat */
public final class C0366ve {
    public final float[] a;

    /* renamed from: a  reason: collision with other field name */
    public final int[] f3372a;

    public C0366ve(ArrayList arrayList, ArrayList arrayList2) {
        int size = arrayList.size();
        this.f3372a = new int[size];
        this.a = new float[size];
        for (int i = 0; i < size; i++) {
            this.f3372a[i] = ((Integer) arrayList.get(i)).intValue();
            this.a[i] = ((Float) arrayList2.get(i)).floatValue();
        }
    }

    public C0366ve(int i, int i2) {
        this.f3372a = new int[]{i, i2};
        this.a = new float[]{0.0f, 1.0f};
    }

    public C0366ve(int i, int i2, int i3) {
        this.f3372a = new int[]{i, i2, i3};
        this.a = new float[]{0.0f, 0.5f, 1.0f};
    }
}
