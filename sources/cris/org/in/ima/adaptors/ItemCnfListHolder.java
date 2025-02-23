package cris.org.in.ima.adaptors;

import android.view.View;
import android.widget.TextView;
import com.google.firebase.sessions.settings.RemoteSettings;
import cris.prs.webservices.dto.MaxWLRacCnfDTO;
import java.text.SimpleDateFormat;
import java.util.Locale;
import uk.co.ribot.easyadapter.PositionInfo;

@C0708Uh(2131558579)
public class ItemCnfListHolder extends C1424ug<MaxWLRacCnfDTO> {
    @C1456wC(2131362064)
    private TextView booking_status;
    @C1456wC(2131362920)
    private TextView journey_date;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    public ItemCnfListHolder(View view) {
        super(view);
    }

    public void onSetValues(MaxWLRacCnfDTO maxWLRacCnfDTO, PositionInfo positionInfo) {
        if (maxWLRacCnfDTO != null) {
            this.journey_date.setText(this.sdf.format(maxWLRacCnfDTO.getJdate()));
            TextView textView = this.booking_status;
            StringBuilder sb = new StringBuilder();
            String lastYearRunningStatus = maxWLRacCnfDTO.getLastYearRunningStatus();
            int[] X = xx.X(3);
            int length = X.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                int i2 = X[i];
                if (C1058d.n(i2).equalsIgnoreCase(lastYearRunningStatus)) {
                    lastYearRunningStatus = C1058d.p(i2);
                    break;
                }
                i++;
            }
            sb.append(lastYearRunningStatus);
            sb.append(RemoteSettings.FORWARD_SLASH_STRING);
            sb.append(maxWLRacCnfDTO.getLastYearRunningNumber());
            textView.setText(sb.toString());
        }
    }
}
