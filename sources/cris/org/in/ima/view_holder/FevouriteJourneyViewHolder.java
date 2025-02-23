package cris.org.in.ima.view_holder;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.db.StationDb;
import cris.org.in.ima.fragment.FevouriteJourneyFragment;
import cris.org.in.ima.fragment.NewBookingFragment;
import cris.org.in.ima.model.FevJourneyModel;
import cris.org.in.prs.ima.R;
import java.util.ArrayList;
import java.util.Objects;

public final class FevouriteJourneyViewHolder extends RecyclerView.Adapter<ViewHolder> {
    public Context a;

    /* renamed from: a  reason: collision with other field name */
    public StationDb f5403a = null;

    /* renamed from: a  reason: collision with other field name */
    public final a f5404a;

    /* renamed from: a  reason: collision with other field name */
    public final b f5405a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<FevJourneyModel> f5406a;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public FevJourneyModel a;
        @BindView(2131362647)
        ImageView fev_delete;
        @BindView(2131364418)
        TextView fromcidtyName;
        @BindView(2131363888)
        LinearLayout select_book_ll;
        @BindView(2131364667)
        TextView tocityName;
        @BindView(2131364692)
        TextView train_no;
        @BindView(2131364339)
        TextView tv_class;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
        }

        @OnClick({2131363888})
        public void onClick(View view) {
            b bVar = FevouriteJourneyViewHolder.this.f5405a;
            FevJourneyModel fevJourneyModel = this.a;
            FevouriteJourneyFragment fevouriteJourneyFragment = FevouriteJourneyFragment.this;
            fevouriteJourneyFragment.f4639a = fevJourneyModel;
            Bundle bundle = new Bundle();
            bundle.putString("fevJourneyfromcode", fevouriteJourneyFragment.f4639a.d);
            bundle.putString("fevJourneyto", fevouriteJourneyFragment.f4639a.e);
            bundle.putString("fevJourneytrainnumber", fevouriteJourneyFragment.f4639a.c);
            bundle.putString("fevJourneyjourneyclass", fevouriteJourneyFragment.f4639a.f);
            bundle.putString("fevJourneyquota", fevouriteJourneyFragment.f4639a.g);
            bundle.putBoolean("fevJourneycheck", true);
            NewBookingFragment newBookingFragment = new NewBookingFragment();
            newBookingFragment.setArguments(bundle);
            HomeActivity.n(fevouriteJourneyFragment.getActivity(), newBookingFragment, C1218kf.NEW_BOOKING.a(), Boolean.FALSE, Boolean.TRUE);
        }

        @OnClick({2131362647})
        public void onEditClick(View view) {
            a aVar = FevouriteJourneyViewHolder.this.f5404a;
            if (aVar != null) {
                String valueOf = String.valueOf(this.a.a);
                int i = FevouriteJourneyFragment.c;
                FevouriteJourneyFragment fevouriteJourneyFragment = FevouriteJourneyFragment.this;
                if (!C0535I5.O((ConnectivityManager) fevouriteJourneyFragment.getActivity().getSystemService("connectivity"), fevouriteJourneyFragment.getContext())) {
                    new Handler().postDelayed(new C0800bc(), 5000);
                } else if (!valueOf.equals("")) {
                    C0793b1 b1Var = C0793b1.a;
                    if (b1Var.f3912a != null) {
                        ProgressDialog show = ProgressDialog.show(fevouriteJourneyFragment.a, fevouriteJourneyFragment.getString(R.string.deleting_passenger), fevouriteJourneyFragment.getString(R.string.please_wait_text));
                        Objects.toString(b1Var.f3912a);
                        ((Om) C0657Qt.c(b1Var.f3912a)).h(valueOf).c(C1181iv.a()).a(E0.a()).b(new C1067dc(fevouriteJourneyFragment, show));
                    }
                }
            }
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        public View a;

        /* renamed from: a  reason: collision with other field name */
        public ViewHolder f5408a;
        public View b;

        /* compiled from: FevouriteJourneyViewHolder$ViewHolder_ViewBinding */
        public class a extends DebouncingOnClickListener {
            public final /* synthetic */ ViewHolder a;

            public a(ViewHolder viewHolder) {
                this.a = viewHolder;
            }

            public final void doClick(View view) {
                this.a.onEditClick(view);
            }
        }

        /* compiled from: FevouriteJourneyViewHolder$ViewHolder_ViewBinding */
        public class b extends DebouncingOnClickListener {
            public final /* synthetic */ ViewHolder a;

            public b(ViewHolder viewHolder) {
                this.a = viewHolder;
            }

            public final void doClick(View view) {
                this.a.onClick(view);
            }
        }

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.f5408a = viewHolder;
            Class cls = TextView.class;
            viewHolder.train_no = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_trainnumber, "field 'train_no'", cls);
            viewHolder.fromcidtyName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_fromStn_code, "field 'fromcidtyName'", cls);
            viewHolder.tocityName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_toStn_code, "field 'tocityName'", cls);
            viewHolder.tv_class = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_class, "field 'tv_class'", cls);
            View findRequiredView = Utils.findRequiredView(view, R.id.fev_delete, "field 'fev_delete' and method 'onEditClick'");
            viewHolder.fev_delete = (ImageView) Utils.castView(findRequiredView, R.id.fev_delete, "field 'fev_delete'", ImageView.class);
            this.a = findRequiredView;
            findRequiredView.setOnClickListener(new a(viewHolder));
            View findRequiredView2 = Utils.findRequiredView(view, R.id.select_book_ll, "field 'select_book_ll' and method 'onClick'");
            viewHolder.select_book_ll = (LinearLayout) Utils.castView(findRequiredView2, R.id.select_book_ll, "field 'select_book_ll'", LinearLayout.class);
            this.b = findRequiredView2;
            findRequiredView2.setOnClickListener(new b(viewHolder));
        }

        public final void unbind() {
            ViewHolder viewHolder = this.f5408a;
            if (viewHolder != null) {
                this.f5408a = null;
                viewHolder.train_no = null;
                viewHolder.fromcidtyName = null;
                viewHolder.tocityName = null;
                viewHolder.tv_class = null;
                viewHolder.fev_delete = null;
                viewHolder.select_book_ll = null;
                this.a.setOnClickListener((View.OnClickListener) null);
                this.a = null;
                this.b.setOnClickListener((View.OnClickListener) null);
                this.b = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public interface a {
    }

    public interface b {
    }

    static {
        C1354qp.R(FevouriteJourneyViewHolder.class);
    }

    public FevouriteJourneyViewHolder(ArrayList arrayList, FevouriteJourneyFragment.a aVar, FevouriteJourneyFragment.b bVar) {
        this.f5406a = arrayList;
        this.a = this.a;
        this.f5405a = aVar;
        this.f5404a = bVar;
    }

    public final int getItemCount() {
        ArrayList<FevJourneyModel> arrayList = this.f5406a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        FevJourneyModel fevJourneyModel = this.f5406a.get(i);
        this.f5403a = C0793b1.a.f3911a;
        fevJourneyModel.toString();
        viewHolder2.a = fevJourneyModel;
        TextView textView = viewHolder2.train_no;
        textView.setText(String.valueOf("(" + fevJourneyModel.c + ")"));
        viewHolder2.tv_class.setText(String.valueOf(fevJourneyModel.f));
        try {
            viewHolder2.fromcidtyName.setText(String.valueOf(this.f5403a.m(fevJourneyModel.d.split("-")[1])).trim());
            viewHolder2.tocityName.setText(String.valueOf(this.f5403a.m(fevJourneyModel.e.split("-")[1])).trim());
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View r = C1058d.r(viewGroup, R.layout.item_viewall_fevouritejourney_jppage, (ViewGroup) null);
        this.a = viewGroup.getContext();
        ViewHolder viewHolder = new ViewHolder(r);
        xx.O(-1, -2, r);
        return viewHolder;
    }
}
