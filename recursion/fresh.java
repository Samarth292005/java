class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        int[] suffixMin = new int[n];

        suffixMin[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]);
        }

        int prefixMax = nums[0];

        for (int i = 0; i < n; i++) {
            prefixMax = Math.max(prefixMax, nums[i]);

            if (prefixMax - suffixMin[i] <= k) {
                return i;
            }
        }

        return -1;
    }
}

class Solution {

    import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 9, 1, 3};
        Arrays.sort(numbers);
        
        // Output: [1, 2, 3, 5, 9]
        System.out.println(Arrays.toString(numbers)); 
        
        String[] fruits = {"Orange", "Apple", "Banana"};
        Arrays.sort(fruits);
        
        // Output: [Apple, Banana, Orange]
        System.out.println(Arrays.toString(fruits));
    }
}

    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }

            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        int left = Math.min(minIndex, maxIndex);
        int right = Math.max(minIndex, maxIndex);

        int fromFront = right + 1;
        int fromBack = n - left;
        int fromBoth = (left + 1) + (n - right);

        return Math.min(fromFront, Math.min(fromBack, fromBoth));
    }
}package recursion;


class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {

        int n = nums.length;

        // [value, original index]
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        // Sort by value
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int start = 0;

        while (start < n) {

            int end = start;

            // Find one connected group
            while (end + 1 < n &&
                   arr[end + 1][0] - arr[end][0] <= limit) {
                end++;
            }

            // Get original indices of this group
            int[] indices = new int[end - start + 1];

            for (int i = start; i <= end; i++) {
                indices[i - start] = arr[i][1];
            }

            // Sort original indices
            Arrays.sort(indices);

            // Values are already sorted
            for (int i = 0; i < indices.length; i++) {
                nums[indices[i]] = arr[start + i][0];
            }

            start = end + 1;
        }

        return nums;
    }
}
class Solution {
    

