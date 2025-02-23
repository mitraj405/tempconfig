package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.Base64;
import android.util.Pair;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzaky {
    public final String zza;
    public final String zzb;
    public final boolean zzc;
    public final long zzd;
    public final long zze;
    public final zzale zzf;
    public final String zzg;
    public final String zzh;
    public final zzaky zzi;
    private final String[] zzj;
    private final HashMap zzk;
    private final HashMap zzl;
    private List zzm;

    private zzaky(String str, String str2, long j, long j2, zzale zzale, String[] strArr, String str3, String str4, zzaky zzaky) {
        boolean z;
        this.zza = str;
        this.zzb = str2;
        this.zzh = str4;
        this.zzf = zzale;
        this.zzj = strArr;
        if (str2 != null) {
            z = true;
        } else {
            z = false;
        }
        this.zzc = z;
        this.zzd = j;
        this.zze = j2;
        str3.getClass();
        this.zzg = str3;
        this.zzi = zzaky;
        this.zzk = new HashMap();
        this.zzl = new HashMap();
    }

    public static zzaky zzb(String str, long j, long j2, zzale zzale, String[] strArr, String str2, String str3, zzaky zzaky) {
        return new zzaky(str, (String) null, j, j2, zzale, strArr, str2, str3, zzaky);
    }

    public static zzaky zzc(String str) {
        return new zzaky((String) null, str.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " "), -9223372036854775807L, -9223372036854775807L, (zzale) null, (String[]) null, "", (String) null, (zzaky) null);
    }

    private static SpannableStringBuilder zzi(String str, Map map) {
        if (!map.containsKey(str)) {
            zzcz zzcz = new zzcz();
            zzcz.zzl(new SpannableStringBuilder());
            map.put(str, zzcz);
        }
        CharSequence zzq = ((zzcz) map.get(str)).zzq();
        zzq.getClass();
        return (SpannableStringBuilder) zzq;
    }

    private final void zzj(TreeSet treeSet, boolean z) {
        String str = this.zza;
        boolean equals = "p".equals(str);
        boolean equals2 = "div".equals(str);
        if (z || equals || (equals2 && this.zzh != null)) {
            long j = this.zzd;
            if (j != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j));
            }
            long j2 = this.zze;
            if (j2 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j2));
            }
        }
        if (this.zzm != null) {
            for (int i = 0; i < this.zzm.size(); i++) {
                zzaky zzaky = (zzaky) this.zzm.get(i);
                boolean z2 = true;
                if (!z && !equals) {
                    z2 = false;
                }
                zzaky.zzj(treeSet, z2);
            }
        }
    }

    private final void zzk(long j, String str, List list) {
        String str2;
        if (!"".equals(this.zzg)) {
            str = this.zzg;
        }
        if (!zzg(j) || !"div".equals(this.zza) || (str2 = this.zzh) == null) {
            for (int i = 0; i < zza(); i++) {
                zzd(i).zzk(j, str, list);
            }
            return;
        }
        list.add(new Pair(str, str2));
    }

    private final void zzl(long j, Map map, Map map2, String str, Map map3) {
        zzaky zzaky;
        int i;
        int i2;
        zzale zza2;
        int i3;
        Map map4 = map;
        if (zzg(j)) {
            String str2 = !"".equals(this.zzg) ? this.zzg : str;
            for (Map.Entry entry : this.zzl.entrySet()) {
                String str3 = (String) entry.getKey();
                int intValue = this.zzk.containsKey(str3) ? ((Integer) this.zzk.get(str3)).intValue() : 0;
                int intValue2 = ((Integer) entry.getValue()).intValue();
                if (intValue != intValue2) {
                    zzcz zzcz = (zzcz) map3.get(str3);
                    zzcz.getClass();
                    zzalc zzalc = (zzalc) map2.get(str2);
                    zzalc.getClass();
                    zzale zza3 = zzald.zza(this.zzf, this.zzj, map4);
                    SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) zzcz.zzq();
                    if (spannableStringBuilder == null) {
                        spannableStringBuilder = new SpannableStringBuilder();
                        zzcz.zzl(spannableStringBuilder);
                    }
                    if (zza3 != null) {
                        zzaky zzaky2 = this.zzi;
                        if (zza3.zzh() != -1) {
                            spannableStringBuilder.setSpan(new StyleSpan(zza3.zzh()), intValue, intValue2, 33);
                        }
                        if (zza3.zzI()) {
                            spannableStringBuilder.setSpan(new StrikethroughSpan(), intValue, intValue2, 33);
                        }
                        if (zza3.zzJ()) {
                            spannableStringBuilder.setSpan(new UnderlineSpan(), intValue, intValue2, 33);
                        }
                        if (zza3.zzH()) {
                            zzdg.zza(spannableStringBuilder, new ForegroundColorSpan(zza3.zzd()), intValue, intValue2, 33);
                        }
                        if (zza3.zzG()) {
                            zzdg.zza(spannableStringBuilder, new BackgroundColorSpan(zza3.zzc()), intValue, intValue2, 33);
                        }
                        if (zza3.zzD() != null) {
                            zzdg.zza(spannableStringBuilder, new TypefaceSpan(zza3.zzD()), intValue, intValue2, 33);
                        }
                        if (zza3.zzk() != null) {
                            zzakx zzk2 = zza3.zzk();
                            zzk2.getClass();
                            int i4 = zzk2.zza;
                            if (i4 == -1) {
                                int i5 = zzalc.zzj;
                                i4 = (i5 == 2 || i5 == 1) ? 3 : 1;
                                i3 = 1;
                            } else {
                                i3 = zzk2.zzb;
                            }
                            int i6 = zzk2.zzc;
                            if (i6 == -2) {
                                i6 = 1;
                            }
                            zzdg.zza(spannableStringBuilder, new zzdh(i4, i3, i6), intValue, intValue2, 33);
                        }
                        int zzg2 = zza3.zzg();
                        if (zzg2 == 2) {
                            while (true) {
                                if (zzaky2 != null) {
                                    zzale zza4 = zzald.zza(zzaky2.zzf, zzaky2.zzj, map4);
                                    if (zza4 != null && zza4.zzg() == 1) {
                                        break;
                                    }
                                    zzaky2 = zzaky2.zzi;
                                } else {
                                    zzaky2 = null;
                                    break;
                                }
                            }
                            if (zzaky2 != null) {
                                ArrayDeque arrayDeque = new ArrayDeque();
                                arrayDeque.push(zzaky2);
                                while (true) {
                                    if (arrayDeque.isEmpty()) {
                                        zzaky = null;
                                        break;
                                    }
                                    zzaky zzaky3 = (zzaky) arrayDeque.pop();
                                    zzale zza5 = zzald.zza(zzaky3.zzf, zzaky3.zzj, map4);
                                    if (zza5 != null && zza5.zzg() == 3) {
                                        zzaky = zzaky3;
                                        break;
                                    }
                                    for (int zza6 = zzaky3.zza() - 1; zza6 >= 0; zza6--) {
                                        arrayDeque.push(zzaky3.zzd(zza6));
                                    }
                                }
                                if (zzaky != null) {
                                    if (zzaky.zza() != 1 || zzaky.zzd(0).zzb == null) {
                                        zzea.zze("TtmlRenderUtil", "Skipping rubyText node without exactly one text child.");
                                    } else {
                                        String str4 = zzaky.zzd(0).zzb;
                                        int i7 = zzet.zza;
                                        zzale zza7 = zzald.zza(zzaky.zzf, zzaky.zzj, map4);
                                        if (zza7 != null) {
                                            i = zza7.zzf();
                                            i2 = -1;
                                        } else {
                                            i2 = -1;
                                            i = -1;
                                        }
                                        if (i == i2 && (zza2 = zzald.zza(zzaky2.zzf, zzaky2.zzj, map4)) != null) {
                                            i = zza2.zzf();
                                        }
                                        spannableStringBuilder.setSpan(new zzdf(str4, i), intValue, intValue2, 33);
                                    }
                                }
                            }
                        } else if (zzg2 == 3 || zzg2 == 4) {
                            spannableStringBuilder.setSpan(new zzakw(), intValue, intValue2, 33);
                        }
                        if (zza3.zzF()) {
                            zzdg.zza(spannableStringBuilder, new zzde(), intValue, intValue2, 33);
                        }
                        int zze2 = zza3.zze();
                        if (zze2 == 1) {
                            zzdg.zza(spannableStringBuilder, new AbsoluteSizeSpan((int) zza3.zza(), true), intValue, intValue2, 33);
                        } else if (zze2 == 2) {
                            zzdg.zza(spannableStringBuilder, new RelativeSizeSpan(zza3.zza()), intValue, intValue2, 33);
                        } else if (zze2 == 3) {
                            zzdg.zza(spannableStringBuilder, new RelativeSizeSpan(zza3.zza() / 100.0f), intValue, intValue2, 33);
                        }
                        if ("p".equals(this.zza)) {
                            if (zza3.zzb() != Float.MAX_VALUE) {
                                zzcz.zzj((zza3.zzb() * -90.0f) / 100.0f);
                            }
                            if (zza3.zzj() != null) {
                                zzcz.zzm(zza3.zzj());
                            }
                            if (zza3.zzi() != null) {
                                zzcz.zzg(zza3.zzi());
                            }
                        }
                    }
                } else {
                    Map map5 = map2;
                    Map map6 = map3;
                }
            }
            Map map7 = map2;
            Map map8 = map3;
            for (int i8 = 0; i8 < zza(); i8++) {
                zzd(i8).zzl(j, map, map2, str2, map3);
            }
        }
    }

    private final void zzm(long j, boolean z, String str, Map map) {
        boolean z2;
        this.zzk.clear();
        this.zzl.clear();
        if (!"metadata".equals(this.zza)) {
            if (!"".equals(this.zzg)) {
                str = this.zzg;
            }
            if (this.zzc && z) {
                SpannableStringBuilder zzi2 = zzi(str, map);
                String str2 = this.zzb;
                str2.getClass();
                zzi2.append(str2);
            } else if ("br".equals(this.zza) && z) {
                zzi(str, map).append(10);
            } else if (zzg(j)) {
                for (Map.Entry entry : map.entrySet()) {
                    CharSequence zzq = ((zzcz) entry.getValue()).zzq();
                    zzq.getClass();
                    this.zzk.put((String) entry.getKey(), Integer.valueOf(zzq.length()));
                }
                boolean equals = "p".equals(this.zza);
                for (int i = 0; i < zza(); i++) {
                    zzaky zzd2 = zzd(i);
                    if (z || equals) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zzd2.zzm(j, z2, str, map);
                }
                if (equals) {
                    SpannableStringBuilder zzi3 = zzi(str, map);
                    int length = zzi3.length();
                    do {
                        length--;
                        if (length < 0 || zzi3.charAt(length) != ' ') {
                            if (length >= 0 && zzi3.charAt(length) != 10) {
                                zzi3.append(10);
                            }
                        }
                        length--;
                        break;
                    } while (zzi3.charAt(length) != ' ');
                    zzi3.append(10);
                }
                for (Map.Entry entry2 : map.entrySet()) {
                    CharSequence zzq2 = ((zzcz) entry2.getValue()).zzq();
                    zzq2.getClass();
                    this.zzl.put((String) entry2.getKey(), Integer.valueOf(zzq2.length()));
                }
            }
        }
    }

    public final int zza() {
        List list = this.zzm;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final zzaky zzd(int i) {
        List list = this.zzm;
        if (list != null) {
            return (zzaky) list.get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    public final List zze(long j, Map map, Map map2, Map map3) {
        ArrayList arrayList = new ArrayList();
        zzk(j, this.zzg, arrayList);
        TreeMap treeMap = new TreeMap();
        long j2 = j;
        zzm(j2, false, this.zzg, treeMap);
        zzl(j2, map, map2, this.zzg, treeMap);
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Pair pair = (Pair) arrayList.get(i);
            String str = (String) map3.get(pair.second);
            if (str != null) {
                byte[] decode = Base64.decode(str, 0);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                zzalc zzalc = (zzalc) map2.get(pair.first);
                zzalc.getClass();
                zzcz zzcz = new zzcz();
                zzcz.zzc(decodeByteArray);
                zzcz.zzh(zzalc.zzb);
                zzcz.zzi(0);
                zzcz.zze(zzalc.zzc, 0);
                zzcz.zzf(zzalc.zze);
                zzcz.zzk(zzalc.zzf);
                zzcz.zzd(zzalc.zzg);
                zzcz.zzo(zzalc.zzj);
                arrayList2.add(zzcz.zzp());
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            zzalc zzalc2 = (zzalc) map2.get(entry.getKey());
            zzalc2.getClass();
            zzcz zzcz2 = (zzcz) entry.getValue();
            CharSequence zzq = zzcz2.zzq();
            zzq.getClass();
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) zzq;
            for (zzakw zzakw : (zzakw[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), zzakw.class)) {
                spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(zzakw), spannableStringBuilder.getSpanEnd(zzakw), "");
            }
            int i2 = 0;
            while (i2 < spannableStringBuilder.length()) {
                int i3 = i2 + 1;
                if (spannableStringBuilder.charAt(i2) == ' ') {
                    int i4 = i3;
                    while (i4 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i4) == ' ') {
                        i4++;
                    }
                    int i5 = i4 - i3;
                    if (i5 > 0) {
                        spannableStringBuilder.delete(i2, i5 + i2);
                    }
                }
                i2 = i3;
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
                spannableStringBuilder.delete(0, 1);
            }
            int i6 = 0;
            while (i6 < spannableStringBuilder.length() - 1) {
                int i7 = i6 + 1;
                if (spannableStringBuilder.charAt(i6) == 10 && spannableStringBuilder.charAt(i7) == ' ') {
                    spannableStringBuilder.delete(i7, i6 + 2);
                }
                i6 = i7;
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            int i8 = 0;
            while (i8 < spannableStringBuilder.length() - 1) {
                int i9 = i8 + 1;
                if (spannableStringBuilder.charAt(i8) == ' ' && spannableStringBuilder.charAt(i9) == 10) {
                    spannableStringBuilder.delete(i8, i9);
                }
                i8 = i9;
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == 10) {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            zzcz2.zze(zzalc2.zzc, zzalc2.zzd);
            zzcz2.zzf(zzalc2.zze);
            zzcz2.zzh(zzalc2.zzb);
            zzcz2.zzk(zzalc2.zzf);
            zzcz2.zzn(zzalc2.zzi, zzalc2.zzh);
            zzcz2.zzo(zzalc2.zzj);
            arrayList2.add(zzcz2.zzp());
        }
        return arrayList2;
    }

    public final void zzf(zzaky zzaky) {
        if (this.zzm == null) {
            this.zzm = new ArrayList();
        }
        this.zzm.add(zzaky);
    }

    public final boolean zzg(long j) {
        long j2 = this.zzd;
        if (j2 == -9223372036854775807L) {
            if (this.zze == -9223372036854775807L) {
                return true;
            }
            j2 = -9223372036854775807L;
        }
        int i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
        if (i <= 0 && this.zze == -9223372036854775807L) {
            return true;
        }
        if (j2 == -9223372036854775807L && j < this.zze) {
            return true;
        }
        if (i > 0) {
            return false;
        }
        if (j < this.zze) {
            return true;
        }
        return false;
    }

    public final long[] zzh() {
        TreeSet treeSet = new TreeSet();
        int i = 0;
        zzj(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i] = ((Long) it.next()).longValue();
            i++;
        }
        return jArr;
    }
}
