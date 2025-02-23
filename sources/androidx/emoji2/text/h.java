package androidx.emoji2.text;

import android.graphics.Typeface;
import android.util.SparseArray;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;

/* compiled from: MetadataRepo */
public final class h {
    public final Typeface a;

    /* renamed from: a  reason: collision with other field name */
    public final a f2028a = new a(UserMetadata.MAX_ATTRIBUTE_SIZE);

    /* renamed from: a  reason: collision with other field name */
    public final ll f2029a;

    /* renamed from: a  reason: collision with other field name */
    public final char[] f2030a;

    /* compiled from: MetadataRepo */
    public static class a {
        public final SparseArray<a> a;

        /* renamed from: a  reason: collision with other field name */
        public C0287oa f2031a;

        public a() {
            this(1);
        }

        public final void a(C0287oa oaVar, int i, int i2) {
            a aVar;
            int a2 = oaVar.a(i);
            SparseArray<a> sparseArray = this.a;
            if (sparseArray == null) {
                aVar = null;
            } else {
                aVar = sparseArray.get(a2);
            }
            if (aVar == null) {
                aVar = new a();
                sparseArray.put(oaVar.a(i), aVar);
            }
            if (i2 > i) {
                aVar.a(oaVar, i + 1, i2);
            } else {
                aVar.f2031a = oaVar;
            }
        }

        public a(int i) {
            this.a = new SparseArray<>(i);
        }
    }

    public h(Typeface typeface, ll llVar) {
        int i;
        int i2;
        int i3;
        boolean z;
        this.a = typeface;
        this.f2029a = llVar;
        int a2 = llVar.a(6);
        if (a2 != 0) {
            int i4 = a2 + llVar.a;
            i = llVar.f3207a.getInt(llVar.f3207a.getInt(i4) + i4);
        } else {
            i = 0;
        }
        this.f2030a = new char[(i * 2)];
        int a3 = llVar.a(6);
        if (a3 != 0) {
            int i5 = a3 + llVar.a;
            i2 = llVar.f3207a.getInt(llVar.f3207a.getInt(i5) + i5);
        } else {
            i2 = 0;
        }
        for (int i6 = 0; i6 < i2; i6++) {
            C0287oa oaVar = new C0287oa(this, i6);
            kl c = oaVar.c();
            int a4 = c.a(4);
            if (a4 != 0) {
                i3 = c.f3207a.getInt(a4 + c.a);
            } else {
                i3 = 0;
            }
            Character.toChars(i3, this.f2030a, i6 * 2);
            if (oaVar.b() > 0) {
                z = true;
            } else {
                z = false;
            }
            C1354qp.q(z, "invalid metadata codepoint length");
            this.f2028a.a(oaVar, 0, oaVar.b() - 1);
        }
    }
}
