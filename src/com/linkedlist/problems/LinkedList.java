//This class is all about LinkedList Problem.
//Use Case 1 is to create a simple linked list of 56,30 and 70.
//Use Case 2 is to create LinkedList by adding 30,56 to 70. Sequence is 56-->30-->70 but adding vice-versa.
//Use Case 3 is to create a LinkedList by appending 30 and 70 to 56. Sequence is 56-->30-->70.
//Use Case 4 is to add 30 in between 56 and 70 in the linked list. Sequence is 56-->30-->70.
//Use Case 5 is to delete first element in the linked list. Given sequence is 56-->30-->70 and o/p will be 30-->70.
//Use Case 6 is to delete last element in the linked list. Given sequence is 56-->30-->70 and o/p will be 56-->30.
//Use Case 7 is to search linked list to find node with value 30. Given sequence is 56-->30-->70.
//Use Case 8 is to insert 40 after 30 to the linked list. Given sequence is 56-->30-->70 and o/p will be 56-->30-->40-->70.
//Use Case 9 is to delete 40 from the linked list and show the size of linked list. Given sequence is 56-->30-->40-->70.

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
    static int position;

    //Adding to linked list.
    public void addToLinkedList(int data)
    {
        Node newNode = new Node(data);
        if (head == null)
        {
            head = newNode;
        }
        else
        {
            tail.next = newNode;
            newNode.next = null;
        }
        tail = newNode;
    }

    //Search the LinkedList to find a particular node
    public void checkNode(int value)
    {
        Node current = head;
        int count = 1;
        while (current != null)
        {
            if (current.data == value)
            {
                System.out.println("Searched key : "+value+" is present at node : "+count);
                position = count;
                return;
            }
            current = current.next;
            count++;
        }
        System.out.println("Searched key is not present in the LinkedList");
    }

    //Add the node in the middle.
    public void addAtParticularPosition(int value, int index)
    {
        Node current = head;
        int count = 1;
        while (current != null && count != index)//List starts from 0 so 30 position is 1 and this index
        //represents 2 where 40 will be put.
        {
            current = current.next;
            count++;
        }
        Node newNode = new Node(value);
        Node temp = current.next;
        current.next = newNode;
        newNode.next = temp;
    }

    //Delete the first element in the linked list
    public void pop()
    {
        if (head == null)
        {
            System.out.println("List is empty");
            return;
        }
        else
        {
            if (head != tail)
            {
                head = head.next;
            }
            else
            {
                head = tail = null;
            }
        }
    }

    //Delete last element in the linked list
    public void popLast()
    {
        if (head == null)
        {
            System.out.println("List is empty");
        }
        else
        {
            if (head != tail)
            {
                Node current = head;
                while (current.next.next != null)
                {
                    current = current.next;
                }
                tail = current;
                tail.next = null;
            }
            else
            {
                head = tail = null;
            }
        }
    }

    //Delete node at given index.
    public void popNodeAtAGivenIndex(int index) {

        //case when we need to remove the head node
        if (index == 1)
        {
            pop();
        }
        else if (index == getLinkedListSize())
        {
            //case when we need to remove the tail node
            popLast();
        }
        else
        {
            int count = 1;
            Node current = head;
            while (current != null && count != index)
            {
                current = current.next;
                count++;
            }
            current.next = current.next.next;
        }
    }

    //Getting linked list size
    public int getLinkedListSize()
    {
        Node current = head;
        int count = 0;
        while (current != null) {

            current = current.next;
            count++;
        }
        return count;
    }

    //Print LinkedList
    public void printLinkedList()
    {
        Node current = head;
        if (head == null)
        {
            System.out.println("LinkedList is empty");
            return;
        }
        while (current != null)
        {
            System.out.print(current.data+"  ");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        System.out.println("Welcome to LinkedList program");
        list.addToLinkedList(56);
        list.addToLinkedList(30);
        list.addToLinkedList(70);
        System.out.println("Before adding 40 to the LinkedList");
        list.printLinkedList();
        System.out.println();
        list.checkNode(30);
        list.addAtParticularPosition(40,position);//position represents the node position of 30.
        System.out.println("After adding 40 to the LinkedList");
        list.printLinkedList();
        list.popNodeAtAGivenIndex(position);
        System.out.println("\nAfter removing 40 from linked list");
        list.printLinkedList();

    }
}