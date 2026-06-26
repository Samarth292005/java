package LL;

 class DLLNode{
    int data;
    DLLNode prev;
    DLLNode next;

    DLLNode(int data)
    {
        this.data = data;
    }
}
public class DLL{
    DLLNode head;
   int  size = 0;

   public void insertIndex(int data,int index)
   {
    DLLNode temp = head;
    DLLNode node = new DLLNode(data);
    for(int i=1;i<index;i++)
    {
        temp = temp.next;
    }
    DLLNode nextNode = temp.next;
    node.next = temp.next;
    nextNode.prev = node;
    temp.next = node;
    node.prev = temp;





   }

   public void insertLast(int data)
    {
        DLLNode lastNode = null;
        DLLNode node = new DLLNode(data);
           DLLNode temp = head;
           while(temp != null)
           {
            lastNode = temp;
            temp = temp.next;
           }
                  
           lastNode.next = node;
           node.prev = lastNode;
           node.next = null;






   }





public void insert(int data)
{
    DLLNode node = new DLLNode(data);
    if(size==0)
    {
        head = node;
        size++;
        return;
    }
      node.next = head;
      head.prev = node;
      node.prev = null;
      head = node;

      size++;
}
public void display()
{
    DLLNode temp = head;
    DLLNode  last = null;
    System.out.println("for");
    while(temp != null)
    {
        System.out.println(temp.data);
        last = temp;
        temp = temp.next;
    }
    System.out.println("rev");
    while(last != null){
        System.out.println(last.data);
        last = last.prev;
    }
}
}