package defpackage;

import androidx.datastore.preferences.core.MutablePreferences;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* renamed from: x5  reason: default package and case insensitive filesystem */
/* compiled from: _Collections.kt */
public class C1472x5 extends C1452w5 {
    public static final ArrayList X(Iterable iterable) {
        ArrayList arrayList = new ArrayList();
        for (Object next : iterable) {
            if (next != null) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static final void Y(Iterable iterable, StringBuilder sb, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1) {
        C1177ig.f(iterable, "<this>");
        C1177ig.f(charSequence, "separator");
        C1177ig.f(charSequence2, "prefix");
        C1177ig.f(charSequence3, "postfix");
        C1177ig.f(charSequence4, "truncated");
        sb.append(charSequence2);
        int i2 = 0;
        for (Object next : iterable) {
            i2++;
            boolean z = true;
            if (i2 > 1) {
                sb.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            } else if (function1 != null) {
                sb.append((CharSequence) function1.invoke(next));
            } else {
                if (next != null) {
                    z = next instanceof CharSequence;
                }
                if (z) {
                    sb.append((CharSequence) next);
                } else if (next instanceof Character) {
                    sb.append(((Character) next).charValue());
                } else {
                    sb.append(String.valueOf(next));
                }
            }
        }
        if (i >= 0 && i2 > i) {
            sb.append(charSequence4);
        }
        sb.append(charSequence3);
    }

    public static String Z(Iterable iterable, String str, String str2, String str3, MutablePreferences.a aVar, int i) {
        String str4;
        String str5;
        int i2;
        CharSequence charSequence;
        MutablePreferences.a aVar2;
        if ((i & 1) != 0) {
            str = ", ";
        }
        String str6 = str;
        if ((i & 2) != 0) {
            str4 = "";
        } else {
            str4 = str2;
        }
        if ((i & 4) != 0) {
            str5 = "";
        } else {
            str5 = str3;
        }
        if ((i & 8) != 0) {
            i2 = -1;
        } else {
            i2 = 0;
        }
        int i3 = i2;
        if ((i & 16) != 0) {
            charSequence = "...";
        } else {
            charSequence = null;
        }
        if ((i & 32) != 0) {
            aVar2 = null;
        } else {
            aVar2 = aVar;
        }
        C1177ig.f(iterable, "<this>");
        C1177ig.f(str4, "prefix");
        C1177ig.f(str5, "postfix");
        C1177ig.f(charSequence, "truncated");
        StringBuilder sb = new StringBuilder();
        Y(iterable, sb, str6, str4, str5, i3, charSequence, aVar2);
        String sb2 = sb.toString();
        C1177ig.e(sb2, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb2;
    }

    public static final void a0(Iterable iterable, AbstractCollection abstractCollection) {
        C1177ig.f(iterable, "<this>");
        for (Object add : iterable) {
            abstractCollection.add(add);
        }
    }

    public static final <T> List<T> b0(Iterable<? extends T> iterable) {
        ArrayList arrayList;
        Object obj;
        C1177ig.f(iterable, "<this>");
        boolean z = iterable instanceof Collection;
        C1477xa xaVar = C1477xa.a;
        if (z) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                return xaVar;
            }
            if (size != 1) {
                return new ArrayList(collection);
            }
            if (iterable instanceof List) {
                obj = ((List) iterable).get(0);
            } else {
                obj = iterable.iterator().next();
            }
            return r1.E(obj);
        }
        if (z) {
            arrayList = new ArrayList((Collection) iterable);
        } else {
            arrayList = new ArrayList();
            a0(iterable, arrayList);
        }
        int size2 = arrayList.size();
        if (size2 == 0) {
            return xaVar;
        }
        if (size2 != 1) {
            return arrayList;
        }
        return r1.E(arrayList.get(0));
    }

    public static final <T> Set<T> c0(Iterable<? extends T> iterable) {
        Object obj;
        C1177ig.f(iterable, "<this>");
        boolean z = iterable instanceof Collection;
        C1513za zaVar = C1513za.a;
        if (z) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                return zaVar;
            }
            if (size != 1) {
                LinkedHashSet linkedHashSet = new LinkedHashSet(r1.H(collection.size()));
                a0(iterable, linkedHashSet);
                return linkedHashSet;
            }
            if (iterable instanceof List) {
                obj = ((List) iterable).get(0);
            } else {
                obj = iterable.iterator().next();
            }
            Set<T> singleton = Collections.singleton(obj);
            C1177ig.e(singleton, "singleton(element)");
            return singleton;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        a0(iterable, linkedHashSet2);
        int size2 = linkedHashSet2.size();
        if (size2 == 0) {
            return zaVar;
        }
        if (size2 != 1) {
            return linkedHashSet2;
        }
        Set<T> singleton2 = Collections.singleton(linkedHashSet2.iterator().next());
        C1177ig.e(singleton2, "singleton(element)");
        return singleton2;
    }
}
