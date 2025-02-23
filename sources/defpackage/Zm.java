package defpackage;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.app.RemoteInput;
import android.content.Context;
import android.content.LocusId;
import android.graphics.PorterDuff;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.RemoteViews;
import androidx.collection.ArraySet;
import androidx.core.app.NotificationCompat$Builder;
import androidx.core.app.a;
import androidx.core.graphics.drawable.IconCompat;
import com.google.firebase.messaging.Constants;
import defpackage.C0370vp;
import defpackage.d7;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: Zm  reason: default package */
/* compiled from: NotificationCompatBuilder */
public final class Zm {
    public final Notification.Builder a;

    /* renamed from: a  reason: collision with other field name */
    public final Context f765a;

    /* renamed from: a  reason: collision with other field name */
    public final Bundle f766a;

    /* renamed from: a  reason: collision with other field name */
    public final NotificationCompat$Builder f767a;

    /* renamed from: Zm$a */
    /* compiled from: NotificationCompatBuilder */
    public static class a {
        public static Notification.Builder a(Notification.Builder builder, Notification.Action action) {
            return builder.addAction(action);
        }

        public static Notification.Action.Builder b(Notification.Action.Builder builder, Bundle bundle) {
            return builder.addExtras(bundle);
        }

        public static Notification.Action.Builder c(Notification.Action.Builder builder, RemoteInput remoteInput) {
            return builder.addRemoteInput(remoteInput);
        }

        public static Notification.Action d(Notification.Action.Builder builder) {
            return builder.build();
        }

        public static Notification.Action.Builder e(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(i, charSequence, pendingIntent);
        }

        public static String f(Notification notification) {
            return notification.getGroup();
        }

        public static Notification.Builder g(Notification.Builder builder, String str) {
            return builder.setGroup(str);
        }

        public static Notification.Builder h(Notification.Builder builder, boolean z) {
            return builder.setGroupSummary(z);
        }

        public static Notification.Builder i(Notification.Builder builder, boolean z) {
            return builder.setLocalOnly(z);
        }

        public static Notification.Builder j(Notification.Builder builder, String str) {
            return builder.setSortKey(str);
        }
    }

    /* renamed from: Zm$b */
    /* compiled from: NotificationCompatBuilder */
    public static class b {
        public static Notification.Builder a(Notification.Builder builder, String str) {
            return builder.addPerson(str);
        }

        public static Notification.Builder b(Notification.Builder builder, String str) {
            return builder.setCategory(str);
        }

        public static Notification.Builder c(Notification.Builder builder, int i) {
            return builder.setColor(i);
        }

        public static Notification.Builder d(Notification.Builder builder, Notification notification) {
            return builder.setPublicVersion(notification);
        }

        public static Notification.Builder e(Notification.Builder builder, Uri uri, Object obj) {
            return builder.setSound(uri, (AudioAttributes) obj);
        }

        public static Notification.Builder f(Notification.Builder builder, int i) {
            return builder.setVisibility(i);
        }
    }

    /* renamed from: Zm$c */
    /* compiled from: NotificationCompatBuilder */
    public static class c {
        public static Notification.Action.Builder a(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(icon, charSequence, pendingIntent);
        }

        public static Notification.Builder b(Notification.Builder builder, Icon icon) {
            return builder.setLargeIcon(icon);
        }

        public static Notification.Builder c(Notification.Builder builder, Object obj) {
            return builder.setSmallIcon((Icon) obj);
        }
    }

    /* renamed from: Zm$d */
    /* compiled from: NotificationCompatBuilder */
    public static class d {
        public static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z) {
            return builder.setAllowGeneratedReplies(z);
        }

        public static Notification.Builder b(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomBigContentView(remoteViews);
        }

        public static Notification.Builder c(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomContentView(remoteViews);
        }

        public static Notification.Builder d(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomHeadsUpContentView(remoteViews);
        }

