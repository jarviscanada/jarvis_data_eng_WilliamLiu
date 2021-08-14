package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class CompareTwoMapsTest {

  @Test
  public void compareMaps() {
    CompareTwoMaps compareTwoMaps = new CompareTwoMaps();
    Map<String, String> map1 = new HashMap<>();
    Map<String, String> map2 = new HashMap<>();

    map1.put("1", "one");
    map1.put("2", "two");
    map1.put("3", "three");

    map2.put("2", "two");
    map2.put("1", "one");
    map2.put("3", "three");

    assertTrue(compareTwoMaps.compareMaps(map1, map2));

    map2.remove("2");

    assertFalse(compareTwoMaps.compareMaps(map1, map2));
  }

  @Test
  public void compareMapsNoEquals() {
    CompareTwoMaps compareTwoMaps = new CompareTwoMaps();
    Map<String, String> map1 = new HashMap<>();
    Map<String, String> map2 = new HashMap<>();

    map1.put("1", "one");
    map1.put("2", "two");
    map1.put("3", "three");

    map2.put("2", "two");
    map2.put("1", "one");
    map2.put("3", "three");

    assertTrue(compareTwoMaps.compareMapsNoEquals(map1, map2));

    map2.remove("2");

    assertFalse(compareTwoMaps.compareMapsNoEquals(map1, map2));
  }
}
