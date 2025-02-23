package cris.org.in.ima.adaptors;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.ima.model.PaymentOptionModel;
import cris.org.in.prs.ima.R;
import java.util.List;

public class PaymentOptionAdapter extends RecyclerView.Adapter<PaymentOptionItemHolder> {
    private static final String TAG = C1354qp.R(PaymentOptionAdapter.class);
    /* access modifiers changed from: private */
    public PaymentOptionAdapterListener listener;
    private Context mContext;
    private List<PaymentOptionModel> paymentOptionModelsList;

    public interface PaymentOptionAdapterListener {
        void onItemClick(PaymentOptionModel paymentOptionModel);
    }

    public class PaymentOptionItemHolder extends RecyclerView.ViewHolder {
        @BindView(2131362397)
        TextView description;
        PaymentOptionModel item;
        @BindView(2131364525)
        TextView paymentOptionDesc;
        @BindView(2131363483)
        LinearLayout paymentOptionLl;
        @BindView(2131363479)
        RadioButton paymentoption;

        public PaymentOptionItemHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
        }

        @OnClick({2131363483})
        public void paymentDetailsClick(View view) {
            if (PaymentOptionAdapter.this.listener != null) {
                PaymentOptionAdapter.this.listener.onItemClick(this.item);
            }
        }

        @OnClick({2131363479})
        public void paymentOptionClick(View view) {
            if (PaymentOptionAdapter.this.listener != null) {
                PaymentOptionAdapter.this.listener.onItemClick(this.item);
            }
        }
    }

    public class PaymentOptionItemHolder_ViewBinding implements Unbinder {
        private PaymentOptionItemHolder target;
        private View view7f0a0697;
        private View view7f0a069b;

        public PaymentOptionItemHolder_ViewBinding(final PaymentOptionItemHolder paymentOptionItemHolder, View view) {
            this.target = paymentOptionItemHolder;
            View findRequiredView = Utils.findRequiredView(view, R.id.payment_option_ll, "field 'paymentOptionLl' and method 'paymentDetailsClick'");
            paymentOptionItemHolder.paymentOptionLl = (LinearLayout) Utils.castView(findRequiredView, R.id.payment_option_ll, "field 'paymentOptionLl'", LinearLayout.class);
            this.view7f0a069b = findRequiredView;
            findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    paymentOptionItemHolder.paymentDetailsClick(view);
                }
            });
            Class cls = TextView.class;
            paymentOptionItemHolder.description = (TextView) Utils.findRequiredViewAsType(view, R.id.description, "field 'description'", cls);
            View findRequiredView2 = Utils.findRequiredView(view, R.id.payment_option, "field 'paymentoption' and method 'paymentOptionClick'");
            paymentOptionItemHolder.paymentoption = (RadioButton) Utils.castView(findRequiredView2, R.id.payment_option, "field 'paymentoption'", RadioButton.class);
            this.view7f0a0697 = findRequiredView2;
            findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    paymentOptionItemHolder.paymentOptionClick(view);
                }
            });
            paymentOptionItemHolder.paymentOptionDesc = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_payment_option, "field 'paymentOptionDesc'", cls);
        }

        public void unbind() {
            PaymentOptionItemHolder paymentOptionItemHolder = this.target;
            if (paymentOptionItemHolder != null) {
                this.target = null;
                paymentOptionItemHolder.paymentOptionLl = null;
                paymentOptionItemHolder.description = null;
                paymentOptionItemHolder.paymentoption = null;
                paymentOptionItemHolder.paymentOptionDesc = null;
                this.view7f0a069b.setOnClickListener((View.OnClickListener) null);
                this.view7f0a069b = null;
                this.view7f0a0697.setOnClickListener((View.OnClickListener) null);
                this.view7f0a0697 = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public PaymentOptionAdapter(Context context, List<PaymentOptionModel> list, PaymentOptionAdapterListener paymentOptionAdapterListener) {
        this.mContext = context;
        this.listener = paymentOptionAdapterListener;
        this.paymentOptionModelsList = list;
    }

    public int getItemCount() {
        return this.paymentOptionModelsList.size();
    }

    public PaymentOptionItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View r = C1058d.r(viewGroup, R.layout.item_paymentpassepage_option, (ViewGroup) null);
        PaymentOptionItemHolder paymentOptionItemHolder = new PaymentOptionItemHolder(r);
        xx.O(-1, -2, r);
        return paymentOptionItemHolder;
    }

    public void onBindViewHolder(PaymentOptionItemHolder paymentOptionItemHolder, int i) {
        PaymentOptionModel paymentOptionModel = this.paymentOptionModelsList.get(i);
        paymentOptionItemHolder.item = paymentOptionModel;
        paymentOptionItemHolder.paymentOptionDesc.setText(paymentOptionModel.a.getLabel());
        paymentOptionItemHolder.description.setText(paymentOptionModel.a.getDesc());
        if (paymentOptionModel.f5340a) {
            paymentOptionItemHolder.paymentoption.setChecked(true);
        } else {
            paymentOptionItemHolder.paymentoption.setChecked(false);
        }
    }
}
