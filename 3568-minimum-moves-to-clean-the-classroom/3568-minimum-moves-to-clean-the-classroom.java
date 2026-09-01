import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int startR = -1, startC = -1;
        List<int[]> litterList = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = classroom[i].charAt(j);
                if (ch == 'S') {
                    startR = i;
                    startC = j;
                } else if (ch == 'L') {
                    litterList.add(new int[]{i, j});
                }
            }
        }

        int k = litterList.size();
        if (k == 0) return 0;
        int targetMask = (1 << k) - 1;

        int[][] litterIdx = new int[m][n];
        for (int[] row : litterIdx) Arrays.fill(row, -1);
        for (int i = 0; i < k; i++) {
            int[] pos = litterList.get(i);
            litterIdx[pos[0]][pos[1]] = i;
        }

        int[][][] maxEnergy = new int[m][n][1 << k];
        for (int[][] mat : maxEnergy) {
            for (int[] row : mat) {
                Arrays.fill(row, -1);
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startR, startC, 0, energy, 0});
        maxEnergy[startR][startC][0] = energy;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int mask = curr[2];
            int e = curr[3];
            int moves = curr[4];

            if (mask == targetMask) {
                return moves;
            }

            if (e == 0) continue; // Out of energy, cannot move further

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    char cell = classroom[nr].charAt(nc);
                    if (cell == 'X') continue;

                    int nextMask = mask;
                    if (litterIdx[nr][nc] != -1) {
                        nextMask |= (1 << litterIdx[nr][nc]);
                    }

                    int nextEnergy = e - 1;
                    // If moving into a recharge station 'R', restore energy
                    if (cell == 'R') {
                        nextEnergy = energy;
                    }

                    // Only visit if we reach this state with strictly more remaining energy
                    if (nextEnergy > maxEnergy[nr][nc][nextMask]) {
                        maxEnergy[nr][nc][nextMask] = nextEnergy;
                        queue.offer(new int[]{nr, nc, nextMask, nextEnergy, moves + 1});
                    }
                }
            }
        }

        return -1;
    }
}