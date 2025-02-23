package com.paytm.pgsdk.sdknative;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.paytm.pgsdk.sdknative.modal.ResponseSavedCardBin;

/* compiled from: SavedCardFragment */
public class a extends Fragment implements View.OnClickListener {
    public EditText a;

    /* renamed from: a  reason: collision with other field name */
    public ImageView f4122a;

    /* renamed from: a  reason: collision with other field name */
    public RelativeLayout f4123a;

    /* renamed from: a  reason: collision with other field name */
    public TextView f4124a;

    /* renamed from: a  reason: collision with other field name */
    public C0055a f4125a;

    /* renamed from: a  reason: collision with other field name */
    public ResponseSavedCardBin.SavedCardBinDetails f4126a;
    public EditText b;

    /* renamed from: b  reason: collision with other field name */
    public TextView f4127b;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public TextView f4128c;

    /* renamed from: com.paytm.pgsdk.sdknative.a$a  reason: collision with other inner class name */
    /* compiled from: SavedCardFragment */
    public interface C0055a {
    }

    public final void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof C0055a) {
            this.f4125a = (C0055a) context;
            return;
        }
        throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
    }

    public final void onClick(View view) {
        int id = view.getId();
        if (id == C0501Er.rel_proceed_pay || id == C0501Er.txt_proceed_to_pay) {
            String obj = this.b.getText().toString();
            if (TextUtils.isEmpty(obj)) {
                this.f4128c.setVisibility(0);
            } else if (this.f4126a != null) {
                ((PaytmSavedCardActivity) getActivity()).proceedToPayViaSavedCardDetails("" + this.f4126a.SAVE_CARD_ID, obj);
            } else if (getActivity() != null) {
                ((PaytmSavedCardActivity) getActivity()).proceedToPayViaSavedCardDetails("", obj);
            }
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            getArguments().getString("param1");
            getArguments().getString("param2");
            this.c = getArguments().getInt("position");
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C0697Tr.fragment_saved_card, viewGroup, false);
        this.f4126a = ((PaytmSavedCardActivity) getActivity()).getmResponseSavedCardBin(this.c);
        this.f4124a = (TextView) inflate.findViewById(C0501Er.card_name);
        this.f4127b = (TextView) inflate.findViewById(C0501Er.txt_card_no);
        this.f4122a = (ImageView) inflate.findViewById(C0501Er.img_card_type);
        int i = C0501Er.edit_cvv;
        this.a = (EditText) inflate.findViewById(i);
        this.f4128c = (TextView) inflate.findViewById(C0501Er.error_cvv);
        this.f4123a = (RelativeLayout) inflate.findViewById(C0501Er.rel_proceed_pay);
        TextView textView = (TextView) inflate.findViewById(C0501Er.txt_proceed_to_pay);
        this.b = (EditText) inflate.findViewById(i);
        if (this.f4126a != null) {
            TextView textView2 = this.f4124a;
            textView2.setText(this.f4126a.BANK_NAME + "");
            TextView textView3 = this.f4127b;
            textView3.setText(this.f4126a.CARDLASTDIGIT + "");
            String str = this.f4126a.CARD_TYPE;
            if (str.equalsIgnoreCase("maestro")) {
                this.f4122a.setImageResource(C1502yr.maestro_icon);
            } else if (str.equalsIgnoreCase("visa")) {
                this.f4122a.setImageResource(C1502yr.visa_icon);
            } else if (str.equalsIgnoreCase("master")) {
                this.f4122a.setImageResource(C1502yr.master_icon);
            } else if (str.equalsIgnoreCase("diners")) {
                this.f4122a.setImageResource(C1502yr.diners);
            } else if (str.equalsIgnoreCase("jcb")) {
                this.f4122a.setImageResource(C1502yr.jcb);
            } else if (str.equalsIgnoreCase("amex")) {
                this.f4122a.setImageResource(C1502yr.amex);
            } else {
                this.f4122a.setImageResource(17170445);
            }
        }
        this.f4123a.setOnClickListener(this);
        this.a.addTextChangedListener(new Ru(this));
        return inflate;
    }

    public final void onDetach() {
        super.onDetach();
    }
}
