package com.dsAlgo2023.Algoritm.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class RatInMaze {
    public static void main(String[] args) {
        int maze[][] =
                {{1, 0, 0, 0},
                 {1, 1, 0, 1},
                 {1, 1, 0, 0},
                 {0, 1, 1, 1}};
        System.out.println(findPaths(maze));
    }

    private static ArrayList<String> findPaths(int[][] maze) {
        int [][] sol = new int[maze.length][maze.length];
        ArrayList<String>paths= new ArrayList<>();
        findPaths(maze,0,0,sol,new StringBuilder(),null,paths);
        return paths;
    }

    private static boolean findPaths(int[][] maze, int x, int y, int[][]sol, StringBuilder path, String direction, List<String>paths){
        if(x== maze.length-1 && y == maze.length-1 && maze[x][y]==1){
            System.out.println("* reached "+x+","+y);
            sol[x][y]=1;
            path.append(direction);
            System.out.println("* reached path: "+path);
            paths.add(path.toString());
            return true;
        }
        if(isSafe(maze, x, y, direction, path, sol)){
            sol[x][y]=1;
            //UP
            if(findPaths(maze, x-1, y, sol, path, "U", paths)){
                return true;
            }
            //DOWN
            if(findPaths(maze, x+1, y, sol, path, "D", paths)){
                return true;
            }
            //LEFT
            if(findPaths(maze, x, y-1, sol, path, "L", paths)){
                return true;
            }
            //RIGHT
            if(findPaths(maze, x, y+1, sol, path, "R", paths)){
                return true;
            }
            //backtrack
            sol[x][y]=0;
            System.out.println("#Back tracking \n#Deleting: "+ path.charAt(path.length()-1));
            path.deleteCharAt(path.length()-1);
        }
        return false;
    }

    private static boolean isSafe(int[][] maze, int x, int y, String direction, StringBuilder path, int [][]sol){

        if(x<0 || y<0 || x>(maze.length-1)|| y>(maze.length-1)) return false;

        if(sol[x][y]==maze[x][y]) return false;

        if(maze[x][y]==0) return false;
        System.out.println(direction);
        System.out.println(x+","+y);
        if(direction!=null){
            path.append(direction);
            System.out.println("path: "+path);
        }
        return true;
    }
}

