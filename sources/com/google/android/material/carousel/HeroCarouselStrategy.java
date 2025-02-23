package com.google.android.material.carousel;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class HeroCarouselStrategy extends CarouselStrategy {
    private static final int[] MEDIUM_COUNTS = {0, 1};
    private static final int[] SMALL_COUNTS = {1};
    private int keylineCount = 0;

    public KeylineState onFirstChildMeasuredWithMargins(Carousel carousel, View view) {
        int[] iArr;
        int i;
        int[] iArr2;
        int[] iArr3;
        int i2;
        int containerHeight = carousel.getContainerHeight();
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f = (float) (layoutParams.topMargin + layoutParams.bottomMargin);
        float measuredWidth = (float) (view.getMeasuredWidth() * 2);
        if (carousel.isHorizontal()) {
            f = (float) (layoutParams.leftMargin + layoutParams.rightMargin);
            measuredWidth = (float) (view.getMeasuredHeight() * 2);
        }
        float smallItemSizeMin = getSmallItemSizeMin() + f;
        float max = Math.max(getSmallItemSizeMax() + f, smallItemSizeMin);
        float f2 = (float) containerHeight;
        float min = Math.min(measuredWidth + f, f2);
        float w = C1354qp.w((measuredWidth / 3.0f) + f, smallItemSizeMin + f, max + f);
        float f3 = (min + w) / 2.0f;
        int[] iArr4 = SMALL_COUNTS;
        if (f2 < 2.0f * smallItemSizeMin) {
            iArr = new int[]{0};
        } else {
            iArr = iArr4;
        }
        int max2 = (int) Math.max(1.0d, Math.floor((double) ((f2 - (((float) CarouselStrategyHelper.maxValue(iArr4)) * max)) / min)));
        int ceil = (((int) Math.ceil((double) (f2 / min))) - max2) + 1;
        int[] iArr5 = new int[ceil];
        for (int i3 = 0; i3 < ceil; i3++) {
            iArr5[i3] = max2 + i3;
        }
        if (carousel.getCarouselAlignment() == 1) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            iArr2 = CarouselStrategy.doubleCounts(iArr);
        } else {
            iArr2 = iArr;
        }
        if (i != 0) {
            iArr3 = CarouselStrategy.doubleCounts(MEDIUM_COUNTS);
        } else {
            iArr3 = MEDIUM_COUNTS;
        }
        int[] iArr6 = iArr5;
        Arrangement findLowestCostArrangement = Arrangement.findLowestCostArrangement(f2, w, smallItemSizeMin, max, iArr2, f3, iArr3, min, iArr5);
        this.keylineCount = findLowestCostArrangement.getItemCount();
        if (findLowestCostArrangement.getItemCount() > carousel.getItemCount()) {
            findLowestCostArrangement = Arrangement.findLowestCostArrangement(f2, w, smallItemSizeMin, max, iArr, f3, MEDIUM_COUNTS, min, iArr6);
            i2 = 0;
        } else {
            i2 = i;
        }
        return CarouselStrategyHelper.createKeylineState(view.getContext(), f, f2, findLowestCostArrangement, i2);
    }

    public boolean shouldRefreshKeylineState(Carousel carousel, int i) {
        if (carousel.getCarouselAlignment() == 1) {
            if (i < this.keylineCount && carousel.getItemCount() >= this.keylineCount) {
                return true;
            }
            if (i < this.keylineCount || carousel.getItemCount() >= this.keylineCount) {
                return false;
            }
            return true;
        }
        return false;
    }
}
