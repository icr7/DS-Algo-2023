package com.dsAlgo2023.Algoritm.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class RatInMaze {
    public static void main(String[] args) {
        int[][] maze =
                {{1, 0, 0, 0},
                 {1, 1, 0, 1},
                 {1, 1, 0, 0},
                 {0, 1, 1, 1}};
        System.out.println(findPaths(maze));
    }

    private static ArrayList<String> findPaths(int[][] maze) {
        int [][] sol = new int[maze.length][maze.length];
        ArrayList<String>paths= new ArrayList<>();
        findPaths(maze,0,0,sol,new StringBuilder(),"",paths);
        return paths;
    }

    private static void findPaths(int[][] maze, int x, int y, int[][]sol, StringBuilder path, String direction, List<String>paths){
        if(x== maze.length-1 && y == maze.length-1 && maze[x][y]==1){
            sol[x][y]=1;
            path.append(direction);
            paths.add(path.toString());
        }
        if(isSafe(maze, x, y, sol)){
            sol[x][y]=1;
            path.append(direction);
            //UP
            findPaths(maze, x-1, y, sol, path, "U", paths);
            //DOWN
            findPaths(maze, x+1, y, sol, path, "D", paths);
            //LEFT
            findPaths(maze, x, y-1, sol, path, "L", paths);
            //RIGHT
            findPaths(maze, x, y+1, sol, path, "R", paths);
            //backtrack
            sol[x][y]=0;
            path.deleteCharAt(path.length()-1);
        }
    }

    private static boolean isSafe(int[][] maze, int x, int y, int [][]sol){

        if(x<0 || y<0 || x>(maze.length-1)|| y>(maze.length-1)) return false;

        if(sol[x][y]==maze[x][y]) return false;

        return maze[x][y] != 0;
    }
}

