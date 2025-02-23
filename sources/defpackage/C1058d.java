package defpackage;

import android.content.Context;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.Transition;
import com.google.android.datatransport.Transformer;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.proto.AtProtobuf;
import com.google.firebase.messaging.FcmBroadcastProcessor;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import cris.org.in.ima.IrctcImaApplication;
import cris.prs.webservices.dto.DmrcstatsionDto;
import defpackage.C0114a9;
import java.nio.charset.Charset;
import java.util.List;
import okhttp3.Dns;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;

/* renamed from: d  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C1058d implements C0114a9.a, Transition.TransitionNotification, TextInputLayout.LengthCounter, LibraryVersionComponent.VersionExtractor, Transformer, Continuation, SuccessContinuation, Dns {
    public static String A(String str, String str2, String str3, String str4, String str5) {
        return str + str2 + str3 + str4 + str5;
    }

    public static String B(StringBuilder sb, String str, String str2, String str3) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb.toString();
    }

    public static StringBuilder C(String str, int i, String str2, int i2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i);
        sb.append(str2);
        sb.append(i2);
        sb.append(str3);
        return sb;
    }

    public static StringBuilder D(StringBuilder sb, ASN1ObjectIdentifier aSN1ObjectIdentifier, ConfigurableProvider configurableProvider, String str, String str2) {
        sb.append(aSN1ObjectIdentifier);
        configurableProvider.b(sb.toString(), str);
        return new StringBuilder(str2);
    }

    public static ASN1EncodableVector E(ASN1Encodable aSN1Encodable) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(aSN1Encodable);
        return aSN1EncodableVector;
    }

    public static ASN1EncodableVector F(ASN1Encodable aSN1Encodable, ASN1Encodable aSN1Encodable2, ASN1Encodable aSN1Encodable3) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(aSN1Encodable);
        aSN1EncodableVector.a(aSN1Encodable2);
        aSN1EncodableVector.a(aSN1Encodable3);
        return aSN1EncodableVector;
    }

    public static void G(int i, String str, TextView textView) {
        textView.setText(i + str);
    }

    public static void H(Context context, int i, TextView textView) {
        textView.setTextColor(context.getResources().getColor(i));
    }

    public static void I(StringBuilder sb, ASN1ObjectIdentifier aSN1ObjectIdentifier, ConfigurableProvider configurableProvider, String str) {
        sb.append(aSN1ObjectIdentifier);
        configurableProvider.b(sb.toString(), str);
    }

    public static void J(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str, String str2, String str3, String str4) {
        aSN1ObjectIdentifier.q(str);
        aSN1ObjectIdentifier.q(str2);
        aSN1ObjectIdentifier.q(str3);
        aSN1ObjectIdentifier.q(str4);
    }

    public static boolean K(DmrcstatsionDto dmrcstatsionDto) {
        return String.valueOf(dmrcstatsionDto.getDmrclinecolorcode()).isEmpty();
    }

    public static int L(int i, int i2, int i3, int i4) {
        return ((i * i2) / i3) + i4;
    }

    public static String M(Exception exc, StringBuilder sb) {
        sb.append(exc.getMessage());
        return sb.toString();
    }

    public static /* synthetic */ String N(int i) {
        if (i == 1) {
            return "SUSPEND";
        }
        if (i == 2) {
            return "DROP_OLDEST";
        }
        if (i == 3) {
            return "DROP_LATEST";
        }
        return "null";
    }

    public static /* synthetic */ String O(int i) {
        if (i == 1) {
            return "UNKNOWN";
        }
        if (i == 2) {
            return "HORIZONTAL_DIMENSION";
        }
        if (i == 3) {
            return "VERTICAL_DIMENSION";
        }
        if (i == 4) {
            return "LEFT";
        }
        if (i == 5) {
            return "RIGHT";
        }
        if (i == 6) {
            return "TOP";
        }
        if (i == 7) {
            return "BOTTOM";
        }
        if (i == 8) {
            return "BASELINE";
        }
        return "null";
    }

    public static int[] _values() {
        return xx.X(40);
    }

    public static final int c(int i) {
        return o(i);
    }

    public static int d(int i) {
        for (int i2 : _values()) {
            if (i == h(i2)) {
                return i2;
            }
        }
        return 0;
    }

    public static String e(String str) {
        for (int i : xx.X(5)) {
            if (IrctcImaApplication.e.equalsIgnoreCase("hi")) {
                if (j(i).equals(str)) {
                    return k(i);
                }
            } else if (i(i).equals(str)) {
                return k(i);
            }
        }
        return null;
    }

    public static String f(String str) {
        int[] X = xx.X(5);
        int length = X.length;
        int i = 0;
        while (i < length) {
            int i2 = X[i];
            if (!k(i2).equals(str)) {
                i++;
            } else if (IrctcImaApplication.e.equalsIgnoreCase("hi")) {
                return j(i2);
            } else {
                return i(i2);
            }
        }
        return null;
    }

    public static int g(String str) {
        for (int i : xx.X(7)) {
            if (l(i).equalsIgnoreCase(str)) {
                return i;
            }
        }
        return 0;
    }

    public static /* synthetic */ int h(int i) {
        if (i == 1) {
            return 73;
        }
        if (i == 2) {
            return 99;
        }
        if (i == 3) {
            return 1000;
        }
        if (i == 4) {
            return 74;
        }
        if (i == 5) {
            return 77;
        }
        if (i == 6) {
            return 76;
        }
        if (i == 7) {
            return 91;
        }
        if (i == 8) {
            return 95;
        }
        if (i == 9) {
            return 106;
        }
        if (i == 10) {
            return 101;
        }
        if (i == 11) {
            return 108;
        }
        if (i == 12) {
            return 111;
        }
        if (i == 13) {
            return 118;
        }
        if (i == 14) {
            return 119;
        }
        if (i == 15) {
            return 120;
        }
        if (i == 16) {
            return 104;
        }
        if (i == 17) {
            return 121;
        }
        if (i == 18) {
            return 122;
        }
        if (i == 19) {
            return 124;
        }
        if (i == 20) {
            return 125;
        }
        if (i == 21) {
            return 127;
        }
        if (i == 22) {
            return 131;
        }
        if (i == 23) {
            return 133;
        }
        if (i == 24) {
            return 135;
        }
        if (i == 25) {
            return 101;
        }
        if (i == 26) {
            return 102;
        }
        if (i == 27) {
            return 103;
        }
        if (i == 28) {
            return 104;
        }
        if (i == 29) {
            return 105;
        }
        if (i == 30) {
            return 138;
        }
        if (i == 31) {
            return 139;
        }
        if (i == 32) {
            return 140;
        }
        if (i == 33) {
            return 144;
        }
        if (i == 34) {
            return 141;
        }
        if (i == 35) {
            return 142;
        }
        if (i == 36) {
            return 147;
        }
        if (i == 37) {
            return 152;
        }
        if (i == 38) {
            return 154;
        }
        if (i == 39) {
            return 156;
        }
        if (i == 40) {
            return 148;
        }
        throw null;
    }

    public static /* synthetic */ String i(int i) {
        if (i == 1) {
            return "SBI Bank Loyalty Credit Card";
        }
        if (i == 2) {
            return "BOB Bank Loyalty Credit Card";
        }
        if (i == 3) {
            return "HDFC Bank Loyalty Credit Card";
        }
        if (i == 4) {
            return "OGAONE Loyalty  Card";
        }
        if (i == 5) {
            return "KOTAK Bank Loyalty  Card";
        }
        throw null;
    }

    public static /* synthetic */ String j(int i) {
        if (i == 1) {
            return "आईआरसीटीसी एसबीआई क्रेडिट कार्ड";
        }
        if (i == 2) {
            return "आईआरसीटीसी बैंक ऑफ बड़ौदा क्रेडिट कार्ड";
        }
        if (i == 3) {
            return "HDFC Bank Loyalty Credit Card";
        }
        if (i == 4) {
            return "OGAONE Loyalty  Card";
        }
        if (i == 5) {
            return "KOTAK Bank Loyalty  Card";
        }
        throw null;
    }

    public static /* synthetic */ String k(int i) {
        if (i == 1) {
            return "101";
        }
        if (i == 2) {
            return "102";
        }
        if (i == 3) {
            return "103";
        }
        if (i == 4) {
            return "104";
        }
        if (i == 5) {
            return "105";
        }
        throw null;
    }

    public static /* synthetic */ String l(int i) {
        if (i == 1) {
            return "SRCTZN";
        }
        if (i == 2) {
            return "PSRCTN";
        }
        if (i == 3) {
            return "SRCTNW";
        }
        if (i == 4) {
            return "PSRCTW";
        }
        if (i == 5) {
            return "NOCONC";
        }
        if (i == 6) {
            return "SRCTZT";
        }
        if (i == 7) {
            return "PSRCTT";
        }
        throw null;
    }

    public static /* synthetic */ int m(int i) {
        if (i == 1) {
            return 13;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 3) {
            return 7;
        }
        if (i == 4 || i == 5 || i == 6 || i == 7 || i == 8 || i == 9 || i == 10 || i == 11 || i == 12 || i == 13 || i == 14) {
            return 13;
        }
        if (i == 15) {
            return 59;
        }
        if (i == 16 || i == 17) {
            return 13;
        }
        if (i == 18 || i == 19 || i == 20) {
            return 59;
        }
        if (i == 21 || i == 22 || i == 23 || i == 24) {
            return 13;
        }
        if (i == 25 || i == 26 || i == 27 || i == 28 || i == 29) {
            return 14;
        }
        if (i == 30 || i == 31 || i == 32 || i == 33 || i == 34) {
            return 13;
        }
        if (i == 35) {
            return 59;
        }
        if (i == 36 || i == 37 || i == 38 || i == 39) {
            return 13;
        }
        if (i == 40) {
            return 59;
        }
        throw null;
    }

    public static /* synthetic */ String n(int i) {
        if (i == 1) {
            return "W";
        }
        if (i == 2) {
            return "R";
        }
        if (i == 3) {
            return "C";
        }
        throw null;
    }

    public static /* synthetic */ int o(int i) {
        if (i == 1) {
            return 1;
        }
        if (i == 2) {
            return 2;
        }
        if (i == 3) {
            return 1;
        }
        if (i == 4) {
            return 2;
        }
        if (i == 5) {
            return 3;
        }
        if (i == 6) {
            return 1;
        }
        if (i == 7) {
            return 2;
        }
        throw null;
    }

    public static /* synthetic */ String p(int i) {
        if (i == 1) {
            return "WL";
        }
        if (i == 2) {
            return "RAC";
        }
        if (i == 3) {
            return "CNF";
        }
        throw null;
    }

    public static int q(int i, int i2, int i3, int i4) {
        return i + i2 + i3 + i4;
    }

    public static View r(ViewGroup viewGroup, int i, ViewGroup viewGroup2) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup2);
    }

    public static View s(ViewGroup viewGroup, int i, ViewGroup viewGroup2, boolean z) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup2, z);
    }

    public static FieldDescriptor t(int i, FieldDescriptor.Builder builder) {
        return builder.withProperty(AtProtobuf.builder().tag(i).build()).build();
    }

    public static String u(int i, String str, int i2) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(i2);
        return sb.toString();
    }

    public static String v(int i, String str, String str2) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static String w(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.exceptionLabel());
        return sb.toString();
    }

    public static String x(Exception exc, StringBuilder sb) {
        sb.append(exc.toString());
        return sb.toString();
    }

    public static String y(String str, int i, String str2) {
        return str + i + str2;
    }

    public static String z(String str, String str2) {
        return str + str2;
    }

    public Object apply(Object obj) {
        return DataTransportCrashlyticsReportSender.TRANSFORM.reportToJson((CrashlyticsReport) obj).getBytes(Charset.forName("UTF-8"));
    }

    public void b(Transition.TransitionListener transitionListener, Transition transition, boolean z) {
        transitionListener.onTransitionEnd(transition, z);
    }

    public int countLength(Editable editable) {
        return TextInputLayout.lambda$new$0(editable);
    }

    public String extract(Object obj) {
        return FirebaseCommonRegistrar.lambda$getComponents$1((Context) obj);
    }

    public List lookup(String str) {
        return Dns.lambda$static$0(str);
    }

    public Task then(Object obj) {
        return Tasks.forResult(null);
    }

    public Object then(Task task) {
        return FcmBroadcastProcessor.lambda$startMessagingService$1(task);
    }
}
