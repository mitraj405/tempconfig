package com.facebook.ads.internal.dynamicloading;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Keep;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeBannerAd;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.RewardedVideoAdListener;
import com.facebook.ads.internal.api.AdViewApi;
import com.facebook.ads.internal.api.AdViewParentApi;
import com.facebook.ads.internal.api.InterstitialAdApi;
import com.facebook.ads.internal.api.NativeAdBaseApi;
import com.facebook.ads.internal.api.RewardedVideoAdApi;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

@Keep
class DynamicLoaderFallback {
    /* access modifiers changed from: private */
    public static final WeakHashMap<Object, AdListener> sApiProxyToAdListenersMap = new WeakHashMap<>();

    public class a implements InvocationHandler {
        public final /* synthetic */ Method a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ List f2792a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ Map f2793a;
        public final /* synthetic */ Method b;

        /* renamed from: b  reason: collision with other field name */
        public final /* synthetic */ List f2794b;

        /* renamed from: b  reason: collision with other field name */
        public final /* synthetic */ Map f2795b;
        public final /* synthetic */ List c;
        public final /* synthetic */ List d;
        public final /* synthetic */ List e;

        public a(ArrayList arrayList, HashMap hashMap, ArrayList arrayList2, ArrayList arrayList3, HashMap hashMap2, ArrayList arrayList4, ArrayList arrayList5, Method method, Method method2) {
            this.f2792a = arrayList;
            this.f2793a = hashMap;
            this.f2794b = arrayList2;
            this.c = arrayList3;
            this.f2795b = hashMap2;
            this.d = arrayList4;
            this.e = arrayList5;
            this.a = method;
            this.b = method2;
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) {
            Object obj2;
            Map map;
            boolean isPrimitive = method.getReturnType().isPrimitive();
            Map map2 = this.f2793a;
            if (isPrimitive) {
                if (!method.getReturnType().equals(Void.TYPE)) {
                    return Array.get(Array.newInstance(method.getReturnType(), 1), 0);
                }
                Iterator it = this.f2792a.iterator();
                while (it.hasNext() && (!DynamicLoaderFallback.equalsMethods(method, (Method) it.next()) || !DynamicLoaderFallback.reportError(obj, map2))) {
                }
                for (Method access$100 : this.f2794b) {
                    if (DynamicLoaderFallback.equalsMethods(method, access$100) && DynamicLoaderFallback.reportError(obj, map2)) {
                        return null;
                    }
                }
                return null;
            } else if (method.getReturnType().equals(String.class)) {
                return "";
            } else {
                if (method.getReturnType().equals(obj.getClass().getInterfaces()[0])) {
                    obj2 = obj;
                } else {
                    obj2 = Proxy.newProxyInstance(DynamicLoaderFallback.class.getClassLoader(), new Class[]{method.getReturnType()}, this);
                }
                Iterator it2 = this.c.iterator();
                while (true) {
                    boolean hasNext = it2.hasNext();
                    map = this.f2795b;
                    if (hasNext) {
                        if (DynamicLoaderFallback.equalsMethods(method, (Method) it2.next())) {
                            DynamicLoaderFallback.sApiProxyToAdListenersMap.put(map.get(obj), objArr[0]);
                            break;
                        }
                    } else {
                        break;
                    }
                }
                for (Method access$1002 : this.d) {
                    if (DynamicLoaderFallback.equalsMethods(method, access$1002)) {
                        map.put(obj2, obj);
                    }
                }
                for (Method access$1003 : this.e) {
                    if (DynamicLoaderFallback.equalsMethods(method, access$1003)) {
                        for (Ad ad : objArr) {
                            if (ad instanceof Ad) {
                                map2.put(obj2, ad);
                            }
                        }
                    }
                }
                if (DynamicLoaderFallback.equalsMethods(method, this.a)) {
                    map2.put(objArr[1], objArr[0]);
                }
                if (DynamicLoaderFallback.equalsMethods(method, this.b)) {
                    map2.put(objArr[1], objArr[0]);
                }
                return obj2;
            }
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ Ad a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ AdListener f2796a;

        public b(AdListener adListener, Ad ad) {
            this.f2796a = adListener;
            this.a = ad;
        }

        public final void run() {
            this.f2796a.onError(this.a, new AdError(-1, "Can't load Audience Network Dex. Please, check that audience_network.dex is inside of assets folder."));
        }
    }

    public static class c {
        public final a a = new a();

        /* renamed from: a  reason: collision with other field name */
        public Method f2797a;

        public class a implements InvocationHandler {
            public a() {
            }

            public final Object invoke(Object obj, Method method, Object[] objArr) {
                if ("toString".equals(method.getName())) {
                    return null;
                }
                c.this.f2797a = method;
                return null;
            }
        }

        public final <T> T a(Class<T> cls) {
            return cls.cast(Proxy.newProxyInstance(DynamicLoaderFallback.class.getClassLoader(), new Class[]{cls}, this.a));
        }
    }

    private static boolean equalsMethodParams(Method method, Method method2) {
        return Arrays.equals(method.getParameterTypes(), method2.getParameterTypes());
    }

