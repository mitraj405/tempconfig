package com.google.firebase.sessions.settings;

import com.google.common.net.HttpHeaders;
import com.google.firebase.perf.FirebasePerformance;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

@C1128g8(c = "com.google.firebase.sessions.settings.RemoteSettingsFetcher$doConfigFetch$2", f = "RemoteSettingsFetcher.kt", l = {68, 70, 73}, m = "invokeSuspend")
/* compiled from: RemoteSettingsFetcher.kt */
public final class RemoteSettingsFetcher$doConfigFetch$2 extends Py implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, String> $headerOptions;
    final /* synthetic */ Function2<String, Continuation<? super Unit>, Object> $onFailure;
    final /* synthetic */ Function2<JSONObject, Continuation<? super Unit>, Object> $onSuccess;
    int label;
    final /* synthetic */ RemoteSettingsFetcher this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RemoteSettingsFetcher$doConfigFetch$2(RemoteSettingsFetcher remoteSettingsFetcher, Map<String, String> map, Function2<? super JSONObject, ? super Continuation<? super Unit>, ? extends Object> function2, Function2<? super String, ? super Continuation<? super Unit>, ? extends Object> function22, Continuation<? super RemoteSettingsFetcher$doConfigFetch$2> continuation) {
        super(2, continuation);
        this.this$0 = remoteSettingsFetcher;
        this.$headerOptions = map;
        this.$onSuccess = function2;
        this.$onFailure = function22;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RemoteSettingsFetcher$doConfigFetch$2(this.this$0, this.$headerOptions, this.$onSuccess, this.$onFailure, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        C1438v7 v7Var = C1438v7.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            r1.R(obj);
            URLConnection openConnection = this.this$0.settingsUrl().openConnection();
            C1177ig.d(openConnection, "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) openConnection;
            httpsURLConnection.setRequestMethod(FirebasePerformance.HttpMethod.GET);
            httpsURLConnection.setRequestProperty(HttpHeaders.ACCEPT, "application/json");
            for (Map.Entry next : this.$headerOptions.entrySet()) {
                httpsURLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
            }
            int responseCode = httpsURLConnection.getResponseCode();
            if (responseCode == 200) {
                InputStream inputStream = httpsURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder sb = new StringBuilder();
                C0571Ks ks = new C0571Ks();
                while (true) {
                    T readLine = bufferedReader.readLine();
                    ks.a = readLine;
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
                bufferedReader.close();
                inputStream.close();
                JSONObject jSONObject = new JSONObject(sb.toString());
                Function2<JSONObject, Continuation<? super Unit>, Object> function2 = this.$onSuccess;
                this.label = 1;
                if (function2.invoke(jSONObject, this) == v7Var) {
                    return v7Var;
                }
            } else {
                Function2<String, Continuation<? super Unit>, Object> function22 = this.$onFailure;
                String str = "Bad response code: " + responseCode;
                this.label = 2;
                if (function22.invoke(str, this) == v7Var) {
                    return v7Var;
                }
            }
        } else if (i == 1 || i == 2) {
            try {
                r1.R(obj);
            } catch (Exception e) {
                Function2<String, Continuation<? super Unit>, Object> function23 = this.$onFailure;
                String message = e.getMessage();
                if (message == null) {
                    message = e.toString();
                }
                this.label = 3;
                if (function23.invoke(message, this) == v7Var) {
                    return v7Var;
                }
            }
        } else if (i == 3) {
            r1.R(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.a;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RemoteSettingsFetcher$doConfigFetch$2) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }
}
