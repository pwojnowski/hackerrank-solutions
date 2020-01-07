package poligon.algorithms.graphs

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class GraphTest {

    private val emptyGraph = Graph.createAdjList(0)
    private val only42Vertices = Graph.createAdjList(42)
    private val graphWithAnomalies = Graph.createAdjList(3)
        .apply {
            addEdge(0, 0) // adjacency list allows self loops
            addEdge(0, 1)
            addEdge(0, 2)
            addEdge(1, 2)
            addEdge(1, 2) // adjacency list allows parallel edges
        }
    private val anomaliesAsString = """
    |3
    |9
    |0 0
    |0 1
    |0 2
    |1 0
    |1 2
    |1 2
    |2 0
    |2 1
    |2 1
    |
""".trimMargin()

    @Test
    fun shouldReturnNumberOfVertices() {
        assertEquals(emptyGraph.vertices(), 0)
        assertEquals(only42Vertices.vertices(), 42)
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

        val g = Graph.createAdjList(ins)

        assertEquals(graphWithAnomalies, g)
    }

    @Test
    @Disabled
    fun shouldReturnGraphAsString() {
        // 0 vertices, 0 edges
        assertEquals("0\n0\n", emptyGraph.toString())
        assertEquals("42\n0\n", only42Vertices.toString())
        assertEquals(anomaliesAsString, graphWithAnomalies.toString())
    }

}