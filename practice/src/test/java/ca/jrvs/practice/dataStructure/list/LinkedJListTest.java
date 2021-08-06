package ca.jrvs.practice.dataStructure.list;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LinkedJListTest {

  @Test
  public void add() {
    JList<String> list = new LinkedJList<>();
    list.add("0");
    list.add("1");
    list.add("2");
    assertEquals(list.get(1), "1");
  }

  @Test
  public void toArray() {
    JList<String> list = new LinkedJList<>();
    list.add("0");
    list.add("1");
    list.add("2");
    assertArrayEquals(list.toArray(), new String[]{"0", "1", "2"});
  }

  @Test
  public void size() {
    JList<String> list = new LinkedJList<>();
    list.add("0");
    list.add("1");
    list.add("2");
    assertEquals(list.size(), 3);
  }

  @Test
  public void isEmpty() {
    JList<String> list = new LinkedJList<>();
    assertTrue(list.isEmpty());
  }

  @Test
  public void indexOf() {
    JList<String> list = new LinkedJList<>();
    list.add("0");
    list.add("1");
    list.add("2");
    assertEquals(list.indexOf("1"), 1);
    assertEquals(list.indexOf("3"), -1);
  }

  @Test
  public void contains() {
    JList<String> list = new LinkedJList<>();
    list.add("0");
    list.add("1");
    list.add("2");
    assertTrue(list.contains("2"));
    assertFalse(list.contains("3"));
  }

  @Test
  public void get() {
    JList<String> list = new LinkedJList<>();
    list.add("0");
    list.add("1");
    list.add("2");
    assertEquals(list.get(1), "1");
  }

  @Test
  public void remove() {
    JList<String> list = new LinkedJList<>();
    list.add("0");
    list.add("1");
    list.add("2");
    assertEquals(list.remove(1), "1");
  }

  @Test
  public void clear() {
    JList<String> list = new LinkedJList<>();
    list.add("0");
    list.add("1");
    list.add("2");
    list.clear();
    assertTrue(list.isEmpty());
  }
}
