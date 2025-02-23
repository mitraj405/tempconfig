package in.juspay.hypersdk.services;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.messaging.Constants;
import com.google.firebase.sessions.settings.RemoteSettings;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.constants.LogCategory;
import in.juspay.hyper.constants.LogLevel;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hyper.core.FileProviderInterface;
import in.juspay.hyper.core.JuspayLogger;
import in.juspay.hypersdk.R;
import in.juspay.hypersdk.core.JuspayServices;
import in.juspay.hypersdk.core.PaymentConstants;
import in.juspay.hypersdk.core.SdkTracker;
import in.juspay.hypersdk.data.KeyValueStore;
import in.juspay.hypersdk.data.SdkInfo;
import in.juspay.hypersdk.security.EncryptionHelper;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class FileProviderService implements FileProviderInterface {
    private static final String LOG_TAG = "FileProviderService";
    private final Map<String, String> fileCache = new HashMap();
    private final List<String> fileCacheWhiteList = new ArrayList();
    private final JuspayServices juspayServices;
    private final boolean shouldCheckInternalAssets = true;

    public FileProviderService(JuspayServices juspayServices2) {
        this.juspayServices = juspayServices2;
    }

    private void cacheFile(String str, String str2) {
        this.fileCache.put(str, str2);
        JuspayServices juspayServices2 = this.juspayServices;
        juspayServices2.sdkDebug(LOG_TAG, "Caching file: " + str);
    }

    private void copyFile(Context context, String str, String str2) {
        SdkTracker sdkTracker;
        StringBuilder sb;
        FileOutputStream fileOutputStream;
        try {
            createJuspayDir(context);
            createRequiredDir(context, str2);
            JuspayServices juspayServices2 = this.juspayServices;
            juspayServices2.sdkDebug(LOG_TAG, "copyFile: " + str + "   " + str2);
            FileInputStream fileInputStream = new FileInputStream(getFileFromInternalStorage(context, str));
            try {
                fileOutputStream = new FileOutputStream(getFileFromInternalStorage(context, str2));
                byte[] bArr = new byte[UserMetadata.MAX_ATTRIBUTE_SIZE];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        fileInputStream.close();
                        return;
                    }
                }
            } catch (Throwable th) {
                fileInputStream.close();
                throw th;
            }
            sb.append(str);
            sdkTracker.trackException(LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.FILE_PROVIDER_SERVICE, sb.toString(), e);
            return;
            throw th;
        } catch (FileNotFoundException e) {
            e = e;
            sdkTracker = this.juspayServices.getSdkTracker();
            sb = new StringBuilder("File not found: ");
        } catch (Exception e2) {
            e = e2;
            sdkTracker = this.juspayServices.getSdkTracker();
            sb = new StringBuilder("Exception: ");
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
    }

    private void createCertDir(Context context) {
        File file = new File(context.getDir("juspay", 0), "certificates_v1");
        if (!file.exists()) {
            file.mkdir();
        }
    }

    private void createJuspayDir(Context context) {
        File file = new File(context.getCacheDir(), "juspay");
        if (!file.exists()) {
            file.mkdir();
        }
    }

    private void createRequiredDir(Context context, String str) {
        if (str.contains(RemoteSettings.FORWARD_SLASH_STRING)) {
            File file = new File(context.getDir("juspay", 0), str.substring(0, str.lastIndexOf(RemoteSettings.FORWARD_SLASH_STRING)));
            if (!file.exists()) {
                file.mkdirs();
            }
        }
    }

    private void deleteFileFromCache(String str) {
        if (isFileCached(str)) {
            this.fileCache.remove(str);
        }
    }

    private File getFileFromInternalStorage(Context context, String str) {
        JuspayServices juspayServices2 = this.juspayServices;
        juspayServices2.sdkDebug(LOG_TAG, "Context while reading Internal Storage :" + context);
        JuspayServices juspayServices3 = this.juspayServices;
        juspayServices3.sdkDebug(LOG_TAG, "Getting file from internal storage. Filename: " + str);
        return new File(context.getDir("juspay", 0), str);
    }

    private boolean isFileCached(String str) {
        return this.fileCache.containsKey(str);
    }

    private String readFromAssets(Context context, String str) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            byte[] assetFileAsByte = getAssetFileAsByte(context, str);
            if (str.endsWith("jsa")) {
                JuspayServices juspayServices2 = this.juspayServices;
                juspayServices2.sdkDebug(LOG_TAG, "Read JSA Asset file " + str + " with encrypted hash - " + EncryptionHelper.md5(assetFileAsByte));
                return new String(EncryptionHelper.decryptThenGunzip(assetFileAsByte, context.getResources().getString(R.string.juspay_encryption_version)));
            }
            JuspayServices juspayServices3 = this.juspayServices;
            juspayServices3.sdkDebug(LOG_TAG, "Done reading " + str + " from assets");
            return new String(assetFileAsByte);
        } catch (Exception e) {
            sdkTracker.trackException(LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.FILE_PROVIDER_SERVICE, C0709Uj.i("Exception trying to read from file: ", str), e);
            return null;
        }
    }

    private void readFromInputStream(ByteArrayOutputStream byteArrayOutputStream, InputStream inputStream) {
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    private String readFromInternalStorage(Context context, String str) {
        BufferedReader bufferedReader;
        String appendSdkNameAndVersion = appendSdkNameAndVersion(str);
        if (this.juspayServices.getSdkInfo().usesLocalAssets()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            if (appendSdkNameAndVersion.endsWith("jsa")) {
                byte[] decryptGunzipInternalStorage = decryptGunzipInternalStorage(context, appendSdkNameAndVersion);
                if (decryptGunzipInternalStorage != null) {
                    return new String(decryptGunzipInternalStorage);
                }
                sdkTracker.trackAction(LogSubCategory.Action.SYSTEM, LogLevel.WARNING, Labels.System.FILE_PROVIDER_SERVICE, "readFromInternalStorage", "Returning null from internal storage for ".concat(appendSdkNameAndVersion));
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(getFileFromInternalStorage(context, appendSdkNameAndVersion));
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    while (true) {
                        int read = bufferedReader.read();
                        if (read != -1) {
                            sb.append((char) read);
                        } else {
                            bufferedReader.close();
                            inputStreamReader.close();
                            sdkTracker.trackAction(LogSubCategory.Action.SYSTEM, LogLevel.DEBUG, Labels.System.FILE_PROVIDER_SERVICE, "readFromInternalStorage", "Returning the file content without decryption for " + appendSdkNameAndVersion);
                            String sb2 = sb.toString();
                            fileInputStream.close();
                            return sb2;
                        }
                    }
                } catch (Throwable th) {
                    inputStreamReader.close();
                    throw th;
                }
            } catch (Throwable th2) {
                fileInputStream.close();
                throw th2;
            }
        } catch (Exception e) {
            sdkTracker.trackException(LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.FILE_PROVIDER_SERVICE, "read from internal storage failed", e);
            return null;
        } catch (Throwable th3) {
            th2.addSuppressed(th3);
        }
        throw th;
    }

    private void updateFallback(Context context, String str, String str2) {
        String str3;
        Exception exc;
        SdkTracker sdkTracker;
        if (str2.endsWith("jsa") && isFilePresent(context, str2)) {
            JuspayServices juspayServices2 = this.juspayServices;
            juspayServices2.sdkDebug(LOG_TAG, "updateFallback: starting" + str2 + "  " + str);
            try {
                String md5 = EncryptionHelper.md5(decryptGunzipInternalStorage(context, str2));
                JSONObject jSONObject = new JSONObject(KeyValueStore.read(this.juspayServices, PaymentConstants.JP_BLOCKED_HASH, "{}"));
                this.juspayServices.sdkDebug(LOG_TAG, "updateFallback: got the blocked hash");
                if (jSONObject.has(str)) {
                    JuspayServices juspayServices3 = this.juspayServices;
                    juspayServices3.sdkDebug(LOG_TAG, "updateFallback: got the file name " + str);
                    JSONObject jSONObject2 = jSONObject.getJSONObject(str);
                    if (!jSONObject2.has("latest_hash") || !jSONObject2.getString("latest_hash").equals(md5)) {
                        this.juspayServices.sdkDebug(LOG_TAG, "updateFallback: wonderful.. copying to the fallback");
                        copyFile(context, str2, "fb/".concat(str2));
                        jSONObject2.remove("latest_hash");
                        jSONObject.put(str, jSONObject2);
                        KeyValueStore.write(this.juspayServices, PaymentConstants.JP_BLOCKED_HASH, jSONObject.toString());
                    } else {
                        return;
                    }
                } else {
                    copyFile(context, str2, "fb/".concat(str2));
                    this.juspayServices.sdkDebug(LOG_TAG, "updateFallback: we didn;t get the file name from blocked hash ".concat(str2));
                    this.juspayServices.sdkDebug(LOG_TAG, "updateFallback: wonderful.. copying to the fallback");
                }
                this.juspayServices.sdkDebug(LOG_TAG, "updateFallback: file copied");
            } catch (FileNotFoundException e) {
                exc = e;
                sdkTracker = this.juspayServices.getSdkTracker();
                str3 = "File not found: ";
                sdkTracker.trackException(LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.HyperSdk.AUTO_FALLBACK, str3.concat(str2), exc);
            } catch (Exception e2) {
                exc = e2;
                sdkTracker = this.juspayServices.getSdkTracker();
                str3 = "Exception: ";
                sdkTracker.trackException(LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.HyperSdk.AUTO_FALLBACK, str3.concat(str2), exc);
            }
        }
    }

    private boolean writeToFile(Context context, String str, byte[] bArr, boolean z) {
        StringBuilder sb;
        FileOutputStream fileOutputStream;
        String appendSdkNameAndVersion = appendSdkNameAndVersion(str);
        updateFallback(context, str, appendSdkNameAndVersion);
        deleteFileFromCache(appendSdkNameAndVersion);
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            createJuspayDir(context);
            createRequiredDir(context, appendSdkNameAndVersion);
            if (z) {
                createCertDir(context);
            }
            fileOutputStream = new FileOutputStream(getFileFromInternalStorage(context, appendSdkNameAndVersion));
            fileOutputStream.write(bArr);
            fileOutputStream.close();
            return true;
        } catch (FileNotFoundException e) {
            e = e;
            sb = new StringBuilder("File not found: ");
            sb.append(appendSdkNameAndVersion);
            sdkTracker.trackException(LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.FILE_PROVIDER_SERVICE, sb.toString(), e);
            return false;
        } catch (IOException e2) {
            e = e2;
            sb = new StringBuilder("IOException: ");
            sb.append(appendSdkNameAndVersion);
            sdkTracker.trackException(LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.FILE_PROVIDER_SERVICE, sb.toString(), e);
            return false;
        } catch (Exception e3) {
            e = e3;
            sb = new StringBuilder("Exception: ");
            sb.append(appendSdkNameAndVersion);
            sdkTracker.trackException(LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.FILE_PROVIDER_SERVICE, sb.toString(), e);
            return false;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public void addToFileCacheWhiteList(String str) {
        this.fileCacheWhiteList.add(str);
    }

    public String appendSdkNameAndVersion(String str) {
        String str2;
        StringBuilder sb;
        SdkInfo sdkInfo = this.juspayServices.getSdkInfo();
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf <= 0 || lastIndexOf >= str.length() - 1) {
            sb = lf.n(str, "_");
            sb.append(sdkInfo.getSdkName());
            sb.append("_");
            str2 = sdkInfo.getSdkVersion();
        } else {
            String substring = str.substring(0, lastIndexOf);
            str2 = str.substring(lastIndexOf);
            sb = lf.n(substring, "_");
            sb.append(sdkInfo.getSdkName());
            sb.append("_");
            sb.append(sdkInfo.getSdkVersion());
        }
        sb.append(str2);
        return sb.toString();
    }

    public byte[] decryptGunzipAssetFile(Context context, String str) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        byte[] bArr = new byte[0];
        try {
            bArr = getAssetFileAsByte(context, str);
        } catch (Exception e) {
            sdkTracker.trackException(LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.FILE_PROVIDER_SERVICE, lf.j("Exception in reading ", str, " from assets"), e);
        }
        return EncryptionHelper.decryptThenGunzip(bArr, context.getResources().getString(R.string.juspay_encryption_version));
    }

    public byte[] decryptGunzipInternalStorage(Context context, String str) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            byte[] internalStorageFileAsByte = getInternalStorageFileAsByte(context, str);
            JuspayServices juspayServices2 = this.juspayServices;
            juspayServices2.sdkDebug(LOG_TAG, "Read Encrypted file from internalStorage - " + str + " with encrypted hash - " + EncryptionHelper.md5(internalStorageFileAsByte));
            return EncryptionHelper.decryptThenGunzip(internalStorageFileAsByte, context.getResources().getString(R.string.juspay_encryption_version));
        } catch (FileNotFoundException e) {
            JuspayServices juspayServices3 = this.juspayServices;
            juspayServices3.sdkDebug(LOG_TAG, "No File to decrypt in internal storage: " + str);
            throw e;
        } catch (Exception e2) {
            sdkTracker.trackException(LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.FILE_PROVIDER_SERVICE, lf.j("Exception in reading ", str, " from internal storage"), e2);
            return null;
        }
    }

    public boolean deleteFileFromInternalStorage(Context context, String str) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        RemoteAssetService remoteAssetService = this.juspayServices.getRemoteAssetService();
        File fileFromInternalStorage = getFileFromInternalStorage(context, str);
        if (fileFromInternalStorage.exists()) {
            JuspayServices juspayServices2 = this.juspayServices;
            juspayServices2.sdkDebug(LOG_TAG, "Deleting " + str + " from internal storage");
            JuspayLogger.e(LOG_TAG, "FILE CORRUPTED. DISABLING SDK");
            sdkTracker.trackAction(LogSubCategory.Action.SYSTEM, LogLevel.WARNING, Labels.System.FILE_PROVIDER_SERVICE, "file_corrupted", str);
            try {
                remoteAssetService.resetMetadata(str.replace(".zip", ".jsa"));
            } catch (Exception e) {
                sdkTracker.trackException(LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.FILE_PROVIDER_SERVICE, "Error while resetting etag", e);
            }
            return fileFromInternalStorage.delete();
        }
        JuspayLogger.e(LOG_TAG, str + " not found");
        return false;
    }

    public byte[] getAssetFileAsByte(Context context, String str) {
        InputStream open;
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                AssetManager assets = context.getResources().getAssets();
                open = assets.open("juspay/" + str);
                readFromInputStream(byteArrayOutputStream, open);
                if (open != null) {
                    open.close();
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Throwable th) {
                byteArrayOutputStream.close();
                throw th;
            }
            throw th;
        } catch (FileNotFoundException e) {
            sdkTracker.trackException(LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.FILE_PROVIDER_SERVICE, C0709Uj.i("Could not read ", str), e);
            throw new RuntimeException(e);
        } catch (IOException e2) {
            sdkTracker.trackException(LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.FILE_PROVIDER_SERVICE, C0709Uj.i("Could not read ", str), e2);
            deleteFileFromInternalStorage(context, str);
            throw new RuntimeException(e2);
        } catch (Exception e3) {
            sdkTracker.trackException(LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.FILE_PROVIDER_SERVICE, C0709Uj.i("Exception: Could not read ", str), e3);
            deleteFileFromInternalStorage(context, str);
            return new byte[0];
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
    }

    public byte[] getInternalStorageFileAsByte(Context context, String str) {
        FileInputStream fileInputStream;
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        RemoteAssetService remoteAssetService = this.juspayServices.getRemoteAssetService();
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                fileInputStream = new FileInputStream(getFileFromInternalStorage(context, str));
                readFromInputStream(byteArrayOutputStream, fileInputStream);
                fileInputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Throwable th) {
                byteArrayOutputStream.close();
                throw th;
            }
            throw th;
        } catch (FileNotFoundException e) {
            JuspayServices juspayServices2 = this.juspayServices;
            juspayServices2.sdkDebug(LOG_TAG, "File not found " + str);
            try {
                remoteAssetService.resetMetadata(str.replace(".zip", ".jsa"));
            } catch (JSONException unused) {
                sdkTracker.trackException(LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.FILE_PROVIDER_SERVICE, C0709Uj.i("Couldn't reset ", str), e);
            }
            throw e;
        } catch (IOException e2) {
            sdkTracker.trackException(LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.FILE_PROVIDER_SERVICE, C0709Uj.i("Could not read ", str), e2);
            deleteFileFromInternalStorage(context, str);
            throw new RuntimeException(e2);
        } catch (Exception e3) {
            sdkTracker.trackException(LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.FILE_PROVIDER_SERVICE, C0709Uj.i("Exception: Could not read ", str), e3);
            deleteFileFromInternalStorage(context, str);
            throw new RuntimeException(e3);
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
    }

    public boolean isFilePresent(Context context, String str) {
        boolean z = true;
        if (new File(context.getDir("juspay", 0), appendSdkNameAndVersion(str)).exists()) {
            return true;
        }
        try {
            InputStream open = context.getResources().getAssets().open("juspay/" + str);
            if (open == null) {
                z = false;
            }
            if (open != null) {
                open.close();
            }
            return z;
        } catch (IOException unused) {
            return false;
        }
    }

    public String readFromCache(String str) {
        if (!isFileCached(str)) {
            return null;
        }
        String str2 = this.fileCache.get(str);
        JuspayServices juspayServices2 = this.juspayServices;
        juspayServices2.sdkDebug(LOG_TAG, "Returning cached value of the file: " + str);
        JuspayServices juspayServices3 = this.juspayServices;
        juspayServices3.sdkDebug(LOG_TAG, "Cached: " + str2);
        return str2;
    }

    public String readFromFile(Context context, String str) {
        return readFromFile(context, str, true);
    }

    public void renewFile(String str, String str2, long j) {
        this.juspayServices.getRemoteAssetService().renewFile(this.juspayServices.getContext(), str, (String) null, str2, j);
    }

    public boolean updateCertificate(Context context, String str, byte[] bArr) {
        return writeToFile(context, str, bArr, true);
    }

    public boolean updateFile(Context context, String str, byte[] bArr) {
        return writeToFile(context, str, bArr, false);
    }

    public String writeFileToDisk(Context context, String str, String str2) {
        try {
            File file = new File(context.getExternalFilesDirs(Environment.DIRECTORY_DOWNLOADS)[0].getAbsolutePath());
            file.mkdirs();
            File file2 = new File(file, str2);
            file2.createNewFile();
            if (file2.exists()) {
                FileWriter fileWriter = new FileWriter(file2);
                fileWriter.write(str);
                fileWriter.flush();
                fileWriter.close();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("error", "false");
                jSONObject.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, file);
                return jSONObject.toString();
            }
            JuspayLogger.d(LOG_TAG, "Exception in creating the file");
            return String.format("{\"error\":\"true\",\"data\":\"%s\"}", new Object[]{"unknown_error::Exception in creating the file"});
        } catch (Exception e) {
            JuspayLogger.d(LOG_TAG, "Exception in downloading the file :" + e);
            return String.format("{\"error\":\"true\",\"data\":\"%s\"}", new Object[]{"unknown_error::" + e});
        }
    }

    public String readFromFile(Context context, String str, boolean z) {
        String readFromCache = z ? readFromCache(str) : null;
        if (readFromCache == null) {
            readFromCache = readFromInternalStorage(context, str);
        }
        if (readFromCache == null) {
            readFromCache = readFromAssets(context, str);
        }
        if (this.fileCacheWhiteList.contains(str) && readFromCache != null) {
            cacheFile(str, readFromCache);
        }
        return readFromCache == null ? "" : readFromCache;
    }
}
