package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.SparseArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.ArrayList;

public final class ConstraintLayoutStates {
    public int a = -1;

    /* renamed from: a  reason: collision with other field name */
    public final SparseArray<a> f1650a = new SparseArray<>();

    /* renamed from: a  reason: collision with other field name */
    public final ConstraintLayout f1651a;
    public int b = -1;

    /* renamed from: b  reason: collision with other field name */
    public final SparseArray<ConstraintSet> f1652b = new SparseArray<>();

    public static class a {
        public final int a;

        /* renamed from: a  reason: collision with other field name */
        public final ConstraintSet f1653a;

        /* renamed from: a  reason: collision with other field name */
        public final ArrayList<b> f1654a = new ArrayList<>();
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
                    if ("layout".equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.f1653a = constraintSet;
                        constraintSet.e((ConstraintLayout) LayoutInflater.from(context).inflate(resourceId, (ViewGroup) null));
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class b {
        public final float a = Float.NaN;

        /* renamed from: a  reason: collision with other field name */
        public final int f1655a = -1;

        /* renamed from: a  reason: collision with other field name */
        public final ConstraintSet f1656a;
        public final float b = Float.NaN;
        public final float c = Float.NaN;
        public final float d = Float.NaN;

        public b(Context context, XmlResourceParser xmlResourceParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), C0221hs.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0221hs.Variant_constraints) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, this.f1655a);
                    this.f1655a = resourceId;
                    String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                    context.getResources().getResourceName(resourceId);
                    if ("layout".equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.f1656a = constraintSet;
                        constraintSet.e((ConstraintLayout) LayoutInflater.from(context).inflate(resourceId, (ViewGroup) null));
                    }
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
    public ConstraintLayoutStates(android.content.Context r8, androidx.constraintlayout.widget.ConstraintLayout r9, int r10) {
        /*
            r7 = this;
            r7.<init>()
            r0 = -1
            r7.a = r0
            r7.b = r0
            android.util.SparseArray r1 = new android.util.SparseArray
            r1.<init>()
            r7.f1650a = r1
            android.util.SparseArray r1 = new android.util.SparseArray
            r1.<init>()
            r7.f1652b = r1
            r1 = 0
            r7.f1651a = r9
            android.content.res.Resources r9 = r8.getResources()
            android.content.res.XmlResourceParser r9 = r9.getXml(r10)
            int r10 = r9.getEventType()     // Catch:{ XmlPullParserException -> 0x00a2, IOException -> 0x009d }
        L_0x0025:
            r2 = 1
            if (r10 == r2) goto L_0x00a6
            if (r10 == 0) goto L_0x0095
            r3 = 2
            if (r10 == r3) goto L_0x002f
            goto L_0x0098
        L_0x002f:
            java.lang.String r10 = r9.getName()     // Catch:{ XmlPullParserException -> 0x00a2, IOException -> 0x009d }
            int r4 = r10.hashCode()     // Catch:{ XmlPullParserException -> 0x00a2, IOException -> 0x009d }
            r5 = 4
            r6 = 3
            switch(r4) {
                case -1349929691: goto L_0x0064;
                case 80204913: goto L_0x005a;
                case 1382829617: goto L_0x0051;
                case 1657696882: goto L_0x0047;
                case 1901439077: goto L_0x003d;
                default: goto L_0x003c;
            }     // Catch:{ XmlPullParserException -> 0x00a2, IOException -> 0x009d }
        L_0x003c:
            goto L_0x006e
        L_0x003d:
            java.lang.String r2 = "Variant"
            boolean r10 = r10.equals(r2)     // Catch:{ XmlPullParserException -> 0x00a2, IOException -> 0x009d }
            if (r10 == 0) goto L_0x006e
            r2 = r6
            goto L_0x006f
        L_0x0047:
            java.lang.String r2 = "layoutDescription"
            boolean r10 = r10.equals(r2)     // Catch:{ XmlPullParserException -> 0x00a2, IOException -> 0x009d }
            if (r10 == 0) goto L_0x006e
            r2 = 0
            goto L_0x006f
        L_0x0051:
            java.lang.String r4 = "StateSet"
            boolean r10 = r10.equals(r4)     // Catch:{ XmlPullParserException -> 0x00a2, IOException -> 0x009d }
            if (r10 == 0) goto L_0x006e
            goto L_0x006f
        L_0x005a:
            java.lang.String r2 = "State"
            boolean r10 = r10.equals(r2)     // Catch:{ XmlPullParserException -> 0x00a2, IOException -> 0x009d }
            if (r10 == 0) goto L_0x006e
            r2 = r3
            goto L_0x006f
        L_0x0064:
            java.lang.String r2 = "ConstraintSet"
            boolean r10 = r10.equals(r2)     // Catch:{ XmlPullParserException -> 0x00a2, IOException -> 0x009d }
            if (r10 == 0) goto L_0x006e
            r2 = r5
            goto L_0x006f
        L_0x006e:
            r2 = r0
        L_0x006f:
            if (r2 == r3) goto L_0x0087
            if (r2 == r6) goto L_0x007a
            if (r2 == r5) goto L_0x0076
            goto L_0x0098
        L_0x0076:
            r7.a(r8, r9)     // Catch:{ XmlPullParserException -> 0x00a2, IOException -> 0x009d }
            goto L_0x0098
        L_0x007a:
            androidx.constraintlayout.widget.ConstraintLayoutStates$b r10 = new androidx.constraintlayout.widget.ConstraintLayoutStates$b     // Catch:{ XmlPullParserException -> 0x00a2, IOException -> 0x009d }
            r10.<init>(r8, r9)     // Catch:{ XmlPullParserException -> 0x00a2, IOException -> 0x009d }
            if (r1 == 0) goto L_0x0098
            java.util.ArrayList<androidx.constraintlayout.widget.ConstraintLayoutStates$b> r2 = r1.f1654a     // Catch:{ XmlPullParserException -> 0x00a2, IOException -> 0x009d }
            r2.add(r10)     // Catch:{ XmlPullParserException -> 0x00a2, IOException -> 0x009d }
            goto L_0x0098
        L_0x0087:
            androidx.constraintlayout.widget.ConstraintLayoutStates$a r10 = new androidx.constraintlayout.widget.ConstraintLayoutStates$a     // Catch:{ XmlPullParserException -> 0x00a2, IOException -> 0x009d }
            r10.<init>(r8, r9)     // Catch:{ XmlPullParserException -> 0x00a2, IOException -> 0x009d }
            android.util.SparseArray<androidx.constraintlayout.widget.ConstraintLayoutStates$a> r1 = r7.f1650a     // Catch:{ XmlPullParserException -> 0x00a2, IOException -> 0x009d }
            int r2 = r10.a     // Catch:{ XmlPullParserException -> 0x00a2, IOException -> 0x009d }
            r1.put(r2, r10)     // Catch:{ XmlPullParserException -> 0x00a2, IOException -> 0x009d }
            r1 = r10
            goto L_0x0098
        L_0x0095:
            r9.getName()     // Catch:{ XmlPullParserException -> 0x00a2, IOException -> 0x009d }
        L_0x0098:
            int r10 = r9.next()     // Catch:{ XmlPullParserException -> 0x00a2, IOException -> 0x009d }
            goto L_0x0025
        L_0x009d:
            r8 = move-exception
            r8.printStackTrace()
            goto L_0x00a6
        L_0x00a2:
            r8 = move-exception
            r8.printStackTrace()
        L_0x00a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayoutStates.<init>(android.content.Context, androidx.constraintlayout.widget.ConstraintLayout, int):void");
    }

    public final void a(Context context, XmlResourceParser xmlResourceParser) {
        int i;
        ConstraintSet constraintSet = new ConstraintSet();
        int attributeCount = xmlResourceParser.getAttributeCount();
        int i2 = 0;
        while (i2 < attributeCount) {
            String attributeName = xmlResourceParser.getAttributeName(i2);
            String attributeValue = xmlResourceParser.getAttributeValue(i2);
            if (attributeName == null || attributeValue == null || !FacebookMediationAdapter.KEY_ID.equals(attributeName)) {
                i2++;
            } else {
                if (attributeValue.contains(RemoteSettings.FORWARD_SLASH_STRING)) {
                    i = context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), FacebookMediationAdapter.KEY_ID, context.getPackageName());
                } else {
                    i = -1;
                }
                if (i == -1 && attributeValue.length() > 1) {
                    i = Integer.parseInt(attributeValue.substring(1));
                }
                constraintSet.k(context, xmlResourceParser);
                this.f1652b.put(i, constraintSet);
                return;
            }
        }
    }

    public final void b(float f, float f2, int i) {
        ConstraintSet constraintSet;
        a aVar;
        ConstraintSet constraintSet2;
        int i2 = this.a;
        SparseArray<a> sparseArray = this.f1650a;
        int i3 = 0;
        ConstraintLayout constraintLayout = this.f1651a;
        if (i2 == i) {
            if (i == -1) {
                aVar = sparseArray.valueAt(0);
            } else {
                aVar = sparseArray.get(i2);
            }
            int i4 = this.b;
            if (i4 == -1 || !aVar.f1654a.get(i4).a(f, f2)) {
                while (true) {
                    ArrayList<b> arrayList = aVar.f1654a;
                    if (i3 >= arrayList.size()) {
                        i3 = -1;
                        break;
                    } else if (arrayList.get(i3).a(f, f2)) {
                        break;
                    } else {
                        i3++;
                    }
                }
                if (this.b != i3) {
                    ArrayList<b> arrayList2 = aVar.f1654a;
                    if (i3 == -1) {
                        constraintSet2 = null;
                    } else {
                        constraintSet2 = arrayList2.get(i3).f1656a;
                    }
                    if (i3 != -1) {
                        int i5 = arrayList2.get(i3).f1655a;
                    }
                    if (constraintSet2 != null) {
                        this.b = i3;
                        constraintSet2.b(constraintLayout);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.a = i;
        a aVar2 = sparseArray.get(i);
        while (true) {
            ArrayList<b> arrayList3 = aVar2.f1654a;
            if (i3 >= arrayList3.size()) {
                i3 = -1;
                break;
            } else if (arrayList3.get(i3).a(f, f2)) {
                break;
            } else {
                i3++;
            }
        }
        ArrayList<b> arrayList4 = aVar2.f1654a;
        if (i3 == -1) {
            constraintSet = aVar2.f1653a;
        } else {
            constraintSet = arrayList4.get(i3).f1656a;
        }
        if (i3 != -1) {
            int i6 = arrayList4.get(i3).f1655a;
        }
        if (constraintSet != null) {
            this.b = i3;
            constraintSet.b(constraintLayout);
        }
    }
}