        public static Notification.Builder e(Notification.Builder builder, CharSequence[] charSequenceArr) {
            return builder.setRemoteInputHistory(charSequenceArr);
        }
    }

    /* renamed from: Zm$e */
    /* compiled from: NotificationCompatBuilder */
    public static class e {
        public static Notification.Builder a(Context context, String str) {
            return new Notification.Builder(context, str);
        }

        public static Notification.Builder b(Notification.Builder builder, int i) {
            return builder.setBadgeIconType(i);
        }

        public static Notification.Builder c(Notification.Builder builder, boolean z) {
            return builder.setColorized(z);
        }

        public static Notification.Builder d(Notification.Builder builder, int i) {
            return builder.setGroupAlertBehavior(i);
        }

        public static Notification.Builder e(Notification.Builder builder, CharSequence charSequence) {
            return builder.setSettingsText(charSequence);
        }

        public static Notification.Builder f(Notification.Builder builder, String str) {
            return builder.setShortcutId(str);
        }

        public static Notification.Builder g(Notification.Builder builder, long j) {
            return builder.setTimeoutAfter(j);
        }
    }

    /* renamed from: Zm$f */
    /* compiled from: NotificationCompatBuilder */
    public static class f {
        public static Notification.Builder a(Notification.Builder builder, Person person) {
            return builder.addPerson(person);
        }

        public static Notification.Action.Builder b(Notification.Action.Builder builder, int i) {
            return builder.setSemanticAction(i);
        }
    }

    /* renamed from: Zm$g */
    /* compiled from: NotificationCompatBuilder */
    public static class g {
        public static Notification.Builder a(Notification.Builder builder, boolean z) {
            return builder.setAllowSystemGeneratedContextualActions(z);
        }

        public static Notification.Builder b(Notification.Builder builder, Notification.BubbleMetadata bubbleMetadata) {
            return builder.setBubbleMetadata(bubbleMetadata);
        }

        public static Notification.Action.Builder c(Notification.Action.Builder builder, boolean z) {
            return builder.setContextual(z);
        }

        public static Notification.Builder d(Notification.Builder builder, Object obj) {
            return builder.setLocusId((LocusId) obj);
        }
    }

    /* renamed from: Zm$h */
    /* compiled from: NotificationCompatBuilder */
    public static class h {
        public static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z) {
            return builder.setAuthenticationRequired(z);
        }

        public static Notification.Builder b(Notification.Builder builder, int i) {
            return builder.setForegroundServiceBehavior(i);
        }
    }

    public Zm(NotificationCompat$Builder notificationCompat$Builder) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Icon icon;
        ArrayList<C0370vp> arrayList;
        Bundle bundle;
        ArrayList<androidx.core.app.a> arrayList2;
        ArrayList<String> arrayList3;
        Zm zm = this;
        NotificationCompat$Builder notificationCompat$Builder2 = notificationCompat$Builder;
        new ArrayList();
        zm.f766a = new Bundle();
        zm.f767a = notificationCompat$Builder2;
        Context context = notificationCompat$Builder2.f1737a;
        zm.f765a = context;
        Notification.Builder a2 = e.a(context, notificationCompat$Builder2.f1747b);
        zm.a = a2;
        Notification notification = notificationCompat$Builder2.f1735a;
        Bundle[] bundleArr = null;
        Notification.Builder lights = a2.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, (RemoteViews) null).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
        int i = 2;
        int i2 = 0;
        if ((notification.flags & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        Notification.Builder ongoing = lights.setOngoing(z);
        if ((notification.flags & 8) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Notification.Builder onlyAlertOnce = ongoing.setOnlyAlertOnce(z2);
        if ((notification.flags & 16) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Notification.Builder deleteIntent = onlyAlertOnce.setAutoCancel(z3).setDefaults(notification.defaults).setContentTitle(notificationCompat$Builder2.f1741a).setContentText(notificationCompat$Builder2.f1746b).setContentInfo((CharSequence) null).setContentIntent(notificationCompat$Builder2.f1736a).setDeleteIntent(notification.deleteIntent);
        if ((notification.flags & 128) != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        deleteIntent.setFullScreenIntent((PendingIntent) null, z4).setNumber(notificationCompat$Builder2.a).setProgress(0, 0, false);
        IconCompat iconCompat = notificationCompat$Builder2.f1740a;
        if (iconCompat == null) {
            icon = null;
        } else {
            icon = IconCompat.a.f(iconCompat, context);
        }
        c.b(a2, icon);
        a2.setSubText(notificationCompat$Builder2.f1750c).setUsesChronometer(false).setPriority(notificationCompat$Builder2.b);
        Ym ym = notificationCompat$Builder2.f1734a;
        if (ym instanceof androidx.core.app.b) {
            androidx.core.app.b bVar = (androidx.core.app.b) ym;
            int i3 = C0383wr.ic_call_decline;
            int i4 = Xr.call_notification_hang_up_action;
            int i5 = C0263lr.call_notification_decline_color;
            Context context2 = bVar.a.f1737a;
            Object obj = d7.a;
            Integer valueOf = Integer.valueOf(d7.b.a(context2, i5));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append(bVar.a.f1737a.getResources().getString(i4));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(valueOf.intValue()), 0, spannableStringBuilder.length(), 18);
            Context context3 = bVar.a.f1737a;
            PorterDuff.Mode mode = IconCompat.b;
            context3.getClass();
            androidx.core.app.a a3 = new a.C0009a(IconCompat.b(context3.getResources(), context3.getPackageName(), i3), spannableStringBuilder, (PendingIntent) null, new Bundle()).a();
            a3.f1760a.putBoolean("key_action_priority", true);
            ArrayList arrayList4 = new ArrayList(3);
            arrayList4.add(a3);
            ArrayList<androidx.core.app.a> arrayList5 = bVar.a.f1743a;
            if (arrayList5 != null) {
                Iterator<androidx.core.app.a> it = arrayList5.iterator();
                while (it.hasNext()) {
                    androidx.core.app.a next = it.next();
                    if (next.c) {
                        arrayList4.add(next);
                    } else if (!next.f1760a.getBoolean("key_action_priority") && i > 1) {
                        arrayList4.add(next);
                        i--;
                    }
                }
            }
            Iterator it2 = arrayList4.iterator();
            while (it2.hasNext()) {
                zm.a((androidx.core.app.a) it2.next());
            }
        } else {
            Iterator<androidx.core.app.a> it3 = notificationCompat$Builder2.f1743a.iterator();
            while (it3.hasNext()) {
                zm.a(it3.next());
            }
        }
        Bundle bundle2 = notificationCompat$Builder2.f1738a;
        if (bundle2 != null) {
            zm.f766a.putAll(bundle2);
        }
        int i6 = Build.VERSION.SDK_INT;
        zm.a.setShowWhen(notificationCompat$Builder2.f1744a);
        a.i(zm.a, notificationCompat$Builder2.f1752c);
        a.g(zm.a, notificationCompat$Builder2.f1742a);
        a.j(zm.a, (String) null);
        a.h(zm.a, notificationCompat$Builder2.f1749b);
        b.b(zm.a, (String) null);
        b.c(zm.a, notificationCompat$Builder2.c);
        b.f(zm.a, notificationCompat$Builder2.d);
        b.d(zm.a, (Notification) null);
        b.e(zm.a, notification.sound, notification.audioAttributes);
        ArrayList<C0370vp> arrayList6 = notificationCompat$Builder2.f1748b;
        ArrayList<String> arrayList7 = notificationCompat$Builder2.f1753d;
        if (i6 < 28) {
            if (arrayList6 == null) {
                arrayList3 = null;
            } else {
                arrayList3 = new ArrayList<>(arrayList6.size());
                Iterator<C0370vp> it4 = arrayList6.iterator();
                while (it4.hasNext()) {
                    C0370vp next2 = it4.next();
                    String str = next2.f3375a;
                    if (str == null) {
                        CharSequence charSequence = next2.f3374a;
                        if (charSequence != null) {
                            str = "name:" + charSequence;
                        } else {
                            str = "";
                        }
                    }
                    arrayList3.add(str);
                }
            }
            if (arrayList3 != null) {
                if (arrayList7 != null) {
                    ArraySet arraySet = new ArraySet(arrayList7.size() + arrayList3.size());
                    arraySet.addAll(arrayList3);
                    arraySet.addAll(arrayList7);
                    arrayList3 = new ArrayList<>(arraySet);
                }
                arrayList7 = arrayList3;
            }
        }
        if (arrayList7 != null && !arrayList7.isEmpty()) {
            for (String a4 : arrayList7) {
                b.a(zm.a, a4);
            }
        }
        ArrayList<androidx.core.app.a> arrayList8 = notificationCompat$Builder2.f1751c;
        if (arrayList8.size() > 0) {
            if (notificationCompat$Builder2.f1738a == null) {
                notificationCompat$Builder2.f1738a = new Bundle();
            }
            Bundle bundle3 = notificationCompat$Builder2.f1738a.getBundle("android.car.EXTENSIONS");
            bundle3 = bundle3 == null ? new Bundle() : bundle3;
            Bundle bundle4 = new Bundle(bundle3);
            Bundle bundle5 = new Bundle();
            int i7 = 0;
            while (i2 < arrayList8.size()) {
                String num = Integer.toString(i2);
                androidx.core.app.a aVar = arrayList8.get(i2);
                Bundle bundle6 = new Bundle();
                IconCompat a5 = aVar.a();
                bundle6.putInt("icon", a5 != null ? a5.c() : i7);
                bundle6.putCharSequence("title", aVar.f1762a);
                bundle6.putParcelable("actionIntent", aVar.f1759a);
                Bundle bundle7 = aVar.f1760a;
                if (bundle7 != null) {
                    bundle = new Bundle(bundle7);
                } else {
                    bundle = new Bundle();
                }
                bundle.putBoolean("android.support.allowGeneratedReplies", aVar.f1763a);
                bundle6.putBundle("extras", bundle);
                pt[] ptVarArr = aVar.f1764a;
                if (ptVarArr == null) {
                    arrayList2 = arrayList8;
                } else {
                    bundleArr = new Bundle[ptVarArr.length];
                    int i8 = 0;
                    arrayList2 = arrayList8;
                    while (i8 < ptVarArr.length) {
                        pt ptVar = ptVarArr[i8];
                        pt[] ptVarArr2 = ptVarArr;
                        Bundle bundle8 = new Bundle();
                        ptVar.getClass();
                        bundle8.putString("resultKey", (String) null);
                        bundle8.putCharSequence(Constants.ScionAnalytics.PARAM_LABEL, (CharSequence) null);
                        bundle8.putCharSequenceArray("choices", (CharSequence[]) null);
                        bundle8.putBoolean("allowFreeFormInput", false);
                        bundle8.putBundle("extras", (Bundle) null);
                        bundleArr[i8] = bundle8;
                        i8++;
                        ptVarArr = ptVarArr2;
                        arrayList6 = arrayList6;
                    }
                }
                ArrayList<C0370vp> arrayList9 = arrayList6;
                bundle6.putParcelableArray("remoteInputs", bundleArr);
                bundle6.putBoolean("showsUserInterface", aVar.f1765b);
                bundle6.putInt("semanticAction", aVar.a);
                bundle5.putBundle(num, bundle6);
                i2++;
                bundleArr = null;
                i7 = 0;
                arrayList8 = arrayList2;
                arrayList6 = arrayList9;
            }
            arrayList = arrayList6;
            bundle3.putBundle("invisible_actions", bundle5);
            bundle4.putBundle("invisible_actions", bundle5);
            if (notificationCompat$Builder2.f1738a == null) {
                notificationCompat$Builder2.f1738a = new Bundle();
            }
            notificationCompat$Builder2.f1738a.putBundle("android.car.EXTENSIONS", bundle3);
            zm = this;
            zm.f766a.putBundle("android.car.EXTENSIONS", bundle4);
        } else {
            arrayList = arrayList6;
        }
        int i9 = Build.VERSION.SDK_INT;
        zm.a.setExtras(notificationCompat$Builder2.f1738a);
        d.e(zm.a, (CharSequence[]) null);
        RemoteViews remoteViews = notificationCompat$Builder2.f1739a;
        if (remoteViews != null) {
            d.c(zm.a, remoteViews);
        }
        RemoteViews remoteViews2 = notificationCompat$Builder2.f1745b;
        if (remoteViews2 != null) {
            d.b(zm.a, remoteViews2);
        }
        e.b(zm.a, 0);
        e.e(zm.a, (CharSequence) null);
        e.f(zm.a, (String) null);
        e.g(zm.a, notificationCompat$Builder2.f1733a);
        e.d(zm.a, 0);
        if (!TextUtils.isEmpty(notificationCompat$Builder2.f1747b)) {
            zm.a.setSound((Uri) null).setDefaults(0).setLights(0, 0, 0).setVibrate((long[]) null);
        }
        if (i9 >= 28) {
            Iterator<C0370vp> it5 = arrayList.iterator();
            while (it5.hasNext()) {
                C0370vp next3 = it5.next();
                Notification.Builder builder = zm.a;
                next3.getClass();
                f.a(builder, C0370vp.a.b(next3));
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            g.a(zm.a, notificationCompat$Builder2.f1754d);
            g.b(zm.a, (Notification.BubbleMetadata) null);
        }
    }

    public final void a(androidx.core.app.a aVar) {
        Icon icon;
        Bundle bundle;
        IconCompat a2 = aVar.a();
        RemoteInput[] remoteInputArr = null;
        if (a2 != null) {
            icon = IconCompat.a.f(a2, (Context) null);
        } else {
            icon = null;
        }
        Notification.Action.Builder a3 = c.a(icon, aVar.f1762a, aVar.f1759a);
        pt[] ptVarArr = aVar.f1764a;
        if (ptVarArr != null) {
            if (ptVarArr != null) {
                remoteInputArr = new RemoteInput[ptVarArr.length];
                for (int i = 0; i < ptVarArr.length; i++) {
                    remoteInputArr[i] = pt.a(ptVarArr[i]);
                }
            }
            for (RemoteInput c2 : remoteInputArr) {
                a.c(a3, c2);
            }
        }
        Bundle bundle2 = aVar.f1760a;
        if (bundle2 != null) {
            bundle = new Bundle(bundle2);
        } else {
            bundle = new Bundle();
        }
        boolean z = aVar.f1763a;
        bundle.putBoolean("android.support.allowGeneratedReplies", z);
        int i2 = Build.VERSION.SDK_INT;
        d.a(a3, z);
        int i3 = aVar.a;
        bundle.putInt("android.support.action.semanticAction", i3);
        if (i2 >= 28) {
            f.b(a3, i3);
        }
        if (i2 >= 29) {
            g.c(a3, aVar.c);
        }
        if (i2 >= 31) {
            h.a(a3, aVar.d);
        }
        bundle.putBoolean("android.support.action.showsUserInterface", aVar.f1765b);
        a.b(a3, bundle);
        a.a(this.a, a.d(a3));
    }
}
