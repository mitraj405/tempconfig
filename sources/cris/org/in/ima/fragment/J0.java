package cris.org.in.ima.fragment;

import android.content.DialogInterface;
import cris.org.in.prs.ima.R;
import rx.Subscriber;

/* compiled from: UpdateProfileFragment */
public final class J0 extends Subscriber<C0459BB> {
    public final /* synthetic */ UpdateProfileFragment a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f4660a = false;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public J0(UpdateProfileFragment updateProfileFragment, String str, String str2) {
        this.a = updateProfileFragment;
        this.c = str;
        this.d = str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0137  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCompleted() {
        /*
            r17 = this;
            r0 = r17
            boolean r1 = r0.f4660a
            java.lang.String r2 = r0.c
            java.lang.String r3 = r0.d
            r4 = 1
            cris.org.in.ima.fragment.UpdateProfileFragment r12 = r0.a
            if (r1 != 0) goto L_0x01dd
            android.widget.EditText r1 = r12.email
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            java.lang.String r5 = r12.i
            boolean r1 = r1.equals(r5)
            r13 = -65536(0xffffffffffff0000, float:NaN)
            r5 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r14 = 0
            java.lang.String r15 = ""
            if (r1 != 0) goto L_0x0044
            boolean r1 = r12.f5190b
            if (r1 == 0) goto L_0x0044
            androidx.fragment.app.FragmentActivity r1 = r12.f5185a
            r5 = 2131952616(0x7f1303e8, float:1.954168E38)
            java.lang.String r5 = r12.getString(r5)
            android.widget.Toast r1 = android.widget.Toast.makeText(r1, r5, r4)
            r1.setGravity(r4, r14, r14)
            android.widget.EditText r5 = r12.email
            r5.setTextColor(r13)
            r1.show()
            goto L_0x0100
        L_0x0044:
            android.widget.EditText r1 = r12.email
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            java.lang.String r6 = r12.i
            boolean r1 = r1.equals(r6)
            if (r1 != 0) goto L_0x0100
            if (r3 == 0) goto L_0x0100
            android.content.Context r1 = r12.getContext()
            r6 = 2131952615(0x7f1303e7, float:1.9541678E38)
            java.lang.String r6 = r12.getString(r6)
            android.widget.Toast r1 = android.widget.Toast.makeText(r1, r6, r4)
            r1.setGravity(r4, r14, r14)
            android.widget.EditText r6 = r12.email
            r6.setTextColor(r5)
            r1.show()
            android.widget.EditText r1 = r12.email
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            java.lang.String r1 = r1.trim()
            boolean r1 = r1.equals(r15)
            if (r1 != 0) goto L_0x00e3
            android.widget.EditText r1 = r12.email
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            java.lang.String r5 = r12.i
            boolean r1 = r1.equalsIgnoreCase(r5)
            if (r1 != 0) goto L_0x00c6
            java.lang.String r6 = "E"
            r7 = 0
            android.widget.EditText r1 = r12.email
            android.text.Editable r1 = r1.getText()
            java.lang.String r8 = r1.toString()
            r9 = 0
            r10 = 0
            android.widget.TextView r11 = r12.updateEmail
            android.content.res.Resources r1 = r12.getResources()
            r5 = 2131952625(0x7f1303f1, float:1.9541698E38)
            r1.getString(r5)
            android.widget.EditText r1 = r12.email
            android.text.Editable r1 = r1.getText()
            r1.toString()
            r1 = 2131951928(0x7f130138, float:1.9540284E38)
            r16 = 0
            r5 = r12
            r5.j(r6, r7, r8, r9, r10, r11)
            goto L_0x0105
        L_0x00c6:
            r1 = 2131951928(0x7f130138, float:1.9540284E38)
            r5 = 0
            androidx.fragment.app.FragmentActivity r6 = r12.f5185a
            android.content.res.Resources r7 = r12.getResources()
            r8 = 2131952618(0x7f1303ea, float:1.9541684E38)
            java.lang.String r7 = r7.getString(r8)
            java.lang.String r8 = r12.getString(r1)
            android.app.AlertDialog r6 = defpackage.C0535I5.o(r6, r7, r8, r5)
            r6.show()
            goto L_0x0107
        L_0x00e3:
            r1 = 2131951928(0x7f130138, float:1.9540284E38)
            r5 = 0
            androidx.fragment.app.FragmentActivity r6 = r12.f5185a
            android.content.res.Resources r7 = r12.getResources()
            r8 = 2131952619(0x7f1303eb, float:1.9541686E38)
            java.lang.String r7 = r7.getString(r8)
            java.lang.String r8 = r12.getString(r1)
            android.app.AlertDialog r6 = defpackage.C0535I5.o(r6, r7, r8, r5)
            r6.show()
            goto L_0x0107
        L_0x0100:
            r1 = 2131951928(0x7f130138, float:1.9540284E38)
            r16 = 0
        L_0x0105:
            r5 = r16
        L_0x0107:
            android.widget.EditText r6 = r12.mobile
            android.text.Editable r6 = r6.getText()
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = r12.i
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x0137
            boolean r6 = r12.f5189a
            if (r6 == 0) goto L_0x0137
            androidx.fragment.app.FragmentActivity r1 = r12.f5185a
            r5 = 2131953150(0x7f1305fe, float:1.9542763E38)
            java.lang.String r5 = r12.getString(r5)
            android.widget.Toast r1 = android.widget.Toast.makeText(r1, r5, r4)
            r1.setGravity(r4, r14, r14)
            android.widget.EditText r5 = r12.mobile
            r5.setTextColor(r13)
            r1.show()
            goto L_0x01dd
        L_0x0137:
            android.widget.EditText r6 = r12.mobile
            android.text.Editable r6 = r6.getText()
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = r12.j
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x01dd
            if (r2 == 0) goto L_0x01dd
            android.content.Context r6 = r12.getContext()
            r7 = 2131953149(0x7f1305fd, float:1.954276E38)
            java.lang.String r7 = r12.getString(r7)
            android.widget.Toast r6 = android.widget.Toast.makeText(r6, r7, r4)
            r6.setGravity(r4, r14, r14)
            android.widget.EditText r7 = r12.mobile
            r8 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r7.setTextColor(r8)
            r6.show()
            android.widget.EditText r6 = r12.mobile
            boolean r6 = defpackage.xx.T(r6, r15)
            if (r6 != 0) goto L_0x01c5
            android.widget.EditText r6 = r12.mobile
            android.text.Editable r6 = r6.getText()
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = r12.j
            boolean r6 = r6.equalsIgnoreCase(r7)
            if (r6 != 0) goto L_0x01ac
            java.lang.String r6 = "M"
            android.widget.EditText r1 = r12.mobile
            android.text.Editable r1 = r1.getText()
            java.lang.String r7 = r1.toString()
            r8 = 0
            java.lang.String r9 = "94"
            java.lang.String r10 = "91"
            android.widget.TextView r11 = r12.updateMobile
            android.content.res.Resources r1 = r12.getResources()
            r5 = 2131953155(0x7f130603, float:1.9542773E38)
            r1.getString(r5)
            android.widget.EditText r1 = r12.mobile
            android.text.Editable r1 = r1.getText()
            r1.toString()
            r5 = r12
            r5.j(r6, r7, r8, r9, r10, r11)
            goto L_0x01dd
        L_0x01ac:
            androidx.fragment.app.FragmentActivity r6 = r12.f5185a
            android.content.res.Resources r7 = r12.getResources()
            r8 = 2131953143(0x7f1305f7, float:1.9542749E38)
            java.lang.String r7 = r7.getString(r8)
            java.lang.String r1 = r12.getString(r1)
            android.app.AlertDialog r1 = defpackage.C0535I5.o(r6, r7, r1, r5)
            r1.show()
            goto L_0x01dd
        L_0x01c5:
            androidx.fragment.app.FragmentActivity r6 = r12.f5185a
            android.content.res.Resources r7 = r12.getResources()
            r8 = 2131953144(0x7f1305f8, float:1.954275E38)
            java.lang.String r7 = r7.getString(r8)
            java.lang.String r1 = r12.getString(r1)
            android.app.AlertDialog r1 = defpackage.C0535I5.o(r6, r7, r1, r5)
            r1.show()
        L_0x01dd:
            if (r3 == 0) goto L_0x01f3
            java.util.HashMap<java.lang.String, java.lang.Boolean> r1 = r12.f5188a
            boolean r1 = r1.containsKey(r3)
            if (r1 != 0) goto L_0x01f3
            java.util.HashMap<java.lang.String, java.lang.Boolean> r1 = r12.f5188a
            boolean r5 = r12.f5190b
            r5 = r5 ^ r4
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            r1.put(r3, r5)
        L_0x01f3:
            if (r2 == 0) goto L_0x0209
            java.util.HashMap<java.lang.String, java.lang.Boolean> r1 = r12.f5188a
            boolean r1 = r1.containsKey(r2)
            if (r1 != 0) goto L_0x0209
            java.util.HashMap<java.lang.String, java.lang.Boolean> r1 = r12.f5188a
            boolean r3 = r12.f5189a
            r3 = r3 ^ r4
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r1.put(r2, r3)
        L_0x0209:
            android.app.ProgressDialog r1 = r12.f5183a
            r1.dismiss()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.fragment.J0.onCompleted():void");
    }

    public final void onError(Throwable th) {
        UpdateProfileFragment updateProfileFragment = this.a;
        updateProfileFragment.f5191c = "Error";
        C0657Qt.a();
        updateProfileFragment.f5183a.dismiss();
        Lt.a(false, th);
    }

    public final void onNext(Object obj) {
        boolean z;
        boolean z2;
        String str;
        String str2;
        String str3;
        C0459BB bb = (C0459BB) obj;
        int i = UpdateProfileFragment.c;
        bb.toString();
        UpdateProfileFragment updateProfileFragment = this.a;
        boolean equals = updateProfileFragment.mobile.getText().toString().equals(updateProfileFragment.j);
        String str4 = this.c;
        String str5 = "* ";
        if (!equals && str4 != null && !bb.getMobileAvailable().equalsIgnoreCase("TRUE")) {
            StringBuilder sb = new StringBuilder();
            if (updateProfileFragment.f5191c.length() <= 1 || updateProfileFragment.f5191c.charAt(0) == '*') {
                str2 = "";
            } else {
                str2 = str5;
            }
            sb.append(str2);
            sb.append(updateProfileFragment.f5191c);
            if (updateProfileFragment.f5191c.length() > 1) {
                str3 = str5;
            } else {
                str3 = "";
            }
            sb.append(str3);
            sb.append(updateProfileFragment.getString(R.string.mobilenumber_already_registered));
            updateProfileFragment.f5191c = sb.toString();
            updateProfileFragment.k(8, updateProfileFragment.getString(R.string.mobilenumber_already_registered));
            updateProfileFragment.f5189a = true;
        }
        boolean equals2 = updateProfileFragment.email.getText().toString().equals(updateProfileFragment.i);
        String str6 = this.d;
        if (!equals2 && str6 != null && !bb.getEmailAvailable().equalsIgnoreCase("TRUE")) {
            StringBuilder sb2 = new StringBuilder();
            if (updateProfileFragment.f5191c.length() <= 1 || updateProfileFragment.f5191c.charAt(0) == '*') {
                str = "";
            } else {
                str = str5;
            }
            sb2.append(str);
            sb2.append(updateProfileFragment.f5191c);
            if (updateProfileFragment.f5191c.length() <= 1) {
                str5 = "";
            }
            updateProfileFragment.f5191c = C0709Uj.j(sb2, str5, "Email is already registered.");
            updateProfileFragment.k(9, "Email is already registered.");
            updateProfileFragment.f5190b = true;
        }
        if (!updateProfileFragment.email.getText().toString().equals(updateProfileFragment.i) && str6 != null && !(z2 = updateProfileFragment.f5190b)) {
            updateProfileFragment.f5188a.put(str6, Boolean.valueOf(!z2));
        }
        if (str4 != null && !(z = updateProfileFragment.f5189a)) {
            updateProfileFragment.f5188a.put(str4, Boolean.valueOf(!z));
        }
        if (updateProfileFragment.mobile.getText().equals(updateProfileFragment.j) && updateProfileFragment.email.getText().equals(updateProfileFragment.i)) {
            updateProfileFragment.f5191c = "";
        }
        if (!updateProfileFragment.f5191c.trim().equals("") && this.f4660a) {
            C0535I5.o(updateProfileFragment.f5185a, updateProfileFragment.f5191c, updateProfileFragment.getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
        }
        updateProfileFragment.f5183a.dismiss();
    }
}
