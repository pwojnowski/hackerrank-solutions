package poligon.algorithms.graphs;

import java.io.InputStream;
import java.util.*;

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

    public static Graph createAdjList(InputStream ins) {
        try (Scanner scanner = new Scanner(ins)) {
            Graph g = createAdjList(scanner.nextInt());
            int e = scanner.nextInt();
            while (e-- > 0) {
                g.addEdge(scanner.nextInt(), scanner.nextInt());
            }
            return g;
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Graph graph = (Graph) o;
        return Arrays.equals(vertices, graph.vertices);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(vertices);
    }
}
