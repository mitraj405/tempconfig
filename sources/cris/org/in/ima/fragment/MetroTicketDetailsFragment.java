package cris.org.in.ima.fragment;

import android.app.AlertDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.adaptors.DmrcQRPagerAdapter;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.BookingResponseDTO;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;

public class MetroTicketDetailsFragment extends Fragment {
    public final d a = new d();

    /* renamed from: a  reason: collision with other field name */
    public BookingResponseDTO f4815a;

    /* renamed from: a  reason: collision with other field name */
    public List<C1283nl> f4816a;

    /* renamed from: a  reason: collision with other field name */
    public String[] f4817a;
    @BindView(2131362060)
    TextView bookingDate;
    @BindView(2131362422)
    TextView dmrcFromStn;
    @BindView(2131362427)
    RecyclerView dmrcQrCodeViewPager;
    @BindView(2131362431)
    LinearLayout dmrcTicketDetailsRl;
    @BindView(2131362433)
    TextView dmrcToStn;
    @BindView(2131362420)
    TextView dmrc_congratulation_msg;
    @BindView(2131362840)
    RecyclerView indicator_rv;
    @BindView(2131362976)
    ImageView left_arrow;
    @BindView(2131363346)
    TextView noOfPassenger;
    @BindView(2131363335)
    TextView no_of_tickets;
    @BindView(2131363499)
    TextView phone_screen_with_scratches;
    @BindView(2131363567)
    LinearLayout qrImagelayout;
    @BindView(2131363568)
    ImageView qrImg;
    @BindView(2131363569)
    ImageView qrImgCross;
    @BindView(2131363575)
    TextView qr_no;
    @BindView(2131363699)
    ImageView right_arrow;
    @BindView(2131364144)
    TextView tickets_validity_infoMsg_txt;
    @BindView(2131364214)
    TextView transactionId;

    public class a implements View.OnClickListener {
        public a() {
        }

