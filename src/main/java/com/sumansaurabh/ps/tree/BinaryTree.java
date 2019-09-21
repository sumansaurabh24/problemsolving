package com.sumansaurabh.ps.tree;

import com.sun.jmx.snmp.SnmpOidDatabase;

public class BinaryTree {

    private Node root;

    int height(Node node){

        if(node == null){
            return 0;
        }

        return 1+ Math.max(height(node.left) , height(node.right));
    }

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);

        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Height of tree is : " +
                tree.height(tree.root));
    }
}
