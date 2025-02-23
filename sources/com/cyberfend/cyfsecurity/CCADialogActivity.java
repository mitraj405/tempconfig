package com.cyberfend.cyfsecurity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import defpackage.FE;

public class CCADialogActivity extends AppCompatActivity {
    public static final /* synthetic */ int c = 0;
    public Button a;

    /* renamed from: a  reason: collision with other field name */
    public final a f2780a = new a();

    /* renamed from: a  reason: collision with other field name */
    public CircleProgressBar f2781a;

    public class a {
        public a() {
        }
    }

    public class b implements View.OnClickListener {
        public final void onClick(View view) {
            FE fe = FE.a;
            HE he = HE.a;
            int i = he.f337a;
            if (i == 1) {
                he.e(2);
            } else if (i == 3) {
                he.e(0);
            }
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(Rr.activity_ccadialog);
        setFinishOnTouchOutside(false);
        this.f2781a = (CircleProgressBar) findViewById(Cr.dialogActivity_dialog_progressBar);
        String stringExtra = getIntent().getStringExtra("CCA Title");
        String stringExtra2 = getIntent().getStringExtra("CCA Message");
        String stringExtra3 = getIntent().getStringExtra("CCA Cancel Button");
        ((TextView) findViewById(Cr.dialogActivity_dialog_title)).setText(stringExtra);
        ((TextView) findViewById(Cr.dialogActivity_dialog_message)).setText(stringExtra2);
        Button button = (Button) findViewById(Cr.dialogActivity_dialog_button);
        this.a = button;
        button.setText(stringExtra3);
        this.a.setOnClickListener(new b());
        int intExtra = getIntent().getIntExtra("Theme Color", getResources().getColor(C0275mr.akamaiCCAcolorPrimary));
        this.a.setTextColor(intExtra);
        this.f2781a.setProgressBarColor(intExtra);
        FE fe = FE.a;
        fe.f201a = this.f2780a;
        FE.a aVar = new FE.a();
        HE he = HE.a;
        int i = he.f337a;
        he.f260a = aVar;
        if (!(i == 1 || i == 3)) {
            he.f = fe.f202a;
            he.b(1, 100);
        }
        a aVar2 = fe.f201a;
        float f = fe.f200a;
        aVar2.getClass();
        new Handler(Looper.getMainLooper()).post(new a(aVar2, f));
    }

    public final void onBackPressed() {
    }
}
