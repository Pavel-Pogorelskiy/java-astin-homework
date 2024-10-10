package com.aston.hm1.model;

import java.util.Objects;

/**
 *<p>The custom {@code ArrayList} with limited functionality - resizable-array
 *  implementation of the {@code List} interface ({@code List} analog).
 *  Implements all listable operations and permits all elements, including null.
 *  <p><strong>The class is not synchronized.</strong>
 *
 *  <p>Each {@code ObjectList} instance as in {@code ArrayList}, has <i>size</i>
 *  and <i>capacity</i>. The size is the number of elements in the list.
 *  The capacity is the size of the array used to store the elements in the list.
 *  It is always at least as large as the list size. Capacity is automatically increased
 *  when items are added to the {@code MyArrayList} or the size is equal to the capacity.
 *
 *  In addition {@code MyArrayList} can be sorted using {@code Sorts} class.
 *
 *  @param <E> the type of elements in this list
 *  @author Pogorelskiy Pavel
 *  @see List
 *  @see Sorts
 */
public class MyArrayList<E> implements List<E> {
    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * Empty initial capacity
     */
    private static final int EMPTY_CAPACITY = 0;
    /**
     * Empty size MyArrayList
     */
    private static final int EMPTY_SIZE = 0;
    /**
     * Shared empty array instance used for empty instances
     */
    private static final Object[] EMPTY_ELEMENT_DATA = {};
    /**
     * The array buffer into which the elements of the MyArrayList are stored.
     * The capacity of the MyArrayList is the length of this array buffer. Any
     * empty MyArrayList with elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA
     *  will be expanded to DEFAULT_CAPACITY when the first element is added.
     */
    transient Object[] elementData;
    /**
     * The capacity of the MyArrayList
     */
    private int capacity;
    /**
     * The size of the MyArrayList (the number of elements it contains).
     */
    private int size;

    /**
     * Constructs an empty list with an initial capacity of ten.
     */
    public MyArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
    }

    /**
     * Constructs an empty list with the specified initial capacity.
     * Params:
     * @param initialCapacity – the initial capacity of the list
     * Throws:
     * @throws IllegalArgumentException – if the specified initial capacity is negative
     */
    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            elementData = new Object[initialCapacity];
            capacity = initialCapacity;
        } else if (initialCapacity == 0) {
            elementData = EMPTY_ELEMENT_DATA;
            capacity = EMPTY_CAPACITY;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "
                    + initialCapacity);
        }
    }

    /**
     Appends the specified element to the end of this list.
     * @param e element to be appended to this list
     * @return {@code true}
     */
    @Override
    public boolean add(E e) {
        if (capacity == 0) {
            capacity = DEFAULT_CAPACITY;
        }
        if (size == capacity) {
            if (capacity <= Integer.MAX_VALUE) {
                Object[] newElementData = increasedCapacity(capacity);
                System.arraycopy(elementData, 0, newElementData, 0, size);
                elementData = newElementData;
            } else {
                throw new IllegalArgumentException("Capacity limit max");
            }
        }
        elementData[size++] = e;
        return true;
    }

    /**
     * Inserts the specified element at the specified position in this
     * list. Shifts the element currently at that position (if any) and
     * any subsequent elements to the right (adds one to their indices).
     *
     *  @param index index at which the specified element is to be inserted
     *  @param e element to be inserted
     *  @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size())
     */
    @Override
    public boolean add(int index, E e) {
        Objects.checkIndex(index, size);
        Object[] newElementData = new Object[capacity];
        if (size == capacity) {
            newElementData = increasedCapacity(capacity);
        }
        System.arraycopy(elementData, 0, newElementData, 0, index);
        newElementData[index] = e;
        System.arraycopy(elementData, index, newElementData, index + 1,
                size - index);
        elementData = newElementData;
        size++;
        return true;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param  index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        return (E) elementData[index];
    }

    /**
     * Replaces the element at the specified position in this list with
     * the specified element.
     *
     * @param index index of the element to replace
     * @param elementUpdate element to be stored at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    @Override
    public void set(int index, E elementUpdate) {
        Objects.checkIndex(index, size);
        E oldElement = (E) elementData[index];
        elementData[index] = elementUpdate;
    }

    /**
     * Removes all of the elements from this list.  The list will
     *  be empty after this call returns.
     */
    @Override
    public void clear() {
        elementData = new Object[capacity];
        size = EMPTY_SIZE;
    }

    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left (subtracts one from their
     * indices).
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size()
     */
    @Override
    public boolean remove(int index) {
        Objects.checkIndex(index, size);
        Object[] newElementData = new Object[size - 1];
        System.arraycopy(elementData, 0, newElementData, 0, index);
        System.arraycopy(elementData, index + 1, newElementData, index,
                size - index - 1);
        elementData = newElementData;
        size--;
        return true;
    }

    /**
     * Return the number of elements in this list
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    private Object[] increasedCapacity(int oldCapacity) {
        capacity = oldCapacity * 3 / 2 + 1;
        return new Object[capacity];
    }
}