    public String lexPalindromicPermutation(String s, String target) {

        int n = s.length();
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int odd = 0;
        char mid = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                odd++;
                mid = (char) ('a' + i);
            }
        }

        if (odd > 1) {
            return "";
        }

        int[] half = new int[26];

        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
        }

        int len = n / 2;

        // Case 1: left half exactly equals target's left half
        // and middle character makes the palindrome greater.
        if (n % 2 == 1) {

            int[] temp = half.clone();
            boolean possible = true;

            for (int i = 0; i < len; i++) {

                int c = target.charAt(i) - 'a';

                if (temp[c] == 0) {
                    possible = false;
                    break;
                }

                temp[c]--;
            }

            if (possible && mid > target.charAt(len)) {

                char[] left = new char[len];

                for (int i = 0; i < len; i++) {
                    left[i] = target.charAt(i);
                }

                return makePalindrome(left, mid, n);
            }
        }

        // Case 2: Make the left half greater
        for (int pos = len - 1; pos >= 0; pos--) {

            int[] temp = half.clone();
            boolean possible = true;

            // Match target before pos
            for (int i = 0; i < pos; i++) {

                int c = target.charAt(i) - 'a';

                if (temp[c] == 0) {
                    possible = false;
                    break;
                }

                temp[c]--;
            }

            if (!possible) {
                continue;
            }

            int targetChar = target.charAt(pos) - 'a';

            // Choose smallest character greater than target[pos]
            for (int c = targetChar + 1; c < 26; c++) {

                if (temp[c] > 0) {

                    temp[c]--;

                    char[] left = new char[len];

                    // Copy target prefix
                    for (int i = 0; i < pos; i++) {
                        left[i] = target.charAt(i);
                    }

                    // Bigger character at pos
                    left[pos] = (char) ('a' + c);

                    // Fill rest with smallest characters
                    int index = pos + 1;

                    for (int x = 0; x < 26; x++) {
                        while (temp[x] > 0) {
                            left[index++] = (char) ('a' + x);
                            temp[x]--;
                        }
                    }

                    return makePalindrome(left, mid, n);
                }
            }
        }

        return "";
    }

    private String makePalindrome(char[] left, char mid, int n) {

        StringBuilder ans = new StringBuilder();

        for (char c : left) {
            ans.append(c);
        }

        if (n % 2 == 1) {
            ans.append(mid);
        }

        for (int i = left.length - 1; i >= 0; i--) {
            ans.append(left[i]);
        }

        return ans.toString();
    }
}
class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder prefix = new StringBuilder();
        int i = 0;

        // Match target as long as possible
        while (i < n && freq[target.charAt(i) - 'a'] > 0) {
            freq[target.charAt(i) - 'a']--;
            prefix.append(target.charAt(i));
            i++;
        }

        // Start from the last valid position
        int start = Math.min(i, n - 1);

        for (int pos = start; pos >= 0; pos--) {

            // Restore target[pos] if it was part of the matched prefix
            if (pos < i) {
                freq[target.charAt(pos) - 'a']++;
            }

            // Find smallest available character > target[pos]
            for (char c = (char)(target.charAt(pos) + 1); c <= 'z'; c++) {

                if (freq[c - 'a'] > 0) {

                    StringBuilder result =
                        new StringBuilder(prefix.substring(0, pos));

                    result.append(c);
                    freq[c - 'a']--;

                    // Add remaining characters in sorted order
                    for (char x = 'a'; x <= 'z'; x++) {
                        while (freq[x - 'a'] > 0) {
                            result.append(x);
                            freq[x - 'a']--;
                        }
                    }

                    return result.toString();
                }
            }
        }

        return "";
    }
}
class Solution {
    public int missingMultiple(int[] nums, int k) {
        for (int i = 1; ; i++) {
            int ele = i * k;
            boolean found = false;

            for (int j = 0; j < nums.length; j++) {
                if (ele == nums[j]) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                return ele;
            }
        }
    }
}
}
class Solution {
    public int thirdMax(int[] nums) {
        Long first = null;
        Long second = null;
        Long third = null;

        for (int num : nums) {

            if (first != null && num == first ||
                second != null && num == second ||
                third != null && num == third) {
                continue;
            }

            if (first == null || num > first) {
                third = second;
                second = first;
                first = (long) num;
            }
            else if (second == null || num > second) {
                third = second;
                second = (long) num;
            }
            else if (third == null || num > third) {
                third = (long) num;
            }
        }

        return third == null ? first.intValue() : third.intValue();
    }
}
class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.add(num);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }
}
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
public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int arr[] = new int[nums.length+1];
        arr[0] = 0;
        for(int i=0;i<nums.length;i++)
        {
            arr[nums[i]] = nums[i]; 
        }
        for(int i=1;i<nums.length+1;i++)
        {
            if(arr[i] == 0)
            {
                list.add(i);
            }
        }
        return list;
    }
public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        int[][] dist = new int[m][n];
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);

        Deque<int[]> dq = new ArrayDeque<>();

        dist[0][0] = grid.get(0).get(0);
        dq.offerFirst(new int[]{0, 0});

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int r = cur[0];
            int c = cur[1];

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr < 0 || nc < 0 || nr >= m || nc >= n)
                    continue;

                int cost = grid.get(nr).get(nc);

                if (dist[r][c] + cost < dist[nr][nc]) {
                    dist[nr][nc] = dist[r][c] + cost;

                    if (cost == 0)
                        dq.offerFirst(new int[]{nr, nc});
                    else
                        dq.offerLast(new int[]{nr, nc});
                }
            }
        }

        return dist[m - 1][n - 1] < health;
    }

public int minScore(int n, int[][] roads) {

        List<int[]>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int[] r : roads) {
            graph[r[0]].add(new int[]{r[1], r[2]});
            graph[r[1]].add(new int[]{r[0], r[2]});
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n + 1];

        q.offer(1);
        vis[1] = true;

        int ans = Integer.MAX_VALUE;

        while (!q.isEmpty()) {

            int node = q.poll();

            for (int[] nei : graph[node]) {

                ans = Math.min(ans, nei[1]);

                if (!vis[nei[0]]) {
                    vis[nei[0]] = true;
                    q.offer(nei[0]);
                }
            }
        }

        return ans;
    }

