import java.util.PriorityQueue;

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;
        int[] ans = new int[m];
        
        // Priority queue for available servers: sorted by weight, then by index
        PriorityQueue<int[]> freeServers = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]); // compare weights
            }
            return Integer.compare(a[1], b[1]); // compare indices
        });
        
        // Priority queue for busy servers: sorted by free time, then weight, then index
        PriorityQueue<int[]> busyServers = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]); // compare free time
            }
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]); // compare weights
            }
            return Integer.compare(a[2], b[2]); // compare indices
        });
        
        // Initialize free servers with [weight, index]
        for (int i = 0; i < n; i++) {
            freeServers.offer(new int[] { servers[i], i });
        }
        
        long currentTime = 0;
        for (int j = 0; j < m; j++) {
            currentTime = Math.max(currentTime, j);
            
            // Move servers from busy to free if their work is done by currentTime
            while (!busyServers.isEmpty() && busyServers.peek()[0] <= currentTime) {
                int[] busy = busyServers.poll();
                freeServers.offer(new int[] { busy[1], busy[2] }); // [weight, index]
            }
            
            // If no servers are available, jump time to the next freeing server
            if (freeServers.isEmpty()) {
                currentTime = busyServers.peek()[0];
                while (!busyServers.isEmpty() && busyServers.peek()[0] <= currentTime) {
                    int[] busy = busyServers.poll();
                    freeServers.offer(new int[] { busy[1], busy[2] });
                }
            }
            
            // Assign the task to the best available server
            int[] server = freeServers.poll();
            int serverWeight = server[0];
            int serverIndex = server[1];
            
            ans[j] = serverIndex;
            
            // Push the server to busy heap with its free time: [freeTime, weight, index]
            long freeTime = currentTime + tasks[j];
            busyServers.offer(new int[] { (int) freeTime, serverWeight, serverIndex });
        }
        
        return ans;
    }
}