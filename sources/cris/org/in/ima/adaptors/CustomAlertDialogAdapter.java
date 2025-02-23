package cris.org.in.ima.adaptors;

import android.content.Context;
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
import cris.org.in.ima.listener.OnSelectListenerYesNo;
import cris.org.in.prs.ima.R;

public class CustomAlertDialogAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = C1354qp.R(CustomAlertDialogAdapter.class);
    private Context mContext;
    private String mDropDownModels;
    /* access modifiers changed from: private */
    public OnSelectListenerYesNo mOnSelectionListener;
    String no;
    String yes;

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(2131364484)
        TextView message;
        String no;
        String yes;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
        }

        @OnClick({2131364501})
        public void onNoClick(View view) {
            CustomAlertDialogAdapter.this.mOnSelectionListener.a();
        }

        @OnClick({2131364733})
        public void onYesClick(View view) {
            CustomAlertDialogAdapter.this.mOnSelectionListener.b();
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;
        private View view7f0a0a95;
        private View view7f0a0b7d;

        public ViewHolder_ViewBinding(final ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.message = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_message, "field 'message'", TextView.class);
            View findRequiredView = Utils.findRequiredView(view, R.id.tv_yes, "method 'onYesClick'");
            this.view7f0a0b7d = findRequiredView;
            findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    viewHolder.onYesClick(view);
                }
            });
            View findRequiredView2 = Utils.findRequiredView(view, R.id.tv_no, "method 'onNoClick'");
            this.view7f0a0a95 = findRequiredView2;
            findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    viewHolder.onNoClick(view);
                }
            });
        }

        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder != null) {
                this.target = null;
                viewHolder.message = null;
                this.view7f0a0b7d.setOnClickListener((View.OnClickListener) null);
                this.view7f0a0b7d = null;
                this.view7f0a0a95.setOnClickListener((View.OnClickListener) null);
                this.view7f0a0a95 = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public CustomAlertDialogAdapter(Context context, String str, String str2, String str3, OnSelectListenerYesNo onSelectListenerYesNo) {
        this.mContext = context;
        this.mOnSelectionListener = onSelectListenerYesNo;
        this.mDropDownModels = str;
    }

    public int getItemCount() {
        if (this.mDropDownModels != null) {
            return 1;
        }
        return 0;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(C1058d.s(viewGroup, R.layout.item_alert_dialog, viewGroup, false));
    }

    public void setData(String str) {
        this.mDropDownModels = str;
        notifyDataSetChanged();
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        try {
            viewHolder.yes = this.yes;
            viewHolder.no = this.no;
            viewHolder.message.setText(this.mDropDownModels);
        } catch (Exception e) {
            e.toString();
        }
    }
}