class Solution {

    class DSU {

        int[] parent;

        DSU(int n) {
            parent = new int[n + 1];
            for (int i = 1; i <= n; i++)
                parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int a, int b) {
            parent[find(a)] = find(b);
        }
    }

    public int minScore(int n, int[][] roads) {

        DSU dsu = new DSU(n);

        for (int[] r : roads)
            dsu.union(r[0], r[1]);

        int root = dsu.find(1);

        int ans = Integer.MAX_VALUE;

        for (int[] r : roads) {
            if (dsu.find(r[0]) == root)
                ans = Math.min(ans, r[2]);
        }

        return ans;
    }
}

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{};
}
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    int carry = 0;

    while (l1 != null || l2 != null || carry != 0) {
        int sum = carry;

        if (l1 != null) {
            sum += l1.val;
            l1 = l1.next;
        }

        if (l2 != null) {
            sum += l2.val;
            l2 = l2.next;
        }

        carry = sum / 10;
        curr.next = new ListNode(sum % 10);
        curr = curr.next;
    }

    return dummy.next;
}
public int lengthOfLongestSubstring(String s) {
    HashMap<Character, Integer> map = new HashMap<>();
    int left = 0, maxLen = 0;

    for (int right = 0; right < s.length(); right++) {
        char ch = s.charAt(right);

        if (map.containsKey(ch) && map.get(ch) >= left) {
            left = map.get(ch) + 1;
        }

        map.put(ch, right);
        maxLen = Math.max(maxLen, right - left + 1);
    }

    return maxLen;
}
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry == 1) {

            int sum = carry;

            if (i >= 0)
                sum += a.charAt(i--) - '0';

            if (j >= 0)
                sum += b.charAt(j--) - '0';

            ans.append(sum % 2);
            carry = sum / 2;
        }

        return ans.reverse().toString();
    }
    class Solution {
    public long sumAndMultiply(int n) {
        if (n == 0) return 0;

        int temp = n;
        int divisor = 1;

        while (temp >= 10) {
            temp /= 10;
            divisor *= 10;
        }

        long x = 0;
        long sum = 0;

        while (divisor > 0) {
            int digit = n / divisor;
            n %= divisor;
            divisor /= 10;

            if (digit != 0) {
                x = x * 10 + digit;
                sum += digit;
            }
        }

        return x * sum;
    }
}
}

class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}
class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] component = new int[n];

        component[0] = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                component[i] = component[i - 1];
            } else {
                component[i] = component[i - 1] + 1;
            }
        }

        boolean[] ans = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            ans[i] = component[u] == component[v];
        }

        return ans;
    }
}
class Solution {
    public int lengthOfLastWord(String s) {
        int c=0;
        int k = s.length() - 1;
        while(s.charAt(k) == ' ')
        {
            k--;
        }
     for(int i=k;i>=0;i--)
     {
        if(s.charAt(i)==' ')
        {
            return c;
        }
        c++;
     }
     return c;
    }
}
class Solution {
    public int singleNumber(int[] nums) {
        int ans=0;
        for(int i=0;i<nums.length;i++)
        {
            ans = ans ^ nums[i];
        }
        return ans;
    }
}
class Solution {
    public int xorOperation(int n, int start) {
        int ans = 0;
        for(int i = 0;i<n;i++)
        {
            int e = start + (2*i);
            ans = ans ^ e;
        }
        return ans;
    }
}
import java.util.*;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        HashMap<Integer, Integer> rank = new HashMap<>();
        int r = 1;

        // Assign ranks to unique elements
        for (int num : sorted) {
            if (!rank.containsKey(num)) {
                rank.put(num, r++);
            }
        }

        // Replace each element with its rank
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rank.get(arr[i]);
        }

        return arr;
    }
}
class Solution {
    public int reverseBits(int n) {
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            int lastBit = n & 1;
            ans = (ans << 1) | lastBit;
            n >>>= 1;      // unsigned right shift
        }

