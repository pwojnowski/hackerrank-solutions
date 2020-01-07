package poligon.algorithms.graphs;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SymbolGraph {

    private final String[] indexedNames;
    private final Map<String, Integer> symbolsMap;
    private final Graph graph;

    public SymbolGraph(Map<String, Integer> symbolsMap, Graph graph) {
        this.symbolsMap = symbolsMap;
        this.graph = graph;
        indexedNames = indexNames(symbolsMap);
    }

    private static String[] indexNames(Map<String, Integer> symbolsMap) {
        String[] index = new String[symbolsMap.size()];
        symbolsMap.forEach((name, i) -> index[i] = name);
        return index;
    }

    public static SymbolGraph load(InputStream is, String separator) {
        Map<String, Integer> symbolsMap = createSymbolsMap(is, separator);
        Graph graph = createGraph(is, separator, symbolsMap);
        return new SymbolGraph(symbolsMap, graph);
    }

    private static Map<String, Integer> createSymbolsMap(InputStream is, String separator) {
        Map<String, Integer> symbolsMap = new HashMap<>();
        Scanner scanner = createScanner(is, separator);
        while (scanner.hasNextLine()) {
            String[] parts = scanner.nextLine().split(separator);
            addSymbol(symbolsMap, parts[0]);
            addSymbol(symbolsMap, parts[1]);
        }
        return symbolsMap;
    }

    private static void addSymbol(Map<String, Integer> symbolsMap, String name) {
        if (!symbolsMap.containsKey(name)) {
            System.out.printf("Adding %s -> %d%n", name, symbolsMap.size());
            symbolsMap.put(name, symbolsMap.size());
        }
    }

    private static Graph createGraph(InputStream is, String separator, Map<String, Integer> symbolsMap) {
        Graph graph = Graph.createAdjList(symbolsMap.size());
        Scanner scanner = createScanner(is, separator);
        while (scanner.hasNext()) {
            graph.addEdge(symbolsMap.get(scanner.next()), symbolsMap.get(scanner.next()));
        }
        return graph;
    }

    private static Scanner createScanner(InputStream is, String separator) {
        return new Scanner(is).useDelimiter(separator);
    }

    // Returns `true` when graph contains given key.
    public boolean contains(String key) {
        return symbolsMap.containsKey(key);
    }

    // Returns index for given key.
    public int index(String key) {
        return symbolsMap.get(key);
    }

    // Returns vertex key name for the given index.
    public String name(int v) {
        return indexedNames[v];
    }

    // Returns underlying graph object.
    public Graph graph() {
        return graph;
    }

}
