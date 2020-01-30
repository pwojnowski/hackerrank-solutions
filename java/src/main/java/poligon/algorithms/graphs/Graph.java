package poligon.algorithms.graphs;

public interface Graph {
    int vertices();

    int edges();

    // Returns vertices adjacent to given
    Iterable<Integer> adj(int v);

    // Add edge(s) between v and w
    void addEdge(int v, int w);
}
