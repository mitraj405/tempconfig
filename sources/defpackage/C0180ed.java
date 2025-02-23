package defpackage;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Base64;
import android.util.Xml;
import com.google.logging.type.LogSeverity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: ed  reason: default package and case insensitive filesystem */
/* compiled from: FontResourcesParserCompat */
public final class C0180ed {

    /* renamed from: ed$a */
    /* compiled from: FontResourcesParserCompat */
    public static class a {
        public static int a(TypedArray typedArray, int i) {
            return typedArray.getType(i);
        }
    }

    /* renamed from: ed$b */
    /* compiled from: FontResourcesParserCompat */
    public interface b {
    }

    /* renamed from: ed$c */
    /* compiled from: FontResourcesParserCompat */
    public static final class c implements b {
        public final d[] a;

        public c(d[] dVarArr) {
            this.a = dVarArr;
        }
    }

    /* renamed from: ed$d */
    /* compiled from: FontResourcesParserCompat */
    public static final class d {
        public final int a;

        /* renamed from: a  reason: collision with other field name */
        public final String f2883a;

        /* renamed from: a  reason: collision with other field name */
        public final boolean f2884a;
        public final int b;

        /* renamed from: b  reason: collision with other field name */
        public final String f2885b;
        public final int c;

        public d(int i, int i2, int i3, String str, String str2, boolean z) {
            this.f2883a = str;
            this.a = i;
            this.f2884a = z;
            this.f2885b = str2;
            this.b = i2;
            this.c = i3;
        }
    }

    /* renamed from: ed$e */
    /* compiled from: FontResourcesParserCompat */
    public static final class e implements b {
        public final int a;

        /* renamed from: a  reason: collision with other field name */
        public final C0109Yc f2886a;

        /* renamed from: a  reason: collision with other field name */
        public final String f2887a;
        public final int b;

        public e(C0109Yc yc, int i, int i2, String str) {
            this.f2886a = yc;
            this.b = i;
            this.a = i2;
            this.f2887a = str;
        }
    }

    public static b a(XmlResourceParser xmlResourceParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        boolean z;
        Resources resources2 = resources;
        do {
            next = xmlResourceParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            xmlResourceParser.require(2, (String) null, "font-family");
            if (xmlResourceParser.getName().equals("font-family")) {
                TypedArray obtainAttributes = resources2.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), js.FontFamily);
                String string = obtainAttributes.getString(js.FontFamily_fontProviderAuthority);
                String string2 = obtainAttributes.getString(js.FontFamily_fontProviderPackage);
                String string3 = obtainAttributes.getString(js.FontFamily_fontProviderQuery);
                int resourceId = obtainAttributes.getResourceId(js.FontFamily_fontProviderCerts, 0);
                int integer = obtainAttributes.getInteger(js.FontFamily_fontProviderFetchStrategy, 1);
                int integer2 = obtainAttributes.getInteger(js.FontFamily_fontProviderFetchTimeout, 500);
                String string4 = obtainAttributes.getString(js.FontFamily_fontProviderSystemFontFamily);
                obtainAttributes.recycle();
                if (string == null || string2 == null || string3 == null) {
                    ArrayList arrayList = new ArrayList();
                    while (xmlResourceParser.next() != 3) {
                        if (xmlResourceParser.getEventType() == 2) {
                            if (xmlResourceParser.getName().equals("font")) {
                                TypedArray obtainAttributes2 = resources2.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), js.FontFamilyFont);
                                int i = js.FontFamilyFont_fontWeight;
                                if (!obtainAttributes2.hasValue(i)) {
                                    i = js.FontFamilyFont_android_fontWeight;
                                }
                                int i2 = obtainAttributes2.getInt(i, LogSeverity.WARNING_VALUE);
                                int i3 = js.FontFamilyFont_fontStyle;
                                if (!obtainAttributes2.hasValue(i3)) {
                                    i3 = js.FontFamilyFont_android_fontStyle;
                                }
                                if (1 == obtainAttributes2.getInt(i3, 0)) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                int i4 = js.FontFamilyFont_ttcIndex;
                                if (!obtainAttributes2.hasValue(i4)) {
                                    i4 = js.FontFamilyFont_android_ttcIndex;
                                }
                                int i5 = js.FontFamilyFont_fontVariationSettings;
                                if (!obtainAttributes2.hasValue(i5)) {
                                    i5 = js.FontFamilyFont_android_fontVariationSettings;
                                }
                                String string5 = obtainAttributes2.getString(i5);
                                int i6 = obtainAttributes2.getInt(i4, 0);
                                int i7 = js.FontFamilyFont_font;
                                if (!obtainAttributes2.hasValue(i7)) {
                                    i7 = js.FontFamilyFont_android_font;
                                }
                                int resourceId2 = obtainAttributes2.getResourceId(i7, 0);
                                String string6 = obtainAttributes2.getString(i7);
                                obtainAttributes2.recycle();
                                while (xmlResourceParser.next() != 3) {
                                    c(xmlResourceParser);
                                }
                                arrayList.add(new d(i2, i6, resourceId2, string6, string5, z));
                            } else {
                                c(xmlResourceParser);
                            }
                        }
                    }
                    if (arrayList.isEmpty()) {
                        return null;
                    }
                    return new c((d[]) arrayList.toArray(new d[0]));
                }
                while (xmlResourceParser.next() != 3) {
                    c(xmlResourceParser);
                }
                return new e(new C0109Yc(string, string2, string3, b(resources2, resourceId)), integer, integer2, string4);
            }
            c(xmlResourceParser);
            return null;
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List<List<byte[]>> b(Resources resources, int i) {
        if (i == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a.a(obtainTypedArray, 0) == 1) {
                for (int i2 = 0; i2 < obtainTypedArray.length(); i2++) {
                    int resourceId = obtainTypedArray.getResourceId(i2, 0);
                    if (resourceId != 0) {
                        String[] stringArray = resources.getStringArray(resourceId);
                        ArrayList arrayList2 = new ArrayList();
                        for (String decode : stringArray) {
                            arrayList2.add(Base64.decode(decode, 0));
                        }
                        arrayList.add(arrayList2);
                    }
                }
            } else {
                String[] stringArray2 = resources.getStringArray(i);
                ArrayList arrayList3 = new ArrayList();
                for (String decode2 : stringArray2) {
                    arrayList3.add(Base64.decode(decode2, 0));
                }
                arrayList.add(arrayList3);
            }
            obtainTypedArray.recycle();
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    public static void c(XmlResourceParser xmlResourceParser) throws XmlPullParserException, IOException {
        int i = 1;
        while (i > 0) {
            int next = xmlResourceParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }
}
