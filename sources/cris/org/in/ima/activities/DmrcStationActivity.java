package cris.org.in.ima.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import cris.org.in.ima.adaptors.DmrcStationAdapter;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.DmrcstatsionDto;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class DmrcStationActivity extends AppCompatActivity {
    public Intent a;

    /* renamed from: a  reason: collision with other field name */
    public final f f4156a = new f();

    /* renamed from: a  reason: collision with other field name */
    public DmrcStationAdapter f4157a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<DmrcstatsionDto> f4158a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public final HashMap<String, List> f4159a = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    public boolean f4160a;
    public final ArrayList<DmrcstatsionDto> b = new ArrayList<>();
    public String c = "";

    /* renamed from: c  reason: collision with other field name */
    public ArrayList<C1322p9> f4161c = new ArrayList<>();
    public String d = "";
    @BindView(2131363811)
    RecyclerView dmrcstationList;
    @BindView(2131362439)
    TextView dmrctvRecentSearch;
    @BindView(2131364375)
    EditText tvDmrcsearchtext;
    @BindView(2131364421)
    TextView tv_from_distance;

    public class a extends TypeToken<ArrayList<DmrcstatsionDto>> {
    }

    public class b extends TypeToken<ArrayList<C1322p9>> {
    }

    public class c implements Comparator<DmrcstatsionDto> {
        public final int compare(Object obj, Object obj2) {
            return Integer.compare((int) ((DmrcstatsionDto) obj).getDistance(), (int) ((DmrcstatsionDto) obj2).getDistance());
        }
    }

    public class d implements Comparator<DmrcstatsionDto> {
        public final int compare(Object obj, Object obj2) {
            return Integer.compare(((DmrcstatsionDto) obj).getDmrclinecolorcode(), ((DmrcstatsionDto) obj2).getDmrclinecolorcode());
        }
    }

    public class e implements Comparator<DmrcstatsionDto> {
        public final int compare(Object obj, Object obj2) {
            return Integer.compare((int) ((DmrcstatsionDto) obj).getDistance(), (int) ((DmrcstatsionDto) obj2).getDistance());
        }
    }

    public class f implements DmrcStationAdapter.DmrcStationListAdapterStnSelectListener {
        public f() {
        }

        public final void onStationClick(DmrcstatsionDto dmrcstatsionDto) {
            DmrcStationActivity dmrcStationActivity = DmrcStationActivity.this;
            dmrcStationActivity.f4160a = false;
            dmrcStationActivity.tvDmrcsearchtext.setText(dmrcstatsionDto.getDmrcstationname());
            dmrcStationActivity.b.clear();
            dmrcStationActivity.f4157a.notifyDataSetChanged();
            Intent intent = new Intent();
            if (!dmrcStationActivity.tvDmrcsearchtext.getText().equals("")) {
                C0535I5.I(dmrcStationActivity);
                if (dmrcStationActivity.a.getIntExtra("dmrcStationView", 0) == 1) {
                    if (dmrcStationActivity.a.getStringExtra("FromDmrcStationHint").equalsIgnoreCase(dmrcstatsionDto.getDmrcstationname())) {
                        Toast makeText = Toast.makeText(dmrcStationActivity, dmrcStationActivity.getString(R.string.souece_and_destination_cant_same), 1);
                        makeText.setGravity(1, 0, 0);
                        makeText.show();
                    } else {
                        dmrcStationActivity.dmrctvRecentSearch.setHint(dmrcStationActivity.getString(R.string.enter_from_metro_satation_name));
                        intent.putExtra("toDmrcStationName", dmrcstatsionDto.getDmrcstationname());
                        intent.putExtra("dmrcstatsionDto", dmrcstatsionDto);
                        dmrcStationActivity.setResult(2, intent);
                        dmrcStationActivity.finish();
                    }
                }
                if (dmrcStationActivity.a.getIntExtra("dmrcStationView", 0) != 0) {
                    return;
                }
                if (dmrcStationActivity.a.getStringExtra("ToDmrcStationHint").equalsIgnoreCase(dmrcstatsionDto.getDmrcstationname())) {
                    dmrcStationActivity.dmrctvRecentSearch.setHint("Enter Destination city/station name or code");
                    Toast makeText2 = Toast.makeText(dmrcStationActivity, dmrcStationActivity.getString(R.string.souece_and_destination_cant_same), 1);
                    makeText2.setGravity(1, 0, 0);
                    makeText2.show();
                    return;
                }
                dmrcStationActivity.dmrctvRecentSearch.setHint(dmrcStationActivity.getString(R.string.enter_destination_metro_satation_name));
                intent.putExtra("fromDmrcStationName", dmrcstatsionDto.getDmrcstationname());
                intent.putExtra("dmrcstatsionDto", dmrcstatsionDto);
                dmrcStationActivity.setResult(0, intent);
                dmrcStationActivity.finish();
            }
        }
    }

    public static boolean l(ArrayList arrayList, DmrcstatsionDto dmrcstatsionDto) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (((DmrcstatsionDto) it.next()).getDmrcstationname().equalsIgnoreCase(dmrcstatsionDto.getDmrcstationname())) {
                return true;
            }
        }
        return false;
    }

    public final void attachBaseContext(Context context) {
        super.attachBaseContext(C0575LC.a(context));
    }

    @OnClick({2131362015})
    public void backClick() {
        C0535I5.I(this);
        finish();
    }

    @OnTextChanged({2131364375})
    public void dmrcStationSearchClick(CharSequence charSequence) {
        int length = charSequence.length();
        ArrayList<DmrcstatsionDto> arrayList = this.b;
        if (length != 0) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            if (this.f4160a) {
                ArrayList<DmrcstatsionDto> arrayList5 = this.f4158a;
                if (arrayList5 != null) {
                    Iterator<DmrcstatsionDto> it = arrayList5.iterator();
                    while (it.hasNext()) {
                        DmrcstatsionDto next = it.next();
                        if (next.getDmrcstationname().toUpperCase().startsWith(charSequence.toString().toUpperCase())) {
                            arrayList3.add(next);
                            if (arrayList3.size() >= 100) {
                                break;
                            }
                        }
                    }
                    Iterator<DmrcstatsionDto> it2 = this.f4158a.iterator();
                    while (it2.hasNext()) {
                        DmrcstatsionDto next2 = it2.next();
                        if (next2.getDmrcstationname().toUpperCase().contains(charSequence.toString().toUpperCase())) {
                            arrayList4.add(next2);
                            if (arrayList4.size() >= 100) {
                                break;
                            }
                        }
                    }
                }
                Iterator it3 = arrayList3.iterator();
                while (it3.hasNext()) {
                    DmrcstatsionDto dmrcstatsionDto = (DmrcstatsionDto) it3.next();
                    if (!l(arrayList2, dmrcstatsionDto)) {
                        arrayList2.add(dmrcstatsionDto);
                    }
                    if (arrayList2.size() >= 100) {
                        break;
                    }
                }
                Iterator it4 = arrayList4.iterator();
                while (it4.hasNext()) {
                    DmrcstatsionDto dmrcstatsionDto2 = (DmrcstatsionDto) it4.next();
                    if (!l(arrayList2, dmrcstatsionDto2)) {
                        arrayList2.add(dmrcstatsionDto2);
                    }
                    if (arrayList2.size() >= 100) {
                        break;
                    }
                }
                arrayList.clear();
                arrayList.addAll(arrayList2);
                this.f4157a.notifyDataSetChanged();
                return;
            }
            return;
        }
        arrayList.clear();
        arrayList.addAll(this.f4158a);
        this.f4157a.notifyDataSetChanged();
    }

    public final void onCreate(Bundle bundle) {
        HashMap<String, List> hashMap;
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_dmrc_station);
        ButterKnife.bind((Activity) this);
        Gson gson = new Gson();
        Bw e2 = Bw.e(getApplicationContext());
        String b2 = e2.b();
        String a2 = e2.a();
        Type type = new a().getType();
        Type type2 = new b().getType();
        this.f4158a = (ArrayList) gson.fromJson(b2, type);
        this.f4161c = (ArrayList) gson.fromJson(a2, type2);
        ArrayList<DmrcstatsionDto> arrayList = this.b;
        arrayList.addAll(this.f4158a);
        Bundle extras = getIntent().getExtras();
        if (extras != null && !extras.isEmpty()) {
            this.c = extras.getString("fromStnCode");
            this.d = extras.getString("toStnCode");
        }
        this.a = getIntent();
        this.f4160a = true;
        int i = 0;
        while (true) {
            int size = this.f4161c.size();
            hashMap = this.f4159a;
            if (i >= size) {
                break;
            }
            hashMap.put(this.f4161c.get(i).getKey(), this.f4161c.get(i).getValue());
            i++;
        }
        int intExtra = this.a.getIntExtra("dmrcStationView", 0);
        f fVar = this.f4156a;
        if (intExtra == 0) {
            this.tvDmrcsearchtext.setHint(getString(R.string.enter_from_metro_satation_name));
            if (hashMap.keySet().equals("GZB")) {
                this.f4157a = new DmrcStationAdapter(this, arrayList, fVar);
                this.dmrcstationList.setLayoutManager(new LinearLayoutManager(this));
                this.dmrcstationList.setAdapter(this.f4157a);
            } else if (hashMap.keySet().contains(this.d)) {
                List list = hashMap.get(this.d);
                Collections.sort(list, new c());
                this.tv_from_distance.setText(getApplicationContext().getResources().getString(R.string.from_distance));
                this.f4157a = new DmrcStationAdapter(this, (ArrayList) list, fVar);
                this.dmrcstationList.setLayoutManager(new LinearLayoutManager(this));
                this.dmrcstationList.setAdapter(this.f4157a);
            } else {
                Collections.sort(arrayList, new d());
                this.tv_from_distance.setText("");
                this.f4157a = new DmrcStationAdapter(this, arrayList, fVar);
                this.dmrcstationList.setLayoutManager(new LinearLayoutManager(this));
                this.dmrcstationList.setAdapter(this.f4157a);
            }
        } else if (this.a.getIntExtra("dmrcStationView", 0) == 1) {
            this.tvDmrcsearchtext.setHint(getString(R.string.enter_destination_metro_satation_name));
            if (hashMap.keySet().equals("GZB")) {
                this.f4157a = new DmrcStationAdapter(this, arrayList, fVar);
                this.dmrcstationList.setLayoutManager(new LinearLayoutManager(this));
                this.dmrcstationList.setAdapter(this.f4157a);
            } else if (hashMap.keySet().contains(this.c)) {
                Collections.sort(hashMap.get(this.c), new e());
                this.tv_from_distance.setText(getApplicationContext().getResources().getString(R.string.from_distance));
                this.f4157a = new DmrcStationAdapter(this, (ArrayList) hashMap.get(this.c), fVar);
                this.dmrcstationList.setLayoutManager(new LinearLayoutManager(this));
                this.dmrcstationList.setAdapter(this.f4157a);
            } else {
                this.tv_from_distance.setText("");
                this.f4157a = new DmrcStationAdapter(this, arrayList, fVar);
                this.dmrcstationList.setLayoutManager(new LinearLayoutManager(this));
                this.dmrcstationList.setAdapter(this.f4157a);
            }
        }
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
