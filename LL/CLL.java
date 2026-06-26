package LL;
public class CLL {

    Node head;
    Node tail;
    int size = 0;

    public void insert(int data){
        Node node = new Node(data);

        if(size == 0)
        {
            head = node;
            tail = node;
            size++;
        }
        tail.next = node;
        node.next = head;
        tail = node;
    }
    public void display()
    {
        Node temp = head;
        do{
            System.out.println(temp.data);
            temp = temp.next;
        }while(temp != head);
    }
    
}
