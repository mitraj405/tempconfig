package cris.org.in.ima.adaptors;

import android.content.Context;
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
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.MealItemDetails;
import java.util.ArrayList;

public class Lap1MealDetaillViewHolder extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = C1354qp.R(Lap1MealDetaillViewHolder.class);
    ArrayList<String> checkMeal = new ArrayList<>();
    AddMealHolderListener listener;
    Context mContext;
    ArrayList<MealItemDetails> mealDetailList;

    public interface AddMealHolderListener {
        void MinClick(MealItemDetails mealItemDetails);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(2131362480)
        LinearLayout edit;
        @BindView(2131362892)
        TextView iv_meal_icon;
        @BindView(2131362893)
        ImageView iv_meal_min;
        @BindView(2131362894)
        ImageView iv_meal_plus;
        MealItemDetails meal;
        @BindView(2131364280)
        TextView tv_addmeal;
        @BindView(2131364480)
        TextView tv_meal;
        @BindView(2131364481)
        TextView tv_mealType;
        @BindView(2131364682)
        TextView tv_total_price;
        @BindView(2131364683)
        TextView tv_total_price2;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
        }

        @OnClick({2131362893})
        public void MinClick(View view) {
            int j0 = C0535I5.j0(this.meal);
            if (j0 == 0) {
                this.tv_addmeal.setText("0");
                onEditClick();
                this.iv_meal_min.setVisibility(8);
                return;
            }
            C1058d.G(j0, "", this.tv_addmeal);
            this.iv_meal_min.setVisibility(0);
            this.tv_total_price2.setText(String.format(Lap1MealDetaillViewHolder.this.mContext.getResources().getString(R.string.format_zerotimes), new Object[]{Float.valueOf(this.meal.getMealRate() * ((float) this.meal.getQuantity()))}));
        }

        @OnClick({2131362894})
        public void PlusClick() {
            int l0 = C0535I5.l0(this.meal);
            if (l0 == 0) {
                this.tv_addmeal.setText("0");
                this.iv_meal_min.setVisibility(8);
                return;
            }
            C1058d.G(l0, "", this.tv_addmeal);
            this.iv_meal_min.setVisibility(0);
            this.tv_total_price2.setText(String.format(Lap1MealDetaillViewHolder.this.mContext.getResources().getString(R.string.format_zerotimes), new Object[]{Float.valueOf(this.meal.getMealRate() * ((float) this.meal.getQuantity()))}));
        }

        @OnClick({2131364280})
        public void addMealButtonClick() {
            if (this.tv_addmeal.getText().equals("ADD")) {
                PlusClick();
            }
        }

        public void onEditClick() {
            AddMealHolderListener addMealHolderListener = Lap1MealDetaillViewHolder.this.listener;
            if (addMealHolderListener != null) {
                addMealHolderListener.MinClick(this.meal);
            }
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;
        private View view7f0a044d;
        private View view7f0a044e;
        private View view7f0a09b8;

        public ViewHolder_ViewBinding(final ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            Class cls = TextView.class;
            viewHolder.tv_meal = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_meal, "field 'tv_meal'", cls);
            viewHolder.tv_total_price = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_total_price, "field 'tv_total_price'", cls);
            viewHolder.edit = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.edit_ll, "field 'edit'", LinearLayout.class);
            viewHolder.iv_meal_icon = (TextView) Utils.findRequiredViewAsType(view, R.id.iv_meal_icon, "field 'iv_meal_icon'", cls);
            viewHolder.tv_mealType = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_mealType, "field 'tv_mealType'", cls);
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
            viewHolder.tv_total_price2 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_total_price2, "field 'tv_total_price2'", cls);
        }

        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder != null) {
                this.target = null;
                viewHolder.tv_meal = null;
                viewHolder.tv_total_price = null;
                viewHolder.edit = null;
                viewHolder.iv_meal_icon = null;
                viewHolder.tv_mealType = null;
                viewHolder.iv_meal_min = null;
                viewHolder.tv_addmeal = null;
                viewHolder.iv_meal_plus = null;
                viewHolder.tv_total_price2 = null;
                this.view7f0a044d.setOnClickListener((View.OnClickListener) null);
                this.view7f0a044d = null;
                this.view7f0a09b8.setOnClickListener((View.OnClickListener) null);
                this.view7f0a09b8 = null;
                this.view7f0a044e.setOnClickListener((View.OnClickListener) null);
                this.view7f0a044e = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public Lap1MealDetaillViewHolder(Context context, ArrayList<MealItemDetails> arrayList, AddMealHolderListener addMealHolderListener) {
        this.listener = addMealHolderListener;
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
        View r = C1058d.r(viewGroup, R.layout.lap1_item_addmeal, (ViewGroup) null);
        ViewHolder viewHolder = new ViewHolder(r);
        xx.O(-1, -2, r);
        return viewHolder;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        MealItemDetails mealItemDetails = this.mealDetailList.get(i);
        viewHolder.meal = mealItemDetails;
        if (!this.checkMeal.contains(mealItemDetails.getMealType())) {
            viewHolder.tv_mealType.setVisibility(0);
            viewHolder.tv_mealType.setText(mealItemDetails.getMealType());
            this.checkMeal.add(mealItemDetails.getMealType());
        } else {
            viewHolder.tv_mealType.setVisibility(8);
        }
        C0535I5.h0(viewHolder.iv_meal_icon, mealItemDetails.getMealCode());
        TextView textView = viewHolder.tv_meal;
        textView.setText(mealItemDetails.getMealName() + " x " + mealItemDetails.getQuantity());
        viewHolder.tv_total_price.setText(String.format(this.mContext.getResources().getString(R.string.format_zerotimes), new Object[]{Float.valueOf(mealItemDetails.getMealRate() * ((float) mealItemDetails.getQuantity()))}));
        if (C0535I5.f3643f) {
            viewHolder.edit.setVisibility(8);
            viewHolder.tv_total_price.setVisibility(0);
        } else {
            viewHolder.edit.setVisibility(0);
            viewHolder.tv_total_price.setVisibility(8);
        }
        viewHolder.tv_total_price2.setText(String.format(this.mContext.getResources().getString(R.string.format_zerotimes), new Object[]{Float.valueOf(mealItemDetails.getMealRate() * ((float) mealItemDetails.getQuantity()))}));
        if (C0535I5.f3645g) {
            viewHolder.tv_total_price2.setVisibility(0);
        } else {
            viewHolder.tv_total_price2.setVisibility(8);
        }
        mealItemDetails.toString();
        int quantity = mealItemDetails.getQuantity();
        if (quantity == 0) {
            viewHolder.tv_addmeal.setText("0");
            viewHolder.iv_meal_min.setVisibility(8);
            return;
        }
        C1058d.G(quantity, "", viewHolder.tv_addmeal);
        viewHolder.iv_meal_min.setVisibility(0);
    }
}
