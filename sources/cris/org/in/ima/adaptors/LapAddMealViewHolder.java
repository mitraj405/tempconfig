package cris.org.in.ima.adaptors;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.MealItemDetails;
import java.util.ArrayList;

public class LapAddMealViewHolder extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = C1354qp.R(LapAddMealViewHolder.class);
    Context mContext;
    ArrayList<MealItemDetails> mealDetailList;
    ArrayList<String> mealtype = new ArrayList<>();

    public interface AddMealHolderListener {
        void onEditClick(MealItemDetails mealItemDetails);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(2131362892)
        TextView iv_meal_icon;
        @BindView(2131362893)
        ImageView iv_meal_min;
        @BindView(2131362894)
        ImageView iv_meal_plus;
        MealItemDetails meal;
        @BindView(2131363201)
        TextView mealType;
        @BindView(2131363205)
        View mealview;
        @BindView(2131363963)
        RelativeLayout show_menuitem_rl;
        @BindView(2131364280)
        TextView tv_addmeal;
        @BindView(2131364480)
        TextView tv_meal;
        @BindView(2131364482)
        TextView tv_mealdetail;
        @BindView(2131364538)
        TextView tv_price;
        @BindView(2131364732)
        TextView tv_weight_meal;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
        }

        @OnClick({2131362893})
        public void MinClick(View view) {
            int j0 = C0535I5.j0(this.meal);
            if (j0 == 0) {
                this.tv_addmeal.setText("ADD");
                this.iv_meal_min.setVisibility(8);
                return;
            }
            C1058d.G(j0, "", this.tv_addmeal);
            this.iv_meal_min.setVisibility(0);
        }

        @OnClick({2131362894})
        public void PlusClick() {
            int l0 = C0535I5.l0(this.meal);
            if (l0 == 0) {
                this.tv_addmeal.setText("ADD");
                this.iv_meal_min.setVisibility(8);
                return;
            }
            C1058d.G(l0, "", this.tv_addmeal);
            this.iv_meal_min.setVisibility(0);
        }

        @OnClick({2131364280})
        public void addMealButtonClick() {
            if (this.tv_addmeal.getText().equals("ADD")) {
                PlusClick();
            }
        }

        @OnClick({2131362829})
        public void showMealDetailClick(View view) {
            if (this.tv_mealdetail.getVisibility() == 8) {
                this.tv_mealdetail.setVisibility(0);
            } else {
                this.tv_mealdetail.setVisibility(8);
            }
        }

        @OnClick({2131363963})
        public void showmenuitemClick(View view) {
            if (this.tv_mealdetail.getVisibility() == 8) {
                this.tv_mealdetail.setVisibility(0);
            } else {
                this.tv_mealdetail.setVisibility(8);
            }
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;
        private View view7f0a040d;
        private View view7f0a044d;
        private View view7f0a044e;
        private View view7f0a087b;
        private View view7f0a09b8;

        public ViewHolder_ViewBinding(final ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            Class cls = TextView.class;
            viewHolder.tv_meal = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_meal, "field 'tv_meal'", cls);
            viewHolder.tv_price = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_price, "field 'tv_price'", cls);
            viewHolder.tv_weight_meal = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_weight_meal, "field 'tv_weight_meal'", cls);
            View findRequiredView = Utils.findRequiredView(view, R.id.iv_meal_min, "field 'iv_meal_min' and method 'MinClick'");
            Class cls2 = ImageView.class;
            viewHolder.iv_meal_min = (ImageView) Utils.castView(findRequiredView, R.id.iv_meal_min, "field 'iv_meal_min'", cls2);
            this.view7f0a044d = findRequiredView;
            findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    viewHolder.MinClick(view);
                }
            });
            View findRequiredView2 = Utils.findRequiredView(view, R.id.tv_addmeal, "field 'tv_addmeal' and method 'addMealButtonClick'");
            viewHolder.tv_addmeal = (TextView) Utils.castView(findRequiredView2, R.id.tv_addmeal, "field 'tv_addmeal'", cls);
            this.view7f0a09b8 = findRequiredView2;
            findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    viewHolder.addMealButtonClick();
                }
            });
            View findRequiredView3 = Utils.findRequiredView(view, R.id.iv_meal_plus, "field 'iv_meal_plus' and method 'PlusClick'");
            viewHolder.iv_meal_plus = (ImageView) Utils.castView(findRequiredView3, R.id.iv_meal_plus, "field 'iv_meal_plus'", cls2);
            this.view7f0a044e = findRequiredView3;
            findRequiredView3.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    viewHolder.PlusClick();
                }
            });
            viewHolder.tv_mealdetail = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_mealdetail, "field 'tv_mealdetail'", cls);
            viewHolder.iv_meal_icon = (TextView) Utils.findRequiredViewAsType(view, R.id.iv_meal_icon, "field 'iv_meal_icon'", cls);
            viewHolder.mealType = (TextView) Utils.findRequiredViewAsType(view, R.id.mealType, "field 'mealType'", cls);
            viewHolder.mealview = Utils.findRequiredView(view, R.id.mealview, "field 'mealview'");
            View findRequiredView4 = Utils.findRequiredView(view, R.id.show_menuitem_rl, "field 'show_menuitem_rl' and method 'showmenuitemClick'");
            viewHolder.show_menuitem_rl = (RelativeLayout) Utils.castView(findRequiredView4, R.id.show_menuitem_rl, "field 'show_menuitem_rl'", RelativeLayout.class);
            this.view7f0a087b = findRequiredView4;
            findRequiredView4.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    viewHolder.showmenuitemClick(view);
                }
            });
            View findRequiredView5 = Utils.findRequiredView(view, R.id.im_show_mealdetail, "method 'showMealDetailClick'");
            this.view7f0a040d = findRequiredView5;
            findRequiredView5.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    viewHolder.showMealDetailClick(view);
                }
            });
        }

        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder != null) {
                this.target = null;
                viewHolder.tv_meal = null;
                viewHolder.tv_price = null;
                viewHolder.tv_weight_meal = null;
                viewHolder.iv_meal_min = null;
                viewHolder.tv_addmeal = null;
                viewHolder.iv_meal_plus = null;
                viewHolder.tv_mealdetail = null;
                viewHolder.iv_meal_icon = null;
                viewHolder.mealType = null;
                viewHolder.mealview = null;
                viewHolder.show_menuitem_rl = null;
                this.view7f0a044d.setOnClickListener((View.OnClickListener) null);
                this.view7f0a044d = null;
                this.view7f0a09b8.setOnClickListener((View.OnClickListener) null);
                this.view7f0a09b8 = null;
                this.view7f0a044e.setOnClickListener((View.OnClickListener) null);
                this.view7f0a044e = null;
                this.view7f0a087b.setOnClickListener((View.OnClickListener) null);
                this.view7f0a087b = null;
                this.view7f0a040d.setOnClickListener((View.OnClickListener) null);
                this.view7f0a040d = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public LapAddMealViewHolder(Context context, ArrayList<MealItemDetails> arrayList) {
        this.mealDetailList = arrayList;
        this.mContext = context;
    }

    public int getItemCount() {
        ArrayList<MealItemDetails> arrayList = this.mealDetailList;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View r = C1058d.r(viewGroup, R.layout.lap_item_addmeal_passengerpage, (ViewGroup) null);
        ViewHolder viewHolder = new ViewHolder(r);
        xx.O(-1, -2, r);
        return viewHolder;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        MealItemDetails mealItemDetails = this.mealDetailList.get(i);
        viewHolder.meal = mealItemDetails;
        if (!this.mealtype.contains(mealItemDetails.getMealType())) {
            TextView textView = viewHolder.mealType;
            textView.setText(mealItemDetails.getMealType() + "  (" + mealItemDetails.getAvailableFromTime() + " " + this.mContext.getString(R.string.hrs) + " " + this.mContext.getString(R.string.to_se) + " " + mealItemDetails.getAvailableToTime() + " " + this.mContext.getString(R.string.hrs) + ")");
            viewHolder.mealType.setVisibility(0);
            viewHolder.mealview.setVisibility(0);
            this.mealtype.add(mealItemDetails.getMealType());
        } else {
            viewHolder.mealType.setVisibility(8);
            viewHolder.mealview.setVisibility(8);
        }
        String[] split = mealItemDetails.getMealName().split("\\(");
        C0535I5.h0(viewHolder.iv_meal_icon, mealItemDetails.getMealCode());
        viewHolder.tv_meal.setText(split[0]);
        lf.x(new StringBuilder("("), split[1], viewHolder.tv_weight_meal);
        viewHolder.tv_mealdetail.setText(mealItemDetails.getMealDetails());
        viewHolder.tv_price.setText(String.format(this.mContext.getResources().getString(R.string.format_zerotimes), new Object[]{Float.valueOf(mealItemDetails.getMealRate())}));
        int quantity = mealItemDetails.getQuantity();
        if (quantity == 0) {
            viewHolder.tv_addmeal.setText("ADD");
            viewHolder.iv_meal_min.setVisibility(8);
            return;
        }
        C1058d.G(quantity, "", viewHolder.tv_addmeal);
        viewHolder.iv_meal_min.setVisibility(0);
    }
}
