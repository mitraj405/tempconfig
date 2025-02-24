package com.google.android.gms.measurement.internal;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import android.os.Handler;
import com.google.android.gms.common.internal.AccountType;
import com.google.android.gms.common.util.Clock;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
public final class zzax extends zzii {
    private long zza;
    private String zzb;
    private AccountManager zzc;
    private Boolean zzd;
    private long zze;

    public zzax(zzhj zzhj) {
        super(zzhj);
    }

    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    public final long zzc() {
        zzt();
        return this.zze;
    }

    public final /* bridge */ /* synthetic */ zzab zzd() {
        return super.zzd();
    }

    public final /* bridge */ /* synthetic */ zzag zze() {
        return super.zze();
    }

    public final /* bridge */ /* synthetic */ zzax zzf() {
        return super.zzf();
    }

    public final long zzg() {
        zzac();
        return this.zza;
    }

    public final String zzh() {
        zzac();
        return this.zzb;
    }

    public final /* bridge */ /* synthetic */ zzfr zzi() {
        return super.zzi();
    }

    public final /* bridge */ /* synthetic */ zzfw zzj() {
        return super.zzj();
    }

    public final /* bridge */ /* synthetic */ zzgh zzk() {
        return super.zzk();
    }

    public final /* bridge */ /* synthetic */ zzhc zzl() {
        return super.zzl();
    }

    public final void zzm() {
        zzt();
        this.zzd = null;
        this.zze = 0;
    }

    public final boolean zzn() {
        zzt();
        long currentTimeMillis = zzb().currentTimeMillis();
        if (currentTimeMillis - this.zze > 86400000) {
            this.zzd = null;
        }
        Boolean bool = this.zzd;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (d7.a(zza(), "android.permission.GET_ACCOUNTS") != 0) {
            zzj().zzw().zza("Permission error checking for dasher/unicorn accounts");
            this.zze = currentTimeMillis;
            this.zzd = Boolean.FALSE;
            return false;
        }
        if (this.zzc == null) {
            this.zzc = AccountManager.get(zza());
        }
        try {
            Account[] result = this.zzc.getAccountsByTypeAndFeatures(AccountType.GOOGLE, new String[]{"service_HOSTED"}, (AccountManagerCallback) null, (Handler) null).getResult();
            if (result == null || result.length <= 0) {
                Account[] result2 = this.zzc.getAccountsByTypeAndFeatures(AccountType.GOOGLE, new String[]{"service_uca"}, (AccountManagerCallback) null, (Handler) null).getResult();
                if (result2 != null && result2.length > 0) {
                    this.zzd = Boolean.TRUE;
                    this.zze = currentTimeMillis;
                    return true;
                }
                this.zze = currentTimeMillis;
                this.zzd = Boolean.FALSE;
                return false;
            }
            this.zzd = Boolean.TRUE;
            this.zze = currentTimeMillis;
            return true;
        } catch (AuthenticatorException | OperationCanceledException | IOException e) {
            zzj().zzm().zza("Exception checking account types", e);
        }
    }

    public final boolean zzo() {
        Calendar instance = Calendar.getInstance();
        this.zza = TimeUnit.MINUTES.convert((long) (instance.get(16) + instance.get(15)), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        Locale locale2 = Locale.ENGLISH;
        this.zzb = xx.D(language.toLowerCase(locale2), "-", locale.getCountry().toLowerCase(locale2));
        return false;
    }

    public final /* bridge */ /* synthetic */ zznp zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ void zzr() {
        super.zzr();
    }

    public final /* bridge */ /* synthetic */ void zzs() {
        super.zzs();
    }

    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }
}