        return ans;
    }
}
class Solution {
    private static final int MOD = 1_000_000_007;

    public int subsequencePairCount(int[] nums) {
        int max = 0;
        for (int x : nums) max = Math.max(max, x);

        long[][] dp = new long[max + 1][max + 1];
        dp[0][0] = 1;

        for (int x : nums) {
            long[][] next = new long[max + 1][max + 1];

            for (int g1 = 0; g1 <= max; g1++) {
                for (int g2 = 0; g2 <= max; g2++) {
                    if (dp[g1][g2] == 0) continue;

                    long ways = dp[g1][g2];

                    // Ignore x
                    next[g1][g2] = (next[g1][g2] + ways) % MOD;

                    // Put x in first subsequence
                    int ng1 = (g1 == 0) ? x : gcd(g1, x);
                    next[ng1][g2] = (next[ng1][g2] + ways) % MOD;

                    // Put x in second subsequence
                    int ng2 = (g2 == 0) ? x : gcd(g2, x);
                    next[g1][ng2] = (next[g1][ng2] + ways) % MOD;
                }
            }

            dp = next;
        }

        long ans = 0;
        for (int g = 1; g <= max; g++) {
            ans = (ans + dp[g][g]) % MOD;
        }

        return (int) ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
    return n;
        import java.util.*;

class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixGcd = new int[n];

        int mx = 0;
        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, nums[i]);
            prefixGcd[i] = gcd(nums[i], mx);
        }

        Arrays.sort(prefixGcd);

        long ans = 0;
        int l = 0, r = n - 1;
        while (l < r) {
            ans += gcd(prefixGcd[l], prefixGcd[r]);
            l++;
            r--;
        }

        return ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;

        Node node = map.get(key);
        remove(node);
        insert(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            Node old = map.get(key);
            remove(old);
            map.remove(key);
        }

        if (map.size() == capacity) {
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }

        Node node = new Node(key, value);
        insert(node);
        map.put(key, node);
    }
}
import java.util.*;

class Solution {
    public String smallestSubsequence(String s) {
        int[] count = new int[26];
        boolean[] inStack = new boolean[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            count[c - 'a']--;

            if (inStack[c - 'a']) continue;

            while (!stack.isEmpty()
                    && stack.peekLast() > c
                    && count[stack.peekLast() - 'a'] > 0) {
                inStack[stack.removeLast() - 'a'] = false;
            }

            stack.addLast(c);
            inStack[c - 'a'] = true;
        }

        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append(stack.removeFirst());
        }

