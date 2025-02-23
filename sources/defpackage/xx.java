package defpackage;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import cris.org.in.ima.IrctcImaApplication;
import cris.org.in.ima.fragment.DelhiMetroFragment;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.digests.MD5Digest;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.pqc.crypto.xmss.DefaultXMSSMTOid;

/* renamed from: xx  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class xx {
    public static final /* synthetic */ int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40};

    public static String A(int i, String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        return sb.toString();
    }

    public static String B(EditText editText) {
        return editText.getText().toString().trim();
    }

    public static String C(String str, Fragment fragment, String str2) {
        return str + fragment + str2;
    }

    public static String D(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String E(String str, String str2, ConfigurableProvider configurableProvider, String str3, String str4) {
        configurableProvider.b(str3, str.concat(str2));
        return str.concat(str4);
    }

    public static String F(String str, StringBuilder sb) {
        return str + sb;
    }

    public static String G(StringBuilder sb, boolean z, String str) {
        sb.append(z);
        sb.append(str);
        return sb.toString();
    }

    public static String H(CipherParameters cipherParameters, String str) {
        return str.concat(cipherParameters.getClass().getName());
    }

    public static StringBuilder I(int i, String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        return sb;
    }

    public static StringBuilder J(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static StringBuilder K(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    public static /* synthetic */ Iterator L() {
        try {
            return Arrays.asList(new C1364r7[]{new C0()}).iterator();
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }

    public static ASN1EncodableVector M(ASN1Encodable aSN1Encodable, ASN1Encodable aSN1Encodable2) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(aSN1Encodable);
        aSN1EncodableVector.a(aSN1Encodable2);
        return aSN1EncodableVector;
    }

    public static ECFieldElement N(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return eCFieldElement.o().a(eCFieldElement2).a(eCFieldElement3);
    }

    public static void O(int i, int i2, View view) {
        view.setLayoutParams(new RecyclerView.LayoutParams(i, i2));
    }

    public static void P(Context context, int i, TextView textView) {
        textView.setText(context.getResources().getString(i));
    }

    public static void Q(DelhiMetroFragment delhiMetroFragment, int i, TextView textView) {
        textView.setText(delhiMetroFragment.getActivity().getResources().getString(i));
    }

    public static void R(String str, HashMap hashMap, String str2) {
        hashMap.put(str2, new DefaultXMSSMTOid(str));
    }

    public static void S(Throwable th, boolean z, Throwable th2) {
        th.getClass();
        th.getMessage();
        Lt.a(z, th2);
    }

    public static boolean T(EditText editText, String str) {
        return editText.getText().toString().equals(str);
    }

    public static /* synthetic */ String U(int i) {
        if (i == 1) {
            return "HANDICAP";
        }
        if (i == 2) {
            return "ESCORT";
        }
        if (i == 3) {
            return "GENERAL";
        }
        if (i == 4) {
            return "PRESSC";
        }
        if (i == 5) {
            return "PRESSS";
        }
        if (i == 6) {
            return "PRESCH";
        }
        if (i == 7) {
            return "PRESCO";
        }
        if (i == 8) {
            return "MPPASS";
        }
        if (i == 9) {
            return "MPSPOS";
        }
        if (i == 10) {
            return "MPCOMP";
        }
        if (i == 11) {
            return "MPBLES";
        }
        if (i == 12) {
            return "EXMP";
        }
        if (i == 13) {
            return "EXCOMP";
        }
        if (i == 14) {
            return "MPNTSP";
        }
        throw null;
    }

    public static /* synthetic */ int V(int i) {
        if (i != 0) {
            return i - 1;
        }
        throw null;
    }

    public static /* synthetic */ String W(int i) {
        if (i == 1) {
            return "EXPONENTIAL";
        }
        if (i == 2) {
            return "LINEAR";
        }
        return "null";
    }

    public static /* synthetic */ int[] X(int i) {
        int[] iArr = new int[i];
        System.arraycopy(a, 0, iArr, 0, i);
        return iArr;
    }

    public static int[] _values() {
        return X(13);
    }

    public static int[] _values$1() {
        return X(14);
    }

    public static final String a(int i) {
        if (IrctcImaApplication.e.equalsIgnoreCase("hi")) {
            return q(i);
        }
        return o(i);
    }

    public static final String b(int i) {
        return p(i);
    }

    public static final String c(int i) {
        return t(i);
    }

    public static final String d(int i) {
        if (IrctcImaApplication.e.equalsIgnoreCase("hi")) {
            return v(i);
        }
        return u(i);
    }

    public static String e(String str) {
        int[] _values = _values();
        int length = _values.length;
        int i = 0;
        while (i < length) {
            int i2 = _values[i];
            if (!k(i2).equalsIgnoreCase(str)) {
                i++;
            } else if (IrctcImaApplication.e.equalsIgnoreCase("hi")) {
                return m(i2);
            } else {
                return l(i2);
            }
        }
        return null;
    }

    public static int f(String str) {
        for (int i : X(4)) {
            if (o(i).equals(str) || (q(i).equals(str) && IrctcImaApplication.e.equalsIgnoreCase("hi"))) {
                return i;
            }
        }
        return 0;
    }

    public static int g(String str) {
        for (int i : _values$1()) {
            if (p(i).equals(str)) {
                return i;
            }
        }
        return 0;
    }

    public static int h(String str) {
        for (int i : X(5)) {
            if ((IrctcImaApplication.e.equalsIgnoreCase("hi") && r(i).equals(str)) || n(i).equals(str)) {
                return i;
            }
        }
        return 0;
    }

    public static int i(String str) {
        for (int i : _values$1()) {
            if (t(i).equals(str)) {
                return i;
            }
        }
        return 0;
    }

    public static int j(int i) {
        for (int i2 : X(4)) {
            if (V(i2) == i) {
                return i2;
            }
        }
        return 0;
    }

    public static /* synthetic */ String k(int i) {
        if (i == 1) {
            return "EA";
        }
        if (i == 2) {
            return "1A";
        }
        if (i == 3) {
            return "2A";
        }
        if (i == 4) {
            return "3A";
        }
        if (i == 5) {
            return "CC";
        }
        if (i == 6) {
            return "3E";
        }
        if (i == 7) {
            return "EC";
        }
        if (i == 8) {
            return "SL";
        }
        if (i == 9) {
            return "FC";
        }
        if (i == 10) {
            return "2S";
        }
        if (i == 11) {
            return "VS";
        }
        if (i == 12) {
            return "VC";
        }
        if (i == 13) {
            return "EV";
        }
        throw null;
    }

    public static /* synthetic */ String l(int i) {
        if (i == 1) {
            return "Anubhuti Class";
        }
        if (i == 2) {
            return "AC First Class";
        }
        if (i == 3) {
            return "AC 2 Tier";
        }
        if (i == 4) {
            return "AC 3 Tier";
        }
        if (i == 5) {
            return "AC Chair car";
        }
        if (i == 6) {
            return "AC 3 Economy";
        }
        if (i == 7) {
            return "Exec. Chair Car";
        }
        if (i == 8) {
            return "Sleeper";
        }
        if (i == 9) {
            return "First Class";
        }
        if (i == 10) {
            return "Second Sitting";
        }
        if (i == 11) {
            return "Vistadome Non AC";
        }
        if (i == 12) {
            return "Vistadome Chair Car";
        }
        if (i == 13) {
            return "Vistadome AC";
        }
        throw null;
    }

    public static /* synthetic */ String m(int i) {
        if (i == 1) {
            return "अनुभूति श्रेणी";
        }
        if (i == 2) {
            return "एसी प्रथम श्रेणी";
        }
        if (i == 3) {
            return "एसी 2 श्रेणी";
        }
        if (i == 4) {
            return "एसी 3 श्रेणी";
        }
        if (i == 5) {
            return "एसी चेयर कार";
        }
        if (i == 6) {
            return "AC 3 Economy";
        }
        if (i == 7) {
            return "कार्यकारी कुर्सी कार";
        }
        if (i == 8) {
            return "शयनयान";
        }
        if (i == 9) {
            return "प्रथम श्रेणी";
        }
        if (i == 10) {
            return "द्वितीय सीटिंग";
        }
        if (i == 11) {
            return "Vistadome Non AC";
        }
        if (i == 12) {
            return "Vistadome Chair Car";
        }
        if (i == 13) {
            return "Vistadome AC";
        }
        throw null;
    }

    public static /* synthetic */ String n(int i) {
        if (i == 1) {
            return "Annual Transaction Details";
        }
        if (i == 2) {
            return "IRCTC Transaction Details";
        }
        if (i == 3) {
            return "IRCTC Bought Points Details";
        }
        if (i == 4) {
            return "SBI Co-brand Credit Card Details";
        }
        if (i == 5) {
            return "Redemption Details";
        }
        throw null;
    }

    public static /* synthetic */ String o(int i) {
        if (i == 1) {
            return "Option for Senior Citizen Concession";
        }
        if (i == 2) {
            return "Avail Concession";
        }
        if (i == 3) {
            return "Forgo 50% concession";
        }
        if (i == 4) {
            return "Forgo Full Concession";
        }
        throw null;
    }

    public static /* synthetic */ String p(int i) {
        if (i == 1) {
            return "HANDICAP";
        }
        if (i == 2) {
            return "ESCORT";
        }
        if (i == 3) {
            return "GENERAL";
        }
        if (i == 4) {
            return "PRESSC";
        }
        if (i == 5) {
            return "PRESSS";
        }
        if (i == 6) {
            return "PRESCH";
        }
        if (i == 7) {
            return "PRESCO";
        }
        if (i == 8) {
            return "MPPASS";
        }
        if (i == 9) {
            return "MPSPOS";
        }
        if (i == 10) {
            return "MPCOMP";
        }
        if (i == 11) {
            return "MPBLES";
        }
        if (i == 12) {
            return "EXMP";
        }
        if (i == 13) {
            return "EXCOMP";
        }
        if (i == 14) {
            return "MPNTSP";
        }
        throw null;
    }

    public static /* synthetic */ String q(int i) {
        if (i == 1) {
            return "Option for Senior Citizen Concession";
        }
        if (i == 2) {
            return "छूट प्राप्त करें";
        }
        if (i == 3) {
            return "50% छूट छोड़ो";
        }
        if (i == 4) {
            return "पूर्ण छूट छोड़ो";
        }
        throw null;
    }

    public static /* synthetic */ String r(int i) {
        if (i == 1) {
            return "वार्षिक लेनदेन विवरण";
        }
        if (i == 2) {
            return "आईआरसीटीसी लेनदेन विवरण";
        }
        if (i == 3) {
            return "आईआरसीटीसी से खरीदे गए अंकों का विवरण";
        }
        if (i == 4) {
            return "एसबीआई को-ब्रांड क्रेडिट कार्ड विवरण";
        }
        if (i == 5) {
            return "रिडेम्पशन विवरण";
        }
        throw null;
    }

    public static /* synthetic */ long s(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 3) {
            return 2;
        }
        if (i == 4) {
            return 3;
        }
        if (i == 5) {
            return 4;
        }
        throw null;
    }

    public static /* synthetic */ String t(int i) {
        if (i == 1) {
            return "Person with disability";
        }
        if (i == 2) {
            return "Escort";
        }
        if (i == 3) {
            return "General";
        }
        if (i == 4) {
            return "Press Person";
        }
        if (i == 5) {
            return "Press Spouse";
        }
        if (i == 6) {
            return "Press Child";
        }
        if (i == 7) {
            return "Press Companion";
        }
        if (i == 8) {
            return "MP";
        }
        if (i == 9) {
            return "MP/EX-MP SPOUSE";
        }
        if (i == 10) {
            return "MP COMPANION";
        }
        if (i == 11) {
            return "BLIND MP ESCORT";
        }
        if (i == 12) {
            return "EX-MP";
        }
        if (i == 13) {
            return "EX-MP COMPANION";
        }
        if (i == 14) {
            return "MP LIEU SPOUSE";
        }
        throw null;
    }

    public static /* synthetic */ String u(int i) {
        if (i == 1) {
            return "Edit child";
        }
        if (i == 2) {
            return " Confirm Cancel";
        }
        if (i == 3) {
            return "OPT Meal post booking";
        }
        if (i == 4) {
            return "Change Boarding";
        }
        if (i == 5) {
            return "Opt Vikalp Train";
        }
        if (i == 6) {
            return "Change Vikalp Train";
        }
        if (i == 7) {
            return "Test Bank Verify";
        }
        throw null;
    }

    public static /* synthetic */ String v(int i) {
        if (i == 1) {
            return "Edit child";
        }
        if (i == 2) {
            return "रद्द करने की पुष्टि करें";
        }
        if (i == 3) {
            return "खाना बुक करें";
        }
        if (i == 4) {
            return "Change Boarding";
        }
        if (i == 5) {
            return "विकल्प का चयन करें";
        }
        if (i == 6) {
            return "Change Vikalp Train";
        }
        if (i == 7) {
            return "Test Bank Verify";
        }
        throw null;
    }

    public static /* synthetic */ int w(int i) {
        if (i == 1) {
            return 1;
        }
        if (i == 2) {
            return 2;
        }
        if (i == 3) {
            return 3;
        }
        if (i == 4) {
            return 4;
        }
        if (i == 5) {
            return 5;
        }
        throw null;
    }

    public static /* synthetic */ int x(int i) {
        if (i == 1) {
            return 1;
        }
        if (i == 2) {
            return 2;
        }
        if (i == 3) {
            return -1;
        }
        if (i == 4) {
            return 3;
        }
        if (i == 5) {
            return 4;
        }
        if (i == 6) {
            return 5;
        }
        if (i == 7) {
            return 6;
        }
        if (i == 8) {
            return 7;
        }
        if (i == 9) {
            return 8;
        }
        if (i == 10) {
            return 9;
        }
        if (i == 11) {
            return 10;
        }
        if (i == 12) {
            return 11;
        }
        if (i == 13) {
            return 12;
        }
        if (i == 14) {
            return 13;
        }
        throw null;
    }

    public static int y(int i, int i2, int i3, MD5Digest mD5Digest, int i4, int i5) {
        return mD5Digest.o(i + i2 + i3, i4) + i5;
    }

    public static int z(int i, int i2, String str) {
        return Integer.parseInt(str.substring(i + i2));
    }
}
