package cris.org.in.ima.activities;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTouch;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.gson.reflect.TypeToken;
import cris.org.in.ima.adaptors.FavoriteStationListAdapter;
import cris.org.in.ima.adaptors.StationListAdapter;
import cris.org.in.ima.model.StationModel;
import cris.org.in.prs.ima.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class StationListActivity extends AppCompatActivity {
    public Intent a;

    /* renamed from: a  reason: collision with other field name */
    public final d f4350a = new d();

    /* renamed from: a  reason: collision with other field name */
    public final e f4351a = new e();

    /* renamed from: a  reason: collision with other field name */
    public final f f4352a = new f();

    /* renamed from: a  reason: collision with other field name */
    public FavoriteStationListAdapter f4353a;

    /* renamed from: a  reason: collision with other field name */
    public StationListAdapter f4354a;

    /* renamed from: a  reason: collision with other field name */
    public StationModel f4355a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<StationModel> f4356a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public List<StationModel> f4357a = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    public boolean f4358a;
    public StationListAdapter b;

    /* renamed from: b  reason: collision with other field name */
    public final ArrayList<StationModel> f4359b = new ArrayList<>();
    public final int c = 25;

    /* renamed from: c  reason: collision with other field name */
    public String f4360c = "false";

    /* renamed from: c  reason: collision with other field name */
    public final ArrayList<StationModel> f4361c = new ArrayList<>();
    @BindView(2131362642)
    LinearLayout favourityLl;
    @BindView(2131363522)
    LinearLayout popularLl;
    @BindView(2131363561)
    AdManagerAdView publisherAdView;
    @BindView(2131364553)
    TextView recentStationSearch;
    @BindView(2131363813)
    RecyclerView rvFavouriteList;
    @BindView(2131363827)
    RecyclerView rvPopularstationList;
    @BindView(2131363836)
    RecyclerView stationList;
    @BindView(2131364587)
    EditText stationSearch;
    @BindView(2131364403)
    TextView txfavourite;
    @BindView(2131364536)
    TextView txpopular;
    @BindView(2131364832)
    View view_recentsearch;

    public class a extends TypeToken<ArrayList<C0742Wx>> {
    }

    public class b extends TypeToken<ArrayList<String>> {
    }

    public class c extends TypeToken<LinkedHashMap<String, ArrayList<C0742Wx>>> {
    }

    public class d implements StationListAdapter.StationListAdapterStnSelectListener {
        public d() {
        }

        public final void onStationClick(StationModel stationModel) {
            StationListActivity stationListActivity = StationListActivity.this;
            stationListActivity.f4355a = stationModel;
            stationListActivity.f4358a = false;
            EditText editText = stationListActivity.stationSearch;
            editText.setText(stationModel.b + " (" + stationModel.f5341a + ")");
            stationListActivity.f4356a.clear();
            stationListActivity.f4354a.notifyDataSetChanged();
            stationListActivity.f4358a = true;
            Intent intent = new Intent();
            StationModel stationModel2 = stationListActivity.f4355a;
            if (!stationListActivity.stationSearch.getText().equals("")) {
                C0535I5.I(stationListActivity);
                if (stationListActivity.a.getIntExtra("stationView", 0) == 1) {
                    String stringExtra = stationListActivity.a.getStringExtra("FromStationHint");
                    if (stringExtra.equalsIgnoreCase(stationModel2.f5341a + "-" + stationModel2.b)) {
                        Toast makeText = Toast.makeText(stationListActivity, stationListActivity.getString(R.string.souece_and_destination_cant_same), 1);
                        makeText.setGravity(1, 0, 0);
                        makeText.show();
                    } else {
                        stationListActivity.stationSearch.setHint(stationListActivity.getString(R.string.enter_from__satation_code));
                        intent.putExtra("toStationCode", stationModel2.f5341a + "-" + stationModel2.b);
                        intent.putExtra("favouritelist", "false");
                        stationListActivity.setResult(2, intent);
                        stationListActivity.finish();
                    }
                }
                if (stationListActivity.a.getIntExtra("stationView", 0) == 0) {
                    String stringExtra2 = stationListActivity.a.getStringExtra("ToStationHint");
                    if (stringExtra2.equalsIgnoreCase(stationModel2.f5341a + "-" + stationModel2.b)) {
                        stationListActivity.stationSearch.setHint("Enter Destination city/station name or code");
                        Toast makeText2 = Toast.makeText(stationListActivity, stationListActivity.getString(R.string.souece_and_destination_cant_same), 1);
                        makeText2.setGravity(1, 0, 0);
                        makeText2.show();
                        return;
                    }
                    stationListActivity.stationSearch.setHint(stationListActivity.getString(R.string.enter_destination__satation_code));
                    intent.putExtra("fromStationCode", stationModel2.f5341a + "-" + stationModel2.b);
                    intent.putExtra("favouritelist", "false");
                    stationListActivity.setResult(0, intent);
                    stationListActivity.finish();
                }
            }
        }
    }

    public class e implements StationListAdapter.StationListAdapterStnSelectListener {
        public e() {
        }

        public final void onStationClick(StationModel stationModel) {
            StationListActivity stationListActivity = StationListActivity.this;
            stationListActivity.f4355a = stationModel;
            stationListActivity.f4358a = false;
            EditText editText = stationListActivity.stationSearch;
            editText.setText(stationModel.b + " (" + stationModel.f5341a + ")");
            stationListActivity.f4359b.clear();
            stationListActivity.b.notifyDataSetChanged();
            stationListActivity.f4358a = true;
            Intent intent = new Intent();
            StationModel stationModel2 = stationListActivity.f4355a;
            if (!stationListActivity.stationSearch.getText().equals("")) {
                C0535I5.I(stationListActivity);
                if (stationListActivity.a.getIntExtra("stationView", 0) == 1) {
                    String stringExtra = stationListActivity.a.getStringExtra("FromStationHint");
                    if (stringExtra.equalsIgnoreCase(stationModel2.f5341a + "-" + stationModel2.b)) {
                        Toast makeText = Toast.makeText(stationListActivity, stationListActivity.getString(R.string.souece_and_destination_cant_same), 1);
                        makeText.setGravity(1, 0, 0);
                        makeText.show();
                    } else {
                        stationListActivity.stationSearch.setHint(stationListActivity.getString(R.string.enter_from__satation_code));
                        intent.putExtra("toStationCode", stationModel2.f5341a + "-" + stationModel2.b);
                        intent.putExtra("favouritelist", "false");
                        stationListActivity.setResult(2, intent);
                        stationListActivity.finish();
                    }
                }
                if (stationListActivity.a.getIntExtra("stationView", 0) == 0) {
                    String stringExtra2 = stationListActivity.a.getStringExtra("ToStationHint");
                    if (stringExtra2.equalsIgnoreCase(stationModel2.f5341a + "-" + stationModel2.b)) {
                        stationListActivity.stationSearch.setHint(stationListActivity.getString(R.string.enter_destination__satation_code));
                        Toast makeText2 = Toast.makeText(stationListActivity, stationListActivity.getString(R.string.souece_and_destination_cant_same), 1);
                        makeText2.setGravity(1, 0, 0);
                        makeText2.show();
                        return;
                    }
                    stationListActivity.stationSearch.setHint(stationListActivity.getString(R.string.enter_destination__satation_code));
                    intent.putExtra("fromStationCode", stationModel2.f5341a + "-" + stationModel2.b);
                    intent.putExtra("favouritelist", "false");
                    stationListActivity.setResult(0, intent);
                    stationListActivity.finish();
                }
            }
        }
    }

    public class f implements FavoriteStationListAdapter.StationListAdapterStnSelectListener {
        public f() {
        }

        public final void onStationClick(StationModel stationModel) {
            StationListActivity stationListActivity = StationListActivity.this;
            stationListActivity.f4355a = stationModel;
            stationListActivity.f4358a = false;
            EditText editText = stationListActivity.stationSearch;
            editText.setText(stationModel.b + " (" + stationModel.f5341a + ")");
            stationListActivity.f4361c.clear();
            stationListActivity.f4353a.notifyDataSetChanged();
            stationListActivity.f4358a = true;
            Intent intent = new Intent();
            StationModel stationModel2 = stationListActivity.f4355a;
            if (!stationListActivity.stationSearch.getText().equals("")) {
                C0535I5.I(stationListActivity);
                intent.putExtra("toStationCode", stationModel2.f5341a);
                intent.putExtra("fromStationCode", stationModel2.b);
                intent.putExtra("favouritelist", "true");
                stationListActivity.setResult(2, intent);
                stationListActivity.finish();
            }
        }
    }

    public static Boolean l(ArrayList arrayList, StationModel stationModel) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (((StationModel) it.next()).f5341a.equalsIgnoreCase(stationModel.f5341a)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    public static int m(String str, String str2) {
        int i;
        int length = str.length() + 1;
        int length2 = str2.length() + 1;
        int[] iArr = new int[length];
        int[] iArr2 = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = i2;
        }
        int i3 = 1;
        while (i3 < length2) {
            int i4 = i3 - 1;
            iArr2[0] = i4;
            for (int i5 = 1; i5 < length; i5++) {
                int i6 = i5 - 1;
                if (str.charAt(i6) == str2.charAt(i4)) {
                    i = 0;
                } else {
                    i = 1;
                }
                iArr2[i5] = Math.min(Math.min(iArr[i5] + 1, iArr2[i6] + 1), iArr[i6] + i);
            }
            i3++;
            int[] iArr3 = iArr2;
            iArr2 = iArr;
            iArr = iArr3;
        }
        return iArr[length - 1];
    }

    public final void attachBaseContext(Context context) {
        super.attachBaseContext(C0575LC.a(context));
    }

    @OnClick({2131362015})
    public void backClick() {
        C0535I5.I(this);
        finish();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r8v4 */
    /* JADX WARNING: type inference failed for: r8v6, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r8v7 */
    /* JADX WARNING: type inference failed for: r8v8 */
    /* JADX WARNING: type inference failed for: r8v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0149 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r15) {
        /*
            r14 = this;
            super.onCreate(r15)
            r15 = 2131558608(0x7f0d00d0, float:1.8742537E38)
            r14.setContentView((int) r15)
            butterknife.ButterKnife.bind((android.app.Activity) r14)
            android.content.Intent r15 = r14.getIntent()
            r14.a = r15
            android.widget.TextView r15 = r14.recentStationSearch
            r0 = 0
            r15.setVisibility(r0)
            androidx.recyclerview.widget.RecyclerView r15 = r14.stationList
            androidx.recyclerview.widget.LinearLayoutManager r1 = new androidx.recyclerview.widget.LinearLayoutManager
            r1.<init>(r14)
            r15.setLayoutManager(r1)
            cris.org.in.ima.adaptors.StationListAdapter r15 = new cris.org.in.ima.adaptors.StationListAdapter
            java.util.ArrayList<cris.org.in.ima.model.StationModel> r1 = r14.f4356a
            cris.org.in.ima.activities.StationListActivity$d r2 = r14.f4350a
            r15.<init>(r14, r1, r2)
            r14.f4354a = r15
            androidx.recyclerview.widget.RecyclerView r2 = r14.stationList
            r2.setAdapter(r15)
            androidx.recyclerview.widget.RecyclerView r15 = r14.rvPopularstationList
            androidx.recyclerview.widget.LinearLayoutManager r2 = new androidx.recyclerview.widget.LinearLayoutManager
            r2.<init>(r14)
            r15.setLayoutManager(r2)
            cris.org.in.ima.adaptors.StationListAdapter r15 = new cris.org.in.ima.adaptors.StationListAdapter
            java.util.ArrayList<cris.org.in.ima.model.StationModel> r2 = r14.f4359b
            cris.org.in.ima.activities.StationListActivity$e r3 = r14.f4351a
            r15.<init>(r14, r2, r3)
            r14.b = r15
            androidx.recyclerview.widget.RecyclerView r2 = r14.rvPopularstationList
            r2.setAdapter(r15)
            androidx.recyclerview.widget.RecyclerView r15 = r14.rvFavouriteList
            androidx.recyclerview.widget.LinearLayoutManager r2 = new androidx.recyclerview.widget.LinearLayoutManager
            r2.<init>(r14)
            r15.setLayoutManager(r2)
            cris.org.in.ima.adaptors.FavoriteStationListAdapter r15 = new cris.org.in.ima.adaptors.FavoriteStationListAdapter
            java.util.ArrayList<cris.org.in.ima.model.StationModel> r2 = r14.f4361c
            cris.org.in.ima.activities.StationListActivity$f r3 = r14.f4352a
            r15.<init>(r14, r2, r3)
            r14.f4353a = r15
            androidx.recyclerview.widget.RecyclerView r2 = r14.rvFavouriteList
            r2.setAdapter(r15)
            b1 r15 = defpackage.C0793b1.a
            cris.org.in.ima.db.StationDb r2 = r15.f3911a
            java.util.ArrayList r3 = r2.c()
            if (r3 == 0) goto L_0x007d
            java.util.ArrayList r2 = r2.c()
            r3 = 100
            java.util.List r2 = r2.subList(r0, r3)
            r14.f4357a = r2
            goto L_0x008e
        L_0x007d:
            android.content.Context r2 = r14.getApplicationContext()
            r3 = 2131953888(0x7f1308e0, float:1.954426E38)
            java.lang.String r3 = r14.getString(r3)
            defpackage.C0535I5.t0(r2, r3)
            r14.finish()
        L_0x008e:
            cris.org.in.ima.db.StationDb r15 = r15.f3911a
            java.util.ArrayList r2 = r15.e()
            r3 = 1
            if (r2 != 0) goto L_0x009c
            r14.stationSerchClick()
            goto L_0x0163
        L_0x009c:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Iterator r2 = r2.iterator()
        L_0x00a5:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x0158
            java.lang.Object r5 = r2.next()
            cris.org.in.ima.model.StationModel r5 = (cris.org.in.ima.model.StationModel) r5
            cris.org.in.ima.model.StationModel r6 = new cris.org.in.ima.model.StationModel
            r6.<init>()
            java.lang.String r7 = r5.f5341a
            r6.f5341a = r7
            java.lang.String r7 = r5.f5341a
            java.lang.String r7 = r15.n(r7)
            java.lang.String r8 = r5.f5341a
            java.lang.String r8 = r15.n(r8)
            r6.d = r8
            r6.b = r7
            java.lang.String r7 = r5.f5341a
            java.lang.String r7 = r15.h(r7)
            java.lang.String r8 = r5.f5341a
            java.lang.String r8 = r15.h(r8)
            r6.c = r7
            r6.e = r8
            java.lang.String r7 = r5.f5341a
            r8 = 0
            android.database.sqlite.SQLiteDatabase r9 = r15.getReadableDatabase()     // Catch:{ SQLiteException -> 0x013d, all -> 0x0130 }
            java.lang.String r10 = "SELECT sStateEn, sStateHi FROM stns WHERE scode MATCH ?"
            java.lang.String[] r11 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x012e, all -> 0x012c }
            r11[r0] = r7     // Catch:{ SQLiteException -> 0x012e, all -> 0x012c }
            android.database.Cursor r7 = r9.rawQuery(r10, r11)     // Catch:{ SQLiteException -> 0x012e, all -> 0x012c }
            boolean r10 = r7.moveToFirst()     // Catch:{ SQLiteException -> 0x013f, all -> 0x0129 }
            if (r10 == 0) goto L_0x0125
        L_0x00f1:
            java.lang.String r10 = r7.getString(r0)     // Catch:{ SQLiteException -> 0x013f, all -> 0x0129 }
            java.lang.String r11 = r7.getString(r3)     // Catch:{ SQLiteException -> 0x013f, all -> 0x0129 }
            boolean r12 = r7.moveToNext()     // Catch:{ SQLiteException -> 0x013f, all -> 0x0129 }
            if (r12 != 0) goto L_0x00f1
            r7.close()     // Catch:{ SQLiteException -> 0x013f, all -> 0x0129 }
            r9.close()     // Catch:{ SQLiteException -> 0x013f, all -> 0x0129 }
            java.lang.String r12 = cris.org.in.ima.IrctcImaApplication.e     // Catch:{ SQLiteException -> 0x013f, all -> 0x0129 }
            java.lang.String r13 = "hi"
            boolean r12 = r12.equalsIgnoreCase(r13)     // Catch:{ SQLiteException -> 0x013f, all -> 0x0129 }
            if (r12 == 0) goto L_0x011d
            java.lang.String r8 = ""
            if (r11 == r8) goto L_0x011d
            if (r11 == 0) goto L_0x011d
            r7.close()
            r9.close()
            r8 = r11
            goto L_0x0149
        L_0x011d:
            r7.close()
            r9.close()
            r8 = r10
            goto L_0x0149
        L_0x0125:
            r7.close()
            goto L_0x0146
        L_0x0129:
            r15 = move-exception
            r8 = r7
            goto L_0x0132
        L_0x012c:
            r15 = move-exception
            goto L_0x0132
        L_0x012e:
            r7 = r8
            goto L_0x013f
        L_0x0130:
            r15 = move-exception
            r9 = r8
        L_0x0132:
            if (r8 == 0) goto L_0x0137
            r8.close()
        L_0x0137:
            if (r9 == 0) goto L_0x013c
            r9.close()
        L_0x013c:
            throw r15
        L_0x013d:
            r7 = r8
            r9 = r7
        L_0x013f:
            if (r7 == 0) goto L_0x0144
            r7.close()
        L_0x0144:
            if (r9 == 0) goto L_0x0149
        L_0x0146:
            r9.close()
        L_0x0149:
            java.lang.String r5 = r5.f5341a
            java.lang.String r5 = r15.h(r5)
            r6.g = r5
            r6.f = r8
            r4.add(r6)
            goto L_0x00a5
        L_0x0158:
            r1.clear()
            r1.addAll(r4)
            cris.org.in.ima.adaptors.StationListAdapter r15 = r14.f4354a
            r15.notifyDataSetChanged()
        L_0x0163:
            r14.f4358a = r3
            android.widget.EditText r15 = r14.stationSearch
            int r1 = r14.c
            defpackage.C0535I5.a(r15, r1)
            cris.org.in.ima.dto.oauth2.GoogleAdParamDTO r15 = new cris.org.in.ima.dto.oauth2.GoogleAdParamDTO
            r15.<init>()
            java.lang.String r1 = defpackage.C1450w1.f7009a
            r15.setAge(r1)
            java.lang.String r1 = defpackage.C1450w1.f7021c
            r15.setGender(r1)
            android.content.Intent r1 = r14.a
            java.lang.String r2 = "FromStationHint"
            java.lang.String r1 = r1.getStringExtra(r2)
            r15.setSource(r1)
            android.content.Intent r1 = r14.a
            java.lang.String r2 = "ToStationHint"
            java.lang.String r1 = r1.getStringExtra(r2)
            r15.setDestination(r1)
            com.google.android.gms.ads.admanager.AdManagerAdView r1 = r14.publisherAdView
            defpackage.C0535I5.Y(r14, r1, r15)
            android.content.Intent r15 = r14.a
            java.lang.String r1 = "stationView"
            int r15 = r15.getIntExtra(r1, r0)
            if (r15 != 0) goto L_0x01ad
            android.widget.EditText r15 = r14.stationSearch
            r0 = 2131952649(0x7f130409, float:1.9541747E38)
            java.lang.String r0 = r14.getString(r0)
            r15.setHint(r0)
            goto L_0x01c1
        L_0x01ad:
            android.content.Intent r15 = r14.a
            int r15 = r15.getIntExtra(r1, r0)
            if (r15 != r3) goto L_0x01c1
            android.widget.EditText r15 = r14.stationSearch
            r0 = 2131952644(0x7f130404, float:1.9541737E38)
            java.lang.String r0 = r14.getString(r0)
            r15.setHint(r0)
        L_0x01c1:
            android.content.Intent r15 = r14.a
            java.lang.String r0 = "toStnClickFavFlag"
            java.lang.String r15 = r15.getStringExtra(r0)
            r14.f4360c = r15
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.activities.StationListActivity.onCreate(android.os.Bundle):void");
    }

    public final void onPause() {
        super.onPause();
        getWindow().setFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE, UserMetadata.MAX_INTERNAL_KEY_SIZE);
    }

    public final void onResume() {
        super.onResume();
        getWindow().clearFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x049f  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x06eb  */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x06f6  */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x0735  */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x0781  */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x0788  */
    /* JADX WARNING: Removed duplicated region for block: B:311:0x04ce A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:336:0x078a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0350  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0381  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x03b5  */
    @butterknife.OnTextChanged({2131364587})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void stationSearchChange(java.lang.CharSequence r27) {
        /*
            r26 = this;
            r0 = r26
            int r1 = r27.length()
            if (r1 == 0) goto L_0x0920
            com.google.gson.Gson r1 = new com.google.gson.Gson
            r1.<init>()
            android.content.Context r3 = r26.getApplicationContext()
            Bw r3 = defpackage.Bw.e(r3)
            Nv r4 = r3.f3534a
            java.lang.String r5 = "CityWiseStationList"
            java.lang.String r6 = ""
            java.lang.String r4 = r4.getString(r5, r6)
            Nv r3 = r3.f3534a
            java.lang.String r5 = "CityNameList"
            java.lang.String r5 = r3.getString(r5, r6)
            java.lang.String r7 = "TagList"
            java.lang.String r7 = r3.getString(r7, r6)
            java.lang.String r8 = "TagWiseStationList"
            java.lang.String r8 = r3.getString(r8, r6)
            java.lang.String r9 = "DISTSCORINGSTNLIST"
            java.lang.String r3 = r3.getString(r9, r6)
            cris.org.in.ima.activities.StationListActivity$a r9 = new cris.org.in.ima.activities.StationListActivity$a
            r9.<init>()
            java.lang.reflect.Type r9 = r9.getType()
            cris.org.in.ima.activities.StationListActivity$b r10 = new cris.org.in.ima.activities.StationListActivity$b
            r10.<init>()
            java.lang.reflect.Type r10 = r10.getType()
            cris.org.in.ima.activities.StationListActivity$c r11 = new cris.org.in.ima.activities.StationListActivity$c
            r11.<init>()
            java.lang.reflect.Type r11 = r11.getType()
            java.lang.Object r4 = r1.fromJson((java.lang.String) r4, (java.lang.reflect.Type) r11)
            java.util.LinkedHashMap r4 = (java.util.LinkedHashMap) r4
            java.lang.Object r5 = r1.fromJson((java.lang.String) r5, (java.lang.reflect.Type) r10)
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            java.lang.Object r7 = r1.fromJson((java.lang.String) r7, (java.lang.reflect.Type) r10)
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            java.lang.Object r3 = r1.fromJson((java.lang.String) r3, (java.lang.reflect.Type) r9)
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            java.util.TreeMap r7 = new java.util.TreeMap
            r7.<init>()
            java.lang.Object r1 = r1.fromJson((java.lang.String) r8, (java.lang.reflect.Type) r11)
            java.util.LinkedHashMap r1 = (java.util.LinkedHashMap) r1
            android.widget.TextView r1 = r0.recentStationSearch
            r8 = 8
            r1.setVisibility(r8)
            boolean r1 = r0.f4358a
            if (r1 == 0) goto L_0x0929
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            b1 r10 = defpackage.C0793b1.a
            cris.org.in.ima.db.StationDb r10 = r10.f3911a
            java.lang.String r11 = r0.f4360c
            java.lang.String r12 = "true"
            boolean r11 = r11.equals(r12)
            java.util.ArrayList<cris.org.in.ima.model.StationModel> r12 = r0.f4361c
            if (r11 == 0) goto L_0x00e5
            java.util.Iterator r11 = r12.iterator()
        L_0x00a5:
            boolean r13 = r11.hasNext()
            if (r13 == 0) goto L_0x00e5
            java.lang.Object r13 = r11.next()
            cris.org.in.ima.model.StationModel r13 = (cris.org.in.ima.model.StationModel) r13
            java.lang.Boolean r14 = r13.a
            boolean r14 = r14.booleanValue()
            if (r14 == 0) goto L_0x00cd
            java.lang.String r14 = r13.f5341a
            java.lang.String r14 = r14.toLowerCase()
            java.lang.String r15 = r27.toString()
            java.lang.String r15 = r15.toLowerCase()
            boolean r14 = r14.contains(r15)
            if (r14 != 0) goto L_0x00e1
        L_0x00cd:
            java.lang.String r14 = r13.b
            java.lang.String r14 = r14.toLowerCase()
            java.lang.String r15 = r27.toString()
            java.lang.String r15 = r15.toLowerCase()
            boolean r14 = r14.contains(r15)
            if (r14 == 0) goto L_0x00a5
        L_0x00e1:
            r1.add(r13)
            goto L_0x00a5
        L_0x00e5:
            java.lang.String r11 = r27.toString()
            java.util.ArrayList r10 = r10.j(r11)
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r16 = r9
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            r17 = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r18 = r12
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            r19 = r7
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.ArrayList r20 = new java.util.ArrayList
            r20.<init>()
            r20 = r6
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r21 = r3
            if (r10 == 0) goto L_0x04d1
            java.util.Iterator r22 = r10.iterator()
        L_0x013b:
            boolean r23 = r22.hasNext()
            if (r23 == 0) goto L_0x016a
            java.lang.Object r23 = r22.next()
            r3 = r23
            cris.org.in.ima.model.StationModel r3 = (cris.org.in.ima.model.StationModel) r3
            r23 = r6
            java.lang.String r6 = r3.f5341a
            r24 = r7
            java.lang.String r7 = r27.toString()
            boolean r6 = r6.equalsIgnoreCase(r7)
            if (r6 == 0) goto L_0x0165
            r11.add(r3)
            int r3 = r11.size()
            r6 = 100
            if (r3 < r6) goto L_0x0165
            goto L_0x016e
        L_0x0165:
            r6 = r23
            r7 = r24
            goto L_0x013b
        L_0x016a:
            r23 = r6
            r24 = r7
        L_0x016e:
            java.util.Iterator r3 = r10.iterator()
        L_0x0172:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x01a3
            java.lang.Object r6 = r3.next()
            cris.org.in.ima.model.StationModel r6 = (cris.org.in.ima.model.StationModel) r6
            java.lang.String r7 = r6.f5341a
            java.lang.String r7 = r7.toUpperCase()
            java.lang.String r22 = r27.toString()
            r25 = r3
            java.lang.String r3 = r22.toUpperCase()
            boolean r3 = r7.startsWith(r3)
            if (r3 == 0) goto L_0x01a0
            r13.add(r6)
            int r3 = r13.size()
            r6 = 100
            if (r3 < r6) goto L_0x01a0
            goto L_0x01a3
        L_0x01a0:
            r3 = r25
            goto L_0x0172
        L_0x01a3:
            java.util.List<cris.org.in.ima.model.StationModel> r3 = r0.f4357a
            java.util.Iterator r3 = r3.iterator()
        L_0x01a9:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x01da
            java.lang.Object r6 = r3.next()
            cris.org.in.ima.model.StationModel r6 = (cris.org.in.ima.model.StationModel) r6
            java.lang.String r7 = r6.b
            java.lang.String r7 = r7.toUpperCase()
            java.lang.String r22 = r27.toString()
            r25 = r3
            java.lang.String r3 = r22.toUpperCase()
            boolean r3 = r7.startsWith(r3)
            if (r3 == 0) goto L_0x01d7
            r14.add(r6)
            int r3 = r14.size()
            r6 = 100
            if (r3 < r6) goto L_0x01d7
            goto L_0x01da
        L_0x01d7:
            r3 = r25
            goto L_0x01a9
        L_0x01da:
            java.util.List<cris.org.in.ima.model.StationModel> r3 = r0.f4357a
            java.util.Iterator r3 = r3.iterator()
        L_0x01e0:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x0211
            java.lang.Object r6 = r3.next()
            cris.org.in.ima.model.StationModel r6 = (cris.org.in.ima.model.StationModel) r6
            java.lang.String r7 = r6.b
            java.lang.String r7 = r7.toUpperCase()
            java.lang.String r22 = r27.toString()
            r25 = r3
            java.lang.String r3 = r22.toUpperCase()
            boolean r3 = r7.contains(r3)
            if (r3 == 0) goto L_0x020e
            r15.add(r6)
            int r3 = r15.size()
            r6 = 100
            if (r3 < r6) goto L_0x020e
            goto L_0x0211
        L_0x020e:
            r3 = r25
            goto L_0x01e0
        L_0x0211:
            java.util.Iterator r3 = r10.iterator()
        L_0x0215:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x0246
            java.lang.Object r6 = r3.next()
            cris.org.in.ima.model.StationModel r6 = (cris.org.in.ima.model.StationModel) r6
            java.lang.String r7 = r6.b
            java.lang.String r7 = r7.toUpperCase()
            java.lang.String r22 = r27.toString()
            r25 = r3
            java.lang.String r3 = r22.toUpperCase()
            boolean r3 = r7.startsWith(r3)
            if (r3 == 0) goto L_0x0243
            r2.add(r6)
            int r3 = r2.size()
            r6 = 100
            if (r3 < r6) goto L_0x0243
            goto L_0x0246
        L_0x0243:
            r3 = r25
            goto L_0x0215
        L_0x0246:
            if (r5 != 0) goto L_0x0253
            boolean r3 = r5.isEmpty()
            if (r3 == 0) goto L_0x024f
            goto L_0x0253
        L_0x024f:
            r25 = r2
            goto L_0x0346
        L_0x0253:
            r3 = 0
        L_0x0254:
            int r6 = r5.size()
            if (r3 >= r6) goto L_0x024f
            java.lang.Object r6 = r5.get(r3)
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r6 = r6.toUpperCase()
            java.lang.String r7 = r27.toString()
            java.lang.String r7 = r7.toUpperCase()
            boolean r6 = r6.startsWith(r7)
            if (r6 == 0) goto L_0x0333
            java.lang.Object r6 = r5.get(r3)
            java.lang.Object r6 = r4.get(r6)
            java.util.ArrayList r6 = (java.util.ArrayList) r6
            int r6 = r6.size()
            r7 = 0
        L_0x0281:
            if (r7 >= r6) goto L_0x0333
            r22 = r6
            cris.org.in.ima.model.StationModel r6 = new cris.org.in.ima.model.StationModel
            r6.<init>()
            java.lang.Object r0 = r5.get(r3)
            java.lang.Object r0 = r4.get(r0)
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            java.lang.Object r0 = r0.get(r7)
            Wx r0 = (defpackage.C0742Wx) r0
            java.lang.String r0 = r0.getEn()
            r25 = r2
            java.lang.Object r2 = r5.get(r3)
            java.lang.Object r2 = r4.get(r2)
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            java.lang.Object r2 = r2.get(r7)
            Wx r2 = (defpackage.C0742Wx) r2
            java.lang.String r2 = r2.getHi()
            r6.d = r2
            r6.b = r0
            java.lang.Object r0 = r5.get(r3)
            java.lang.Object r0 = r4.get(r0)
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            java.lang.Object r0 = r0.get(r7)
            Wx r0 = (defpackage.C0742Wx) r0
            java.lang.String r0 = r0.getSc()
            r6.f5341a = r0
            java.lang.Object r0 = r5.get(r3)
            java.lang.Object r0 = r4.get(r0)
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            java.lang.Object r0 = r0.get(r7)
            Wx r0 = (defpackage.C0742Wx) r0
            java.lang.String r0 = r0.getEc()
            java.lang.Object r2 = r5.get(r3)
            java.lang.Object r2 = r4.get(r2)
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            java.lang.Object r2 = r2.get(r7)
            Wx r2 = (defpackage.C0742Wx) r2
            java.lang.String r2 = r2.getHc()
            r6.c = r0
            r6.e = r2
            java.lang.Object r0 = r5.get(r3)
            java.lang.Object r0 = r4.get(r0)
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            java.lang.Object r0 = r0.get(r7)
            Wx r0 = (defpackage.C0742Wx) r0
            java.lang.String r0 = r0.getSe()
            java.lang.Object r2 = r5.get(r3)
            java.lang.Object r2 = r4.get(r2)
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            java.lang.Object r2 = r2.get(r7)
            Wx r2 = (defpackage.C0742Wx) r2
            java.lang.String r2 = r2.getSh()
            r6.g = r2
            r6.f = r0
            r8.add(r6)
            int r7 = r7 + 1
            r0 = r26
            r6 = r22
            r2 = r25
            goto L_0x0281
        L_0x0333:
            r25 = r2
            int r0 = r8.size()
            r2 = 100
            if (r0 < r2) goto L_0x033e
            goto L_0x0346
        L_0x033e:
            int r3 = r3 + 1
            r0 = r26
            r2 = r25
            goto L_0x0254
        L_0x0346:
            java.util.Iterator r0 = r10.iterator()
        L_0x034a:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0377
            java.lang.Object r2 = r0.next()
            cris.org.in.ima.model.StationModel r2 = (cris.org.in.ima.model.StationModel) r2
            java.lang.String r3 = r2.h
            if (r3 == 0) goto L_0x034a
            java.lang.String r3 = r3.toUpperCase()
            java.lang.String r6 = r27.toString()
            java.lang.String r6 = r6.toUpperCase()
            boolean r3 = r3.startsWith(r6)
            if (r3 == 0) goto L_0x034a
            r9.add(r2)
            int r2 = r9.size()
            r3 = 100
            if (r2 < r3) goto L_0x034a
        L_0x0377:
            java.util.Iterator r0 = r10.iterator()
        L_0x037b:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x03a6
            java.lang.Object r2 = r0.next()
            cris.org.in.ima.model.StationModel r2 = (cris.org.in.ima.model.StationModel) r2
            java.lang.String r3 = r2.b
            java.lang.String r3 = r3.toUpperCase()
            java.lang.String r6 = r27.toString()
            java.lang.String r6 = r6.toUpperCase()
            boolean r3 = r3.contains(r6)
            if (r3 == 0) goto L_0x037b
            r1.add(r2)
            int r2 = r1.size()
            r3 = 100
            if (r2 < r3) goto L_0x037b
        L_0x03a6:
            if (r5 != 0) goto L_0x03ae
            boolean r0 = r5.isEmpty()
            if (r0 == 0) goto L_0x0495
        L_0x03ae:
            r0 = 0
        L_0x03af:
            int r2 = r5.size()
            if (r0 >= r2) goto L_0x0495
            java.lang.Object r2 = r5.get(r0)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r2 = r2.toUpperCase()
            java.lang.String r3 = r27.toString()
            java.lang.String r3 = r3.toUpperCase()
            boolean r2 = r2.contains(r3)
            if (r2 == 0) goto L_0x0488
            java.lang.Object r2 = r5.get(r0)
            java.lang.Object r2 = r4.get(r2)
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            int r2 = r2.size()
            r3 = 0
        L_0x03dc:
            if (r3 >= r2) goto L_0x0488
            cris.org.in.ima.model.StationModel r6 = new cris.org.in.ima.model.StationModel
            r6.<init>()
            java.lang.Object r7 = r5.get(r0)
            java.lang.Object r7 = r4.get(r7)
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            java.lang.Object r7 = r7.get(r3)
            Wx r7 = (defpackage.C0742Wx) r7
            java.lang.String r7 = r7.getEn()
            r22 = r2
            java.lang.Object r2 = r5.get(r0)
            java.lang.Object r2 = r4.get(r2)
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            java.lang.Object r2 = r2.get(r3)
            Wx r2 = (defpackage.C0742Wx) r2
            java.lang.String r2 = r2.getHi()
            r6.d = r2
            r6.b = r7
            java.lang.Object r2 = r5.get(r0)
            java.lang.Object r2 = r4.get(r2)
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            java.lang.Object r2 = r2.get(r3)
            Wx r2 = (defpackage.C0742Wx) r2
            java.lang.String r2 = r2.getSc()
            r6.f5341a = r2
            java.lang.Object r2 = r5.get(r0)
            java.lang.Object r2 = r4.get(r2)
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            java.lang.Object r2 = r2.get(r3)
            Wx r2 = (defpackage.C0742Wx) r2
            java.lang.String r2 = r2.getEc()
            java.lang.Object r7 = r5.get(r0)
            java.lang.Object r7 = r4.get(r7)
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            java.lang.Object r7 = r7.get(r3)
            Wx r7 = (defpackage.C0742Wx) r7
            java.lang.String r7 = r7.getHc()
            r6.c = r2
            r6.e = r7
            java.lang.Object r2 = r5.get(r0)
            java.lang.Object r2 = r4.get(r2)
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            java.lang.Object r2 = r2.get(r3)
            Wx r2 = (defpackage.C0742Wx) r2
            java.lang.String r2 = r2.getSe()
            java.lang.Object r7 = r5.get(r0)
            java.lang.Object r7 = r4.get(r7)
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            java.lang.Object r7 = r7.get(r3)
            Wx r7 = (defpackage.C0742Wx) r7
            java.lang.String r7 = r7.getSh()
            r6.g = r7
            r6.f = r2
            r12.add(r6)
            int r3 = r3 + 1
            r2 = r22
            goto L_0x03dc
        L_0x0488:
            int r2 = r12.size()
            r3 = 100
            if (r2 < r3) goto L_0x0491
            goto L_0x0495
        L_0x0491:
            int r0 = r0 + 1
            goto L_0x03af
        L_0x0495:
            java.util.Iterator r0 = r10.iterator()
        L_0x0499:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x04ce
            java.lang.Object r2 = r0.next()
            cris.org.in.ima.model.StationModel r2 = (cris.org.in.ima.model.StationModel) r2
            java.lang.String r3 = r2.h
            if (r3 == 0) goto L_0x04c9
            java.lang.String r3 = r3.toUpperCase()
            java.lang.String r4 = r27.toString()
            java.lang.String r4 = r4.toUpperCase()
            boolean r3 = r3.contains(r4)
            if (r3 == 0) goto L_0x04c9
            r3 = r24
            r3.add(r2)
            int r2 = r3.size()
            r4 = 100
            if (r2 < r4) goto L_0x04cb
            goto L_0x04d6
        L_0x04c9:
            r3 = r24
        L_0x04cb:
            r24 = r3
            goto L_0x0499
        L_0x04ce:
            r3 = r24
            goto L_0x04d6
        L_0x04d1:
            r25 = r2
            r23 = r6
            r3 = r7
        L_0x04d6:
            java.util.Iterator r0 = r11.iterator()
        L_0x04da:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0501
            java.lang.Object r2 = r0.next()
            cris.org.in.ima.model.StationModel r2 = (cris.org.in.ima.model.StationModel) r2
            r4 = r23
            java.lang.Boolean r5 = l(r4, r2)
            boolean r5 = r5.booleanValue()
            if (r5 != 0) goto L_0x04f5
            r4.add(r2)
        L_0x04f5:
            int r2 = r4.size()
            r5 = 100
            if (r2 < r5) goto L_0x04fe
            goto L_0x0503
        L_0x04fe:
            r23 = r4
            goto L_0x04da
        L_0x0501:
            r4 = r23
        L_0x0503:
            java.util.Iterator r0 = r13.iterator()
        L_0x0507:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0528
            java.lang.Object r2 = r0.next()
            cris.org.in.ima.model.StationModel r2 = (cris.org.in.ima.model.StationModel) r2
            java.lang.Boolean r5 = l(r4, r2)
            boolean r5 = r5.booleanValue()
            if (r5 != 0) goto L_0x0520
            r4.add(r2)
        L_0x0520:
            int r2 = r4.size()
            r5 = 100
            if (r2 < r5) goto L_0x0507
        L_0x0528:
            java.util.Iterator r0 = r14.iterator()
        L_0x052c:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x054d
            java.lang.Object r2 = r0.next()
            cris.org.in.ima.model.StationModel r2 = (cris.org.in.ima.model.StationModel) r2
            java.lang.Boolean r5 = l(r4, r2)
            boolean r5 = r5.booleanValue()
            if (r5 != 0) goto L_0x0545
            r4.add(r2)
        L_0x0545:
            int r2 = r4.size()
            r5 = 100
            if (r2 < r5) goto L_0x052c
        L_0x054d:
            java.util.Iterator r0 = r15.iterator()
        L_0x0551:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0572
            java.lang.Object r2 = r0.next()
            cris.org.in.ima.model.StationModel r2 = (cris.org.in.ima.model.StationModel) r2
            java.lang.Boolean r5 = l(r4, r2)
            boolean r5 = r5.booleanValue()
            if (r5 != 0) goto L_0x056a
            r4.add(r2)
        L_0x056a:
            int r2 = r4.size()
            r5 = 100
            if (r2 < r5) goto L_0x0551
        L_0x0572:
            java.util.Iterator r0 = r25.iterator()
        L_0x0576:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0597
            java.lang.Object r2 = r0.next()
            cris.org.in.ima.model.StationModel r2 = (cris.org.in.ima.model.StationModel) r2
            java.lang.Boolean r5 = l(r4, r2)
            boolean r5 = r5.booleanValue()
            if (r5 != 0) goto L_0x058f
            r4.add(r2)
        L_0x058f:
            int r2 = r4.size()
            r5 = 100
            if (r2 < r5) goto L_0x0576
        L_0x0597:
            java.util.Iterator r0 = r8.iterator()
        L_0x059b:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x05bc
            java.lang.Object r2 = r0.next()
            cris.org.in.ima.model.StationModel r2 = (cris.org.in.ima.model.StationModel) r2
            java.lang.Boolean r5 = l(r4, r2)
            boolean r5 = r5.booleanValue()
            if (r5 != 0) goto L_0x05b4
            r4.add(r2)
        L_0x05b4:
            int r2 = r4.size()
            r5 = 100
            if (r2 < r5) goto L_0x059b
        L_0x05bc:
            java.util.Iterator r0 = r9.iterator()
        L_0x05c0:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x05e1
            java.lang.Object r2 = r0.next()
            cris.org.in.ima.model.StationModel r2 = (cris.org.in.ima.model.StationModel) r2
            java.lang.Boolean r5 = l(r4, r2)
            boolean r5 = r5.booleanValue()
            if (r5 != 0) goto L_0x05d9
            r4.add(r2)
        L_0x05d9:
            int r2 = r4.size()
            r5 = 100
            if (r2 < r5) goto L_0x05c0
        L_0x05e1:
            java.util.Iterator r0 = r1.iterator()
        L_0x05e5:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0606
            java.lang.Object r1 = r0.next()
            cris.org.in.ima.model.StationModel r1 = (cris.org.in.ima.model.StationModel) r1
            java.lang.Boolean r2 = l(r4, r1)
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L_0x05fe
            r4.add(r1)
        L_0x05fe:
            int r1 = r4.size()
            r2 = 100
            if (r1 < r2) goto L_0x05e5
        L_0x0606:
            java.util.Iterator r0 = r12.iterator()
        L_0x060a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x062b
            java.lang.Object r1 = r0.next()
            cris.org.in.ima.model.StationModel r1 = (cris.org.in.ima.model.StationModel) r1
            java.lang.Boolean r2 = l(r4, r1)
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L_0x0623
            r4.add(r1)
        L_0x0623:
            int r1 = r4.size()
            r2 = 100
            if (r1 < r2) goto L_0x060a
        L_0x062b:
            java.util.Iterator r0 = r3.iterator()
        L_0x062f:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0650
            java.lang.Object r1 = r0.next()
            cris.org.in.ima.model.StationModel r1 = (cris.org.in.ima.model.StationModel) r1
            java.lang.Boolean r2 = l(r4, r1)
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L_0x0648
            r4.add(r1)
        L_0x0648:
            int r1 = r4.size()
            r2 = 100
            if (r1 < r2) goto L_0x062f
        L_0x0650:
            boolean r0 = r4.isEmpty()
            if (r0 == 0) goto L_0x08c2
            r0 = 0
        L_0x0657:
            int r1 = r21.size()
            if (r0 >= r1) goto L_0x07a2
            r3 = r21
            java.lang.Object r1 = r3.get(r0)
            Wx r1 = (defpackage.C0742Wx) r1
            java.lang.String r1 = r1.getTg()
            r7 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            if (r1 == 0) goto L_0x06cf
            java.lang.Object r1 = r3.get(r0)
            Wx r1 = (defpackage.C0742Wx) r1
            java.lang.String r1 = r1.getTg()
            r2 = r20
            if (r1 == r2) goto L_0x06d1
            java.lang.Object r1 = r3.get(r0)
            Wx r1 = (defpackage.C0742Wx) r1
            java.lang.String r1 = r1.getTg()
            java.lang.String r9 = ","
            java.lang.String[] r1 = r1.split(r9)
            r9 = 0
            r10 = 0
        L_0x068e:
            int r12 = r1.length
            if (r9 >= r12) goto L_0x06d3
            r12 = r1[r9]
            int r12 = r12.length()
            java.lang.String r13 = r27.toString()
            int r13 = r13.length()
            if (r12 <= r13) goto L_0x06a8
            r12 = r1[r9]
            int r12 = r12.length()
            goto L_0x06b0
        L_0x06a8:
            java.lang.String r12 = r27.toString()
            int r12 = r12.length()
        L_0x06b0:
            r13 = r1[r9]
            java.lang.String r13 = r13.toLowerCase()
            java.lang.String r14 = r27.toString()
            java.lang.String r14 = r14.toLowerCase()
            int r13 = m(r13, r14)
            double r13 = (double) r13
            double r5 = (double) r12
            double r13 = r13 / r5
            double r5 = r7 - r13
            int r12 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r12 <= 0) goto L_0x06cc
            r10 = r5
        L_0x06cc:
            int r9 = r9 + 1
            goto L_0x068e
        L_0x06cf:
            r2 = r20
        L_0x06d1:
            r10 = 0
        L_0x06d3:
            java.lang.Object r1 = r3.get(r0)
            Wx r1 = (defpackage.C0742Wx) r1
            java.lang.String r1 = r1.getEn()
            int r1 = r1.length()
            java.lang.String r5 = r27.toString()
            int r5 = r5.length()
            if (r1 <= r5) goto L_0x06f6
            java.lang.Object r1 = r3.get(r0)
            Wx r1 = (defpackage.C0742Wx) r1
            java.lang.String r1 = r1.getEn()
            goto L_0x06fa
        L_0x06f6:
            java.lang.String r1 = r27.toString()
        L_0x06fa:
            int r1 = r1.length()
            java.lang.Object r5 = r3.get(r0)
            Wx r5 = (defpackage.C0742Wx) r5
            java.lang.String r5 = r5.getEn()
            java.lang.String r5 = r5.toLowerCase()
            java.lang.String r6 = r27.toString()
            java.lang.String r6 = r6.toLowerCase()
            int r5 = m(r5, r6)
            double r5 = (double) r5
            double r12 = (double) r1
            double r5 = r5 / r12
            double r5 = r7 - r5
            java.lang.Object r1 = r3.get(r0)
            Wx r1 = (defpackage.C0742Wx) r1
            java.lang.String r1 = r1.getEc()
            if (r1 == 0) goto L_0x0781
            java.lang.Object r1 = r3.get(r0)
            Wx r1 = (defpackage.C0742Wx) r1
            java.lang.String r1 = r1.getEc()
            if (r1 == r2) goto L_0x0781
            java.lang.Object r1 = r3.get(r0)
            Wx r1 = (defpackage.C0742Wx) r1
            java.lang.String r1 = r1.getEc()
            int r1 = r1.length()
            java.lang.String r9 = r27.toString()
            int r9 = r9.length()
            if (r1 <= r9) goto L_0x0758
            java.lang.Object r1 = r3.get(r0)
            Wx r1 = (defpackage.C0742Wx) r1
            java.lang.String r1 = r1.getEc()
            goto L_0x075c
        L_0x0758:
            java.lang.String r1 = r27.toString()
        L_0x075c:
            int r1 = r1.length()
            java.lang.Object r9 = r3.get(r0)
            Wx r9 = (defpackage.C0742Wx) r9
            java.lang.String r9 = r9.getEc()
            java.lang.String r9 = r9.toLowerCase()
            java.lang.String r12 = r27.toString()
            java.lang.String r12 = r12.toLowerCase()
            int r9 = m(r9, r12)
            double r12 = (double) r9
            double r14 = (double) r1
            double r12 = r12 / r14
            double r7 = r7 - r12
            r20 = r7
            goto L_0x0783
        L_0x0781:
            r20 = 0
        L_0x0783:
            int r1 = (r10 > r20 ? 1 : (r10 == r20 ? 0 : -1))
            if (r1 <= 0) goto L_0x0788
            goto L_0x078a
        L_0x0788:
            r10 = r20
        L_0x078a:
            double r5 = r5 + r10
            java.lang.Double r1 = java.lang.Double.valueOf(r5)
            java.lang.Object r5 = r3.get(r0)
            Wx r5 = (defpackage.C0742Wx) r5
            r6 = r19
            r6.put(r1, r5)
            int r0 = r0 + 1
            r20 = r2
            r21 = r3
            goto L_0x0657
        L_0x07a2:
            r6 = r19
            r2 = r20
            java.util.NavigableSet r0 = r6.descendingKeySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x07ae:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x08c2
            java.lang.Object r1 = r0.next()
            java.lang.Double r1 = (java.lang.Double) r1
            double r7 = r1.doubleValue()
            cris.org.in.ima.model.StationModel r1 = new cris.org.in.ima.model.StationModel
            r1.<init>()
            java.lang.Double r3 = java.lang.Double.valueOf(r7)
            java.lang.Object r3 = r6.get(r3)
            Wx r3 = (defpackage.C0742Wx) r3
            java.lang.String r3 = r3.getSc()
            r1.f5341a = r3
            java.lang.Double r3 = java.lang.Double.valueOf(r7)
            java.lang.Object r3 = r6.get(r3)
            Wx r3 = (defpackage.C0742Wx) r3
            java.lang.String r3 = r3.getEn()
            java.lang.Double r5 = java.lang.Double.valueOf(r7)
            java.lang.Object r5 = r6.get(r5)
            Wx r5 = (defpackage.C0742Wx) r5
            java.lang.String r5 = r5.getHi()
            r1.d = r5
            r1.b = r3
            java.lang.Double r3 = java.lang.Double.valueOf(r7)
            java.lang.Object r3 = r6.get(r3)
            Wx r3 = (defpackage.C0742Wx) r3
            java.lang.String r3 = r3.getEc()
            if (r3 == 0) goto L_0x0833
            java.lang.Double r3 = java.lang.Double.valueOf(r7)
            java.lang.Object r3 = r6.get(r3)
            Wx r3 = (defpackage.C0742Wx) r3
            java.lang.String r3 = r3.getEc()
            if (r3 == r2) goto L_0x0833
            java.lang.Double r3 = java.lang.Double.valueOf(r7)
            java.lang.Object r3 = r6.get(r3)
            Wx r3 = (defpackage.C0742Wx) r3
            java.lang.String r3 = r3.getEc()
            java.lang.Double r5 = java.lang.Double.valueOf(r7)
            java.lang.Object r5 = r6.get(r5)
            Wx r5 = (defpackage.C0742Wx) r5
            java.lang.String r5 = r5.getHc()
            r1.c = r3
            r1.e = r5
        L_0x0833:
            java.lang.Double r3 = java.lang.Double.valueOf(r7)
            java.lang.Object r3 = r6.get(r3)
            Wx r3 = (defpackage.C0742Wx) r3
            java.lang.String r3 = r3.getSe()
            if (r3 == 0) goto L_0x0873
            java.lang.Double r3 = java.lang.Double.valueOf(r7)
            java.lang.Object r3 = r6.get(r3)
            Wx r3 = (defpackage.C0742Wx) r3
            java.lang.String r3 = r3.getSe()
            if (r3 == r2) goto L_0x0873
            java.lang.Double r3 = java.lang.Double.valueOf(r7)
            java.lang.Object r3 = r6.get(r3)
            Wx r3 = (defpackage.C0742Wx) r3
            java.lang.String r3 = r3.getSe()
            java.lang.Double r5 = java.lang.Double.valueOf(r7)
            java.lang.Object r5 = r6.get(r5)
            Wx r5 = (defpackage.C0742Wx) r5
            java.lang.String r5 = r5.getSh()
            r1.g = r5
            r1.f = r3
        L_0x0873:
            java.lang.Double r3 = java.lang.Double.valueOf(r7)
            java.lang.Object r3 = r6.get(r3)
            Wx r3 = (defpackage.C0742Wx) r3
            java.lang.String r3 = r3.getTg()
            if (r3 == 0) goto L_0x08a3
            java.lang.Double r3 = java.lang.Double.valueOf(r7)
            java.lang.Object r3 = r6.get(r3)
            Wx r3 = (defpackage.C0742Wx) r3
            java.lang.String r3 = r3.getTg()
            if (r3 == r2) goto L_0x08a3
            java.lang.Double r3 = java.lang.Double.valueOf(r7)
            java.lang.Object r3 = r6.get(r3)
            Wx r3 = (defpackage.C0742Wx) r3
            java.lang.String r3 = r3.getTg()
            r1.h = r3
        L_0x08a3:
            java.lang.Double r3 = java.lang.Double.valueOf(r7)
            java.lang.Object r3 = r6.get(r3)
            Wx r3 = (defpackage.C0742Wx) r3
            r3.getSc()
            java.lang.String r3 = r27.toString()
            r3.toUpperCase()
            r4.add(r1)
            int r1 = r4.size()
            r3 = 100
            if (r1 < r3) goto L_0x07ae
        L_0x08c2:
            r0 = r26
            java.util.ArrayList<cris.org.in.ima.model.StationModel> r1 = r0.f4356a
            r1.clear()
            r1.addAll(r4)
            r18.clear()
            r1 = r17
            r2 = r18
            r2.addAll(r1)
            androidx.recyclerview.widget.RecyclerView r1 = r0.rvPopularstationList
            r3 = 8
            r1.setVisibility(r3)
            int r1 = r16.size()
            if (r1 != 0) goto L_0x08f4
            android.widget.LinearLayout r1 = r0.popularLl
            r1.setVisibility(r3)
            android.widget.TextView r1 = r0.txpopular
            r1.setVisibility(r3)
            android.view.View r1 = r0.view_recentsearch
            r4 = 0
            r1.setVisibility(r4)
            goto L_0x0904
        L_0x08f4:
            r4 = 0
            android.widget.LinearLayout r1 = r0.popularLl
            r1.setVisibility(r4)
            android.widget.TextView r1 = r0.txpopular
            r1.setVisibility(r4)
            android.view.View r1 = r0.view_recentsearch
            r1.setVisibility(r3)
        L_0x0904:
            int r1 = r2.size()
            if (r1 != 0) goto L_0x0910
            android.widget.LinearLayout r1 = r0.favourityLl
            r1.setVisibility(r3)
            goto L_0x0915
        L_0x0910:
            android.widget.LinearLayout r1 = r0.favourityLl
            r1.setVisibility(r4)
        L_0x0915:
            cris.org.in.ima.adaptors.StationListAdapter r1 = r0.f4354a
            r1.notifyDataSetChanged()
            cris.org.in.ima.adaptors.FavoriteStationListAdapter r1 = r0.f4353a
            r1.notifyDataSetChanged()
            goto L_0x0929
        L_0x0920:
            r4 = 0
            android.widget.TextView r1 = r0.recentStationSearch
            r1.setVisibility(r4)
            r26.stationSerchClick()
        L_0x0929:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.activities.StationListActivity.stationSearchChange(java.lang.CharSequence):void");
    }

    @OnTouch({2131364587})
    public boolean stationSerchClick() {
        C0793b1.a.f3911a.e();
        List<StationModel> list = this.f4357a;
        if (!this.f4360c.equals("true") || C0535I5.f3640e.size() <= 0) {
            this.favourityLl.setVisibility(8);
        } else {
            this.favourityLl.setVisibility(0);
            this.txfavourite.setVisibility(0);
            ArrayList<StationModel> arrayList = this.f4361c;
            arrayList.clear();
            arrayList.clear();
            if (C0535I5.f3636d.size() >= 3) {
                arrayList.addAll(C0535I5.f3636d.subList(0, 3));
            }
            this.f4353a.notifyDataSetChanged();
        }
        if (list.size() > 0) {
            this.popularLl.setVisibility(0);
            this.txpopular.setVisibility(0);
            this.rvPopularstationList.setVisibility(0);
            ArrayList<StationModel> arrayList2 = this.f4359b;
            arrayList2.clear();
            arrayList2.addAll(list);
            this.b.notifyDataSetChanged();
        } else {
            this.popularLl.setVisibility(8);
        }
        return false;
    }
}
