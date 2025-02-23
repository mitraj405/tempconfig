package defpackage;

import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.internal.ads.zzea;
import cris.org.in.ima.fragment.NewBookingFragment;
import java.util.ArrayList;
import java.util.HashSet;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.crypto.digests.MD4Digest;
import org.spongycastle.crypto.digests.RIPEMD160Digest;
import org.spongycastle.crypto.digests.RIPEMD320Digest;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;

/* renamed from: lf  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class lf {
    public static /* synthetic */ String A(int i) {
        if (i == 1) {
            return "BEGIN_ARRAY";
        }
        if (i == 2) {
            return "END_ARRAY";
        }
        if (i == 3) {
            return "BEGIN_OBJECT";
        }
        if (i == 4) {
            return "END_OBJECT";
        }
        if (i == 5) {
            return "NAME";
        }
        if (i == 6) {
            return "STRING";
        }
        if (i == 7) {
            return "NUMBER";
        }
        if (i == 8) {
            return "BOOLEAN";
        }
        if (i == 9) {
            return "NULL";
        }
        if (i == 10) {
            return "END_DOCUMENT";
        }
        return "null";
    }

    public static /* synthetic */ String B(int i) {
        if (i == 1) {
            return "PRE_COMP";
        }
        if (i == 2) {
            return "SOLID";
        }
        if (i == 3) {
            return "IMAGE";
        }
        if (i == 4) {
            return "NULL";
        }
        if (i == 5) {
            return "SHAPE";
        }
        if (i == 6) {
            return "TEXT";
        }
        if (i == 7) {
            return "UNKNOWN";
        }
        return "null";
    }

    public static /* synthetic */ String C(int i) {
        if (i == 1) {
            return "PRIMITIVE";
        }
        if (i == 2) {
            return "CONSTRUCTED";
        }
        return "null";
    }

    public static int[] _values() {
        return xx.X(8);
    }

    public static float a(float f, float f2, float f3, float f4) {
        return ((f - f2) * f3) + f4;
    }

    public static int b(int i, int i2, int i3, MD4Digest mD4Digest, int i4) {
        return mD4Digest.p(i + i2 + i3, i4);
    }

    public static int c(int i, int i2, int i3, RIPEMD160Digest rIPEMD160Digest, int i4, int i5) {
        return rIPEMD160Digest.n(i + i2 + i3, i4) + i5;
    }

    public static int d(int i, int i2, int i3, RIPEMD320Digest rIPEMD320Digest, int i4, int i5) {
        return rIPEMD320Digest.n(i + i2 + i3, i4) + i5;
    }

    public static int e(EditText editText) {
        return editText.getText().toString().length();
    }

    public static int f(String str, int i) {
        return String.valueOf(str).length() + i;
    }

    public static int g(String str, int i, int i2) {
        return (str.hashCode() + i) * i2;
    }

    public static String h(String str, int i) {
        return str + i;
    }

    public static String i(String str, int i, String str2, int i2) {
        return str + i + str2 + i2;
    }

    public static String j(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String k(StringBuilder sb, int i, String str) {
        sb.append(i);
        sb.append(str);
        return sb.toString();
    }

    public static String l(StringBuilder sb, long j, String str) {
        sb.append(j);
        sb.append(str);
        return sb.toString();
    }

    public static StringBuilder m(String str, int i, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder n(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder o(String str, String str2, ConfigurableProvider configurableProvider, String str3, String str4) {
        configurableProvider.b(str3, str.concat(str2));
        return new StringBuilder(str4);
    }

    public static ASN1ObjectIdentifier p(String str) {
        return new ASN1ObjectIdentifier(str).v();
    }

    public static /* bridge */ /* synthetic */ void q(int i, int i2, Class cls) {
        throw null;
    }

    public static void r(Context context, int i, EditText editText) {
        editText.setBackground(context.getResources().getDrawable(i));
    }

    public static void s(EditText editText) {
        editText.setText(editText.getText().toString());
    }

    public static void t(NewBookingFragment newBookingFragment, int i, TextView textView) {
        textView.setTextColor(newBookingFragment.getResources().getColor(i));
    }

    public static /* bridge */ /* synthetic */ void u(Object obj) {
        throw null;
    }

    public static void v(String str, int i, ArrayList arrayList) {
        arrayList.add(new C0503FA(str, i));
    }

    public static void w(String str, String str2, String str3) {
        zzea.zzf(str3, str2.concat(String.valueOf(str)));
    }

    public static void x(StringBuilder sb, String str, TextView textView) {
        sb.append(str);
        textView.setText(sb.toString());
    }

    public static void y(HashSet hashSet, String str, String str2, String str3, String str4) {
        hashSet.add(str);
        hashSet.add(str2);
        hashSet.add(str3);
        hashSet.add(str4);
    }

    public static /* synthetic */ String z(int i) {
        if (i == 1) {
            return "UNIVERSAL";
        }
        if (i == 2) {
            return "APPLICATION";
        }
        if (i == 3) {
            return "CONTEXT_SPECIFIC";
        }
        if (i == 4) {
            return "PRIVATE";
        }
        return "null";
    }
}
