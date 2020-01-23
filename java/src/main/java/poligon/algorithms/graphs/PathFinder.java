package poligon.algorithms.graphs;

import java.util.*;

public class PathFinder {

    private final Graph graph;
    private final boolean[] marked;
    private final int[] edgeTo;
    private final int startVertex;

    private PathFinder(Graph graph, int startVertex) {
        this.graph = graph;
        this.startVertex = startVertex;
        marked = new boolean[graph.vertices()];
        edgeTo = new int[graph.vertices()];
    }

    /**
     * Create PathFinder with paths found using DFS algorithm.
     */
    public static PathFinder deepSearch(Graph graph, int startVertex) {
        PathFinder finder = new PathFinder(graph, startVertex);
        finder.recursiveDfs(startVertex);
        return finder;
    }

    public static PathFinder bfs(Graph graph, int startVertex) {
        PathFinder finder = new PathFinder(graph, startVertex);
        finder.bfs();
        return finder;
    }

    private void bfs() {
        Queue<Integer> vertices = new LinkedList<>();
        vertices.add(startVertex);

        while (!vertices.isEmpty()) {
            int v = vertices.remove();
            if (!marked[v]) {
                marked[v] = true;
                for (int adj : graph.adj(v)) {
                    if (!marked[adj]) {
                        edgeTo[adj] = v;
                        vertices.add(adj);
                    }
                }
            }
        }
    }

    private void recursiveDfs(int v) {
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                recursiveDfs(w);
            }
        }
    }

    public boolean hasPathTo(int target) {
        return marked[target];
    }

    public Iterable<Integer> pathTo(int v) {
        LinkedList<Integer> reversedPath = new LinkedList<>();
        if (hasPathTo(v)) {
            reversedPath.addFirst(v);
            while (v != startVertex) {
                reversedPath.addFirst(edgeTo[v]);
                v = edgeTo[v];
            }
        }
        return reversedPath;
    }
}
