package cris.org.in.ima.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.fragment.BookMealFragment;
import java.io.Serializable;
import java.security.SecureRandom;

/* renamed from: cris.org.in.ima.fragment.w  reason: case insensitive filesystem */
/* compiled from: BookMealFragment */
public final class C1051w implements DialogInterface.OnClickListener {
    public final /* synthetic */ Wp a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ BookMealFragment.a f5242a;

    public C1051w(BookMealFragment.a aVar, Wp wp) {
        this.f5242a = aVar;
        this.a = wp;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        String.valueOf(((long) (new SecureRandom().nextDouble() * 9.0E9d)) + 1000000000);
        Bundle bundle = new Bundle();
        MakePaymentNewFragment makePaymentNewFragment = new MakePaymentNewFragment();
        Wp wp = this.a;
        bundle.putSerializable("BankDetailDto", (Serializable) wp.getBankDetailDTO());
        bundle.putString("TotalFare", String.valueOf(wp.getTotalPayableAmount()));
        bundle.putString("ClientTxnId", "POST_BOOKING");
        makePaymentNewFragment.setArguments(bundle);
        HomeActivity.n(BookMealFragment.this.getActivity(), makePaymentNewFragment, C1218kf.MAKE_PAYMENT.a(), Boolean.TRUE, Boolean.FALSE);
    }
}
