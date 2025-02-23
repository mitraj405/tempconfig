package androidx.emoji2.text;

import android.content.pm.PackageManager;
import android.content.pm.Signature;

/* compiled from: DefaultEmojiCompatConfig */
public final class a {

    /* renamed from: androidx.emoji2.text.a$a  reason: collision with other inner class name */
    /* compiled from: DefaultEmojiCompatConfig */
    public static class C0018a {
        public Signature[] a(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo(str, 64).signatures;
        }
    }

    /* compiled from: DefaultEmojiCompatConfig */
    public static class b extends C0018a {
    }

    /* compiled from: DefaultEmojiCompatConfig */
    public static class c extends b {
        public final Signature[] a(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo(str, 64).signatures;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004b A[EDGE_INSN: B:26:0x004b->B:16:0x004b ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.emoji2.text.g a(android.content.Context r8) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 < r1) goto L_0x000c
            androidx.emoji2.text.a$c r0 = new androidx.emoji2.text.a$c
            r0.<init>()
            goto L_0x0011
        L_0x000c:
            androidx.emoji2.text.a$b r0 = new androidx.emoji2.text.a$b
            r0.<init>()
        L_0x0011:
            android.content.pm.PackageManager r1 = r8.getPackageManager()
            java.lang.String r2 = "Package manager required to locate emoji font provider"
            defpackage.C1354qp.t(r1, r2)
            android.content.Intent r2 = new android.content.Intent
            java.lang.String r3 = "androidx.content.action.LOAD_EMOJI_FONT"
            r2.<init>(r3)
            r3 = 0
            java.util.List r2 = r1.queryIntentContentProviders(r2, r3)
            java.util.Iterator r2 = r2.iterator()
        L_0x002a:
            boolean r4 = r2.hasNext()
            r5 = 0
            if (r4 == 0) goto L_0x004a
            java.lang.Object r4 = r2.next()
            android.content.pm.ResolveInfo r4 = (android.content.pm.ResolveInfo) r4
            android.content.pm.ProviderInfo r4 = r4.providerInfo
            if (r4 == 0) goto L_0x0046
            android.content.pm.ApplicationInfo r6 = r4.applicationInfo
            if (r6 == 0) goto L_0x0046
            int r6 = r6.flags
            r7 = 1
            r6 = r6 & r7
            if (r6 != r7) goto L_0x0046
            goto L_0x0047
        L_0x0046:
            r7 = r3
        L_0x0047:
            if (r7 == 0) goto L_0x002a
            goto L_0x004b
        L_0x004a:
            r4 = r5
        L_0x004b:
            if (r4 != 0) goto L_0x004e
            goto L_0x0076
        L_0x004e:
            java.lang.String r2 = r4.authority     // Catch:{ NameNotFoundException -> 0x0076 }
            java.lang.String r4 = r4.packageName     // Catch:{ NameNotFoundException -> 0x0076 }
            android.content.pm.Signature[] r0 = r0.a(r1, r4)     // Catch:{ NameNotFoundException -> 0x0076 }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ NameNotFoundException -> 0x0076 }
            r1.<init>()     // Catch:{ NameNotFoundException -> 0x0076 }
            int r6 = r0.length     // Catch:{ NameNotFoundException -> 0x0076 }
        L_0x005c:
            if (r3 >= r6) goto L_0x006a
            r7 = r0[r3]     // Catch:{ NameNotFoundException -> 0x0076 }
            byte[] r7 = r7.toByteArray()     // Catch:{ NameNotFoundException -> 0x0076 }
            r1.add(r7)     // Catch:{ NameNotFoundException -> 0x0076 }
            int r3 = r3 + 1
            goto L_0x005c
        L_0x006a:
            java.util.List r0 = java.util.Collections.singletonList(r1)     // Catch:{ NameNotFoundException -> 0x0076 }
            Yc r1 = new Yc     // Catch:{ NameNotFoundException -> 0x0076 }
            java.lang.String r3 = "emojicompat-emoji-font"
            r1.<init>(r2, r4, r3, r0)     // Catch:{ NameNotFoundException -> 0x0076 }
            goto L_0x0077
        L_0x0076:
            r1 = r5
        L_0x0077:
            if (r1 != 0) goto L_0x007a
            goto L_0x007f
        L_0x007a:
            androidx.emoji2.text.g r5 = new androidx.emoji2.text.g
            r5.<init>(r8, r1)
        L_0x007f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.a.a(android.content.Context):androidx.emoji2.text.g");
    }
}
