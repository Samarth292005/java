package LL;
public class Main {
    public static void main(String[] args)
    {
        CustomStack s = new CustomStack(5);
        s.push(10);
        s.push(45);
        s.push(45);
        s.push(454);
        s.push(77);
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
