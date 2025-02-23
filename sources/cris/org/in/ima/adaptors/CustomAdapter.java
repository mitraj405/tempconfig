package cris.org.in.ima.adaptors;

import android.content.Context;
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
import cris.org.in.ima.listener.OnSelectionListener;
import cris.org.in.prs.ima.R;
import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = C1354qp.R(CustomAdapter.class);
    private Context mContext;
    /* access modifiers changed from: private */
    public ArrayList<String> mDropDownModels;
    /* access modifiers changed from: private */
    public OnSelectionListener mOnSelectionListener;

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(2131363295)
        TextView name;
        @BindView(2131363439)
        LinearLayout parentView;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
        }

        @OnClick({2131363439})
        public void onItemClick(View view) {
            CustomAdapter.this.mOnSelectionListener.onClick((String) CustomAdapter.this.mDropDownModels.get(((Integer) view.getTag()).intValue()));
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;
        private View view7f0a066f;

        public ViewHolder_ViewBinding(final ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.name = (TextView) Utils.findRequiredViewAsType(view, R.id.name, "field 'name'", TextView.class);
            View findRequiredView = Utils.findRequiredView(view, R.id.parent_view, "field 'parentView' and method 'onItemClick'");
            viewHolder.parentView = (LinearLayout) Utils.castView(findRequiredView, R.id.parent_view, "field 'parentView'", LinearLayout.class);
            this.view7f0a066f = findRequiredView;
            findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    viewHolder.onItemClick(view);
                }
            });
        }

        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder != null) {
                this.target = null;
                viewHolder.name = null;
                viewHolder.parentView = null;
                this.view7f0a066f.setOnClickListener((View.OnClickListener) null);
                this.view7f0a066f = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public CustomAdapter(Context context, ArrayList<String> arrayList, OnSelectionListener onSelectionListener) {
        this.mContext = context;
        this.mOnSelectionListener = onSelectionListener;
        this.mDropDownModels = arrayList;
    }

    public int getItemCount() {
        ArrayList<String> arrayList = this.mDropDownModels;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(C1058d.s(viewGroup, R.layout.item_row, viewGroup, false));
    }

    public void setData(ArrayList<String> arrayList) {
        this.mDropDownModels = arrayList;
        notifyDataSetChanged();
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        try {
            viewHolder.name.setText(this.mDropDownModels.get(i));
            viewHolder.parentView.setTag(Integer.valueOf(i));
        } catch (Exception e) {
            e.toString();
        }
    }
}
