package defpackage;

import android.widget.TextView;
import cris.org.in.ima.adaptors.CustomAdapter;
import cris.org.in.ima.fragment.CustomDialogFragment;
import cris.org.in.ima.fragment.PassengerDetailFragment;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.CountryDTO;
import java.util.ArrayList;
import java.util.HashMap;
import rx.Subscriber;

/* renamed from: Mo  reason: default package */
/* compiled from: PassengerDetailFragment */
public final class Mo extends Subscriber<C0812c0> {
    public final /* synthetic */ PassengerDetailFragment a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ArrayList f3705a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ HashMap f3706a;
    public final /* synthetic */ HashMap b;

    public Mo(PassengerDetailFragment passengerDetailFragment, ArrayList arrayList, HashMap hashMap, HashMap hashMap2) {
        this.a = passengerDetailFragment;
        this.f3705a = arrayList;
        this.f3706a = hashMap;
        this.b = hashMap2;
    }

    public final void onCompleted() {
        TextView textView = PassengerDetailFragment.a;
    }

    public final void onError(Throwable th) {
        TextView textView = PassengerDetailFragment.a;
        th.getMessage();
        this.a.f4903a.dismiss();
        Lt.a(true, th);
    }

    public final void onNext(Object obj) {
        HashMap<String, String> hashMap;
        HashMap<String, String> hashMap2;
        C0812c0 c0Var = (C0812c0) obj;
        PassengerDetailFragment passengerDetailFragment = this.a;
        if (c0Var == null) {
            passengerDetailFragment.f4903a.dismiss();
            C0535I5.m(passengerDetailFragment.getActivity(), false, passengerDetailFragment.getString(R.string.Unable_process_request), passengerDetailFragment.getString(R.string.error), passengerDetailFragment.getString(R.string.OK), new Lo()).show();
        } else if (c0Var.getError() == null) {
            ArrayList<CountryDTO> countryList = c0Var.getCountryList();
            TextView textView = PassengerDetailFragment.a;
            if (countryList != null) {
                countryList.toString();
                String string = passengerDetailFragment.getString(R.string.India);
                ArrayList<String> arrayList = this.f3705a;
                arrayList.add(string);
                int i = 0;
                while (true) {
                    int size = countryList.size();
                    hashMap = this.f3706a;
                    hashMap2 = this.b;
                    if (i >= size) {
                        break;
                    }
                    hashMap.put(countryList.get(i).getCountry(), countryList.get(i).getCountryCode());
                    hashMap2.put(countryList.get(i).getCountryCode(), countryList.get(i).getCountry());
                    arrayList.add(countryList.get(i).getCountry());
                    i++;
                }
                C0535I5.f3633c = hashMap2;
                C0535I5.f3628b = hashMap;
                C0535I5.f3622a = arrayList;
                passengerDetailFragment.f4903a.dismiss();
                passengerDetailFragment.f4941a = C0535I5.f3628b;
                passengerDetailFragment.f5017v = C0535I5.f3622a;
                CustomDialogFragment customDialogFragment = new CustomDialogFragment();
                customDialogFragment.setShowsDialog(true);
                customDialogFragment.show(passengerDetailFragment.getActivity().getSupportFragmentManager(), "");
                customDialogFragment.setCancelable(true);
                passengerDetailFragment.getActivity().getSupportFragmentManager().z();
                CustomAdapter customAdapter = new CustomAdapter(passengerDetailFragment.getContext(), passengerDetailFragment.f5017v, new C0612No(passengerDetailFragment, customDialogFragment));
                customDialogFragment.g().setText(passengerDetailFragment.getString(R.string.select_Nationality));
                customDialogFragment.f().setAdapter(customAdapter);
                passengerDetailFragment.f4903a.dismiss();
            } else {
                passengerDetailFragment.f4903a.dismiss();
                C0535I5.m(passengerDetailFragment.getActivity(), false, "Service not available. Please try after sometime.", passengerDetailFragment.getString(R.string.error), passengerDetailFragment.getString(R.string.OK), new Jo()).show();
            }
            passengerDetailFragment.f4903a.dismiss();
        } else {
            C0535I5.m(passengerDetailFragment.getActivity(), false, c0Var.getError(), passengerDetailFragment.getString(R.string.error), passengerDetailFragment.getString(R.string.OK), new Ko()).show();
        }
    }
}
