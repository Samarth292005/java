package recursion;
import java.util.*;
public class recursion3 {
    public static void main(String []args)
    {
        int a[] = {1,4,3,4,8,6};
        getAllEle(a,0,4);
        System.out.println(list);
    }


    public static boolean isSorte(int[] arr){
        return helper(arr,0);
          
    }
    private static boolean helper(int arr[],int index)
    {
        if(index == arr.length-1)
        {
            return true;
        }
       return arr[index]>arr[index+1] && helper(arr,index+1); // important 
    }
    public static int getele(int arr[],int index,int target)
    {
        if(index==arr.length-1)
        {
            return -1;
        }
        if(arr[index]==target)
        {
            return index;
        }
        return getele(arr,index+1,target);
    }



    static ArrayList<Integer> list = new ArrayList<>();
    public static void getAllEle(int arr[],int index,int target)
    {
        if(index==arr.length)
        {
            return;
        }
        if(arr[index]==target)
        {
           list.add(index);
        }
        getAllEle(arr,index+1,target);
    }

     // Returning arrayList now 
     
     static ArrayList<Integer> find(int arr[],int target,int index,ArrayList<Integer> l)
     {
          if(index==arr.length)
          {
            return l;
          }
          else if(arr[index]==target)
          {
            l.add(index);
          }
          return find(arr,target,index+1,l);
        }

 // making arralist for every function 

 public static ArrayList<Integer> find2(int[] arr,int target,int index)
 {
    ArrayList<Integer> list = new ArrayList<>();
    if(index == arr.length)
    {
        return list;
    }
    else if(arr[index]==target)
    {
        list.add(index);
    }
    ArrayList<Integer> ansfrombelow = find2(arr,target,index+1);
    list.addAll(ansfrombelow);
    return list;

 }




















     























}
