package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        for (int z = 0; z < c; z++) {
            int M = sc.nextInt();
            int N = sc.nextInt();
            int[][] arr = new int[M][N];
            int count = sc.nextInt();
            for (int i = 0; i < count; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                arr[x][y] = 1;
            }
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if(arr[i][j] == 1) {
                        int area = bfs(arr, i,j);
                        list.add(area);
                    }
                }
            }

            System.out.println(list.size());
        }

    }

    public static int bfs(int[][] arr, int x, int y) {
        int M = arr.length;
        int N = arr[0].length;
        if( x == -1 || y == -1 || x == M || y == N) return 0;
        if(arr[x][y] == 0 || arr[x][y] == 2) return 0;
        arr[x][y] = 2;
        return 1 + bfs(arr, x+1,y) + bfs(arr, x-1,y) + bfs(arr, x,y+1) + bfs(arr, x,y-1);
    }
}
