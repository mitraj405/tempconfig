package cris.org.in.ima.activities;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.drawerlayout.widget.DrawerLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;

public class HomeActivity_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public HomeActivity f4200a;
    public View b;
    public View c;
    public View d;
    public View e;
    public View f;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ HomeActivity a;

        public a(HomeActivity homeActivity) {
            this.a = homeActivity;
        }

        public final void doClick(View view) {
            this.a.onClickMoreDrawer(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ HomeActivity a;

        public b(HomeActivity homeActivity) {
            this.a = homeActivity;
        }

        public final void doClick(View view) {
            this.a.setMyAccount(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ HomeActivity a;

        public c(HomeActivity homeActivity) {
            this.a = homeActivity;
        }

        public final void doClick(View view) {
            this.a.setMyTransaction(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ HomeActivity a;

        public d(HomeActivity homeActivity) {
            this.a = homeActivity;
        }

        public final void doClick(View view) {
            this.a.setHome(view);
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ HomeActivity a;

        public e(HomeActivity homeActivity) {
            this.a = homeActivity;
        }

        public final void doClick(View view) {
            this.a.clckAmazonCart(view);
        }
    }

    public class f extends DebouncingOnClickListener {
        public final /* synthetic */ HomeActivity a;

        public f(HomeActivity homeActivity) {
            this.a = homeActivity;
        }

        public final void doClick(View view) {
            this.a.onBackArrowClick();
        }
    }

    public HomeActivity_ViewBinding(HomeActivity homeActivity, View view) {
        this.f4200a = homeActivity;
        homeActivity.drawerLayout = (DrawerLayout) Utils.findRequiredViewAsType(view, R.id.drawer_layout, "field 'drawerLayout'", DrawerLayout.class);
        Class cls = ImageView.class;
        homeActivity.homeimage = (ImageView) Utils.findRequiredViewAsType(view, R.id.home_image, "field 'homeimage'", cls);
        Class cls2 = TextView.class;
        homeActivity.hometext = (TextView) Utils.findRequiredViewAsType(view, R.id.home_text, "field 'hometext'", cls2);
        homeActivity.myaccountimage = (ImageView) Utils.findRequiredViewAsType(view, R.id.my_account_image, "field 'myaccountimage'", cls);
        homeActivity.myaccounttext = (TextView) Utils.findRequiredViewAsType(view, R.id.my_account_text, "field 'myaccounttext'", cls2);
        homeActivity.transactionitext = (TextView) Utils.findRequiredViewAsType(view, R.id.transaction_text, "field 'transactionitext'", cls2);
        homeActivity.transactionimaqe = (ImageView) Utils.findRequiredViewAsType(view, R.id.transaction_imaqe, "field 'transactionimaqe'", cls);
        homeActivity.moretext = (TextView) Utils.findRequiredViewAsType(view, R.id.more_text, "field 'moretext'", cls2);
        homeActivity.moreimage = (ImageView) Utils.findRequiredViewAsType(view, R.id.more_image, "field 'moreimage'", cls);
        View findRequiredView = Utils.findRequiredView(view, R.id.more_drawer, "method 'onClickMoreDrawer'");
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(homeActivity));
        View findRequiredView2 = Utils.findRequiredView(view, R.id.myaccount_ll, "method 'setMyAccount'");
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new b(homeActivity));
        View findRequiredView3 = Utils.findRequiredView(view, R.id.transaction_ll, "method 'setMyTransaction'");
        this.c = findRequiredView3;
        findRequiredView3.setOnClickListener(new c(homeActivity));
        View findRequiredView4 = Utils.findRequiredView(view, R.id.home_11, "method 'setHome'");
        this.d = findRequiredView4;
        findRequiredView4.setOnClickListener(new d(homeActivity));
        View findRequiredView5 = Utils.findRequiredView(view, R.id.amazon_shopping_cart_ll, "method 'clckAmazonCart'");
        this.e = findRequiredView5;
        findRequiredView5.setOnClickListener(new e(homeActivity));
        View findRequiredView6 = Utils.findRequiredView(view, R.id.back, "method 'onBackArrowClick'");
        this.f = findRequiredView6;
        findRequiredView6.setOnClickListener(new f(homeActivity));
    }

    public final void unbind() {
        HomeActivity homeActivity = this.f4200a;
        if (homeActivity != null) {
            this.f4200a = null;
            homeActivity.drawerLayout = null;
            homeActivity.homeimage = null;
            homeActivity.hometext = null;
            homeActivity.myaccountimage = null;
            homeActivity.myaccounttext = null;
            homeActivity.transactionitext = null;
            homeActivity.transactionimaqe = null;
            homeActivity.moretext = null;
            homeActivity.moreimage = null;
            this.a.setOnClickListener((View.OnClickListener) null);
            this.a = null;
            this.b.setOnClickListener((View.OnClickListener) null);
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
}
