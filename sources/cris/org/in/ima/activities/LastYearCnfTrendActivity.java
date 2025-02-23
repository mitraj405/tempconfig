package cris.org.in.ima.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.MaxWLRacCnfDTO;
import java.util.ArrayList;

public class LastYearCnfTrendActivity extends Activity {
    public LinearLayout a;

    /* renamed from: a  reason: collision with other field name */
    public TextView f4205a;

    /* renamed from: a  reason: collision with other field name */
    public RecyclerView f4206a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<MaxWLRacCnfDTO> f4207a;
    public TextView b;
    public TextView c;

    /* renamed from: c  reason: collision with other field name */
    public String f4208c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;

    public class a implements View.OnClickListener {
        public a() {
        }

        public final void onClick(View view) {
            LastYearCnfTrendActivity.this.finish();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public final void onClick(View view) {
            LastYearCnfTrendActivity.this.finish();
        }
    }

    public final void onCreate(Bundle bundle) {
        double d2;
        super.onCreate(bundle);
        setContentView(R.layout.item_cnf_availability_listview);
        this.f4205a = (TextView) findViewById(R.id.tv_name);
        this.b = (TextView) findViewById(R.id.tv_from_city_name);
        this.c = (TextView) findViewById(R.id.tv_to_city_name);
        this.d = (TextView) findViewById(R.id.tv_avl_class);
        this.e = (TextView) findViewById(R.id.current_avl_status);
        this.f = (TextView) findViewById(R.id.current_avl_date);
        this.g = (TextView) findViewById(R.id.prob_cnf_chance);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.current_ll);
        this.a = linearLayout;
        linearLayout.setVisibility(0);
        Intent intent = getIntent();
        if (intent != null) {
            TextView textView = this.f4205a;
            StringBuilder sb = new StringBuilder();
            sb.append(intent.getStringExtra("train_name"));
            sb.append("(");
            sb.append(intent.getStringExtra("train_no"));
            lf.x(sb, ")", textView);
            this.b.setText(intent.getStringExtra("FromStnCode"));
            this.c.setText(intent.getStringExtra("toStnCode"));
            this.d.setText(intent.getStringExtra("tv_class"));
            if (intent.getStringExtra("current_avl_status") == null || intent.getStringExtra("current_avl_status").equals("")) {
                this.a.setVisibility(8);
            } else {
                this.e.setText(intent.getStringExtra("current_avl_status"));
                this.f.setText(intent.getStringExtra("current_avl_date"));
            }
            this.f4208c = intent.getStringExtra("cnf_status");
            TextView textView2 = this.g;
            textView2.setText(getResources().getString(R.string.probability_chance) + intent.getStringExtra("cnf_chance").toString());
        }
        this.f4207a = C0535I5.f3627b;
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.listview);
        this.f4206a = recyclerView;
        if (this.f4207a != null) {
            recyclerView.setAdapter(new U9(getBaseContext(), (ArrayList) this.f4207a));
            this.f4206a.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        }
        String str = this.f4208c;
        str.getClass();
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case 2773:
                if (str.equals("WL")) {
                    c2 = 0;
                    break;
                }
                break;
            case 66875:
                if (str.equals("CNF")) {
                    c2 = 1;
                    break;
                }
                break;
            case 80884:
                if (str.equals("RAC")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                this.g.setTextColor(getResources().getColor(R.color.predict_wl));
                break;
            case 1:
                this.g.setTextColor(getResources().getColor(R.color.predict_cnf));
                break;
            case 2:
                this.g.setTextColor(getResources().getColor(R.color.predict_rac));
                break;
            default:
                this.g.setTextColor(getResources().getColor(R.color.predict_other));
                break;
        }
        ((TextView) findViewById(R.id.btn_ok)).setOnClickListener(new a());
        ((TextView) findViewById(R.id.tv_close_Popup_Btn)).setOnClickListener(new b());
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        ArrayList<MaxWLRacCnfDTO> arrayList = this.f4207a;
        if (arrayList == null || arrayList.size() >= 4) {
            d2 = 0.87d;
        } else {
            d2 = 0.68d;
        }
        getWindow().setLayout((int) (((double) i) * 0.94d), (int) (((double) i2) * d2));
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.gravity = 17;
        attributes.x = 0;
        attributes.y = 20;
        getWindow().setAttributes(attributes);
    }

    public final void onPause() {
        super.onPause();
        getWindow().setFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE, UserMetadata.MAX_INTERNAL_KEY_SIZE);
    }

    public final void onResume() {
        super.onResume();
        getWindow().clearFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE);
    }
}
