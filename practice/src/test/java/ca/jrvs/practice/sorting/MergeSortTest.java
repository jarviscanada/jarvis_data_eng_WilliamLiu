package ca.jrvs.practice.sorting;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class MergeSortTest {

  @Test
  public void mergeSort() {
    MergeSort quickSort = new MergeSort();
    int[] arr = {-3, 43, -456, -54, 366, 564564, 2515};
    int[] expected = {-456, -54, -3, 43, 366, 2515, 564564};
    quickSort.mergeSort(arr, arr.length);
    assertArrayEquals(expected, arr);
  }
}
