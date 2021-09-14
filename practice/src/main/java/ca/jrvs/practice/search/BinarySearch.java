package ca.jrvs.practice.search;

import java.util.Optional;

public class BinarySearch {

  /**
   * find the the target index in a sorted array
   *
   * @param arr    input arry is sorted
   * @param target value to be searched
   * @return target index or Optional.empty() if not found
   */
  public <E> Optional<Integer> binarySearchRecursion(E[] arr, E target) {
    if (arr.length == 0) {
      return Optional.empty();
    }
    return binarySearchRecursive(arr, target, 0, arr.length - 1);
  }

  private <E> Optional<Integer> binarySearchRecursive(E[] arr, E target, int left, int right) {
    if (left <= right) {
      int mid = (left + right) / 2;
      int compare = ((Comparable) target).compareTo(arr[mid]);
      if (compare == 0) {
        return Optional.of(mid);
      } else if (compare < 0) {
        return binarySearchRecursive(arr, target, left, mid - 1);
      } else {
        return binarySearchRecursive(arr, target, mid + 1, right);
      }
    }
    return Optional.empty();
  }

  /**
   * find the the target index in a sorted array
   *
   * @param arr    input arry is sorted
   * @param target value to be searched
   * @return target index or Optional.empty() if not found
   */
  public <E> Optional<Integer> binarySearchIteration(E[] arr, E target) {
    int left = 0;
    int right = arr.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      int compare = ((Comparable) target).compareTo(arr[mid]);
      if (compare == 0) {
        return Optional.of(mid);
      } else if (compare < 0) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return Optional.empty();
  }
}
