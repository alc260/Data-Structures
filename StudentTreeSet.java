//Ava Chong
//Timothy James 0445 Assignment 6
//Due 4/4/18

import java.util.Comparator;

public class StudentTreeSet {
  private int size;
  private TreeNode root;
  private StudentComparator comparator = new StudentComparator();
  
  public int size() {
    return size;
  }
  
  public void add(Student value) {
    if (value == null) {
      throw new UnsupportedOperationException("Can't add null student.");
    }
    if (root == null) {
      root = new TreeNode(value);
      size++;
    } else {
      add(value, root);
    }
  }
  
  public boolean contains(Student value) {
    if (value == null) {
      return false;
    }
    return contains(value, root);
  }
  
  private boolean contains(Student value, TreeNode node) {
    if (node != null) {
      int c = comparator.compare(value, node.value);
      if (c == 0) {
        return true;
      } else if (c < 0) {
        return contains(value, node.left);
      } else {
        return contains(value, node.right);
      }
    }
    return false;
  }

  private void add(Student value, TreeNode node) {
    int c = comparator.compare(value, node.value);
    if (c == 0) {
      node.value = value;
    } else if (c < 0) {
      if (node.hasLeftChild()) {
        add(value, node.left);
      } else {
        node.left = addTreeNode(value);
      }
    } else {
      if (node.hasRightChild()) {
        add(value, node.right);
      } else {
        node.right = addTreeNode(value);
      }
    }
  }
  
  private TreeNode addTreeNode(Student value) {
    size++;
    return new TreeNode(value);
  }
  
  private class TreeNode {
    private TreeNode left;
    private TreeNode right;
    private Student value;
    
    public TreeNode(Student value) {
      this.value = value;
    }

    public void setValue(Student value){
      this.value = value;
    }
    
    public boolean hasLeftChild() {
      return left != null;
    }
    
    public boolean hasRightChild() {
      return right != null;
    }
    
    public void removeLeftChild() {
      left = null;
    }
    
    public void removeRightChild() {
      right = null;
    }
    
    public int countChildren() {
      int result = 0;
      if (hasLeftChild()) {
        result++;
      }
      if (hasRightChild()) {
        result++;
      } 
      return result;
    }
  }
  
  private class StudentComparator implements Comparator<Student> {
    public int compare(Student left, Student right) {
      //proper order being, alphabetically by last name, then first name, then ID number
      String leftLast = left.getLastName();
      String rightLast = right.getLastName();
      int compare = leftLast.compareTo(rightLast); 
      //return neg if Left is alphabetically first 
      //return pos if Left is alphabetically second

      if (compare == 0){ //if last names are the same 
        String leftFirst = left.getFirstName();
        String rightFirst = right.getFirstName();
        compare = leftFirst.compareTo(rightFirst);

        if (compare == 0){ //if first names are the same
          int leftID = left.getIdNumber();
          int rightID = right.getIdNumber();
          if (leftID > rightID){ //Right ID is first numerically
            compare = 1; 
          }
          else if (rightID > leftID){ //Left ID is first numerically
            compare = -1;
          }
          else{
            compare = 0; //duplicate
          }
        }
      }
      return compare;
    }
  }
  
  public boolean remove(Student s) {
    // Find where it is. Set value to null 
    boolean contains = contains(s); 
    boolean removed;
    if (contains == false){
      removed = false;
    }
    else{
      TreeNode compareNode = root;
      if (compareNode != null) {
        int c = comparator.compare(s, compareNode.value);
        do{
          if (c == 0) { //remove this node
          remove(compareNode);
          } 
          else if (c < 0) {
            compareNode = compareNode.left;
            c = comparator.compare(s, compareNode.value);
          } 
          else {
            compareNode = compareNode.right;
            c = comparator.compare(s, compareNode.value);
          }
        } while (c != 0);
      }
      removed = true;
    }
    return removed;
  }

  public void remove(TreeNode node){
    if (node.countChildren() == 0){
      node = null;
    }
    else if (node.countChildren() == 1){
      if(node.hasLeftChild() == true){
        node = node.left;
      }
      else{
        node = node.right;
      }
    }
    else if (node.countChildren() == 2){
      //find min of right sub tree
      TreeNode minNode = node.right;
      int children = minNode.countChildren();
      while(children != 0){
        minNode = minNode.left;
        children = minNode.countChildren();
      }
      //replace node with minNode VALUE
      Student minValue = minNode.value;
      node.setValue(minValue);

      //remove min
      minNode = null;
    }
  }
}