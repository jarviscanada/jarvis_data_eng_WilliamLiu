package ca.jrvs.practice.sorting;

public class MergeSort {

  public void mergeSort(int[] a, int length) {
    if (length < 2) {
      return;
    }
    int mid = length / 2;
    int[] l = new int[mid];
    int[] r = new int[length - mid];

    for (int i = 0; i < mid; i++) {
      l[i] = a[i];
    }
    for (int i = mid; i < length; i++) {
      r[i - mid] = a[i];
    }

    mergeSort(l, mid);
    mergeSort(r, length - mid);

    merge(a, l, r, mid, length - mid);
  }

  private void merge(int[] a, int[] l, int[] r, int leftLength, int rightLength) {
    int i = 0, j = 0, k = 0;
    while (i < leftLength && j < rightLength) {
      if (l[i] <= r[j]) {
        a[k++] = l[i++];
      } else {
        a[k++] = r[j++];
      }
    }
    while (i < leftLength) {
      a[k++] = l[i++];
    }
    while (j < rightLength) {
      a[k++] = r[j++];
    }
  }
}
