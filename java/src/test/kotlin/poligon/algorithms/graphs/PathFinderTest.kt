package poligon.algorithms.graphs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PathFinderTest {

    @Test
    fun shouldFindSinglePath() {
        val connections = """
            krk waw
            waw gda
            waw szy
        """.trimIndent()

        val sg = SymbolGraph.load(connections, " ")
        val krk_idx = sg.index("krk")
        val waw_idx = sg.index("waw")
        val gda_idx = sg.index("gda")
        val szy_idx = sg.index("szy")

        val finder = PathFinder(sg.graph(), krk_idx)

        assertTrue(finder.hasPathTo(waw_idx))
        assertTrue(finder.hasPathTo(gda_idx))
        assertTrue(finder.hasPathTo(szy_idx))

        assertEquals(listOf(krk_idx, waw_idx), finder.pathTo(waw_idx))
        assertEquals(listOf(krk_idx, waw_idx, szy_idx), finder.pathTo(szy_idx))
    }
}