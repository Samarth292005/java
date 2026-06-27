package recursion;

import java.util.ArrayList;
import java.util.List;

public class recursion35 {
  public static void main(String[] args)
  {
      boolean[][] maze = {
    {true,  true,  true},
    {true,  false, true},
    {true,  true,  true}
};

pathobs("", maze, 0, 0);
  } 
  static int count(int r,int c)
  {
    if(r==1 || c==1)
    {
        return 1;
    } 
    int left = count(r-1,c);
    int right = count(r,c-1);
    return right + left;

  }   

  static void path(String p,int r,int c)
  {
    if(r==1 && c==1)
    {
        System.out.println(p);
        return;
    }
    if(r>1)
    {
        path(p+"V",r-1,c);
    }
    if(c>1)
    {
        path(p+"H",r,c-1);
    }
    if(r>1 && c>1)
    {
        path(p+"D",r-1,c-1);
    }
  }

  static void pathobs(String p,boolean[][] maze,int r,int c)
  {
    if(r==maze.length-1 && c==maze[0].length-1)
    {
        System.out.println(p);
        return;
    }
    if(!maze[r][c])
    {
        return;
    }
    if(r<maze.length-1)
    {
        pathobs(p+"D",maze,r+1,c);
    }
    if(c<maze[0].length-1)
    {
        pathobs(p+"R",maze,r,c+1);
    }

  }
   public List<String> fizzBuzz(int n) {
        ArrayList<String> list = new ArrayList<>();
        for(int i=1;i<=n;i++)
        {
            if(i%3==0 && i%5==0)
            {
                list.add("FizzBuzz");
            }
            else if(i%3==0)
            {
                list.add("Fizz");
            }
            else if(i%5==0)
            {
                list.add("Buzz");
            }
            else{
                list.add(Integer.toString(i));
            }
        }
        return list;
    }


}
