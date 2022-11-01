//This class is all about LinkedList Problem.
//Use Case 1 is to create a simple linked list of 56,30 and 70.
//Use Case 2 is to create LinkedList by adding 30,56 to 70. Sequence is 56-->30-->70 but adding vice-versa.
//Use Case 3 is to create a LinkedList by appending 30 and 70 to 56. Sequence 56-->30-->70.
//Use case 4 is to add 30 in between 56 and 70 in the linked list. Sequence is 56-->30-->70.
package com.linkedlist.problems;

public class LinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;
    Node tail = null;

    //Adding to linked list.
    public void addToLinkedList(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.next = null;
        }
        tail = newNode;
    }

    //Add the node in the middle.
    public void addAfterParticularNode(int value) {
        Node current = head;
        while (current != null) {
            if (!(current.data == 56)) {
                current = current.next;
            } else if (current.data == 56) {
                break;
            }
        }
        Node newNode = new Node(value);
        Node temp = current.next;
        current.next = newNode;
        newNode.next = temp;
    }

    //Print LinkedList
    public void printLinkedList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "  ");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        System.out.println("Welcome to LinkedList program");
        list.addToLinkedList(56);//56 is added first
        list.addToLinkedList(70);
        list.printLinkedList();
        list.addAfterParticularNode(30);
        System.out.println();
        list.printLinkedList();
    }

}