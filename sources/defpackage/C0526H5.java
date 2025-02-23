package defpackage;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.CountryDTO;
import java.util.ArrayList;
import rx.Subscriber;

/* renamed from: H5  reason: default package and case insensitive filesystem */
/* compiled from: CommonUtil */
public final class C0526H5 extends Subscriber<C0812c0> {
    public final /* synthetic */ ProgressDialog a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Context f3604a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f3605a = false;

    public C0526H5(ProgressDialog progressDialog, AppCompatActivity appCompatActivity) {
        this.a = progressDialog;
        this.f3604a = appCompatActivity;
    }

    public final void onCompleted() {
        AlertDialog alertDialog = C0535I5.f3619a;
        this.a.dismiss();
    }

    public final void onError(Throwable th) {
        AlertDialog alertDialog = C0535I5.f3619a;
        th.getClass();
        th.getMessage();
        this.a.dismiss();
        Lt.a(true, th);
    }

    public final void onNext(Object obj) {
        boolean z;
        C0812c0 c0Var = (C0812c0) obj;
        Context context = this.f3604a;
        ProgressDialog progressDialog = this.a;
        if (c0Var == null) {
            progressDialog.dismiss();
            C0535I5.m(context, false, context.getString(R.string.Unable_process_request), context.getString(R.string.error), context.getString(R.string.ok), new C0512G5()).show();
        } else if (c0Var.getError() == null) {
            ArrayList<CountryDTO> countryList = c0Var.getCountryList();
            AlertDialog alertDialog = C0535I5.f3619a;
            if (countryList != null) {
                countryList.toString();
                C0535I5.f3622a.add("India");
                int i = 0;
                while (true) {
                    int size = countryList.size();
                    z = this.f3605a;
                    if (i >= size) {
                        break;
                    }
                    if (z) {
                        C0535I5.f3628b.put(countryList.get(i).getCountry(), countryList.get(i).getCountryCode());
                        C0535I5.f3633c.put(countryList.get(i).getCountryCode(), countryList.get(i).getCountry());
                    } else {
                        C0535I5.f3623a.put(countryList.get(i).getCountry(), countryList.get(i).getCountryId().toString());
                    }
                    C0535I5.f3622a.add(countryList.get(i).getCountry());
                    i++;
                }
                if (!z) {
                    C0535I5.f3623a.put("Other", "1000");
                    C0535I5.f3622a.add("Other");
                }
                progressDialog.dismiss();
                Toast makeText = Toast.makeText(context, context.getString(R.string.country_nationality_list_updated), 1);
                makeText.setGravity(1, 0, 0);
                makeText.show();
            } else {
                progressDialog.dismiss();
                C0535I5.m(context, false, "Service not available. Please try after sometime.", context.getString(R.string.error), context.getString(R.string.ok), new E5()).show();
            }
            progressDialog.dismiss();
        } else {
            C0535I5.m(this.f3604a, false, c0Var.getError(), context.getString(R.string.error), context.getString(R.string.ok), new F5()).show();
        }
    }
}
