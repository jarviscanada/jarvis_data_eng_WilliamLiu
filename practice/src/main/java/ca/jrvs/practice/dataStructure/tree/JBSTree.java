package ca.jrvs.practice.dataStructure.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * A simplified BST implementation
 *
 * @param <E> type of object to be stored
 */
public class JBSTree<E> implements JTree<E> {

  private Node<E> root;

  /**
   * The comparator used to maintain order in this tree map Comparator cannot be null
   */
  private final Comparator<E> comparator;

  /**
   * Create a new BST
   *
   * @param comparator the comparator that will be used to order this map.
   * @throws IllegalArgumentException if comparator is null
   */
  public JBSTree(Comparator<E> comparator) {
    if (comparator == null) {
      throw new IllegalArgumentException("Comparator is null");
    }
    this.comparator = comparator;
    this.root = null;
  }

  /**
   * Insert an object into the tree.
   *
   * @param object item to be inserted
   * @return inserted item
   * @throws IllegalArgumentException if the object already exists
   */
  @Override
  public E insert(E object) {
    if (root == null) {
      root = new Node<>(object, null);
      return root.getValue();
    }
    insertRecursive(root, object);
    return object;
  }

  private void insertRecursive(Node<E> current, E object) {
    int compareResult = comparator.compare(object, current.getValue());
    if (compareResult < 0) {
      if (current.left == null) {
        current.left = new Node<>(object, current);
      } else {
        insertRecursive(current.left, object);
      }
    } else if (compareResult > 0) {
      if (current.right == null) {
        current.right = new Node<>(object, current);
      } else {
        insertRecursive(current.right, object);
      }
    } else {
      throw new IllegalArgumentException("Object already exists");
    }
  }

  /**
   * Search and return an object, return null if not found
   *
   * @param object to be found
   * @return the object if exists or null if not
   */
  @Override
  public E search(E object) {
    if (root == null) {
      return null;
    }
    boolean found = searchRecursive(root, object);
    if (found) {
      return object;
    } else {
      return null;
    }
  }

  private boolean searchRecursive(Node<E> current, E object) {
    boolean found = false;
    if (current != null) {
      int compareResult = comparator.compare(object, current.getValue());
      if (compareResult < 0) {
        found = searchRecursive(current.left, object);
      } else if (compareResult > 0) {
        found = searchRecursive(current.right, object);
      } else {
        found = true;
      }
    }
    return found;
  }

  /**
   * Remove an object from the tree.
   *
   * @param object to be removed
   * @return removed object
   * @throws IllegalArgumentException if the object not exists
   */
  @Override
  public E remove(E object) {
    if (root == null) {
      throw new IllegalArgumentException("Tree is empty");
    }
    if (search(object) == null) {
      throw new IllegalArgumentException("Object does not exist");
    }
    removeRecursive(root, object);
    return object;
  }

  private Node<E> removeRecursive(Node<E> current, E object) {
    int compareResult = comparator.compare(object, current.getValue());
    if (compareResult < 0) {
      current.left = removeRecursive(current.left, object);
    } else if (compareResult > 0) {
      current.right = removeRecursive(current.right, object);
    } else {
      if (current.left == null && current.right == null) {
        return null;
      }

      if (current.right == null) {
        return current.left;
      }
      if (current.left == null) {
        return current.right;
      }

      E smallestValue = findSmallestValueNode(current.right).getValue();
      current.setValue(smallestValue);
      current.right = removeRecursive(current.right, smallestValue);
    }
    return current;
  }

  private Node<E> findSmallestValueNode(Node<E> current) {
    if (current.getLeft() == null) {
      return current;
    }
    return findSmallestValueNode(current.getLeft());
  }

  /**
   * traverse the tree recursively
   *
   * @return all objects in pre-order
   */
  @Override
  public E[] preOrder() {
    return (E[]) preOrderRecursive(root).toArray();
  }

  private List<E> preOrderRecursive(Node<E> root) {
    List<E> list = new ArrayList<>();
    if (root == null) {
      return list;
    }
    list.add(root.getValue());
    list.addAll(preOrderRecursive(root.getLeft()));
    list.addAll(preOrderRecursive(root.getRight()));
    return list;
  }

  /**
   * traverse the tree recursively
   *
   * @return all objects in-order
   */
  @Override
  public E[] inOrder() {
    return (E[]) inOrderRecursive(root).toArray();
  }

  private List<E> inOrderRecursive(Node<E> root) {
    List<E> list = new ArrayList<>();
    if (root == null) {
      return list;
    }
    list.addAll(inOrderRecursive(root.getLeft()));
    list.add(root.getValue());
    list.addAll(inOrderRecursive(root.getRight()));
    return list;
  }

  /**
   * traverse the tree recursively
   *
   * @return all objects pre-order
   */
  @Override
  public E[] postOrder() {
    return (E[]) postOrderRecursive(root).toArray();
  }

  private List<E> postOrderRecursive(Node<E> root) {
    List<E> list = new ArrayList<>();
    if (root == null) {
      return list;
    }
    list.addAll(postOrderRecursive(root.getLeft()));
    list.addAll(postOrderRecursive(root.getRight()));
    list.add(root.getValue());
    return list;
  }

  /**
   * traverse through the tree and find out the tree height
   *
   * @return height
   * @throws NullPointerException if the BST is empty
   */
  @Override
  public int findHeight() {
    if (root == null) {
      throw new NullPointerException("BST is empty");
    }
    return findHeightRecursive(root);
  }

  private int findHeightRecursive(Node<E> current) {
    if (current == null) {
      return 0;
    } else {
      int leftDepth = findHeightRecursive(current.left);
      int rightDepth = findHeightRecursive(current.right);

      if (leftDepth > rightDepth) {
        return leftDepth + 1;
      } else {
        return rightDepth + 1;
      }
    }
  }

  static final class Node<E> {

    E value;
    Node<E> left;
    Node<E> right;
    Node<E> parent;

    public Node(E value, Node<E> parent) {
      this.value = value;
      this.parent = parent;
    }

    public E getValue() {
      return value;
    }

    public void setValue(E value) {
      this.value = value;
    }

    public Node<E> getLeft() {
      return left;
    }

    public void setLeft(Node<E> left) {
      this.left = left;
    }

    public Node<E> getRight() {
      return right;
    }

    public void setRight(Node<E> right) {
      this.right = right;
    }

    public Node<E> getParent() {
      return parent;
    }

    public void setParent(Node<E> parent) {
      this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Node)) {
        return false;
      }
      Node<?> node = (Node<?>) o;
      return getValue().equals(node.getValue()) &&
          getLeft().equals(node.getLeft()) &&
          getRight().equals(node.getRight()) &&
          getParent().equals(node.getParent());
    }

    @Override
    public int hashCode() {
      return Objects.hash(getValue(), getLeft(), getRight(), getParent());
    }
  }
}
