package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* renamed from: p5  reason: default package and case insensitive filesystem */
/* compiled from: ClassReference.kt */
public final class C1318p5 implements C1198jh<Object>, C1274n5 {
    public static final LinkedHashMap a;

    /* renamed from: a  reason: collision with other field name */
    public static final Map<Class<? extends C0782ae<?>>, Integer> f6886a;

    /* renamed from: a  reason: collision with other field name */
    public final Class<?> f6887a;

    static {
        int i = 0;
        Iterable F = r1.F(Function0.class, Function1.class, Function2.class, C0694Td.class, C0706Ud.class, C0722Vd.class, C0736Wd.class, C0747Xd.class, C0756Yd.class, C0767Zd.class, C0517Gd.class, C0528Hd.class, C0540Id.class, C0553Jd.class, C0566Kd.class, C0579Ld.class, C0592Md.class, C0608Nd.class, C0623Od.class, C0637Pd.class, C0651Qd.class, C0666Rd.class, C0681Sd.class);
        ArrayList arrayList = new ArrayList(C1418u5.W(F));
        for (Object next : F) {
            int i2 = i + 1;
            if (i >= 0) {
                arrayList.add(new Pair((Class) next, Integer.valueOf(i)));
                i = i2;
            } else {
                throw new ArithmeticException("Index overflow has happened.");
            }
        }
        f6886a = C1328pk.W(arrayList);
        HashMap hashMap = new HashMap();
        hashMap.put("boolean", "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put("int", "kotlin.Int");
        hashMap.put("float", "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        HashMap hashMap3 = new HashMap();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(hashMap);
        hashMap3.putAll(hashMap2);
        Collection<String> values = hashMap.values();
        C1177ig.e(values, "primitiveFqNames.values");
        for (String str : values) {
            StringBuilder sb = new StringBuilder("kotlin.jvm.internal.");
            C1177ig.e(str, "kotlinName");
            sb.append(C1337py.b1(str, str));
            sb.append("CompanionObject");
            hashMap3.put(sb.toString(), str.concat(".Companion"));
        }
        for (Map.Entry next2 : f6886a.entrySet()) {
            int intValue = ((Number) next2.getValue()).intValue();
            String name = ((Class) next2.getKey()).getName();
            hashMap3.put(name, "kotlin.Function" + intValue);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(r1.H(hashMap3.size()));
        for (Map.Entry entry : hashMap3.entrySet()) {
            Object key = entry.getKey();
            String str2 = (String) entry.getValue();
            linkedHashMap.put(key, C1337py.b1(str2, str2));
        }
        a = linkedHashMap;
    }

    public C1318p5(Class<?> cls) {
        C1177ig.f(cls, "jClass");
        this.f6887a = cls;
    }

    public final Class<?> a() {
        return this.f6887a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C1318p5) || !C1177ig.a(C1354qp.Q(this), C1354qp.Q((C1198jh) obj))) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return C1354qp.Q(this).hashCode();
    }

    public final String toString() {
        return this.f6887a.toString() + " (Kotlin reflection is not available)";
    }
}
