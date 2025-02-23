package com.google.firebase.sessions;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: InstallationId.kt */
public final class InstallationId {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "InstallationId";
    private final String authToken;
    private final String fid;

    /* compiled from: InstallationId.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0040  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x007c A[Catch:{ Exception -> 0x0085 }, RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object create(com.google.firebase.installations.FirebaseInstallationsApi r8, kotlin.coroutines.Continuation<? super com.google.firebase.sessions.InstallationId> r9) {
            /*
                r7 = this;
                boolean r0 = r9 instanceof com.google.firebase.sessions.InstallationId$Companion$create$1
                if (r0 == 0) goto L_0x0013
                r0 = r9
                com.google.firebase.sessions.InstallationId$Companion$create$1 r0 = (com.google.firebase.sessions.InstallationId$Companion$create$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.label = r1
                goto L_0x0018
            L_0x0013:
                com.google.firebase.sessions.InstallationId$Companion$create$1 r0 = new com.google.firebase.sessions.InstallationId$Companion$create$1
                r0.<init>(r7, r9)
            L_0x0018:
                java.lang.Object r9 = r0.result
                v7 r1 = defpackage.C1438v7.COROUTINE_SUSPENDED
                int r2 = r0.label
                java.lang.String r3 = ""
                r4 = 2
                r5 = 1
                if (r2 == 0) goto L_0x0040
                if (r2 == r5) goto L_0x0038
                if (r2 != r4) goto L_0x0030
                java.lang.Object r8 = r0.L$0
                java.lang.String r8 = (java.lang.String) r8
                defpackage.r1.R(r9)     // Catch:{ Exception -> 0x0085 }
                goto L_0x007d
            L_0x0030:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L_0x0038:
                java.lang.Object r8 = r0.L$0
                com.google.firebase.installations.FirebaseInstallationsApi r8 = (com.google.firebase.installations.FirebaseInstallationsApi) r8
                defpackage.r1.R(r9)     // Catch:{ Exception -> 0x0067 }
                goto L_0x0058
            L_0x0040:
                defpackage.r1.R(r9)
                r9 = 0
                com.google.android.gms.tasks.Task r9 = r8.getToken(r9)     // Catch:{ Exception -> 0x0067 }
                java.lang.String r2 = "firebaseInstallations.getToken(false)"
                defpackage.C1177ig.e(r9, r2)     // Catch:{ Exception -> 0x0067 }
                r0.L$0 = r8     // Catch:{ Exception -> 0x0067 }
                r0.label = r5     // Catch:{ Exception -> 0x0067 }
                java.lang.Object r9 = defpackage.C1506yz.a(r9, r0)     // Catch:{ Exception -> 0x0067 }
                if (r9 != r1) goto L_0x0058
                return r1
            L_0x0058:
                com.google.firebase.installations.InstallationTokenResult r9 = (com.google.firebase.installations.InstallationTokenResult) r9     // Catch:{ Exception -> 0x0067 }
                java.lang.String r9 = r9.getToken()     // Catch:{ Exception -> 0x0067 }
                java.lang.String r2 = "{\n          firebaseInst…).await().token\n        }"
                defpackage.C1177ig.e(r9, r2)     // Catch:{ Exception -> 0x0067 }
                r6 = r9
                r9 = r8
                r8 = r6
                goto L_0x0069
            L_0x0067:
                r9 = r8
                r8 = r3
            L_0x0069:
                com.google.android.gms.tasks.Task r9 = r9.getId()     // Catch:{ Exception -> 0x0085 }
                java.lang.String r2 = "firebaseInstallations.id"
                defpackage.C1177ig.e(r9, r2)     // Catch:{ Exception -> 0x0085 }
                r0.L$0 = r8     // Catch:{ Exception -> 0x0085 }
                r0.label = r4     // Catch:{ Exception -> 0x0085 }
                java.lang.Object r9 = defpackage.C1506yz.a(r9, r0)     // Catch:{ Exception -> 0x0085 }
                if (r9 != r1) goto L_0x007d
                return r1
            L_0x007d:
                java.lang.String r0 = "{\n          firebaseInst…ions.id.await()\n        }"
                defpackage.C1177ig.e(r9, r0)     // Catch:{ Exception -> 0x0085 }
                java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x0085 }
                r3 = r9
            L_0x0085:
                com.google.firebase.sessions.InstallationId r9 = new com.google.firebase.sessions.InstallationId
                r0 = 0
                r9.<init>(r3, r8, r0)
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.InstallationId.Companion.create(com.google.firebase.installations.FirebaseInstallationsApi, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    public /* synthetic */ InstallationId(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    public final String getAuthToken() {
        return this.authToken;
    }

    public final String getFid() {
        return this.fid;
    }

    private InstallationId(String str, String str2) {
        this.fid = str;
        this.authToken = str2;
    }
}
