package defpackage;

import android.content.Context;
import android.os.Handler;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cris.org.in.ima.fragment.MakeMppPaymentFragment;
import defpackage.Mv;
import java.util.ArrayList;

/* renamed from: Uw  reason: default package and case insensitive filesystem */
/* compiled from: SimpleSearchDialogCompat */
public final class C0714Uw<T extends Mv> extends C1508z2<T> {
    public Ev<T> a;

    /* renamed from: a  reason: collision with other field name */
    public Handler f3809a;

    /* renamed from: a  reason: collision with other field name */
    public EditText f3810a;

    /* renamed from: a  reason: collision with other field name */
    public ProgressBar f3811a;

    /* renamed from: a  reason: collision with other field name */
    public TextView f3812a;

    /* renamed from: a  reason: collision with other field name */
    public RecyclerView f3813a;
    public String c = "Search";
    public String d = "Find Your Bank";

    public C0714Uw(Context context, ArrayList arrayList, MakeMppPaymentFragment.a aVar) {
        super(context, arrayList);
        this.a = aVar;
        this.f7078a = new C0658Qw(this);
        this.f3809a = new Handler();
    }
}
