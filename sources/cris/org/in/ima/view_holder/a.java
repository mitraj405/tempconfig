package cris.org.in.ima.view_holder;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.BookingResponseDTO;

/* compiled from: ErsTravelnsuranceViewHolder */
public final class a extends ClickableSpan {
    public final /* synthetic */ ErsTravelnsuranceViewHolder a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ BookingResponseDTO f5429a;

    public a(ErsTravelnsuranceViewHolder ersTravelnsuranceViewHolder, BookingResponseDTO bookingResponseDTO) {
        this.a = ersTravelnsuranceViewHolder;
        this.f5429a = bookingResponseDTO;
    }

    public final void onClick(View view) {
        ErsTravelnsuranceViewHolder ersTravelnsuranceViewHolder = this.a;
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(this.f5429a.getInsuranceCompanyUrl()));
            ersTravelnsuranceViewHolder.f5391a.startActivity(intent);
        } catch (Exception e) {
            int i = ErsTravelnsuranceViewHolder.a;
            e.getMessage();
            Context context = ersTravelnsuranceViewHolder.f5391a;
            C0535I5.t0(context, context.getString(R.string.unable_to_open_link));
        }
    }

    public final void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(true);
    }
}
