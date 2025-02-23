package cris.org.in.ima.adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import cris.org.in.prs.ima.R;
import java.util.ArrayList;

public class TrainTypeAdaptor extends ArrayAdapter<C0503FA> {
    public TrainTypeAdaptor(Context context, ArrayList<C0503FA> arrayList) {
        super(context, 0, arrayList);
    }

    private View initView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.country_spinner_row, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(R.id.text_view_name);
        ImageView imageView = (ImageView) view.findViewById(R.id.image_view_flag);
        C0503FA fa = (C0503FA) getItem(i);
        if (fa != null) {
            textView.setText(fa.f3582a);
            imageView.setImageResource(fa.a);
        }
        return view;
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return initView(i, view, viewGroup);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return initView(i, view, viewGroup);
    }
}
