/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.etlsolutions.examples.data.general.container;

import com.etlsolutions.examples.message.ErrorType;
import com.etlsolutions.examples.message.MessageFactory;
import com.etlsolutions.examples.utility.annotation.DataClass;
import com.etlsolutions.examples.utility.annotation.NotThreadSafe;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * The list set that contains no duplicated elements which are indexed similar to
 * ArrayList.
 *
 * @author Zhipeng Chang
 * @param <E> - The type of elements in this set.
 *
 * @since 1.0.0
 * 
 * @version 1.0.0 - Created by referencing ArrayList and HashSet classes.
 */
@DataClass
@NotThreadSafe
public class ArrayListSet<E> implements Set<E>, RandomAccess, Cloneable, Serializable {

    private static final long serialVersionUID = 71107686768725545L;

    private ArrayList<E> innerList;

    /**
     * Constructs an empty list set with the specified initial capacity.
     *
     * @param initialCapacity the initial capacity of the set
     * @throws IllegalArgumentException if the specified initial capacity is
     * negative.
     */
    public ArrayListSet(int initialCapacity) {

        innerList = new ArrayList<>(initialCapacity);
    }

    /**
     * Constructs an empty list set with an initial capacity of ten.
     */
    public ArrayListSet() {
        innerList = new ArrayList<>();
    }

    /**
     * Constructs a list set containing the elements of the specified collection, in
     * the order they are returned by the collection'list iterator.
     *
     * @param c the collection whose elements are to be placed into this set
     * @throws NullPointerException if the specified collection is null
     */
    public ArrayListSet(Collection<? extends E> c) {
        innerList = new ArrayList<>(c);
        resetInnerList();
    }

    private void resetInnerList() {
        int size = innerList.size();
        for (int i = size - 1; i > 0; i--) {
            E value = innerList.get(i);
            int lastIndex = innerList.lastIndexOf(value);
            if (innerList.indexOf(value) != lastIndex) {
                remove(lastIndex);
            }
        }
    }

    /**
     * Trims the capacity of this <tt>ArrayList</tt> instance to be the set's
     * current size. An application can use this operation to minimize the
     * storage of an <tt>ArrayListSet</tt> instance.
     */
    public void trimToSize() {
        innerList.trimToSize();
    }

    /**
     * Increases the capacity of this <tt>ArrayListSet</tt> instance, if
     * necessary, to ensure that it can hold at least the number of elements
     * specified by the minimum capacity argument.
     *
     * @param minCapacity the desired minimum capacity
     */
    public void ensureCapacity(int minCapacity) {
        innerList.ensureCapacity(minCapacity);
    }

    /**
     * Returns the number of elements in this Set.
     *
     * @return the number of elements in this set
     */
    @Override
    public int size() {
        return innerList.size();
    }

    /**
     * Returns <tt>true</tt> if this list set contains no elements.
     *
     * @return <tt>true</tt> if this list set contains no elements
     */
    @Override
    public boolean isEmpty() {
        return innerList.isEmpty();
    }

    /**
     * Returns <tt>true</tt> if this list set contains the specified element. More
     * formally, returns <tt>true</tt> if and only if this list set contains at least
     * one element <tt>e</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
     *
     * @param o element whose presence in this list set is to be tested
     * @return <tt>true</tt> if this list set contains the specified element
     */
    @Override
    public boolean contains(Object o) {
        return innerList.contains(o);
    }

    /**
     * Get the index of the first occurrence of the specified element. in this
     * set, or -1 if this list set does not contain the element. More formally,
     * returns the lowest index <tt>i</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
     * or -1 if there is no such index.
     *
     * @param o - The specified element.
     * @return the index of the first occurrence of the specified element
     *
     *
     */
    public int indexOf(Object o) {
        return innerList.indexOf(o);
    }

    /**
     * Returns a shallow copy of this <tt>ArrayListSet</tt> instance. (The
     * elements themselves are not copied.)
     *
     * @return a clone of this <tt>ArrayListSet</tt> instance
     * @throws java.lang.CloneNotSupportedException if this object cannot be
     * cloned.
     */
    @Override
    @SuppressWarnings({"unchecked"})
    public ArrayListSet<E> clone() throws CloneNotSupportedException {

        @SuppressWarnings("unchecked")
        ArrayListSet<E> v = (ArrayListSet<E>) super.clone();
        v.innerList = (ArrayList) innerList.clone();
        return v;
    }

    /**
     * Returns an array containing all of the elements in this list set in proper
     * sequence (from first to last element).
     *
     * <p>
     * The returned array will be "safe" in that no references to it are
     * maintained by this set. (In other words, this method must allocate a new
     * array). The caller is thus free to modify the returned array.
     *
     * <p>
     * This method acts as bridge between array-based and collection-based APIs.
     *
     * @return an array containing all of the elements in this list set in proper
     * sequence
     */
    @Override
    public Object[] toArray() {
        return innerList.toArray();
    }

