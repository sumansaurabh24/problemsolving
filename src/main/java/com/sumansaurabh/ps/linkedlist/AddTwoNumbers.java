package com.sumansaurabh.ps.linkedlist;

public class AddTwoNumbers {

    static ListNode head ;
    static ListNode tail;

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;

        while (l1 != null && l2 != null){
            int sum = l1.val + l2.val;

            if(carry > 0){
                sum = sum + carry;
                carry = 0;
            }

            int num = sum;

            if(sum >= 10){
                num = sum - 10;
                carry = 1;
            }

            addNode(num);

            l1 = l1.next;
            l2 = l2.next;
        }

        if(carry > 0){
            addNode(carry);
        }

        return head;
    }

    public static void addNode(int data){
        ListNode newNode = new ListNode(data);

        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }

    }

    static int readReverse(ListNode head) {

        if (head == null) {
            return 0;
        }

        int data = readReverse(head.next);

        return data * 10 + head.val;

    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();

        list1.append(2).append(4).append(3);



        ListNode root1 = new ListNode(5);

        ListNode first1 = new ListNode(6);
        root1.next = first1;

        ListNode second1 = new ListNode(4);
        first1.next = second1;

        ListNode sumList = addTwoNumbers(list1.getHead(), root1);

        while (sumList != null){
            System.out.println(sumList.val);
            sumList = sumList.next;
        }
    }
}
