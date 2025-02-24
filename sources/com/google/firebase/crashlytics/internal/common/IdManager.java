package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.InstallIdProvider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import java.util.regex.Pattern;

public class IdManager implements InstallIdProvider {
    public static final String DEFAULT_VERSION_NAME = "0.0";
    private static final String FORWARD_SLASH_REGEX = Pattern.quote(RemoteSettings.FORWARD_SLASH_STRING);
    private static final Pattern ID_PATTERN = Pattern.compile("[^\\p{Alnum}]");
    static final String PREFKEY_ADVERTISING_ID = "crashlytics.advertising.id";
    static final String PREFKEY_FIREBASE_IID = "firebase.installation.id";
    static final String PREFKEY_INSTALLATION_UUID = "crashlytics.installation.id";
    static final String PREFKEY_LEGACY_INSTALLATION_UUID = "crashlytics.installation.id";
    private static final String SYNTHETIC_FID_PREFIX = "SYN_";
    private final Context appContext;
    private final String appIdentifier;
    private final DataCollectionArbiter dataCollectionArbiter;
    private final FirebaseInstallationsApi firebaseInstallations;
    private InstallIdProvider.InstallIds installIds;
    private final InstallerPackageNameProvider installerPackageNameProvider;

    public IdManager(Context context, String str, FirebaseInstallationsApi firebaseInstallationsApi, DataCollectionArbiter dataCollectionArbiter2) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        } else if (str != null) {
            this.appContext = context;
            this.appIdentifier = str;
            this.firebaseInstallations = firebaseInstallationsApi;
            this.dataCollectionArbiter = dataCollectionArbiter2;
            this.installerPackageNameProvider = new InstallerPackageNameProvider();
        } else {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
    }

    private synchronized String createAndCacheCrashlyticsInstallId(String str, SharedPreferences sharedPreferences) {
        String formatId;
        formatId = formatId(UUID.randomUUID().toString());
        Logger logger = Logger.getLogger();
        logger.v("Created new Crashlytics installation ID: " + formatId + " for FID: " + str);
        sharedPreferences.edit().putString("crashlytics.installation.id", formatId).putString(PREFKEY_FIREBASE_IID, str).apply();
        return formatId;
    }

    public static String createSyntheticFid() {
        return SYNTHETIC_FID_PREFIX + UUID.randomUUID().toString();
    }

    private static String formatId(String str) {
        return ID_PATTERN.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    public static boolean isSyntheticFid(String str) {
        if (str == null || !str.startsWith(SYNTHETIC_FID_PREFIX)) {
            return false;
        }
        return true;
    }

    private String readCachedCrashlyticsInstallId(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString("crashlytics.installation.id", (String) null);
    }

    private String removeForwardSlashesIn(String str) {
        return str.replaceAll(FORWARD_SLASH_REGEX, "");
    }

    private boolean shouldRefresh() {
        InstallIdProvider.InstallIds installIds2 = this.installIds;
        if (installIds2 == null || (installIds2.getFirebaseInstallationId() == null && this.dataCollectionArbiter.isAutomaticDataCollectionEnabled())) {
            return true;
        }
        return false;
    }

    public FirebaseInstallationId fetchTrueFid(boolean z) {
        String str;
        String str2 = null;
        if (z) {
            try {
                str = ((InstallationTokenResult) Utils.awaitEvenIfOnMainThread(this.firebaseInstallations.getToken(false))).getToken();
            } catch (Exception e) {
                Logger.getLogger().w("Error getting Firebase authentication token.", e);
            }
            str2 = (String) Utils.awaitEvenIfOnMainThread(this.firebaseInstallations.getId());
            return new FirebaseInstallationId(str2, str);
        }
        str = null;
        try {
            str2 = (String) Utils.awaitEvenIfOnMainThread(this.firebaseInstallations.getId());
        } catch (Exception e2) {
            Logger.getLogger().w("Error getting Firebase installation id.", e2);
        }
        return new FirebaseInstallationId(str2, str);
    }

    public String getAppIdentifier() {
        return this.appIdentifier;
    }

    public synchronized InstallIdProvider.InstallIds getInstallIds() {
        String str;
        if (!shouldRefresh()) {
            return this.installIds;
        }
        Logger.getLogger().v("Determining Crashlytics installation ID...");
        SharedPreferences sharedPrefs = CommonUtils.getSharedPrefs(this.appContext);
        String string = sharedPrefs.getString(PREFKEY_FIREBASE_IID, (String) null);
        Logger logger = Logger.getLogger();
        logger.v("Cached Firebase Installation ID: " + string);
        if (this.dataCollectionArbiter.isAutomaticDataCollectionEnabled()) {
            FirebaseInstallationId fetchTrueFid = fetchTrueFid(false);
            Logger logger2 = Logger.getLogger();
            logger2.v("Fetched Firebase Installation ID: " + fetchTrueFid.getFid());
            if (fetchTrueFid.getFid() == null) {
                if (string == null) {
                    str = createSyntheticFid();
                } else {
                    str = string;
                }
                fetchTrueFid = new FirebaseInstallationId(str, (String) null);
            }
            if (Objects.equals(fetchTrueFid.getFid(), string)) {
                this.installIds = InstallIdProvider.InstallIds.create(readCachedCrashlyticsInstallId(sharedPrefs), fetchTrueFid);
            } else {
                this.installIds = InstallIdProvider.InstallIds.create(createAndCacheCrashlyticsInstallId(fetchTrueFid.getFid(), sharedPrefs), fetchTrueFid);
            }
        } else if (isSyntheticFid(string)) {
            this.installIds = InstallIdProvider.InstallIds.createWithoutFid(readCachedCrashlyticsInstallId(sharedPrefs));
        } else {
            this.installIds = InstallIdProvider.InstallIds.createWithoutFid(createAndCacheCrashlyticsInstallId(createSyntheticFid(), sharedPrefs));
        }
        Logger logger3 = Logger.getLogger();
        logger3.v("Install IDs: " + this.installIds);
        return this.installIds;
    }

    public String getInstallerPackageName() {
        return this.installerPackageNameProvider.getInstallerPackageName(this.appContext);
    }

    public String getModelName() {
        return String.format(Locale.US, "%s/%s", new Object[]{removeForwardSlashesIn(Build.MANUFACTURER), removeForwardSlashesIn(Build.MODEL)});
    }

    public String getOsBuildVersionString() {
        return removeForwardSlashesIn(Build.VERSION.INCREMENTAL);
    }

    public String getOsDisplayVersionString() {
        return removeForwardSlashesIn(Build.VERSION.RELEASE);
    }
}
