
import java.util.*;

class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {

        int n = parent.length;

        List<Integer>[] tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }

        int[] newParent = parent.clone();
        int[] last = new int[26];
        int[] prev = new int[n];
        int[] order = new int[n];
        int[] stack = new int[2 * n + 5];

        Arrays.fill(last, -1);

        int top = 0;
        int count = 0;

        stack[top++] = 1;

        while (top > 0) {

            int event = stack[--top];

            if (event > 0) {

                int u = event - 1;
                int c = s.charAt(u) - 'a';

                prev[u] = last[c];

                if (last[c] != -1) {
                    newParent[u] = last[c];
                }

                last[c] = u;
                order[count++] = u;

                stack[top++] = -(u + 1);

                for (int i = tree[u].size() - 1; i >= 0; i--) {
                    stack[top++] = tree[u].get(i) + 1;
                }

            } else {

                int u = -event - 1;
                int c = s.charAt(u) - 'a';

                last[c] = prev[u];
            }
        }

        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        for (int i = n - 1; i > 0; i--) {
            int u = order[i];
            ans[newParent[u]] += ans[u];
        }

        return ans;
    }
}
