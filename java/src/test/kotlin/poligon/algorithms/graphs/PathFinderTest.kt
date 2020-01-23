package poligon.algorithms.graphs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PathFinderTest {

    private val connections = """
            krk waw
            waw gda
            waw szy
        """.trimIndent()

    private val sg = SymbolGraph.load(connections, " ")

    private val krkIdx = sg.index("krk")
    private val wawIdx = sg.index("waw")
    private val gdaIdx = sg.index("gda")
    private val szyIdx = sg.index("szy")

    @Test
    fun shouldFindPathUsingRecursiveDFS() {
        val finder = PathFinder.deepSearch(sg.graph(), krkIdx)

        assertTrue(finder.hasPathTo(wawIdx))
        assertTrue(finder.hasPathTo(gdaIdx))
        assertTrue(finder.hasPathTo(szyIdx))

        assertEquals(listOf(krkIdx, wawIdx), finder.pathTo(wawIdx))
        assertEquals(listOf(krkIdx, wawIdx, szyIdx), finder.pathTo(szyIdx))
    }
}