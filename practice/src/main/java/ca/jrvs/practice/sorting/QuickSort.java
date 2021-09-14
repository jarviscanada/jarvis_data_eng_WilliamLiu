package ca.jrvs.practice.sorting;

public class QuickSort {

  public void quickSort(int[] arr, int start, int end) {
    if (start < end) {
      int pivot = partition(arr, start, end);
      quickSort(arr, start, pivot - 1);
      quickSort(arr, pivot + 1, end);
    }
  }

  private int partition(int[] arr, int start, int end) {
    int pivot = arr[end];
    int i = start;
    for (int j = start; j < end; j++) {
      if (arr[j] <= pivot) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        i++;
      }
    }
    arr[end] = arr[i];
    arr[i] = pivot;
    return i;
  }
}
