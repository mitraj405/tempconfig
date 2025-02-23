package cris.org.in.ima.adaptors;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.ima.model.OtherPreferenceModel;
import cris.org.in.prs.ima.R;
import java.util.List;

public class OtherPreferenceLapwiseAdapter extends RecyclerView.Adapter<OtherItemHolder> {
    private static final String TAG = C1354qp.R(OtherPreferenceLapwiseAdapter.class);
    /* access modifiers changed from: private */
    public OtherOptionAdapterListener listener;
    private Context mContext;
    private List<OtherPreferenceModel> otherPreferenceModellist;

    public class OtherItemHolder extends RecyclerView.ViewHolder {
        @BindView(2131362038)
        LinearLayout berthchoise_option_ll;
        OtherPreferenceModel item;
        @BindView(2131363528)
        TextView prefence;

        public OtherItemHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
        }

        @OnClick({2131362038})
        public void otherPrefrenceClick(View view) {
            if (OtherPreferenceLapwiseAdapter.this.listener != null) {
                OtherPreferenceLapwiseAdapter.this.listener.onItemClick(this.item);
            }
        }
    }

    public class OtherItemHolder_ViewBinding implements Unbinder {
        private OtherItemHolder target;
        private View view7f0a00f6;

        public OtherItemHolder_ViewBinding(final OtherItemHolder otherItemHolder, View view) {
            this.target = otherItemHolder;
            View findRequiredView = Utils.findRequiredView(view, R.id.berthchoise_option_ll, "field 'berthchoise_option_ll' and method 'otherPrefrenceClick'");
            otherItemHolder.berthchoise_option_ll = (LinearLayout) Utils.castView(findRequiredView, R.id.berthchoise_option_ll, "field 'berthchoise_option_ll'", LinearLayout.class);
            this.view7f0a00f6 = findRequiredView;
            findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    otherItemHolder.otherPrefrenceClick(view);
                }
            });
            otherItemHolder.prefence = (TextView) Utils.findRequiredViewAsType(view, R.id.prefence, "field 'prefence'", TextView.class);
        }

        public void unbind() {
            OtherItemHolder otherItemHolder = this.target;
            if (otherItemHolder != null) {
                this.target = null;
                otherItemHolder.berthchoise_option_ll = null;
                otherItemHolder.prefence = null;
                this.view7f0a00f6.setOnClickListener((View.OnClickListener) null);
                this.view7f0a00f6 = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public interface OtherOptionAdapterListener {
        void onItemClick(OtherPreferenceModel otherPreferenceModel);
    }

    public OtherPreferenceLapwiseAdapter(Context context, List<OtherPreferenceModel> list, OtherOptionAdapterListener otherOptionAdapterListener) {
        this.mContext = context;
        this.listener = otherOptionAdapterListener;
        this.otherPreferenceModellist = list;
    }

    private void setTextViewDrawableColor(TextView textView, int i) {
        for (Drawable drawable : textView.getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(this.mContext.getResources().getColor(i), PorterDuff.Mode.SRC_IN));
            }
        }
    }

    public int getItemCount() {
        return this.otherPreferenceModellist.size();
    }

    public OtherItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View r = C1058d.r(viewGroup, R.layout.item_other_preference_lapwise, (ViewGroup) null);
        OtherItemHolder otherItemHolder = new OtherItemHolder(r);
        xx.O(-1, -2, r);
        return otherItemHolder;
    }

    public void onBindViewHolder(OtherItemHolder otherItemHolder, int i) {
        OtherPreferenceModel otherPreferenceModel = this.otherPreferenceModellist.get(i);
        otherItemHolder.item = otherPreferenceModel;
        otherItemHolder.prefence.setText(otherPreferenceModel.a.getDesc());
        if (otherPreferenceModel.f5339a) {
            otherItemHolder.prefence.setSelected(true);
            setTextViewDrawableColor(otherItemHolder.prefence, R.color.dark);
            otherItemHolder.prefence.setTextAppearance(this.mContext, R.style.fontForbold);
            return;
        }
        otherItemHolder.prefence.setSelected(false);
        setTextViewDrawableColor(otherItemHolder.prefence, R.color.white);
        otherItemHolder.prefence.setTextAppearance(this.mContext, R.style.fontForNormal);
    }
}