        return ans.toString();
    }
}class Solution {
    public String smallestSubsequence(String s) {
        int[] freq = new int[26];
        boolean[] used = new boolean[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            freq[c - 'a']--;

            if (used[c - 'a']) continue;

            while (sb.length() > 0 &&
                   sb.charAt(sb.length() - 1) > c &&
                   freq[sb.charAt(sb.length() - 1) - 'a'] > 0) {

                used[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }

            sb.append(c);
            used[c - 'a'] = true;
        }

        return sb.toString();
    }
}
class Solution {
    public String smallestSubsequence(String s) {
        int[] count = new int[26];
        boolean[] vis = new boolean[26];

        for (char c : s.toCharArray())
            count[c - 'a']++;

        char[] stack = new char[26];
        int top = -1;

        for (char c : s.toCharArray()) {
            count[c - 'a']--;

            if (vis[c - 'a']) continue;

            while (top >= 0 &&
                   stack[top] > c &&
                   count[stack[top] - 'a'] > 0) {

                vis[stack[top] - 'a'] = false;
                top--;
            }

            stack[++top] = c;
            vis[c - 'a'] = true;
        }

        return new String(stack, 0, top + 1);
    }
}
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;

        k %= total;

        int[][] ans = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int oldIndex = i * n + j;
                int newIndex = (oldIndex + k) % total;

                int newRow = newIndex / n;
                int newCol = newIndex % n;

                ans[newRow][newCol] = grid[i][j];
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(ans[i][j]);
            }
            res.add(row);
        }

        return res;
    }
}
class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int ans = 0;
        int mx = 0;
        int pre = Integer.MIN_VALUE;

        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }

            int len = j - i;

            if (s.charAt(i) == '1') {
                ans += len;
            } else {
                mx = Math.max(mx, pre + len);
                pre = len;
            }

            i = j;
        }

        return ans + mx;
    }
}
class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        // Step 1: Find the first decreasing element from the right
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: If such an element exists, find the next greater element
        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        // Step 3: Reverse the suffix
        reverse(nums, i + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{};
    }
        }
    }
}
class Solution {
    public int uniqueXorTriplets(int[] nums) {
        final int MAX = 2048;

        boolean[][] dp = new boolean[4][MAX];
        dp[0][0] = true;

        for (int num : nums) {
            for (int cnt = 3; cnt >= 1; cnt--) {
                for (int x = 0; x < MAX; x++) {
                    if (dp[cnt - 1][x]) {
                        dp[cnt][x ^ num] = true;
                    }
                }
            }
        }

        int ans = 0;
        for (int x = 0; x < MAX; x++) {
            if (dp[1][x] || dp[3][x]) {
                ans++;
            }
        }

        return ans;
    }
    class Solution {
    public int maxProduct(int n) {
        int max1 = 0;
        int max2 = 0;
        while(n != 0)
        {
            int k = n % 10;
            n = n/10;
            if(k>=max1)
            {
                max2 = max1;
                max1 = k;
            }
            else if(k>max2 && k<max1)
            {
                max2 = k;
            }
        }
        return max1*max2;
    }
}
    class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);       // Odd length
            int len2 = expand(s, i, i + 1);   // Even length
            int len = Math.max(len1, len2);

            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() &&
               s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
}
class Solution {
    public int maxProduct(int[] nums) {
        int max1 = 0;
        int max2 = 0;

        for (int num : nums) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }

