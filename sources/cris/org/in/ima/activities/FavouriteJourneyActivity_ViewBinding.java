package cris.org.in.ima.activities;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;

public class FavouriteJourneyActivity_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public FavouriteJourneyActivity f4177a;

    /* renamed from: a  reason: collision with other field name */
    public b f4178a;
    public View b;
    public View c;
    public View d;
    public View e;
    public View f;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ FavouriteJourneyActivity a;

        public a(FavouriteJourneyActivity favouriteJourneyActivity) {
            this.a = favouriteJourneyActivity;
        }

        public final void doClick(View view) {
            this.a.addFavouriteJourney();
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ FavouriteJourneyActivity a;

        public c(FavouriteJourneyActivity favouriteJourneyActivity) {
            this.a = favouriteJourneyActivity;
        }

        public final void doClick(View view) {
            this.a.onFromStationClick(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ FavouriteJourneyActivity a;

        public d(FavouriteJourneyActivity favouriteJourneyActivity) {
            this.a = favouriteJourneyActivity;
        }

        public final void doClick(View view) {
            this.a.onToStationClick(view);
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ FavouriteJourneyActivity a;

        public e(FavouriteJourneyActivity favouriteJourneyActivity) {
            this.a = favouriteJourneyActivity;
        }

        public final void doClick(View view) {
            this.a.onSelectClassClick(view);
        }
    }

    public class f extends DebouncingOnClickListener {
        public final /* synthetic */ FavouriteJourneyActivity a;

        public f(FavouriteJourneyActivity favouriteJourneyActivity) {
            this.a = favouriteJourneyActivity;
        }

        public final void doClick(View view) {
            this.a.onQuotaClick(view);
        }
    }

    public FavouriteJourneyActivity_ViewBinding(FavouriteJourneyActivity favouriteJourneyActivity, View view) {
        this.f4177a = favouriteJourneyActivity;
        View findRequiredView = Utils.findRequiredView(view, R.id.submit, "field 'submit' and method 'addFavouriteJourney'");
        Class cls = TextView.class;
        favouriteJourneyActivity.submit = (TextView) Utils.castView(findRequiredView, R.id.submit, "field 'submit'", cls);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(favouriteJourneyActivity));
        View findRequiredView2 = Utils.findRequiredView(view, R.id.et_train_number, "field 'et_train_number' and method 'onTrainNumberTextChanged'");
        favouriteJourneyActivity.et_train_number = (EditText) Utils.castView(findRequiredView2, R.id.et_train_number, "field 'et_train_number'", EditText.class);
        this.b = findRequiredView2;
        b bVar = new b(favouriteJourneyActivity);
        this.f4178a = bVar;
        ((TextView) findRequiredView2).addTextChangedListener(bVar);
        View findRequiredView3 = Utils.findRequiredView(view, R.id.rv_fromstn, "field 'rv_fromstn' and method 'onFromStationClick'");
        Class cls2 = RelativeLayout.class;
        favouriteJourneyActivity.rv_fromstn = (RelativeLayout) Utils.castView(findRequiredView3, R.id.rv_fromstn, "field 'rv_fromstn'", cls2);
        this.c = findRequiredView3;
        findRequiredView3.setOnClickListener(new c(favouriteJourneyActivity));
        View findRequiredView4 = Utils.findRequiredView(view, R.id.rv_tostn, "field 'rv_tostn' and method 'onToStationClick'");
        favouriteJourneyActivity.rv_tostn = (RelativeLayout) Utils.castView(findRequiredView4, R.id.rv_tostn, "field 'rv_tostn'", cls2);
        this.d = findRequiredView4;
        findRequiredView4.setOnClickListener(new d(favouriteJourneyActivity));
        View findRequiredView5 = Utils.findRequiredView(view, R.id.rv_class, "field 'rv_class' and method 'onSelectClassClick'");
        favouriteJourneyActivity.rv_class = (RelativeLayout) Utils.castView(findRequiredView5, R.id.rv_class, "field 'rv_class'", cls2);
        this.e = findRequiredView5;
        findRequiredView5.setOnClickListener(new e(favouriteJourneyActivity));
        favouriteJourneyActivity.tv_class = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_class, "field 'tv_class'", cls);
        View findRequiredView6 = Utils.findRequiredView(view, R.id.rv_quaota, "field 'rv_quaota' and method 'onQuotaClick'");
        favouriteJourneyActivity.rv_quaota = (RelativeLayout) Utils.castView(findRequiredView6, R.id.rv_quaota, "field 'rv_quaota'", cls2);
        this.f = findRequiredView6;
        findRequiredView6.setOnClickListener(new f(favouriteJourneyActivity));
        favouriteJourneyActivity.tv_quota = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_quota, "field 'tv_quota'", cls);
        favouriteJourneyActivity.tv_fromstan = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_fromstan, "field 'tv_fromstan'", cls);
        favouriteJourneyActivity.tv_tostan = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tostan, "field 'tv_tostan'", cls);
    }

    public final void unbind() {
        FavouriteJourneyActivity favouriteJourneyActivity = this.f4177a;
        if (favouriteJourneyActivity != null) {
            this.f4177a = null;
            favouriteJourneyActivity.submit = null;
            favouriteJourneyActivity.et_train_number = null;
            favouriteJourneyActivity.rv_fromstn = null;
            favouriteJourneyActivity.rv_tostn = null;
            favouriteJourneyActivity.rv_class = null;
            favouriteJourneyActivity.tv_class = null;
            favouriteJourneyActivity.rv_quaota = null;
            favouriteJourneyActivity.tv_quota = null;
            favouriteJourneyActivity.tv_fromstan = null;
            favouriteJourneyActivity.tv_tostan = null;
            this.a.setOnClickListener((View.OnClickListener) null);
            this.a = null;
            ((TextView) this.b).removeTextChangedListener(this.f4178a);
            this.f4178a = null;
            this.b = null;
            this.c.setOnClickListener((View.OnClickListener) null);
            this.c = null;
            this.d.setOnClickListener((View.OnClickListener) null);
            this.d = null;
            this.e.setOnClickListener((View.OnClickListener) null);
            this.e = null;
            this.f.setOnClickListener((View.OnClickListener) null);
            this.f = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }

    public class b implements TextWatcher {
        public final /* synthetic */ FavouriteJourneyActivity a;

        public b(FavouriteJourneyActivity favouriteJourneyActivity) {
            this.a = favouriteJourneyActivity;
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.a.onTrainNumberTextChanged(charSequence, i, i2, i3);
        }

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
