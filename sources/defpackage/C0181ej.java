package defpackage;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* renamed from: ej  reason: default package and case insensitive filesystem */
/* compiled from: LottieComposition */
public final class C0181ej {
    public float a;

    /* renamed from: a  reason: collision with other field name */
    public int f2898a = 0;

    /* renamed from: a  reason: collision with other field name */
    public Rect f2899a;

    /* renamed from: a  reason: collision with other field name */
    public LongSparseArray<Sh> f2900a;

    /* renamed from: a  reason: collision with other field name */
    public SparseArrayCompat<C0101Tc> f2901a;

    /* renamed from: a  reason: collision with other field name */
    public final HashSet<String> f2902a = new HashSet<>();

    /* renamed from: a  reason: collision with other field name */
    public List<C0307qk> f2903a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, List<Sh>> f2904a;

    /* renamed from: a  reason: collision with other field name */
    public final C0357up f2905a = new C0357up();

    /* renamed from: a  reason: collision with other field name */
    public boolean f2906a;
    public float b;

    /* renamed from: b  reason: collision with other field name */
    public List<Sh> f2907b;

    /* renamed from: b  reason: collision with other field name */
    public Map<String, Gj> f2908b;
    public float c;

    /* renamed from: c  reason: collision with other field name */
    public Map<String, C0099Qc> f2909c;

    public final void a(String str) {
        Ai.b(str);
        this.f2902a.add(str);
    }

    public final float b() {
        return (float) ((long) (((this.b - this.a) / this.c) * 1000.0f));
    }

    public final C0307qk c(String str) {
        int size = this.f2903a.size();
        for (int i = 0; i < size; i++) {
            C0307qk qkVar = this.f2903a.get(i);
            String str2 = qkVar.f3203a;
            boolean z = true;
            if (!str2.equalsIgnoreCase(str) && (!str2.endsWith("\r") || !str2.substring(0, str2.length() - 1).equalsIgnoreCase(str))) {
                z = false;
            }
            if (z) {
                return qkVar;
            }
        }
        return null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (Sh a2 : this.f2907b) {
            sb.append(a2.a("\t"));
        }
        return sb.toString();
    }
}
