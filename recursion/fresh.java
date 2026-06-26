package recursion;
class fresh{
    public static void main(String[] args)
    {

        int i,s=0;
        int[] a = {5, 12, 19, 8, 21, 30, 17, 9, 42, 3, 27, 14, 36, 19, 25, 7, 11, 28, 33, 1};
        for(i=0;i<20;i++)
        {
            if(a[i]%3==0 && a[i]%5==0)
            {
            System.out.println(a[i]);
               s = s + a[i];
        }
         
    }
    if(s==0)
    {
        System.out.println("no such ele found");
    }
    else{
    System.out.println(s);
    }
}
}