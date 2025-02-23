package com.google.android.material.color.utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class Score {
    private static final int BLUE_500 = -12417548;
    private static final double CUTOFF_CHROMA = 5.0d;
    private static final double CUTOFF_EXCITED_PROPORTION = 0.01d;
    private static final int MAX_COLOR_COUNT = 4;
    private static final double TARGET_CHROMA = 48.0d;
    private static final double WEIGHT_CHROMA_ABOVE = 0.3d;
    private static final double WEIGHT_CHROMA_BELOW = 0.1d;
    private static final double WEIGHT_PROPORTION = 0.7d;

    public static class ScoredComparator implements Comparator<ScoredHCT> {
        public int compare(ScoredHCT scoredHCT, ScoredHCT scoredHCT2) {
            return Double.compare(scoredHCT2.score, scoredHCT.score);
        }
    }

    public static class ScoredHCT {
        public final Hct hct;
        public final double score;

        public ScoredHCT(Hct hct2, double d) {
            this.hct = hct2;
            this.score = d;
        }
    }

    private Score() {
    }

    public static List<Integer> score(Map<Integer, Integer> map) {
        return score(map, 4, BLUE_500, true);
    }

    public static List<Integer> score(Map<Integer, Integer> map, int i) {
        return score(map, i, BLUE_500, true);
    }

    public static List<Integer> score(Map<Integer, Integer> map, int i, int i2) {
        return score(map, i, i2, true);
    }

    public static List<Integer> score(Map<Integer, Integer> map, int i, int i2, boolean z) {
        boolean z2;
        int i3 = i;
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[360];
        double d = 0.0d;
        for (Map.Entry next : map.entrySet()) {
            Hct fromInt = Hct.fromInt(((Integer) next.getKey()).intValue());
            arrayList.add(fromInt);
            int floor = (int) Math.floor(fromInt.getHue());
            int intValue = ((Integer) next.getValue()).intValue();
            iArr[floor] = iArr[floor] + intValue;
            d += (double) intValue;
        }
        double[] dArr = new double[360];
        for (int i4 = 0; i4 < 360; i4++) {
            double d2 = ((double) iArr[i4]) / d;
            for (int i5 = i4 - 14; i5 < i4 + 16; i5++) {
                int sanitizeDegreesInt = MathUtils.sanitizeDegreesInt(i5);
                dArr[sanitizeDegreesInt] = dArr[sanitizeDegreesInt] + d2;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Hct hct = (Hct) it.next();
            double d3 = dArr[MathUtils.sanitizeDegreesInt((int) Math.round(hct.getHue()))];
            if (!z || (hct.getChroma() >= CUTOFF_CHROMA && d3 > CUTOFF_EXCITED_PROPORTION)) {
                arrayList2.add(new ScoredHCT(hct, ((hct.getChroma() - TARGET_CHROMA) * (hct.getChroma() < TARGET_CHROMA ? 0.1d : WEIGHT_CHROMA_ABOVE)) + (d3 * 100.0d * WEIGHT_PROPORTION)));
            }
        }
        Collections.sort(arrayList2, new ScoredComparator());
        ArrayList arrayList3 = new ArrayList();
        for (int i6 = 90; i6 >= 15; i6--) {
            arrayList3.clear();
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                Hct hct2 = ((ScoredHCT) it2.next()).hct;
                Iterator it3 = arrayList3.iterator();
                while (true) {
                    if (it3.hasNext()) {
                        if (MathUtils.differenceDegrees(hct2.getHue(), ((Hct) it3.next()).getHue()) < ((double) i6)) {
                            z2 = true;
                            break;
                        }
                    } else {
                        z2 = false;
                        break;
                    }
                }
                if (!z2) {
                    arrayList3.add(hct2);
                }
                if (arrayList3.size() >= i3) {
                    break;
                }
            }
            if (arrayList3.size() >= i3) {
                break;
            }
        }
        ArrayList arrayList4 = new ArrayList();
        if (arrayList3.isEmpty()) {
            arrayList4.add(Integer.valueOf(i2));
            return arrayList4;
        }
        Iterator it4 = arrayList3.iterator();
        while (it4.hasNext()) {
            arrayList4.add(Integer.valueOf(((Hct) it4.next()).toInt()));
        }
        return arrayList4;
    }
}
