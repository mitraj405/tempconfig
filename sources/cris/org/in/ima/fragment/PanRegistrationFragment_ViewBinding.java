package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;

public class PanRegistrationFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public PanRegistrationFragment f4885a;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ PanRegistrationFragment a;

        public a(PanRegistrationFragment panRegistrationFragment) {
            this.a = panRegistrationFragment;
        }

        public final void doClick(View view) {
            this.a.onRegisterClick();
        }
    }

    public PanRegistrationFragment_ViewBinding(PanRegistrationFragment panRegistrationFragment, View view) {
        this.f4885a = panRegistrationFragment;
        Class cls = EditText.class;
        panRegistrationFragment.panNumber = (EditText) Utils.findRequiredViewAsType(view, R.id.pan_number, "field 'panNumber'", cls);
        panRegistrationFragment.panName = (EditText) Utils.findRequiredViewAsType(view, R.id.pan_name, "field 'panName'", cls);
        panRegistrationFragment.submit = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_submit, "field 'submit'", LinearLayout.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.tv_save, "method 'onRegisterClick'");
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(panRegistrationFragment));
    }

    public final void unbind() {
        PanRegistrationFragment panRegistrationFragment = this.f4885a;
        if (panRegistrationFragment != null) {
            this.f4885a = null;
            panRegistrationFragment.panNumber = null;
            panRegistrationFragment.panName = null;
            panRegistrationFragment.submit = null;
            this.a.setOnClickListener((View.OnClickListener) null);
            this.a = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
