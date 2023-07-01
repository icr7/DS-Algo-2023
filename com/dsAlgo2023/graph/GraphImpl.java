package com.dsAlgo2023.graph;

import java.util.*;

public class GraphImpl {
    public static void main(String[] args) {
        Graph myGraph = new Graph();
        myGraph.addEdge(0,1);
        myGraph.addEdge(1,2);
        myGraph.addEdge(1,4);
        myGraph.addEdge(2,3);
        myGraph.addEdge(2,4);
        myGraph.addEdge(3,4);
        myGraph.addEdge(3,5);
        myGraph.addEdge(4,6);
        myGraph.addEdge(4,0);

        myGraph.printGraph();
        System.out.print("BFS: ");

        myGraph.bfs(0);

        System.out.print("\nDFS: ");

        myGraph.dfs(0);

        Scanner sc = new Scanner(System.in);
        System.out.println("\nsource: ");
        int source=sc.nextInt();
        System.out.println("destination: ");
        int destination=sc.nextInt();

        List<List<Integer>>paths=myGraph.getPaths(source,destination);
        System.out.println("paths from source : "+source+" to destination : "+destination+" --> there are "+paths.size()+" ways i.e : "+paths);
    }
}
class Graph{
    private final Map<Integer,List<Integer>> adjacencyList;
    /*if we put final in adjacencyList that's mean
    adjacencyList cannot be reassigned to another object,
    but we can still modify the content of the adjacencyList map
     by adding or removing vertices and edges
     */

    public Graph(){
        adjacencyList=new HashMap<>();
    }

    public void addEdge(int source, int destination){
        if(!adjacencyList.containsKey(source)){
            addVertex(source);
        }
        if(!adjacencyList.containsKey(destination)){
            addVertex(destination);
        }
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }
    private void addVertex(int vertex){
        adjacencyList.put(vertex, new ArrayList<>());
    }

    public void printGraph(){
        for(Map.Entry<Integer,List<Integer>> entry : adjacencyList.entrySet()){
            int vertex=entry.getKey();
            System.out.println(vertex+" : "+entry.getValue());
        }
    }

    public void bfs(int currentVertex){
        Queue<Integer>queue = new LinkedList<>();
        Set<Integer>visited = new HashSet<>();
        queue.add(currentVertex);
        visited.add(currentVertex);

        while(!queue.isEmpty()){
            currentVertex= queue.poll();
            System.out.print(currentVertex + ", ");
            List<Integer>neighbours=adjacencyList.get(currentVertex);
            for (int neighbour :neighbours){
                if(!visited.contains(neighbour)){
                    queue.add(neighbour);
                    visited.add(neighbour);
                }
            }
        }
    }

    public void dfs(int currentVertex){
        Set<Integer>visited= new HashSet<>();
        dfs(currentVertex,visited);
    }

    private void dfs(int currentVertex, Set<Integer> visited){
        visited.add(currentVertex);
        System.out.print(currentVertex+", ");
        List<Integer>neighbours = adjacencyList.get(currentVertex);

        for (int neighbour : neighbours){
            if(!visited.contains(neighbour)){
                dfs(neighbour,visited);
            }
        }
    }

    public List<List<Integer>> getPaths(int source, int destination){
        List<List<Integer>>paths=new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        getPaths(source, destination, visited,  paths , new ArrayList<>());
        return paths;
    }

    private void getPaths(int currentVertex, int destination, Set<Integer> visited, List<List<Integer>>paths, List<Integer>path){

        if(currentVertex==destination){
            path.add(currentVertex);
            paths.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }

        if(path.contains(currentVertex)){
            return;
        }

        List<Integer>neighbours=adjacencyList.get(currentVertex);

        path.add(currentVertex);
        for(int neighbour: neighbours){
                getPaths(neighbour, destination, visited, paths, path);
        }
        path.remove(path.size()-1);
    }
}
