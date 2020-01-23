package poligon.algorithms.graphs;

public class ConnectedComponents {

    private final Graph graph;
    private int count;
    private final boolean[] marked;
    private final int[] id;

    public ConnectedComponents(Graph graph) {
        this.graph = graph;
        this.marked = new boolean[graph.vertices()];
        this.id = new int[graph.vertices()];

        for (int v = 0; v < graph.vertices(); ++v) {
            if (!marked[v]) {
                dfs(v);
                ++count;
            }
        }
    }

    private void dfs(int v) {
        marked[v] = true;
        id[v] = count;
        for (int adj : graph.adj(v)) {
            if (!marked[adj]) {
                dfs(adj);
            }
        }
    }

    /**
     * Returns true if given vertices are connected (are in the same connected component).
     */
    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    /**
     * Returns number of connected components.
     */
    public int count() {
        return count;
    }

    /**
     * Returns connected component of given vertex.
     */
    public int component(int v) {
        return id[v];
    }
}
