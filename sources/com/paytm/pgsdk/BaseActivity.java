package com.paytm.pgsdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import defpackage.C1310ov;
import java.util.concurrent.ConcurrentHashMap;

public class BaseActivity extends Activity {

    public class a {
        public DialogInterface.OnClickListener a;

        /* renamed from: a  reason: collision with other field name */
        public String f4096a;
        public DialogInterface.OnClickListener b;

        /* renamed from: b  reason: collision with other field name */
        public String f4097b;
        public String c;
    }

    public a getDialogParams() {
        return new a();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onDestroy() {
        super.onDestroy();
        String simpleName = getClass().getSimpleName();
        ConcurrentHashMap<C1310ov.a, C1310ov> concurrentHashMap = C1310ov.a;
        if (concurrentHashMap != null) {
            try {
                for (C1310ov.a next : concurrentHashMap.keySet()) {
                    String str = next.a;
                    if (str != null && str.equalsIgnoreCase(simpleName)) {
                        C1310ov ovVar = concurrentHashMap.get(next);
                        if (ovVar.getStatus() == AsyncTask.Status.RUNNING && ovVar.cancel(true)) {
                            concurrentHashMap.remove(next);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public AlertDialog openGenericDialog(a aVar) {
        DialogInterface.OnClickListener onClickListener;
        DialogInterface.OnClickListener onClickListener2;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if (!TextUtils.isEmpty(aVar.f4097b)) {
            builder.setTitle(aVar.f4097b);
        }
        if (!TextUtils.isEmpty(aVar.f4096a)) {
            builder.setMessage(aVar.f4096a);
        }
        if (!TextUtils.isEmpty(aVar.c) && (onClickListener2 = aVar.a) != null) {
            builder.setPositiveButton(aVar.c, onClickListener2);
        }
        if (!TextUtils.isEmpty((CharSequence) null) && (onClickListener = aVar.b) != null) {
            builder.setNegativeButton((CharSequence) null, onClickListener);
        }
        return builder.create();
    }
}
