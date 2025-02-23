package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.base.Ticker;
import com.google.common.cache.AbstractCache;
import com.google.common.cache.LocalCache;
import com.google.errorprone.annotations.CheckReturnValue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class CacheBuilder<K, V> {
    static final Supplier<AbstractCache.StatsCounter> CACHE_STATS_COUNTER = new Supplier<AbstractCache.StatsCounter>() {
        public AbstractCache.StatsCounter get() {
            return new AbstractCache.SimpleStatsCounter();
        }
    };
    private static final int DEFAULT_CONCURRENCY_LEVEL = 4;
    private static final int DEFAULT_EXPIRATION_NANOS = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final int DEFAULT_REFRESH_NANOS = 0;
    static final CacheStats EMPTY_STATS = new CacheStats(0, 0, 0, 0, 0, 0);
    static final Supplier<? extends AbstractCache.StatsCounter> NULL_STATS_COUNTER = Suppliers.ofInstance(new AbstractCache.StatsCounter() {
        public CacheStats snapshot() {
            return CacheBuilder.EMPTY_STATS;
        }

        public void recordEviction() {
        }

        public void recordHits(int i) {
        }

        public void recordLoadException(long j) {
        }

        public void recordLoadSuccess(long j) {
        }

        public void recordMisses(int i) {
        }
    });
    static final Ticker NULL_TICKER = new Ticker() {
        public long read() {
            return 0;
        }
    };
    static final int UNSET_INT = -1;
    private static final Logger logger = Logger.getLogger(CacheBuilder.class.getName());
    int concurrencyLevel = -1;
    long expireAfterAccessNanos = -1;
    long expireAfterWriteNanos = -1;
    int initialCapacity = -1;
    Equivalence<Object> keyEquivalence;
    LocalCache.Strength keyStrength;
    long maximumSize = -1;
    long maximumWeight = -1;
    long refreshNanos = -1;
    RemovalListener<? super K, ? super V> removalListener;
    Supplier<? extends AbstractCache.StatsCounter> statsCounterSupplier = NULL_STATS_COUNTER;
    boolean strictParsing = true;
    Ticker ticker;
    Equivalence<Object> valueEquivalence;
    LocalCache.Strength valueStrength;
    Weigher<? super K, ? super V> weigher;

    public enum OneWeigher implements Weigher<Object, Object> {
        INSTANCE;

        public int weigh(Object obj, Object obj2) {
            return 1;
        }
    }

    private CacheBuilder() {
    }

    private void checkNonLoadingCache() {
        boolean z;
        if (this.refreshNanos == -1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "refreshAfterWrite requires a LoadingCache");
    }

    private void checkWeightWithWeigher() {
        boolean z = true;
        if (this.weigher == null) {
            if (this.maximumWeight != -1) {
                z = false;
            }
            Preconditions.checkState(z, "maximumWeight requires weigher");
        } else if (this.strictParsing) {
            if (this.maximumWeight == -1) {
                z = false;
            }
            Preconditions.checkState(z, "weigher requires maximumWeight");
        } else if (this.maximumWeight == -1) {
            logger.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
        }
    }

    @GwtIncompatible
    @CheckReturnValue
    public static CacheBuilder<Object, Object> from(CacheBuilderSpec cacheBuilderSpec) {
        return cacheBuilderSpec.toCacheBuilder().lenientParsing();
    }

    @CheckReturnValue
    public static CacheBuilder<Object, Object> newBuilder() {
        return new CacheBuilder<>();
    }

    @CheckReturnValue
    public <K1 extends K, V1 extends V> LoadingCache<K1, V1> build(CacheLoader<? super K1, V1> cacheLoader) {
        checkWeightWithWeigher();
        return new LocalCache.LocalLoadingCache(this, cacheLoader);
    }

    public CacheBuilder<K, V> concurrencyLevel(int i) {
        boolean z;
        int i2 = this.concurrencyLevel;
        boolean z2 = true;
        if (i2 == -1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "concurrency level was already set to %s", i2);
        if (i <= 0) {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        this.concurrencyLevel = i;
        return this;
    }

    public CacheBuilder<K, V> expireAfterAccess(long j, TimeUnit timeUnit) {
        boolean z;
        long j2 = this.expireAfterAccessNanos;
        boolean z2 = true;
        if (j2 == -1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "expireAfterAccess was already set to %s ns", j2);
        if (j < 0) {
            z2 = false;
        }
        Preconditions.checkArgument(z2, "duration cannot be negative: %s %s", j, (Object) timeUnit);
        this.expireAfterAccessNanos = timeUnit.toNanos(j);
        return this;
    }

    public CacheBuilder<K, V> expireAfterWrite(long j, TimeUnit timeUnit) {
        boolean z;
        long j2 = this.expireAfterWriteNanos;
        boolean z2 = true;
        if (j2 == -1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "expireAfterWrite was already set to %s ns", j2);
        if (j < 0) {
            z2 = false;
        }
        Preconditions.checkArgument(z2, "duration cannot be negative: %s %s", j, (Object) timeUnit);
        this.expireAfterWriteNanos = timeUnit.toNanos(j);
        return this;
    }

    public int getConcurrencyLevel() {
        int i = this.concurrencyLevel;
        if (i == -1) {
            return 4;
        }
        return i;
    }

    public long getExpireAfterAccessNanos() {
        long j = this.expireAfterAccessNanos;
        if (j == -1) {
            return 0;
        }
        return j;
    }

    public long getExpireAfterWriteNanos() {
        long j = this.expireAfterWriteNanos;
        if (j == -1) {
            return 0;
        }
        return j;
    }

    public int getInitialCapacity() {
        int i = this.initialCapacity;
        if (i == -1) {
            return 16;
        }
        return i;
    }

    public Equivalence<Object> getKeyEquivalence() {
        return (Equivalence) MoreObjects.firstNonNull(this.keyEquivalence, getKeyStrength().defaultEquivalence());
    }

    public LocalCache.Strength getKeyStrength() {
        return (LocalCache.Strength) MoreObjects.firstNonNull(this.keyStrength, LocalCache.Strength.STRONG);
    }

    public long getMaximumWeight() {
        if (this.expireAfterWriteNanos == 0 || this.expireAfterAccessNanos == 0) {
            return 0;
        }
        if (this.weigher == null) {
            return this.maximumSize;
        }
        return this.maximumWeight;
    }

    public long getRefreshNanos() {
        long j = this.refreshNanos;
        if (j == -1) {
            return 0;
        }
        return j;
    }

    public <K1 extends K, V1 extends V> RemovalListener<K1, V1> getRemovalListener() {
        return (RemovalListener) MoreObjects.firstNonNull(this.removalListener, NullListener.INSTANCE);
    }

    public Supplier<? extends AbstractCache.StatsCounter> getStatsCounterSupplier() {
        return this.statsCounterSupplier;
    }

    public Ticker getTicker(boolean z) {
        Ticker ticker2 = this.ticker;
        if (ticker2 != null) {
            return ticker2;
        }
        if (z) {
            return Ticker.systemTicker();
        }
        return NULL_TICKER;
    }

    public Equivalence<Object> getValueEquivalence() {
        return (Equivalence) MoreObjects.firstNonNull(this.valueEquivalence, getValueStrength().defaultEquivalence());
    }

    public LocalCache.Strength getValueStrength() {
        return (LocalCache.Strength) MoreObjects.firstNonNull(this.valueStrength, LocalCache.Strength.STRONG);
    }

    public <K1 extends K, V1 extends V> Weigher<K1, V1> getWeigher() {
        return (Weigher) MoreObjects.firstNonNull(this.weigher, OneWeigher.INSTANCE);
    }

    public CacheBuilder<K, V> initialCapacity(int i) {
        boolean z;
        int i2 = this.initialCapacity;
        boolean z2 = true;
        if (i2 == -1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "initial capacity was already set to %s", i2);
        if (i < 0) {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        this.initialCapacity = i;
        return this;
    }

    public boolean isRecordingStats() {
        if (this.statsCounterSupplier == CACHE_STATS_COUNTER) {
            return true;
        }
        return false;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> keyEquivalence(Equivalence<Object> equivalence) {
        boolean z;
        Equivalence<Object> equivalence2 = this.keyEquivalence;
        if (equivalence2 == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "key equivalence was already set to %s", (Object) equivalence2);
        this.keyEquivalence = (Equivalence) Preconditions.checkNotNull(equivalence);
        return this;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> lenientParsing() {
        this.strictParsing = false;
        return this;
    }

    public CacheBuilder<K, V> maximumSize(long j) {
        boolean z;
        boolean z2;
        boolean z3;
        long j2 = this.maximumSize;
        boolean z4 = true;
        if (j2 == -1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "maximum size was already set to %s", j2);
        long j3 = this.maximumWeight;
        if (j3 == -1) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkState(z2, "maximum weight was already set to %s", j3);
        if (this.weigher == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3, "maximum size can not be combined with weigher");
        if (j < 0) {
            z4 = false;
        }
        Preconditions.checkArgument(z4, "maximum size must not be negative");
        this.maximumSize = j;
        return this;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> maximumWeight(long j) {
        boolean z;
        boolean z2;
        long j2 = this.maximumWeight;
        boolean z3 = true;
        if (j2 == -1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "maximum weight was already set to %s", j2);
        long j3 = this.maximumSize;
        if (j3 == -1) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkState(z2, "maximum size was already set to %s", j3);
        if (j < 0) {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "maximum weight must not be negative");
        this.maximumWeight = j;
        return this;
    }

    public CacheBuilder<K, V> recordStats() {
        this.statsCounterSupplier = CACHE_STATS_COUNTER;
        return this;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> refreshAfterWrite(long j, TimeUnit timeUnit) {
        boolean z;
        Preconditions.checkNotNull(timeUnit);
        long j2 = this.refreshNanos;
        boolean z2 = true;
        if (j2 == -1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "refresh was already set to %s ns", j2);
        if (j <= 0) {
            z2 = false;
        }
        Preconditions.checkArgument(z2, "duration must be positive: %s %s", j, (Object) timeUnit);
        this.refreshNanos = timeUnit.toNanos(j);
        return this;
    }

    @CheckReturnValue
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> removalListener(RemovalListener<? super K1, ? super V1> removalListener2) {
        boolean z;
        if (this.removalListener == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        this.removalListener = (RemovalListener) Preconditions.checkNotNull(removalListener2);
        return this;
    }

    public CacheBuilder<K, V> setKeyStrength(LocalCache.Strength strength) {
        boolean z;
        LocalCache.Strength strength2 = this.keyStrength;
        if (strength2 == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "Key strength was already set to %s", (Object) strength2);
        this.keyStrength = (LocalCache.Strength) Preconditions.checkNotNull(strength);
        return this;
    }

    public CacheBuilder<K, V> setValueStrength(LocalCache.Strength strength) {
        boolean z;
        LocalCache.Strength strength2 = this.valueStrength;
        if (strength2 == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "Value strength was already set to %s", (Object) strength2);
        this.valueStrength = (LocalCache.Strength) Preconditions.checkNotNull(strength);
        return this;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> softValues() {
        return setValueStrength(LocalCache.Strength.SOFT);
    }

    public CacheBuilder<K, V> ticker(Ticker ticker2) {
        boolean z;
        if (this.ticker == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        this.ticker = (Ticker) Preconditions.checkNotNull(ticker2);
        return this;
    }

    public String toString() {
        MoreObjects.ToStringHelper stringHelper = MoreObjects.toStringHelper((Object) this);
        int i = this.initialCapacity;
        if (i != -1) {
            stringHelper.add("initialCapacity", i);
        }
        int i2 = this.concurrencyLevel;
        if (i2 != -1) {
            stringHelper.add("concurrencyLevel", i2);
        }
        long j = this.maximumSize;
        if (j != -1) {
            stringHelper.add("maximumSize", j);
        }
        long j2 = this.maximumWeight;
        if (j2 != -1) {
            stringHelper.add("maximumWeight", j2);
        }
        long j3 = this.expireAfterWriteNanos;
        if (j3 != -1) {
            StringBuilder sb = new StringBuilder(22);
            sb.append(j3);
            sb.append("ns");
            stringHelper.add("expireAfterWrite", (Object) sb.toString());
        }
        long j4 = this.expireAfterAccessNanos;
        if (j4 != -1) {
            StringBuilder sb2 = new StringBuilder(22);
            sb2.append(j4);
            sb2.append("ns");
            stringHelper.add("expireAfterAccess", (Object) sb2.toString());
        }
        LocalCache.Strength strength = this.keyStrength;
        if (strength != null) {
            stringHelper.add("keyStrength", (Object) Ascii.toLowerCase(strength.toString()));
        }
        LocalCache.Strength strength2 = this.valueStrength;
        if (strength2 != null) {
            stringHelper.add("valueStrength", (Object) Ascii.toLowerCase(strength2.toString()));
        }
        if (this.keyEquivalence != null) {
            stringHelper.addValue((Object) "keyEquivalence");
        }
        if (this.valueEquivalence != null) {
            stringHelper.addValue((Object) "valueEquivalence");
        }
        if (this.removalListener != null) {
            stringHelper.addValue((Object) "removalListener");
        }
        return stringHelper.toString();
    }

    @GwtIncompatible
    public CacheBuilder<K, V> valueEquivalence(Equivalence<Object> equivalence) {
        boolean z;
        Equivalence<Object> equivalence2 = this.valueEquivalence;
        if (equivalence2 == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "value equivalence was already set to %s", (Object) equivalence2);
        this.valueEquivalence = (Equivalence) Preconditions.checkNotNull(equivalence);
        return this;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> weakKeys() {
        return setKeyStrength(LocalCache.Strength.WEAK);
    }

    @GwtIncompatible
    public CacheBuilder<K, V> weakValues() {
        return setValueStrength(LocalCache.Strength.WEAK);
    }

    @GwtIncompatible
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> weigher(Weigher<? super K1, ? super V1> weigher2) {
        boolean z;
        boolean z2 = true;
        if (this.weigher == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        if (this.strictParsing) {
            long j = this.maximumSize;
            if (j != -1) {
                z2 = false;
            }
            Preconditions.checkState(z2, "weigher can not be combined with maximum size", j);
        }
        this.weigher = (Weigher) Preconditions.checkNotNull(weigher2);
        return this;
    }

    @GwtIncompatible
    @CheckReturnValue
    public static CacheBuilder<Object, Object> from(String str) {
        return from(CacheBuilderSpec.parse(str));
    }

    @CheckReturnValue
    public <K1 extends K, V1 extends V> Cache<K1, V1> build() {
        checkWeightWithWeigher();
        checkNonLoadingCache();
        return new LocalCache.LocalManualCache(this);
    }

    public enum NullListener implements RemovalListener<Object, Object> {
        INSTANCE;

        public void onRemoval(RemovalNotification<Object, Object> removalNotification) {
        }
    }
}
