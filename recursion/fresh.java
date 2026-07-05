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



}
