package cmsc256;

import java.util.LinkedList;
import java.util.Queue;

import bridges.base.Element;
import bridges.connect.Bridges;
import bridges.base.BinTreeElement;
import io.socket.parser.Binary;

/************
 * Name: Jeffrey Stanley
 * Project Name: BinSearchTree
 * Code function: Create a binary search tree and displayed a visual representation
 * Class: CMSC 256
 * Professor: Debra Duke
 * Final Update date: November 6th, 2020
 *
 */

public class BinSearchTree<E extends Comparable<E>> implements BinTreeInterface<E> {
    private int size = 0;
    private BinTreeElement<E> root = null;

    //height method
    public int height() {
        return recursHeight(root);
    }

    //helper method to height method
    public int recursHeight(BinTreeElement root) {
        if (root == null) {
            return -1;
        }
//recursive call for left and right root
        int leftRoot = recursHeight(root.getLeft());
        int rightRoot = recursHeight(root.getRight());

        if (leftRoot > rightRoot) {
            return leftRoot + 1;
        } else {
            return rightRoot + 1;
        }
    }

    //checks if tree is full
    public boolean isFullBST() {
        if (root == null)
            return false;
        //calls helper method
        return recFullBST(root);

    }

    //helper to isFullBST method
    public boolean recFullBST(BinTreeElement root) {
        boolean temp = true;
        //if both nodes are null, thrn tree is full
        if (root.getLeft() == null && root.getRight() == null) {
            return true;
            //if one child is null, it is not full
        } else if (root.getLeft() == null && root.getRight() != null) {
            return false;
            //if one child is null, it is not full
        } else if (root.getLeft() != null && root.getRight() == null) {
            return false;
        } else {
            temp = recFullBST(root.getLeft());

            if (temp != true) {
                return temp;
            }
            temp = recFullBST(root.getRight());
            if (temp != true) {
                return temp;
            }
        }
        return temp;
    }

    //returns total number of leaves
    public int getNumberOfLeaves() {
        return findLeaf(root);
    }

    //helper method to getNumberOfLeaves method
    public int findLeaf(BinTreeElement root) {
        if (root == null)
            return 0;
        //if there is no child node, node is a leaf
        if (root.getLeft() == null && root.getRight() == null)
            return 1;
        //return any leaf nodes
        else
            return findLeaf(root.getLeft()) + findLeaf(root.getRight());
    }

    //returns number of non-leaf nodes
    public int getNumberOfNonLeaves() {

        return size - getNumberOfLeaves();
    }

    public int findAllNodes(BinTreeElement root) {
        if (root == null)
            return 0;
        return (findAllNodes(root.getLeft()) + findAllNodes(root.getRight()));
    }

    //returns the root of the tree
    @Override
    public BinTreeElement<E> getRoot() {
        if (root == null) {
            return null;
        }
        return root;
    }

    //helper method to add method
    private boolean addToParent(BinTreeElement<E> parentNode, BinTreeElement<E> addNode) {
        int compare = parentNode.getValue().compareTo(addNode.getValue());
        boolean wasAdded = false;
        if (compare > 0) {
            //if parent has no left node, add new node as left
            if (parentNode.getLeft() == null) {
                parentNode.setLeft(addNode); //fills in the blank
                wasAdded = true;
            } else {
                // otherwise, add to parentNode's left (recursive)
                wasAdded = addToParent(parentNode.getLeft(), addNode);
            }
        } else if (compare < 0) {
            //if parent has no right node, add new node as right
            if (parentNode.getRight() == null) {
                parentNode.setRight(addNode);
                wasAdded = true;
            } else {
                wasAdded = addToParent(parentNode.getRight(), addNode);
            }
        }
        return wasAdded;
    }

    //adds new node to tree
    @Override
    public boolean add(E element) {
        BinTreeElement node = new BinTreeElement(element);
        //creates the label for each node in Bridges
        node.setLabel(element.toString());
        boolean wasAdded = true;
        //sets root to node if null
        if (root == null) {
            root = node;
        } else {
            wasAdded = addToParent(root, node);
        }
        if (wasAdded) {
            size++;
        }
        return wasAdded;
    }