        return (max1 - 1) * (max2 - 1);
    }
}class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder left = new StringBuilder();
        String middle = "";

        for (int i = 0; i < 26; i++) {
            if ((freq[i] & 1) == 1) {
                middle = String.valueOf((char) ('a' + i));
            }

            for (int j = 0; j < freq[i] / 2; j++) {
                left.append((char) ('a' + i));
            }
        }

        StringBuilder right = new StringBuilder(left).reverse();

        return left.toString() + middle + right.toString();
    }
}
class Solution {
    public int minimumPushes(String word) {
     if(word.length()<=8)
     {
        return word.length();
     }   
     else if(word.length()>8 && word.length()<=16)
     {
        return 8 + ((word.length()-8) * 2);
     }
     else if(word.length()>16 && word.length()<=24)
     {
        return 8 + (8*2) + ((word.length()-16)*3);
     }
     else{
        return 8 + (8*2) + (8*3) + ((word.length()-24)*4);
     }
    }
    class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];

        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        Arrays.sort(freq);

        int ans = 0;
        int idx = 0;

        // Traverse from largest frequency to smallest
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0) break;

            int cost = idx / 8 + 1;
            ans += freq[i] * cost;
            idx++;
        }

        return ans;
    }
}
}class Solution {
    int[][] dp;

    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        return solve(0, n - 1, nums) >= 0;
    }

    private int solve(int i, int j, int[] nums) {
        if (i == j) return nums[i];

        if (dp[i][j] != Integer.MIN_VALUE)
            return dp[i][j];

        int left = nums[i] - solve(i + 1, j, nums);
        int right = nums[j] - solve(i, j - 1, nums);

        return dp[i][j] = Math.max(left, right);
    }
}
class Solution {
    public boolean stoneGame(int[] piles) {
        return true;
    }
    class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> list = new ArrayList<>();
       for(int i=left;i<=right;i++)
       {
        int num = i;
        int num2 = i;
        int n = 0;
        while(num != 0)
        {
          int k = num % 10;
          if(k==0)
          {
            n =1;
            break;
          }
          if(num2 % k != 0)
          {
            n = 1;
            break;
          }
          num = num/10;
        }
        if(n==0)
        {
            list.add(i);
         
        }
        
       }
       return list;
     
    }
}
    class Solution {
    public int arrangeCoins(int n) {
        int rem = n;
        int i = 1;
        int c = 0;

        while (rem >= i) {
            rem -= i;
            c++;
            i++;
        }

        return c;
    }
}
    class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : invocations) {
            graph.get(edge[0]).add(edge[1]);
        }

        boolean[] suspicious = new boolean[n];

        Queue<Integer> q = new LinkedList<>();
        q.offer(k);
        suspicious[k] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int next : graph.get(curr)) {
                if (!suspicious[next]) {
                    suspicious[next] = true;
                    q.offer(next);
                }
            }
        }

        for (int[] edge : invocations) {
            int from = edge[0];
            int to = edge[1];

            if (!suspicious[from] && suspicious[to]) {
                List<Integer> ans = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    ans.add(i);
                }
                return ans;
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) {
                ans.add(i);
            }
        }

        return ans;
    }
}
    class Solution {
    public int smallestNumber(int n, int t) {
       int num = n;
        int mul = 1;
        while(true){
            int kk = num;
            while(kk!=0)
            {
                int m = kk % 10;
                mul = m * mul;
                kk = kk / 10;
            }
            if(mul % t==0)
            {
                break;
            }
            mul = 1;
            num = num + 1;
        }
        return num;
    }
}
    class Solution {
    public int findComplement(int num) {
        int mask = 1;

        while (mask < num) {
            mask = (mask << 1) | 1;
        }

        return mask ^ num;
    }
}
    class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;

        // suffix[i] = sum of piles from i to n-1
        int[] suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        // dp[i][m] = maximum stones current player can get
        // starting from index i with M = m
        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {

            for (int m = 1; m <= n; m++) {

                // Can take all remaining piles
                if (i + 2 * m >= n) {
                    dp[i][m] = suffix[i];
                    continue;
                }

                int best = 0;

                for (int x = 1; x <= 2 * m && i + x <= n; x++) {

                    int opponent = dp[i + x][Math.max(m, x)];

                    int current = suffix[i] - opponent;

                    best = Math.max(best, current);
                }

                dp[i][m] = best;
            }
        }

        return dp[0][1];
    }
}
    class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int num : nums1) {
            set.add(num);
        }

        for (int num : nums2) {
            if (set.contains(num)) {
                list.add(num);
                set.remove(num);
            }
        }

        int[] ans = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}
}
class Solution {
    public int missingInteger(int[] nums) {
        int sum = nums[0];

        // Find sequential prefix sum
        int i = 1;
        while (i < nums.length && nums[i] == nums[i - 1] + 1) {
            sum += nums[i];
            i++;
        }

        // Find smallest integer >= sum that is not in nums
        while (contains(sum, nums)) {
            sum++;
        }

        return sum;
    }

