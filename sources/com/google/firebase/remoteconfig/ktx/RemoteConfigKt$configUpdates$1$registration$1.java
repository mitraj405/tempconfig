package com.google.firebase.remoteconfig.ktx;

import com.google.firebase.remoteconfig.ConfigUpdate;
import com.google.firebase.remoteconfig.ConfigUpdateListener;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.d;

/* compiled from: RemoteConfig.kt */
public final class RemoteConfigKt$configUpdates$1$registration$1 implements ConfigUpdateListener {
    final /* synthetic */ ProducerScope<ConfigUpdate> $$this$callbackFlow;
    final /* synthetic */ FirebaseRemoteConfig $this_configUpdates;

    public RemoteConfigKt$configUpdates$1$registration$1(FirebaseRemoteConfig firebaseRemoteConfig, ProducerScope<? super ConfigUpdate> producerScope) {
        this.$this_configUpdates = firebaseRemoteConfig;
        this.$$this$callbackFlow = producerScope;
    }

    /* access modifiers changed from: private */
    public static final void onUpdate$lambda$0(ProducerScope producerScope, ConfigUpdate configUpdate) {
        C1177ig.f(producerScope, "$$this$callbackFlow");
        C1177ig.f(configUpdate, "$configUpdate");
        C1354qp.K0(producerScope, configUpdate);
    }

    public void onError(FirebaseRemoteConfigException firebaseRemoteConfigException) {
        C1177ig.f(firebaseRemoteConfigException, "error");
        d.b(this.$$this$callbackFlow, firebaseRemoteConfigException);
    }

    public void onUpdate(ConfigUpdate configUpdate) {
        C1177ig.f(configUpdate, "configUpdate");
        this.$this_configUpdates.schedule(new C0428zq(6, this.$$this$callbackFlow, configUpdate));
    }
}
