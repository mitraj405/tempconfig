package com.google.android.gms.signin.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.signin.zae;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
public class SignInClientImpl extends GmsClient<zaf> implements zae {
    public static final /* synthetic */ int zaa = 0;
    private final boolean zab = true;
    private final ClientSettings zac;
    private final Bundle zad;
    private final Integer zae;

    public SignInClientImpl(Context context, Looper looper, boolean z, ClientSettings clientSettings, Bundle bundle, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 44, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zac = clientSettings;
        this.zad = bundle;
        this.zae = clientSettings.zab();
    }

    @KeepForSdk
    public static Bundle createBundleFromClientSettings(ClientSettings clientSettings) {
        clientSettings.zaa();
        Integer zab2 = clientSettings.zab();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", clientSettings.getAccount());
        if (zab2 != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", zab2.intValue());
        }
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", (String) null);
        bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
        bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
        bundle.putString("com.google.android.gms.signin.internal.hostedDomain", (String) null);
        bundle.putString("com.google.android.gms.signin.internal.logSessionId", (String) null);
        bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
        return bundle;
    }

    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        if (queryLocalInterface instanceof zaf) {
            return (zaf) queryLocalInterface;
        }
        return new zaf(iBinder);
    }

    public final Bundle getGetServiceRequestExtraArgs() {
        if (!getContext().getPackageName().equals(this.zac.getRealClientPackageName())) {
            this.zad.putString("com.google.android.gms.signin.internal.realClientPackageName", this.zac.getRealClientPackageName());
        }
        return this.zad;
    }

    public final int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    public final String getServiceDescriptor() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    public final String getStartServiceAction() {
        return "com.google.android.gms.signin.service.START";
    }

    public final boolean requiresSignIn() {
        return this.zab;
    }

    public final void zaa() {
        try {
            ((zaf) getService()).zae(((Integer) Preconditions.checkNotNull(this.zae)).intValue());
        } catch (RemoteException unused) {
        }
    }

    public final void zab() {
        connect(new BaseGmsClient.LegacyClientCallbackAdapter());
    }

    public final void zac(IAccountAccessor iAccountAccessor, boolean z) {
        try {
            ((zaf) getService()).zaf(iAccountAccessor, ((Integer) Preconditions.checkNotNull(this.zae)).intValue(), z);
        } catch (RemoteException unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r7.zab(new com.google.android.gms.signin.internal.zak(1, new com.google.android.gms.common.ConnectionResult(8, (android.app.PendingIntent) null), (com.google.android.gms.common.internal.zav) null));
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0045 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zad(com.google.android.gms.signin.internal.zae r7) {
        /*
            r6 = this;
            java.lang.String r0 = "Expecting a valid ISignInCallbacks"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7, r0)
            r0 = 1
            r1 = 0
            com.google.android.gms.common.internal.ClientSettings r2 = r6.zac     // Catch:{ RemoteException -> 0x0045 }
            android.accounts.Account r2 = r2.getAccountOrDefault()     // Catch:{ RemoteException -> 0x0045 }
            java.lang.String r3 = "<<default account>>"
            java.lang.String r4 = r2.name     // Catch:{ RemoteException -> 0x0045 }
            boolean r3 = r3.equals(r4)     // Catch:{ RemoteException -> 0x0045 }
            if (r3 == 0) goto L_0x0024
            android.content.Context r3 = r6.getContext()     // Catch:{ RemoteException -> 0x0045 }
            com.google.android.gms.auth.api.signin.internal.Storage r3 = com.google.android.gms.auth.api.signin.internal.Storage.getInstance(r3)     // Catch:{ RemoteException -> 0x0045 }
            com.google.android.gms.auth.api.signin.GoogleSignInAccount r3 = r3.getSavedDefaultGoogleSignInAccount()     // Catch:{ RemoteException -> 0x0045 }
            goto L_0x0025
        L_0x0024:
            r3 = r1
        L_0x0025:
            com.google.android.gms.common.internal.zat r4 = new com.google.android.gms.common.internal.zat     // Catch:{ RemoteException -> 0x0045 }
            java.lang.Integer r5 = r6.zae     // Catch:{ RemoteException -> 0x0045 }
            java.lang.Object r5 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)     // Catch:{ RemoteException -> 0x0045 }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ RemoteException -> 0x0045 }
            int r5 = r5.intValue()     // Catch:{ RemoteException -> 0x0045 }
            r4.<init>(r2, r5, r3)     // Catch:{ RemoteException -> 0x0045 }
            android.os.IInterface r2 = r6.getService()     // Catch:{ RemoteException -> 0x0045 }
            com.google.android.gms.signin.internal.zaf r2 = (com.google.android.gms.signin.internal.zaf) r2     // Catch:{ RemoteException -> 0x0045 }
            com.google.android.gms.signin.internal.zai r3 = new com.google.android.gms.signin.internal.zai     // Catch:{ RemoteException -> 0x0045 }
            r3.<init>(r0, r4)     // Catch:{ RemoteException -> 0x0045 }
            r2.zag(r3, r7)     // Catch:{ RemoteException -> 0x0045 }
            return
        L_0x0045:
            com.google.android.gms.signin.internal.zak r2 = new com.google.android.gms.signin.internal.zak     // Catch:{ RemoteException -> 0x0054 }
            com.google.android.gms.common.ConnectionResult r3 = new com.google.android.gms.common.ConnectionResult     // Catch:{ RemoteException -> 0x0054 }
            r4 = 8
            r3.<init>(r4, r1)     // Catch:{ RemoteException -> 0x0054 }
            r2.<init>(r0, r3, r1)     // Catch:{ RemoteException -> 0x0054 }
            r7.zab(r2)     // Catch:{ RemoteException -> 0x0054 }
        L_0x0054:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.signin.internal.SignInClientImpl.zad(com.google.android.gms.signin.internal.zae):void");
    }
}
