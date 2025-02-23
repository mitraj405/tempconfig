package defpackage;

import android.content.DialogInterface;
import android.graphics.Color;
import android.widget.EditText;
import android.widget.TextView;
import cris.org.in.ima.fragment.PurchaseLoyaltyPointsFragment;
import cris.org.in.prs.ima.R;
import java.util.regex.Pattern;
import rx.Subscriber;

/* renamed from: Qq  reason: default package and case insensitive filesystem */
/* compiled from: PurchaseLoyaltyPointsFragment */
public final class C0656Qq extends Subscriber<C0812c0> {
    public final /* synthetic */ EditText a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ TextView f3771a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ PurchaseLoyaltyPointsFragment f3772a;
    public final /* synthetic */ String c;

    public C0656Qq(PurchaseLoyaltyPointsFragment purchaseLoyaltyPointsFragment, TextView textView, String str, EditText editText) {
        this.f3772a = purchaseLoyaltyPointsFragment;
        this.f3771a = textView;
        this.c = str;
        this.a = editText;
    }

    public final void onCompleted() {
        Pattern pattern = PurchaseLoyaltyPointsFragment.a;
        this.f3772a.f5052a.dismiss();
    }

    public final void onError(Throwable th) {
        Pattern pattern = PurchaseLoyaltyPointsFragment.a;
        th.getClass();
        th.getMessage();
        this.f3772a.f5052a.dismiss();
        Lt.a(false, th);
    }

    public final void onNext(Object obj) {
        C0812c0 c0Var = (C0812c0) obj;
        Pattern pattern = PurchaseLoyaltyPointsFragment.a;
        EditText editText = this.a;
        PurchaseLoyaltyPointsFragment purchaseLoyaltyPointsFragment = this.f3772a;
        if (c0Var != null) {
            c0Var.toString();
            String error = c0Var.getError();
            TextView textView = this.f3771a;
            String str = this.c;
            if (error == null) {
                purchaseLoyaltyPointsFragment.b.clear();
                for (int i = 0; i < c0Var.getCityList().size(); i++) {
                    purchaseLoyaltyPointsFragment.b.add(c0Var.getCityList().get(i));
                }
                textView.setTextColor(Color.parseColor("#000000"));
                purchaseLoyaltyPointsFragment.f(R.id.city_reg, "@color/white_90_opa");
                purchaseLoyaltyPointsFragment.f(R.id.et_state_reg, "@color/white_90_opa");
                purchaseLoyaltyPointsFragment.e = str;
                c0Var.getState();
            } else {
                purchaseLoyaltyPointsFragment.e = str;
                purchaseLoyaltyPointsFragment.b.clear();
                purchaseLoyaltyPointsFragment.f5056a.clear();
                textView.setText((CharSequence) null);
                purchaseLoyaltyPointsFragment.f(R.id.city_reg, "@color/white_10_opa");
                editText.setError(c0Var.getError());
                purchaseLoyaltyPointsFragment.f5052a.dismiss();
                C0535I5.m(purchaseLoyaltyPointsFragment.getActivity(), true, c0Var.getError(), purchaseLoyaltyPointsFragment.getString(R.string.error), purchaseLoyaltyPointsFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            }
        } else {
            editText.setError("");
        }
        purchaseLoyaltyPointsFragment.f5052a.dismiss();
    }
}