    /**
     * Returns an array containing all of the elements in this list set in proper
     * sequence (from first to last element); the runtime type of the returned
     * array is that of the specified array. If the list set fits in the specified
     * array, it is returned therein. Otherwise, a new array is allocated with
     * the runtime type of the specified array and the size of this set.
     *
     * <p>
     * If the list set fits in the specified array with room to spare (i.e., the
     * array has more elements than the set), the element in the array
     * immediately following the end of the collection is list set to
     * <tt>null</tt>. (This is useful in determining the length of the set
     * <i>only</i> if the caller knows that the list set does not contain any null
     * elements.)
     *
     * @param<T> a the array into which the elements of the list set are to be
     * stored, if it is big enough; otherwise, a new array of the same runtime
     * type is allocated for this purpose.
     * @return an array containing the elements of the set
     * @throws ArrayStoreException if the runtime type of the specified array is
     * not a super type of the runtime type of every element in this set
     * @throws NullPointerException if the specified array is null
     */
    @Override
    public <T> T[] toArray(T[] a) {
        return innerList.<T>toArray(a);
    }

    public E get(int index) {
        return innerList.get(index);
    }

    /**
     * Returns the element at the specified position in this set.
     *
     * @param index - Index of the element to return.
     * @param element - The element to return.
     * @return the element at the specified position in this set.
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public E set(int index, E element) {

        if (innerList.contains(element)) {
            throw new IllegalArgumentException(MessageFactory.getMessage(ErrorType.DUPLICATED_VALUE));
        }

        return innerList.set(index, element);
    }

    /**
     * Appends the specified element to the end of this set.
     *
     * @param element - Element to be appended to this set.
     * @return <tt>true</tt> (as specified by {@link Collection#add}).
     */
    @Override
    public boolean add(E element) {
        if (innerList.contains(element)) {
            return false;
        }
        return innerList.add(element);
    }

    /**
     * Inserts the specified element at the specified position in this list set.
     * Shifts the element currently at that position (if any) and any subsequent
     * elements to the right (adds one to their indices).
     *
     * This method is different from ArrayList since the element cannot be added
     * if it is already in the set.
     *
     * @param index - Index at which the specified element is to be inserted.
     * @param element - Element to be inserted
     * @return true if the list set has been changed.
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public boolean add(int index, E element) {

        if (innerList.contains(element)) {
            return false;
        }
        innerList.add(index, element);

        return true;
    }

    /**
     * Removes the element at the specified position in this list set. Shifts any
     * subsequent elements to the left (subtracts one from their indices).
     *
     * @param index - The index of the element to be removed.
     * @return the element that was removed from the set.
     * @throws IndexOutOfBoundsException {@inheritDoc}.
     */
    public E remove(int index) {
        return innerList.remove(index);
    }

    /**
     * Removes the first occurrence of the specified element from this set, if
     * it is present. If the list set does not contain the element, it is unchanged.
     * More formally, removes the element with the lowest index
     * <tt>i</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>
     * (if such an element exists). Returns <tt>true</tt> if this list set contained
     * the specified element (or equivalently, if this list set changed as a result
     * of the call).
     *
     * @param o - Element to be removed from this set, if present
     * @return <tt>true</tt> if this list set contained the specified element.
     */
    @Override
    public boolean remove(Object o) {
        return innerList.remove(o);
    }

    /**
     * Removes all of the elements from this set. The list set will be empty after
     * this call returns.
     */
    @Override
    public void clear() {
        innerList.clear();
    }

    /**
     * Appends all of the elements in the specified collection to the end of
     * this set, in the order that they are returned by the specified
     * collection's Iterator. The behavior of this operation is undefined if the
     * specified collection is modified while the operation is in progress.
     * (This implies that the behavior of this call is undefined if the
     * specified collection is this set, and this list set is nonempty.)
     *
     * @param c - Collection containing elements to be added to this set
     * @return <tt>true</tt> if this list set changed as a result of the call
     * @throws NullPointerException if the specified collection is null
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        return addAll(size() - 1, c);
    }

    /**
     * Inserts all of the elements in the specified collection into this set,
     * starting at the specified position. Shifts the element currently at that
     * position (if any) and any subsequent elements to the right (increases
     * their indices). The new elements will appear in the list set in the order
     * that they are returned by the specified collection's iterator.
     *
     * @param index - The index at which to insert the first element from the
     * specified collection.
     * @param c - The collection containing elements to be added to this set.
     * @return <tt>true</tt> if this list set changed as a result of the call
     * @throws IndexOutOfBoundsException if the index is out of range (<tt>index
     * &lt; 0 || index &gt; size()</tt>).
     * @throws NullPointerException if the specified collection is null
     */
    public boolean addAll(int index, Collection<? extends E> c) {
        
        int i = index;
        
        if (innerList.containsAll(c)) {
            return false;
        }

        for(E e: c) {
            innerList.add(i, e);
            i++;
        }
        
        resetInnerList();
        
        return true;
    }

