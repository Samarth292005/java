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
                        }
}
