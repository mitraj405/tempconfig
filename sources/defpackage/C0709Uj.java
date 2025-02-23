package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Parcel;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.transition.Transition;
import com.google.android.datatransport.Transformer;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzea;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import cris.org.in.ima.fragment.PassengerDetailFragment;
import cris.org.in.ima.fragment.ReviewMetroJourneyFragment;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.crypto.digests.RIPEMD160Digest;
import org.spongycastle.crypto.digests.RIPEMD320Digest;

/* renamed from: Uj  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0709Uj implements Transition.TransitionNotification, LibraryVersionComponent.VersionExtractor, Transformer, SuccessContinuation {
    public static /* synthetic */ int a(int i) {
        if (i == 1) {
            return 1;
        }
        if (i == 2) {
            return 2;
        }
        throw null;
    }

    public static int c(int i, int i2, RIPEMD160Digest rIPEMD160Digest, int i3, int i4) {
        return rIPEMD160Digest.n(i + i2, i3) + i4;
    }

    public static int d(int i, int i2, RIPEMD320Digest rIPEMD320Digest, int i3, int i4) {
        return rIPEMD320Digest.n(i + i2, i3) + i4;
    }

    public static IObjectWrapper e(Parcel parcel) {
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
        parcel.recycle();
        return asInterface;
    }

    public static String f(int i, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb.toString();
    }

    public static String g(IOException iOException, StringBuilder sb) {
        sb.append(iOException.getMessage());
        return sb.toString();
    }

    public static String h(String str, long j) {
        return str + j;
    }

    public static String i(String str, String str2) {
        return str + str2;
    }

    public static String j(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static String k(ASN1Sequence aSN1Sequence, StringBuilder sb) {
        sb.append(aSN1Sequence.size());
        return sb.toString();
    }

    public static /* synthetic */ Iterator l() {
        try {
            return Arrays.asList(new C0695Tj[]{new B0()}).iterator();
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }

    public static short m(EditText editText) {
        return Short.parseShort(editText.getText().toString());
    }

    public static void n(int i, HashMap hashMap, String str, int i2, String str2, int i3, String str3, int i4, String str4) {
        hashMap.put(str, Integer.valueOf(i));
        hashMap.put(str2, Integer.valueOf(i2));
        hashMap.put(str3, Integer.valueOf(i3));
        hashMap.put(str4, Integer.valueOf(i4));
    }

    public static void o(PassengerDetailFragment passengerDetailFragment, int i, EditText editText) {
        editText.setBackgroundColor(passengerDetailFragment.getResources().getColor(i));
    }

    public static void p(PassengerDetailFragment passengerDetailFragment, int i, LinearLayout linearLayout) {
        linearLayout.setBackgroundColor(passengerDetailFragment.getResources().getColor(i));
    }

    public static void q(PassengerDetailFragment passengerDetailFragment, int i, FragmentActivity fragmentActivity, String str, DialogInterface.OnClickListener onClickListener) {
        C0535I5.o(fragmentActivity, str, passengerDetailFragment.getString(i), onClickListener).show();
    }

    public static void r(ReviewMetroJourneyFragment reviewMetroJourneyFragment, int i, TextView textView) {
        textView.setText(reviewMetroJourneyFragment.getActivity().getResources().getString(i));
    }

    public static /* bridge */ /* synthetic */ void s(Object obj, int i, int i2, int i3) {
        throw null;
    }

    public static void t(String str, int i, String str2) {
        zzea.zzf(str2, str + i);
    }

    public static boolean u(String str) {
        C1073dl.a();
        return C1073dl.b().containsKey(str);
    }

    public static /* synthetic */ String v(int i) {
        if (i == 1) {
            return "MERGE";
        }
        if (i == 2) {
            return "ADD";
        }
        if (i == 3) {
            return "SUBTRACT";
        }
        if (i == 4) {
            return "INTERSECT";
        }
        if (i == 5) {
            return "EXCLUDE_INTERSECTIONS";
        }
        return "null";
    }

    public static /* synthetic */ String w(int i) {
        if (i == 1) {
            return "RUN_AS_NON_EXPEDITED_WORK_REQUEST";
        }
        if (i == 2) {
            return "DROP_WORK_REQUEST";
        }
        return "null";
    }

    public static /* synthetic */ String x(int i) {
        if (i == 1) {
            return "BINARY";
        }
        if (i == 2) {
            return "NUMERIC";
        }
        if (i == 3) {
            return "TEXT";
        }
        if (i == 4) {
            return "MIXED";
        }
        if (i == 5) {
            return "DOL";
        }
        if (i == 6) {
            return "TEMPLATE";
        }
        return "null";
    }

    public Object apply(Object obj) {
        return ((MessagingClientEventExtension) obj).toByteArray();
    }

    public void b(Transition.TransitionListener transitionListener, Transition transition, boolean z) {
        transitionListener.onTransitionCancel(transition);
    }

    public String extract(Object obj) {
        return FirebaseCommonRegistrar.lambda$getComponents$2((Context) obj);
    }

    public Task then(Object obj) {
        return Tasks.forResult(null);
    }
}
