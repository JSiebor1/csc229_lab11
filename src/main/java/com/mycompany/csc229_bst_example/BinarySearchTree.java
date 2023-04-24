package com.mycompany.csc229_bst_example;

/**
 *
 * @author MoaathAlrajab
 */
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    private BstNode root;

    public boolean isEmpty() {
        return (this.root == null);
    }

    public void insert(Integer data) {

        System.out.print("[input: " + data + "]");
        if (root == null) {
            this.root = new BstNode(data);
            System.out.println(" -> inserted: " + data);
            return;
        }
        insertNode(this.root, data);
        System.out.print(" -> inserted: " + data);
        System.out.println();
    }

    private BstNode insertNode(BstNode root, Integer data) {

        BstNode tmpNode = null;
        System.out.print(" ->" + root.getData());
        if (root.getData() >= data) {
            System.out.print(" [L]");
            if (root.getLeft() == null) {
                root.setLeft(new BstNode(data));
                return root.getLeft();
            } else {
                tmpNode = root.getLeft();
            }
        } else {
            System.out.print(" [R]");
            if (root.getRight() == null) {
                root.setRight(new BstNode(data));
                return root.getRight();
            } else {
                tmpNode = root.getRight();
            }
        }
        return insertNode(tmpNode, data);
    }

    public void inOrderTraversal() {
        doInOrder(this.root);
    }

    private void doInOrder(BstNode root) {
        if (root == null) {
            return;
        }
        doInOrder(root.getLeft());
        System.out.println(root.getData());
        doInOrder(root.getRight());
    }

    public void preOrderTraversal() {
        doPreOrder(this.root);
    }

    public void doPreOrder(BstNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.getData());
        doPreOrder(root.getLeft());
        doPreOrder(root.getRight());
    }

    public Integer findHeight() {
        int height = 0;
        BstNode node = this.root;

        Queue<BstNode> queue = new LinkedList<>();
        queue.add(node);

        if (root == null) {
            return height;
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            height++;

            while (size > 0) {
                node = queue.remove();

                if (node.getLeft() != null) {
                    queue.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.add(node.getRight());
                }
                size--;
            }
        }

        return height;
    }

    public int getDepth(BstNode node) {
        //ToDo 4: complete getDepth of a node 
        int depth = 0;
        BstNode currNode = root;

        while (currNode != null) {
            if (currNode.getData() == node.getData()) {
                return depth;
            } else if (node.getData() > currNode.getData()) {
                currNode = currNode.getRight();
            } else if (node.getData() < currNode.getData()) {
                currNode = currNode.getLeft();
            }

            depth++;
        }
        return -1;
    }

    public void print() {
        System.out.println("\n==== BST Print ===== \n");
        print(root, "");
        // ToDo 5: complete the print of the BST
    }

    public void print(BstNode node, String str) {
        if (node == null) {
            return;
        }
        System.out.println(str + " + " + node.getData());
        print(node.getLeft(), str + " ");
        print(node.getRight(), str + " ");
    } // each node is only visited once, O(n)
}
