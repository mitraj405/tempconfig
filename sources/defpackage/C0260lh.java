package defpackage;

import android.content.Context;
import android.util.AttributeSet;
import java.util.HashMap;
import java.util.HashSet;

/* renamed from: lh  reason: default package and case insensitive filesystem */
/* compiled from: Key */
public abstract class C0260lh {
    public int a = -1;

    /* renamed from: a  reason: collision with other field name */
    public String f3092a = null;

    /* renamed from: a  reason: collision with other field name */
    public HashMap<String, O6> f3093a;
    public int b = -1;

    public static float g(Number number) {
        if (number instanceof Float) {
            return ((Float) number).floatValue();
        }
        return Float.parseFloat(number.toString());
    }

    public abstract void a(HashMap<String, MC> hashMap);

    /* renamed from: b */
    public abstract C0260lh clone();

    public C0260lh c(C0260lh lhVar) {
        this.a = lhVar.a;
        this.b = lhVar.b;
        this.f3092a = lhVar.f3092a;
        this.f3093a = lhVar.f3093a;
        return this;
    }

    public abstract void d(HashSet<String> hashSet);

    public abstract void e(Context context, AttributeSet attributeSet);

    public void f(HashMap<String, Integer> hashMap) {
    }
}
