package recursion;
import java.util.*;
public class recursion7{
    public static void main(String[] args)
    {
       int arr[] = {1,2,2};
       List<List<Integer>> ans = new ArrayList<>();
       permut("","abc");
    }
    public static void removea(String s,int i,String k)
    {
        if(i == s.length()){
    System.out.println(k);
    return;
}
       else if(s.charAt(i)=='a')
        {
            removea(s,i+1,k);
        }
        else{
            k = k + s.charAt(i);
            removea(s,i+1,k);
        }
    }

    // remove a particular string 

    public static String removeApple(String a)
    {
        if(a.isEmpty())
        {
            return "";
        }
        if(a.startsWith("apple")){
            return removeApple(a.substring(5));
        }
        else{
            return a.charAt(0) + removeApple(a.substring(1));
        }

    }

    public static String removeAppNotApple(String a)
    {
        if(a.isEmpty())
        {
            return "";
        }
        if(a.startsWith("app") && !a.startsWith("apple")){
            return removeAppNotApple(a.substring(3));
        }
        else{
            return a.charAt(0) + removeAppNotApple(a.substring(1));
        }

    }
     

    public static void subseq(String p,String up)
    {
        if(up.isEmpty())
        {
            System.out.println(p);
             return ;
        }
        char ch = up.charAt(0);

        subseq(p+ch,up.substring(1));
        subseq(p,up.substring(1));
    }


    // Using ArrayList 1
    public static ArrayList<String> subseqa(String p,String up,ArrayList<String> l)
    {
        if(up.isEmpty())
        {
            l.add(p);
             return l;
        }
        char ch = up.charAt(0);

        subseqa(p+ch,up.substring(1),l);
        subseqa(p,up.substring(1),l);

        return l;
    }


   // using ArrayList 2


   public static ArrayList<String> subseqa2(String p,String up)
    {
        if(up.isEmpty())
        {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
            
        }
        char ch = up.charAt(0);

        ArrayList<String> left = subseqa2(p+ch,up.substring(1));
        ArrayList<String> right = subseqa2(p,up.substring(1));
         
        left.addAll(right);
        return left;
    }


    public static void subseqAscii(String p,String up)
    {
        if(up.isEmpty())
        {
            System.out.println(p);
             return ;
        }
        char ch = up.charAt(0);

        subseqAscii(p+ch,up.substring(1));
        subseqAscii(p,up.substring(1));
        subseqAscii(p+(ch+0),up.substring(1));
    }

    public static List<List<Integer>> subset(int[] arr)
    {
       List<List<Integer>> outer = new ArrayList<>();
       outer.add(new ArrayList<>());

       for(int num:arr)
       {
        int n = outer.size();
        for(int i=0;i<n;i++)
        {
            List<Integer> internal = new ArrayList<>(outer.get(i));
            internal.add(num);
            outer.add(internal);

        }
       }
       return outer;


    }

    //subsetDuplicate

    public static List<List<Integer>> subsetDup(int[] arr)
    {
        Arrays.sort(arr);
       List<List<Integer>> outer = new ArrayList<>();
       outer.add(new ArrayList<>());

       int start = 0;
       int end = 0;
       for(int i=0;i<arr.length;i++)
       {
        start = 0;
        if(i>0 && arr[i]==arr[i-1])
        {
           start = end + 1;
        }
        end = outer.size() - 1;
        int n = outer.size();
        for(int j=start;j<n;j++)
        {
            List<Integer> internal = new ArrayList<>(outer.get(j));
            internal.add(arr[i]);
            outer.add(internal);

        }
       }
       return outer;


    }




    // permutations

    public static void permut(String p,String up)
    {
        if(up.isEmpty())
        {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);


        for(int i=0;i<=p.length();i++)
        {
           String f = p.substring(0,i);
           String s = p.substring(i,p.length());
           permut(f+ch+s,up.substring(1)); 
        }
    }


    
   
}