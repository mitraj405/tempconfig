package cris.org.in.ima.fragment;

import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;
import cris.org.in.ima.adaptors.StationListAdapter;
import cris.org.in.ima.adaptors.ViewPagerAdapter;
import cris.org.in.ima.model.StationModel;
import cris.org.in.prs.ima.R;
import java.util.ArrayList;

public class StationFragment extends Fragment {
    public U9 a;

    /* renamed from: a  reason: collision with other field name */
    public final b f5118a = new b();

    /* renamed from: a  reason: collision with other field name */
    public StationModel f5119a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f5120a;
    public final int c = 25;
    @BindView(2131364553)
    TextView recentStationSearch;
    @BindView(2131363836)
    RecyclerView stationList;
    @BindView(2131364587)
    EditText stationSearch;

    public class a extends RecyclerView.OnScrollListener {
        public a() {
        }

        public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (i2 > 0) {
                C0535I5.H(StationFragment.this.getActivity(), recyclerView);
            }
        }
    }

    public class b implements StationListAdapter.StationListAdapterStnSelectListener {
        public b() {
        }

        public final void onStationClick(StationModel stationModel) {
            StationFragment stationFragment = StationFragment.this;
            stationFragment.f5119a = stationModel;
            stationFragment.f5120a = false;
            EditText editText = stationFragment.stationSearch;
            editText.setText(stationModel.b + " (" + stationModel.f5341a + ")");
            stationFragment.a.a.clear();
            stationFragment.a.notifyDataSetChanged();
            stationFragment.f5120a = true;
            ViewPager viewPager = (ViewPager) stationFragment.getActivity().findViewById(R.id.pager);
            ImageView imageView = (ImageView) stationFragment.getActivity().findViewById(R.id.iv_back_arrow);
            ViewPagerAdapter viewPagerAdapter = (ViewPagerAdapter) viewPager.getAdapter();
            StationModel stationModel2 = ((StationFragment) viewPagerAdapter.getItem(0)).f5119a;
            StationModel stationModel3 = ((StationFragment) viewPagerAdapter.getItem(1)).f5119a;
            if (viewPager.getCurrentItem() == 1) {
                stationFragment.getClass();
                if (stationModel2 != null) {
                    imageView.performClick();
                    return;
                }
                viewPager.setCurrentItem(0, true);
                stationFragment.stationSearch.requestFocus();
                return;
            }
            stationFragment.getClass();
            if (stationModel3 != null) {
                imageView.performClick();
            } else {
                viewPager.setCurrentItem(1, true);
            }
        }
    }

    static {
        C1354qp.R(StationFragment.class);
    }

    public final void f() {
        try {
            ArrayList<StationModel> e = C0793b1.a.f3911a.e();
            if (e != null) {
                this.a.a.clear();
                U9 u9 = this.a;
                u9.a = e;
                u9.notifyDataSetChanged();
                this.a.notifyDataSetChanged();
            } else if (e != null && e.isEmpty()) {
                this.a.a.clear();
            }
        } catch (SQLiteException e2) {
            e2.getMessage();
            C0535I5.t0(getActivity(), getResources().getString(R.string.unable_process_message));
        } catch (Exception unused) {
            C0535I5.t0(getActivity(), getResources().getString(R.string.unable_process_message));
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.item_search_container, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        this.stationList.setLayoutManager(new LinearLayoutManager(getActivity()));
        U9 u9 = new U9(getActivity(), this.f5118a);
        this.a = u9;
        this.stationList.setAdapter(u9);
        f();
        this.f5120a = true;
        C0535I5.a(this.stationSearch, this.c);
        this.stationList.addOnScrollListener(new a());
        return inflate;
    }

    @OnTextChanged({2131364587})
    public void stationSearchChange(CharSequence charSequence) {
        if (charSequence.length() != 0) {
            this.recentStationSearch.setVisibility(8);
            if (this.f5120a) {
                try {
                    ArrayList<StationModel> j = C0793b1.a.f3911a.j(charSequence.toString());
                    if (j != null) {
                        this.a.a.clear();
                        U9 u9 = this.a;
                        u9.a = j;
                        u9.notifyDataSetChanged();
                        this.a.notifyDataSetChanged();
                    } else if (j != null && j.isEmpty()) {
                        this.a.a.clear();
                    }
                } catch (SQLiteException e) {
                    e.getMessage();
                    C0535I5.t0(getActivity(), getResources().getString(R.string.unable_process_message));
                } catch (Exception e2) {
                    e2.getMessage();
                    C0535I5.t0(getActivity(), getResources().getString(R.string.unable_process_message));
                }
            }
        } else {
            this.recentStationSearch.setVisibility(0);
            f();
        }
    }
}
