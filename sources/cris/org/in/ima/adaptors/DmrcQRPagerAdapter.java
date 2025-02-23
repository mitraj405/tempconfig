package cris.org.in.ima.adaptors;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import cris.org.in.prs.ima.R;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;

public class DmrcQRPagerAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = C1354qp.R(DmrcQRPagerAdapter.class);
    private Context context;
    QrClickListener listener;
    private List<C1283nl> metroPsgnList;
    Integer qrCancelId;
    String qrCancelString;
    String qrCodeString;

    public interface QrClickListener {
        void onQrClickListener(String str, int i);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView from_stn;
        TextView journey_dateur;
        TextView positionTextView;
        TextView qrCancelMsg;
        ImageView qrCode;
        TextView qrNo;
        TextView toStn;

        public ViewHolder(View view) {
            super(view);
            this.qrCode = (ImageView) view.findViewById(R.id.qr_code);
            this.qrNo = (TextView) view.findViewById(R.id.qr_no);
            this.qrCancelMsg = (TextView) view.findViewById(R.id.qr_cancel_msg);
            this.positionTextView = (TextView) view.findViewById(R.id.positionTextView);
        }
    }

    public DmrcQRPagerAdapter(Context context2, List<C1283nl> list, QrClickListener qrClickListener) {
        this.context = context2;
        this.metroPsgnList = list;
        this.listener = qrClickListener;
    }

    private void OnClickListener(ImageView imageView, final QrClickListener qrClickListener, final String str, final int i) {
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                qrClickListener.onQrClickListener(str, i);
            }
        });
    }

    private void initQRCode(ViewHolder viewHolder, String str) {
        String str2;
        int i;
        try {
            str2 = new String(str.getBytes("UTF-8"), Charset.forName("UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            str2 = "";
        }
        try {
            BitMatrix encode = new MultiFormatWriter().encode(str2, BarcodeFormat.QR_CODE, 300, 300);
            int width = encode.getWidth();
            int height = encode.getHeight();
            int[] iArr = new int[(width * height)];
            for (int i2 = 0; i2 < height; i2++) {
                int i3 = i2 * width;
                for (int i4 = 0; i4 < width; i4++) {
                    int i5 = i3 + i4;
                    if (encode.get(i4, i2)) {
                        i = -16777216;
                    } else {
                        i = -1;
                    }
                    iArr[i5] = i;
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
            viewHolder.qrCode.setImageBitmap(createBitmap);
            viewHolder.qrCode.setVisibility(0);
            Integer num = this.qrCancelId;
            if (num == null || num.intValue() <= 0) {
                viewHolder.qrCancelMsg.setVisibility(8);
                return;
            }
            viewHolder.qrCancelMsg.setVisibility(0);
            viewHolder.qrCancelMsg.setText(this.qrCancelString);
        } catch (WriterException e) {
            e.getMessage();
        }
    }

    public int getItemCount() {
        List<C1283nl> list = this.metroPsgnList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(C1058d.s(viewGroup, R.layout.dmrc_qr_item_page, viewGroup, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        this.qrCodeString = this.metroPsgnList.get(i).getMetroQrTicketBlock();
        this.qrCancelId = this.metroPsgnList.get(i).getCancelStatus();
        this.qrCancelString = this.metroPsgnList.get(i).getCancelStatusString();
        initQRCode(viewHolder, this.qrCodeString);
        int size = this.metroPsgnList.size();
        TextView textView = viewHolder.positionTextView;
        textView.setText("PASSENGER " + (i + 1) + RemoteSettings.FORWARD_SLASH_STRING + size);
        TextView textView2 = viewHolder.qrNo;
        StringBuilder sb = new StringBuilder("QR No: ");
        sb.append(this.metroPsgnList.get(i).getMetroQrTicketNo());
        textView2.setText(sb.toString());
        OnClickListener(viewHolder.qrCode, this.listener, this.qrCodeString, i);
    }
}
