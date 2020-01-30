package poligon.algorithms.graphs;

import java.io.InputStream;
import java.util.*;

public class GraphAdjacencyLists implements Graph {

    private final Collection<Integer>[] vertices;
    private int edgeCount;

    private GraphAdjacencyLists(Collection<Integer>[] vertices) {
        this.vertices = vertices;
    }

    public static Graph create(int v) {
        @SuppressWarnings("unchecked")
        GraphAdjacencyLists g = new GraphAdjacencyLists(new List[v]);
        for (int i = 0; i < g.vertices.length; ++i) {
            g.vertices[i] = new LinkedList<>();
        }
        return g;
    }

    public static Graph create(InputStream ins) {
        try (Scanner scanner = new Scanner(ins)) {
            Graph g = create(scanner.nextInt());
            int e = scanner.nextInt();
            while (e-- > 0) {
                g.addEdge(scanner.nextInt(), scanner.nextInt());
            }
            return g;
        }
    }

    @Override
    public int vertices() {
        return vertices.length;
    }

    @Override
    public int edges() {
        return edgeCount;
    }

    // Returns vertices adjacent to given
    @Override
    public Iterable<Integer> adj(int v) {
        return vertices[v];
    }

    // Add edge(s) between v and w
    @Override
    public void addEdge(int v, int w) {
        vertices[v].add(w);
        if (v != w) { // add self-loop only once
            vertices[w].add(v);
        }
        ++edgeCount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(vertices() + System.lineSeparator() + edges() + System.lineSeparator());
        for (int v = 0; v < vertices.length; ++v) {
            for (int w : adj(v)) {
                if (v <= w)
                    sb.append(v).append(" ").append(w).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphAdjacencyLists graph = (GraphAdjacencyLists) o;
        return Arrays.equals(vertices, graph.vertices);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(vertices);
    }
}