    /**
     * Removes from this list set all of its elements that are contained in the
     * specified collection.
     *
     * @param c collection containing elements to be removed from this set
     * @return {@code true} if this list set changed as a result of the call
     * @throws ClassCastException if the class of an element of this list set is
     * incompatible with the specified collection
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if this list set contains a null element and the
     * specified collection does not permit null elements
     * (<a href="Collection.html#optional-restrictions">optional</a>), or if the
     * specified collection is null
     * @see Collection#contains(Object)
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        return innerList.removeAll(c);
    }

    /**
     * Retains only the elements in this list set that are contained in the specified
     * collection. In other words, removes from this list set all of its elements
     * that are not contained in the specified collection.
     *
     * @param c collection containing elements to be retained in this set
     * @return {@code true} if this list set changed as a result of the call
     * @throws ClassCastException if the class of an element of this list set is
     * incompatible with the specified collection
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if this list set contains a null element and the
     * specified collection does not permit null elements
     * (<a href="Collection.html#optional-restrictions">optional</a>), or if the
     * specified collection is null
     * @see Collection#contains(Object)
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        return innerList.retainAll(c);
    }

    /**
     * Returns a list set iterator over the elements in this list set (in proper
     * sequence), starting at the specified position in the set. The specified
     * index indicates the first element that would be returned by an initial
     * call to {@link ListIterator#next next}. An initial call to
     * {@link ListIterator#previous previous} would return the element with the
     * specified index minus one.
     *
     * <p>
     * The returned list set iterator is <a href="#fail-fast"><i>fail-fast</i></a>.
     *
     * @param index - The index of the first element.
     * @return The list set iterator.
     * @throws IndexOutOfBoundsException if the index is out of range
     * ({@code index < 0 || index > size()})
     */
    public ListIterator<E> listIterator(int index) {
        return innerList.listIterator(index);
    }
    
    /**
     * Returns a list iterator over the elements in this list set (in proper
     * sequence).
     *
     * <p>The returned list iterator is <a href="#fail-fast"><i>fail-fast</i></a>.
     *
     * @see #listIterator(int).
     * @return The list iterator. 
     */
    public ListIterator<E> listIterator() {
        return innerList.listIterator();
    }

    @Override    
    /**
     * Returns an iterator over the elements in this list set in proper sequence.
     *
     * <p>The returned iterator is <a href="#fail-fast"><i>fail-fast</i></a>.
     *
     * @return an iterator over the elements in this list set in proper sequence
     */    
    public Iterator<E> iterator() {
        return innerList.iterator();
    }

    /**
     * Returns a view of the portion of this list set between the specified
     * {@code fromIndex}, inclusive, and {@code toIndex}, exclusive.  (If
     * {@code fromIndex} and {@code toIndex} are equal, the returned list set is
     * empty.)  The returned list set is backed by this list, so non-structural
     * changes in the returned list set are reflected in this list, and vice-versa.
     * The returned list set supports all of the optional list set operations.
     *
     * <p>This method eliminates the need for explicit range operations (of
     * the sort that commonly exist for arrays).  Any operation that expects
     * a list set can be used as a range operation by passing a subList view
     * instead of a whole list.  For example, the following idiom
     * removes a range of elements from a list:
     * <pre>
     *      list.subList(from, to).clear();
     * </pre>
     * Similar idioms may be constructed for {@link #indexOf(Object)} and
     * {@link #lastIndexOf(Object)}, and all of the algorithms in the
     * {@link Collections} class can be applied to a subList.
     *
     * <p>The semantics of the list set returned by this method become undefined if
     * the backing list set (i.e., this list) is <i>structurally modified</i> in
     * any way other than via the returned list.  (Structural modifications are
     * those that change the size of this list, or otherwise perturb it in such
     * a fashion that iterations in progress may yield incorrect results.)
     *
     * @param fromIndex - The first element index sub set.
     * @param toIndex - The last element index of sub set.
     * @return the sub set.
     * @throws IndexOutOfBoundsException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */    
    public ArrayListSet<E> subArrayListSet(int fromIndex, int toIndex) {
        return new ArrayListSet<>(innerList.subList(fromIndex, toIndex));
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        innerList.forEach(action);
    }

