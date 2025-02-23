package in.juspay.hypersdk.analytics;

import android.support.v4.media.session.PlaybackStateCompat;
import in.juspay.hypersdk.services.SdkConfigService;
import org.json.JSONArray;
import org.json.JSONObject;

public class LogConstants {
    public static final String CRASH_LOGS_FILE = "juspay-crash-logFile.dat";
    public static final String DEFAULT_CHANNEL = "default";
    public static final String LOGS_FILE = "juspay-pre-logs-queue-";
    public static final String LOGS_FILE_EXTENSION = ".dat";
    public static final String LOGS_READING_FILE = "LOGS_READING_FILE";
    public static final String LOGS_WRITING_FILE = "LOGS_WRITING_FILE";
    public static final String LOG_CHANNEL_INFO = "LOG_CHANNEL_INFO";
    public static final String LOG_CHANNEL_NAMES = "LOG_CHANNEL_NAMES";
    public static final String LOG_DELIMITER = "LOG_DELIMITER";
    public static final String PERSISTENT_LOGS_FILE = "juspay-logs-queue-";
    public static final String PERSISTENT_LOGS_FILE_EXTENSION = ".dat";
    public static final String PERSISTENT_LOGS_READING_FILE = "PERSISTENT_LOGS_READING_FILE";
    public static final String PERSISTENT_LOGS_WRITING_FILE = "PERSISTENT_LOGS_WRITING_FILE";
    public static final String TEMP_LOGS_FILE = "temp-logs-queue-";
    public static final String TEMP_LOGS_FILE_EXTENSION = ".dat";
    public static final String TEMP_LOGS_READING_FILE = "TEMP_LOGS_READING_FILE";
    public static final String TEMP_LOGS_WRITING_FILE = "TEMP_LOGS_WRITING_FILE";
    static JSONArray allowWhileBuffering = null;
    static JSONObject channels = null;
    static JSONArray defaultChannels = null;
    static int defaultPriority = 5;
    static long dontPushIfFileIsLastModifiedBeforeInHours = 720;
    static String encryptionLevel = "encryption";
    public static String errorUrl = null;
    public static JSONArray fallBackPublicKeys = null;
    public static JSONArray fallBackUrl = null;
    public static String fileFormat = null;
    static long filesCountLimit = 200;
    static long folderSizeLimit = 52428800;
    static JSONArray logChannelsConfig = null;
    static JSONObject logHeaders = null;
    static int logPostInterval = 2000;
    public static JSONObject logProperties = null;
    static int logSessioniseInterval = 2000;
    static int maxFilesAllowed = 7;
    static long maxLogFileSize = 20971520;
    static long maxLogLineSize = 20971520;
    static long maxLogValueSize = 32768;
    static long maxLogsPerPush = 75;
    static int maxRetryPerBatch = -1;
    static long maxSizeLimitPerPush = 204800;
    static long minMemoryRequired = 16384;
    static int numFilesToLeaveIfMaxFilesExceeded = 5;
    static String prodLogUrl;
    static JSONObject publicKey;
    static JSONObject publicKeySandbox;
    static String sandboxLogUrl;
    public static boolean shouldPush;

    static {
        publicKeySandbox = new JSONObject();
        publicKey = new JSONObject();
        channels = new JSONObject();
        logChannelsConfig = new JSONArray();
        defaultChannels = new JSONArray();
        sandboxLogUrl = "https://debug.logs.juspay.net/godel/analytics";
        prodLogUrl = "https://logs.juspay.in/godel/analytics";
        shouldPush = true;
        fileFormat = "prefixByte";
        fallBackUrl = new JSONArray();
        fallBackPublicKeys = new JSONArray();
        errorUrl = "";
        logHeaders = new JSONObject();
        logProperties = new JSONObject();
        allowWhileBuffering = new JSONArray();
        JSONObject cachedSdkConfig = SdkConfigService.getCachedSdkConfig();
        if (cachedSdkConfig != null) {
            try {
                JSONObject jSONObject = cachedSdkConfig.getJSONObject("logsConfig");
                String str = "prefixByte";
                maxLogLineSize = jSONObject.optLong("maxLogLineSize", 20971520);
                maxLogFileSize = jSONObject.optLong("maxLogFileSize", 20971520);
                minMemoryRequired = jSONObject.optLong("minMemoryRequired", PlaybackStateCompat.ACTION_PREPARE);
                maxFilesAllowed = jSONObject.optInt("maxFilesAllowed", 7);
                maxLogValueSize = jSONObject.optLong("maxLogValueSize", PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID);
                folderSizeLimit = jSONObject.optLong("folderSizeLimit", 52428800);
                filesCountLimit = jSONObject.optLong("filesCountLimit", 200);
                maxSizeLimitPerPush = jSONObject.optLong("maxSizeLimitPerPush", 204800);
                encryptionLevel = jSONObject.optString("encryptionLevelKey", "encryption");
                publicKeySandbox = jSONObject.optJSONObject("publicKeySandbox");
                publicKey = jSONObject.optJSONObject("publicKey");
                channels = jSONObject.optJSONObject("channels");
                defaultChannels = jSONObject.optJSONArray("defaultChannels");
                numFilesToLeaveIfMaxFilesExceeded = jSONObject.optInt("numFilesToLeaveIfMaxFilesExceeded", 5);
                String str2 = "";
                dontPushIfFileIsLastModifiedBeforeInHours = jSONObject.optLong("dontPushIfFileIsLastModifiedBeforeInHours", 720);
                shouldPush = jSONObject.optBoolean("shouldPush", true);
                sandboxLogUrl = jSONObject.optString("logsUrlKeySandbox", "https://debug.logs.juspay.net/godel/analytics");
                prodLogUrl = jSONObject.optString("logsUrlKey", "https://logs.juspay.in/godel/analytics");
                defaultPriority = jSONObject.optInt("defaultPriority", 5);
                maxRetryPerBatch = jSONObject.optInt("retryAttempts", -1);
                maxLogsPerPush = jSONObject.optLong("batchCount", 75);
                logPostInterval = jSONObject.optInt("logPusherTimerWithChannel", 2000);
                logSessioniseInterval = jSONObject.optInt("sessioniseTimer", 2000);
                logChannelsConfig = cachedSdkConfig.optJSONArray("logChannelsConfig");
                if (jSONObject.has("logHeaders")) {
                    logHeaders = jSONObject.getJSONObject("logHeaders");
                }
                if (jSONObject.has("logProperties")) {
                    logProperties = jSONObject.getJSONObject("logProperties");
                }
                if (jSONObject.has("allowWhileBuffering")) {
                    allowWhileBuffering = jSONObject.getJSONArray("allowWhileBuffering");
                }
                if (jSONObject.has("fileFormat")) {
                    fileFormat = jSONObject.optString("fileFormat", str);
                }
                if (jSONObject.has("fallBackUrl")) {
                    fallBackUrl = jSONObject.optJSONArray("fallBackUrl");
                }
                if (jSONObject.has("fallBackPublicKeys")) {
                    fallBackPublicKeys = jSONObject.optJSONArray("fallBackPublicKeys");
                }
                if (jSONObject.has("errorUrl")) {
                    errorUrl = jSONObject.optString("errorUrl", str2);
                }
            } catch (Exception unused) {
            }
        }
    }
}
