// Bongki Moon (bkmoon@snu.ac.kr), Mar/27/2017

class Node {
  String key;
  int frequency = 1, access_count = 0;
  Node left, right;

  void setKey(String key) {
    this.key = key;
  }

  void resetFC() {
    this.frequency = 1;
    this.access_count = 0;
  }
}

public class BST { // Binary Search Tree implementation

  private Node root;
  private int treeSize;

  public BST() {
    treeSize = 0;
  }

  public void insert(String key) { // 교재 p.351
    root = insertItem(root, key);
  }

  private Node insertItem(Node t, String key) { // 교재 p.351
    if (t == null) {
      Node r = new Node();
      r.setKey(key);
      treeSize += 1;
      return r;
    } else if (key.compareTo(t.key) > 0) {
      t.left = insertItem(t.left, key);
      return t;
    } else if (key.compareTo(t.key) < 0) {
      t.right = insertItem(t.right, key);
      return t;
    } else {
      t.frequency += 1;
      return t;
    }
  }

  public boolean find(String key) { // 교재 p.347
    Node r = search(root, key);
    if (r == null) {
      return false;
    } else {
      return true;
    }
  }

  private Node search(Node t, String key) { // 교재 p.347
    if (t == null) {
      return null;
    } else if (t.key == key) { // additional condition
      t.access_count += 1;
      return t;
    } else if (key.compareTo(t.key) > 0) {
      return search(t.left, key);
    } else {
      return search(t.right, key);
    }
  }

  public int size() {
    return treeSize;
  }

  public int sumFreq() {
    return sumFreqRC(root);
  }

  private int sumFreqRC(Node t) { // check recursively
    int sum = 0;
    if (t == null) {
      sum = 0;
    } else {
      sum = sumFreqRC(t.left) + sumFreqRC(t.right);
    }
    return sum + t.frequency;
  }

  public int sumProbes() {
    return sumProbesRC(root);
  }

  private int sumProbesRC(Node t) {
    int sum = 0;
    if (t == null) {
      sum = 0;
    } else {
      sum = sumProbesRC(t.left) + sumProbesRC(t.right);
    }
    return sum + t.access_count;
  }

  public void resetCounters() {
    resetCountersRC(root);
  }

  private void resetCountersRC(Node t) {
    if (t != null) {
      t.resetFC();
      resetCountersRC(t.left);
      resetCountersRC(t.right);
    }
  }

  public void print() {
    printRC(root);
  }

  private void printRC(Node t) {
    if (t != null) {
      printRC(t.left);
      System.out.println(t.key + ":" + t.frequency + ":" + t.access_count);
      printRC(t.right);
    }
  }

}
