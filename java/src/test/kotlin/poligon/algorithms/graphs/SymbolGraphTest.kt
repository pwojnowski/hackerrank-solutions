package poligon.algorithms.graphs

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SymbolGraphTest {

    val flights = """
        krk waw
        krk gda
        krk psg
        psg jfk
        psg dfw
        dfw jfk
        dfw lax
        jfk lax
        waw psg
    """.trimIndent()

    @Test
    fun shouldLoadGraphFromInputStream() {
        val sg = SymbolGraph.load(flights, " ")

        assertTrue(sg.contains("krk"))
        assertTrue(sg.contains("waw"))
        assertTrue(sg.contains("gda"))
        assertTrue(sg.contains("psg"))
        assertTrue(sg.contains("jfk"))
        assertTrue(sg.contains("dfw"))
        assertTrue(sg.contains("lax"))

        assertEquals(0, sg.index("krk"))
        assertEquals(1, sg.index("waw"))
        assertEquals(2, sg.index("gda"))
        assertEquals(3, sg.index("psg"))
        assertEquals(4, sg.index("jfk"))
        assertEquals(5, sg.index("dfw"))
        assertEquals(6, sg.index("lax"))

        assertEquals("krk", sg.name(0))
        assertEquals("waw", sg.name(1))
        assertEquals("gda", sg.name(2))
        assertEquals("psg", sg.name(3))
        assertEquals("jfk", sg.name(4))
        assertEquals("dfw", sg.name(5))
        assertEquals("lax", sg.name(6))

        val expectedGraph = GraphAdjacencyLists.create(7).apply {
            addEdge(sg.index("krk"), sg.index("waw"))
            addEdge(sg.index("krk"), sg.index("gda"))
            addEdge(sg.index("krk"), sg.index("psg"))
            addEdge(sg.index("psg"), sg.index("jfk"))
            addEdge(sg.index("psg"), sg.index("dfw"))
            addEdge(sg.index("dfw"), sg.index("jfk"))
            addEdge(sg.index("dfw"), sg.index("lax"))
            addEdge(sg.index("jfk"), sg.index("lax"))
            addEdge(sg.index("waw"), sg.index("psg"))
        }
        assertEquals(expectedGraph, sg.graph())
    }

}