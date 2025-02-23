package com.google.firebase.sessions.settings;

import kotlin.coroutines.Continuation;

@C1128g8(c = "com.google.firebase.sessions.settings.SettingsCache", f = "SettingsCache.kt", l = {103}, m = "removeConfigs$com_google_firebase_firebase_sessions")
/* compiled from: SettingsCache.kt */
public final class SettingsCache$removeConfigs$1 extends C1148h7 {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SettingsCache this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SettingsCache$removeConfigs$1(SettingsCache settingsCache, Continuation<? super SettingsCache$removeConfigs$1> continuation) {
        super(continuation);
        this.this$0 = settingsCache;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.removeConfigs$com_google_firebase_firebase_sessions(this);
    }
}
