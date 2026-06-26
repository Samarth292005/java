package recursion;

import java.util.*;
public class recursion4 {
    public static void main(String[] args)
    {
       int a[] = {4,3,2,1};
       ss(a,a.length,0,0);
       System.out.println(Arrays.toString(a));
    }
    public static void pat(int row,int col)
    {
        if(row==0)
        {
            return;
        }
        else if(col<row)
        {
          System.out.print("*");
          pat(row,col+1);
        }
        else{
            System.out.println("");
            pat(row-1,0);
        }
    }
    public static void pat2(int row,int col)
    {
        if(row==0)
        {
            return;
        }
        else if(col<row)
        {
             pat2(row,col+1);
          System.out.print("*");
         
        }
        else{
             pat2(row-1,0);
            System.out.println("");
           
        }

    }


    public static void bubbleSort(int arr[],int r,int c)
    {
        if(r==0)
        {
            return;
        }
        else if(c<r)
        {
            if(arr[c]>arr[c+1])
            {
                int temp = arr[c];
                arr[c] = arr[c+1];
                arr[c+1] = temp;
            }
            bubbleSort(arr,r,c+1);
        
        }
        else{
            bubbleSort(arr,r-1,0);
        }
    }
         public static void ss(int arr[],int r,int c,int max)
         {
            if(r==0)
            {
                return;
            }
            else if(c<r)
            {
                if(arr[c]>arr[max])
                {
                    max = c;
                }
                ss(arr,r,c+1,max);
            }
            else{
                int temp = arr[r-1];
                arr[r-1] = arr[max];
                arr[max] = temp;
                ss(arr,r-1,0,0);


            }
         }
}
