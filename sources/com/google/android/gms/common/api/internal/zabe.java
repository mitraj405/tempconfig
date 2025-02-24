package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.service.Common;
import com.google.android.gms.common.internal.zaj;
import com.google.android.gms.common.internal.zak;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zae;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
public final class zabe extends GoogleApiClient implements zabz {
    @VisibleForTesting
    final Queue<BaseImplementation.ApiMethodImpl<?, ?>> zaa = new LinkedList();
    @VisibleForTesting
    zabx zab;
    final Map<Api.AnyClientKey<?>, Api.Client> zac;
    Set<Scope> zad;
    final ClientSettings zae;
    final Map<Api<?>, Boolean> zaf;
    final Api.AbstractClientBuilder<? extends zae, SignInOptions> zag;
    Set<zada> zah;
    final zadc zai;
    private final Lock zaj;
    private final zak zak;
    private zaca zal = null;
    private final int zam;
    /* access modifiers changed from: private */
    public final Context zan;
    private final Looper zao;
    private volatile boolean zap;
    private long zaq;
    private long zar;
    private final zabc zas;
    private final GoogleApiAvailability zat;
    private final ListenerHolders zau;
    private final ArrayList<zat> zav;
    private Integer zaw;
    private final zaj zax;

    public zabe(Context context, Lock lock, Looper looper, ClientSettings clientSettings, GoogleApiAvailability googleApiAvailability, Api.AbstractClientBuilder<? extends zae, SignInOptions> abstractClientBuilder, Map<Api<?>, Boolean> map, List<GoogleApiClient.ConnectionCallbacks> list, List<GoogleApiClient.OnConnectionFailedListener> list2, Map<Api.AnyClientKey<?>, Api.Client> map2, int i, int i2, ArrayList<zat> arrayList) {
        long j;
        Looper looper2 = looper;
        int i3 = i;
        if (true != ClientLibraryUtils.isPackageSide()) {
            j = 120000;
        } else {
            j = 10000;
        }
        this.zaq = j;
        this.zar = 5000;
        this.zad = new HashSet();
        this.zau = new ListenerHolders();
        this.zaw = null;
        this.zah = null;
        zaay zaay = new zaay(this);
        this.zax = zaay;
        this.zan = context;
        this.zaj = lock;
        this.zak = new zak(looper, zaay);
        this.zao = looper2;
        this.zas = new zabc(this, looper);
        this.zat = googleApiAvailability;
        this.zam = i3;
        if (i3 >= 0) {
            this.zaw = Integer.valueOf(i2);
        }
        this.zaf = map;
        this.zac = map2;
        this.zav = arrayList;
        this.zai = new zadc();
        for (GoogleApiClient.ConnectionCallbacks zaf2 : list) {
            this.zak.zaf(zaf2);
        }
        for (GoogleApiClient.OnConnectionFailedListener zag2 : list2) {
            this.zak.zag(zag2);
        }
        this.zae = clientSettings;
        this.zag = abstractClientBuilder;
    }

    public static int zad(Iterable<Api.Client> iterable, boolean z) {
        boolean z2 = false;
        boolean z3 = false;
        for (Api.Client next : iterable) {
            z2 |= next.requiresSignIn();
            z3 |= next.providesSignIn();
        }
        if (!z2) {
            return 3;
        }
        if (!z3 || !z) {
            return 1;
        }
        return 2;
    }

    public static String zag(int i) {
        if (i == 1) {
            return "SIGN_IN_MODE_REQUIRED";
        }
        if (i == 2) {
            return "SIGN_IN_MODE_OPTIONAL";
        }
        if (i != 3) {
            return "UNKNOWN";
        }
        return "SIGN_IN_MODE_NONE";
    }

    public static /* bridge */ /* synthetic */ void zai(zabe zabe) {
        zabe.zaj.lock();
        try {
            if (zabe.zap) {
                zabe.zan();
            }
        } finally {
            zabe.zaj.unlock();
        }
    }

    public static /* bridge */ /* synthetic */ void zaj(zabe zabe) {
        zabe.zaj.lock();
        try {
            if (zabe.zak()) {
                zabe.zan();
            }
        } finally {
            zabe.zaj.unlock();
        }
    }

