package defpackage;

import android.database.Cursor;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* renamed from: rz  reason: default package */
/* compiled from: TableInfo */
public final class rz {
    public final String a;

    /* renamed from: a  reason: collision with other field name */
    public final Map<String, a> f3230a;

    /* renamed from: a  reason: collision with other field name */
    public final Set<b> f3231a;
    public final Set<d> b;

    /* renamed from: rz$a */
    /* compiled from: TableInfo */
    public static class a {
        public final int a;

        /* renamed from: a  reason: collision with other field name */
        public final String f3232a;

        /* renamed from: a  reason: collision with other field name */
        public final boolean f3233a;
        public final int b;

        /* renamed from: b  reason: collision with other field name */
        public final String f3234b;
        public final int c;

        /* renamed from: c  reason: collision with other field name */
        public final String f3235c;

        public a(int i, String str, String str2, String str3, boolean z, int i2) {
            this.f3232a = str;
            this.f3234b = str2;
            this.f3233a = z;
            this.b = i;
            int i3 = 5;
            if (str2 != null) {
                String upperCase = str2.toUpperCase(Locale.US);
                if (upperCase.contains("INT")) {
                    i3 = 3;
                } else if (upperCase.contains("CHAR") || upperCase.contains("CLOB") || upperCase.contains("TEXT")) {
                    i3 = 2;
                } else if (!upperCase.contains("BLOB")) {
                    i3 = (upperCase.contains("REAL") || upperCase.contains("FLOA") || upperCase.contains("DOUB")) ? 4 : 1;
                }
            }
            this.a = i3;
            this.f3235c = str3;
            this.c = i2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.b != aVar.b || !this.f3232a.equals(aVar.f3232a) || this.f3233a != aVar.f3233a) {
                return false;
            }
            String str = this.f3235c;
            int i = this.c;
            int i2 = aVar.c;
            String str2 = aVar.f3235c;
            if (i == 1 && i2 == 2 && str != null && !str.equals(str2)) {
                return false;
            }
            if (i == 2 && i2 == 1 && str2 != null && !str2.equals(str)) {
                return false;
            }
            if (i != 0 && i == i2 && (str == null ? str2 != null : !str.equals(str2))) {
                return false;
            }
            if (this.a == aVar.a) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            int i;
            int hashCode = ((this.f3232a.hashCode() * 31) + this.a) * 31;
            if (this.f3233a) {
                i = 1231;
            } else {
                i = 1237;
            }
            return ((hashCode + i) * 31) + this.b;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("Column{name='");
            sb.append(this.f3232a);
            sb.append("', type='");
            sb.append(this.f3234b);
            sb.append("', affinity='");
            sb.append(this.a);
            sb.append("', notNull=");
            sb.append(this.f3233a);
            sb.append(", primaryKeyPosition=");
            sb.append(this.b);
            sb.append(", defaultValue='");
            return C0709Uj.j(sb, this.f3235c, "'}");
        }
    }

    /* renamed from: rz$b */
    /* compiled from: TableInfo */
    public static class b {
        public final String a;

        /* renamed from: a  reason: collision with other field name */
        public final List<String> f3236a;
        public final String b;

        /* renamed from: b  reason: collision with other field name */
        public final List<String> f3237b;
        public final String c;

        public b(String str, String str2, String str3, List<String> list, List<String> list2) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.f3236a = Collections.unmodifiableList(list);
            this.f3237b = Collections.unmodifiableList(list2);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.a.equals(bVar.a) && this.b.equals(bVar.b) && this.c.equals(bVar.c) && this.f3236a.equals(bVar.f3236a)) {
                return this.f3237b.equals(bVar.f3237b);
            }
            return false;
        }

        public final int hashCode() {
            int g = lf.g(this.c, lf.g(this.b, this.a.hashCode() * 31, 31), 31);
            return this.f3237b.hashCode() + ((this.f3236a.hashCode() + g) * 31);
        }

        public final String toString() {
            return "ForeignKey{referenceTable='" + this.a + "', onDelete='" + this.b + "', onUpdate='" + this.c + "', columnNames=" + this.f3236a + ", referenceColumnNames=" + this.f3237b + '}';
        }
    }

    /* renamed from: rz$c */
    /* compiled from: TableInfo */
    public static class c implements Comparable<c> {
        public final int c;

        /* renamed from: c  reason: collision with other field name */
        public final String f3238c;
        public final int d;

        /* renamed from: d  reason: collision with other field name */
        public final String f3239d;

        public c(int i, int i2, String str, String str2) {
            this.c = i;
            this.d = i2;
            this.f3238c = str;
            this.f3239d = str2;
        }

        public final int compareTo(Object obj) {
            c cVar = (c) obj;
            int i = this.c - cVar.c;
            if (i == 0) {
                return this.d - cVar.d;
            }
            return i;
        }
    }

    /* renamed from: rz$d */
    /* compiled from: TableInfo */
    public static class d {
        public final String a;

        /* renamed from: a  reason: collision with other field name */
        public final List<String> f3240a;

        /* renamed from: a  reason: collision with other field name */
        public final boolean f3241a;

        public d(List list, String str, boolean z) {
            this.a = str;
            this.f3241a = z;
            this.f3240a = list;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            if (this.f3241a != dVar.f3241a || !this.f3240a.equals(dVar.f3240a)) {
                return false;
            }
            String str = this.a;
            boolean startsWith = str.startsWith("index_");
            String str2 = dVar.a;
            if (startsWith) {
                return str2.startsWith("index_");
            }
            return str.equals(str2);
        }

        public final int hashCode() {
            int i;
            String str = this.a;
            if (str.startsWith("index_")) {
                i = -1184239155;
            } else {
                i = str.hashCode();
            }
            return this.f3240a.hashCode() + (((i * 31) + (this.f3241a ? 1 : 0)) * 31);
        }

        public final String toString() {
            return "Index{name='" + this.a + "', unique=" + this.f3241a + ", columns=" + this.f3240a + '}';
        }
    }

    public rz(String str, HashMap hashMap, HashSet hashSet, HashSet hashSet2) {
        Set<d> set;
        this.a = str;
        this.f3230a = Collections.unmodifiableMap(hashMap);
        this.f3231a = Collections.unmodifiableSet(hashSet);
        if (hashSet2 == null) {
            set = null;
        } else {
            set = Collections.unmodifiableSet(hashSet2);
        }
        this.b = set;
    }

    /* JADX INFO: finally extract failed */
    public static rz a(C0408yd ydVar, String str) {
        HashSet hashSet;
        boolean z;
        int i;
        ArrayList arrayList;
        int i2;
        int i3;
        boolean z2;
        C0408yd ydVar2 = ydVar;
        String str2 = str;
        Cursor h = ydVar2.h("PRAGMA table_info(`" + str2 + "`)");
        HashMap hashMap = new HashMap();
        try {
            if (h.getColumnCount() > 0) {
                int columnIndex = h.getColumnIndex(AppMeasurementSdk.ConditionalUserProperty.NAME);
                int columnIndex2 = h.getColumnIndex("type");
                int columnIndex3 = h.getColumnIndex("notnull");
                int columnIndex4 = h.getColumnIndex("pk");
                int columnIndex5 = h.getColumnIndex("dflt_value");
                while (h.moveToNext()) {
                    String string = h.getString(columnIndex);
                    String string2 = h.getString(columnIndex2);
                    if (h.getInt(columnIndex3) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    a aVar = r14;
                    a aVar2 = new a(h.getInt(columnIndex4), string, string2, h.getString(columnIndex5), z2, 2);
                    hashMap.put(string, aVar2);
                }
            }
            h.close();
            HashSet hashSet2 = new HashSet();
            Cursor h2 = ydVar2.h("PRAGMA foreign_key_list(`" + str2 + "`)");
            try {
                int columnIndex6 = h2.getColumnIndex(FacebookMediationAdapter.KEY_ID);
                int columnIndex7 = h2.getColumnIndex("seq");
                int columnIndex8 = h2.getColumnIndex("table");
                int columnIndex9 = h2.getColumnIndex("on_delete");
                int columnIndex10 = h2.getColumnIndex("on_update");
                ArrayList b2 = b(h2);
                int count = h2.getCount();
                int i4 = 0;
                while (i4 < count) {
                    h2.moveToPosition(i4);
                    if (h2.getInt(columnIndex7) != 0) {
                        i3 = columnIndex6;
                        i2 = columnIndex7;
                        arrayList = b2;
                        i = count;
                    } else {
                        int i5 = h2.getInt(columnIndex6);
                        i3 = columnIndex6;
                        ArrayList arrayList2 = new ArrayList();
                        i2 = columnIndex7;
                        ArrayList arrayList3 = new ArrayList();
                        Iterator it = b2.iterator();
                        while (it.hasNext()) {
                            ArrayList arrayList4 = b2;
                            c cVar = (c) it.next();
                            int i6 = count;
                            if (cVar.c == i5) {
                                arrayList2.add(cVar.f3238c);
                                arrayList3.add(cVar.f3239d);
                            }
                            b2 = arrayList4;
                            count = i6;
                        }
                        arrayList = b2;
                        i = count;
                        hashSet2.add(new b(h2.getString(columnIndex8), h2.getString(columnIndex9), h2.getString(columnIndex10), arrayList2, arrayList3));
                    }
                    i4++;
                    columnIndex6 = i3;
                    columnIndex7 = i2;
                    b2 = arrayList;
                    count = i;
                }
                h2.close();
                Cursor h3 = ydVar2.h("PRAGMA index_list(`" + str2 + "`)");
                try {
                    int columnIndex11 = h3.getColumnIndex(AppMeasurementSdk.ConditionalUserProperty.NAME);
                    int columnIndex12 = h3.getColumnIndex("origin");
                    int columnIndex13 = h3.getColumnIndex("unique");
                    if (columnIndex11 != -1 && columnIndex12 != -1) {
                        if (columnIndex13 != -1) {
                            hashSet = new HashSet();
                            while (h3.moveToNext()) {
                                if ("c".equals(h3.getString(columnIndex12))) {
                                    String string3 = h3.getString(columnIndex11);
                                    if (h3.getInt(columnIndex13) == 1) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    d c2 = c(ydVar2, string3, z);
                                    if (c2 != null) {
                                        hashSet.add(c2);
                                    }
                                }
                            }
                            h3.close();
                            return new rz(str2, hashMap, hashSet2, hashSet);
                        }
                    }
                    h3.close();
                    hashSet = null;
                    return new rz(str2, hashMap, hashSet2, hashSet);
                } catch (Throwable th) {
                    h3.close();
                    throw th;
                }
            } catch (Throwable th2) {
                h2.close();
                throw th2;
            }
        } catch (Throwable th3) {
            h.close();
            throw th3;
        }
    }

    public static ArrayList b(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex(FacebookMediationAdapter.KEY_ID);
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex(Constants.MessagePayloadKeys.FROM);
        int columnIndex4 = cursor.getColumnIndex("to");
        int count = cursor.getCount();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < count; i++) {
            cursor.moveToPosition(i);
            arrayList.add(new c(cursor.getInt(columnIndex), cursor.getInt(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4)));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    /* JADX INFO: finally extract failed */
    public static d c(C0408yd ydVar, String str, boolean z) {
        Cursor h = ydVar.h("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndex = h.getColumnIndex("seqno");
            int columnIndex2 = h.getColumnIndex("cid");
            int columnIndex3 = h.getColumnIndex(AppMeasurementSdk.ConditionalUserProperty.NAME);
            if (!(columnIndex == -1 || columnIndex2 == -1)) {
                if (columnIndex3 != -1) {
                    TreeMap treeMap = new TreeMap();
                    while (h.moveToNext()) {
                        if (h.getInt(columnIndex2) >= 0) {
                            int i = h.getInt(columnIndex);
                            treeMap.put(Integer.valueOf(i), h.getString(columnIndex3));
                        }
                    }
                    ArrayList arrayList = new ArrayList(treeMap.size());
                    arrayList.addAll(treeMap.values());
                    d dVar = new d(arrayList, str, z);
                    h.close();
                    return dVar;
                }
            }
            h.close();
            return null;
        } catch (Throwable th) {
            h.close();
            throw th;
        }
    }

    public final boolean equals(Object obj) {
        Set<d> set;
        if (this == obj) {
            return true;
        }
        if (obj == null || rz.class != obj.getClass()) {
            return false;
        }
        rz rzVar = (rz) obj;
        String str = rzVar.a;
        String str2 = this.a;
        if (str2 == null ? str != null : !str2.equals(str)) {
            return false;
        }
        Map<String, a> map = rzVar.f3230a;
        Map<String, a> map2 = this.f3230a;
        if (map2 == null ? map != null : !map2.equals(map)) {
            return false;
        }
        Set<b> set2 = rzVar.f3231a;
        Set<b> set3 = this.f3231a;
        if (set3 == null ? set2 != null : !set3.equals(set2)) {
            return false;
        }
        Set<d> set4 = this.b;
        if (set4 == null || (set = rzVar.b) == null) {
            return true;
        }
        return set4.equals(set);
    }

    public final int hashCode() {
        int i;
        int i2;
        int i3 = 0;
        String str = this.a;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        int i4 = i * 31;
        Map<String, a> map = this.f3230a;
        if (map != null) {
            i2 = map.hashCode();
        } else {
            i2 = 0;
        }
        int i5 = (i4 + i2) * 31;
        Set<b> set = this.f3231a;
        if (set != null) {
            i3 = set.hashCode();
        }
        return i5 + i3;
    }

    public final String toString() {
        return "TableInfo{name='" + this.a + "', columns=" + this.f3230a + ", foreignKeys=" + this.f3231a + ", indices=" + this.b + '}';
    }
}
