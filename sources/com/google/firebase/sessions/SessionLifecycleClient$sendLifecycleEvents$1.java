package com.google.firebase.sessions;

import android.os.Message;
import com.google.firebase.sessions.api.FirebaseSessionsDependencies;
import com.google.firebase.sessions.api.SessionSubscriber;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@C1128g8(c = "com.google.firebase.sessions.SessionLifecycleClient$sendLifecycleEvents$1", f = "SessionLifecycleClient.kt", l = {151}, m = "invokeSuspend")
/* compiled from: SessionLifecycleClient.kt */
public final class SessionLifecycleClient$sendLifecycleEvents$1 extends Py implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Message> $messages;
    int label;
    final /* synthetic */ SessionLifecycleClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SessionLifecycleClient$sendLifecycleEvents$1(SessionLifecycleClient sessionLifecycleClient, List<Message> list, Continuation<? super SessionLifecycleClient$sendLifecycleEvents$1> continuation) {
        super(2, continuation);
        this.this$0 = sessionLifecycleClient;
        this.$messages = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SessionLifecycleClient$sendLifecycleEvents$1(this.this$0, this.$messages, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        boolean z;
        List<Message> list;
        C1438v7 v7Var = C1438v7.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            r1.R(obj);
            FirebaseSessionsDependencies firebaseSessionsDependencies = FirebaseSessionsDependencies.INSTANCE;
            this.label = 1;
            obj = firebaseSessionsDependencies.getRegisteredSubscribers$com_google_firebase_firebase_sessions(this);
            if (obj == v7Var) {
                return v7Var;
            }
        } else if (i == 1) {
            r1.R(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Map map = (Map) obj;
        if (!map.isEmpty()) {
            Iterable values = map.values();
            if (!(values instanceof Collection) || !((Collection) values).isEmpty()) {
                Iterator it = values.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((SessionSubscriber) it.next()).isDataCollectionEnabled()) {
                            z = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            z = true;
            if (!z) {
                ArrayList X = C1472x5.X(new ArrayList(new C0525H1(new Message[]{this.this$0.getLatestByCode(this.$messages, 2), this.this$0.getLatestByCode(this.$messages, 1)}, true)));
                SessionLifecycleClient$sendLifecycleEvents$1$invokeSuspend$$inlined$sortedBy$1 sessionLifecycleClient$sendLifecycleEvents$1$invokeSuspend$$inlined$sortedBy$1 = new SessionLifecycleClient$sendLifecycleEvents$1$invokeSuspend$$inlined$sortedBy$1();
                if (X.size() <= 1) {
                    list = C1472x5.b0(X);
                } else {
                    Object[] array = X.toArray(new Object[0]);
                    C1177ig.f(array, "<this>");
                    if (array.length > 1) {
                        Arrays.sort(array, sessionLifecycleClient$sendLifecycleEvents$1$invokeSuspend$$inlined$sortedBy$1);
                    }
                    list = Arrays.asList(array);
                    C1177ig.e(list, "asList(this)");
                }
                SessionLifecycleClient sessionLifecycleClient = this.this$0;
                for (Message access$sendMessageToServer : list) {
                    sessionLifecycleClient.sendMessageToServer(access$sendMessageToServer);
                }
            }
        }
        return Unit.a;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SessionLifecycleClient$sendLifecycleEvents$1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }
}
