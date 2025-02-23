package defpackage;

import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;

/* renamed from: bq  reason: default package and case insensitive filesystem */
/* compiled from: PreferenceDataStoreFactory.kt */
public final class C0150bq implements DataStore<Preferences> {
    public final DataStore<Preferences> a;

    @C1128g8(c = "androidx.datastore.preferences.core.PreferenceDataStore$updateData$2", f = "PreferenceDataStoreFactory.kt", l = {85}, m = "invokeSuspend")
    /* renamed from: bq$a */
    /* compiled from: PreferenceDataStoreFactory.kt */
    public static final class a extends Py implements Function2<Preferences, Continuation<? super Preferences>, Object> {
        public /* synthetic */ Object a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ Function2<Preferences, Continuation<? super Preferences>, Object> f2742a;
        public int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Function2<? super Preferences, ? super Continuation<? super Preferences>, ? extends Object> function2, Continuation<? super a> continuation) {
            super(2, continuation);
            this.f2742a = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            a aVar = new a(this.f2742a, continuation);
            aVar.a = obj;
            return aVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((a) create((Preferences) obj, (Continuation) obj2)).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            C1438v7 v7Var = C1438v7.COROUTINE_SUSPENDED;
            int i = this.c;
            if (i == 0) {
                r1.R(obj);
                this.c = 1;
                obj = this.f2742a.invoke((Preferences) this.a, this);
                if (obj == v7Var) {
                    return v7Var;
                }
            } else if (i == 1) {
                r1.R(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Preferences preferences = (Preferences) obj;
            ((MutablePreferences) preferences).f1892a.set(true);
            return preferences;
        }
    }

    public C0150bq(Ww ww) {
        this.a = ww;
    }

    public final Object a(Function2<? super Preferences, ? super Continuation<? super Preferences>, ? extends Object> function2, Continuation<? super Preferences> continuation) {
        return this.a.a(new a(function2, (Continuation<? super a>) null), continuation);
    }

    public final Flow<Preferences> b() {
        return this.a.b();
    }
}
