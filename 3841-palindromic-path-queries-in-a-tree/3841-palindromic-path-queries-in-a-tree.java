import java.util.*;

class Solution {
    private List<List<Integer>> adj;
    private int[] parent, depth, heavy, head, pos, subtreeSize;
    private int curPos;
    private int[] tree;
    private int[] nodeMasks;

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        parent = new int[n];
        depth = new int[n];
        heavy = new int[n];
        head = new int[n];
        pos = new int[n];
        subtreeSize = new int[n];
        Arrays.fill(heavy, -1);

        dfs1(0, -1, 0);
        curPos = 0;
        dfs2(0, 0);

        // Segment tree setup
        tree = new int[4 * n];
        nodeMasks = new int[n];
        for (int i = 0; i < n; i++) {
            nodeMasks[i] = 1 << (s.charAt(i) - 'a');
            updateTree(1, 0, n - 1, pos[i], nodeMasks[i]);
        }

        List<Boolean> result = new ArrayList<>();
        for (String qStr : queries) {
            String[] q = qStr.split(" ");
            if (q[0].equals("update")) {
                int u = Integer.parseInt(q[1]);
                char newChar = q[2].charAt(0);
                int newMask = 1 << (newChar - 'a');
                nodeMasks[u] = newMask;
                updateTree(1, 0, n - 1, pos[u], newMask);
            } else {
                int u = Integer.parseInt(q[1]);
                int v = Integer.parseInt(q[2]);
                int pathMask = queryPath(u, v, n);
                // Check if at most one bit is set (palindrome condition)
                boolean isPalindrome = (pathMask & (pathMask - 1)) == 0;
                result.add(isPalindrome);
            }
        }

        return result;
    }

    private void dfs1(int u, int p, int d) {
        parent[u] = p;
        depth[u] = d;
        subtreeSize[u] = 1;
        int maxSub = 0;
        for (int v : adj.get(u)) {
            if (v != p) {
                dfs1(v, u, d + 1);
                subtreeSize[u] += subtreeSize[v];
                if (subtreeSize[v] > maxSub) {
                    maxSub = subtreeSize[v];
                    heavy[u] = v;
                }
            }
        }
    }

    private void dfs2(int u, int h) {
        head[u] = h;
        pos[u] = curPos++;
        if (heavy[u] != -1) {
            dfs2(heavy[u], h);
        }
        for (int v : adj.get(u)) {
            if (v != parent[u] && v != heavy[u]) {
                dfs2(v, v);
            }
        }
    }

    private void updateTree(int node, int start, int end, int idx, int val) {
        if (start == end) {
            tree[node] = val;
            return;
        }
        int mid = start + (end - start) / 2;
        if (start <= idx && idx <= mid) {
            updateTree(2 * node, start, mid, idx, val);
        } else {
            updateTree(2 * node + 1, mid + 1, end, idx, val);
        }
        tree[node] = tree[2 * node] ^ tree[2 * node + 1];
    }

    private int queryTree(int node, int start, int end, int l, int r) {
        if (r < start || end < l) return 0;
        if (l <= start && end <= r) return tree[node];
        int mid = start + (end - start) / 2;
        return queryTree(2 * node, start, mid, l, r) ^ queryTree(2 * node + 1, mid + 1, end, l, r);
    }

    private int queryPath(int u, int v, int n) {
        int res = 0;
        while (head[u] != head[v]) {
            if (depth[head[u]] > depth[head[v]]) {
                int temp = u; u = v; v = temp;
            }
            res ^= queryTree(1, 0, n - 1, pos[head[v]], pos[v]);
            v = parent[head[v]];
        }
        if (depth[u] > depth[v]) {
            int temp = u; u = v; v = temp;
        }
        res ^= queryTree(1, 0, n - 1, pos[u], pos[v]);
        return res;
    }
}