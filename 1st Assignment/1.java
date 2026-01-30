// --- Question 1: Write a program to clone an array ---
public static int[] cloneArray(int[] original) {
    if (original == null) return null;
    int[] copy = new int[original.length];
    for (int i = 0; i < original.length; i++) {
        copy[i] = original[i];
    }
    return copy;
}

// --- Question 3: Write a program in Java to remove a specific element from an array ---
public static int[] removeElement(int[] arr, int target) {
    int count = 0;
    for (int x : arr) if (x == target) count++;
    if (count == 0) return arr;

    int[] result = new int[arr.length - count];
    int index = 0;
    for (int x : arr) {
        if (x != target) result[index++] = x;
    }
    return result;
}

// --- Question 5: Write a function to concatenate two linked lists ---
// (Assuming a standard Singly Linked List Node structure)
static class Node {
    int data;
    Node next;
    Node(int d) { data = d; next = null; }
}

public static Node concatenate(Node head1, Node head2) {
    if (head1 == null) return head2;
    Node temp = head1;
    while (temp.next != null) {
        temp = temp.next;
    }
    temp.next = head2;
    return head1;
}

// --- Question 7: Write a function to search for element in singly linked list and return its position ---
public static int searchSingly(Node head, int key) {
    Node temp = head;
    int pos = 0;
    while (temp != null) {
        if (temp.data == key) return pos;
        temp = temp.next;
        pos++;
    }
    return -1;
}

// --- Question 9: Write a function to remove at specific position from singly linked list ---
public static Node removeAtPosition(Node head, int pos) {
    if (head == null) return null;
    if (pos == 0) return head.next;
    
    Node temp = head;
    for (int i = 0; temp != null && i < pos - 1; i++) {
        temp = temp.next;
    }
    if (temp == null || temp.next == null) return head;

    temp.next = temp.next.next;
    return head;
}

// --- Question 11: Write a function to traverse a doubly linked list in reverse and print all the elements ---
static class DNode {
    int data;
    DNode next, prev;
    DNode(int d) { data = d; }
}

public static void printReverseDoubly(DNode tail) {
    DNode temp = tail;
    while (temp != null) {
        System.out.print(temp.data + " ");
        temp = temp.prev;
    }
    System.out.println();
}

// --- Question 13: Write a function to insert a node at a specific position in a circular linked list ---
public static Node insertCircular(Node tail, int data, int pos) {
    Node newNode = new Node(data);
    if (tail == null) {
        newNode.next = newNode;
        return newNode;
    }
    Node head = tail.next;
    if (pos == 0) {
        newNode.next = head;
        tail.next = newNode;
        return tail;
    }
    Node temp = head;
    for (int i = 0; i < pos - 1; i++) {
        temp = temp.next;
        if (temp == head) break; 
    }
    newNode.next = temp.next;
    temp.next = newNode;
    if (temp == tail) return newNode;
    return tail;
}

// --- Question 15: Write a function to search for an element in a circular linked list ---
public static boolean searchCircular(Node tail, int key) {
    if (tail == null) return false;
    Node temp = tail.next;
    do {
        if (temp.data == key) return true;
        temp = temp.next;
    } while (temp != tail.next);
    return false;
}