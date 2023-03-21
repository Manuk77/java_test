package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortingMethodsTest {
    SortingMethods sort = new SortingMethods();
    @Test
    void quickSortTest() {

        int[] arr = new int[]{5, 3, 2, 4, 5, 6, 7, 8, 0};
        int[] arrRes = new int[]{0, 2, 3, 4, 5, 5, 6, 7, 8};
        sort.quickSort(arr, 0, arr.length - 1);
        assertArrayEquals(arrRes,arr);
    }

    @Test
    void babbleSortTest() {

        int[] arr = new int[]{5, 3, 2, 4, 5, 6, 7, 8, 0};
        int[] arrRes = new int[]{0, 2, 3, 4, 5, 5, 6, 7, 8};
        assertArrayEquals(arrRes, sort.babbleSort(arr));

    }

    @Test
    void selectionSortTest() {

        int[] arr = new int[]{5, 3, 2, 4, 5, 6, 7, 8, 0};
        int[] arrRes = new int[]{0, 2, 3, 4, 5, 5, 6, 7, 8};
        assertArrayEquals(arrRes, sort.selectionSort(arr));

    }

    @Test
    void insertionSortTest() {

        int[] arr = new int[]{5, 3, 2, 4, 5, 6, 7, 8, 0};
        int[] arrRes = new int[]{0, 2, 3, 4, 5, 5, 6, 7, 8};
        assertArrayEquals(arrRes, sort.insertionSort(arr));

    }


}