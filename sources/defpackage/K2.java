package defpackage;

import android.text.SpannableStringBuilder;
import defpackage.Iz;

/* renamed from: K2  reason: default package */
/* compiled from: BidiFormatter */
public final class K2 {
    public static final K2 a;

    /* renamed from: a  reason: collision with other field name */
    public static final String f324a = Character.toString(8206);
    public static final K2 b;

    /* renamed from: b  reason: collision with other field name */
    public static final String f325b = Character.toString(8207);

    /* renamed from: a  reason: collision with other field name */
    public final int f326a;

    /* renamed from: a  reason: collision with other field name */
    public final Hz f327a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f328a;

    /* renamed from: K2$a */
    /* compiled from: BidiFormatter */
    public static class a {
        public static final byte[] a = new byte[1792];

        /* renamed from: a  reason: collision with other field name */
        public char f329a;

        /* renamed from: a  reason: collision with other field name */
        public final int f330a;

        /* renamed from: a  reason: collision with other field name */
        public final CharSequence f331a;
        public int b;

        static {
            for (int i = 0; i < 1792; i++) {
                a[i] = Character.getDirectionality(i);
            }
        }

        public a(CharSequence charSequence) {
            this.f331a = charSequence;
            this.f330a = charSequence.length();
        }

        public final byte a() {
            CharSequence charSequence = this.f331a;
            char charAt = charSequence.charAt(this.b - 1);
            this.f329a = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePointBefore = Character.codePointBefore(charSequence, this.b);
                this.b -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.b--;
            char c = this.f329a;
            if (c < 1792) {
                return a[c];
            }
            return Character.getDirectionality(c);
        }
    }

    static {
        Iz.d dVar = Iz.c;
        a = new K2(false, 2, dVar);
        b = new K2(true, 2, dVar);
    }

