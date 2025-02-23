package cris.org.in.ima.adaptors;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.ima.model.QuotaModel;
import cris.org.in.prs.ima.R;
import java.util.List;

public class QuotaSelectionAdapter extends RecyclerView.Adapter<QuotaItemHolder> {
    /* access modifiers changed from: private */
    public QuotaSelectListener listener;
    private Context mContext;
    private List<QuotaModel> quotaModels;

    public class QuotaItemHolder extends RecyclerView.ViewHolder {
        QuotaModel item;
        @BindView(2131364549)
        TextView quota;

        public QuotaItemHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
        }

        @OnClick({2131362970})
        public void tktLayoutClick(View view) {
            if (QuotaSelectionAdapter.this.listener != null) {
                QuotaSelectionAdapter.this.listener.onQuotaClick(this.item);
            }
        }
    }

    public class QuotaItemHolder_ViewBinding implements Unbinder {
        private QuotaItemHolder target;
        private View view7f0a049a;

        public QuotaItemHolder_ViewBinding(final QuotaItemHolder quotaItemHolder, View view) {
            this.target = quotaItemHolder;
            quotaItemHolder.quota = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_quota, "field 'quota'", TextView.class);
            View findRequiredView = Utils.findRequiredView(view, R.id.layout_id, "method 'tktLayoutClick'");
            this.view7f0a049a = findRequiredView;
            findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    quotaItemHolder.tktLayoutClick(view);
                }
            });
        }

        public void unbind() {
            QuotaItemHolder quotaItemHolder = this.target;
            if (quotaItemHolder != null) {
                this.target = null;
                quotaItemHolder.quota = null;
                this.view7f0a049a.setOnClickListener((View.OnClickListener) null);
                this.view7f0a049a = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public interface QuotaSelectListener {
        void onQuotaClick(QuotaModel quotaModel);
    }

    public QuotaSelectionAdapter(Context context, List<QuotaModel> list, QuotaSelectListener quotaSelectListener) {
        this.mContext = context;
        this.listener = quotaSelectListener;
        this.quotaModels = list;
    }

    private void setTextViewDrawableColor(TextView textView, int i) {
        for (Drawable drawable : textView.getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(this.mContext.getResources().getColor(i), PorterDuff.Mode.SRC_IN));
            }
        }
    }

    public int getItemCount() {
        return this.quotaModels.size();
    }

    public QuotaItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View r = C1058d.r(viewGroup, R.layout.item_quota_selection, (ViewGroup) null);
        QuotaItemHolder quotaItemHolder = new QuotaItemHolder(r);
        xx.O(-1, -2, r);
        return quotaItemHolder;
    }

    public void onBindViewHolder(QuotaItemHolder quotaItemHolder, int i) {
        QuotaModel quotaModel = this.quotaModels.get(i);
        quotaItemHolder.item = quotaModel;
        if (quotaModel.c.equalsIgnoreCase("SS")) {
            quotaItemHolder.quota.setText(R.string.senior_citizen);
        } else {
            quotaItemHolder.quota.setText(C0535I5.s0(H9.f(quotaModel.c).a()));
        }
        if (quotaModel.a.booleanValue()) {
            quotaItemHolder.quota.setTextAppearance(this.mContext, R.style.fontForbold);
            setTextViewDrawableColor(quotaItemHolder.quota, R.color.dark);
            return;
        }
        quotaItemHolder.quota.setTextAppearance(this.mContext, R.style.fontForNormal);
        setTextViewDrawableColor(quotaItemHolder.quota, R.color.white);
    }
}
