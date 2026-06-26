package recursion;

public class recursion2 {
    public static void main(String[] args)
    {
        System.out.println(countz(8008));
         
    }
    static void fun(int n)
    {

        if(n==0)
        {
            return;
        }
        fun(n-1);
         System.out.println(n);
       
    }
    static int fac(int n)
    {
        if(n==1 || n==0)
        {
            return n;
        }
        else{
            return n * fac(n-1);
        }
    }
    static int sumofd(int n)
    {
        if(n % 10 == n)
        {
            return n;
        }
        return n%10 * sumofd(n/10);

    }
    static int sum = 0;
    static void reverse(int n)
    {
        int rem;
        if(n==0)
        {
            return ;
        } 
        rem = n % 10;
        sum = sum*10 + rem;
        reverse(n/10);
        }
    static int rev2(int n)
    {
        int digits = (int)(Math.log10(n)) + 1;
        return helper(n,digits);
    }
    private static int helper(int n,int digits)
    {
        if(n%10==n)
        {
            return n;
        }
        int rem = n % 10;
        return rem * (int)Math.pow(10,digits-1) + helper(n/10,digits-1);
    }
    static boolean pal(int n)
    {
        if(n==rev2(n))
        {
            return true;
        }
        else{
            return false;
        }
    }
    static int countz(int n)
    {
        return helperz(n,0);
    }
    private static int helperz(int n , int c)
    {
        if(n==0)
        {
            return c;
        }
        int rem = n % 10;
        if(rem == 0)
        {
        return helperz(n/10,c+1);
        }
        return helperz(n/10,c);
    }

}
