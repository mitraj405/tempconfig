package defpackage;

import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

@C1128g8(c = "androidx.datastore.preferences.core.PreferencesKt$edit$2", f = "Preferences.kt", l = {329}, m = "invokeSuspend")
/* renamed from: iq  reason: default package */
/* compiled from: Preferences.kt */
public final class iq extends Py implements Function2<Preferences, Continuation<? super Preferences>, Object> {
    public /* synthetic */ Object a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Function2<MutablePreferences, Continuation<? super Unit>, Object> f3020a;
    public int c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public iq(Function2<? super MutablePreferences, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super iq> continuation) {
        super(2, continuation);
        this.f3020a = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        iq iqVar = new iq(this.f3020a, continuation);
        iqVar.a = obj;
        return iqVar;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((iq) create((Preferences) obj, (Continuation) obj2)).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        C1438v7 v7Var = C1438v7.COROUTINE_SUSPENDED;
        int i = this.c;
        if (i == 0) {
            r1.R(obj);
            Map<Preferences.Key<?>, Object> a2 = ((Preferences) this.a).a();
            C1177ig.f(a2, "<this>");
            MutablePreferences mutablePreferences = new MutablePreferences((Map<Preferences.Key<?>, Object>) new LinkedHashMap(a2), false);
            this.a = mutablePreferences;
            this.c = 1;
            if (this.f3020a.invoke(mutablePreferences, this) == v7Var) {
                return v7Var;
            }
            return mutablePreferences;
        } else if (i == 1) {
            MutablePreferences mutablePreferences2 = (MutablePreferences) this.a;
            r1.R(obj);
            return mutablePreferences2;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
