package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;

public final class AlertController {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final Context f831a;

    /* renamed from: a  reason: collision with other field name */
    public Drawable f832a;

    /* renamed from: a  reason: collision with other field name */
    public Message f833a;

    /* renamed from: a  reason: collision with other field name */
    public View f834a;

    /* renamed from: a  reason: collision with other field name */
    public final Window f835a;

    /* renamed from: a  reason: collision with other field name */
    public Button f836a;

    /* renamed from: a  reason: collision with other field name */
    public ImageView f837a;

    /* renamed from: a  reason: collision with other field name */
    public ListAdapter f838a;

    /* renamed from: a  reason: collision with other field name */
    public TextView f839a;

    /* renamed from: a  reason: collision with other field name */
    public RecycleListView f840a;

    /* renamed from: a  reason: collision with other field name */
    public final a f841a = new a();

    /* renamed from: a  reason: collision with other field name */
    public final b f842a;

    /* renamed from: a  reason: collision with other field name */
    public final f f843a;

    /* renamed from: a  reason: collision with other field name */
    public NestedScrollView f844a;

    /* renamed from: a  reason: collision with other field name */
    public CharSequence f845a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f846a = false;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public Drawable f847b;

    /* renamed from: b  reason: collision with other field name */
    public Message f848b;

    /* renamed from: b  reason: collision with other field name */
    public View f849b;

    /* renamed from: b  reason: collision with other field name */
    public Button f850b;

    /* renamed from: b  reason: collision with other field name */
    public TextView f851b;

    /* renamed from: b  reason: collision with other field name */
    public CharSequence f852b;

    /* renamed from: b  reason: collision with other field name */
    public final boolean f853b;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public Drawable f854c;

    /* renamed from: c  reason: collision with other field name */
    public Message f855c;

    /* renamed from: c  reason: collision with other field name */
    public Button f856c;

    /* renamed from: c  reason: collision with other field name */
    public CharSequence f857c;
    public int d;

    /* renamed from: d  reason: collision with other field name */
    public Drawable f858d;

    /* renamed from: d  reason: collision with other field name */
    public CharSequence f859d;
    public int e;

    /* renamed from: e  reason: collision with other field name */
    public CharSequence f860e;
    public int f;
    public int g = 0;
    public int h = -1;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;

    public static class AlertParams {
        public int a = 0;

        /* renamed from: a  reason: collision with other field name */
        public final Context f861a;

        /* renamed from: a  reason: collision with other field name */
        public DialogInterface.OnCancelListener f862a;

        /* renamed from: a  reason: collision with other field name */
        public DialogInterface.OnClickListener f863a;

        /* renamed from: a  reason: collision with other field name */
        public DialogInterface.OnDismissListener f864a;

        /* renamed from: a  reason: collision with other field name */
        public DialogInterface.OnKeyListener f865a;

        /* renamed from: a  reason: collision with other field name */
        public DialogInterface.OnMultiChoiceClickListener f866a;

        /* renamed from: a  reason: collision with other field name */
        public Cursor f867a;

        /* renamed from: a  reason: collision with other field name */
        public Drawable f868a;

        /* renamed from: a  reason: collision with other field name */
        public final LayoutInflater f869a;

        /* renamed from: a  reason: collision with other field name */
        public View f870a;

        /* renamed from: a  reason: collision with other field name */
        public AdapterView.OnItemSelectedListener f871a;

        /* renamed from: a  reason: collision with other field name */
        public ListAdapter f872a;

        /* renamed from: a  reason: collision with other field name */
        public CharSequence f873a;

        /* renamed from: a  reason: collision with other field name */
        public String f874a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f875a;

        /* renamed from: a  reason: collision with other field name */
        public CharSequence[] f876a;

        /* renamed from: a  reason: collision with other field name */
        public boolean[] f877a;
        public int b;

        /* renamed from: b  reason: collision with other field name */
        public DialogInterface.OnClickListener f878b;

        /* renamed from: b  reason: collision with other field name */
        public Drawable f879b;

        /* renamed from: b  reason: collision with other field name */
        public View f880b;

        /* renamed from: b  reason: collision with other field name */
        public CharSequence f881b;

        /* renamed from: b  reason: collision with other field name */
        public String f882b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f883b = false;
        public int c;

        /* renamed from: c  reason: collision with other field name */
        public DialogInterface.OnClickListener f884c;

        /* renamed from: c  reason: collision with other field name */
        public Drawable f885c;

        /* renamed from: c  reason: collision with other field name */
        public CharSequence f886c;

        /* renamed from: c  reason: collision with other field name */
        public boolean f887c;
        public int d;

        /* renamed from: d  reason: collision with other field name */
        public DialogInterface.OnClickListener f888d;

