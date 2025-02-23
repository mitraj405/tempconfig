package in.juspay.hypersdk.core;

import android.app.ActivityManager;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import androidx.annotation.Keep;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.constants.LogCategory;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hyper.core.JuspayLogger;
import in.juspay.hypersdk.data.PaymentSessionInfo;
import in.juspay.hypersdk.data.SessionInfo;
import in.juspay.hypersdk.safe.JuspayWebView;
import in.juspay.hypersdk.utils.IntegrationUtils;
import in.juspay.hypersdk.utils.Utils;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class PaymentUtils extends Utils {
    private static final String LOG_TAG = "PaymentUtils";

    public static void clearCookies(JuspayServices juspayServices) {
        Context context = juspayServices.getContext();
        SdkTracker sdkTracker = juspayServices.getSdkTracker();
        try {
            CookieSyncManager.createInstance(context).sync();
            CookieManager.getInstance().removeAllCookie();
        } catch (Exception e) {
            sdkTracker.trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.UTIL, "Failed to clear cookies", e);
        }
    }

    public static void deleteRecursive(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles == null) {
                    listFiles = new File[0];
                }
                for (File deleteRecursive : listFiles) {
                    deleteRecursive(deleteRecursive);
                }
            }
            file.delete();
        }
    }

    public static String getConfigVariableDeclarations(Context context, SessionInfo sessionInfo) {
        String deviceId = sessionInfo.getDeviceId();
        String androidId = sessionInfo.getAndroidId();
        if (deviceId == null || deviceId.isEmpty()) {
            deviceId = "";
        }
        return "var clientId = '" + sessionInfo.getClientId() + "';var juspayDeviceId = '" + deviceId + "';var juspayAndroidId = '" + androidId + "';var godelRemotesVersion = '" + PaymentSessionInfo.getGodelRemotesVersion(context) + "';var godelVersion = '" + IntegrationUtils.getGodelVersion(context) + "';var buildVersion = '" + IntegrationUtils.getGodelBuildVersion(context) + "';var os_version = '" + SessionInfo.getOSVersion() + "';";
    }

    public static ConnectivityReceiver getConnectivityReceiver(JuspayServices juspayServices) {
        SdkTracker sdkTracker = juspayServices.getSdkTracker();
        try {
            return new ConnectivityReceiver(juspayServices);
        } catch (Throwable th) {
            sdkTracker.trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.UTIL, "Failed to register Connectivity receiver (Ignoring)", th);
            return null;
        }
    }

    public static boolean hasTelephonyService(JuspayServices juspayServices) {
        Context context = juspayServices.getContext();
        SdkTracker sdkTracker = juspayServices.getSdkTracker();
        try {
            if (((TelephonyManager) context.getSystemService("phone")).getPhoneType() != 0) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            sdkTracker.trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.UTIL, "Exception while trying to get telephony service. Returning false.", th);
            return false;
        }
    }

    public static boolean isClassAvailable(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static void logMemoryInfo(SdkTracker sdkTracker, ActivityManager.MemoryInfo memoryInfo) {
        SdkTracker sdkTracker2 = sdkTracker;
        sdkTracker2.trackContext(LogSubCategory.Context.DEVICE, "info", Labels.Device.MEMORY, "available_memory", Long.valueOf(memoryInfo.availMem));
        sdkTracker2.trackContext(LogSubCategory.Context.DEVICE, "info", Labels.Device.MEMORY, "threshold_memory", Long.valueOf(memoryInfo.threshold));
        sdkTracker2.trackContext(LogSubCategory.Context.DEVICE, "info", Labels.Device.MEMORY, "total_memory", Long.valueOf(memoryInfo.totalMem));
    }

    public static void refreshPage(JuspayWebView juspayWebView) {
        if (juspayWebView != null) {
            juspayWebView.addJsToWebView("window.location.reload(true);");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005a A[Catch:{ Exception -> 0x00a6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void switchOffGodelIfLowOnMemory(in.juspay.hypersdk.safe.Godel r11, in.juspay.hypersdk.core.JuspayServices r12, in.juspay.hypersdk.data.PaymentSessionInfo r13) {
        /*
            java.lang.String r0 = " MB"
            java.lang.String r1 = "low on memory - Available memory : "
            android.content.Context r2 = r12.getContext()     // Catch:{ Exception -> 0x00a6 }
            in.juspay.hypersdk.core.SdkTracker r12 = r12.getSdkTracker()     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r3 = "activity"
            java.lang.Object r2 = r2.getSystemService(r3)     // Catch:{ Exception -> 0x00a6 }
            android.app.ActivityManager r2 = (android.app.ActivityManager) r2     // Catch:{ Exception -> 0x00a6 }
            android.app.ActivityManager$MemoryInfo r10 = new android.app.ActivityManager$MemoryInfo     // Catch:{ Exception -> 0x00a6 }
            r10.<init>()     // Catch:{ Exception -> 0x00a6 }
            r3 = 4
            org.json.JSONObject r11 = r11.getWebLabRules()     // Catch:{ Exception -> 0x0047 }
            if (r11 == 0) goto L_0x0045
            java.lang.String r4 = "shouldUseMemory"
            int r11 = r11.getInt(r4)     // Catch:{ Exception -> 0x0047 }
            java.lang.String r4 = "system"
            java.lang.String r5 = "info"
            java.lang.String r6 = "util"
            java.lang.String r7 = "weblab_shouldUseMemory"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0042 }
            r3.<init>()     // Catch:{ Exception -> 0x0042 }
            r3.append(r11)     // Catch:{ Exception -> 0x0042 }
            r3.append(r0)     // Catch:{ Exception -> 0x0042 }
            java.lang.String r8 = r3.toString()     // Catch:{ Exception -> 0x0042 }
            r3 = r12
            r3.trackAction(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0042 }
            goto L_0x0058
        L_0x0042:
            r3 = move-exception
            r9 = r3
            goto L_0x004a
        L_0x0045:
            r11 = r3
            goto L_0x0058
        L_0x0047:
            r11 = move-exception
            r9 = r11
            r11 = r3
        L_0x004a:
            java.lang.String r4 = LOG_TAG     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r5 = "action"
            java.lang.String r6 = "system"
            java.lang.String r7 = "util"
            java.lang.String r8 = "Exception while fetching shouldUseMemory from config"
            r3 = r12
            r3.trackAndLogException(r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x00a6 }
        L_0x0058:
            if (r2 == 0) goto L_0x00a6
            r2.getMemoryInfo(r10)     // Catch:{ Exception -> 0x00a6 }
            int r2 = r2.getMemoryClass()     // Catch:{ Exception -> 0x00a6 }
            if (r2 >= r11) goto L_0x0083
            java.lang.String r3 = "LOW_ON_MEMORY"
            r13.setGodelDisabled(r3)     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r4 = "system"
            java.lang.String r5 = "info"
            java.lang.String r6 = "util"
            java.lang.String r7 = "switching_godel_off"
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a6 }
            r13.<init>(r1)     // Catch:{ Exception -> 0x00a6 }
            r13.append(r2)     // Catch:{ Exception -> 0x00a6 }
            r13.append(r0)     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r8 = r13.toString()     // Catch:{ Exception -> 0x00a6 }
            r3 = r12
            r3.trackAction(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00a6 }
        L_0x0083:
            logMemoryInfo(r12, r10)     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r4 = "system"
            java.lang.String r5 = "info"
            java.lang.String r6 = "util"
            java.lang.String r7 = "switchoffgodeliflowonmemory"
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a6 }
            r13.<init>()     // Catch:{ Exception -> 0x00a6 }
            r13.append(r2)     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r0 = " MB <"
            r13.append(r0)     // Catch:{ Exception -> 0x00a6 }
            r13.append(r11)     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r8 = r13.toString()     // Catch:{ Exception -> 0x00a6 }
            r3 = r12
            r3.trackAction(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00a6 }
        L_0x00a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.core.PaymentUtils.switchOffGodelIfLowOnMemory(in.juspay.hypersdk.safe.Godel, in.juspay.hypersdk.core.JuspayServices, in.juspay.hypersdk.data.PaymentSessionInfo):void");
    }

    @Keep
    public static String toJavascriptArray(ArrayList<String> arrayList) {
        if (arrayList == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            sb.append("\"");
            sb.append(it.next());
            sb.append("\"");
            if (it.hasNext()) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static boolean validatePinning(X509Certificate[] x509CertificateArr, Set<String> set) {
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            if (x509CertificateArr.length > 0) {
                X509Certificate x509Certificate = x509CertificateArr[0];
                byte[] encoded = x509Certificate.getPublicKey().getEncoded();
                instance.update(encoded, 0, encoded.length);
                String encodeToString = Base64.encodeToString(instance.digest(), 2);
                sb.append("    sha256/");
                sb.append(encodeToString);
                sb.append(" : ");
                sb.append(x509Certificate.getSubjectDN().toString());
                sb.append("\n");
                return !set.contains(encodeToString);
            }
            JuspayLogger.d(LOG_TAG, sb.toString());
            return true;
        } catch (NoSuchAlgorithmException unused) {
            throw new CertificateException("couldn't create digest");
        }
    }
}