        public final void onClick(View view) {
            MetroTicketDetailsFragment metroTicketDetailsFragment = MetroTicketDetailsFragment.this;
            int findFirstVisibleItemPosition = ((LinearLayoutManager) metroTicketDetailsFragment.dmrcQrCodeViewPager.getLayoutManager()).findFirstVisibleItemPosition() + 1;
            if (findFirstVisibleItemPosition < metroTicketDetailsFragment.f4815a.getMetroServiceDetail().getNumberOfPassengerOpted().shortValue()) {
                metroTicketDetailsFragment.dmrcQrCodeViewPager.smoothScrollToPosition(findFirstVisibleItemPosition);
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public final void onClick(View view) {
            MetroTicketDetailsFragment metroTicketDetailsFragment = MetroTicketDetailsFragment.this;
            int findFirstVisibleItemPosition = ((LinearLayoutManager) metroTicketDetailsFragment.dmrcQrCodeViewPager.getLayoutManager()).findFirstVisibleItemPosition() - 1;
            if (findFirstVisibleItemPosition >= 0) {
                metroTicketDetailsFragment.dmrcQrCodeViewPager.smoothScrollToPosition(findFirstVisibleItemPosition);
            }
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public final void onClick(View view) {
            MetroTicketDetailsFragment metroTicketDetailsFragment = MetroTicketDetailsFragment.this;
            metroTicketDetailsFragment.qrImagelayout.setVisibility(8);
            metroTicketDetailsFragment.dmrcTicketDetailsRl.setVisibility(0);
            HomeActivity.J();
        }
    }

    public class d implements DmrcQRPagerAdapter.QrClickListener {
        public d() {
        }

        public final void onQrClickListener(String str, int i) {
            String str2;
            int i2;
            HomeActivity.t();
            MetroTicketDetailsFragment metroTicketDetailsFragment = MetroTicketDetailsFragment.this;
            metroTicketDetailsFragment.qrImagelayout.setVisibility(0);
            String metroQrTicketBlock = metroTicketDetailsFragment.f4816a.get(i).getMetroQrTicketBlock();
            metroTicketDetailsFragment.qr_no.setText("QR No : " + metroTicketDetailsFragment.f4816a.get(i).getMetroQrTicketNo());
            metroTicketDetailsFragment.getClass();
            try {
                str2 = new String(metroQrTicketBlock.getBytes("UTF-8"), Charset.forName("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.getMessage();
                str2 = "";
            }
            try {
                BitMatrix encode = new MultiFormatWriter().encode(str2, BarcodeFormat.QR_CODE, 300, 300);
                int width = encode.getWidth();
                int height = encode.getHeight();
                int[] iArr = new int[(width * height)];
                for (int i3 = 0; i3 < height; i3++) {
                    int i4 = i3 * width;
                    for (int i5 = 0; i5 < width; i5++) {
                        int i6 = i4 + i5;
                        if (encode.get(i5, i3)) {
                            i2 = -16777216;
                        } else {
                            i2 = -1;
                        }
                        iArr[i6] = i2;
                    }
                }
                Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
                metroTicketDetailsFragment.qrImg.setImageBitmap(createBitmap);
                metroTicketDetailsFragment.qrImg.setVisibility(0);
            } catch (WriterException e2) {
                e2.getMessage();
            }
        }
    }

    static {
        C1354qp.R(MetroTicketDetailsFragment.class);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_metro_ticket_details, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        Bundle arguments = getArguments();
        if (arguments != null) {
            BookingResponseDTO bookingResponseDTO = (BookingResponseDTO) arguments.getSerializable("FinalBookingSummary");
            this.f4815a = bookingResponseDTO;
            String.valueOf(bookingResponseDTO.isMetroServiceOpted());
        }
        this.f4816a = this.f4815a.getMetroServiceDetail().getMetroPassengerList();
        this.f4817a = this.f4815a.getInformationMessage();
        DmrcQRPagerAdapter dmrcQRPagerAdapter = new DmrcQRPagerAdapter(getContext(), this.f4816a, this.a);
        this.dmrcQrCodeViewPager.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.dmrcQrCodeViewPager.setAdapter(dmrcQRPagerAdapter);
        this.dmrcFromStn.setText(this.f4815a.getMetroServiceDetail().getMetroFromStation());
        this.dmrcToStn.setText(this.f4815a.getMetroServiceDetail().getMetroToStation());
        this.no_of_tickets.setText(String.valueOf(this.f4815a.getMetroServiceDetail().getNumberOfPassengerOpted()));
        this.transactionId.setText(String.valueOf(this.f4815a.getMetroServiceDetail().getMetroPassengerList().get(0).getMetroTransactionId()));
        TextView textView = this.bookingDate;
        Date metroJourneyDate = this.f4815a.getMetroServiceDetail().getMetroJourneyDate();
        AlertDialog alertDialog = C0535I5.f3619a;
        textView.setText(new SimpleDateFormat("MMM dd yyyy").format(metroJourneyDate));
        String[] strArr = this.f4817a;
        if (strArr != null && strArr.length > 2) {
            this.phone_screen_with_scratches.setText(strArr[2]);
        }
        this.dmrc_congratulation_msg.setText(this.f4815a.getMetroServiceDetail().getDmrcCarbonMessage());
        try {
            LocalDateTime parse = LocalDateTime.parse(String.valueOf(this.f4815a.getMetroServiceDetail().getMetroJourneyDate()), DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss 'GMT'xxx yyyy"));
            LocalDateTime minusDays = parse.minusDays(1);
            LocalDateTime plusDays = parse.plusDays(2);
            DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("MMM dd, yyyy");
            String format = minusDays.format(ofPattern);
            String format2 = plusDays.format(ofPattern);
            String[] strArr2 = this.f4817a;
            if (strArr2 != null) {
                if (strArr2[0] != "") {
                    TextView textView2 = this.tickets_validity_infoMsg_txt;
                    textView2.setText(this.f4817a[0] + "  " + format + " - " + format2);
                    this.right_arrow.setOnClickListener(new a());
                    this.left_arrow.setOnClickListener(new b());
                    this.qrImgCross.setOnClickListener(new c());
                    HomeActivity.J();
                    return inflate;
                }
            }
            TextView textView3 = this.tickets_validity_infoMsg_txt;
            textView3.setText("Active Date:  " + format + " - " + format2);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
        this.right_arrow.setOnClickListener(new a());
        this.left_arrow.setOnClickListener(new b());
        this.qrImgCross.setOnClickListener(new c());
        HomeActivity.J();
        return inflate;
    }
}
