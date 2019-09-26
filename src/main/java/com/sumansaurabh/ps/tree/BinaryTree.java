package com.sumansaurabh.ps.tree;

import com.sun.jmx.snmp.SnmpOidDatabase;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    private Node root;

    int height(Node node){

        if(node == null){
            return 0;
        }

        return 1+ Math.max(height(node.left) , height(node.right));
    }

    Node findLCA(int n1, int n2){
        return findLCA(root, n1, n2);
    }

    Node findLCA(Node node , int n1, int n2){
        if(node == null){
            return null;
        }

        if(node.data == n1 || node.data == n2){
            return node;
        }

        Node leftLca = findLCA(node.left, n1, n2);
        Node rightLca = findLCA(node.right, n1, n2);

        if(leftLca != null && rightLca != null){
            return node;
        }

        return (leftLca != null) ? leftLca : rightLca;
    }

    void printLevelOrder(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){

            Node tempNode = queue.poll();
            System.out.println(tempNode.data);

            if(tempNode.left != null){
                queue.add(tempNode.left);
            }

            if(tempNode.right != null){
                queue.add(tempNode.right);
            }
        }

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
