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

    import java.util.Arrays;

class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {

        Arrays.sort(arr);

        arr[0] = 1;

        for(int i = 1; i < arr.length; i++) {
            arr[i] = Math.min(arr[i], arr[i - 1] + 1);
        }

        return arr[arr.length - 1];
    }
}
class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int c=0;
        for(int i=0;i<patterns.length;i++)
        {
            if(word.contains(patterns[i]))
            {
                c++;
            }
        }
        return c;
    }
}
class Solution {
    public int numberOfSubstrings(String s) {
        int[] freq = new int[3];
        int left = 0;
        int ans = 0;
        int n = s.length();

        for (int right = 0; right < n; right++) {
            // Add current character to the window
            freq[s.charAt(right) - 'a']++;

            // While the window contains at least one 'a', 'b', and 'c'
            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                // All substrings ending from 'right' to 'n-1' are valid
                ans += (n - right);

                // Shrink the window from the left
                freq[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return ans;
    }
}
}
