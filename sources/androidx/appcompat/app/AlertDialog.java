package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.f;
import androidx.core.widget.NestedScrollView;
import com.google.firebase.perf.util.Constants;
import java.util.WeakHashMap;

public final class AlertDialog extends f implements DialogInterface {
    public final AlertController a = new AlertController(getContext(), this, getWindow());

    public static class Builder {
        private final AlertController.AlertParams P;
        private final int mTheme;

        public Builder(Context context) {
            this(context, AlertDialog.b(context, 0));
        }

        /* JADX WARNING: type inference failed for: r14v0, types: [android.widget.ListAdapter] */
        /* JADX WARNING: type inference failed for: r14v4 */
        /* JADX WARNING: type inference failed for: r14v5 */
        /* JADX WARNING: type inference failed for: r14v6 */
        /* JADX WARNING: type inference failed for: r4v32, types: [androidx.appcompat.app.b] */
        /* JADX WARNING: type inference failed for: r4v33, types: [androidx.appcompat.app.a] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.appcompat.app.AlertDialog create() {
            /*
                r20 = this;
                r0 = r20
                androidx.appcompat.app.AlertDialog r1 = new androidx.appcompat.app.AlertDialog
                androidx.appcompat.app.AlertController$AlertParams r2 = r0.P
                android.content.Context r2 = r2.f861a
                int r3 = r0.mTheme
                r1.<init>(r2, r3)
                androidx.appcompat.app.AlertController$AlertParams r2 = r0.P
                android.view.View r3 = r2.f870a
                r10 = 0
                androidx.appcompat.app.AlertController r11 = r1.a
                r12 = 0
                if (r3 == 0) goto L_0x001a
                r11.f849b = r3
                goto L_0x0059
            L_0x001a:
                java.lang.CharSequence r3 = r2.f873a
                if (r3 == 0) goto L_0x0027
                r11.f845a = r3
                android.widget.TextView r4 = r11.f839a
                if (r4 == 0) goto L_0x0027
                r4.setText(r3)
            L_0x0027:
                android.graphics.drawable.Drawable r3 = r2.f868a
                if (r3 == 0) goto L_0x003b
                r11.f858d = r3
                r11.g = r12
                android.widget.ImageView r4 = r11.f837a
                if (r4 == 0) goto L_0x003b
                r4.setVisibility(r12)
                android.widget.ImageView r4 = r11.f837a
                r4.setImageDrawable(r3)
            L_0x003b:
                int r3 = r2.a
                if (r3 == 0) goto L_0x0059
                r11.f858d = r10
                r11.g = r3
                android.widget.ImageView r4 = r11.f837a
                if (r4 == 0) goto L_0x0059
                if (r3 == 0) goto L_0x0054
                r4.setVisibility(r12)
                android.widget.ImageView r3 = r11.f837a
                int r4 = r11.g
                r3.setImageResource(r4)
                goto L_0x0059
            L_0x0054:
                r3 = 8
                r4.setVisibility(r3)
            L_0x0059:
                java.lang.CharSequence r3 = r2.f881b
                if (r3 == 0) goto L_0x0066
                r11.f852b = r3
                android.widget.TextView r4 = r11.f851b
                if (r4 == 0) goto L_0x0066
                r4.setText(r3)
            L_0x0066:
                java.lang.CharSequence r3 = r2.f886c
                if (r3 != 0) goto L_0x006e
                android.graphics.drawable.Drawable r4 = r2.f879b
                if (r4 == 0) goto L_0x0076
            L_0x006e:
                android.content.DialogInterface$OnClickListener r4 = r2.f863a
                android.graphics.drawable.Drawable r5 = r2.f879b
                r6 = -1
                r11.d(r6, r3, r4, r5)
            L_0x0076:
                java.lang.CharSequence r3 = r2.f890d
                if (r3 != 0) goto L_0x007e
                android.graphics.drawable.Drawable r4 = r2.f885c
                if (r4 == 0) goto L_0x0086
            L_0x007e:
                android.content.DialogInterface$OnClickListener r4 = r2.f878b
                android.graphics.drawable.Drawable r5 = r2.f885c
                r6 = -2
                r11.d(r6, r3, r4, r5)
            L_0x0086:
                java.lang.CharSequence r3 = r2.f892e
                if (r3 != 0) goto L_0x008e
                android.graphics.drawable.Drawable r4 = r2.f889d
                if (r4 == 0) goto L_0x0096
            L_0x008e:
                android.content.DialogInterface$OnClickListener r4 = r2.f884c
                android.graphics.drawable.Drawable r5 = r2.f889d
                r6 = -3
                r11.d(r6, r3, r4, r5)
            L_0x0096:
                java.lang.CharSequence[] r3 = r2.f876a
                r13 = 1
                if (r3 != 0) goto L_0x00a3
                android.database.Cursor r3 = r2.f867a
                if (r3 != 0) goto L_0x00a3
                android.widget.ListAdapter r3 = r2.f872a
                if (r3 == 0) goto L_0x0145
            L_0x00a3:
                int r3 = r11.j
                android.view.LayoutInflater r4 = r2.f869a
                android.view.View r3 = r4.inflate(r3, r10)
                androidx.appcompat.app.AlertController$RecycleListView r3 = (androidx.appcompat.app.AlertController.RecycleListView) r3
                boolean r4 = r2.f887c
                if (r4 == 0) goto L_0x00d2
                android.database.Cursor r4 = r2.f867a
                if (r4 != 0) goto L_0x00c4
                androidx.appcompat.app.a r14 = new androidx.appcompat.app.a
                android.content.Context r6 = r2.f861a
                int r7 = r11.k
                java.lang.CharSequence[] r8 = r2.f876a
                r4 = r14
                r5 = r2
                r9 = r3
                r4.<init>(r5, r6, r7, r8, r9)
                goto L_0x010d
            L_0x00c4:
                androidx.appcompat.app.b r14 = new androidx.appcompat.app.b
                android.content.Context r6 = r2.f861a
                android.database.Cursor r7 = r2.f867a
                r4 = r14
                r5 = r2
                r8 = r3
                r9 = r11
                r4.<init>(r5, r6, r7, r8, r9)
                goto L_0x010d
            L_0x00d2:
                boolean r4 = r2.f891d
                if (r4 == 0) goto L_0x00d9
                int r4 = r11.l
                goto L_0x00db
            L_0x00d9:
                int r4 = r11.m
            L_0x00db:
                android.database.Cursor r5 = r2.f867a
                if (r5 == 0) goto L_0x00ff
                android.widget.SimpleCursorAdapter r5 = new android.widget.SimpleCursorAdapter
                android.content.Context r15 = r2.f861a
                android.database.Cursor r6 = r2.f867a
                java.lang.String[] r7 = new java.lang.String[r13]
                java.lang.String r8 = r2.f874a
                r7[r12] = r8
                int[] r8 = new int[r13]
                r9 = 16908308(0x1020014, float:2.3877285E-38)
                r8[r12] = r9
                r14 = r5
                r16 = r4
                r17 = r6
                r18 = r7
                r19 = r8
                r14.<init>(r15, r16, r17, r18, r19)
                goto L_0x010d
            L_0x00ff:
                android.widget.ListAdapter r14 = r2.f872a
                if (r14 == 0) goto L_0x0104
                goto L_0x010d
            L_0x0104:
                androidx.appcompat.app.AlertController$c r14 = new androidx.appcompat.app.AlertController$c
                android.content.Context r5 = r2.f861a
                java.lang.CharSequence[] r6 = r2.f876a
                r14.<init>(r5, r4, r6)
            L_0x010d:
                r11.f838a = r14
                int r4 = r2.g
                r11.h = r4
                android.content.DialogInterface$OnClickListener r4 = r2.f888d
                if (r4 == 0) goto L_0x0120
                androidx.appcompat.app.c r4 = new androidx.appcompat.app.c
                r4.<init>(r2, r11)
                r3.setOnItemClickListener(r4)
                goto L_0x012c
            L_0x0120:
                android.content.DialogInterface$OnMultiChoiceClickListener r4 = r2.f866a
                if (r4 == 0) goto L_0x012c
                androidx.appcompat.app.d r4 = new androidx.appcompat.app.d
                r4.<init>(r2, r3, r11)
                r3.setOnItemClickListener(r4)
            L_0x012c:
                android.widget.AdapterView$OnItemSelectedListener r4 = r2.f871a
                if (r4 == 0) goto L_0x0133
                r3.setOnItemSelectedListener(r4)
            L_0x0133:
                boolean r4 = r2.f891d
                if (r4 == 0) goto L_0x013b
                r3.setChoiceMode(r13)
                goto L_0x0143
            L_0x013b:
                boolean r4 = r2.f887c
                if (r4 == 0) goto L_0x0143
                r4 = 2
                r3.setChoiceMode(r4)
            L_0x0143:
                r11.f840a = r3
            L_0x0145:
                android.view.View r3 = r2.f880b
                if (r3 == 0) goto L_0x016b
                boolean r4 = r2.f883b
                if (r4 == 0) goto L_0x0164
                int r4 = r2.c
                int r5 = r2.d
                int r6 = r2.e
                int r2 = r2.f
                r11.f834a = r3
                r11.b = r12
                r11.f846a = r13
                r11.c = r4
                r11.d = r5
                r11.e = r6
                r11.f = r2
                goto L_0x0175
            L_0x0164:
                r11.f834a = r3
                r11.b = r12
                r11.f846a = r12
                goto L_0x0175
            L_0x016b:
                int r2 = r2.b
                if (r2 == 0) goto L_0x0175
                r11.f834a = r10
                r11.b = r2
                r11.f846a = r12
            L_0x0175:
                androidx.appcompat.app.AlertController$AlertParams r2 = r0.P
                boolean r2 = r2.f875a
                r1.setCancelable(r2)
                androidx.appcompat.app.AlertController$AlertParams r2 = r0.P
                boolean r2 = r2.f875a
                if (r2 == 0) goto L_0x0185
                r1.setCanceledOnTouchOutside(r13)
            L_0x0185:
                androidx.appcompat.app.AlertController$AlertParams r2 = r0.P
                android.content.DialogInterface$OnCancelListener r2 = r2.f862a
                r1.setOnCancelListener(r2)
                androidx.appcompat.app.AlertController$AlertParams r2 = r0.P
                android.content.DialogInterface$OnDismissListener r2 = r2.f864a
                r1.setOnDismissListener(r2)
                androidx.appcompat.app.AlertController$AlertParams r2 = r0.P
                android.content.DialogInterface$OnKeyListener r2 = r2.f865a
                if (r2 == 0) goto L_0x019c
                r1.setOnKeyListener(r2)
            L_0x019c:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AlertDialog.Builder.create():androidx.appcompat.app.AlertDialog");
        }

        public Context getContext() {
            return this.P.f861a;
        }

        public Builder setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.f872a = listAdapter;
            alertParams.f888d = onClickListener;
            return this;
        }

        public Builder setCancelable(boolean z) {
            this.P.f875a = z;
            return this;
        }

        public Builder setCursor(Cursor cursor, DialogInterface.OnClickListener onClickListener, String str) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.f867a = cursor;
            alertParams.f874a = str;
            alertParams.f888d = onClickListener;
            return this;
        }

        public Builder setCustomTitle(View view) {
            this.P.f870a = view;
            return this;
        }

        public Builder setIcon(int i) {
            this.P.a = i;
            return this;
        }

        public Builder setIconAttribute(int i) {
            TypedValue typedValue = new TypedValue();
            this.P.f861a.getTheme().resolveAttribute(i, typedValue, true);
            this.P.a = typedValue.resourceId;
            return this;
        }

        @Deprecated
        public Builder setInverseBackgroundForced(boolean z) {
            this.P.getClass();
            return this;
        }

        public Builder setItems(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.f876a = alertParams.f861a.getResources().getTextArray(i);
            this.P.f888d = onClickListener;
            return this;
        }

        public Builder setMessage(int i) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.f881b = alertParams.f861a.getText(i);
            return this;
        }

        public Builder setMultiChoiceItems(int i, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.f876a = alertParams.f861a.getResources().getTextArray(i);
            AlertController.AlertParams alertParams2 = this.P;
            alertParams2.f866a = onMultiChoiceClickListener;
            alertParams2.f877a = zArr;
            alertParams2.f887c = true;
            return this;
        }

        public Builder setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.f890d = alertParams.f861a.getText(i);
            this.P.f878b = onClickListener;
            return this;
        }

        public Builder setNegativeButtonIcon(Drawable drawable) {
            this.P.f885c = drawable;
            return this;
        }

        public Builder setNeutralButton(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.f892e = alertParams.f861a.getText(i);
            this.P.f884c = onClickListener;
            return this;
        }

        public Builder setNeutralButtonIcon(Drawable drawable) {
            this.P.f889d = drawable;
            return this;
        }

        public Builder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.P.f862a = onCancelListener;
            return this;
        }

        public Builder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.P.f864a = onDismissListener;
            return this;
        }

        public Builder setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
            this.P.f871a = onItemSelectedListener;
            return this;
        }

        public Builder setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
            this.P.f865a = onKeyListener;
            return this;
        }

        public Builder setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.f886c = alertParams.f861a.getText(i);
            this.P.f863a = onClickListener;
            return this;
        }

        public Builder setPositiveButtonIcon(Drawable drawable) {
            this.P.f879b = drawable;
            return this;
        }

        public Builder setRecycleOnMeasureEnabled(boolean z) {
            this.P.getClass();
            return this;
        }

        public Builder setSingleChoiceItems(int i, int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.f876a = alertParams.f861a.getResources().getTextArray(i);
            AlertController.AlertParams alertParams2 = this.P;
            alertParams2.f888d = onClickListener;
            alertParams2.g = i2;
            alertParams2.f891d = true;
            return this;
        }

        public Builder setTitle(int i) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.f873a = alertParams.f861a.getText(i);
            return this;
        }

        public Builder setView(int i) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.f880b = null;
            alertParams.b = i;
            alertParams.f883b = false;
            return this;
        }

        public AlertDialog show() {
            AlertDialog create = create();
            create.show();
            return create;
        }

        public Builder(Context context, int i) {
            this.P = new AlertController.AlertParams(new ContextThemeWrapper(context, AlertDialog.b(context, i)));
            this.mTheme = i;
        }

        public Builder setIcon(Drawable drawable) {
            this.P.f868a = drawable;
            return this;
        }

        public Builder setMessage(CharSequence charSequence) {
            this.P.f881b = charSequence;
            return this;
        }

        public Builder setTitle(CharSequence charSequence) {
            this.P.f873a = charSequence;
            return this;
        }

        public Builder setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.f876a = charSequenceArr;
            alertParams.f888d = onClickListener;
            return this;
        }

        public Builder setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.f890d = charSequence;
            alertParams.f878b = onClickListener;
            return this;
        }

        public Builder setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.f892e = charSequence;
            alertParams.f884c = onClickListener;
            return this;
        }

        public Builder setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.f886c = charSequence;
            alertParams.f863a = onClickListener;
            return this;
        }

        public Builder setView(View view) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.f880b = view;
            alertParams.b = 0;
            alertParams.f883b = false;
            return this;
        }

        public Builder setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.f876a = charSequenceArr;
            alertParams.f866a = onMultiChoiceClickListener;
            alertParams.f877a = zArr;
            alertParams.f887c = true;
            return this;
        }

        public Builder setSingleChoiceItems(Cursor cursor, int i, String str, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.f867a = cursor;
            alertParams.f888d = onClickListener;
            alertParams.g = i;
            alertParams.f874a = str;
            alertParams.f891d = true;
            return this;
        }

        @Deprecated
        public Builder setView(View view, int i, int i2, int i3, int i4) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.f880b = view;
            alertParams.b = 0;
            alertParams.f883b = true;
            alertParams.c = i;
            alertParams.d = i2;
            alertParams.e = i3;
            alertParams.f = i4;
            return this;
        }

        public Builder setMultiChoiceItems(Cursor cursor, String str, String str2, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.f867a = cursor;
            alertParams.f866a = onMultiChoiceClickListener;
            alertParams.f882b = str;
            alertParams.f874a = str2;
            alertParams.f887c = true;
            return this;
        }

        public Builder setSingleChoiceItems(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.f876a = charSequenceArr;
            alertParams.f888d = onClickListener;
            alertParams.g = i;
            alertParams.f891d = true;
            return this;
        }

        public Builder setSingleChoiceItems(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.P;
            alertParams.f872a = listAdapter;
            alertParams.f888d = onClickListener;
            alertParams.g = i;
            alertParams.f891d = true;
            return this;
        }
    }

    public AlertDialog(Context context, int i) {
        super(context, b(context, i));
    }

    public static int b(Context context, int i) {
        if (((i >>> 24) & Constants.MAX_HOST_LENGTH) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0220hr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public final void onCreate(Bundle bundle) {
        boolean z;
        boolean z2;
        View view;
        boolean z3;
        boolean z4;
        int i;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        ListAdapter listAdapter;
        boolean z9;
        View findViewById;
        int i2;
        super.onCreate(bundle);
        AlertController alertController = this.a;
        alertController.f843a.setContentView(alertController.i);
        int i3 = Gr.parentPanel;
        Window window = alertController.f835a;
        View findViewById2 = window.findViewById(i3);
        int i4 = Gr.topPanel;
        View findViewById3 = findViewById2.findViewById(i4);
        int i5 = Gr.contentPanel;
        View findViewById4 = findViewById2.findViewById(i5);
        int i6 = Gr.buttonPanel;
        View findViewById5 = findViewById2.findViewById(i6);
        ViewGroup viewGroup = (ViewGroup) findViewById2.findViewById(Gr.customPanel);
        View view2 = alertController.f834a;
        Context context = alertController.f831a;
        if (view2 == null) {
            if (alertController.b != 0) {
                view2 = LayoutInflater.from(context).inflate(alertController.b, viewGroup, false);
            } else {
                view2 = null;
            }
        }
        if (view2 != null) {
            z = true;
        } else {
            z = false;
        }
        if (!z || !AlertController.a(view2)) {
            window.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) window.findViewById(Gr.custom);
            frameLayout.addView(view2, new ViewGroup.LayoutParams(-1, -1));
            if (alertController.f846a) {
                frameLayout.setPadding(alertController.c, alertController.d, alertController.e, alertController.f);
            }
            if (alertController.f840a != null) {
                ((LinearLayoutCompat.LayoutParams) viewGroup.getLayoutParams()).weight = 0.0f;
            }
        } else {
            viewGroup.setVisibility(8);
        }
        View findViewById6 = viewGroup.findViewById(i4);
        View findViewById7 = viewGroup.findViewById(i5);
        View findViewById8 = viewGroup.findViewById(i6);
        ViewGroup c = AlertController.c(findViewById6, findViewById3);
        ViewGroup c2 = AlertController.c(findViewById7, findViewById4);
        ViewGroup c3 = AlertController.c(findViewById8, findViewById5);
        NestedScrollView nestedScrollView = (NestedScrollView) window.findViewById(Gr.scrollView);
        alertController.f844a = nestedScrollView;
        nestedScrollView.setFocusable(false);
        alertController.f844a.setNestedScrollingEnabled(false);
        TextView textView = (TextView) c2.findViewById(16908299);
        alertController.f851b = textView;
        if (textView != null) {
            CharSequence charSequence = alertController.f852b;
            if (charSequence != null) {
                textView.setText(charSequence);
            } else {
                textView.setVisibility(8);
                alertController.f844a.removeView(alertController.f851b);
                if (alertController.f840a != null) {
                    ViewGroup viewGroup2 = (ViewGroup) alertController.f844a.getParent();
                    int indexOfChild = viewGroup2.indexOfChild(alertController.f844a);
                    viewGroup2.removeViewAt(indexOfChild);
                    viewGroup2.addView(alertController.f840a, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                } else {
                    c2.setVisibility(8);
                }
            }
        }
        Button button = (Button) c3.findViewById(16908313);
        alertController.f836a = button;
        AlertController.a aVar = alertController.f841a;
        button.setOnClickListener(aVar);
        boolean isEmpty = TextUtils.isEmpty(alertController.f857c);
        int i7 = alertController.a;
        if (!isEmpty || alertController.f832a != null) {
            alertController.f836a.setText(alertController.f857c);
            Drawable drawable = alertController.f832a;
            if (drawable != null) {
                drawable.setBounds(0, 0, i7, i7);
                alertController.f836a.setCompoundDrawables(alertController.f832a, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            alertController.f836a.setVisibility(0);
            z2 = true;
        } else {
            alertController.f836a.setVisibility(8);
            z2 = false;
        }
        Button button2 = (Button) c3.findViewById(16908314);
        alertController.f850b = button2;
        button2.setOnClickListener(aVar);
        if (!TextUtils.isEmpty(alertController.f859d) || alertController.f847b != null) {
            alertController.f850b.setText(alertController.f859d);
            Drawable drawable2 = alertController.f847b;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, i7, i7);
                alertController.f850b.setCompoundDrawables(alertController.f847b, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            alertController.f850b.setVisibility(0);
            z2 |= true;
        } else {
            alertController.f850b.setVisibility(8);
        }
        Button button3 = (Button) c3.findViewById(16908315);
        alertController.f856c = button3;
        button3.setOnClickListener(aVar);
        if (!TextUtils.isEmpty(alertController.f860e) || alertController.f854c != null) {
            alertController.f856c.setText(alertController.f860e);
            Drawable drawable3 = alertController.f854c;
            if (drawable3 != null) {
                i2 = 0;
                drawable3.setBounds(0, 0, i7, i7);
                view = null;
                alertController.f856c.setCompoundDrawables(alertController.f854c, (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                i2 = 0;
                view = null;
            }
            alertController.f856c.setVisibility(i2);
            z2 |= true;
        } else {
            alertController.f856c.setVisibility(8);
            view = null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0220hr.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            if (z2) {
                AlertController.b(alertController.f836a);
            } else if (z2) {
                AlertController.b(alertController.f850b);
            } else if (z2) {
                AlertController.b(alertController.f856c);
            }
        }
        if (z2) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (!z4) {
            c3.setVisibility(8);
        }
        if (alertController.f849b != null) {
            c.addView(alertController.f849b, 0, new ViewGroup.LayoutParams(-1, -2));
            i = 8;
            window.findViewById(Gr.title_template).setVisibility(8);
        } else {
            alertController.f837a = (ImageView) window.findViewById(16908294);
            if (!(!TextUtils.isEmpty(alertController.f845a)) || !alertController.f853b) {
                i = 8;
                window.findViewById(Gr.title_template).setVisibility(8);
                alertController.f837a.setVisibility(8);
                c.setVisibility(8);
            } else {
                TextView textView2 = (TextView) window.findViewById(Gr.alertTitle);
                alertController.f839a = textView2;
                textView2.setText(alertController.f845a);
                int i8 = alertController.g;
                if (i8 != 0) {
                    alertController.f837a.setImageResource(i8);
                } else {
                    Drawable drawable4 = alertController.f858d;
                    if (drawable4 != null) {
                        alertController.f837a.setImageDrawable(drawable4);
                    } else {
                        alertController.f839a.setPadding(alertController.f837a.getPaddingLeft(), alertController.f837a.getPaddingTop(), alertController.f837a.getPaddingRight(), alertController.f837a.getPaddingBottom());
                        i = 8;
                        alertController.f837a.setVisibility(8);
                    }
                }
                i = 8;
            }
        }
        if (viewGroup.getVisibility() != i) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (c == null || c.getVisibility() == i) {
            z6 = false;
        } else {
            z6 = true;
        }
        if (c3.getVisibility() != i) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7 && (findViewById = c2.findViewById(Gr.textSpacerNoButtons)) != null) {
            findViewById.setVisibility(0);
        }
        if (z6) {
            NestedScrollView nestedScrollView2 = alertController.f844a;
            if (nestedScrollView2 != null) {
                nestedScrollView2.setClipToPadding(true);
            }
            if (!(alertController.f852b == null && alertController.f840a == null)) {
                view = c.findViewById(Gr.titleDividerNoCustom);
            }
            z8 = false;
            if (view != null) {
                view.setVisibility(0);
            }
        } else {
            z8 = false;
            View findViewById9 = c2.findViewById(Gr.textSpacerNoTitle);
            if (findViewById9 != null) {
                findViewById9.setVisibility(0);
            }
        }
        AlertController.RecycleListView recycleListView = alertController.f840a;
        if (recycleListView instanceof AlertController.RecycleListView) {
            recycleListView.setHasDecor(z6, z7);
        }
        if (!z5) {
            View view3 = alertController.f840a;
            if (view3 == null) {
                view3 = alertController.f844a;
            }
            if (view3 != null) {
                if (z7) {
                    z9 = true;
                } else {
                    z9 = z8;
                }
                boolean z10 = z6 | z9;
                View findViewById10 = window.findViewById(Gr.scrollIndicatorUp);
                View findViewById11 = window.findViewById(Gr.scrollIndicatorDown);
                WeakHashMap<View, GC> weakHashMap = f.f1839a;
                f.e.d(view3, z10 ? 1 : 0, 3);
                if (findViewById10 != null) {
                    c2.removeView(findViewById10);
                }
                if (findViewById11 != null) {
                    c2.removeView(findViewById11);
                }
            }
        }
        AlertController.RecycleListView recycleListView2 = alertController.f840a;
        if (recycleListView2 != null && (listAdapter = alertController.f838a) != null) {
            recycleListView2.setAdapter(listAdapter);
            int i9 = alertController.h;
            if (i9 > -1) {
                recycleListView2.setItemChecked(i9, true);
                recycleListView2.setSelection(i9);
            }
        }
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z;
        NestedScrollView nestedScrollView = this.a.f844a;
        if (nestedScrollView == null || !nestedScrollView.d(keyEvent)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        boolean z;
        NestedScrollView nestedScrollView = this.a.f844a;
        if (nestedScrollView == null || !nestedScrollView.d(keyEvent)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    public final void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        AlertController alertController = this.a;
        alertController.f845a = charSequence;
        TextView textView = alertController.f839a;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }
}
