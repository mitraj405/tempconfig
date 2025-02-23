package cris.org.in.ima.adaptors;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cris.org.in.ima.fragment.AllTrainListFragment;
import cris.org.in.ima.model.AvlClassModel;
import cris.org.in.ima.model.TrainBtwnStnsModel;
import cris.org.in.prs.ima.R;
import java.util.List;

public class AvlClassViewHolder extends RecyclerView.Adapter<AvlClassItemHolder> {
    private static final String TAG = C1354qp.R(AvlClassViewHolder.class);
    List<AvlClassModel> avlClassModels;
    AvlClassViewHolderListener listener;
    Context mContext;

    public class AvlClassItemHolder extends RecyclerView.ViewHolder {
        TextView avlClass;
        LinearLayout avlClassLayout;
        TextView view_select;

        public AvlClassItemHolder(View view) {
            super(view);
            this.avlClass = (TextView) view.findViewById(R.id.tv_avl_class);
            this.avlClassLayout = (LinearLayout) view.findViewById(R.id.tv_avl_class_layout);
            this.view_select = (TextView) view.findViewById(R.id.view_select);
        }
    }

    public interface AvlClassViewHolderListener {
        void onItemClick(AvlClassModel avlClassModel);
    }

    public AvlClassViewHolder(Context context, List<AvlClassModel> list, AvlClassViewHolderListener avlClassViewHolderListener) {
        this.avlClassModels = list;
        this.mContext = context;
        this.listener = avlClassViewHolderListener;
    }

    public int getItemCount() {
        return this.avlClassModels.size();
    }

    public AvlClassItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new AvlClassItemHolder(C1058d.s(viewGroup, R.layout.item_avl_class, viewGroup, false));
    }

    public void onSetListeners(AvlClassItemHolder avlClassItemHolder, final AvlClassModel avlClassModel) {
        avlClassItemHolder.avlClassLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TrainBtwnStnsModel trainBtwnStnsModel = AllTrainListFragment.f4414b;
                if (trainBtwnStnsModel != null) {
                    trainBtwnStnsModel.f5348c = avlClassModel.c;
                }
                AvlClassViewHolderListener avlClassViewHolderListener = AvlClassViewHolder.this.listener;
                if (avlClassViewHolderListener != null) {
                    avlClassViewHolderListener.onItemClick(avlClassModel);
                }
            }
        });
    }

    public void onBindViewHolder(AvlClassItemHolder avlClassItemHolder, int i) {
        AvlClassModel avlClassModel = this.avlClassModels.get(i);
        avlClassItemHolder.view_select.setBackground(this.mContext.getResources().getDrawable(R.color.white));
        avlClassItemHolder.avlClass.setText(avlClassModel.c);
        if (avlClassModel.a.booleanValue()) {
            avlClassItemHolder.avlClassLayout.setBackground(this.mContext.getResources().getDrawable(R.color.class_select));
        } else {
            avlClassItemHolder.avlClassLayout.setBackground(this.mContext.getResources().getDrawable(R.color.class_backgroundcolor));
        }
        onSetListeners(avlClassItemHolder, avlClassModel);
    }
}
