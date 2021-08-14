package ca.jrvs.practice.codingChallenge;

import java.util.Map;

public class CompareTwoMaps {

  /**
   * Big-O: O(n)
   * Justification: check if key == keys, values == values
   */
  public <K, V> boolean compareMaps(Map<K, V> m1, Map<K, V> m2) {
    return m1.equals(m2);
  }

  /**
   * Big-O: O(n)
   * Justification: check if key == keys, values == values
   */
  public <K, V> boolean compareMapsNoEquals(Map<K, V> m1, Map<K, V> m2) {
    if (m1 == null || m2 == null || m1.size() != m2.size()) {
      return false;
    } else {
      return m1.keySet().stream().allMatch(m2::containsKey) &&
          m1.values().stream().allMatch(m2::containsValue);
    }
  }
}
