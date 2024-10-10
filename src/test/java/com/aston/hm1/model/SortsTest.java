package com.aston.hm1.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class SortsTest {
    private List<Integer> list;
    private List<String> listString;

    @BeforeEach
    void setUp() {
        list = new MyArrayList<>();
    }

    @Test
    void sortTest() {
        list.add(10);
        list.add(5);
        list.add(2);
        list.add(8);
        list.add(3);
        list.add(1);
        list.add(11);
        list.add(25);
        list.add(6);
        Sorts.sort(list);
        List<Integer> expected = new MyArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(5);
        expected.add(6);
        expected.add(8);
        expected.add(10);
        expected.add(11);
        expected.add(25);
        assertEquals(expected.get(0), list.get(0));
        assertEquals(expected.get(1), list.get(1));
        assertEquals(expected.get(2), list.get(2));
        assertEquals(expected.get(3), list.get(3));
        assertEquals(expected.get(4), list.get(4));
        assertEquals(expected.get(5), list.get(5));
        assertEquals(expected.get(6), list.get(6));
        assertEquals(expected.get(7), list.get(7));
        assertEquals(expected.get(8), list.get(8));
    }

    @Test
    void testSort() {
        listString = new MyArrayList<>();
        listString.add("BMW");
        listString.add("Mercedes-Benz");
        listString.add("Audi");
        listString.add("Porshe");
        listString.add("Lada");
        listString.add("Cherry");
        listString.add("Mustang");
        Sorts.sort(listString, Comparator.comparingInt(String::length).thenComparing(o -> o));
        assertEquals("BMW", listString.get(0));
        assertEquals("Audi", listString.get(1));
        assertEquals("Lada", listString.get(2));
        assertEquals("Cherry", listString.get(3));
        assertEquals("Porshe", listString.get(4));
        assertEquals("Mustang", listString.get(5));
        assertEquals("Mercedes-Benz", listString.get(6));
    }
}