package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.SparseArray;
import android.util.Xml;
import java.util.ArrayList;

/* renamed from: Ux  reason: default package */
/* compiled from: StateSet */
public final class Ux {
    public int a = -1;

    /* renamed from: a  reason: collision with other field name */
    public final SparseArray<a> f584a = new SparseArray<>();

    /* renamed from: Ux$a */
    /* compiled from: StateSet */
    public static class a {
        public final int a;

        /* renamed from: a  reason: collision with other field name */
        public final ArrayList<b> f585a = new ArrayList<>();
        public final int b = -1;

        public a(Context context, XmlResourceParser xmlResourceParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), C0221hs.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0221hs.State_android_id) {
                    this.a = obtainStyledAttributes.getResourceId(index, this.a);
                } else if (index == C0221hs.State_constraints) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, this.b);
                    this.b = resourceId;
                    String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                    context.getResources().getResourceName(resourceId);
                    "layout".equals(resourceTypeName);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: Ux$b */
    /* compiled from: StateSet */
    public static class b {
        public final float a = Float.NaN;

        /* renamed from: a  reason: collision with other field name */
        public final int f586a = -1;
        public final float b = Float.NaN;
        public final float c = Float.NaN;
        public final float d = Float.NaN;

        public b(Context context, XmlResourceParser xmlResourceParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), C0221hs.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0221hs.Variant_constraints) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, this.f586a);
                    this.f586a = resourceId;
                    String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                    context.getResources().getResourceName(resourceId);
                    "layout".equals(resourceTypeName);
                } else if (index == C0221hs.Variant_region_heightLessThan) {
                    this.d = obtainStyledAttributes.getDimension(index, this.d);
                } else if (index == C0221hs.Variant_region_heightMoreThan) {
                    this.b = obtainStyledAttributes.getDimension(index, this.b);
                } else if (index == C0221hs.Variant_region_widthLessThan) {
                    this.c = obtainStyledAttributes.getDimension(index, this.c);
                } else if (index == C0221hs.Variant_region_widthMoreThan) {
                    this.a = obtainStyledAttributes.getDimension(index, this.a);
                }
            }
            obtainStyledAttributes.recycle();
        }

        public final boolean a(float f, float f2) {
            float f3 = this.a;
            if (!Float.isNaN(f3) && f < f3) {
                return false;
            }
            float f4 = this.b;
            if (!Float.isNaN(f4) && f2 < f4) {
                return false;
            }
            float f5 = this.c;
            if (!Float.isNaN(f5) && f > f5) {
                return false;
            }
            float f6 = this.d;
            if (Float.isNaN(f6) || f2 <= f6) {
                return true;
            }
            return false;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Ux(android.content.Context r10, android.content.res.XmlResourceParser r11) {
        /*
            r9 = this;
            r9.<init>()
            r0 = -1
            r9.a = r0
            android.util.SparseArray r1 = new android.util.SparseArray
            r1.<init>()
            r9.f584a = r1
            android.util.SparseArray r1 = new android.util.SparseArray
            r1.<init>()
            android.util.AttributeSet r1 = android.util.Xml.asAttributeSet(r11)
            int[] r2 = defpackage.C0221hs.StateSet
            android.content.res.TypedArray r1 = r10.obtainStyledAttributes(r1, r2)
            int r2 = r1.getIndexCount()
            r3 = 0
            r4 = r3
        L_0x0022:
            if (r4 >= r2) goto L_0x0037
            int r5 = r1.getIndex(r4)
            int r6 = defpackage.C0221hs.StateSet_defaultState
            if (r5 != r6) goto L_0x0034
            int r6 = r9.a
            int r5 = r1.getResourceId(r5, r6)
            r9.a = r5
        L_0x0034:
            int r4 = r4 + 1
            goto L_0x0022
        L_0x0037:
            r1.recycle()
            int r1 = r11.getEventType()     // Catch:{ XmlPullParserException -> 0x00b9, IOException -> 0x00b4 }
            r2 = 0
        L_0x003f:
            r4 = 1
            if (r1 == r4) goto L_0x00bd
            if (r1 == 0) goto L_0x00ac
            java.lang.String r5 = "StateSet"
            r6 = 3
            r7 = 2
            if (r1 == r7) goto L_0x005a
            if (r1 == r6) goto L_0x004e
            goto L_0x00af
        L_0x004e:
            java.lang.String r1 = r11.getName()     // Catch:{ XmlPullParserException -> 0x00b9, IOException -> 0x00b4 }
            boolean r1 = r5.equals(r1)     // Catch:{ XmlPullParserException -> 0x00b9, IOException -> 0x00b4 }
            if (r1 == 0) goto L_0x00af
            goto L_0x00bd
        L_0x005a:
            java.lang.String r1 = r11.getName()     // Catch:{ XmlPullParserException -> 0x00b9, IOException -> 0x00b4 }
            int r8 = r1.hashCode()     // Catch:{ XmlPullParserException -> 0x00b9, IOException -> 0x00b4 }
            switch(r8) {
                case 80204913: goto L_0x0081;
                case 1301459538: goto L_0x0077;
                case 1382829617: goto L_0x0070;
                case 1901439077: goto L_0x0066;
                default: goto L_0x0065;
            }     // Catch:{ XmlPullParserException -> 0x00b9, IOException -> 0x00b4 }
        L_0x0065:
            goto L_0x008b
        L_0x0066:
            java.lang.String r4 = "Variant"
            boolean r1 = r1.equals(r4)     // Catch:{ XmlPullParserException -> 0x00b9, IOException -> 0x00b4 }
            if (r1 == 0) goto L_0x008b
            r4 = r6
            goto L_0x008c
        L_0x0070:
            boolean r1 = r1.equals(r5)     // Catch:{ XmlPullParserException -> 0x00b9, IOException -> 0x00b4 }
            if (r1 == 0) goto L_0x008b
            goto L_0x008c
        L_0x0077:
            java.lang.String r4 = "LayoutDescription"
            boolean r1 = r1.equals(r4)     // Catch:{ XmlPullParserException -> 0x00b9, IOException -> 0x00b4 }
            if (r1 == 0) goto L_0x008b
            r4 = r3
            goto L_0x008c
        L_0x0081:
            java.lang.String r4 = "State"
            boolean r1 = r1.equals(r4)     // Catch:{ XmlPullParserException -> 0x00b9, IOException -> 0x00b4 }
            if (r1 == 0) goto L_0x008b
            r4 = r7
            goto L_0x008c
        L_0x008b:
            r4 = r0
        L_0x008c:
            if (r4 == r7) goto L_0x009e
            if (r4 == r6) goto L_0x0091
            goto L_0x00af
        L_0x0091:
            Ux$b r1 = new Ux$b     // Catch:{ XmlPullParserException -> 0x00b9, IOException -> 0x00b4 }
            r1.<init>(r10, r11)     // Catch:{ XmlPullParserException -> 0x00b9, IOException -> 0x00b4 }
            if (r2 == 0) goto L_0x00af
            java.util.ArrayList<Ux$b> r4 = r2.f585a     // Catch:{ XmlPullParserException -> 0x00b9, IOException -> 0x00b4 }
            r4.add(r1)     // Catch:{ XmlPullParserException -> 0x00b9, IOException -> 0x00b4 }
            goto L_0x00af
        L_0x009e:
            Ux$a r1 = new Ux$a     // Catch:{ XmlPullParserException -> 0x00b9, IOException -> 0x00b4 }
            r1.<init>(r10, r11)     // Catch:{ XmlPullParserException -> 0x00b9, IOException -> 0x00b4 }
            android.util.SparseArray<Ux$a> r2 = r9.f584a     // Catch:{ XmlPullParserException -> 0x00b9, IOException -> 0x00b4 }
            int r4 = r1.a     // Catch:{ XmlPullParserException -> 0x00b9, IOException -> 0x00b4 }
            r2.put(r4, r1)     // Catch:{ XmlPullParserException -> 0x00b9, IOException -> 0x00b4 }
            r2 = r1
            goto L_0x00af
        L_0x00ac:
            r11.getName()     // Catch:{ XmlPullParserException -> 0x00b9, IOException -> 0x00b4 }
        L_0x00af:
            int r1 = r11.next()     // Catch:{ XmlPullParserException -> 0x00b9, IOException -> 0x00b4 }
            goto L_0x003f
        L_0x00b4:
            r10 = move-exception
            r10.printStackTrace()
            goto L_0x00bd
        L_0x00b9:
            r10 = move-exception
            r10.printStackTrace()
        L_0x00bd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Ux.<init>(android.content.Context, android.content.res.XmlResourceParser):void");
    }

    public final int a(int i) {
        int i2;
        ArrayList<b> arrayList;
        a aVar;
        ArrayList<b> arrayList2;
        float f = (float) -1;
        SparseArray<a> sparseArray = this.f584a;
        int i3 = 0;
        if (-1 == i) {
            if (i == -1) {
                aVar = sparseArray.valueAt(0);
            } else {
                aVar = sparseArray.get(-1);
            }
            if (aVar == null) {
                return -1;
            }
            while (true) {
                arrayList2 = aVar.f585a;
                if (i3 >= arrayList2.size()) {
                    i3 = -1;
                    break;
                } else if (arrayList2.get(i3).a(f, f)) {
                    break;
                } else {
                    i3++;
                }
            }
            if (-1 == i3) {
                return -1;
            }
            if (i3 == -1) {
                i2 = aVar.b;
            } else {
                i2 = arrayList2.get(i3).f586a;
            }
        } else {
            a aVar2 = sparseArray.get(i);
            if (aVar2 == null) {
                return -1;
            }
            while (true) {
                arrayList = aVar2.f585a;
                if (i3 >= arrayList.size()) {
                    i3 = -1;
                    break;
                } else if (arrayList.get(i3).a(f, f)) {
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 == -1) {
                i2 = aVar2.b;
            } else {
                i2 = arrayList.get(i3).f586a;
            }
        }
        return i2;
    }
}
