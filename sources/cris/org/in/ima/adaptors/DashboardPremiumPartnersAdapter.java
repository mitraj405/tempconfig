package cris.org.in.ima.adaptors;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.ima.model.PremiumPartnerImageModel;
import cris.org.in.prs.ima.R;
import java.util.ArrayList;

public class DashboardPremiumPartnersAdapter extends RecyclerView.Adapter<infoItemHolder> {
    ArrayList<PremiumPartnerImageModel> imagedetaillist;
    PrimuimPartner listener;
    Context mContext;

    public interface PrimuimPartner {
        void onItemClick(PremiumPartnerImageModel premiumPartnerImageModel);
    }

    public class infoItemHolder extends RecyclerView.ViewHolder {
        @BindView(2131362831)
        ImageView image_iv;
        PremiumPartnerImageModel model;
        @BindView(2131364123)
        TextView text_tv;

        public infoItemHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
        }

        @OnClick({2131362831})
        public void onItemClick() {
            DashboardPremiumPartnersAdapter.this.listener.onItemClick(this.model);
        }
    }

    public class infoItemHolder_ViewBinding implements Unbinder {
        private infoItemHolder target;
        private View view7f0a040f;

        public infoItemHolder_ViewBinding(final infoItemHolder infoitemholder, View view) {
            this.target = infoitemholder;
            infoitemholder.text_tv = (TextView) Utils.findRequiredViewAsType(view, R.id.text_tv, "field 'text_tv'", TextView.class);
            View findRequiredView = Utils.findRequiredView(view, R.id.image_iv, "field 'image_iv' and method 'onItemClick'");
            infoitemholder.image_iv = (ImageView) Utils.castView(findRequiredView, R.id.image_iv, "field 'image_iv'", ImageView.class);
            this.view7f0a040f = findRequiredView;
            findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
                public void doClick(View view) {
                    infoitemholder.onItemClick();
                }
            });
        }

        public void unbind() {
            infoItemHolder infoitemholder = this.target;
            if (infoitemholder != null) {
                this.target = null;
                infoitemholder.text_tv = null;
                infoitemholder.image_iv = null;
                this.view7f0a040f.setOnClickListener((View.OnClickListener) null);
                this.view7f0a040f = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public DashboardPremiumPartnersAdapter(Context context, ArrayList<PremiumPartnerImageModel> arrayList, PrimuimPartner primuimPartner) {
        this.imagedetaillist = arrayList;
        this.mContext = context;
        this.listener = primuimPartner;
    }

    public int getItemCount() {
        return this.imagedetaillist.size();
    }

    public infoItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new infoItemHolder(C1058d.s(viewGroup, R.layout.premium_partner_image_item, viewGroup, false));
    }

    public void onBindViewHolder(infoItemHolder infoitemholder, int i) {
        PremiumPartnerImageModel premiumPartnerImageModel = this.imagedetaillist.get(i);
        infoitemholder.model = premiumPartnerImageModel;
        Context context = infoitemholder.image_iv.getContext();
        infoitemholder.image_iv.setImageResource(context.getResources().getIdentifier(premiumPartnerImageModel.d, "drawable", context.getPackageName()));
        TextView textView = infoitemholder.text_tv;
        String str = premiumPartnerImageModel.c;
        textView.setText(str);
        infoitemholder.image_iv.setContentDescription(str);
    }
}
