package com.google.firebase.messaging.ktx;

import com.google.firebase.ktx.Firebase;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: Messaging.kt */
public final class MessagingKt {
    public static final FirebaseMessaging getMessaging(Firebase firebase) {
        C1177ig.f(firebase, "<this>");
        FirebaseMessaging instance = FirebaseMessaging.getInstance();
        C1177ig.e(instance, "getInstance()");
        return instance;
    }

    public static final RemoteMessage remoteMessage(String str, Function1<? super RemoteMessage.Builder, Unit> function1) {
        C1177ig.f(str, "to");
        C1177ig.f(function1, "init");
        RemoteMessage.Builder builder = new RemoteMessage.Builder(str);
        function1.invoke(builder);
        RemoteMessage build = builder.build();
        C1177ig.e(build, "builder.build()");
        return build;
    }
}
