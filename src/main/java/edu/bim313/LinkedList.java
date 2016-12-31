package edu.bim313;


class Node
{
    public int num1;
    public Node nextLink = null;

    //Link constructor
    public Node(int d1) {
        num1 = d1;
    }
} // end of Node

class LinkList
{
    private Node head;

    //LinkList constructor
    public LinkList() {
        head = null;
    }

    //Returns true if list is empty
    public boolean isEmpty() {
        return head == null;
    }

    private Node lastNode() {
        Node last = this.head;
        while (last.nextLink != null)
            last = last.nextLink;

        return last;
    }

    private Node nthNode(int n) {
        Node nthNode = this.head;
        for (int i = 0; i < n; i++) {
            if (nthNode == null) {
                System.out.println("cant find " + n + ". node.");
                System.exit(1);
            }
            nthNode = nthNode.nextLink;
        }
        return nthNode;
    }

    // ****************************************************************************************************
    // ****************************************************************************************************
    // ****************************************************************************************************

    // ** Fill the given methods ************************************************
    // Inserts a new node
    // ATTENTION! This implementation inserts node into head of the list !!
    // It should add at the end of the list
    // Fix this error!

    public void add(int d1)
    {
        Node link = new Node(d1);
        if (this.head == null) {
            this.head = link;
            return;
        }
        lastNode().nextLink = link;
    }

    // insert a new node at n. position
    public void add(int d1, int n)
    {
        Node node = new Node(d1);
        node.nextLink = this.nthNode(n);
        this.nthNode(n - 1).nextLink = node;
    }


    //Deletes the link at the first of the list
    public Node delete()
    {
        Node temp = head;
        head = head.nextLink;
        return temp;
    }


    //Deletes the node which is at n. position
    public Node delete(int n)
    {
        this.nthNode(n - 1).nextLink = this.nthNode(n + 1);
        return head;
    }

    //returns the value of last node
    public int last()
    {
        return this.lastNode().num1;
    }

    // make a new copy of the list which starts with head, return the head of the duplicated list
    public Node copy()
    {
        Node hnode = new Node(this.head.num1);

        Node currentCopyNode = hnode;
        Node currentNode = this.head;
        while (currentNode.nextLink != null) {
            currentNode = currentNode.nextLink;

            Node next = new Node(currentNode.num1);
            currentCopyNode.nextLink = next;
            currentCopyNode = next;
        }
        return hnode;
    }

    // return the position of the node which's value is n
    public int searchPosition(int n)
    {
        Node last = this.head;
        int pos = 0;
        while (last.nextLink != null) {
            if (last.num1 == n)
                return pos;
            last = last.nextLink;
            pos++;
        }
        return 0;
    }

    // return the node which's value is n
    public Node search(int n)
    {
        Node last = this.head;
        while (last.nextLink != null) {
            if (last.num1 == n)
                return last;
            last = last.nextLink;
        }
        return head;

    }

    // return the number of nodes in the list
    int count()
    {
        Node last = this.head;
        if (last == null)
            return 0;

        int count = 0;
        while (last.nextLink != null) {
            last = last.nextLink;
            count++;
        }
        return count;
    }

    // ****************************************************************************************************
    // ****************************************************************************************************
    // ****************************************************************************************************
    // ****************************************************************************************************
    // ****************************************************************************************************


    //Prints list data
    public void printList()
    {
        Node currentLink = head;
        System.out.print("List: ");
        while(currentLink != null)
        {
            System.out.print("{" + currentLink.num1 + "} ");
            currentLink = currentLink.nextLink;
        }
        System.out.println("");
    }

}

public class LinkedList
{


    public static void main(String[] args)
    {

        LinkList list = new LinkList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.printList();
        while(!list.isEmpty())
        {
            Node deletedLink = list.delete();
            System.out.print("deleted: ");
            list.printList();
            System.out.println("");
        }
        list.printList();
    }

}