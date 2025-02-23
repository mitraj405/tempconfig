package com.facebook.ads.internal.util.common;

import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FbValidationUtils {
    public static final String FB4A_SHA256_HASH = "4/nh4M+Z0OVqBVumXiQbM5n3zqUkMmsM3W7BMn7Q/cE=";
    public static final String FB_PACKAGE = "com.facebook.katana";

    public static String getSigningCertificate(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return "";
        }
        try {
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr.length == 0) {
                return "";
            }
            return Base64.encodeToString(MessageDigest.getInstance("SHA256").digest(signatureArr[0].toByteArray()), 2);
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public static boolean isFbSigningCertificateValid(String str) {
        return FB4A_SHA256_HASH.equals(str);
    }
}
