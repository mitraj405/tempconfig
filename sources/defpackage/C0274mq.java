package defpackage;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.protobuf.n;
import androidx.datastore.preferences.protobuf.p;
import androidx.datastore.preferences.protobuf.q;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import defpackage.C0262lq;
import defpackage.Ww;
import defpackage.jq;
import defpackage.kq;
import defpackage.s5;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import kotlin.Unit;

/* renamed from: mq  reason: default package and case insensitive filesystem */
/* compiled from: PreferencesSerializer.kt */
public final class C0274mq implements hw<Preferences> {
    public static final C0274mq a = new C0274mq();

    /* renamed from: mq$a */
    /* compiled from: PreferencesSerializer.kt */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[lf._values().length];
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[6] = 3;
            iArr[2] = 4;
            iArr[3] = 5;
            iArr[4] = 6;
            iArr[5] = 7;
            iArr[7] = 8;
            a = iArr;
        }
    }

    public final MutablePreferences a(FileInputStream fileInputStream) throws IOException, CorruptionException {
        int i;
        try {
            jq r = jq.r(fileInputStream);
            MutablePreferences mutablePreferences = new MutablePreferences(false, 1);
            Preferences.a[] aVarArr = (Preferences.a[]) Arrays.copyOf(new Preferences.a[0], 0);
            C1177ig.f(aVarArr, "pairs");
            mutablePreferences.c();
            if (aVarArr.length <= 0) {
                Map<String, C0262lq> p = r.p();
                C1177ig.e(p, "preferencesProto.preferencesMap");
                for (Map.Entry next : p.entrySet()) {
                    String str = (String) next.getKey();
                    C0262lq lqVar = (C0262lq) next.getValue();
                    C1177ig.e(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
                    C1177ig.e(lqVar, "value");
                    int D = lqVar.D();
                    if (D == 0) {
                        i = -1;
                    } else {
                        i = a.a[xx.V(D)];
                    }
                    switch (i) {
                        case -1:
                            throw new CorruptionException("Value case is null.");
                        case 1:
                            mutablePreferences.d(new Preferences.Key(str), Boolean.valueOf(lqVar.v()));
                            break;
                        case 2:
                            mutablePreferences.d(new Preferences.Key(str), Float.valueOf(lqVar.y()));
                            break;
                        case 3:
                            mutablePreferences.d(new Preferences.Key(str), Double.valueOf(lqVar.x()));
                            break;
                        case 4:
                            mutablePreferences.d(new Preferences.Key(str), Integer.valueOf(lqVar.z()));
                            break;
                        case 5:
                            mutablePreferences.d(new Preferences.Key(str), Long.valueOf(lqVar.A()));
                            break;
                        case 6:
                            Preferences.Key key = new Preferences.Key(str);
                            String B = lqVar.B();
                            C1177ig.e(B, "value.string");
                            mutablePreferences.d(key, B);
                            break;
                        case 7:
                            Preferences.Key key2 = new Preferences.Key(str);
                            p.c q = lqVar.C().q();
                            C1177ig.e(q, "value.stringSet.stringsList");
                            mutablePreferences.d(key2, C1472x5.c0(q));
                            break;
                        case 8:
                            throw new CorruptionException("Value not set.");
                        default:
                            throw new V5();
                    }
                }
                return new MutablePreferences((Map<Preferences.Key<?>, Object>) new LinkedHashMap(mutablePreferences.a()), true);
            }
            aVarArr[0].getClass();
            mutablePreferences.d((Preferences.Key<?>) null, (Object) null);
            throw null;
        } catch (q e) {
            throw new CorruptionException(e);
        }
    }

    public final Unit b(Object obj, Ww.b bVar) {
        n nVar;
        Map<Preferences.Key<?>, Object> a2 = ((Preferences) obj).a();
        jq.a q = jq.q();
        for (Map.Entry next : a2.entrySet()) {
            Object value = next.getValue();
            String str = ((Preferences.Key) next.getKey()).a;
            if (value instanceof Boolean) {
                C0262lq.a E = C0262lq.E();
                boolean booleanValue = ((Boolean) value).booleanValue();
                E.h();
                C0262lq.s((C0262lq) E.b, booleanValue);
                nVar = E.f();
            } else if (value instanceof Float) {
                C0262lq.a E2 = C0262lq.E();
                float floatValue = ((Number) value).floatValue();
                E2.h();
                C0262lq.t((C0262lq) E2.b, floatValue);
                nVar = E2.f();
            } else if (value instanceof Double) {
                C0262lq.a E3 = C0262lq.E();
                double doubleValue = ((Number) value).doubleValue();
                E3.h();
                C0262lq.q((C0262lq) E3.b, doubleValue);
                nVar = E3.f();
            } else if (value instanceof Integer) {
                C0262lq.a E4 = C0262lq.E();
                int intValue = ((Number) value).intValue();
                E4.h();
                C0262lq.u((C0262lq) E4.b, intValue);
                nVar = E4.f();
            } else if (value instanceof Long) {
                C0262lq.a E5 = C0262lq.E();
                long longValue = ((Number) value).longValue();
                E5.h();
                C0262lq.n((C0262lq) E5.b, longValue);
                nVar = E5.f();
            } else if (value instanceof String) {
                C0262lq.a E6 = C0262lq.E();
                E6.h();
                C0262lq.o((C0262lq) E6.b, (String) value);
                nVar = E6.f();
            } else if (value instanceof Set) {
                C0262lq.a E7 = C0262lq.E();
                kq.a r = kq.r();
                r.h();
                kq.o((kq) r.b, (Set) value);
                E7.h();
                C0262lq.p((C0262lq) E7.b, r);
                nVar = E7.f();
            } else {
                throw new IllegalStateException(C1177ig.j(value.getClass().getName(), "PreferencesSerializer does not support type: "));
            }
            q.getClass();
            str.getClass();
            q.h();
            jq.o((jq) q.b).put(str, (C0262lq) nVar);
        }
        jq jqVar = (jq) q.f();
        int serializedSize = jqVar.getSerializedSize();
        Logger logger = s5.a;
        if (serializedSize > 4096) {
            serializedSize = 4096;
        }
        s5.d dVar = new s5.d(bVar, serializedSize);
        jqVar.e(dVar);
        if (dVar.b > 0) {
            dVar.c0();
        }
        return Unit.a;
    }

    public final MutablePreferences c() {
        return new MutablePreferences(true, 1);
    }
}
