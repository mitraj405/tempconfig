package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Deque;
import java.util.Iterator;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingDeque<E> extends ForwardingQueue<E> implements Deque<E> {
    public void addFirst(@ParametricNullness E e) {
        delegate().addFirst(e);
    }

    public void addLast(@ParametricNullness E e) {
        delegate().addLast(e);
    }

    public abstract Deque<E> delegate();

    public Iterator<E> descendingIterator() {
        return delegate().descendingIterator();
    }

    @ParametricNullness
    public E getFirst() {
        return delegate().getFirst();
    }

    @ParametricNullness
    public E getLast() {
        return delegate().getLast();
    }

    @CanIgnoreReturnValue
    public boolean offerFirst(@ParametricNullness E e) {
        return delegate().offerFirst(e);
    }

    @CanIgnoreReturnValue
    public boolean offerLast(@ParametricNullness E e) {
        return delegate().offerLast(e);
    }

    public E peekFirst() {
        return delegate().peekFirst();
    }

    public E peekLast() {
        return delegate().peekLast();
    }

    @CanIgnoreReturnValue
    public E pollFirst() {
        return delegate().pollFirst();
    }

    @CanIgnoreReturnValue
    public E pollLast() {
        return delegate().pollLast();
    }

    @ParametricNullness
    @CanIgnoreReturnValue
    public E pop() {
        return delegate().pop();
    }

    public void push(@ParametricNullness E e) {
        delegate().push(e);
    }

    @ParametricNullness
    @CanIgnoreReturnValue
    public E removeFirst() {
        return delegate().removeFirst();
    }

    @CanIgnoreReturnValue
    public boolean removeFirstOccurrence(Object obj) {
        return delegate().removeFirstOccurrence(obj);
    }

    @ParametricNullness
    @CanIgnoreReturnValue
    public E removeLast() {
        return delegate().removeLast();
    }

    @CanIgnoreReturnValue
    public boolean removeLastOccurrence(Object obj) {
        return delegate().removeLastOccurrence(obj);
    }
}
