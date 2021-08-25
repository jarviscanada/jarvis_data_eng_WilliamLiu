package ca.jrvs.practice.search;

import static org.junit.Assert.assertEquals;

import java.util.Optional;
import org.junit.Test;

public class BinarySearchTest {

  @Test
  public void binarySearchRecursion() {
    Integer[] arr = {10, 20, 30, 40, 50};
    BinarySearch binarySearch = new BinarySearch();
    assertEquals(Optional.empty(), binarySearch.binarySearchRecursion(arr, 5));
    assertEquals(Optional.of(0), binarySearch.binarySearchRecursion(arr, 10));
    assertEquals(Optional.empty(), binarySearch.binarySearchRecursion(arr, 15));
    assertEquals(Optional.of(1), binarySearch.binarySearchRecursion(arr, 20));
    assertEquals(Optional.empty(), binarySearch.binarySearchRecursion(arr, 25));
    assertEquals(Optional.of(2), binarySearch.binarySearchRecursion(arr, 30));
    assertEquals(Optional.empty(), binarySearch.binarySearchRecursion(arr, 35));
    assertEquals(Optional.of(3), binarySearch.binarySearchRecursion(arr, 40));
    assertEquals(Optional.empty(), binarySearch.binarySearchRecursion(arr, 45));
    assertEquals(Optional.of(4), binarySearch.binarySearchRecursion(arr, 50));
    assertEquals(Optional.empty(), binarySearch.binarySearchRecursion(arr, 55));
  }

  @Test
  public void binarySearchIteration() {
    Integer[] arr = {10, 20, 30, 40, 50};
    BinarySearch binarySearch = new BinarySearch();
    assertEquals(Optional.empty(), binarySearch.binarySearchIteration(arr, 5));
    assertEquals(Optional.of(0), binarySearch.binarySearchIteration(arr, 10));
    assertEquals(Optional.empty(), binarySearch.binarySearchIteration(arr, 15));
    assertEquals(Optional.of(1), binarySearch.binarySearchIteration(arr, 20));
    assertEquals(Optional.empty(), binarySearch.binarySearchIteration(arr, 25));
    assertEquals(Optional.of(2), binarySearch.binarySearchIteration(arr, 30));
    assertEquals(Optional.empty(), binarySearch.binarySearchIteration(arr, 35));
    assertEquals(Optional.of(3), binarySearch.binarySearchIteration(arr, 40));
    assertEquals(Optional.empty(), binarySearch.binarySearchIteration(arr, 45));
    assertEquals(Optional.of(4), binarySearch.binarySearchIteration(arr, 50));
    assertEquals(Optional.empty(), binarySearch.binarySearchIteration(arr, 55));
  }
}