    //removes node from tree
    @Override
    public boolean remove(E element) {
        if (root == null) {
            return false;
        }
        //if compareTo method results in 0
        if (root.getValue().compareTo(element) == 0) {
            //check if left child is null, if so, set root to right child
            if (root.getLeft() == null) {
                root = root.getRight();
                //check if right child is null, if so, set root to left child
            } else if (root.getRight() == null) {
                root = root.getLeft();
            } else {
                BinTreeElement formerRight = root.getRight();
                root = root.getRight();
                addToParent(root, formerRight);
//if a > b, a.compareTo(b) will return positive
            }
            size--;
            return true;
        }
        return removeSubNode(root, element);
    }

    //helper method to remove method
    private boolean removeSubNode(BinTreeElement<E> parent, E removeValue) {
        int compareParent = parent.getValue().compareTo(removeValue);
        BinTreeElement<E> subTree = null;
        //if compareParent is positive
        if (compareParent > 0) {
            subTree = parent.getLeft();
            //if negative
        } else {
            subTree = parent.getRight(); // ask about in class
        }
        if (subTree == null) {
            return false;
        }
        //if subtree is equal to zero
        if (subTree.getValue().compareTo(removeValue) == 0) {
            BinTreeElement replacement;
            //create swap variable conditions for null values
            if (subTree.getLeft() == null) {
                replacement = subTree.getRight();
            } else if (subTree.getRight() == null) {
                replacement = subTree.getLeft();
            } else {
                BinTreeElement formerRight = subTree.getRight();
                replacement = subTree.getLeft();
                addToParent(replacement, formerRight);
            }
            //if value is positive
            if (compareParent > 0) {
                parent.setLeft(replacement);
            }
            //if negative
            else {
                parent.setRight(replacement);
            }
            size--;
            return true;
        }
        return removeSubNode(subTree, removeValue);
    }

    //returns size of tree
    @Override
    public int size() {
        return size;
    }

    //checks if tree is empty
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    //empties out binary search tree
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    //searches for desired value in tree
    @Override
    public boolean search(E target) {
        BinTreeElement<E> current = root;
        while (current != null) {
            if ((target.compareTo(current.getValue())) < 0) {
                current = current.getLeft();
            } else if (target.compareTo(current.getValue()) > 0) {
                current = current.getRight();
            } else
                return true;
        }
        return false;
    }

    //transverses tree in inorder form
    @Override
    public String inorder() {
        return recurInorder(this.root);

    }

    //helper method to inorder method
    private String recurInorder(BinTreeElement curr) {
        String string = "";
        if (curr == null) {
            return "";
        }
        //Go through left
        string += recurInorder(curr.getLeft());

        //visit node
        string += curr.getValue() + "  ";
        //Go through right
        string += recurInorder(curr.getRight());
        return string;
    }

    //transverses tree in postorder form
    @Override
    public String postorder() {
        String post = "";
        return recurPost(this.root);
    }

    //helper method to postorder method
    private String recurPost(BinTreeElement curr) {
        String string = "";
        if (curr == null) {
            return "";
        }
        //go through left
        string = string + recurPost(curr.getLeft());
        //go through right
        string = string + recurPost(curr.getRight());
        //vist node
        string = string + curr.getValue() + "  ";
        return string;
    }

    //transverses tree in preorder style
    @Override
    public String preorder() {
        String pre = "";
        return recurPre(this.root);
    }

    //helper method to preorder
    private String recurPre(BinTreeElement curr) {
        String string = "";
        if (curr == null) {
            return "";
        }
        //vist node
        string = string + curr.getValue() + "  ";
        //go through left
        string = string + recurPre(curr.getLeft());
        //go through right
        string = string + recurPre(curr.getRight());
        return string;
    }

    //main method
    public static void main(String[] args) {
        Bridges bridges = new Bridges(1, "JStanley01", "185522224571");
        BinSearchTree<String> names = new BinSearchTree<>();
        names.add("Frodo");
        names.add("Dori");
        names.add("Bilbo");
        names.add("Kili");
        names.add("Gandalf");
        names.add("Fili");
        names.add("Thorin");
        names.add("Nori");
        System.out.println("InOrder traversal: \n" + names.inorder());
        try {
            //creates Bridges URL
            bridges.setDataStructure(names.root);
            bridges.visualize();
        } catch (Exception exc) {
            System.out.println("nope");
        }
    }
}
