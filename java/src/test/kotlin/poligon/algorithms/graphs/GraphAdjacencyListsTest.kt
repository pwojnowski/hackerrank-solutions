package poligon.algorithms.graphs

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class GraphAdjacencyListsTest {

    private val emptyGraph = GraphAdjacencyLists.createAdjList(0)
    private val only42Vertices = GraphAdjacencyLists.createAdjList(42)
    private val graphWithAnomalies = GraphAdjacencyLists.createAdjList(3)
        .apply {
            addEdge(0, 0) // adjacency list allows self loops
            addEdge(0, 1)
            addEdge(0, 2)
            addEdge(1, 2)
            addEdge(1, 2) // adjacency list allows parallel edges
        }

    @Test
    fun shouldReturnNumberOfVertices() {
        assertEquals(emptyGraph.vertices(), 0)
        assertEquals(only42Vertices.vertices(), 42)
        assertEquals(graphWithAnomalies.vertices(), 3)
    }

    @Test
    fun shouldReturnNumberOfEdges() {
        assertEquals(emptyGraph.edges(), 0)
        assertEquals(only42Vertices.edges(), 0)
        assertEquals(graphWithAnomalies.edges(), 5)
    }

    @Test
    fun shouldReturnEdgesAdjacentToVertex() {
        assertEquals(listOf(0, 1, 2), graphWithAnomalies.adj(0))
        assertEquals(listOf(0, 2, 2), graphWithAnomalies.adj(1))
        assertEquals(listOf(0, 1, 1), graphWithAnomalies.adj(2))
    }

    @Test
    fun shouldLoadGraphFromInputStream() {
        val ins = """
    |3
    |5
    |0 0
    |0 1
    |0 2
    |1 2
    |1 2
    |
""".trimMargin().byteInputStream()

        val g = GraphAdjacencyLists.createAdjList(ins)

        assertEquals(graphWithAnomalies, g)
    }

    @Test
    fun shouldReturnGraphAsString() {
        listOf(emptyGraph, only42Vertices, graphWithAnomalies).forEach { graph ->
            assertEquals(graph, GraphAdjacencyLists.createAdjList(graph.toString().byteInputStream()))
        }
    }

}