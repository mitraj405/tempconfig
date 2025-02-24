package com.google.ads.mediation.facebook.rtb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.facebook.ads.Ad;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.MediaView;
import com.facebook.ads.MediaViewListener;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeBannerAd;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.ads.mediation.facebook.MetaFactory;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FacebookRtbNativeAd extends UnifiedNativeAdMapper {
    private final MediationNativeAdConfiguration adConfiguration;
    /* access modifiers changed from: private */
    public final MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> callback;
    private MediaView mediaView;
    private final MetaFactory metaFactory;
    private NativeAdBase nativeAdBase;
    /* access modifiers changed from: private */
    public MediationNativeAdCallback nativeAdCallback;

    public class FacebookAdapterNativeAdImage extends NativeAd.Image {
        private Drawable drawable;
        private Uri uri;

        public FacebookAdapterNativeAdImage() {
        }

        public Drawable getDrawable() {
            return this.drawable;
        }

        public double getScale() {
            return 1.0d;
        }

        public Uri getUri() {
            return this.uri;
        }

        public FacebookAdapterNativeAdImage(Uri uri2) {
            this.uri = uri2;
        }

        public FacebookAdapterNativeAdImage(Drawable drawable2) {
            this.drawable = drawable2;
        }
    }

    public interface NativeAdMapperListener {
        void onMappingFailed(AdError adError);

        void onMappingSuccess();
    }

    public FacebookRtbNativeAd(MediationNativeAdConfiguration mediationNativeAdConfiguration, MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> mediationAdLoadCallback, MetaFactory metaFactory2) {
        this.callback = mediationAdLoadCallback;
        this.adConfiguration = mediationNativeAdConfiguration;
        this.metaFactory = metaFactory2;
    }

    private boolean containsRequiredFieldsForUnifiedNativeAd(NativeAdBase nativeAdBase2) {
        boolean z;
        if (nativeAdBase2.getAdHeadline() == null || nativeAdBase2.getAdBodyText() == null || nativeAdBase2.getAdIcon() == null || nativeAdBase2.getAdCallToAction() == null) {
            z = false;
        } else {
            z = true;
        }
        if (nativeAdBase2 instanceof NativeBannerAd) {
            return z;
        }
        if (!z || nativeAdBase2.getAdCoverImage() == null || this.mediaView == null) {
            return false;
        }
        return true;
    }

    public void mapNativeAd(Context context, NativeAdMapperListener nativeAdMapperListener) {
        if (!containsRequiredFieldsForUnifiedNativeAd(this.nativeAdBase)) {
            AdError adError = new AdError(108, "Ad from Meta Audience Network doesn't have all required assets.", "com.google.ads.mediation.facebook");
            String str = FacebookMediationAdapter.TAG;
            adError.getMessage();
            nativeAdMapperListener.onMappingFailed(adError);
            return;
        }
        setHeadline(this.nativeAdBase.getAdHeadline());
        if (this.nativeAdBase.getAdCoverImage() != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new FacebookAdapterNativeAdImage(Uri.parse(this.nativeAdBase.getAdCoverImage().getUrl())));
            setImages(arrayList);
        }
        setBody(this.nativeAdBase.getAdBodyText());
        if (this.nativeAdBase.getPreloadedIconViewDrawable() != null) {
            setIcon(new FacebookAdapterNativeAdImage(this.nativeAdBase.getPreloadedIconViewDrawable()));
        } else if (this.nativeAdBase.getAdIcon() == null) {
            setIcon(new FacebookAdapterNativeAdImage());
        } else {
            setIcon(new FacebookAdapterNativeAdImage(Uri.parse(this.nativeAdBase.getAdIcon().getUrl())));
        }
        setCallToAction(this.nativeAdBase.getAdCallToAction());
        setAdvertiser(this.nativeAdBase.getAdvertiserName());
        this.mediaView.setListener(new MediaViewListener() {
            public void onComplete(MediaView mediaView) {
                if (FacebookRtbNativeAd.this.nativeAdCallback != null) {
                    FacebookRtbNativeAd.this.nativeAdCallback.onVideoComplete();
                }
            }

            public void onEnterFullscreen(MediaView mediaView) {
            }

            public void onExitFullscreen(MediaView mediaView) {
            }

            public void onFullscreenBackground(MediaView mediaView) {
            }

            public void onFullscreenForeground(MediaView mediaView) {
            }

            public void onPause(MediaView mediaView) {
            }

            public void onPlay(MediaView mediaView) {
            }

            public void onVolumeChange(MediaView mediaView, float f) {
            }
        });
        setHasVideoContent(true);
        setMediaView(this.mediaView);
        Bundle bundle = new Bundle();
        bundle.putCharSequence(FacebookMediationAdapter.KEY_ID, this.nativeAdBase.getId());
        bundle.putCharSequence(FacebookMediationAdapter.KEY_SOCIAL_CONTEXT_ASSET, this.nativeAdBase.getAdSocialContext());
        setExtras(bundle);
        setAdChoicesContent(new AdOptionsView(context, this.nativeAdBase, (NativeAdLayout) null));
        nativeAdMapperListener.onMappingSuccess();
    }

    public void render() {
        String placementID = FacebookMediationAdapter.getPlacementID(this.adConfiguration.getServerParameters());
        if (TextUtils.isEmpty(placementID)) {
            AdError adError = new AdError(101, "Failed to request ad. PlacementID is null or empty.", "com.google.ads.mediation.facebook");
            adError.getMessage();
            this.callback.onFailure(adError);
            return;
        }
        FacebookMediationAdapter.setMixedAudience(this.adConfiguration);
        this.mediaView = this.metaFactory.createMediaView(this.adConfiguration.getContext());
        try {
            this.nativeAdBase = NativeAdBase.fromBidPayload(this.adConfiguration.getContext(), placementID, this.adConfiguration.getBidResponse());
            if (!TextUtils.isEmpty(this.adConfiguration.getWatermark())) {
                this.nativeAdBase.setExtraHints(new ExtraHints.Builder().mediationData(this.adConfiguration.getWatermark()).build());
            }
            NativeAdBase nativeAdBase2 = this.nativeAdBase;
            nativeAdBase2.loadAd(nativeAdBase2.buildLoadAdConfig().withAdListener(new NativeListener(this.adConfiguration.getContext(), this.nativeAdBase)).withBid(this.adConfiguration.getBidResponse()).withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL).withPreloadedIconView(-1, -1).build());
        } catch (Exception e) {
            AdError adError2 = new AdError(109, C1058d.M(e, new StringBuilder("Failed to create native ad from bid payload: ")), "com.google.ads.mediation.facebook");
            adError2.getMessage();
            this.callback.onFailure(adError2);
        }
    }

    public void trackViews(View view, Map<String, View> map, Map<String, View> map2) {
        setOverrideClickHandling(true);
        ArrayList arrayList = new ArrayList(map.values());
        View view2 = map.get("3003");
        NativeAdBase nativeAdBase2 = this.nativeAdBase;
        if (nativeAdBase2 instanceof NativeBannerAd) {
            if (view2 == null) {
                String str = FacebookMediationAdapter.TAG;
            } else if (!(view2 instanceof ImageView)) {
                String.format("Native ad icon asset is rendered with an incompatible class type. Meta Audience Network impression recording might be impacted for this ad. Expected: ImageView, actual: %s.", new Object[]{view2.getClass()});
                String str2 = FacebookMediationAdapter.TAG;
            } else {
                ((NativeBannerAd) nativeAdBase2).registerViewForInteraction(view, (ImageView) view2, (List<View>) arrayList);
            }
        } else if (nativeAdBase2 instanceof com.facebook.ads.NativeAd) {
            com.facebook.ads.NativeAd nativeAd = (com.facebook.ads.NativeAd) nativeAdBase2;
            if (view2 instanceof ImageView) {
                nativeAd.registerViewForInteraction(view, this.mediaView, (ImageView) view2, (List<View>) arrayList);
                return;
            }
            String str3 = FacebookMediationAdapter.TAG;
            nativeAd.registerViewForInteraction(view, this.mediaView, (List<View>) arrayList);
        } else {
            String str4 = FacebookMediationAdapter.TAG;
        }
    }

    public void untrackView(View view) {
        NativeAdBase nativeAdBase2 = this.nativeAdBase;
        if (nativeAdBase2 != null) {
            nativeAdBase2.unregisterView();
        }
        super.untrackView(view);
    }

    public class NativeListener implements AdListener, NativeAdListener {
        private final WeakReference<Context> context;
        private final NativeAdBase nativeAd;

        public NativeListener(Context context2, NativeAdBase nativeAdBase) {
            this.nativeAd = nativeAdBase;
            this.context = new WeakReference<>(context2);
        }

        public void onAdClicked(Ad ad) {
            FacebookRtbNativeAd.this.nativeAdCallback.reportAdClicked();
            FacebookRtbNativeAd.this.nativeAdCallback.onAdOpened();
            FacebookRtbNativeAd.this.nativeAdCallback.onAdLeftApplication();
        }

        public void onAdLoaded(Ad ad) {
            if (ad != this.nativeAd) {
                AdError adError = new AdError(106, "Ad Loaded is not a Native Ad.", "com.google.ads.mediation.facebook");
                adError.getMessage();
                FacebookRtbNativeAd.this.callback.onFailure(adError);
                return;
            }
            Context context2 = this.context.get();
            if (context2 == null) {
                AdError adError2 = new AdError(107, "Context is null.", "com.google.ads.mediation.facebook");
                adError2.getMessage();
                FacebookRtbNativeAd.this.callback.onFailure(adError2);
                return;
            }
            FacebookRtbNativeAd.this.mapNativeAd(context2, new NativeAdMapperListener() {
                public void onMappingFailed(AdError adError) {
                    adError.getMessage();
                    FacebookRtbNativeAd.this.callback.onFailure(adError);
                }

                public void onMappingSuccess() {
                    FacebookRtbNativeAd facebookRtbNativeAd = FacebookRtbNativeAd.this;
                    facebookRtbNativeAd.nativeAdCallback = (MediationNativeAdCallback) facebookRtbNativeAd.callback.onSuccess(FacebookRtbNativeAd.this);
                }
            });
        }

        public void onError(Ad ad, com.facebook.ads.AdError adError) {
            AdError adError2 = FacebookMediationAdapter.getAdError(adError);
            adError2.getMessage();
            FacebookRtbNativeAd.this.callback.onFailure(adError2);
        }

        public void onMediaDownloaded(Ad ad) {
            String str = FacebookMediationAdapter.TAG;
        }

        public void onLoggingImpression(Ad ad) {
        }
    }
}
