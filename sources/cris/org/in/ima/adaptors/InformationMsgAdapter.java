package cris.org.in.ima.adaptors;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
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
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.InformationMessageDTO;
import java.util.List;

public class InformationMsgAdapter extends RecyclerView.Adapter<infoItemHolder> {
    List<InformationMessageDTO> informationMessageDTOList;
    InformationMsgListener listener;
    Context mContext;

    public interface InformationMsgListener {
        void onItemClick(InformationMessageDTO informationMessageDTO);
    }

    public class infoItemHolder extends RecyclerView.ViewHolder {
        @BindView(2131364447)
        TextView item;
        InformationMessageDTO model;

        public infoItemHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
        }

        @OnClick({2131364447})
        public void onItemClick() {
            InformationMsgAdapter.this.listener.onItemClick(this.model);
        }
    }

    public class infoItemHolder_ViewBinding implements Unbinder {
        private infoItemHolder target;
        private View view7f0a0a5f;

        public infoItemHolder_ViewBinding(final infoItemHolder infoitemholder, View view) {
            this.target = infoitemholder;
            View findRequiredView = Utils.findRequiredView(view, R.id.tv_item, "field 'item' and method 'onItemClick'");
            infoitemholder.item = (TextView) Utils.castView(findRequiredView, R.id.tv_item, "field 'item'", TextView.class);
            this.view7f0a0a5f = findRequiredView;
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
                infoitemholder.item = null;
                this.view7f0a0a5f.setOnClickListener((View.OnClickListener) null);
                this.view7f0a0a5f = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public InformationMsgAdapter(Context context, List<InformationMessageDTO> list, InformationMsgListener informationMsgListener) {
        this.informationMessageDTOList = list;
        this.mContext = context;
        this.listener = informationMsgListener;
    }

    public int getItemCount() {
        return this.informationMessageDTOList.size();
    }

    public infoItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new infoItemHolder(C1058d.s(viewGroup, R.layout.info_item, viewGroup, false));
    }

    public void onBindViewHolder(infoItemHolder infoitemholder, int i) {
        InformationMessageDTO informationMessageDTO = this.informationMessageDTOList.get(i);
        infoitemholder.model = informationMessageDTO;
        if (informationMessageDTO.getUrl() == null || !informationMessageDTO.getUrl().contains("http")) {
            C1058d.H(this.mContext, R.color.red, infoitemholder.item);
            infoitemholder.item.setText(informationMessageDTO.getMessage());
            return;
        }
        SpannableString spannableString = new SpannableString(informationMessageDTO.getMessage());
        spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 0);
        infoitemholder.item.setText(spannableString);
    }
}