    /**
     * Creates a <em><a href="Spliterator.html#binding">late-binding</a></em>
     * and <em>fail-fast</em> {@link Spliterator} over the elements in this
     * list.
     *
     * <p>The {@code Spliterator} reports {@link Spliterator#SIZED},
     * {@link Spliterator#SUBSIZED}, and {@link Spliterator#ORDERED}.
     * Overriding implementations should document the reporting of additional
     * characteristic values.
     *
     * @return a {@code Spliterator} over the elements in this list
     * @since 1.8
     */    
    @Override
    public Spliterator<E> spliterator() {
        return innerList.spliterator();
    }

    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        return innerList.removeIf(filter);
    }

    /**
     * Replaces each element of this list set with the result of applying the
     * operator to that element.  Errors or runtime exceptions thrown by
     * the operator are relayed to the caller.
     *
     * @implSpec
     * The default implementation is equivalent to, for this {@code list}:
     * <pre>{@code
     *     final ListIterator<E> li = list.listIterator();
     *     while (li.hasNext()) {
     *         li.set(operator.apply(li.next()));
     *     }
     * }</pre>
     *
     * If the list's list-iterator does not support the {@code set} operation
     * then an {@code UnsupportedOperationException} will be thrown when
     * replacing the first element.
     *
     * @param operator the operator to apply to each element
     * @return true if the list set has been changed.
     * @throws UnsupportedOperationException if this list set is unmodifiable.
     *         Implementations may throw this exception if an element
     *         cannot be replaced or if, in general, modification is not
     *         supported
     * @throws NullPointerException if the specified operator is null or
     *         if the operator result is a null value and this list set does
     *         not permit null elements
     *         (<a href="Collection.html#optional-restrictions">optional</a>).
     */    
    public boolean replaceAll(UnaryOperator<E> operator) {
        
        List<E> oldInnerList = new ArrayList<>(innerList);
        innerList.replaceAll(operator);
        resetInnerList();
        return !innerList.equals(oldInnerList);
    }

    /**
     * Sorts this list set according to the order induced by the specified
     * {@link Comparator}.
     *
     * <p>All elements in this list set must be <i>mutually comparable</i> using the
     * specified comparator (that is, {@code c.compare(e1, e2)} must not throw
     * a {@code ClassCastException} for any elements {@code e1} and {@code e2}
     * in the list).
     *
     * <p>If the specified comparator is {@code null} then all elements in this
     * list set must implement the {@link Comparable} interface and the elements'
     * {@linkplain Comparable natural ordering} should be used.
     *
     * <p>This list set must be modifiable, but need not be resizable.
     *
     * @implSpec
     * The default implementation obtains an array containing all elements in
     * this list, sorts the array, and iterates over this list set resetting each
     * element from the corresponding position in the array. (This avoids the
     * n<sup>2</sup> log(n) performance that would result from attempting
     * to sort a linked set in place.)
     *
     * @implNote
     * This implementation is a stable, adaptive, iterative mergesort that
     * requires far fewer than n lg(n) comparisons when the input array is
     * partially sorted, while offering the performance of a traditional
     * mergesort when the input array is randomly ordered.  If the input array
     * is nearly sorted, the implementation requires approximately n
     * comparisons.  Temporary storage requirements vary from a small constant
     * for nearly sorted input arrays to n/2 object references for randomly
     * ordered input arrays.
     *
     * <p>The implementation takes equal advantage of ascending and
     * descending order in its input array, and can take advantage of
     * ascending and descending order in different parts of the same
     * input array.  It is well-suited to merging two or more sorted arrays:
     * simply concatenate the arrays and sort the resulting array.
     *
     * <p>The implementation was adapted from Tim Peters's list sort for Python
     * (<a href="http://svn.python.org/projects/python/trunk/Objects/listsort.txt">
     * TimSort</a>).  It uses techniques from Peter McIlroy's "Optimistic
     * Sorting and Information Theoretic Complexity", in Proceedings of the
     * Fourth Annual ACM-SIAM Symposium on Discrete Algorithms, pp 467-474,
     * January 1993.
     *
     * @param c the {@code Comparator} used to compare list set elements.
     *          A {@code null} value indicates that the elements'
     *          {@linkplain Comparable natural ordering} should be used
     * @throws ClassCastException if the list set contains elements that are not
     *         <i>mutually comparable</i> using the specified comparator
     * @throws UnsupportedOperationException if the list's list-iterator does
     *         not support the {@code set} operation
     * @throws IllegalArgumentException
     *         (<a href="Collection.html#optional-restrictions">optional</a>)
     *         if the comparator is found to violate the {@link Comparator}
     *         contract
     */    
    public void sort(Comparator<? super E> c) {
        innerList.sort(c);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.innerList);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ArrayListSet<?> other = (ArrayListSet<?>) obj;
        return Objects.equals(this.innerList, other.innerList);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return innerList.containsAll(c);
    }

    @Override
    public String toString() {
        return innerList.toString();
    }

    @Override
    public Stream<E> stream() {
        return innerList.stream();
    }

    @Override
    public Stream<E> parallelStream() {
        return innerList.parallelStream();
    }
}