    private final void zal(int i) {
        Integer num = this.zaw;
        if (num == null) {
            this.zaw = Integer.valueOf(i);
        } else if (num.intValue() != i) {
            String zag2 = zag(i);
            String zag3 = zag(this.zaw.intValue());
            StringBuilder sb = new StringBuilder(zag3.length() + zag2.length() + 51);
            sb.append("Cannot use sign-in mode: ");
            sb.append(zag2);
            sb.append(". Mode was already set to ");
            sb.append(zag3);
            throw new IllegalStateException(sb.toString());
        }
        if (this.zal == null) {
            boolean z = false;
            boolean z2 = false;
            for (Api.Client next : this.zac.values()) {
                z |= next.requiresSignIn();
                z2 |= next.providesSignIn();
            }
            int intValue = this.zaw.intValue();
            if (intValue != 1) {
                if (intValue == 2 && z) {
                    this.zal = zaaa.zag(this.zan, this, this.zaj, this.zao, this.zat, this.zac, this.zae, this.zaf, this.zag, this.zav);
                    return;
                }
            } else if (!z) {
                throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
            } else if (z2) {
                throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            this.zal = new zabi(this.zan, this, this.zaj, this.zao, this.zat, this.zac, this.zae, this.zaf, this.zag, this.zav, this);
        }
    }

    /* access modifiers changed from: private */
    public final void zam(GoogleApiClient googleApiClient, StatusPendingResult statusPendingResult, boolean z) {
        Common.zaa.zaa(googleApiClient).setResultCallback(new zabb(this, statusPendingResult, z, googleApiClient));
    }

    private final void zan() {
        this.zak.zab();
        ((zaca) Preconditions.checkNotNull(this.zal)).zaq();
    }

    public final ConnectionResult blockingConnect() {
        boolean z = true;
        Preconditions.checkState(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.zaj.lock();
        try {
            if (this.zam >= 0) {
                if (this.zaw == null) {
                    z = false;
                }
                Preconditions.checkState(z, "Sign-in mode should have been set explicitly by auto-manage.");
            } else {
                Integer num = this.zaw;
                if (num == null) {
                    this.zaw = Integer.valueOf(zad(this.zac.values(), false));
                } else if (num.intValue() == 2) {
                    throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            }
            zal(((Integer) Preconditions.checkNotNull(this.zaw)).intValue());
            this.zak.zab();
            return ((zaca) Preconditions.checkNotNull(this.zal)).zab();
        } finally {
            this.zaj.unlock();
        }
    }

    public final PendingResult<Status> clearDefaultAccountAndReconnect() {
        Preconditions.checkState(isConnected(), "GoogleApiClient is not connected yet.");
        Integer num = this.zaw;
        boolean z = true;
        if (num != null && num.intValue() == 2) {
            z = false;
        }
        Preconditions.checkState(z, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        StatusPendingResult statusPendingResult = new StatusPendingResult((GoogleApiClient) this);
        if (this.zac.containsKey(Common.CLIENT_KEY)) {
            zam(this, statusPendingResult, false);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            zaaz zaaz = new zaaz(this, atomicReference, statusPendingResult);
            zaba zaba = new zaba(this, statusPendingResult);
            GoogleApiClient.Builder builder = new GoogleApiClient.Builder(this.zan);
            builder.addApi(Common.API);
            builder.addConnectionCallbacks(zaaz);
            builder.addOnConnectionFailedListener(zaba);
            builder.setHandler(this.zas);
            GoogleApiClient build = builder.build();
            atomicReference.set(build);
            build.connect();
        }
        return statusPendingResult;
    }

    public final void connect() {
        this.zaj.lock();
        try {
            int i = 2;
            boolean z = false;
            if (this.zam >= 0) {
                Preconditions.checkState(this.zaw != null, "Sign-in mode should have been set explicitly by auto-manage.");
            } else {
                Integer num = this.zaw;
                if (num == null) {
                    this.zaw = Integer.valueOf(zad(this.zac.values(), false));
                } else if (num.intValue() == 2) {
                    throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            }
            int intValue = ((Integer) Preconditions.checkNotNull(this.zaw)).intValue();
            this.zaj.lock();
            if (intValue == 3 || intValue == 1) {
                i = intValue;
            } else if (intValue != 2) {
                i = intValue;
                StringBuilder sb = new StringBuilder(33);
                sb.append("Illegal sign-in mode: ");
                sb.append(i);
                Preconditions.checkArgument(z, sb.toString());
                zal(i);
                zan();
            }
            z = true;
            StringBuilder sb2 = new StringBuilder(33);
            sb2.append("Illegal sign-in mode: ");
            sb2.append(i);
            Preconditions.checkArgument(z, sb2.toString());
            zal(i);
            zan();
        } catch (Throwable th) {
            throw th;
        } finally {
            this.zaj.unlock();
        }
    }

    public final void disconnect() {
        Lock lock;
        this.zaj.lock();
        try {
            this.zai.zab();
            zaca zaca = this.zal;
            if (zaca != null) {
                zaca.zar();
            }
            this.zau.zab();
            for (BaseImplementation.ApiMethodImpl next : this.zaa) {
                next.zan((zadb) null);
                next.cancel();
            }
            this.zaa.clear();
            if (this.zal == null) {
                lock = this.zaj;
            } else {
                zak();
                this.zak.zaa();
                lock = this.zaj;
            }
            lock.unlock();
        } catch (Throwable th) {
            this.zaj.unlock();
            throw th;
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("mContext=").println(this.zan);
        printWriter.append(str).append("mResuming=").print(this.zap);
        printWriter.append(" mWorkQueue.size()=").print(this.zaa.size());
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.zai.zab.size());
        zaca zaca = this.zal;
        if (zaca != null) {
            zaca.zas(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t) {
        String str;
        Lock lock;
        Api<?> api = t.getApi();
        boolean containsKey = this.zac.containsKey(t.getClientKey());
        if (api != null) {
            str = api.zad();
        } else {
            str = "the API";
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 65);
        sb.append("GoogleApiClient is not configured to use ");
        sb.append(str);
        sb.append(" required for this call.");
        Preconditions.checkArgument(containsKey, sb.toString());
        this.zaj.lock();
        try {
            zaca zaca = this.zal;
            if (zaca == null) {
                this.zaa.add(t);
                lock = this.zaj;
            } else {
                t = zaca.zae(t);
                lock = this.zaj;
            }
            lock.unlock();
            return t;
        } catch (Throwable th) {
            this.zaj.unlock();
            throw th;
        }
    }

    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t) {
        String str;
        Lock lock;
        Api<?> api = t.getApi();
        boolean containsKey = this.zac.containsKey(t.getClientKey());
        if (api != null) {
            str = api.zad();
        } else {
            str = "the API";
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 65);
        sb.append("GoogleApiClient is not configured to use ");
        sb.append(str);
        sb.append(" required for this call.");
        Preconditions.checkArgument(containsKey, sb.toString());
        this.zaj.lock();
        try {
            zaca zaca = this.zal;
            if (zaca != null) {
                if (this.zap) {
                    this.zaa.add(t);
                    while (!this.zaa.isEmpty()) {
                        BaseImplementation.ApiMethodImpl remove = this.zaa.remove();
                        this.zai.zaa(remove);
                        remove.setFailedResult(Status.RESULT_INTERNAL_ERROR);
                    }
                    lock = this.zaj;
                } else {
                    t = zaca.zaf(t);
                    lock = this.zaj;
                }
                lock.unlock();
                return t;
            }
            throw new IllegalStateException("GoogleApiClient is not connected yet.");
        } catch (Throwable th) {
            this.zaj.unlock();
            throw th;
        }
    }

    public final <C extends Api.Client> C getClient(Api.AnyClientKey<C> anyClientKey) {
        C c = (Api.Client) this.zac.get(anyClientKey);
        Preconditions.checkNotNull(c, "Appropriate Api was not requested.");
        return c;
    }

    public final ConnectionResult getConnectionResult(Api<?> api) {
        ConnectionResult connectionResult;
        Lock lock;
        this.zaj.lock();
        try {
            if (!isConnected()) {
                if (!this.zap) {
                    throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
                }
            }
            if (this.zac.containsKey(api.zab())) {
                ConnectionResult zad2 = ((zaca) Preconditions.checkNotNull(this.zal)).zad(api);
                if (zad2 != null) {
                    return zad2;
                }
                if (this.zap) {
                    connectionResult = ConnectionResult.RESULT_SUCCESS;
                    lock = this.zaj;
                } else {
                    zaf();
                    String.valueOf(api.zad()).concat(" requested in getConnectionResult is not connected but is not present in the failed  connections map");
                    new Exception();
                    connectionResult = new ConnectionResult(8, (PendingIntent) null);
                    lock = this.zaj;
                }
                lock.unlock();
                return connectionResult;
            }
            throw new IllegalArgumentException(String.valueOf(api.zad()).concat(" was never registered with GoogleApiClient"));
        } finally {
            this.zaj.unlock();
        }
    }

    public final Context getContext() {
        return this.zan;
    }

    public final Looper getLooper() {
        return this.zao;
    }

    public final boolean hasApi(Api<?> api) {
        return this.zac.containsKey(api.zab());
    }

    public final boolean hasConnectedApi(Api<?> api) {
        Api.Client client;
        if (isConnected() && (client = this.zac.get(api.zab())) != null && client.isConnected()) {
            return true;
        }
        return false;
    }

    public final boolean isConnected() {
        zaca zaca = this.zal;
        if (zaca == null || !zaca.zaw()) {
            return false;
        }
        return true;
    }

    public final boolean isConnecting() {
        zaca zaca = this.zal;
        if (zaca == null || !zaca.zax()) {
            return false;
        }
        return true;
    }

    public final boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        return this.zak.zaj(connectionCallbacks);
    }

    public final boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return this.zak.zak(onConnectionFailedListener);
    }

    public final boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        zaca zaca = this.zal;
        if (zaca == null || !zaca.zay(signInConnectionListener)) {
            return false;
        }
        return true;
    }

    public final void maybeSignOut() {
        zaca zaca = this.zal;
        if (zaca != null) {
            zaca.zau();
        }
    }

    public final void reconnect() {
        disconnect();
        connect();
    }

    public final void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.zak.zaf(connectionCallbacks);
    }

    public final void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zak.zag(onConnectionFailedListener);
    }

    public final <L> ListenerHolder<L> registerListener(L l) {
        this.zaj.lock();
        try {
            return this.zau.zaa(l, this.zao, "NO_TYPE");
        } finally {
            this.zaj.unlock();
        }
    }

    public final void stopAutoManage(FragmentActivity fragmentActivity) {
        LifecycleActivity lifecycleActivity = new LifecycleActivity((Activity) fragmentActivity);
        if (this.zam >= 0) {
            zak.zaa(lifecycleActivity).zae(this.zam);
            return;
        }
        throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
    }

    public final void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.zak.zah(connectionCallbacks);
    }

