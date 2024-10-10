package com.aston.hm1.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {
    private List<Integer> list;

    @BeforeEach
    void setUp() {
        list = new MyArrayList<>();
    }

    @Test
    void addOneNumberTest() {
        assertEquals(0, list.size());
        list.add(1);
        assertEquals(1, list.size());
    }

    @Test
    void addTwoNumberTest() {
        assertEquals(0, list.size());
        list.add(1);
        list.add(2);
        assertEquals(2, list.size());
    }

    @Test
    void addElevenNumberTest() {
        assertEquals(0, list.size());
        for (int i = 0; i <= 10; i++) {
            list.add(i);
        }
        assertEquals(11, list.size());
    }

    @Test
    void addToStartTest() {
        list.add(1);
        assertEquals(1, list.size());
        list.add(0, 2);
        assertEquals(2, list.size());
        assertEquals(2, list.get(0));
    }

    @Test
    void addIndexOutOfBoundsExceptionTest() {
        list.add(1);
        assertEquals(1, list.size());
        IndexOutOfBoundsException ex = assertThrows(
                IndexOutOfBoundsException.class,
                () -> list.add(1,2));
        assertEquals("Index 1 out of bounds for length 1", ex.getMessage());
    }

    @Test
    void addToMediumTest() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(6);
        assertEquals(5, list.size());
        list.add(3, 4);
        assertEquals(6, list.size());
        assertEquals(3, list.get(2));
        assertEquals(4, list.get(3));
        assertEquals(5, list.get(4));
        assertEquals(6, list.get(5));
    }

    @Test
    void getNormalTest() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(6);
        assertEquals(5, list.size());
        assertEquals(5, list.get(3));
    }

    @Test
    void getIndexOutOfBoundsExceptionTest() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(6);
        assertEquals(5, list.size());
        IndexOutOfBoundsException ex = assertThrows(
                IndexOutOfBoundsException.class,
                () -> list.get(10)
        );
        assertEquals("Index 10 out of bounds for length 5", ex.getMessage());
    }

    @Test
    void setNormalTest() {
        list.add(1);
        list.add(2);
        assertEquals(2, list.size());
        list.set(0, 5);
        assertEquals(5, list.get(0));
    }

    @Test
    void setIndexOutOfBoundsExceptionTest() {
        list.add(1);
        IndexOutOfBoundsException ex = assertThrows(
                IndexOutOfBoundsException.class,
                () -> list.set(1, 20));
        assertEquals("Index 1 out of bounds for length 1", ex.getMessage());
    }

    @Test
    void clearTest() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(6);
        assertEquals(5, list.size());
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    void removeNormalTest() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        assertEquals(6, list.size());
        list.remove(0);
        assertEquals(5,list.size());
        assertEquals(2, list.get(0));
        assertEquals(6, list.get(4));
    }

    @Test
    void removeIndexOutOfBoundsExceptionTest() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        assertEquals(6, list.size());
        IndexOutOfBoundsException ex = assertThrows(
                IndexOutOfBoundsException.class,
                () -> list.remove(10)
        );
        assertEquals("Index 10 out of bounds for length 6", ex.getMessage());
    }
}