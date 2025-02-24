package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.internal.measurement.zzgk;
import com.google.android.gms.internal.measurement.zzgw;
import com.google.common.annotations.VisibleForTesting;
import com.google.logging.type.LogSeverity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
public final class zzbf {
    public static final zzfj<Long> zza = zzb("measurement.ad_id_cache_time", 10000L, new zzbh());
    public static final zzfj<Long> zzaa = zzb("measurement.upload.initial_upload_delay_time", 15000L, new zzce());
    public static final zzfj<Long> zzab = zzb("measurement.upload.retry_time", 1800000L, new zzcd());
    public static final zzfj<Integer> zzac = zzb("measurement.upload.retry_count", 6, new zzcg());
    public static final zzfj<Long> zzad = zzb("measurement.upload.max_queue_time", 2419200000L, new zzci());
    public static final zzfj<Integer> zzae = zzb("measurement.lifetimevalue.max_currency_tracked", 4, new zzch());
    public static final zzfj<Integer> zzaf = zzb("measurement.audience.filter_result_max_count", Integer.valueOf(LogSeverity.INFO_VALUE), new zzcj());
    public static final zzfj<Integer> zzag = zza("measurement.upload.max_public_user_properties", 25);
    public static final zzfj<Integer> zzah = zza("measurement.upload.max_event_name_cardinality", 500);
    public static final zzfj<Integer> zzai = zza("measurement.upload.max_public_event_params", 25);
    public static final zzfj<Long> zzaj = zzb("measurement.service_client.idle_disconnect_millis", 5000L, new zzcm());
    public static final zzfj<Boolean> zzak;
    public static final zzfj<String> zzal = zzb("measurement.test.string_flag", "---", new zzco());
    public static final zzfj<Long> zzam = zzb("measurement.test.long_flag", -1L, new zzcn());
    public static final zzfj<Integer> zzan = zzb("measurement.test.int_flag", -2, new zzcp());
    public static final zzfj<Double> zzao = zzb("measurement.test.double_flag", Double.valueOf(-3.0d), new zzcs());
    public static final zzfj<Integer> zzap = zzb("measurement.experiment.max_ids", 50, new zzcu());
    public static final zzfj<Integer> zzaq = zzb("measurement.upload.max_item_scoped_custom_parameters", 27, new zzcw());
    public static final zzfj<Integer> zzar = zza("measurement.upload.max_event_parameter_value_length", 100, new zzcv());
    public static final zzfj<Integer> zzas = zzb("measurement.max_bundles_per_iteration", 100, new zzcy());
    public static final zzfj<Long> zzat = zzb("measurement.sdk.attribution.cache.ttl", 604800000L, new zzcx());
    public static final zzfj<Long> zzau = zzb("measurement.redaction.app_instance_id.ttl", 7200000L, new zzda());
    public static final zzfj<Integer> zzav = zzb("measurement.rb.attribution.client.min_ad_services_version", 7, new zzcz());
    public static final zzfj<Integer> zzaw = zzb("measurement.dma_consent.max_daily_dcu_realtime_events", 1, new zzdc());
    public static final zzfj<String> zzax = zzb("measurement.rb.attribution.uri_scheme", "https", new zzdb());
    public static final zzfj<String> zzay = zzb("measurement.rb.attribution.uri_authority", "google-analytics.com", new zzde());
    public static final zzfj<String> zzaz = zzb("measurement.rb.attribution.uri_path", "privacy-sandbox/register-app-conversion", new zzdf());
    public static final zzfj<Long> zzb = zzb("measurement.app_uninstalled_additional_ad_id_cache_time", 3600000L, new zzbt());
    public static final zzfj<Long> zzba = zzb("measurement.session.engagement_interval", 3600000L, new zzdi());
    public static final zzfj<String> zzbb = zzb("measurement.rb.attribution.app_allowlist", "com.labpixies.flood,com.sofascore.results,games.spearmint.triplecrush,com.block.juggle,io.supercent.linkedcubic,com.cdtg.gunsound,com.corestudios.storemanagementidle,com.cdgames.fidget3d,io.supercent.burgeridle,io.supercent.pizzaidle,jp.ne.ibis.ibispaintx.app,com.dencreak.dlcalculator,com.ebay.kleinanzeigen,de.wetteronline.wetterapp,com.game.shape.shift,com.champion.cubes,bubbleshooter.orig,com.wolt.android,com.master.hotelmaster,com.games.bus.arrival,com.playstrom.dop2,com.huuuge.casino.slots,com.ig.spider.fighting,com.jura.coloring.page,com.rikkogame.ragdoll2,com.ludo.king,com.sigma.prank.sound.haircut,com.crazy.block.robo.monster.cliffs.craft,com.fugo.wow,com.maps.locator.gps.gpstracker.phone,com.gamovation.tileclub,com.pronetis.ironball2,com.meesho.supply,pdf.pdfreader.viewer.editor.free,com.dino.race.master,com.ig.moto.racing,ai.photo.enhancer.photoclear,com.duolingo,com.candle.magic_piano,com.free.vpn.super.hotspot.open,sg.bigo.live,com.cdg.tictactoe,com.zhiliaoapp.musically.go,com.wildspike.wormszone,com.mast.status.video.edit,com.vyroai.photoeditorone,com.pujiagames.deeeersimulator,com.superbinogo.jungleboyadventure,com.trustedapp.pdfreaderpdfviewer,com.artimind.aiart.artgenerator.artavatar,de.cellular.ottohybrid,com.zeptolab.cats.google,in.crossy.daily_crossword", new zzdh());
    public static final zzfj<String> zzbc = zzb("measurement.rb.attribution.user_properties", "_npa,npa", new zzdk());
    public static final zzfj<String> zzbd = zzb("measurement.rb.attribution.event_params", "value|currency", new zzdj());
    public static final zzfj<String> zzbe = zzb("measurement.rb.attribution.query_parameters_to_remove", "", new zzdm());
    public static final zzfj<Long> zzbf = zzb("measurement.rb.attribution.max_queue_time", 1209600000L, new zzdl());
    public static final zzfj<Boolean> zzbg;
    public static final zzfj<Boolean> zzbh;
    public static final zzfj<Boolean> zzbi;
    public static final zzfj<Boolean> zzbj;
    public static final zzfj<Boolean> zzbk;
    public static final zzfj<Boolean> zzbl;
    public static final zzfj<Boolean> zzbm;
    public static final zzfj<Boolean> zzbn;
    public static final zzfj<Integer> zzbo = zzb("measurement.service.storage_consent_support_version", 203600, new zzdv());
    public static final zzfj<Boolean> zzbp;
    public static final zzfj<Boolean> zzbq;
    public static final zzfj<Boolean> zzbr;
    public static final zzfj<Boolean> zzbs;
    public static final zzfj<Boolean> zzbt;
    public static final zzfj<String> zzbu = zza("measurement.sgtm.app_allowlist", "de.zalando.mobile.internal,de.zalando.mobile.internal.debug,de.zalando.lounge.dev,grit.storytel.app,com.rbc.mobile.android,com.rbc.mobile.android,com.dylvian.mango.activities,com.home24.android,com.home24.android.staging,se.lf.mobile.android,se.lf.mobile.android.beta,se.lf.mobile.android.rc,se.lf.mobile.android.test,se.lf.mobile.android.test.debug,com.boots.flagship.android,com.boots.flagshiproi.android,de.zalando.mobile,com.trivago,com.getyourguide.android,es.mobail.meliarewards,se.nansen.coop.debug,se.nansen.coop,se.coop.coop.qa,com.booking,com.google.firebaseengage,com.mse.mseapp.dev,com.mse.mseapp,pl.eobuwie.eobuwieapp,br.com.eventim.mobile.app.Android,ch.ticketcorner.mobile.app.Android,de.eventim.mobile.app.Android,dk.billetlugen.mobile.app.Android,nl.eventim.mobile.app.Android,com.asos.app,com.blueshieldca.prod,dk.magnetix.tivoliapp,matas.matas.internal,nl.omoda", new zzed());
    public static final zzfj<Boolean> zzbv;
    public static final zzfj<Boolean> zzbw;
    public static final zzfj<Boolean> zzbx;
    public static final zzfj<Boolean> zzby;
    public static final zzfj<Boolean> zzbz;
    public static final zzfj<Long> zzc = zzb("measurement.monitoring.sample_period_millis", 86400000L, new zzcf());
    public static final zzfj<Boolean> zzca;
    public static final zzfj<Boolean> zzcb;
    public static final zzfj<Boolean> zzcc;
    public static final zzfj<Boolean> zzcd;
    public static final zzfj<Boolean> zzce;
    public static final zzfj<Boolean> zzcf;
    public static final zzfj<Boolean> zzcg;
    public static final zzfj<Boolean> zzch;
    public static final zzfj<Boolean> zzci;
    public static final zzfj<Boolean> zzcj;
    public static final zzfj<Boolean> zzck;
    public static final zzfj<Boolean> zzcl;
    public static final zzfj<Boolean> zzcm;
    public static final zzfj<Boolean> zzcn;
    public static final zzfj<Boolean> zzco;
    public static final zzfj<Boolean> zzcp;
    public static final zzfj<Boolean> zzcq;
    public static final zzfj<Boolean> zzcr;
    public static final zzfj<Boolean> zzcs;
    public static final zzfj<Boolean> zzct;
    public static final zzfj<Boolean> zzcu;
    public static final zzfj<Boolean> zzcv;
    public static final zzfj<Boolean> zzcw;
    public static final zzfj<Boolean> zzcx;
    public static final zzfj<Boolean> zzcy;
    /* access modifiers changed from: private */
    public static final List<zzfj<?>> zzcz = Collections.synchronizedList(new ArrayList());
    public static final zzfj<Long> zzd = zza("measurement.config.cache_time", 86400000L, 3600000L, new zzcr(), false);
    public static final zzfj<String> zze = zzb("measurement.config.url_scheme", "https", new zzdd());
    public static final zzfj<String> zzf = zzb("measurement.config.url_authority", "app-measurement.com", new zzds());
    public static final zzfj<Integer> zzg = zzb("measurement.upload.max_bundles", 100, new zzee());
    public static final zzfj<Integer> zzh = zzb("measurement.upload.max_batch_size", 65536, new zzeq());
    public static final zzfj<Integer> zzi = zzb("measurement.upload.max_bundle_size", 65536, new zzfc());
    public static final zzfj<Integer> zzj = zzb("measurement.upload.max_events_per_bundle", 1000, new zzbn());
    public static final zzfj<Integer> zzk = zzb("measurement.upload.max_events_per_day", 100000, new zzdp());
    public static final zzfj<Integer> zzl = zzb("measurement.upload.max_error_events_per_day", 1000, new zzec());
    public static final zzfj<Integer> zzm = zzb("measurement.upload.max_public_events_per_day", 50000, new zzel());
    public static final zzfj<Integer> zzn = zzb("measurement.upload.max_conversions_per_day", 10000, new zzey());
    public static final zzfj<Integer> zzo = zzb("measurement.upload.max_realtime_events_per_day", 10, new zzbk());
    public static final zzfj<Integer> zzp = zzb("measurement.store.max_stored_events_per_app", 100000, new zzbq());
    public static final zzfj<String> zzq = zzb("measurement.upload.url", "https://app-measurement.com/a", new zzbp());
    public static final zzfj<Long> zzr = zzb("measurement.upload.backoff_period", 43200000L, new zzbr());
    public static final zzfj<Long> zzs = zzb("measurement.upload.window_interval", 3600000L, new zzbu());
    public static final zzfj<Long> zzt = zzb("measurement.upload.interval", 3600000L, new zzbw());
    public static final zzfj<Long> zzu = zzb("measurement.upload.realtime_upload_interval", 10000L, new zzbv());
    public static final zzfj<Long> zzv = zzb("measurement.upload.debug_upload_interval", 1000L, new zzby());
    public static final zzfj<Long> zzw = zzb("measurement.upload.minimum_delay", 500L, new zzca());
    public static final zzfj<Long> zzx = zzb("measurement.alarm_manager.minimum_interval", 60000L, new zzbz());
    public static final zzfj<Long> zzy = zzb("measurement.upload.stale_data_deletion_interval", 86400000L, new zzcc());
    public static final zzfj<Long> zzz = zzb("measurement.upload.refresh_blacklisted_config_interval", 604800000L, new zzcb());