        /* renamed from: d  reason: collision with other field name */
        public Drawable f889d;

        /* renamed from: d  reason: collision with other field name */
        public CharSequence f890d;

        /* renamed from: d  reason: collision with other field name */
        public boolean f891d;
        public int e;

        /* renamed from: e  reason: collision with other field name */
        public CharSequence f892e;
        public int f;
        public int g = -1;

        public AlertParams(ContextThemeWrapper contextThemeWrapper) {
            this.f861a = contextThemeWrapper;
            this.f875a = true;
            this.f869a = (LayoutInflater) contextThemeWrapper.getSystemService("layout_inflater");
        }
    }

    public static class RecycleListView extends ListView {
        public final int c;
        public final int d;

        public RecycleListView(Context context) {
            this(context, (AttributeSet) null);
        }

        public void setHasDecor(boolean z, boolean z2) {
            int i;
            int i2;
            if (!z2 || !z) {
                int paddingLeft = getPaddingLeft();
                if (z) {
                    i = getPaddingTop();
                } else {
                    i = this.c;
                }
                int paddingRight = getPaddingRight();
                if (z2) {
                    i2 = getPaddingBottom();
                } else {
                    i2 = this.d;
                }
                setPadding(paddingLeft, i, paddingRight, i2);
            }
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ps.RecycleListView);
            this.d = obtainStyledAttributes.getDimensionPixelOffset(ps.RecycleListView_paddingBottomNoButtons, -1);
            this.c = obtainStyledAttributes.getDimensionPixelOffset(ps.RecycleListView_paddingTopNoTitle, -1);
        }
    }

    public class a implements View.OnClickListener {
        public a() {
        }

        public final void onClick(View view) {
            Message message;
            Message message2;
            Message message3;
            Message message4;
            AlertController alertController = AlertController.this;
            if (view == alertController.f836a && (message4 = alertController.f833a) != null) {
                message = Message.obtain(message4);
            } else if (view == alertController.f850b && (message3 = alertController.f848b) != null) {
                message = Message.obtain(message3);
            } else if (view != alertController.f856c || (message2 = alertController.f855c) == null) {
                message = null;
            } else {
                message = Message.obtain(message2);
            }
            if (message != null) {
                message.sendToTarget();
            }
            alertController.f842a.obtainMessage(1, alertController.f843a).sendToTarget();
        }
    }

    public static final class b extends Handler {
        public final WeakReference<DialogInterface> a;

        public b(DialogInterface dialogInterface) {
            this.a = new WeakReference<>(dialogInterface);
        }

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == -3 || i == -2 || i == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.a.get(), message.what);
            } else if (i == 1) {
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    public static class c extends ArrayAdapter<CharSequence> {
        public c(Context context, int i, CharSequence[] charSequenceArr) {
            super(context, i, 16908308, charSequenceArr);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, f fVar, Window window) {
        this.f831a = context;
        this.f843a = fVar;
        this.f835a = window;
        this.f842a = new b(fVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, ps.AlertDialog, C0220hr.alertDialogStyle, 0);
        this.i = obtainStyledAttributes.getResourceId(ps.AlertDialog_android_layout, 0);
        obtainStyledAttributes.getResourceId(ps.AlertDialog_buttonPanelSideLayout, 0);
        this.j = obtainStyledAttributes.getResourceId(ps.AlertDialog_listLayout, 0);
        this.k = obtainStyledAttributes.getResourceId(ps.AlertDialog_multiChoiceItemLayout, 0);
        this.l = obtainStyledAttributes.getResourceId(ps.AlertDialog_singleChoiceItemLayout, 0);
        this.m = obtainStyledAttributes.getResourceId(ps.AlertDialog_listItemLayout, 0);
        this.f853b = obtainStyledAttributes.getBoolean(ps.AlertDialog_showTitle, true);
        this.a = obtainStyledAttributes.getDimensionPixelSize(ps.AlertDialog_buttonIconDimen, 0);
        obtainStyledAttributes.recycle();
        fVar.supportRequestWindowFeature(1);
    }

    public static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public static void b(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    public static ViewGroup c(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    public final void d(int i2, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Drawable drawable) {
        Message message;
        if (onClickListener != null) {
            message = this.f842a.obtainMessage(i2, onClickListener);
        } else {
            message = null;
        }
        if (i2 == -3) {
            this.f860e = charSequence;
            this.f855c = message;
            this.f854c = drawable;
        } else if (i2 == -2) {
            this.f859d = charSequence;
            this.f848b = message;
            this.f847b = drawable;
        } else if (i2 == -1) {
            this.f857c = charSequence;
            this.f833a = message;
            this.f832a = drawable;
        } else {
            throw new IllegalArgumentException("Button does not exist");
        }
    }
}
