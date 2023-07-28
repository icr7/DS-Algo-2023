package com.dsAlgo2023.Algoritm.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class RatInMaze {
    public static void main(String[] args) {
        int[][] maze =
                {{1, 1, 1, 1},
                 {1, 1, 0, 1},
                 {1, 1, 0, 1},
                 {0, 1, 1, 1}};
        System.out.println(findPaths(maze));
    }

    private static ArrayList<String> findPaths(int[][] maze) {
        int [][] sol = new int[maze.length][maze.length];
        ArrayList<String>possiblePaths= new ArrayList<>();
        findPaths(maze,0,0,sol,new StringBuilder(),"",possiblePaths);
        return possiblePaths;
    }

    private static void findPaths(int[][] maze, int x, int y, int[][]sol, StringBuilder path, String direction, List<String>possiblePaths){

        if(isSafe(maze, x, y, sol)){
            sol[x][y]=1;
            path.append(direction);
            // Adding possiblePaths into possiblePaths
            if(x== maze.length-1 && y == maze.length-1 && maze[x][y]==1){
                possiblePaths.add(path.toString());
            }
            //UP
            findPaths(maze, x-1, y, sol, path, "U", possiblePaths);
            //DOWN
            findPaths(maze, x+1, y, sol, path, "D", possiblePaths);
            //LEFT
            findPaths(maze, x, y-1, sol, path, "L", possiblePaths);
            //RIGHT
            findPaths(maze, x, y+1, sol, path, "R", possiblePaths);
            //backtrack
            sol[x][y]=0;
            if(!path.isEmpty())
                path.deleteCharAt(path.length()-1);
        }
    }

    private static boolean isSafe(int[][] maze, int x, int y, int [][]sol){

        if(x<0 || y<0 || x>(maze.length-1)|| y>(maze.length-1)) return false;

        if(sol[x][y]==maze[x][y]) return false;

        return maze[x][y] != 0;
    }
}

