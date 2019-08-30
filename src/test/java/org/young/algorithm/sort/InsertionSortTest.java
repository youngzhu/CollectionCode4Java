package org.young.algorithm.sort;

import org.junit.Test;

import org.young.util.CollectionUtil;

public class InsertionSortTest {
    //~ Instance fields ********************************************************

    private Integer[] arr = new Integer[] {
            5,
            2,
            4,
            6,
            1,
            3
        };

    //~ Methods ****************************************************************

    @Test
    public void testSortByAsc() {
        InsertionSort.sortByAsc(arr);
        CollectionUtil.printArray(arr);
    }


    @Test
    public void testSortByDesc() {
        InsertionSort.sortByDesc(arr);
        CollectionUtil.printArray(arr);
    }
}
