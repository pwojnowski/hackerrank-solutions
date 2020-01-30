package poligon.algorithms.graphs

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ConnectedComponentsTest {

    private val graphWith3Components = GraphAdjacencyLists.createAdjList(11)
        .apply {
            addEdge(0, 1)
            addEdge(0, 2)
            addEdge(1, 2)
            addEdge(2, 3)
            addEdge(4, 5)
            addEdge(5, 6)
            addEdge(7, 8)
            addEdge(8, 9)
            addEdge(8, 10)
            addEdge(10, 9)
        }

    @Test
    fun shouldReturnEdgesAdjacentToVertex() {
        val cc = ConnectedComponents(graphWith3Components)

        assertEquals(3, cc.count())
        assertTrue(cc.connected(0, 1))
        assertTrue(cc.connected(0, 2))
        assertTrue(cc.connected(1, 2))
        assertTrue(cc.connected(2, 3))
        assertEquals(cc.component(0), cc.component(3))

        assertTrue(cc.connected(4, 5))
        assertTrue(cc.connected(5, 6))
        assertEquals(cc.component(4), cc.component(6))
        assertFalse(cc.connected(4, 3))

        assertTrue(cc.connected(7, 8))
        assertTrue(cc.connected(8, 9))
        assertTrue(cc.connected(7, 10))
        assertEquals(cc.component(7), cc.component(10))
        assertFalse(cc.connected(2, 10))
        assertFalse(cc.connected(6, 8))
    }
}