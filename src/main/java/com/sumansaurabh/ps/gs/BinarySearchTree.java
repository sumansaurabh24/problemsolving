package com.sumansaurabh.ps.gs;

public class BinarySearchTree {

    private Node root;

    class Node{
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    void put(int data){
        root = putRecursively(root, data);
    }

    private Node putRecursively(Node node, int data){

        if(node == null){
            node = new Node(data);
            return node;
        }

        if(data < node.value){
            node.left = putRecursively(node.left, data);
        }else if(data > node.value){
            node.right = putRecursively(node.right, data);
        }

        return node;
    }

    void inorder(){
        System.out.println("----------IN ORDER-----------");
        inorderRecursively(root);
        System.out.println("\n");
    }

    private void inorderRecursively(Node node){
        if(node != null){
            inorderRecursively(node.left);
            System.out.print(node.value + " ");
            inorderRecursively(node.right);
        }
    }

    void preOrder(){
        System.out.println("----------PRE ORDER-----------");
        preOrderRecursively(root);
        System.out.println("\n");
    }

    private void preOrderRecursively(Node node){
        if(node != null){
            System.out.print(node.value + " ");
            preOrderRecursively(node.left);
            preOrderRecursively(node.right);
        }
    }

    void postOrder(){
        System.out.println("----------POST ORDER-----------");
        postOrderRecursively(root);
        System.out.println("\n");
    }

    private void postOrderRecursively(Node node){
        if(node != null){
            postOrderRecursively(node.left);
            postOrderRecursively(node.right);
            System.out.print(node.value + " ");
        }
    }

    boolean contains(Node node, int data){
        if(node == null){
            return false;
        }else{
            if(node.value == data){
                return true;
            }else if(data < node.value){
                return contains(node.left, data);
            }else if(data > node.value){
                return contains(node.right, data);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.put(50);
        bst.put(30);
        bst.put(20);
        bst.put(40);
        bst.put(70);
        bst.put(60);
        bst.put(80);

        bst.inorder();
        bst.preOrder();
        bst.postOrder();

        System.out.println(bst.contains(bst.root, 100));
    }
}
