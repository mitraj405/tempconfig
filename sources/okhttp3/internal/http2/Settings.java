package okhttp3.internal.http2;

import java.util.Arrays;

public final class Settings {
    static final int COUNT = 10;
    static final int DEFAULT_INITIAL_WINDOW_SIZE = 65535;
    static final int ENABLE_PUSH = 2;
    static final int HEADER_TABLE_SIZE = 1;
    static final int INITIAL_WINDOW_SIZE = 7;
    static final int MAX_CONCURRENT_STREAMS = 4;
    static final int MAX_FRAME_SIZE = 5;
    static final int MAX_HEADER_LIST_SIZE = 6;
    private int set;
    private final int[] values = new int[10];

    public void clear() {
        this.set = 0;
        Arrays.fill(this.values, 0);
    }

    public int get(int i) {
        return this.values[i];
    }

    public boolean getEnablePush(boolean z) {
        int i;
        if ((this.set & 4) != 0) {
            i = this.values[2];
        } else if (z) {
            i = 1;
        } else {
            i = 0;
        }
        if (i == 1) {
            return true;
        }
        return false;
    }

    public int getHeaderTableSize() {
        if ((this.set & 2) != 0) {
            return this.values[1];
        }
        return -1;
    }

    public int getInitialWindowSize() {
        if ((this.set & 128) != 0) {
            return this.values[7];
        }
        return DEFAULT_INITIAL_WINDOW_SIZE;
    }

    public int getMaxConcurrentStreams(int i) {
        if ((this.set & 16) != 0) {
            return this.values[4];
        }
        return i;
    }

    public int getMaxFrameSize(int i) {
        if ((this.set & 32) != 0) {
            return this.values[5];
        }
        return i;
    }

    public int getMaxHeaderListSize(int i) {
        if ((this.set & 64) != 0) {
            return this.values[6];
        }
        return i;
    }

    public boolean isSet(int i) {
        if (((1 << i) & this.set) != 0) {
            return true;
        }
        return false;
    }

    public void merge(Settings settings) {
        for (int i = 0; i < 10; i++) {
            if (settings.isSet(i)) {
                set(i, settings.get(i));
            }
        }
    }

    public Settings set(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.values;
            if (i < iArr.length) {
                this.set = (1 << i) | this.set;
                iArr[i] = i2;
            }
        }
        return this;
    }

    public int size() {
        return Integer.bitCount(this.set);
    }
}
