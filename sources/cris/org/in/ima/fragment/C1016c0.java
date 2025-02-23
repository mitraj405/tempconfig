package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
import rx.Subscriber;

/* renamed from: cris.org.in.ima.fragment.c0  reason: case insensitive filesystem */
/* compiled from: PassengerDetailFragment */
public final class C1016c0 extends Subscriber<C0812c0> {
    public final /* synthetic */ PassengerDetailFragment a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Boolean f5235a;

    public C1016c0(PassengerDetailFragment passengerDetailFragment, Boolean bool) {
        this.a = passengerDetailFragment;
        this.f5235a = bool;
    }

    public final void onCompleted() {
        TextView textView = PassengerDetailFragment.a;
        this.a.f4903a.dismiss();
    }

    public final void onError(Throwable th) {
        TextView textView = PassengerDetailFragment.a;
        th.getClass();
        th.getMessage();
        this.a.f4903a.dismiss();
        Lt.a(false, th);
    }

    public final void onNext(Object obj) {
        C0812c0 c0Var = (C0812c0) obj;
        TextView textView = PassengerDetailFragment.a;
        PassengerDetailFragment passengerDetailFragment = this.a;
        if (c0Var != null) {
            c0Var.getPostofficeList().toString();
            passengerDetailFragment.f4903a.dismiss();
            if (this.f5235a.booleanValue()) {
                passengerDetailFragment.state.setText(c0Var.getState());
                return;
            }
            ArrayList<String> arrayList = passengerDetailFragment.f5020y;
            arrayList.clear();
            for (int i = 0; i < c0Var.getPostofficeList().size(); i++) {
                arrayList.add(c0Var.getPostofficeList().get(i));
            }
            if (arrayList.size() == 1) {
                passengerDetailFragment.et_post_office.setText(arrayList.get(0));
                passengerDetailFragment.et_post_office.setError((CharSequence) null);
                passengerDetailFragment.f4985i = true;
                passengerDetailFragment.et_city_town.setError((CharSequence) null);
                passengerDetailFragment.f4974f = arrayList.get(0);
            } else if (arrayList.size() > 1) {
                passengerDetailFragment.onPostOfficeClick((View) null);
            }
        } else {
            passengerDetailFragment.f4903a.dismiss();
        }
    }
}
