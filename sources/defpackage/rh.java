package defpackage;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: rh  reason: default package */
/* compiled from: KeyFrames */
public final class rh {
    public static final HashMap<String, Constructor<? extends C0260lh>> b;
    public final HashMap<Integer, ArrayList<C0260lh>> a = new HashMap<>();

    static {
        HashMap<String, Constructor<? extends C0260lh>> hashMap = new HashMap<>();
        b = hashMap;
        try {
            hashMap.put("KeyAttribute", mh.class.getConstructor(new Class[0]));
            hashMap.put("KeyPosition", C0395xh.class.getConstructor(new Class[0]));
            hashMap.put("KeyCycle", oh.class.getConstructor(new Class[0]));
            hashMap.put("KeyTimeCycle", C0426zh.class.getConstructor(new Class[0]));
            hashMap.put("KeyTrigger", Ah.class.getConstructor(new Class[0]));
        } catch (NoSuchMethodException unused) {
        }
    }

    public rh() {
    }

    public final void a(Vl vl) {
        boolean z;
        Integer valueOf = Integer.valueOf(vl.f601a);
        HashMap<Integer, ArrayList<C0260lh>> hashMap = this.a;
        ArrayList arrayList = hashMap.get(valueOf);
        if (arrayList != null) {
            vl.f621b.addAll(arrayList);
        }
        ArrayList arrayList2 = hashMap.get(-1);
        if (arrayList2 != null) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                C0260lh lhVar = (C0260lh) it.next();
                String str = ((ConstraintLayout.LayoutParams) vl.f606a.getLayoutParams()).f1631b;
                String str2 = lhVar.f3092a;
                if (str2 == null || str == null) {
                    z = false;
                } else {
                    z = str.matches(str2);
                }
                if (z) {
                    vl.a(lhVar);
                }
            }
        }
    }

    public final void b(C0260lh lhVar) {
        Integer valueOf = Integer.valueOf(lhVar.b);
        HashMap<Integer, ArrayList<C0260lh>> hashMap = this.a;
        if (!hashMap.containsKey(valueOf)) {
            hashMap.put(Integer.valueOf(lhVar.b), new ArrayList());
        }
        ArrayList arrayList = hashMap.get(Integer.valueOf(lhVar.b));
        if (arrayList != null) {
            arrayList.add(lhVar);
        }
    }

    public rh(Context context, XmlResourceParser xmlResourceParser) {
        HashMap<String, O6> hashMap;
        HashMap<String, O6> hashMap2;
        try {
            int eventType = xmlResourceParser.getEventType();
            C0260lh lhVar = null;
            while (eventType != 1) {
                if (eventType == 2) {
                    String name = xmlResourceParser.getName();
                    HashMap<String, Constructor<? extends C0260lh>> hashMap3 = b;
                    if (hashMap3.containsKey(name)) {
                        try {
                            Constructor constructor = hashMap3.get(name);
                            if (constructor != null) {
                                C0260lh lhVar2 = (C0260lh) constructor.newInstance(new Object[0]);
                                try {
                                    lhVar2.e(context, Xml.asAttributeSet(xmlResourceParser));
                                    b(lhVar2);
                                } catch (Exception unused) {
                                }
                                lhVar = lhVar2;
                            } else {
                                throw new NullPointerException("Keymaker for " + name + " not found");
                            }
                        } catch (Exception unused2) {
                            continue;
                        }
                    } else if (name.equalsIgnoreCase("CustomAttribute")) {
                        if (!(lhVar == null || (hashMap2 = lhVar.f3093a) == null)) {
                            O6.d(context, xmlResourceParser, hashMap2);
                        }
                    } else if (!(!name.equalsIgnoreCase("CustomMethod") || lhVar == null || (hashMap = lhVar.f3093a) == null)) {
                        O6.d(context, xmlResourceParser, hashMap);
                    }
                } else if (eventType == 3) {
                    if ("KeyFrameSet".equals(xmlResourceParser.getName())) {
                        return;
                    }
                }
                eventType = xmlResourceParser.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
