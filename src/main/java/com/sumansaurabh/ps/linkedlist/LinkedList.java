package com.sumansaurabh.ps.linkedlist;

public class LinkedList {
    ListNode head;

    /**
     * Append the data
     *
     * @param data
     * @return
     */
    public LinkedList append(int data) {

        if (head == null) {
            head = new ListNode(data);
            return this;
        }

        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new ListNode(data);

        return this;
    }

    public void prepend(int data) {
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;

    }

    public void deleteWithValue(int data) {
        if (head == null) {
            return;
        }

        if (head.val == data) {
            head = head.next;
            return;
        }

        ListNode current = head;

        while (current.next != null) {
            if (current.next.val == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public ListNode getHead() {
        return head;
    }
}
