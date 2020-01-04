package poligon.algorithms.graphs;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Graph {

    private final Collection<Integer>[] vertices;

    private Graph(Collection<Integer>[] vertices) {
        this.vertices = vertices;
    }

    public static Graph createAdjList(int v) {
        @SuppressWarnings("unchecked")
        Graph g = new Graph(new List[v]);
        for (int i = 0; i < g.vertices.length; ++i) {
            g.vertices[i] = new LinkedList<>();
        }
        return g;
    }

    public int vertices() {
        return vertices.length;
    }

    public int edges() {
        return Arrays.stream(vertices).mapToInt(Collection::size).sum();
    }

    // Returns vertices adjacent to given
    public Iterable<Integer> adj(int v) {
        return vertices[v];
    }

    // Add edge(s) between v and w
    public void addEdge(int v, int w) {
        vertices[v].add(w);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(vertices() + System.lineSeparator() + edges() + System.lineSeparator());
        for (int v = 0; v < vertices.length; ++v) {
            for (Integer w : adj(v)) {
                sb.append(v).append(" ").append(w).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

}
