package com.dsAlgo2023.Algoritm.BackTracking;

import java.util.ArrayList;

public class RatInMaze {
    public static void main(String[] args) {
        int[][] maze =
                {{1, 1, 1, 1},
                 {1, 1, 0, 1},
                 {1, 1, 0, 1},
                 {0, 1, 1, 1}};
        System.out.println(findPaths(maze));
    }

    static ArrayList<String>possiblePaths= new ArrayList<>();
    static int [][] sol;
    private static ArrayList<String> findPaths(int[][] maze) {
        sol = new int[maze.length][maze.length];
        findPaths(maze,0,0,new StringBuilder(),"");
        return possiblePaths;
    }

    private static void findPaths(int[][] maze, int x, int y, StringBuilder path, String direction){

        if(isSafe(maze, x, y)){
            sol[x][y]=1;
            path.append(direction);
            // Adding path into possiblePaths
            if(x== maze.length-1 && y == maze.length-1 && maze[x][y]==1){
                possiblePaths.add(path.toString());
            }
            //UP
            findPaths(maze, x-1, y, path, "U");
            //DOWN
            findPaths(maze, x+1, y, path, "D");
            //LEFT
            findPaths(maze, x, y-1, path, "L");
            //RIGHT
            findPaths(maze, x, y+1, path, "R");
            //backtrack
            sol[x][y]=0;
            if(!path.isEmpty())
                path.deleteCharAt(path.length()-1);
        }
    }

    private static boolean isSafe(int[][] maze, int x, int y){

        if(x<0 || y<0 || x>(maze.length-1)|| y>(maze.length-1)) return false;

        if(sol[x][y]==maze[x][y]) return false;

        return maze[x][y] != 0;
    }
}