    public final void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zak.zai(onConnectionFailedListener);
    }

    public final void zaa(ConnectionResult connectionResult) {
        if (!this.zat.isPlayServicesPossiblyUpdating(this.zan, connectionResult.getErrorCode())) {
            zak();
        }
        if (!this.zap) {
            this.zak.zac(connectionResult);
            this.zak.zaa();
        }
    }

    public final void zab(Bundle bundle) {
        while (!this.zaa.isEmpty()) {
            execute(this.zaa.remove());
        }
        this.zak.zad(bundle);
    }

    public final void zac(int i, boolean z) {
        if (i == 1) {
            if (!z && !this.zap) {
                this.zap = true;
                if (this.zab == null && !ClientLibraryUtils.isPackageSide()) {
                    try {
                        this.zab = this.zat.zac(this.zan.getApplicationContext(), new zabd(this));
                    } catch (SecurityException unused) {
                    }
                }
                zabc zabc = this.zas;
                zabc.sendMessageDelayed(zabc.obtainMessage(1), this.zaq);
                zabc zabc2 = this.zas;
                zabc2.sendMessageDelayed(zabc2.obtainMessage(2), this.zar);
            }
            i = 1;
        }
        for (BasePendingResult forceFailureUnlessReady : (BasePendingResult[]) this.zai.zab.toArray(new BasePendingResult[0])) {
            forceFailureUnlessReady.forceFailureUnlessReady(zadc.zaa);
        }
        this.zak.zae(i);
        this.zak.zaa();
        if (i == 2) {
            zan();
        }
    }

    public final String zaf() {
        StringWriter stringWriter = new StringWriter();
        dump("", (FileDescriptor) null, new PrintWriter(stringWriter), (String[]) null);
        return stringWriter.toString();
    }

    public final boolean zak() {
        if (!this.zap) {
            return false;
        }
        this.zap = false;
        this.zas.removeMessages(2);
        this.zas.removeMessages(1);
        zabx zabx = this.zab;
        if (zabx != null) {
            zabx.zab();
            this.zab = null;
        }
        return true;
    }

    public final void zao(zada zada) {
        this.zaj.lock();
        try {
            if (this.zah == null) {
                this.zah = new HashSet();
            }
            this.zah.add(zada);
        } finally {
            this.zaj.unlock();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0035, code lost:
        if (r2 == false) goto L_0x0037;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zap(com.google.android.gms.common.api.internal.zada r2) {
        /*
            r1 = this;
            java.util.concurrent.locks.Lock r0 = r1.zaj
            r0.lock()
            java.util.Set<com.google.android.gms.common.api.internal.zada> r0 = r1.zah     // Catch:{ all -> 0x004b }
            if (r0 != 0) goto L_0x000f
            java.lang.Exception r2 = new java.lang.Exception     // Catch:{ all -> 0x004b }
            r2.<init>()     // Catch:{ all -> 0x004b }
            goto L_0x003e
        L_0x000f:
            boolean r2 = r0.remove(r2)     // Catch:{ all -> 0x004b }
            if (r2 != 0) goto L_0x001b
            java.lang.Exception r2 = new java.lang.Exception     // Catch:{ all -> 0x004b }
            r2.<init>()     // Catch:{ all -> 0x004b }
            goto L_0x003e
        L_0x001b:
            java.util.concurrent.locks.Lock r2 = r1.zaj     // Catch:{ all -> 0x004b }
            r2.lock()     // Catch:{ all -> 0x004b }
            java.util.Set<com.google.android.gms.common.api.internal.zada> r2 = r1.zah     // Catch:{ all -> 0x0044 }
            if (r2 != 0) goto L_0x002a
            java.util.concurrent.locks.Lock r2 = r1.zaj     // Catch:{ all -> 0x004b }
            r2.unlock()     // Catch:{ all -> 0x004b }
            goto L_0x0037
        L_0x002a:
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x0044 }
            r2 = r2 ^ 1
            java.util.concurrent.locks.Lock r0 = r1.zaj     // Catch:{ all -> 0x004b }
            r0.unlock()     // Catch:{ all -> 0x004b }
            if (r2 != 0) goto L_0x003e
        L_0x0037:
            com.google.android.gms.common.api.internal.zaca r2 = r1.zal     // Catch:{ all -> 0x004b }
            if (r2 == 0) goto L_0x003e
            r2.zat()     // Catch:{ all -> 0x004b }
        L_0x003e:
            java.util.concurrent.locks.Lock r2 = r1.zaj
            r2.unlock()
            return
        L_0x0044:
            r2 = move-exception
            java.util.concurrent.locks.Lock r0 = r1.zaj     // Catch:{ all -> 0x004b }
            r0.unlock()     // Catch:{ all -> 0x004b }
            throw r2     // Catch:{ all -> 0x004b }
        L_0x004b:
            r2 = move-exception
            java.util.concurrent.locks.Lock r0 = r1.zaj
            r0.unlock()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zabe.zap(com.google.android.gms.common.api.internal.zada):void");
    }

    public final ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        Preconditions.checkState(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        Preconditions.checkNotNull(timeUnit, "TimeUnit must not be null");
        this.zaj.lock();
        try {
            Integer num = this.zaw;
            if (num == null) {
                this.zaw = Integer.valueOf(zad(this.zac.values(), false));
            } else if (num.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            zal(((Integer) Preconditions.checkNotNull(this.zaw)).intValue());
            this.zak.zab();
            return ((zaca) Preconditions.checkNotNull(this.zal)).zac(j, timeUnit);
        } finally {
            this.zaj.unlock();
        }
    }

    public final void connect(int i) {
        this.zaj.lock();
        boolean z = true;
        if (!(i == 3 || i == 1)) {
            if (i == 2) {
                i = 2;
            } else {
                z = false;
            }
        }
        try {
            StringBuilder sb = new StringBuilder(33);
            sb.append("Illegal sign-in mode: ");
            sb.append(i);
            Preconditions.checkArgument(z, sb.toString());
            zal(i);
            zan();
        } finally {
            this.zaj.unlock();
        }
    }
}