    /* access modifiers changed from: private */
    public static boolean equalsMethods(Method method, Method method2) {
        if (method == null || method2 == null || !method.getDeclaringClass().equals(method2.getDeclaringClass()) || !method.getName().equals(method2.getName()) || !equalsMethodParams(method, method2)) {
            return false;
        }
        return true;
    }

    @SuppressLint({"Parameter Not Nullable", "CatchGeneralException"})
    public static DynamicLoader makeFallbackLoader() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        c cVar = new c();
        Class cls = DynamicLoader.class;
        DynamicLoader dynamicLoader = (DynamicLoader) cVar.a(cls);
        dynamicLoader.createInterstitialAd((Context) null, (String) null, (InterstitialAd) null);
        arrayList5.add(cVar.f2797a);
        dynamicLoader.createRewardedVideoAd((Context) null, (String) null, (RewardedVideoAd) null);
        arrayList5.add(cVar.f2797a);
        dynamicLoader.createAdViewApi((Context) null, (String) null, (AdSize) null, (AdViewParentApi) null, (AdView) null);
        arrayList5.add(cVar.f2797a);
        try {
            dynamicLoader.createAdViewApi((Context) null, (String) null, (String) null, (AdViewParentApi) null, (AdView) null);
        } catch (Exception unused) {
        }
        arrayList5.add(cVar.f2797a);
        dynamicLoader.createNativeAdApi((NativeAd) null, (NativeAdBaseApi) null);
        Method method = cVar.f2797a;
        dynamicLoader.createNativeBannerAdApi((NativeBannerAd) null, (NativeAdBaseApi) null);
        Method method2 = cVar.f2797a;
        NativeAdBaseApi nativeAdBaseApi = (NativeAdBaseApi) cVar.a(NativeAdBaseApi.class);
        nativeAdBaseApi.loadAd();
        arrayList.add(cVar.f2797a);
        nativeAdBaseApi.loadAd((NativeAdBase.NativeLoadAdConfig) null);
        arrayList2.add(cVar.f2797a);
        nativeAdBaseApi.buildLoadAdConfig((NativeAdBase) null);
        arrayList4.add(cVar.f2797a);
        InterstitialAdApi interstitialAdApi = (InterstitialAdApi) cVar.a(InterstitialAdApi.class);
        interstitialAdApi.loadAd();
        arrayList.add(cVar.f2797a);
        interstitialAdApi.loadAd((InterstitialAd.InterstitialLoadAdConfig) null);
        arrayList2.add(cVar.f2797a);
        interstitialAdApi.buildLoadAdConfig();
        arrayList4.add(cVar.f2797a);
        RewardedVideoAdApi rewardedVideoAdApi = (RewardedVideoAdApi) cVar.a(RewardedVideoAdApi.class);
        rewardedVideoAdApi.loadAd();
        arrayList.add(cVar.f2797a);
        rewardedVideoAdApi.loadAd((RewardedVideoAd.RewardedVideoLoadAdConfig) null);
        arrayList2.add(cVar.f2797a);
        rewardedVideoAdApi.buildLoadAdConfig();
        arrayList4.add(cVar.f2797a);
        AdViewApi adViewApi = (AdViewApi) cVar.a(AdViewApi.class);
        adViewApi.loadAd();
        arrayList.add(cVar.f2797a);
        adViewApi.loadAd((AdView.AdViewLoadConfig) null);
        arrayList2.add(cVar.f2797a);
        adViewApi.buildLoadAdConfig();
        arrayList4.add(cVar.f2797a);
        ((AdView.AdViewLoadConfigBuilder) cVar.a(AdView.AdViewLoadConfigBuilder.class)).withAdListener((AdListener) null);
        arrayList3.add(cVar.f2797a);
        ((NativeAdBase.NativeAdLoadConfigBuilder) cVar.a(NativeAdBase.NativeAdLoadConfigBuilder.class)).withAdListener((NativeAdListener) null);
        arrayList3.add(cVar.f2797a);
        ((InterstitialAd.InterstitialAdLoadConfigBuilder) cVar.a(InterstitialAd.InterstitialAdLoadConfigBuilder.class)).withAdListener((InterstitialAdListener) null);
        arrayList3.add(cVar.f2797a);
        ((RewardedVideoAd.RewardedVideoAdLoadConfigBuilder) cVar.a(RewardedVideoAd.RewardedVideoAdLoadConfigBuilder.class)).withAdListener((RewardedVideoAdListener) null);
        arrayList3.add(cVar.f2797a);
        a aVar = new a(arrayList, hashMap, arrayList2, arrayList3, hashMap2, arrayList4, arrayList5, method, method2);
        return (DynamicLoader) Proxy.newProxyInstance(DynamicLoaderFallback.class.getClassLoader(), new Class[]{cls}, aVar);
    }

    /* access modifiers changed from: private */
    public static boolean reportError(Object obj, Map<Object, Ad> map) {
        if (obj == null) {
            return false;
        }
        AdListener adListener = sApiProxyToAdListenersMap.get(obj);
        Ad ad = map.get(obj);
        if (adListener == null) {
            return false;
        }
        new Handler(Looper.getMainLooper()).postDelayed(new b(adListener, ad), 500);
        return true;
    }
}
