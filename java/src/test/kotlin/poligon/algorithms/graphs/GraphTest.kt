package poligon.algorithms.graphs

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class GraphTest {

    private val emptyGraph = Graph.createAdjList(0)
    private val only42Vertices = Graph.createAdjList(42)
    private val graphWithAnomalies = graphWithAnomalies()
    private val anomaliesAsString = """
    |3
    |5
    |0 0
    |0 1
    |0 2
    |1 2
    |1 2
    |
""".trimMargin()

    @Test
    fun shouldReturnNumberOfVertices() {
        assertEquals(emptyGraph.vertices(), 0)
        assertEquals(only42Vertices.vertices(), 42)
    }

    @Test
    fun shouldReturnEdgesAdjacentToVertex() {
        assertEquals(listOf(0, 1, 2), graphWithAnomalies.adj(0))
        assertEquals(listOf(2, 2), graphWithAnomalies.adj(1))
        assertEquals(emptyList<Int>(), graphWithAnomalies.adj(2))
    }

    @Test
    fun shouldReturnGraphAsString() {
        // 0 vertices, 0 edges
        assertEquals("0\n0\n", emptyGraph.toString())
        assertEquals("42\n0\n", only42Vertices.toString())
        assertEquals(anomaliesAsString, graphWithAnomalies.toString())
    }

    private fun graphWithAnomalies(): Graph {
        return Graph.createAdjList(3)
            .apply {
                addEdge(0, 0) // adjacency list allows self loops
                addEdge(0, 1)
                addEdge(0, 2)
                addEdge(1, 2)
                addEdge(1, 2) // adjacency list allows parallel edges
            }
    }

}