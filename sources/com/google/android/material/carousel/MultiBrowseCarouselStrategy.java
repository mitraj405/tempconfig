package com.google.android.material.carousel;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public final class MultiBrowseCarouselStrategy extends CarouselStrategy {
    private static final int[] MEDIUM_COUNTS = {1, 0};
    private static final int[] SMALL_COUNTS = {1};
    private int keylineCount = 0;

    public boolean ensureArrangementFitsItemCount(Arrangement arrangement, int i) {
        boolean z;
        int itemCount = arrangement.getItemCount() - i;
        if (itemCount <= 0 || (arrangement.smallCount <= 0 && arrangement.mediumCount <= 1)) {
            z = false;
        } else {
            z = true;
        }
        while (itemCount > 0) {
            int i2 = arrangement.smallCount;
            if (i2 > 0) {
                arrangement.smallCount = i2 - 1;
            } else {
                int i3 = arrangement.mediumCount;
                if (i3 > 1) {
                    arrangement.mediumCount = i3 - 1;
                }
            }
            itemCount--;
        }
        return z;
    }

    public KeylineState onFirstChildMeasuredWithMargins(Carousel carousel, View view) {
        float containerHeight = (float) carousel.getContainerHeight();
        if (carousel.isHorizontal()) {
            containerHeight = (float) carousel.getContainerWidth();
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f = (float) (layoutParams.topMargin + layoutParams.bottomMargin);
        float measuredHeight = (float) view.getMeasuredHeight();
        if (carousel.isHorizontal()) {
            f = (float) (layoutParams.leftMargin + layoutParams.rightMargin);
            measuredHeight = (float) view.getMeasuredWidth();
        }
        float f2 = f;
        float smallItemSizeMin = getSmallItemSizeMin() + f2;
        float max = Math.max(getSmallItemSizeMax() + f2, smallItemSizeMin);
        float min = Math.min(measuredHeight + f2, containerHeight);
        float w = C1354qp.w((measuredHeight / 3.0f) + f2, smallItemSizeMin + f2, max + f2);
        float f3 = (min + w) / 2.0f;
        int[] iArr = SMALL_COUNTS;
        if (containerHeight < 2.0f * smallItemSizeMin) {
            iArr = new int[]{0};
        }
        int[] iArr2 = MEDIUM_COUNTS;
        if (carousel.getCarouselAlignment() == 1) {
            iArr = CarouselStrategy.doubleCounts(iArr);
            iArr2 = CarouselStrategy.doubleCounts(iArr2);
        }
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        int ceil = (int) Math.ceil((double) (containerHeight / min));
        int max2 = (ceil - ((int) Math.max(1.0d, Math.floor((double) (((containerHeight - (((float) CarouselStrategyHelper.maxValue(iArr4)) * f3)) - (((float) CarouselStrategyHelper.maxValue(iArr3)) * max)) / min))))) + 1;
        int[] iArr5 = new int[max2];
        for (int i = 0; i < max2; i++) {
            iArr5[i] = ceil - i;
        }
        float f4 = f2;
        Arrangement findLowestCostArrangement = Arrangement.findLowestCostArrangement(containerHeight, w, smallItemSizeMin, max, iArr3, f3, iArr4, min, iArr5);
        this.keylineCount = findLowestCostArrangement.getItemCount();
        if (ensureArrangementFitsItemCount(findLowestCostArrangement, carousel.getItemCount())) {
            findLowestCostArrangement = Arrangement.findLowestCostArrangement(containerHeight, w, smallItemSizeMin, max, new int[]{findLowestCostArrangement.smallCount}, f3, new int[]{findLowestCostArrangement.mediumCount}, min, new int[]{findLowestCostArrangement.largeCount});
        }
        return CarouselStrategyHelper.createKeylineState(view.getContext(), f4, containerHeight, findLowestCostArrangement, carousel.getCarouselAlignment());
    }

    public boolean shouldRefreshKeylineState(Carousel carousel, int i) {
        if ((i >= this.keylineCount || carousel.getItemCount() < this.keylineCount) && (i < this.keylineCount || carousel.getItemCount() >= this.keylineCount)) {
            return false;
        }
        return true;
    }
}