    public boolean contains(int n, int[] nums) {
        for (int num : nums) {
            if (num == n) {
                return true;
            }
        }
        return false;
    }
}
class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num==1)
        {
            return false;
        }
    int s=1;
      for(int i=2;i<=num/2;i++)
      {
        if(num % i==0)
        {
            s+=i;
        }
      }  
      if(s==num)
      {
        return true;
      }
      return false;
    }
    class Solution {
    public boolean canAliceWin(int[] nums) {
        int s=0,d=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<10)
            {
              s+=nums[i];
            }
            else{
                d+=nums[i];
            }
        }
        if(d==s)
        {
            return false;
        }
        return true;
    }
}
    class Solution {
    public int maximumLengthSubstring(String s) {
        int[] freq = new int[26];
        int left = 0;
        int ans = 0;

        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'a']++;

            while (freq[s.charAt(right) - 'a'] > 2) {
                freq[s.charAt(left) - 'a']--;
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
    class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int low = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;

        for (int high = 0; high < nums.length; high++) {
            sum += nums[high];

            while (sum >= target) {
                res = Math.min(res, high - low + 1);
                sum -= nums[low];
                low++;
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
class Solution {
    public boolean stoneGameIX(int[] stones) {
        int c0 = 0, c1 = 0, c2 = 0;

        // Count stones by remainder when divided by 3
        for (int stone : stones) {
            int rem = stone % 3;

            if (rem == 0) {
                c0++;
            } else if (rem == 1) {
                c1++;
            } else {
                c2++;
            }
        }

        // If count of remainder-0 stones is even
        if (c0 % 2 == 0) {
            return c1 > 0 && c2 > 0;
        }

        // If count of remainder-0 stones is odd
        return Math.abs(c1 - c2) > 2;
    }
}
    class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;

        for (int x = low; x <= high; x++) {
            String s = String.valueOf(x);
            int n = s.length();

            // Odd number of digits can never be symmetric
            if (n % 2 != 0) {
                continue;
            }

            int half = n / 2;
            int leftSum = 0;
            int rightSum = 0;

            for (int i = 0; i < half; i++) {
                leftSum += s.charAt(i) - '0';
                rightSum += s.charAt(i + half) - '0';
            }

            if (leftSum == rightSum) {
                count++;
            }
        }

        return count;
    }
}
    class Solution {
    public int pivotIndex(int[] nums) {
        int p[] = new int[nums.length];
        int s[] = new int[nums.length];
        p[0] = nums[0];
        s[nums.length-1] = nums[nums.length-1];
        for(int i=1;i<nums.length;i++)
        {
            p[i] = p[i-1] + nums[i];
        }
          for(int i=nums.length-2;i>=0;i--)
        {
            s[i] = s[i+1] + nums[i];
        }
        for(int i=0;i<nums.length;i++)
        {
            if(p[i]==s[i])
            {
                return i;
            }
        }
        return -1;
    }
}
    class NumArray {

int nums[];
    public NumArray(int[] nums) {
       
        this.nums = nums;
        for(int i=1;i<nums.length;i++)
        {
            nums[i] = nums[i-1] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        if(left!=0)
        {
        return nums[right]-nums[left-1];
        }
        return nums[right];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
}
import java.util.*;
class Solution {
    public int[] resultArray(int[] nums) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        int ans[] = new int[nums.length];
         arr1.add(nums[0]);
        arr2.add(nums[1]);
        int one=0,two=0;
        for(int i=2;i<nums.length;i++)
        {
            if(arr1.get(one)>arr2.get(two))
            {
                arr1.add(nums[i]);
                one++;
            }
            else{
                arr2.add(nums[i]);
                two++;
            }
        }
        for(int i=0;i<arr1.size();i++)
        {
          ans[i] = arr1.get(i);
        }
        for(int i=0;i<arr2.size();i++)
        {
          ans[i+arr1.size()] = arr2.get(i);
        }
        return ans;


    }
    class Solution {
    public int countPrimes(int n) {

        if (n <= 2) {
            return 0;
        }

        boolean[] prime = new boolean[n];

        // Assume all numbers from 2 to n-1 are prime
        for (int i = 2; i < n; i++) {
            prime[i] = true;
        }

        // Sieve
        for (int i = 2; i * i < n; i++) {

            if (prime[i]) {

                for (int j = i * i; j < n; j += i) {
                    prime[j] = false;
                }
            }
        }

        // Count primes
        int count = 0;

        for (int i = 2; i < n; i++) {
            if (prime[i]) {
                count++;
            }
        }

        return count;
    }
}
}
                        }
}
