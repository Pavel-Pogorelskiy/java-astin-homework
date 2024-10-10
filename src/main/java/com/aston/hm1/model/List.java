package com.aston.hm1.model;

/**
 <p>The custom {@code List} with limited functionality.
 * An ordered list that allows duplicate elements and multiple null elements.
 * With this interface, user has to control over where in the list each item is inserted.
 * The user can access elements by their integer index (position in the list).
 *
 * <p>The {@code List} interface as {@code List} interface provides two methods to
 * insert: {@code add, set}, one method to get element: {@code get} and one method to
 * remove element: {@code remove}.
 *
 * <p>In addition the {@code Listable} interface contains methods for clearing
 * the list: {@code clear} and checking size: {@code size}.
 *
 * @param <E> the type of elements in this list
 * @author Pavel Pogorelskiy
 * @see MyArrayList
 * @see Sorts
 */
public interface List<E> {

    /**
     Appends the specified element to the end of this list.
     * @param e element to be appended to this list
     * @return {@code true}
     */
    public boolean add(E e);

    /**
     Inserts the specified element at the specified position in this
     * list. Shifts the element currently at that position (if any) and
     * any subsequent elements to the right (adds one to their indices).
     *
     *  @param index index at which the specified element is to be inserted
     *  @param e element to be inserted
     *  @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size())
     */
    public boolean add(int index, E e);

    /**
     * Returns the element at the specified position in this list.
     *
     * @param  index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    public E get(int index);

    /**
     /**
     * Replaces the element at the specified position in this list with
     * the specified element.
     *
     * @param index index of the element to replace
     * @param elementUpdate element to be stored at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    public void set(int index, E elementUpdate);

    /**
     * Removes all of the elements from this list.  The list will
     *  be empty after this call returns.
     */
    public void clear();

    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left (subtracts one from their
     * indices).
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size()
     */
    public boolean remove(int index);

    /**
     * Return the number of elements in this list
     * @return the number of elements in this list
     */
    public int size();

}