    static {
        Collections.synchronizedSet(new HashSet());
        zzb("measurement.sgtm.google_signal.url", "https://app-measurement.com/s", new zzbs());
        Boolean bool = Boolean.FALSE;
        zzak = zzb("measurement.test.boolean_flag", bool, new zzcl());
        zza("measurement.test.cached_long_flag", -1L, new zzcq());
        Boolean bool2 = Boolean.TRUE;
        zzbg = zzb("measurement.collection.log_event_and_bundle_v2", bool2, new zzdo());
        zzbh = zza("measurement.quality.checksum", bool);
        zzbi = zzb("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", bool, new zzdn());
        zzbj = zzb("measurement.audience.refresh_event_count_filters_timestamp", bool, new zzdq());
        zzbk = zza("measurement.audience.use_bundle_timestamp_for_event_count_filters", bool, new zzdr());
        zzbl = zzb("measurement.sdk.collection.last_deep_link_referrer_campaign2", bool, new zzdu());
        zzbm = zzb("measurement.integration.disable_firebase_instance_id", bool, new zzdt());
        zzbn = zzb("measurement.collection.service.update_with_analytics_fix", bool, new zzdw());
        zzbp = zzb("measurement.service.store_null_safelist", bool2, new zzdy());
        zzbq = zzb("measurement.service.store_safelist", bool2, new zzdx());
        zzbr = zzb("measurement.session_stitching_token_enabled", bool, new zzea());
        zzbs = zza("measurement.sgtm.service", bool2, new zzdz());
        zzbt = zza("measurement.sgtm.preview_mode_enabled", bool2, new zzeb());
        zzb("measurement.sgtm.upload_queue", bool, new zzeg());
        zzb("measurement.sgtm.google_signal.enable", bool, new zzef());
        zzbv = zzb("measurement.gmscore_feature_tracking", bool2, new zzei());
        zzbw = zza("measurement.fix_health_monitor_stack_trace", bool2, new zzeh());
        zzbx = zza("measurement.item_scoped_custom_parameters.client", bool2, new zzek());
        zzby = zzb("measurement.item_scoped_custom_parameters.service", bool2, new zzej());
        zzbz = zza("measurement.rb.attribution.service", bool2, new zzem());
        zzca = zza("measurement.rb.attribution.client2", bool2, new zzeo());
        zzcb = zzb("measurement.rb.attribution.uuid_generation", bool2, new zzen());
        zzcc = zzb("measurement.rb.attribution.enable_trigger_redaction", bool2, new zzep());
        zzb("measurement.rb.attribution.followup1.service", bool, new zzes());
        zzcd = zzb("measurement.rb.attribution.registration_regardless_consent", bool, new zzer());
        zzce = zzb("measurement.rb.attribution.ad_campaign_info", bool, new zzeu());
        zzcf = zza("measurement.rb.attribution.improved_retry", bool2, new zzet());
        zzcg = zzb("measurement.client.sessions.enable_fix_background_engagement", bool, new zzew());
        zzch = zzb("measurement.client.sessions.enable_pause_engagement_in_background", bool2, new zzev());
        zzci = zzb("measurement.dma_consent.service_dcu_event2", bool2, new zzex());
        zzcj = zzb("measurement.dma_consent.services_database_update_fix", bool2, new zzfa());
        zzck = zza("measurement.service.deferred_first_open", bool2, new zzez());
        zzcl = zza("measurement.gbraid_campaign.gbraid.client.dev", bool, new zzfb());
        zzcm = zza("measurement.gbraid_campaign.gbraid.service", bool, new zzfe());
        zzcn = zza("measurement.increase_param_lengths", bool2, new zzfd());
        zzco = zzb("measurement.disable_npa_for_dasher_and_unicorn", bool2, new zzfg());
        zzcp = zza("measurement.consent_regional_defaults.service", bool, new zzff());
        zzcq = zza("measurement.consent_regional_defaults.client2", bool, new zzfi());
        zzcr = zzb("measurement.service.consent.pfo_on_fx", bool2, new zzbj());
        zzcs = zzb("measurement.service.consent.params_on_fx", bool2, new zzbm());
        zzct = zzb("measurement.service.consent.app_start_fix", bool2, new zzbl());
        zzcu = zza("measurement.consent.stop_reset_on_storage_denied.client", bool2, new zzbo());
        zzcv = zza("measurement.consent.stop_reset_on_storage_denied.service", bool2, new zzbx());
        zzcw = zzb("measurement.consent.scrub_audience_data_analytics_consent", bool2, new zzck());
        zzcx = zzb("measurement.consent.fix_first_open_count_from_snapshot", bool2, new zzct());
        zzcy = zzb("measurement.fix_engagement_on_reset_analytics_data", bool2, new zzdg());
    }

    @VisibleForTesting
    private static <V> zzfj<V> zza(String str, V v, zzfh<V> zzfh) {
        return zza(str, v, v, zzfh, true);
    }

    @VisibleForTesting
    private static <V> zzfj<V> zzb(String str, V v, zzfh<V> zzfh) {
        return zza(str, v, v, zzfh, false);
    }

    @VisibleForTesting
    private static <V> zzfj<V> zza(String str, V v, V v2, zzfh<V> zzfh, boolean z) {
        zzfj zzfj = new zzfj(str, v, v2, zzfh, z);
        if (z) {
            zzcz.add(zzfj);
        }
        return zzfj;
    }

    @VisibleForTesting
    private static <V> zzfj<V> zza(String str, V v) {
        return zza(str, v, v, (zzfh) null, false);
    }

    public static Map<String, String> zza(Context context) {
        zzgk zza2 = zzgk.zza(context.getContentResolver(), zzgw.zza("com.google.android.gms.measurement"), new zzbi());
        return zza2 == null ? Collections.emptyMap() : zza2.zza();
    }
}