    public K2(boolean z, int i, Iz.d dVar) {
        this.f328a = z;
        this.f326a = i;
        this.f327a = dVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008c, code lost:
        r3 = r3 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        return 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(java.lang.CharSequence r9) {
        /*
            K2$a r0 = new K2$a
            r0.<init>(r9)
            r9 = 0
            r0.b = r9
            r1 = r9
            r2 = r1
            r3 = r2
        L_0x000b:
            int r4 = r0.b
            int r5 = r0.f330a
            r6 = -1
            r7 = 1
            if (r4 >= r5) goto L_0x006e
            if (r1 != 0) goto L_0x006e
            java.lang.CharSequence r5 = r0.f331a
            char r4 = r5.charAt(r4)
            r0.f329a = r4
            boolean r4 = java.lang.Character.isHighSurrogate(r4)
            if (r4 == 0) goto L_0x0037
            int r4 = r0.b
            int r4 = java.lang.Character.codePointAt(r5, r4)
            int r5 = r0.b
            int r8 = java.lang.Character.charCount(r4)
            int r8 = r8 + r5
            r0.b = r8
            byte r4 = java.lang.Character.getDirectionality(r4)
            goto L_0x004b
        L_0x0037:
            int r4 = r0.b
            int r4 = r4 + r7
            r0.b = r4
            char r4 = r0.f329a
            r5 = 1792(0x700, float:2.511E-42)
            if (r4 >= r5) goto L_0x0047
            byte[] r5 = defpackage.K2.a.a
            byte r4 = r5[r4]
            goto L_0x004b
        L_0x0047:
            byte r4 = java.lang.Character.getDirectionality(r4)
        L_0x004b:
            if (r4 == 0) goto L_0x0069
            if (r4 == r7) goto L_0x0066
            r5 = 2
            if (r4 == r5) goto L_0x0066
            r5 = 9
            if (r4 == r5) goto L_0x000b
            switch(r4) {
                case 14: goto L_0x0062;
                case 15: goto L_0x0062;
                case 16: goto L_0x005e;
                case 17: goto L_0x005e;
                case 18: goto L_0x005a;
                default: goto L_0x0059;
            }
        L_0x0059:
            goto L_0x006c
        L_0x005a:
            int r3 = r3 + -1
            r2 = r9
            goto L_0x000b
        L_0x005e:
            int r3 = r3 + 1
            r2 = r7
            goto L_0x000b
        L_0x0062:
            int r3 = r3 + 1
            r2 = r6
            goto L_0x000b
        L_0x0066:
            if (r3 != 0) goto L_0x006c
            goto L_0x0086
        L_0x0069:
            if (r3 != 0) goto L_0x006c
            goto L_0x008a
        L_0x006c:
            r1 = r3
            goto L_0x000b
        L_0x006e:
            if (r1 != 0) goto L_0x0071
            goto L_0x008f
        L_0x0071:
            if (r2 == 0) goto L_0x0075
            r9 = r2
            goto L_0x008f
        L_0x0075:
            int r2 = r0.b
            if (r2 <= 0) goto L_0x008f
            byte r2 = r0.a()
            switch(r2) {
                case 14: goto L_0x0088;
                case 15: goto L_0x0088;
                case 16: goto L_0x0084;
                case 17: goto L_0x0084;
                case 18: goto L_0x0081;
                default: goto L_0x0080;
            }
        L_0x0080:
            goto L_0x0075
        L_0x0081:
            int r3 = r3 + 1
            goto L_0x0075
        L_0x0084:
            if (r1 != r3) goto L_0x008c
        L_0x0086:
            r9 = r7
            goto L_0x008f
        L_0x0088:
            if (r1 != r3) goto L_0x008c
        L_0x008a:
            r9 = r6
            goto L_0x008f
        L_0x008c:
            int r3 = r3 + -1
            goto L_0x0075
        L_0x008f:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.K2.a(java.lang.CharSequence):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002f, code lost:
        r2 = r2 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        return 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int b(java.lang.CharSequence r6) {
        /*
            K2$a r0 = new K2$a
            r0.<init>(r6)
            int r6 = r0.f330a
            r0.b = r6
            r6 = 0
            r1 = r6
        L_0x000b:
            r2 = r1
        L_0x000c:
            int r3 = r0.b
            if (r3 <= 0) goto L_0x0041
            byte r3 = r0.a()
            if (r3 == 0) goto L_0x0039
            r4 = 1
            if (r3 == r4) goto L_0x0032
            r5 = 2
            if (r3 == r5) goto L_0x0032
            r5 = 9
            if (r3 == r5) goto L_0x000c
            switch(r3) {
                case 14: goto L_0x002c;
                case 15: goto L_0x002c;
                case 16: goto L_0x0029;
                case 17: goto L_0x0029;
                case 18: goto L_0x0026;
                default: goto L_0x0023;
            }
        L_0x0023:
            if (r1 != 0) goto L_0x000c
            goto L_0x003f
        L_0x0026:
            int r2 = r2 + 1
            goto L_0x000c
        L_0x0029:
            if (r1 != r2) goto L_0x002f
            goto L_0x0034
        L_0x002c:
            if (r1 != r2) goto L_0x002f
            goto L_0x003b
        L_0x002f:
            int r2 = r2 + -1
            goto L_0x000c
        L_0x0032:
            if (r2 != 0) goto L_0x0036
        L_0x0034:
            r6 = r4
            goto L_0x0041
        L_0x0036:
            if (r1 != 0) goto L_0x000c
            goto L_0x003f
        L_0x0039:
            if (r2 != 0) goto L_0x003d
        L_0x003b:
            r6 = -1
            goto L_0x0041
        L_0x003d:
            if (r1 != 0) goto L_0x000c
        L_0x003f:
            r1 = r2
            goto L_0x000b
        L_0x0041:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.K2.b(java.lang.CharSequence):int");
    }

    public final SpannableStringBuilder c(CharSequence charSequence, Hz hz) {
        boolean z;
        Iz.d dVar;
        char c;
        Iz.d dVar2;
        String str;
        if (charSequence == null) {
            return null;
        }
        boolean b2 = ((Iz.c) hz).b(charSequence, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if ((this.f326a & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        String str2 = f325b;
        String str3 = f324a;
        boolean z2 = this.f328a;
        if (z) {
            if (b2) {
                dVar2 = Iz.b;
            } else {
                dVar2 = Iz.a;
            }
            boolean b3 = dVar2.b(charSequence, charSequence.length());
            if (!z2 && (b3 || a(charSequence) == 1)) {
                str = str3;
            } else if (!z2 || (b3 && a(charSequence) != -1)) {
                str = "";
            } else {
                str = str2;
            }
            spannableStringBuilder.append(str);
        }
        if (b2 != z2) {
            if (b2) {
                c = 8235;
            } else {
                c = 8234;
            }
            spannableStringBuilder.append(c);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append(8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (b2) {
            dVar = Iz.b;
        } else {
            dVar = Iz.a;
        }
        boolean b4 = dVar.b(charSequence, charSequence.length());
        if (!z2 && (b4 || b(charSequence) == 1)) {
            str2 = str3;
        } else if (!z2 || (b4 && b(charSequence) != -1)) {
            str2 = "";
        }
        spannableStringBuilder.append(str2);
        return spannableStringBuilder;
    }
}
