package cris.org.in.ima.adaptors;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.ima.model.PnrModel;
import cris.org.in.prs.ima.R;
import java.util.ArrayList;

public class FavoritepnrAdaptor extends RecyclerView.Adapter<ViewHolder> {
    /* access modifiers changed from: private */
    public PnrListAdapterStnSelectListener listAdapterStnSelectListener;
    private ArrayList<PnrModel> pnrList;

    public interface PnrListAdapterStnSelectListener {
        void onDeleteClick(PnrModel pnrModel);

        void onPnrClick(PnrModel pnrModel);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(2131364380)
        TextView dojNumber;
        @BindView(2131364402)
        TextView pnrNumber;
        @BindView(2131363508)
        TextView pnr_delete;
        @BindView(2131363726)
        RelativeLayout relativeLayout;
        PnrModel tkt;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
        }

        @OnClick({2131363508})
        public void onDeleteClick(View view) {
            FavoritepnrAdaptor.this.listAdapterStnSelectListener.onDeleteClick(this.tkt);
        }

        @OnClick({2131363726})
        public void onPnrClick(View view) {
            FavoritepnrAdaptor.this.listAdapterStnSelectListener.onPnrClick(this.tkt);
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;
        private View view7f0a06b4;
        private View view7f0a078e;

        public ViewHolder_ViewBinding(final ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            Class cls = TextView.class;
            viewHolder.pnrNumber = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_fav_pnr, "field 'pnrNumber'", cls);
            View findRequiredView = Utils.findRequiredView(view, R.id.pnr_delete, "field 'pnr_delete' and method 'onDeleteClick'");
            viewHolder.pnr_delete = (TextView) Utils.castView(findRequiredView, R.id.pnr_delete, "field 'pnr_delete'", cls);
            this.view7f0a06b4 = findRequiredView;
            findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    viewHolder.onDeleteClick(view);
                }
            });
            viewHolder.dojNumber = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_doj_pnr, "field 'dojNumber'", cls);
            View findRequiredView2 = Utils.findRequiredView(view, R.id.rl_favlist_pnr, "field 'relativeLayout' and method 'onPnrClick'");
            viewHolder.relativeLayout = (RelativeLayout) Utils.castView(findRequiredView2, R.id.rl_favlist_pnr, "field 'relativeLayout'", RelativeLayout.class);
            this.view7f0a078e = findRequiredView2;
            findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    viewHolder.onPnrClick(view);
                }
            });
        }

        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder != null) {
                this.target = null;
                viewHolder.pnrNumber = null;
                viewHolder.pnr_delete = null;
                viewHolder.dojNumber = null;
                viewHolder.relativeLayout = null;
                this.view7f0a06b4.setOnClickListener((View.OnClickListener) null);
                this.view7f0a06b4 = null;
                this.view7f0a078e.setOnClickListener((View.OnClickListener) null);
                this.view7f0a078e = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public FavoritepnrAdaptor(Context context, PnrListAdapterStnSelectListener pnrListAdapterStnSelectListener, ArrayList<PnrModel> arrayList) {
        this.pnrList = arrayList;
        this.listAdapterStnSelectListener = pnrListAdapterStnSelectListener;
    }

    public int getItemCount() {
        return this.pnrList.size();
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View s = C1058d.s(viewGroup, R.layout.favorite_pnr_list, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(s);
        xx.O(-1, -2, s);
        return viewHolder;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        PnrModel pnrModel = this.pnrList.get(i);
        viewHolder.tkt = pnrModel;
        TextView textView = viewHolder.pnrNumber;
        textView.setText(pnrModel.a + "   |");
        viewHolder.dojNumber.setText(pnrModel.b);
        viewHolder.pnr_delete.setTag(Integer.valueOf(i));
    }
}
