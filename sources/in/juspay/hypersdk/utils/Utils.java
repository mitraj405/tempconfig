package in.juspay.hypersdk.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.constants.LogCategory;
import in.juspay.hyper.constants.LogLevel;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hyper.core.JuspayLogger;
import in.juspay.hypersdk.core.JuspayServices;
import in.juspay.hypersdk.services.SdkConfigService;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utils {
    private static final String LOG_TAG = "Utils";

    public static boolean checkIfGranted(JuspayServices juspayServices, String str) {
        if (r1.k(juspayServices.getContext(), str) == 0) {
            return true;
        }
        return false;
    }

    public static boolean contains(JSONArray jSONArray, Object obj) {
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                if (jSONArray.get(i).equals(obj)) {
                    return true;
                }
                i++;
            } catch (JSONException unused) {
            }
        }
        return false;
    }

    public static JSONArray defaultNonNull(JSONArray jSONArray) {
        return jSONArray == null ? new JSONArray() : jSONArray;
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

    public static String getIPAddress(JuspayServices juspayServices) {
        try {
            for (T inetAddresses : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                Iterator<T> it = Collections.list(inetAddresses.getInetAddresses()).iterator();
                while (true) {
                    if (it.hasNext()) {
                        InetAddress inetAddress = (InetAddress) it.next();
                        if (!inetAddress.isLoopbackAddress() && inetAddress.getHostAddress() != null) {
                            String upperCase = inetAddress.getHostAddress().toUpperCase();
                            if (isIPv4Address(upperCase)) {
                                return upperCase;
                            }
                        }
                    }
                }
            }
            return "";
        } catch (Exception e) {
            juspayServices.getSdkTracker().trackException(LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.UTIL, "Failed to Retreive IP address", e);
            return "";
        }
    }

    public static String getLogLevelFromThrowable(Throwable th) {
        if (th instanceof Error) {
            return LogLevel.CRITICAL;
        }
        if (th instanceof Exception) {
            return "error";
        }
        return LogLevel.WARNING;
    }

    public static ActivityManager.MemoryInfo getMemoryInfo(Context context) {
        ActivityManager activityManager;
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            if (context != null) {
                activityManager = (ActivityManager) context.getSystemService("activity");
            } else {
                activityManager = null;
            }
            if (activityManager != null) {
                activityManager.getMemoryInfo(memoryInfo);
                return memoryInfo;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static byte[] gzipContent(byte[] bArr) {
        GZIPOutputStream gZIPOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        try {
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            JuspayLogger.d(LOG_TAG, "Gzipping complete");
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
        throw th;
    }

    public static <T> boolean includes(JSONArray jSONArray, T t) {
        if (jSONArray == null) {
            return false;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            if (t.equals(jSONArray.opt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isIPv4Address(String str) {
        String[] split = str.split("\\.");
        if (split.length != 4) {
            return false;
        }
        int length = split.length;
        int i = 0;
        while (i < length) {
            try {
                int parseInt = Integer.parseInt(split[i]);
                if (parseInt >= 0 && parseInt <= 255) {
                    i++;
                }
            } catch (NumberFormatException unused) {
            }
            return false;
        }
        return true;
    }

    public static boolean isUiFeatureEnabled(JuspayServices juspayServices, String str) {
        JSONObject jSONObject;
        if (juspayServices == null) {
            jSONObject = SdkConfigService.getCachedSdkConfig();
        } else {
            jSONObject = juspayServices.getSdkConfigService().getSdkConfig();
        }
        if (jSONObject == null) {
            jSONObject = SdkConfigService.getCachedSdkConfig();
        }
        if (jSONObject == null) {
            return true;
        }
        JSONObject optJSONObject = optJSONObject(optJSONObject(jSONObject, "uiFeatures"), str);
        if (!optJSONObject.optBoolean("enabled")) {
            return false;
        }
        if (juspayServices == null) {
            return true;
        }
        return !includes(optJSONArray(optJSONObject, "blacklistedClientIds"), juspayServices.getSessionInfo().getClientId());
    }

    public static JSONArray optJSONArray(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return new JSONArray();
        }
        return optJSONArray;
    }

    public static JSONObject optJSONObject(JSONObject jSONObject, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            return new JSONObject();
        }
        return optJSONObject;
    }

    public static JSONObject toJSON(Bundle bundle) {
        Object valueOf;
        JSONObject jSONObject = new JSONObject();
        if (bundle != null) {
            try {
                for (String next : bundle.keySet()) {
                    Object obj = bundle.get(next);
                    if (obj == null) {
                        valueOf = JSONObject.NULL;
                    } else if (obj instanceof ArrayList) {
                        valueOf = toJSONArray((ArrayList) obj);
                    } else if (obj instanceof Bundle) {
                        valueOf = toJSON((Bundle) obj);
                    } else {
                        valueOf = String.valueOf(obj);
                    }
                    jSONObject.put(next, valueOf);
                }
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    public static JSONArray toJSONArray(ArrayList<Object> arrayList) {
        JSONArray jSONArray = new JSONArray();
        Iterator<Object> it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof ArrayList) {
                next = toJSONArray((ArrayList) next);
            } else if (!(next instanceof JSONObject)) {
                next = String.valueOf(next);
            }
            jSONArray.put(next);
        }
        return jSONArray;
    }

    public static JSONObject defaultNonNull(JSONObject jSONObject) {
        return jSONObject == null ? new JSONObject() : jSONObject;
    }
}
