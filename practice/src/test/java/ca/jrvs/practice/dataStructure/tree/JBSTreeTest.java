package ca.jrvs.practice.dataStructure.tree;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Comparator;
import org.junit.Test;

public class JBSTreeTest {

  final Comparator<String> comparator = new StrToIntComparator();

  @Test
  public void insert() {
    JBSTree<String> jbst = new JBSTree<>(comparator);
    jbst.insert("4");
    jbst.insert("2");
    jbst.insert("1");
    jbst.insert("3");
    assertEquals(jbst.search("1"), "1");
    assertNull(jbst.search("0"));
  }

  @Test
  public void search() {
    JBSTree<String> jbst = new JBSTree<>(comparator);
    jbst.insert("4");
    jbst.insert("2");
    jbst.insert("1");
    jbst.insert("3");
    assertEquals(jbst.search("1"), "1");
    assertNull(jbst.search("0"));
  }

  @Test
  public void remove() {
    JBSTree<String> jbst = new JBSTree<>(comparator);
    jbst.insert("4");
    jbst.insert("2");
    jbst.insert("1");
    jbst.insert("3");
    jbst.insert("6");
    jbst.insert("5");
    jbst.insert("7");
    assertEquals(jbst.remove("6"), "6");
    assertEquals(jbst.remove("1"), "1");
    assertEquals(jbst.remove("2"), "2");
  }

  @Test
  public void preOrder() {
    JBSTree<String> jbst = new JBSTree<>(comparator);
    jbst.insert("8");
    jbst.insert("2");
    jbst.insert("21");
    jbst.insert("1");
    jbst.insert("5");
    jbst.insert("13");
    jbst.insert("3");
    assertArrayEquals(jbst.preOrder(), new String[]{"8", "2", "1", "5", "3", "21", "13"});
  }

  @Test
  public void inOrder() {
    JBSTree<String> jbst = new JBSTree<>(comparator);
    jbst.insert("8");
    jbst.insert("2");
    jbst.insert("21");
    jbst.insert("1");
    jbst.insert("5");
    jbst.insert("13");
    jbst.insert("3");
    assertArrayEquals(jbst.inOrder(), new String[]{"1", "2", "3", "5", "8", "13", "21"});
  }

  @Test
  public void postOrder() {
    JBSTree<String> jbst = new JBSTree<>(comparator);
    jbst.insert("8");
    jbst.insert("2");
    jbst.insert("21");
    jbst.insert("1");
    jbst.insert("5");
    jbst.insert("13");
    jbst.insert("3");
    assertArrayEquals(jbst.postOrder(), new String[]{"1", "3", "5", "2", "13", "21", "8"});
  }

  @Test
  public void findHeight() {
    JBSTree<String> jbst = new JBSTree<>(comparator);
    jbst.insert("8");
    jbst.insert("2");
    jbst.insert("21");
    jbst.insert("1");
    jbst.insert("5");
    jbst.insert("13");
    jbst.insert("3");
    assertEquals(jbst.findHeight(), 4);

    JBSTree<String> jbstBalanced = new JBSTree<>(comparator);
    jbstBalanced.insert("8");
    jbstBalanced.insert("2");
    jbstBalanced.insert("21");
    jbstBalanced.insert("1");
    jbstBalanced.insert("5");
    jbstBalanced.insert("13");
    jbstBalanced.insert("24");
    assertEquals(jbstBalanced.findHeight(), 3);
  }

  public static class StrToIntComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
      return Integer.compare(Integer.parseInt(o1), Integer.parseInt(o2));
    }
  }
}
