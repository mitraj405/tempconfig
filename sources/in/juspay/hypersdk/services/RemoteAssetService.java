package in.juspay.hypersdk.services;

import android.content.Context;
import android.os.AsyncTask;
import com.google.common.net.HttpHeaders;
import com.google.firebase.sessions.settings.RemoteSettings;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.constants.LogCategory;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hypersdk.core.JuspayServices;
import in.juspay.hypersdk.core.PaymentConstants;
import in.juspay.hypersdk.core.SdkTracker;
import in.juspay.hypersdk.data.KeyValueStore;
import in.juspay.hypersdk.data.SessionInfo;
import in.juspay.hypersdk.security.EncryptionHelper;
import in.juspay.hypersdk.utils.network.SessionizedNetUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RemoteAssetService {
    private static final String LOG_TAG = "RemoteAssetService";
    /* access modifiers changed from: private */
    public static final JSONArray fileDownloadTimes = new JSONArray();
    private JSONObject assetMetadata;
    /* access modifiers changed from: private */
    public final JuspayServices juspayServices;
    private final String sdkName;

    public static class AssetDownloadTask extends AsyncTask<Void, Void, Boolean> {
        private String callback;
        private Context context;
        private String fileName;
        private String location;
        private RemoteAssetService remoteAssetService;
        private long renewFileStartTime;
        private long ttlInMilliSeconds;

        public AssetDownloadTask(Context context2, String str, String str2, String str3, long j, RemoteAssetService remoteAssetService2, long j2) {
            this.location = str;
            this.fileName = str2;
            this.callback = str3;
            this.ttlInMilliSeconds = j;
            this.remoteAssetService = remoteAssetService2;
            this.context = context2;
            this.renewFileStartTime = j2;
        }

        public Boolean doInBackground(Void... voidArr) {
            if (this.context != null) {
                try {
                    if (!this.location.contains("certificates")) {
                        return Boolean.valueOf(this.remoteAssetService.getContent(this.context, this.location, this.fileName, this.ttlInMilliSeconds));
                    }
                    this.remoteAssetService.updateCertificates(this.context, this.location, this.ttlInMilliSeconds);
                } catch (Exception e) {
                    Exception exc = e;
                    SdkTracker sdkTracker = this.remoteAssetService.juspayServices.getSdkTracker();
                    sdkTracker.trackAndLogException(RemoteAssetService.LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.REMOTE_ASSET_SERVICE, "Could not renew file " + this.location + ": " + exc.getMessage(), exc);
                }
            }
            return Boolean.FALSE;
        }

        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            long currentTimeMillis = System.currentTimeMillis();
            long j = currentTimeMillis - this.renewFileStartTime;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("startTime", this.renewFileStartTime);
                jSONObject.put("endTime", currentTimeMillis);
                jSONObject.put("totalTime", j);
                jSONObject.put("fileName", this.fileName);
            } catch (JSONException unused) {
            }
            RemoteAssetService.fileDownloadTimes.put(jSONObject);
            String str = this.callback;
            if (str != null) {
                String format = String.format("window.callUICallback('%s', '%b', '%s', '%s');", new Object[]{str, bool, this.location, this.remoteAssetService.juspayServices.getFileProviderService().appendSdkNameAndVersion(this.fileName)});
                this.remoteAssetService.juspayServices.sdkDebug(RemoteAssetService.LOG_TAG, format);
                this.remoteAssetService.juspayServices.addJsToWebView(format);
            }
        }
    }

    public RemoteAssetService(JuspayServices juspayServices2) {
        this.juspayServices = juspayServices2;
        this.sdkName = juspayServices2.getSdkInfo().getSdkName();
    }

    private String decideAndUpdateInternalStorage(Context context, byte[] bArr, String str, String str2) {
        boolean z;
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        FileProviderService fileProviderService = this.juspayServices.getFileProviderService();
        String md5 = EncryptionHelper.md5(bArr);
        if (md5 == null) {
            md5 = "";
        }
        String str3 = md5;
        JuspayServices juspayServices2 = this.juspayServices;
        juspayServices2.sdkDebug(LOG_TAG, "hashInDisk: " + str);
        this.juspayServices.sdkDebug(LOG_TAG, "newHash: ".concat(str3));
        sdkTracker.trackAction(LogSubCategory.Action.SYSTEM, "info", Labels.System.REMOTE_ASSET_SERVICE, "remote_asset_service_update_hash", C1058d.B(new StringBuilder("Hash of used file '"), str2, "' is now ", str3));
        if (str == null || !str.equals(str3)) {
            sdkTracker.trackAction(LogSubCategory.Action.SYSTEM, "info", Labels.System.REMOTE_ASSET_SERVICE, "remote_asset_service_compare_hash", lf.j("Remote hash differs from disk hash. Updating asset '", str2, "'"));
            z = fileProviderService.updateFile(context, str2, bArr);
        } else {
            sdkTracker.trackAction(LogSubCategory.Action.SYSTEM, "info", Labels.System.REMOTE_ASSET_SERVICE, "remote_asset_service_compare_hash", lf.j("Remote hash is same as disk hash. Not updating asset '", str2, "'"));
            z = false;
        }
        if (z) {
            return str3;
        }
        return null;
    }

    private byte[] download(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("ts", String.valueOf(System.currentTimeMillis()));
        hashMap.put(HttpHeaders.IF_NONE_MATCH, str);
        hashMap.put(HttpHeaders.ACCEPT_ENCODING, "gzip");
        JuspayServices juspayServices2 = this.juspayServices;
        juspayServices2.sdkDebug(LOG_TAG, "START fetching content from: " + str2);
        try {
            return new SessionizedNetUtils(this.juspayServices.getSessionInfo(), 0, 0, false).fetchIfModified(str2, hashMap);
        } catch (Exception e) {
            this.juspayServices.getSdkTracker().trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.REMOTE_ASSET_SERVICE, "Error While Downloading File", e);
            return null;
        }
    }

    private long getAssetTtl() {
        return Long.parseLong(KeyValueStore.read(this.juspayServices.getContext(), this.sdkName, "REMOTE_ASSET_TTL_MILLISECONDS", String.valueOf(3600000)));
    }

    private synchronized void setMetadata(String str, JSONObject jSONObject) {
        if (this.assetMetadata == null) {
            getMetadata(str);
        }
        this.assetMetadata.put(str, jSONObject);
        KeyValueStore.write(this.juspayServices.getContext(), this.sdkName, "asset_metadata.json", this.assetMetadata.toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0158, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0152, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:?, code lost:
        r1.addSuppressed(r0);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:86:0x0141, B:94:0x014e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] unZipAndVerify(android.content.Context r22, byte[] r23, java.lang.String r24) {
        /*
            r21 = this;
            r1 = r21
            r0 = r23
            r7 = r24
            java.lang.String r8 = "remote_asset_service"
            java.lang.String r9 = "system"
            java.lang.String r10 = "action"
            java.lang.String r11 = "RemoteAssetService"
            in.juspay.hypersdk.core.JuspayServices r2 = r1.juspayServices
            in.juspay.hypersdk.services.FileProviderService r2 = r2.getFileProviderService()
            in.juspay.hypersdk.core.JuspayServices r3 = r1.juspayServices
            in.juspay.hypersdk.core.SdkTracker r19 = r3.getSdkTracker()
            if (r0 == 0) goto L_0x017a
            java.lang.String r3 = ".zip"
            boolean r4 = r7.contains(r3)
            if (r4 == 0) goto L_0x017a
            r20 = 0
            java.io.ByteArrayInputStream r15 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x0167 }
            r15.<init>(r0)     // Catch:{ IOException -> 0x0167 }
            java.util.zip.ZipInputStream r14 = new java.util.zip.ZipInputStream     // Catch:{ all -> 0x015a }
            r14.<init>(r15)     // Catch:{ all -> 0x015a }
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x014a }
            r4 = 34
            if (r0 < r4) goto L_0x0040
            dalvik.system.ZipPathValidator.clearCallback()     // Catch:{ all -> 0x003a }
            goto L_0x0040
        L_0x003a:
            r0 = move-exception
            r1 = r0
            r2 = r14
            r3 = r15
            goto L_0x014e
        L_0x0040:
            r0 = r20
            r12 = r0
        L_0x0043:
            java.util.zip.ZipEntry r4 = r14.getNextEntry()     // Catch:{ Exception -> 0x012b }
            if (r4 == 0) goto L_0x00a1
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x012b }
            r5.<init>()     // Catch:{ Exception -> 0x012b }
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r6]     // Catch:{ Exception -> 0x012b }
        L_0x0052:
            int r13 = r14.read(r6)     // Catch:{ Exception -> 0x012b }
            r1 = -1
            if (r13 == r1) goto L_0x0060
            r1 = 0
            r5.write(r6, r1, r13)     // Catch:{ Exception -> 0x012b }
            r1 = r21
            goto L_0x0052
        L_0x0060:
            r14.closeEntry()     // Catch:{ Exception -> 0x012b }
            r5.close()     // Catch:{ Exception -> 0x012b }
            java.lang.String r1 = r4.getName()     // Catch:{ Exception -> 0x012b }
            java.lang.String r6 = "signature"
            boolean r1 = r1.contains(r6)     // Catch:{ Exception -> 0x012b }
            if (r1 == 0) goto L_0x007e
            byte[] r0 = r5.toByteArray()     // Catch:{ Exception -> 0x012b }
            r1 = 2
            byte[] r0 = android.util.Base64.decode(r0, r1)     // Catch:{ Exception -> 0x012b }
        L_0x007b:
            r1 = r21
            goto L_0x0043
        L_0x007e:
            java.lang.String r1 = r4.getName()     // Catch:{ Exception -> 0x012b }
            java.lang.String r6 = ".jsa"
            boolean r1 = r1.contains(r6)     // Catch:{ Exception -> 0x012b }
            if (r1 != 0) goto L_0x009c
            java.lang.String r1 = "certificate"
            boolean r1 = r7.contains(r1)     // Catch:{ Exception -> 0x012b }
            if (r1 == 0) goto L_0x007b
            java.lang.String r1 = r4.getName()     // Catch:{ Exception -> 0x012b }
            boolean r1 = r1.contains(r3)     // Catch:{ Exception -> 0x012b }
            if (r1 == 0) goto L_0x007b
        L_0x009c:
            byte[] r12 = r5.toByteArray()     // Catch:{ Exception -> 0x012b }
            goto L_0x007b
        L_0x00a1:
            java.io.ObjectInputStream r1 = new java.io.ObjectInputStream     // Catch:{ ClassNotFoundException -> 0x011a, NoSuchAlgorithmException -> 0x0116, InvalidKeyException -> 0x0112, SignatureException -> 0x010e }
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch:{ ClassNotFoundException -> 0x011a, NoSuchAlgorithmException -> 0x0116, InvalidKeyException -> 0x0112, SignatureException -> 0x010e }
            java.lang.String r4 = "remoteAssetPublicKey"
            r5 = r22
            byte[] r2 = r2.getAssetFileAsByte(r5, r4)     // Catch:{ ClassNotFoundException -> 0x011a, NoSuchAlgorithmException -> 0x0116, InvalidKeyException -> 0x0112, SignatureException -> 0x010e }
            r3.<init>(r2)     // Catch:{ ClassNotFoundException -> 0x011a, NoSuchAlgorithmException -> 0x0116, InvalidKeyException -> 0x0112, SignatureException -> 0x010e }
            r1.<init>(r3)     // Catch:{ ClassNotFoundException -> 0x011a, NoSuchAlgorithmException -> 0x0116, InvalidKeyException -> 0x0112, SignatureException -> 0x010e }
            java.lang.Object r2 = r1.readObject()     // Catch:{ all -> 0x0102 }
            java.security.PublicKey r2 = (java.security.PublicKey) r2     // Catch:{ all -> 0x0102 }
            java.lang.String r3 = "DSA"
            java.security.Signature r3 = java.security.Signature.getInstance(r3)     // Catch:{ all -> 0x0102 }
            r3.initVerify(r2)     // Catch:{ all -> 0x0102 }
            r3.update(r12)     // Catch:{ all -> 0x0102 }
            boolean r0 = r3.verify(r0)     // Catch:{ all -> 0x0102 }
            if (r0 != 0) goto L_0x00e9
            java.lang.String r3 = "system"
            java.lang.String r4 = "info"
            java.lang.String r5 = "remote_asset_service"
            java.lang.String r6 = "signature_not_verified"
            r2 = r19
            r7 = r24
            r2.trackAction(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0102 }
            r1.close()     // Catch:{ ClassNotFoundException -> 0x011a, NoSuchAlgorithmException -> 0x0116, InvalidKeyException -> 0x0112, SignatureException -> 0x010e }
            r14.close()     // Catch:{ all -> 0x00e4 }
            r15.close()     // Catch:{ IOException -> 0x0167 }
            return r20
        L_0x00e4:
            r0 = move-exception
            r1 = r0
            r3 = r15
            goto L_0x015d
        L_0x00e9:
            java.lang.String r3 = "system"
            java.lang.String r4 = "info"
            java.lang.String r5 = "remote_asset_service"
            java.lang.String r6 = "signature_verified"
            r2 = r19
            r7 = r24
            r2.trackAction(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0102 }
            r1.close()     // Catch:{ ClassNotFoundException -> 0x011a, NoSuchAlgorithmException -> 0x0116, InvalidKeyException -> 0x0112, SignatureException -> 0x010e }
            r14.close()     // Catch:{ all -> 0x00e4 }
            r15.close()     // Catch:{ IOException -> 0x0167 }
            return r12
        L_0x0102:
            r0 = move-exception
            r2 = r0
            r1.close()     // Catch:{ all -> 0x0108 }
            goto L_0x010d
        L_0x0108:
            r0 = move-exception
            r1 = r0
            r2.addSuppressed(r1)     // Catch:{ ClassNotFoundException -> 0x011a, NoSuchAlgorithmException -> 0x0116, InvalidKeyException -> 0x0112, SignatureException -> 0x010e }
        L_0x010d:
            throw r2     // Catch:{ ClassNotFoundException -> 0x011a, NoSuchAlgorithmException -> 0x0116, InvalidKeyException -> 0x0112, SignatureException -> 0x010e }
        L_0x010e:
            r0 = move-exception
            java.lang.String r1 = "Exception while matching Signature for file"
            goto L_0x011d
        L_0x0112:
            r0 = move-exception
            java.lang.String r1 = "Key Used was Invalid"
            goto L_0x011d
        L_0x0116:
            r0 = move-exception
            java.lang.String r1 = "DSA Algorithm not found"
            goto L_0x011d
        L_0x011a:
            r0 = move-exception
            java.lang.String r1 = "Exception while Reading Public Key"
        L_0x011d:
            r7 = r1
            r2 = r19
            r3 = r11
            r4 = r10
            r5 = r9
            r6 = r8
            r8 = r0
            r2.trackAndLogException(r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x012b }
            r2 = r14
            r3 = r15
            goto L_0x0141
        L_0x012b:
            r0 = move-exception
            r18 = r0
            java.lang.String r13 = "RemoteAssetService"
            java.lang.String r0 = "action"
            java.lang.String r1 = "system"
            java.lang.String r16 = "remote_asset_service"
            java.lang.String r17 = "Exception while verifying Signature"
            r12 = r19
            r2 = r14
            r14 = r0
            r3 = r15
            r15 = r1
            r12.trackAndLogException(r13, r14, r15, r16, r17, r18)     // Catch:{ all -> 0x0148 }
        L_0x0141:
            r2.close()     // Catch:{ all -> 0x0158 }
            r3.close()     // Catch:{ IOException -> 0x0167 }
            goto L_0x0179
        L_0x0148:
            r0 = move-exception
            goto L_0x014d
        L_0x014a:
            r0 = move-exception
            r2 = r14
            r3 = r15
        L_0x014d:
            r1 = r0
        L_0x014e:
            r2.close()     // Catch:{ all -> 0x0152 }
            goto L_0x0157
        L_0x0152:
            r0 = move-exception
            r2 = r0
            r1.addSuppressed(r2)     // Catch:{ all -> 0x0158 }
        L_0x0157:
            throw r1     // Catch:{ all -> 0x0158 }
        L_0x0158:
            r0 = move-exception
            goto L_0x015c
        L_0x015a:
            r0 = move-exception
            r3 = r15
        L_0x015c:
            r1 = r0
        L_0x015d:
            r3.close()     // Catch:{ all -> 0x0161 }
            goto L_0x0166
        L_0x0161:
            r0 = move-exception
            r2 = r0
            r1.addSuppressed(r2)     // Catch:{ IOException -> 0x0167 }
        L_0x0166:
            throw r1     // Catch:{ IOException -> 0x0167 }
        L_0x0167:
            r0 = move-exception
            r18 = r0
            java.lang.String r13 = "RemoteAssetService"
            java.lang.String r14 = "action"
            java.lang.String r15 = "system"
            java.lang.String r16 = "remote_asset_service"
            java.lang.String r17 = "IOException while verifying Signature"
            r12 = r19
            r12.trackAndLogException(r13, r14, r15, r16, r17, r18)
        L_0x0179:
            return r20
        L_0x017a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.services.RemoteAssetService.unZipAndVerify(android.content.Context, byte[], java.lang.String):byte[]");
    }

    private String unzipAndUpdateInternalStorage(Context context, byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        FileProviderService fileProviderService = this.juspayServices.getFileProviderService();
        String md5 = EncryptionHelper.md5(bArr);
        if (md5 == null) {
            md5 = "";
        }
        ZipInputStream zipInputStream = new ZipInputStream(new ByteArrayInputStream(bArr));
        while (true) {
            try {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    String name = nextEntry.getName();
                    if (!nextEntry.isDirectory()) {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        while (true) {
                            int read = zipInputStream.read();
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(read);
                        }
                        fileProviderService.updateCertificate(context, name, byteArrayOutputStream.toByteArray());
                        byteArrayOutputStream.close();
                    }
                } else {
                    zipInputStream.close();
                    return md5;
                }
            } catch (Throwable th) {
                try {
                    zipInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        throw th;
    }

    /* access modifiers changed from: private */
    public void updateCertificates(Context context, String str, long j) {
        String str2;
        String str3;
        Context context2 = context;
        String str4 = str;
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        JSONObject metadata = getMetadata(str4);
        boolean z = true;
        String substring = str4.substring(str4.lastIndexOf(RemoteSettings.FORWARD_SLASH_STRING) + 1);
        if (metadata.getString("lastChecked") != null) {
            str3 = metadata.getString(PaymentConstants.ATTR_HASH_IN_DISK);
            str2 = metadata.getString("zipHashInDisk");
        } else {
            str3 = "";
            str2 = str3;
        }
        byte[] download = download(str2, str4);
        if (download != null) {
            str2 = EncryptionHelper.md5(download);
        } else {
            z = false;
        }
        boolean z2 = z;
        String str5 = str2;
        byte[] unZipAndVerify = unZipAndVerify(context2, download, substring);
        this.juspayServices.sdkDebug(LOG_TAG, "DONE fetching content from: ".concat(str4));
        JuspayServices juspayServices2 = this.juspayServices;
        juspayServices2.sdkDebug(LOG_TAG, "hashInDisk: " + str3);
        this.juspayServices.sdkDebug(LOG_TAG, "newHash: ");
        String str6 = "zipHashInDisk";
        byte[] bArr = unZipAndVerify;
        String str7 = str5;
        sdkTracker.trackAction(LogSubCategory.Action.SYSTEM, "info", Labels.System.REMOTE_ASSET_SERVICE, "remote_asset_service_update_hash", "Hash of used file '" + substring + "' is now ");
        if (bArr != null) {
            String unzipAndUpdateInternalStorage = unzipAndUpdateInternalStorage(context2, bArr);
            metadata.put("lastChecked", System.currentTimeMillis());
            metadata.put(PaymentConstants.ATTR_HASH_IN_DISK, unzipAndUpdateInternalStorage);
            metadata.put(str6, str7);
            setMetadata(str4, metadata);
        } else if (!z2) {
            sdkTracker.trackAction(LogSubCategory.Action.SYSTEM, "info", Labels.System.REMOTE_ASSET_SERVICE, "remote_asset_service_etag_match", "ETAG matches for '" + substring + "'. Not downloading from " + str4);
        }
    }

    public boolean getContent(Context context, String str) {
        return getContent(context, str, getAssetTtl());
    }

    public JSONArray getFileDownloadTimes() {
        return fileDownloadTimes;
    }

    public synchronized JSONObject getMetadata(String str) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            this.assetMetadata = new JSONObject(KeyValueStore.read(this.juspayServices.getContext(), this.sdkName, "asset_metadata.json", "{}"));
            JuspayServices juspayServices2 = this.juspayServices;
            juspayServices2.sdkDebug(LOG_TAG, "assetMetadata: " + this.assetMetadata);
            if (!this.assetMetadata.has(str)) {
                this.assetMetadata.put(str, new JSONObject());
                ((JSONObject) this.assetMetadata.get(str)).put("lastChecked", 0);
                ((JSONObject) this.assetMetadata.get(str)).put(PaymentConstants.ATTR_HASH_IN_DISK, "");
                ((JSONObject) this.assetMetadata.get(str)).put("zipHashInDisk", "");
            }
        } catch (JSONException e) {
            sdkTracker.trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.REMOTE_ASSET_SERVICE, "Exception trying to read from KeyStore: asset_metadata.json", e);
            throw new RuntimeException("Unexpected internal error.", e);
        }
        return (JSONObject) this.assetMetadata.get(str);
    }

    public void renewFile(Context context, String str, String str2, long j) {
        renewFile(context, str, str2, getAssetTtl(), (String) null, j);
    }

    public synchronized void resetMetadata(String str) {
        if (this.assetMetadata == null) {
            getMetadata(str);
        }
        this.assetMetadata.remove(str);
        KeyValueStore.write(this.juspayServices.getContext(), this.sdkName, "asset_metadata.json", this.assetMetadata.toString());
    }

    private boolean getContent(Context context, String str, long j) {
        return getContent(context, str, (String) null, j);
    }

    public void renewFile(Context context, String str, String str2, long j, String str3, long j2) {
        JuspayServices juspayServices2 = this.juspayServices;
        juspayServices2.sdkDebug(LOG_TAG, "Looking to renew file: " + str);
        new AssetDownloadTask(context, str, str3, str2, j, this, j2).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    /* access modifiers changed from: private */
    public boolean getContent(Context context, String str, String str2, long j) {
        String str3;
        String str4;
        boolean z;
        Throwable th;
        Context context2 = context;
        SessionInfo sessionInfo = this.juspayServices.getSessionInfo();
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        FileProviderService fileProviderService = this.juspayServices.getFileProviderService();
        String replace = !sessionInfo.isVerifyAssetsEnabled() ? str.replace(".zip", ".jsa") : str;
        String substring = str2 == null ? replace.substring(replace.lastIndexOf(RemoteSettings.FORWARD_SLASH_STRING) + 1) : str2;
        String replace2 = substring.replace(".zip", ".jsa");
        JSONObject metadata = getMetadata(replace2);
        if (metadata.getString("lastChecked") != null) {
            str4 = metadata.getString(PaymentConstants.ATTR_HASH_IN_DISK);
            str3 = metadata.getString("zipHashInDisk");
        } else {
            str3 = "";
            if (!substring.contains(".zip")) {
                FileInputStream fileInputStream = new FileInputStream(fileProviderService.readFromFile(context2, substring, false));
                try {
                    String md5 = EncryptionHelper.md5((InputStream) fileInputStream);
                    fileInputStream.close();
                    str4 = md5;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            } else {
                str4 = str3;
            }
        }
        byte[] download = download(str3, replace);
        if (download != null) {
            str3 = EncryptionHelper.md5(download);
            z = true;
        } else {
            z = false;
        }
        byte[] unZipAndVerify = unZipAndVerify(context2, download, substring);
        if (unZipAndVerify == null) {
            if (!z) {
                sdkTracker.trackAction(LogSubCategory.Action.SYSTEM, "info", Labels.System.REMOTE_ASSET_SERVICE, "remote_asset_service_etag_match", "ETAG matches for '" + substring + "'. Not downloading from " + replace);
                return false;
            }
            unZipAndVerify = EncryptionHelper.v1Encrypt(fileProviderService.readFromFile(context2, replace2, false).getBytes());
        }
        if (unZipAndVerify != null) {
            this.juspayServices.sdkDebug(LOG_TAG, "DONE fetching content from: ".concat(replace));
            this.juspayServices.sdkDebug(LOG_TAG, "Text: ".concat(new String(unZipAndVerify)));
        }
        String decideAndUpdateInternalStorage = decideAndUpdateInternalStorage(context2, unZipAndVerify, str4, replace2);
        if (decideAndUpdateInternalStorage != null) {
            metadata.put("lastChecked", System.currentTimeMillis());
            metadata.put(PaymentConstants.ATTR_HASH_IN_DISK, decideAndUpdateInternalStorage);
            metadata.put("zipHashInDisk", str3);
            setMetadata(replace2, metadata);
        }
        return true;
        throw th;
    }

    public void renewFile(Context context, String str, String str2, String str3, long j) {
        renewFile(context, str, str2, getAssetTtl(), str3, j);
    }
}
