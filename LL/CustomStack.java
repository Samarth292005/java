package LL;
public class CustomStack {
    int arr[];
    int size;
    int top;
    
    CustomStack(int size)
    {
        this.size = size;
        arr = new int[size];
        top = -1;
    }
    void push(int n)
    {
        if(top==size-1)
        {
            System.out.println("Stack overflow");
        }
        arr[++top] = n;

    }

    int pop()
    {
        if(top == -1)
        {
            System.out.println("Stack Overflow");
            return -1;
        }
        return arr[top--];
    }
}
