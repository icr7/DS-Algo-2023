package com.dsAlgo2023.graph;

import java.util.*;

public class GraphImpl {
    public static void main(String[] args) {
        Graph myGraph = new Graph();
        myGraph.addEdge(0,1);
        myGraph.addEdge(1,2);
        myGraph.addEdge(2,3);
        myGraph.addEdge(3,1);
        myGraph.printGraph();

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

}
