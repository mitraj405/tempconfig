package defpackage;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import defpackage.C1099f0;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: Nv  reason: default package and case insensitive filesystem */
/* compiled from: SecurePreferences */
public final class C0614Nv implements SharedPreferences {
    public final SharedPreferences a;

    /* renamed from: a  reason: collision with other field name */
    public final C1099f0.c f3721a;

    /* renamed from: a  reason: collision with other field name */
    public final String f3722a;

    /* renamed from: Nv$a */
    /* compiled from: SecurePreferences */
    public final class a implements SharedPreferences.Editor {

        /* renamed from: a  reason: collision with other field name */
        public final SharedPreferences.Editor f3723a;

        public a() {
            this.f3723a = C0614Nv.this.a.edit();
        }

        @TargetApi(9)
        public final void apply() {
            this.f3723a.apply();
        }

        public final SharedPreferences.Editor clear() {
            this.f3723a.clear();
            return this;
        }

        public final boolean commit() {
            return this.f3723a.commit();
        }

        public final SharedPreferences.Editor putBoolean(String str, boolean z) {
            this.f3723a.putString(C0614Nv.e(str), C0614Nv.a(C0614Nv.this, Boolean.toString(z)));
            return this;
        }

        public final SharedPreferences.Editor putFloat(String str, float f) {
            this.f3723a.putString(C0614Nv.e(str), C0614Nv.a(C0614Nv.this, Float.toString(f)));
            return this;
        }

        public final SharedPreferences.Editor putInt(String str, int i) {
            this.f3723a.putString(C0614Nv.e(str), C0614Nv.a(C0614Nv.this, Integer.toString(i)));
            return this;
        }

        public final SharedPreferences.Editor putLong(String str, long j) {
            this.f3723a.putString(C0614Nv.e(str), C0614Nv.a(C0614Nv.this, Long.toString(j)));
            return this;
        }

        public final SharedPreferences.Editor putString(String str, String str2) {
            this.f3723a.putString(C0614Nv.e(str), C0614Nv.a(C0614Nv.this, str2));
            return this;
        }

        @TargetApi(11)
        public final SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            HashSet hashSet = new HashSet(set.size());
            for (String a2 : set) {
                hashSet.add(C0614Nv.a(C0614Nv.this, a2));
            }
            this.f3723a.putStringSet(C0614Nv.e(str), hashSet);
            return this;
        }

        public final SharedPreferences.Editor remove(String str) {
            this.f3723a.remove(C0614Nv.e(str));
            return this;
        }
    }

    public C0614Nv(Context context) {
        SharedPreferences sharedPreferences;
        if (this.a == null) {
            if (TextUtils.isEmpty((CharSequence) null)) {
                sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            } else {
                sharedPreferences = context.getSharedPreferences((String) null, 0);
            }
            this.a = sharedPreferences;
        }
        this.f3722a = null;
        if (TextUtils.isEmpty("")) {
            try {
                String e = e(C1099f0.d(context.getPackageName(), d(context).getBytes()).toString());
                String string = this.a.getString(e, (String) null);
                if (string == null) {
                    C1099f0.c();
                    KeyGenerator instance = KeyGenerator.getInstance("AES");
                    instance.init(128);
                    SecretKey generateKey = instance.generateKey();
                    C1099f0.c();
                    byte[] bArr = new byte[32];
                    new SecureRandom().nextBytes(bArr);
                    C1099f0.c cVar = new C1099f0.c(generateKey, new SecretKeySpec(bArr, "HmacSHA256"));
                    this.f3721a = cVar;
                    this.a.edit().putString(e, cVar.toString()).commit();
                } else {
                    this.f3721a = C1099f0.e(string);
                }
                if (this.f3721a == null) {
                    throw new GeneralSecurityException("Problem generating Key");
                }
            } catch (GeneralSecurityException e2) {
                throw new IllegalStateException(e2);
            }
        } else {
            try {
                this.f3721a = C1099f0.d("", d(context).getBytes());
            } catch (GeneralSecurityException e3) {
                throw new IllegalStateException(e3);
            }
        }
    }

    public static String a(C0614Nv nv, String str) {
        nv.getClass();
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return C1099f0.b(str, nv.f3721a).toString();
        } catch (UnsupportedEncodingException | GeneralSecurityException unused) {
            return null;
        }
    }

    public static String e(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            byte[] bytes = str.getBytes("UTF-8");
            instance.update(bytes, 0, bytes.length);
            return Base64.encodeToString(instance.digest(), 2);
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public final String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return C1099f0.a(new C1099f0.a(str), this.f3721a);
        } catch (UnsupportedEncodingException | GeneralSecurityException unused) {
            return null;
        }
    }

    /* renamed from: c */
    public final a edit() {
        return new a();
    }

    public final boolean contains(String str) {
        return this.a.contains(e(str));
    }

    public final String d(Context context) {
        String str = this.f3722a;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            String str2 = (String) Build.class.getField("SERIAL").get((Object) null);
            if (TextUtils.isEmpty(str2)) {
                return Settings.Secure.getString(context.getContentResolver(), "android_id");
            }
            return str2;
        } catch (Exception unused) {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        }
    }

    public final Map<String, String> getAll() {
        Map<String, ?> all = this.a.getAll();
        HashMap hashMap = new HashMap(all.size());
        for (Map.Entry next : all.entrySet()) {
            try {
                Object value = next.getValue();
                if (value != null && !value.equals(this.f3721a.toString())) {
                    hashMap.put(next.getKey(), b(value.toString()));
                }
            } catch (Exception unused) {
                hashMap.put(next.getKey(), next.getValue().toString());
            }
        }
        return hashMap;
    }

    public final boolean getBoolean(String str, boolean z) {
        String string = this.a.getString(e(str), (String) null);
        if (string == null) {
            return z;
        }
        try {
            return Boolean.parseBoolean(b(string));
        } catch (NumberFormatException e) {
            throw new ClassCastException(e.getMessage());
        }
    }

    public final float getFloat(String str, float f) {
        String string = this.a.getString(e(str), (String) null);
        if (string == null) {
            return f;
        }
        try {
            return Float.parseFloat(b(string));
        } catch (NumberFormatException e) {
            throw new ClassCastException(e.getMessage());
        }
    }

    public final int getInt(String str, int i) {
        String string = this.a.getString(e(str), (String) null);
        if (string == null) {
            return i;
        }
        try {
            return Integer.parseInt(b(string));
        } catch (NumberFormatException e) {
            throw new ClassCastException(e.getMessage());
        }
    }

    public final long getLong(String str, long j) {
        String string = this.a.getString(e(str), (String) null);
        if (string == null) {
            return j;
        }
        try {
            return Long.parseLong(b(string));
        } catch (NumberFormatException e) {
            throw new ClassCastException(e.getMessage());
        }
    }

    public final String getString(String str, String str2) {
        String string = this.a.getString(e(str), (String) null);
        String b = b(string);
        if (string == null || b == null) {
            return str2;
        }
        return b;
    }

    @TargetApi(11)
    public final Set<String> getStringSet(String str, Set<String> set) {
        Set<String> stringSet = this.a.getStringSet(e(str), (Set) null);
        if (stringSet == null) {
            return set;
        }
        HashSet hashSet = new HashSet(stringSet.size());
        for (String b : stringSet) {
            hashSet.add(b(b));
        }
        return hashSet;
    }

    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.a.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.a.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }
}
