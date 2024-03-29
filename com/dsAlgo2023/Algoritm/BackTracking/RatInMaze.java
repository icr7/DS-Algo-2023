package com.dsAlgo2023.Algoritm.BackTracking;

import java.util.ArrayList;

public class RatInMaze {
    public static void main(String[] args) {
        int[][] maze = {
                {1, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 0, 1},
                {0, 1, 1, 1}};
        System.out.println(findPaths(maze));
    }

    static ArrayList<String> possiblePaths = new ArrayList<>();
    static int[][] sol;
    static int[][] maze;
    static StringBuilder path;

    private static ArrayList<String> findPaths(int[][] m) {
        sol = new int[m.length][m.length];
        maze = m;
        path=new StringBuilder();
        findPaths(0, 0, "");
        return possiblePaths;
    }

    private static void findPaths(int x, int y, String direction) {

        if (isSafe(x, y)) {
            sol[x][y] = 1;
            path.append(direction);
            // Adding path into possiblePaths
            if (x == maze.length - 1 && y == maze[x].length - 1) {
                possiblePaths.add(path.toString());
            }
            //UP
            findPaths(x - 1, y, "U");
            //DOWN
            findPaths(x + 1, y, "D");
            //LEFT
            findPaths(x, y - 1, "L");
            //RIGHT
            findPaths(x, y + 1, "R");
            //backtrack
            sol[x][y] = 0;
            if (!(path.length()==0)) path.deleteCharAt(path.length() - 1);
        }
    }

    private static boolean isSafe(int x, int y) {

        if (x < 0 || y < 0 || x > (maze.length - 1) || y > (maze.length - 1)) return false;

        if (sol[x][y] == maze[x][y]) return false;

        return maze[x][y] != 0;
    }
}

