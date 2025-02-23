package cris.org.in.ima.activities;

import android.content.DialogInterface;
import android.widget.Toast;
import cris.org.in.prs.ima.R;
import rx.Subscriber;

/* compiled from: RegistrationActivity */
public final class E extends Subscriber<C0459BB> {
    public final /* synthetic */ RegistrationActivity a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f4164a;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;

    public E(RegistrationActivity registrationActivity, String str, String str2, String str3, boolean z) {
        this.a = registrationActivity;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f4164a = z;
    }

    public final void onCompleted() {
        RegistrationActivity registrationActivity = this.a;
        registrationActivity.m();
        boolean z = this.f4164a;
        String str = this.d;
        String str2 = this.e;
        String str3 = this.c;
        if (!z) {
            if (registrationActivity.f4310c) {
                Toast makeText = Toast.makeText(registrationActivity.f4300a, registrationActivity.getString(R.string.email_ID_not_available), 1);
                makeText.setGravity(1, 0, 0);
                registrationActivity.email.setTextColor(-65536);
                makeText.show();
            } else if (str2 != null) {
                Toast makeText2 = Toast.makeText(registrationActivity.f4300a, registrationActivity.getString(R.string.email_ID_available), 1);
                makeText2.setGravity(1, 0, 0);
                registrationActivity.email.setTextColor(-16777216);
                makeText2.show();
            }
            if (registrationActivity.f4306b) {
                registrationActivity.mobile.setTextColor(-65536);
            } else if (str != null) {
                Toast makeText3 = Toast.makeText(registrationActivity.f4300a, registrationActivity.getString(R.string.mobile_number_available), 1);
                makeText3.setGravity(1, 0, 0);
                registrationActivity.mobile.setTextColor(-16777216);
                makeText3.show();
            }
            if (registrationActivity.f4304a) {
                Toast makeText4 = Toast.makeText(registrationActivity.f4300a, registrationActivity.getString(R.string.user_name_not_available), 1);
                makeText4.setGravity(1, 0, 0);
                registrationActivity.userName.setTextColor(-65536);
                makeText4.show();
            } else if (str3 != null) {
                Toast makeText5 = Toast.makeText(registrationActivity.f4300a, registrationActivity.getString(R.string.user_name_available), 1);
                makeText5.setGravity(1, 0, 0);
                registrationActivity.userName.setTextColor(-16777216);
                makeText5.show();
            }
        }
        if (str3 != null && !registrationActivity.f4303a.containsKey(str3)) {
            registrationActivity.f4303a.put(str3, Boolean.valueOf(!registrationActivity.f4304a));
        }
        if (str2 != null && !registrationActivity.f4303a.containsKey(str2)) {
            registrationActivity.f4303a.put(str2, Boolean.valueOf(!registrationActivity.f4310c));
        }
        if (str != null && !registrationActivity.f4303a.containsKey(str)) {
            registrationActivity.f4303a.put(str, Boolean.valueOf(!registrationActivity.f4306b));
        }
    }

    public final void onError(Throwable th) {
        RegistrationActivity registrationActivity = this.a;
        registrationActivity.f4307c = "Error";
        C0657Qt.a();
        registrationActivity.m();
        Lt.a(false, th);
    }

    public final void onNext(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        String str;
        String str2;
        String str3;
        C0459BB bb = (C0459BB) obj;
        RegistrationActivity registrationActivity = this.a;
        registrationActivity.m();
        int i = RegistrationActivity.d;
        bb.toString();
        String str4 = this.c;
        if (!(str4 == null || bb.getUseridAvailable() == null || bb.getUseridAvailable().equalsIgnoreCase("TRUE"))) {
            registrationActivity.f4307c += registrationActivity.getString(R.string.username_already_registered);
            registrationActivity.p(1, registrationActivity.getString(R.string.username_already_registered));
            registrationActivity.f4304a = true;
        }
        String str5 = this.d;
        String str6 = "* ";
        if (!(str5 == null || bb.getMobileAvailable() == null || bb.getMobileAvailable().equalsIgnoreCase("TRUE"))) {
            StringBuilder sb = new StringBuilder();
            if (registrationActivity.f4307c.length() <= 1 || registrationActivity.f4307c.charAt(0) == '*') {
                str2 = "";
            } else {
                str2 = str6;
            }
            sb.append(str2);
            sb.append(registrationActivity.f4307c);
            if (registrationActivity.f4307c.length() > 1) {
                str3 = str6;
            } else {
                str3 = "";
            }
            sb.append(str3);
            sb.append(registrationActivity.getString(R.string.mobilenumber_already_registered));
            registrationActivity.f4307c = sb.toString();
            registrationActivity.p(8, registrationActivity.getString(R.string.mobilenumber_already_registered));
            registrationActivity.f4306b = true;
        }
        String str7 = this.e;
        if (!(str7 == null || bb.getEmailAvailable() == null || bb.getEmailAvailable().equalsIgnoreCase("TRUE"))) {
            StringBuilder sb2 = new StringBuilder();
            if (registrationActivity.f4307c.length() <= 1 || registrationActivity.f4307c.charAt(0) == '*') {
                str = "";
            } else {
                str = str6;
            }
            sb2.append(str);
            sb2.append(registrationActivity.f4307c);
            if (registrationActivity.f4307c.length() <= 1) {
                str6 = "";
            }
            sb2.append(str6);
            sb2.append(registrationActivity.getString(R.string.email_already_registered));
            registrationActivity.f4307c = sb2.toString();
            registrationActivity.p(9, registrationActivity.getString(R.string.email_already_registered));
            registrationActivity.f4310c = true;
        }
        if (str4 != null && !(z3 = registrationActivity.f4304a)) {
            registrationActivity.f4303a.put(str4, Boolean.valueOf(!z3));
        }
        if (str7 != null && !(z2 = registrationActivity.f4310c)) {
            registrationActivity.f4303a.put(str7, Boolean.valueOf(!z2));
        }
        if (str5 != null && !(z = registrationActivity.f4306b)) {
            registrationActivity.f4303a.put(str5, Boolean.valueOf(!z));
        }
        boolean equals = registrationActivity.f4307c.trim().equals("");
        boolean z4 = this.f4164a;
        if (!equals && z4) {
            C0535I5.o(registrationActivity.f4300a, registrationActivity.f4307c, "OK", (DialogInterface.OnClickListener) null).show();
        } else if (z4) {
            registrationActivity.x();
        }
    }
}
