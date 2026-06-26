package LL;
class Node{
    int data;
    Node next;

    Node(int data)
    {
        this.data = data;
    }
}
public class LL{
    Node head;
    Node tail;
    int size=0;

public int DelInd(int i)
{
    Node ind = get(i-2);
    Node temp = ind.next;
    ind.next = ind.next.next;
    return temp.data;
}
public Node get(int index)
{
    Node temp = head;
    for(int i = 0;i<index;i++)
    {
        temp = temp.next;
    }
      return temp;
}
public int deleteLast()
{
    Node secondLast = get(size-1);
     Node temp = tail;
    secondLast.next = null;
    tail = secondLast;
    return temp.data;
    

}
    public void add(int data)
    {
        Node node = new Node(data);
        if(head == null)
        {
            head = node;
            tail = node;
            return;
        }
        node.next = head;
        head = node;
        size++;
    }
    public void display()
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    public void last(int data)
    {
        Node node = new Node(data);
        if(tail == null)
        {
            tail = node;
            return;
        }
         tail.next = node;
         tail = node;
         size++;
    }
    public void insindex(int data,int pos){
        Node node = new Node(data);
        Node temp = head;
        for(int i=1;i<pos-1;i++)
        {
           temp = temp.next;
        }
          node.next = temp.next;
          temp.next = node;
    }
    public int deleteFirst()
    {
        int temp = head.data;
        head = head.next;
        size--;
        return temp;
    }

    public Node insrec(Node head,int pos,int val)
    {
        if(pos == 0 )
        {
            Node node = new Node(val);
            node.next = head;
            return node;
        }
        if(head == null)
        {
            return null;
        }
        head.next = insrec(head.next,pos-1,val);
        return head;

    }



}
