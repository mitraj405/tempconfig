package defpackage;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.Mv;
import java.util.ArrayList;
import java.util.List;

/* renamed from: Cv  reason: default package and case insensitive filesystem */
/* compiled from: SearchDialogAdapter */
public final class C0476Cv<T extends Mv> extends RecyclerView.Adapter<a> {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public Ev f3557a;

    /* renamed from: a  reason: collision with other field name */
    public final Context f3558a;

    /* renamed from: a  reason: collision with other field name */
    public final LayoutInflater f3559a;

    /* renamed from: a  reason: collision with other field name */
    public String f3560a;

    /* renamed from: a  reason: collision with other field name */
    public List<T> f3561a;

    /* renamed from: a  reason: collision with other field name */
    public C1508z2 f3562a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f3563a;
    public final String b;

    /* renamed from: Cv$a */
    /* compiled from: SearchDialogAdapter */
    public static class a extends RecyclerView.ViewHolder {
        public final View a;

        public a(View view) {
            super(view);
            this.a = view;
        }
    }

    public C0476Cv() {
        throw null;
    }

    public C0476Cv(Context context, ArrayList arrayList) {
        this.f3561a = new ArrayList();
        this.f3563a = true;
        this.b = "#FFED2E47";
        this.f3558a = context;
        this.f3559a = LayoutInflater.from(context);
        this.f3561a = arrayList;
        this.a = 17367043;
    }

    public final int getItemCount() {
        List<T> list = this.f3561a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        a aVar = (a) viewHolder;
        Mv mv = (Mv) this.f3561a.get(i);
        TextView textView = (TextView) aVar.a.findViewById(16908308);
        if (this.f3560a == null || !this.f3563a) {
            textView.setText(mv.getTitle());
        } else {
            String title = mv.getTitle();
            String str = this.f3560a;
            int parseColor = Color.parseColor(this.b);
            String j = C1488xu.j(title.toLowerCase(), str.toLowerCase());
            String lowerCase = title.toLowerCase();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append(title);
            for (int i2 = 0; i2 < lowerCase.length() && j.length() > 0; i2++) {
                if (lowerCase.charAt(i2) == j.charAt(0)) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(parseColor), i2, i2 + 1, 0);
                    j = j.substring(1);
                }
            }
            textView.setText(spannableStringBuilder);
        }
        if (this.f3557a != null) {
            aVar.a.setOnClickListener(new C0465Bv(this, mv, i));
        }
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = this.f3559a.inflate(this.a, viewGroup, false);
        inflate.setTag(new a(inflate));
        return (a) inflate.getTag();
    }
}
