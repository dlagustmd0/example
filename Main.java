package net.dlagustmd0;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("첫 번째 줄에는 깊이를 입력하고 두 번째 줄에는 정점 수를 입력해주세요.");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maxDepth = Integer.parseInt(reader.readLine()), L = Integer.parseInt(reader.readLine());
        int[] cache = new int[maxDepth];

        System.out.println("순열:");
        DFS(0, maxDepth, L, cache, new boolean[L]);

        System.out.println("조합:");
        DFSCombo(1, 0, maxDepth, L, cache);
    }

    public static void DFSCombo(int start, int depth, int maxDepth, int L, int[] cache) { // 방문을 고려하지 않고 n을 탐색할 때 n + 1부터 탐색 시작
        if (depth == maxDepth) {
            System.out.print("(");
            for (int i = 0; i < maxDepth - 1; i++) {
                System.out.print(cache[i] + ", ");
            }
            System.out.println(cache[maxDepth - 1] + ")");
            return;
        }

        for (int i = start; i <= L; i++) {
            cache[depth] = i;
            DFSCombo(i + 1, depth + 1, maxDepth, L, cache);
        }
    }

    public static void DFS(int depth, int maxDepth, int L, int[] cache, boolean[] visit) {
        if (depth == maxDepth) {
            System.out.print("(");
            for (int i = 0; i < maxDepth - 1; i++) {
                System.out.print(cache[i] + ", ");
            }
            System.out.println(cache[maxDepth - 1] + ")");
            return;
        }

        for (int i = 1; i <= L; i++) {
            if (visit[i - 1]) continue;
            visit[i - 1] = true;
            cache[depth] = i;
            DFS(depth + 1, maxDepth, L, cache, visit);
            visit[i - 1] = false;
        }
    }

}
