package com.google.android.gms.internal.ads;

import com.google.firebase.perf.util.Constants;
import com.google.firebase.sessions.settings.RemoteSettings;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzain {
    public static zzbj zza(zzek zzek) {
        String str;
        zzbj zzafp;
        int zzg = zzek.zzg() + zzek.zzd();
        int zzg2 = zzek.zzg();
        int i = (zzg2 >> 24) & Constants.MAX_HOST_LENGTH;
        zzbj zzbj = null;
        if (i == 169 || i == 253) {
            int i2 = zzg2 & 16777215;
            if (i2 == 6516084) {
                int zzg3 = zzek.zzg();
                if (zzek.zzg() == 1684108385) {
                    zzek.zzL(8);
                    String zzz = zzek.zzz(zzg3 - 16);
                    zzbj = new zzafx("und", zzz, zzz);
                } else {
                    zzea.zzf("MetadataUtil", "Failed to parse comment attribute: ".concat(zzahx.zzf(zzg2)));
                }
            } else {
                if (i2 != 7233901) {
                    if (i2 != 7631467) {
                        if (i2 != 6516589) {
                            if (i2 != 7828084) {
                                if (i2 == 6578553) {
                                    zzbj = zze(zzg2, "TDRC", zzek);
                                } else if (i2 == 4280916) {
                                    zzbj = zze(zzg2, "TPE1", zzek);
                                } else if (i2 == 7630703) {
                                    zzbj = zze(zzg2, "TSSE", zzek);
                                } else if (i2 == 6384738) {
                                    zzbj = zze(zzg2, "TALB", zzek);
                                } else if (i2 == 7108978) {
                                    zzbj = zze(zzg2, "USLT", zzek);
                                } else if (i2 == 6776174) {
                                    zzbj = zze(zzg2, "TCON", zzek);
                                } else if (i2 == 6779504) {
                                    zzbj = zze(zzg2, "TIT1", zzek);
                                }
                            }
                        }
                        zzbj = zze(zzg2, "TCOM", zzek);
                    }
                }
                zzbj = zze(zzg2, "TIT2", zzek);
            }
            return zzbj;
        }
        if (zzg2 == 1735291493) {
            try {
                String zza = zzage.zza(zzb(zzek) - 1);
                if (zza != null) {
                    zzafp = new zzagm("TCON", (String) null, zzfxr.zzn(zza));
                } else {
                    zzea.zzf("MetadataUtil", "Failed to parse standard genre code");
                    return zzbj;
                }
            } finally {
                zzek.zzK(zzg);
            }
        } else {
            if (zzg2 == 1684632427) {
                zzbj = zzd(1684632427, "TPOS", zzek);
            } else if (zzg2 == 1953655662) {
                zzbj = zzd(1953655662, "TRCK", zzek);
            } else if (zzg2 == 1953329263) {
                zzbj = zzc(1953329263, "TBPM", zzek, true, false);
            } else if (zzg2 == 1668311404) {
                zzbj = zzc(1668311404, "TCMP", zzek, true, true);
            } else if (zzg2 == 1668249202) {
                int zzg4 = zzek.zzg();
                if (zzek.zzg() == 1684108385) {
                    int zzg5 = zzek.zzg() & 16777215;
                    if (zzg5 == 13) {
                        str = "image/jpeg";
                    } else if (zzg5 == 14) {
                        str = "image/png";
                        zzg5 = 14;
                    } else {
                        str = null;
                    }
                    if (str == null) {
                        zzea.zzf("MetadataUtil", "Unrecognized cover art flags: " + zzg5);
                    } else {
                        zzek.zzL(4);
                        int i3 = zzg4 - 16;
                        byte[] bArr = new byte[i3];
                        zzek.zzG(bArr, 0, i3);
                        zzafp = new zzafp(str, (String) null, 3, bArr);
                    }
                } else {
                    zzea.zzf("MetadataUtil", "Failed to parse cover art attribute");
                }
            } else if (zzg2 == 1631670868) {
                zzbj = zze(1631670868, "TPE2", zzek);
            } else if (zzg2 == 1936682605) {
                zzbj = zze(1936682605, "TSOT", zzek);
            } else if (zzg2 == 1936679276) {
                zzbj = zze(1936679276, "TSOA", zzek);
            } else if (zzg2 == 1936679282) {
                zzbj = zze(1936679282, "TSOP", zzek);
            } else if (zzg2 == 1936679265) {
                zzbj = zze(1936679265, "TSO2", zzek);
            } else if (zzg2 == 1936679791) {
                zzbj = zze(1936679791, "TSOC", zzek);
            } else if (zzg2 == 1920233063) {
                zzbj = zzc(1920233063, "ITUNESADVISORY", zzek, false, false);
            } else if (zzg2 == 1885823344) {
                zzbj = zzc(1885823344, "ITUNESGAPLESS", zzek, false, true);
            } else if (zzg2 == 1936683886) {
                zzbj = zze(1936683886, "TVSHOWSORT", zzek);
            } else if (zzg2 == 1953919848) {
                zzbj = zze(1953919848, "TVSHOW", zzek);
            } else if (zzg2 == 757935405) {
                int i4 = -1;
                int i5 = -1;
                String str2 = null;
                String str3 = null;
                while (zzek.zzd() < zzg) {
                    int zzd = zzek.zzd();
                    int zzg6 = zzek.zzg();
                    int zzg7 = zzek.zzg();
                    zzek.zzL(4);
                    if (zzg7 == 1835360622) {
                        str2 = zzek.zzz(zzg6 - 12);
                    } else {
                        int i6 = zzg6 - 12;
                        if (zzg7 == 1851878757) {
                            str3 = zzek.zzz(i6);
                        } else {
                            if (zzg7 == 1684108385) {
                                i5 = zzg6;
                            }
                            if (zzg7 == 1684108385) {
                                i4 = zzd;
                            }
                            zzek.zzL(i6);
                        }
                    }
                }
                if (!(str2 == null || str3 == null)) {
                    if (i4 != -1) {
                        zzek.zzK(i4);
                        zzek.zzL(16);
                        zzbj = new zzagg(str2, str3, zzek.zzz(i5 - 16));
                    }
                }
            }
            return zzbj;
        }
        zzbj = zzafp;
        return zzbj;
        zzea.zzb("MetadataUtil", "Skipped unknown metadata entry: " + zzahx.zzf(zzg2));
        return zzbj;
    }

    private static int zzb(zzek zzek) {
        int zzg = zzek.zzg();
        if (zzek.zzg() == 1684108385) {
            zzek.zzL(8);
            int i = zzg - 16;
            if (i == 1) {
                return zzek.zzm();
            }
            if (i == 2) {
                return zzek.zzq();
            }
            if (i == 3) {
                return zzek.zzo();
            }
            if (i == 4 && (zzek.zzf() & 128) == 0) {
                return zzek.zzp();
            }
        }
        zzea.zzf("MetadataUtil", "Failed to parse data atom to int");
        return -1;
    }

    private static zzagd zzc(int i, String str, zzek zzek, boolean z, boolean z2) {
        int zzb = zzb(zzek);
        if (z2) {
            zzb = Math.min(1, zzb);
        }
        if (zzb < 0) {
            zzea.zzf("MetadataUtil", "Failed to parse uint8 attribute: ".concat(zzahx.zzf(i)));
            return null;
        } else if (z) {
            return new zzagm(str, (String) null, zzfxr.zzn(Integer.toString(zzb)));
        } else {
            return new zzafx("und", str, Integer.toString(zzb));
        }
    }

    private static zzagm zzd(int i, String str, zzek zzek) {
        int zzg = zzek.zzg();
        if (zzek.zzg() == 1684108385 && zzg >= 22) {
            zzek.zzL(10);
            int zzq = zzek.zzq();
            if (zzq > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(zzq);
                String sb2 = sb.toString();
                int zzq2 = zzek.zzq();
                if (zzq2 > 0) {
                    sb2 = sb2 + RemoteSettings.FORWARD_SLASH_STRING + zzq2;
                }
                return new zzagm(str, (String) null, zzfxr.zzn(sb2));
            }
        }
        zzea.zzf("MetadataUtil", "Failed to parse index/count attribute: ".concat(zzahx.zzf(i)));
        return null;
    }

    private static zzagm zze(int i, String str, zzek zzek) {
        int zzg = zzek.zzg();
        if (zzek.zzg() == 1684108385) {
            zzek.zzL(8);
            return new zzagm(str, (String) null, zzfxr.zzn(zzek.zzz(zzg - 16)));
        }
        zzea.zzf("MetadataUtil", "Failed to parse text attribute: ".concat(zzahx.zzf(i)));
        return null;
    }
}
