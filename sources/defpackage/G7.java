package defpackage;

import android.database.Cursor;
import android.widget.Filter;

/* renamed from: G7  reason: default package */
/* compiled from: CursorFilter */
public final class G7 extends Filter {
    public final a a;

    /* renamed from: G7$a */
    /* compiled from: CursorFilter */
    public interface a {
    }

    public G7(a aVar) {
        this.a = aVar;
    }

    public final CharSequence convertResultToString(Object obj) {
        return ((Ey) this.a).d((Cursor) obj);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.widget.Filter.FilterResults performFiltering(java.lang.CharSequence r5) {
        /*
            r4 = this;
            G7$a r0 = r4.a
            Ey r0 = (defpackage.Ey) r0
            if (r5 != 0) goto L_0x0009
            java.lang.String r5 = ""
            goto L_0x0010
        L_0x0009:
            r0.getClass()
            java.lang.String r5 = r5.toString()
        L_0x0010:
            androidx.appcompat.widget.SearchView r1 = r0.f171a
            int r2 = r1.getVisibility()
            r3 = 0
            if (r2 != 0) goto L_0x002c
            int r1 = r1.getWindowVisibility()
            if (r1 == 0) goto L_0x0020
            goto L_0x002c
        L_0x0020:
            android.app.SearchableInfo r1 = r0.a     // Catch:{ RuntimeException -> 0x002c }
            android.database.Cursor r5 = r0.h(r1, r5)     // Catch:{ RuntimeException -> 0x002c }
            if (r5 == 0) goto L_0x002c
            r5.getCount()     // Catch:{ RuntimeException -> 0x002c }
            goto L_0x002d
        L_0x002c:
            r5 = r3
        L_0x002d:
            android.widget.Filter$FilterResults r0 = new android.widget.Filter$FilterResults
            r0.<init>()
            if (r5 == 0) goto L_0x003d
            int r1 = r5.getCount()
            r0.count = r1
            r0.values = r5
            goto L_0x0042
        L_0x003d:
            r5 = 0
            r0.count = r5
            r0.values = r3
        L_0x0042:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.G7.performFiltering(java.lang.CharSequence):android.widget.Filter$FilterResults");
    }

    public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        a aVar = this.a;
        Cursor cursor = ((F7) aVar).f194a;
        Object obj = filterResults.values;
        if (obj != null && obj != cursor) {
            ((Ey) aVar).c((Cursor) obj);
        }
    }
}
