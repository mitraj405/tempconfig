package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.biometric.BiometricPrompt;
import androidx.biometric.j;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

/* renamed from: lc  reason: default package and case insensitive filesystem */
/* compiled from: FingerprintDialogFragment */
public class C0258lc extends DialogFragment {
    public final Handler a = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with other field name */
    public ImageView f3083a;

    /* renamed from: a  reason: collision with other field name */
    public TextView f3084a;

    /* renamed from: a  reason: collision with other field name */
    public j f3085a;

    /* renamed from: a  reason: collision with other field name */
    public final a f3086a = new a();
    public int c;
    public int d;

    /* renamed from: lc$a */
    /* compiled from: FingerprintDialogFragment */
    public class a implements Runnable {
        public a() {
        }

        public final void run() {
            C0258lc lcVar = C0258lc.this;
            Context context = lcVar.getContext();
            if (context != null) {
                lcVar.f3085a.g(1);
                lcVar.f3085a.f(context.getString(Wr.fingerprint_dialog_touch_sensor));
            }
        }
    }

    /* renamed from: lc$b */
    /* compiled from: FingerprintDialogFragment */
    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            C0258lc.this.f3085a.h(true);
        }
    }

    /* renamed from: lc$c */
    /* compiled from: FingerprintDialogFragment */
    public static class c {
        public static void a(Drawable drawable) {
            if (drawable instanceof AnimatedVectorDrawable) {
                ((AnimatedVectorDrawable) drawable).start();
            }
        }
    }

    /* renamed from: lc$d */
    /* compiled from: FingerprintDialogFragment */
    public static class d {
        public static int a() {
            return C0138ar.colorError;
        }
    }

    public final int f(int i) {
        Context context = getContext();
        FragmentActivity activity = getActivity();
        if (context == null || activity == null) {
            return 0;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(typedValue.data, new int[]{i});
        int color = obtainStyledAttributes.getColor(0, 0);
        obtainStyledAttributes.recycle();
        return color;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        j jVar = this.f3085a;
        if (jVar.f == null) {
            jVar.f = new MutableLiveData<>();
        }
        j.i(jVar.f, Boolean.TRUE);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            j jVar = (j) new ViewModelProvider(activity).a(j.class);
            this.f3085a = jVar;
            if (jVar.g == null) {
                jVar.g = new MutableLiveData<>();
            }
            jVar.g.d(this, new C0271mc(this));
            j jVar2 = this.f3085a;
            if (jVar2.h == null) {
                jVar2.h = new MutableLiveData<>();
            }
            jVar2.h.d(this, new C0279nc(this));
        }
        this.c = f(d.a());
        this.d = f(16842808);
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        CharSequence charSequence;
        CharSequence charSequence2;
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        BiometricPrompt.d dVar = this.f3085a.f1296a;
        if (dVar != null) {
            charSequence = dVar.a;
        } else {
            charSequence = null;
        }
        builder.setTitle(charSequence);
        View inflate = LayoutInflater.from(builder.getContext()).inflate(Qr.fingerprint_dialog_layout, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(Hr.fingerprint_subtitle);
        if (textView != null) {
            this.f3085a.getClass();
            if (TextUtils.isEmpty((CharSequence) null)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText((CharSequence) null);
            }
        }
        TextView textView2 = (TextView) inflate.findViewById(Hr.fingerprint_description);
        if (textView2 != null) {
            this.f3085a.getClass();
            if (TextUtils.isEmpty((CharSequence) null)) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
                textView2.setText((CharSequence) null);
            }
        }
        this.f3083a = (ImageView) inflate.findViewById(Hr.fingerprint_icon);
        this.f3084a = (TextView) inflate.findViewById(Hr.fingerprint_error);
        if (androidx.biometric.c.a(this.f3085a.c())) {
            charSequence2 = getString(Wr.confirm_device_credential_password);
        } else {
            charSequence2 = this.f3085a.d();
        }
        builder.setNegativeButton(charSequence2, (DialogInterface.OnClickListener) new b());
        builder.setView(inflate);
        AlertDialog create = builder.create();
        create.setCanceledOnTouchOutside(false);
        return create;
    }

    public final void onPause() {
        super.onPause();
        this.a.removeCallbacksAndMessages((Object) null);
    }

    public final void onResume() {
        super.onResume();
        j jVar = this.f3085a;
        jVar.b = 0;
        jVar.g(1);
        this.f3085a.f(getString(Wr.fingerprint_dialog_touch_sensor));
    }
}
