//This class is all about LinkedList Problem.
//Use Case 1 is to create a simple linked list of 56,30 and 70.

//Use Case 2 is to create LinkedList by adding 30,56 to 70. Sequence is 56-->30-->70 but adding vice-versa.
package com.linkedlist.problems;

public class LinkedList {

    static class Node
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }
    Node head = null;
    Node tail = null;

    //Adding to linked list.
    public void addToLinkedList(int data)
    {
        Node newNode = new Node(data);
        if (head == null)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            newNode.next = head;
            head = newNode;
            tail.next = null;
        }
    }

    //Print LinkedList
    public void printLinkedList()
    {
        Node current = head;
        while (current != null)
        {
            System.out.print(current.data+"  ");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        System.out.println("Welcome to LinkedList program");
        list.addToLinkedList(70);
        list.addToLinkedList(30);
        list.addToLinkedList(56);
        list.printLinkedList();
    }
}
