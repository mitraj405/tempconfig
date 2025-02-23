package cris.org.in.ima.adaptors;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.MealDetails;
import java.util.ArrayList;

public class MealTypeViewHolder extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = C1354qp.R(MealTypeViewHolder.class);
    Context mContext;
    private ArrayList<MealDetails> mealDetails;

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(2131362626)
        LinearLayout expend_layout;
        @BindView(2131363823)
        RecyclerView rv_mealitems;
        @BindView(2131364483)
        TextView tv_mealtype;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
        }

        @OnClick({2131363204})
        public void onTicketClick(View view) {
            if (this.expend_layout.getVisibility() == 8) {
                this.expend_layout.setVisibility(0);
            } else {
                this.expend_layout.setVisibility(8);
            }
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;
        private View view7f0a0584;

        public ViewHolder_ViewBinding(final ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.tv_mealtype = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_mealtype, "field 'tv_mealtype'", TextView.class);
            viewHolder.expend_layout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.expend_layout, "field 'expend_layout'", LinearLayout.class);
            viewHolder.rv_mealitems = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_mealitems, "field 'rv_mealitems'", RecyclerView.class);
            View findRequiredView = Utils.findRequiredView(view, R.id.mealtype_rl, "method 'onTicketClick'");
            this.view7f0a0584 = findRequiredView;
            findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    viewHolder.onTicketClick(view);
                }
            });
        }

        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder != null) {
                this.target = null;
                viewHolder.tv_mealtype = null;
                viewHolder.expend_layout = null;
                viewHolder.rv_mealitems = null;
                this.view7f0a0584.setOnClickListener((View.OnClickListener) null);
                this.view7f0a0584 = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public MealTypeViewHolder(Context context, ArrayList<MealDetails> arrayList) {
        this.mealDetails = arrayList;
        this.mContext = context;
    }

    public int getItemCount() {
        ArrayList<MealDetails> arrayList = this.mealDetails;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View r = C1058d.r(viewGroup, R.layout.item_meal_type, (ViewGroup) null);
        this.mContext = viewGroup.getContext();
        ViewHolder viewHolder = new ViewHolder(r);
        xx.O(-1, -2, r);
        return viewHolder;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        MealDetails mealDetails2 = this.mealDetails.get(i);
        viewHolder.tv_mealtype.setText(mealDetails2.getMealType());
        mealDetails2.toString();
        viewHolder.rv_mealitems.setLayoutManager(new LinearLayoutManager(this.mContext));
        viewHolder.rv_mealitems.setAdapter(new AddMealViewHolder(this.mContext, mealDetails2.getMealDetailList()));
    }
}
